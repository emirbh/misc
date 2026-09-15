package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.ReturnSwapLegUnderlyer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("ReturnSwapLegUnderlyerChoice")
@ImplementedBy(ReturnSwapLegUnderlyerChoice.Default.class)
public interface ReturnSwapLegUnderlyerChoice extends Validator<ReturnSwapLegUnderlyer> {
	
	String NAME = "ReturnSwapLegUnderlyerChoice";
	String DEFINITION = "optional choice settlementAmount, settlementCurrency";
	
	class Default implements ReturnSwapLegUnderlyerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapLegUnderlyer returnSwapLegUnderlyer) {
			ComparisonResult result = executeDataRule(returnSwapLegUnderlyer);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnSwapLegUnderlyer", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnSwapLegUnderlyer", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReturnSwapLegUnderlyer returnSwapLegUnderlyer) {
			try {
				return choice(MapperS.of(returnSwapLegUnderlyer), Arrays.asList("settlementAmount", "settlementCurrency"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReturnSwapLegUnderlyerChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapLegUnderlyer returnSwapLegUnderlyer) {
			return Collections.emptyList();
		}
	}
}
