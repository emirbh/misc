package fpml.consolidated.cd.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.FeeLeg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("FeeLegChoice0")
@ImplementedBy(FeeLegChoice0.Default.class)
public interface FeeLegChoice0 extends Validator<FeeLeg> {
	
	String NAME = "FeeLegChoice0";
	String DEFINITION = "optional choice initialPayment, singlePayment";
	
	class Default implements FeeLegChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeLeg feeLeg) {
			ComparisonResult result = executeDataRule(feeLeg);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeLeg", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeLeg", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(FeeLeg feeLeg) {
			try {
				return choice(MapperS.of(feeLeg), Arrays.asList("initialPayment", "singlePayment"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FeeLegChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, FeeLeg feeLeg) {
			return Collections.emptyList();
		}
	}
}
