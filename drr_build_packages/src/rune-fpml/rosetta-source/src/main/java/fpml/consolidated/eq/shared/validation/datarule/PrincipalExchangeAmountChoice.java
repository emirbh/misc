package fpml.consolidated.eq.shared.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.PrincipalExchangeAmount;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PrincipalExchangeAmountChoice")
@ImplementedBy(PrincipalExchangeAmountChoice.Default.class)
public interface PrincipalExchangeAmountChoice extends Validator<PrincipalExchangeAmount> {
	
	String NAME = "PrincipalExchangeAmountChoice";
	String DEFINITION = "one-of";
	
	class Default implements PrincipalExchangeAmountChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeAmount principalExchangeAmount) {
			ComparisonResult result = executeDataRule(principalExchangeAmount);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PrincipalExchangeAmount", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PrincipalExchangeAmount", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PrincipalExchangeAmount principalExchangeAmount) {
			try {
				return choice(MapperS.of(principalExchangeAmount), Arrays.asList("amountRelativeTo", "determinationMethod", "principalAmount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PrincipalExchangeAmountChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeAmount principalExchangeAmount) {
			return Collections.emptyList();
		}
	}
}
