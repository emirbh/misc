package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.DeliveryDateParameters;
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
@RosettaDataRule("DeliveryDateParametersDeliveryDateParametersChoice")
@ImplementedBy(DeliveryDateParametersDeliveryDateParametersChoice.Default.class)
public interface DeliveryDateParametersDeliveryDateParametersChoice extends Validator<DeliveryDateParameters> {
	
	String NAME = "DeliveryDateParametersDeliveryDateParametersChoice";
	String DEFINITION = "optional choice deliveryNearby, deliveryDate";
	
	class Default implements DeliveryDateParametersDeliveryDateParametersChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryDateParameters deliveryDateParameters) {
			ComparisonResult result = executeDataRule(deliveryDateParameters);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliveryDateParameters", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliveryDateParameters", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(DeliveryDateParameters deliveryDateParameters) {
			try {
				return choice(MapperS.of(deliveryDateParameters), Arrays.asList("deliveryNearby", "deliveryDate"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DeliveryDateParametersDeliveryDateParametersChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeliveryDateParameters deliveryDateParameters) {
			return Collections.emptyList();
		}
	}
}
