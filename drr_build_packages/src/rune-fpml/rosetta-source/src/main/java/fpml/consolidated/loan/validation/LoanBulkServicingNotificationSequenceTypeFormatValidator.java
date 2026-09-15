package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanBulkServicingNotificationSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanBulkServicingNotificationSequenceTypeFormatValidator implements Validator<LoanBulkServicingNotificationSequence> {

	private List<ComparisonResult> getComparisonResults(LoanBulkServicingNotificationSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanBulkServicingNotificationSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanBulkServicingNotificationSequence", ValidationResult.ValidationType.TYPE_FORMAT, "LoanBulkServicingNotificationSequence", path, "", res.getError());
				}
				return success("LoanBulkServicingNotificationSequence", ValidationResult.ValidationType.TYPE_FORMAT, "LoanBulkServicingNotificationSequence", path, "");
			})
			.collect(toList());
	}

}
