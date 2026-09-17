package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ReportingFrequencyTypeEnum;
import fpml.consolidated.loan.LoanCovenantObligationDateTriggerDetailsChoice;
import fpml.consolidated.loan.LoanCovenantObligationDueDate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationDateTriggerDetailsChoiceValidator implements Validator<LoanCovenantObligationDateTriggerDetailsChoice> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationDateTriggerDetailsChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dueDate", (LoanCovenantObligationDueDate) o.getDueDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("frequencyType", (ReportingFrequencyTypeEnum) o.getFrequencyType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationDateTriggerDetailsChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationDateTriggerDetailsChoice", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationDateTriggerDetailsChoice", path, "", res.getError());
				}
				return success("LoanCovenantObligationDateTriggerDetailsChoice", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligationDateTriggerDetailsChoice", path, "");
			})
			.collect(toList());
	}

}
