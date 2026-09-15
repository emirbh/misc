package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.LoanTransferFeePaidByEnum;
import fpml.consolidated.loan.BuyerSellerAmounts;
import fpml.consolidated.loan.LoanTransferFee;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanTransferFeeChoice")
@ImplementedBy(LoanTransferFeeChoice.Default.class)
public interface LoanTransferFeeChoice extends Validator<LoanTransferFee> {
	
	String NAME = "LoanTransferFeeChoice";
	String DEFINITION = "if paidBy exists then transferFeeAmounts is absent else if transferFeeAmounts exists then paidBy is absent and totalAmount is absent else False";
	
	class Default implements LoanTransferFeeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTransferFee loanTransferFee) {
			ComparisonResult result = executeDataRule(loanTransferFee);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTransferFee", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTransferFee", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanTransferFee loanTransferFee) {
			try {
				if (exists(MapperS.of(loanTransferFee).<LoanTransferFeePaidByEnum>map("getPaidBy", _loanTransferFee -> _loanTransferFee.getPaidBy())).getOrDefault(false)) {
					return notExists(MapperS.of(loanTransferFee).<BuyerSellerAmounts>map("getTransferFeeAmounts", _loanTransferFee -> _loanTransferFee.getTransferFeeAmounts()));
				}
				if (exists(MapperS.of(loanTransferFee).<BuyerSellerAmounts>map("getTransferFeeAmounts", _loanTransferFee -> _loanTransferFee.getTransferFeeAmounts())).getOrDefault(false)) {
					return notExists(MapperS.of(loanTransferFee).<LoanTransferFeePaidByEnum>map("getPaidBy", _loanTransferFee -> _loanTransferFee.getPaidBy())).andNullSafe(notExists(MapperS.of(loanTransferFee).<NonNegativeMoney>map("getTotalAmount", _loanTransferFee -> _loanTransferFee.getTotalAmount())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanTransferFeeChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTransferFee loanTransferFee) {
			return Collections.emptyList();
		}
	}
}
