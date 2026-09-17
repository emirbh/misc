package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanContract;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanContractChoice")
@ImplementedBy(LoanContractChoice.Default.class)
public interface LoanContractChoice extends Validator<LoanContract> {
	
	String NAME = "LoanContractChoice";
	String DEFINITION = "required choice fixedRateAccrual, floatingRateAccrual, legacyFloatingRateAccrual";
	
	class Default implements LoanContractChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContract loanContract) {
			ComparisonResult result = executeDataRule(loanContract);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanContract", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanContract", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanContract loanContract) {
			try {
				return choice(MapperS.of(loanContract), Arrays.asList("fixedRateAccrual", "floatingRateAccrual", "legacyFloatingRateAccrual"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanContractChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContract loanContract) {
			return Collections.emptyList();
		}
	}
}
