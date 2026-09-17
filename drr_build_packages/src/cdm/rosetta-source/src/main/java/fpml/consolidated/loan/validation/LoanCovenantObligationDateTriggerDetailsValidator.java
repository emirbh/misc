package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DueDateAdjustment;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetails;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetailsChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationDateTriggerDetailsValidator implements Validator<LoanCovenantObligationDateTriggerDetails> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationDateTriggerDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loanCovenantObligationDateTriggerDetailsChoice", (List<? extends LoanCovenantObligationDateTriggerDetailsChoice>) o.getLoanCovenantObligationDateTriggerDetailsChoice() == null ? 0 : o.getLoanCovenantObligationDateTriggerDetailsChoice().size(), 1, 0), 
				checkCardinality("dueDateAdjustment", (DueDateAdjustment) o.getDueDateAdjustment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationDateTriggerDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationDateTriggerDetails", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationDateTriggerDetails", path, "", res.getError());
				}
				return success("LoanCovenantObligationDateTriggerDetails", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationDateTriggerDetails", path, "");
			})
			.collect(toList());
	}

}
