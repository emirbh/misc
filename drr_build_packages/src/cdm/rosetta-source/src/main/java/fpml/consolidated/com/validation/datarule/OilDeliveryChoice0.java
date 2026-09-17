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
@RosettaDataRule("OilDeliveryChoice0")
@ImplementedBy(OilDeliveryChoice0.Default.class)
public interface OilDeliveryChoice0 extends Validator<OilDelivery> {
	
	String NAME = "OilDeliveryChoice0";
	String DEFINITION = "optional choice absoluteTolerance, percentageTolerance";
	
	class Default implements OilDeliveryChoice0 {
	
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
				return choice(MapperS.of(oilDelivery), Arrays.asList("absoluteTolerance", "percentageTolerance"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OilDeliveryChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OilDelivery oilDelivery) {
			return Collections.emptyList();
		}
	}
}
