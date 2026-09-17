package cdm.product.collateral.validation.datarule;

import cdm.product.collateral.CollateralValuationTreatment;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("CollateralValuationTreatmentHaircutPercentageOrMarginPercentage")
@ImplementedBy(CollateralValuationTreatmentHaircutPercentageOrMarginPercentage.Default.class)
public interface CollateralValuationTreatmentHaircutPercentageOrMarginPercentage extends Validator<CollateralValuationTreatment> {
	
	String NAME = "CollateralValuationTreatmentHaircutPercentageOrMarginPercentage";
	String DEFINITION = "required choice haircutPercentage, marginPercentage";
	
	class Default implements CollateralValuationTreatmentHaircutPercentageOrMarginPercentage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuationTreatment collateralValuationTreatment) {
			ComparisonResult result = executeDataRule(collateralValuationTreatment);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuationTreatment", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuationTreatment", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CollateralValuationTreatment collateralValuationTreatment) {
			try {
				return choice(MapperS.of(collateralValuationTreatment), Arrays.asList("haircutPercentage", "marginPercentage"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralValuationTreatmentHaircutPercentageOrMarginPercentage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralValuationTreatment collateralValuationTreatment) {
			return Collections.emptyList();
		}
	}
}
