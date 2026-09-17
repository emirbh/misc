package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanTradingNonAccruingFee;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanTradingNonAccruingFeeChoice1")
@ImplementedBy(LoanTradingNonAccruingFeeChoice1.Default.class)
public interface LoanTradingNonAccruingFeeChoice1 extends Validator<LoanTradingNonAccruingFee> {
	
	String NAME = "LoanTradingNonAccruingFeeChoice1";
	String DEFINITION = "required choice facilityReference, loanContractReference, letterOfCreditReference";
	
	class Default implements LoanTradingNonAccruingFeeChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingNonAccruingFee loanTradingNonAccruingFee) {
			ComparisonResult result = executeDataRule(loanTradingNonAccruingFee);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingNonAccruingFee", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingNonAccruingFee", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanTradingNonAccruingFee loanTradingNonAccruingFee) {
			try {
				return choice(MapperS.of(loanTradingNonAccruingFee), Arrays.asList("facilityReference", "loanContractReference", "letterOfCreditReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanTradingNonAccruingFeeChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingNonAccruingFee loanTradingNonAccruingFee) {
			return Collections.emptyList();
		}
	}
}
