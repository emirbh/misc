package cdm.event.position.validation.datarule;

import cdm.event.common.Lineage;
import cdm.event.position.PortfolioState;
import cdm.event.position.Position;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("PortfolioStateInitialisation")
@ImplementedBy(PortfolioStateInitialisation.Default.class)
public interface PortfolioStateInitialisation extends Validator<PortfolioState> {
	
	String NAME = "PortfolioStateInitialisation";
	String DEFINITION = "if lineage -> portfolioStateReference is absent then positions is absent and lineage -> eventReference is absent";
	
	class Default implements PortfolioStateInitialisation {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioState portfolioState) {
			ComparisonResult result = executeDataRule(portfolioState);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioState", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioState", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PortfolioState portfolioState) {
			try {
				if (notExists(MapperS.of(portfolioState).<Lineage>map("getLineage", _portfolioState -> _portfolioState.getLineage()).<ReferenceWithMetaPortfolioState>mapC("getPortfolioStateReference", lineage -> lineage.getPortfolioStateReference())).getOrDefault(false)) {
					return notExists(MapperS.of(portfolioState).<Position>mapC("getPositions", _portfolioState -> _portfolioState.getPositions())).andNullSafe(notExists(MapperS.of(portfolioState).<Lineage>map("getLineage", _portfolioState -> _portfolioState.getLineage()).<ReferenceWithMetaWorkflowStep>mapC("getEventReference", lineage -> lineage.getEventReference())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PortfolioStateInitialisation {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PortfolioState portfolioState) {
			return Collections.emptyList();
		}
	}
}
