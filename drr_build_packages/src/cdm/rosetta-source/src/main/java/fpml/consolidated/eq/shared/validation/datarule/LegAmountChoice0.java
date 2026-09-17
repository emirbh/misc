package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.LegAmount;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LegAmountChoice0")
@ImplementedBy(LegAmountChoice0.Default.class)
public interface LegAmountChoice0 extends Validator<LegAmount> {
	
	String NAME = "LegAmountChoice0";
	String DEFINITION = "optional choice currency, determinationMethod, currencyReference";
	
	class Default implements LegAmountChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegAmount legAmount) {
			ComparisonResult result = executeDataRule(legAmount);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegAmount", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LegAmount", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LegAmount legAmount) {
			try {
				return choice(MapperS.of(legAmount), Arrays.asList("currency", "determinationMethod", "currencyReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegAmountChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegAmount legAmount) {
			return Collections.emptyList();
		}
	}
}
