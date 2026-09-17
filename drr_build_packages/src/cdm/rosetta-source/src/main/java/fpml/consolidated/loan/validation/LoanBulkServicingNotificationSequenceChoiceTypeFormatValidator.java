package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanBulkServicingNotificationSequenceChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanBulkServicingNotificationSequenceChoiceTypeFormatValidator implements Validator<LoanBulkServicingNotificationSequenceChoice> {

	private List<ComparisonResult> getComparisonResults(LoanBulkServicingNotificationSequenceChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanBulkServicingNotificationSequenceChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanBulkServicingNotificationSequenceChoice", ValidationResult.ValidationType.TYPE_FORMAT, "LoanBulkServicingNotificationSequenceChoice", path, "", res.getError());
				}
				return success("LoanBulkServicingNotificationSequenceChoice", ValidationResult.ValidationType.TYPE_FORMAT, "LoanBulkServicingNotificationSequenceChoice", path, "");
			})
			.collect(toList());
	}

}
