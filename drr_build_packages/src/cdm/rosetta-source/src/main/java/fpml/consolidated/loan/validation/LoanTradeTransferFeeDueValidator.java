package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.LoanTradeReference;
import fpml.consolidated.loan.LoanTradeTransferFeeDue;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanTradeTransferFeeDueValidator implements Validator<LoanTradeTransferFeeDue> {

	private List<ComparisonResult> getComparisonResults(LoanTradeTransferFeeDue o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : o.getEventIdentifier().size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (ParentEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("previousEventIdentifier", (BusinessEventIdentifier) o.getPreviousEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderPartyReference", (PartyReference) o.getLenderPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashPayable", (CashPayable) o.getCashPayable() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanTradeReference", (LoanTradeReference) o.getLoanTradeReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("amount", (NonNegativeMoney) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("dueDate", (ZonedDateTime) o.getDueDate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradeTransferFeeDue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradeTransferFeeDue", ValidationResult.ValidationType.CARDINALITY, "LoanTradeTransferFeeDue", path, "", res.getError());
				}
				return success("LoanTradeTransferFeeDue", ValidationResult.ValidationType.CARDINALITY, "LoanTradeTransferFeeDue", path, "");
			})
			.collect(toList());
	}

}
