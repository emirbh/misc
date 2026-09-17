package cdm.product.collateral.validation.datarule;

import cdm.product.collateral.DeliveryAmount;
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
@RosettaDataRule("DeliveryAmountOneOf0")
@ImplementedBy(DeliveryAmountOneOf0.Default.class)
public interface DeliveryAmountOneOf0 extends Validator<DeliveryAmount> {
	
	String NAME = "DeliveryAmountOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements DeliveryAmountOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryAmount deliveryAmount) {
			ComparisonResult result = executeDataRule(deliveryAmount);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliveryAmount", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliveryAmount", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DeliveryAmount deliveryAmount) {
			try {
				return choice(MapperS.of(deliveryAmount), Arrays.asList("standardElection", "customElection"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DeliveryAmountOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryAmount deliveryAmount) {
			return Collections.emptyList();
		}
	}
}
