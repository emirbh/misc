package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalActionStatementChoice0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalActionStatementChoice0TypeFormatValidator implements Validator<LoanLegalActionStatementChoice0> {

	private List<ComparisonResult> getComparisonResults(LoanLegalActionStatementChoice0 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalActionStatementChoice0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalActionStatementChoice0", ValidationResult.ValidationType.TYPE_FORMAT, "LoanLegalActionStatementChoice0", path, "", res.getError());
				}
				return success("LoanLegalActionStatementChoice0", ValidationResult.ValidationType.TYPE_FORMAT, "LoanLegalActionStatementChoice0", path, "");
			})
			.collect(toList());
	}

}
