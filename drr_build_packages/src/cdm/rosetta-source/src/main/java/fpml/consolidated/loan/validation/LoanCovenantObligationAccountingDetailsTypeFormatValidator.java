package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligationAccountingDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationAccountingDetailsTypeFormatValidator implements Validator<LoanCovenantObligationAccountingDetails> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligationAccountingDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligationAccountingDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligationAccountingDetails", ValidationResult.ValidationType.TYPE_FORMAT, "LoanCovenantObligationAccountingDetails", path, "", res.getError());
				}
				return success("LoanCovenantObligationAccountingDetails", ValidationResult.ValidationType.TYPE_FORMAT, "LoanCovenantObligationAccountingDetails", path, "");
			})
			.collect(toList());
	}

}
