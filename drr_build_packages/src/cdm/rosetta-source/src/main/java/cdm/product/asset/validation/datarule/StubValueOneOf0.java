package cdm.product.asset.validation.datarule;

import cdm.product.asset.StubValue;
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
@RosettaDataRule("StubValueOneOf0")
@ImplementedBy(StubValueOneOf0.Default.class)
public interface StubValueOneOf0 extends Validator<StubValue> {
	
	String NAME = "StubValueOneOf0";
	String DEFINITION = "one-of";
	
	class Default implements StubValueOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubValue stubValue) {
			ComparisonResult result = executeDataRule(stubValue);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StubValue", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "StubValue", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(StubValue stubValue) {
			try {
				return choice(MapperS.of(stubValue), Arrays.asList("floatingRate", "stubRate", "stubAmount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StubValueOneOf0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubValue stubValue) {
			return Collections.emptyList();
		}
	}
}
