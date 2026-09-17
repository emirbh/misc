package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.ElectricityDeliveryType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ElectricityDeliveryTypeChoice")
@ImplementedBy(ElectricityDeliveryTypeChoice.Default.class)
public interface ElectricityDeliveryTypeChoice extends Validator<ElectricityDeliveryType> {
	
	String NAME = "ElectricityDeliveryTypeChoice";
	String DEFINITION = "one-of";
	
	class Default implements ElectricityDeliveryTypeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDeliveryType electricityDeliveryType) {
			ComparisonResult result = executeDataRule(electricityDeliveryType);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ElectricityDeliveryType", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ElectricityDeliveryType", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ElectricityDeliveryType electricityDeliveryType) {
			try {
				return choice(MapperS.of(electricityDeliveryType), Arrays.asList("firm", "nonFirm", "systemFirm", "unitFirm"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ElectricityDeliveryTypeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ElectricityDeliveryType electricityDeliveryType) {
			return Collections.emptyList();
		}
	}
}
