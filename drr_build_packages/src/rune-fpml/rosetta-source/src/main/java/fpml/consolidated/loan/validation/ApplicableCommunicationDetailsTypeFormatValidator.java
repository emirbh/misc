package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ApplicableCommunicationDetails;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ApplicableCommunicationDetailsTypeFormatValidator implements Validator<ApplicableCommunicationDetails> {

	private List<ComparisonResult> getComparisonResults(ApplicableCommunicationDetails o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApplicableCommunicationDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApplicableCommunicationDetails", ValidationResult.ValidationType.TYPE_FORMAT, "ApplicableCommunicationDetails", path, "", res.getError());
				}
				return success("ApplicableCommunicationDetails", ValidationResult.ValidationType.TYPE_FORMAT, "ApplicableCommunicationDetails", path, "");
			})
			.collect(toList());
	}

}
