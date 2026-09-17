package cdm.legaldocumentation.csa.validation.datarule;

import cdm.legaldocumentation.csa.CollateralAccessBreach;
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
@RosettaDataRule("CollateralAccessBreachCabEndDateTerms")
@ImplementedBy(CollateralAccessBreachCabEndDateTerms.Default.class)
public interface CollateralAccessBreachCabEndDateTerms extends Validator<CollateralAccessBreach> {
	
	String NAME = "CollateralAccessBreachCabEndDateTerms";
	String DEFINITION = "if cabEndDateElection = True then cabEndDateTerms is absent";
	
	class Default implements CollateralAccessBreachCabEndDateTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralAccessBreach collateralAccessBreach) {
			ComparisonResult result = executeDataRule(collateralAccessBreach);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralAccessBreach", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralAccessBreach", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralAccessBreach collateralAccessBreach) {
			try {
				if (areEqual(MapperS.of(collateralAccessBreach).<Boolean>map("getCabEndDateElection", _collateralAccessBreach -> _collateralAccessBreach.getCabEndDateElection()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					return notExists(MapperS.of(collateralAccessBreach).<String>map("getCabEndDateTerms", _collateralAccessBreach -> _collateralAccessBreach.getCabEndDateTerms()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralAccessBreachCabEndDateTerms {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralAccessBreach collateralAccessBreach) {
			return Collections.emptyList();
		}
	}
}
