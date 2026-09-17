package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.BespokeCalculationTime;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("BespokeCalculationTimeAsCalculationAgentIm")
@ImplementedBy(BespokeCalculationTimeAsCalculationAgentIm.Default.class)
public interface BespokeCalculationTimeAsCalculationAgentIm extends Validator<BespokeCalculationTime> {
	
	String NAME = "BespokeCalculationTimeAsCalculationAgentIm";
	String DEFINITION = "if asCalculationAgent = True then bespokeCalculationTimeTerms is absent";
	
	class Default implements BespokeCalculationTimeAsCalculationAgentIm {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BespokeCalculationTime bespokeCalculationTime) {
			ComparisonResult result = executeDataRule(bespokeCalculationTime);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BespokeCalculationTime", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BespokeCalculationTime", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(BespokeCalculationTime bespokeCalculationTime) {
			try {
				if (areEqual(MapperS.of(bespokeCalculationTime).<Boolean>map("getAsCalculationAgent", _bespokeCalculationTime -> _bespokeCalculationTime.getAsCalculationAgent()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(bespokeCalculationTime).<String>map("getBespokeCalculationTimeTerms", _bespokeCalculationTime -> _bespokeCalculationTime.getBespokeCalculationTimeTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BespokeCalculationTimeAsCalculationAgentIm {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, BespokeCalculationTime bespokeCalculationTime) {
			return Collections.emptyList();
		}
	}
}
