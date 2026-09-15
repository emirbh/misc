package fpml.consolidated.com.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.OilDelivery;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("OilDeliveryChoice1")
@ImplementedBy(OilDeliveryChoice1.Default.class)
public interface OilDeliveryChoice1 extends Validator<OilDelivery> {
	
	String NAME = "OilDeliveryChoice1";
	String DEFINITION = "optional choice pipeline, transfer";
	
	class Default implements OilDeliveryChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilDelivery oilDelivery) {
			ComparisonResult result = executeDataRule(oilDelivery);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OilDelivery", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OilDelivery", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OilDelivery oilDelivery) {
			try {
				return choice(MapperS.of(oilDelivery), Arrays.asList("pipeline", "transfer"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OilDeliveryChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilDelivery oilDelivery) {
			return Collections.emptyList();
		}
	}
}
