package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CoalDelivery;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("CoalDeliveryChoice")
@ImplementedBy(CoalDeliveryChoice.Default.class)
public interface CoalDeliveryChoice extends Validator<CoalDelivery> {
	
	String NAME = "CoalDeliveryChoice";
	String DEFINITION = "optional choice deliveryPoint, deliveryAtSource";
	
	class Default implements CoalDeliveryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalDelivery coalDelivery) {
			ComparisonResult result = executeDataRule(coalDelivery);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalDelivery", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalDelivery", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(CoalDelivery coalDelivery) {
			try {
				return choice(MapperS.of(coalDelivery), Arrays.asList("deliveryPoint", "deliveryAtSource"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CoalDeliveryChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, CoalDelivery coalDelivery) {
			return Collections.emptyList();
		}
	}
}
