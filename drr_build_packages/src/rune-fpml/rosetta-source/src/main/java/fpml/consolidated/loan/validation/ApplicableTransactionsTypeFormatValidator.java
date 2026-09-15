package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApplicableTransactions;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApplicableTransactionsTypeFormatValidator implements Validator<ApplicableTransactions> {

	private List<ComparisonResult> getComparisonResults(ApplicableTransactions o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableTransactions o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableTransactions", ValidationResult.ValidationType.TYPE_FORMAT, "ApplicableTransactions", path, "", res.getError());
				}
				return success("ApplicableTransactions", ValidationResult.ValidationType.TYPE_FORMAT, "ApplicableTransactions", path, "");
			})
			.collect(toList());
	}

}
