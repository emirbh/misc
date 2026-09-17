package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.QuantityMultiplier;
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
@RosettaDataRule("QuantityMultiplierOneOf0")
@ImplementedBy(QuantityMultiplierOneOf0.Default.class)
public interface QuantityMultiplierOneOf0 extends Validator<QuantityMultiplier> {
	
	String NAME = "QuantityMultiplierOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements QuantityMultiplierOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantityMultiplier quantityMultiplier) {
			ComparisonResult result = executeDataRule(quantityMultiplier);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "QuantityMultiplier", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "QuantityMultiplier", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(QuantityMultiplier quantityMultiplier) {
			try {
				return choice(MapperS.of(quantityMultiplier), Arrays.asList("fxLinkedNotionalSchedule", "multiplierValue"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements QuantityMultiplierOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuantityMultiplier quantityMultiplier) {
			return Collections.emptyList();
		}
	}
}
