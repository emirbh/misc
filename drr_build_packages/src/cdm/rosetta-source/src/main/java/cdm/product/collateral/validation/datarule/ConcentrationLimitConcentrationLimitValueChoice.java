package cdm.product.collateral.validation.datarule;

import cdm.product.collateral.ConcentrationLimit;
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
@RosettaDataRule("ConcentrationLimitConcentrationLimitValueChoice")
@ImplementedBy(ConcentrationLimitConcentrationLimitValueChoice.Default.class)
public interface ConcentrationLimitConcentrationLimitValueChoice extends Validator<ConcentrationLimit> {
	
	String NAME = "ConcentrationLimitConcentrationLimitValueChoice";
	String DEFINITION = "required choice valueLimit, percentageLimit";
	
	class Default implements ConcentrationLimitConcentrationLimitValueChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConcentrationLimit concentrationLimit) {
			ComparisonResult result = executeDataRule(concentrationLimit);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConcentrationLimit", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConcentrationLimit", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ConcentrationLimit concentrationLimit) {
			try {
				return choice(MapperS.of(concentrationLimit), Arrays.asList("valueLimit", "percentageLimit"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConcentrationLimitConcentrationLimitValueChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConcentrationLimit concentrationLimit) {
			return Collections.emptyList();
		}
	}
}
