package fpml.consolidated.cd.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.cd.AdjustedPaymentDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdjustedPaymentDatesTypeFormatValidator implements Validator<AdjustedPaymentDates> {

	private List<ComparisonResult> getComparisonResults(AdjustedPaymentDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustedPaymentDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustedPaymentDates", ValidationResult.ValidationType.TYPE_FORMAT, "AdjustedPaymentDates", path, "", res.getError());
				}
				return success("AdjustedPaymentDates", ValidationResult.ValidationType.TYPE_FORMAT, "AdjustedPaymentDates", path, "");
			})
			.collect(toList());
	}

}
