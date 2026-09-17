package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.ReturnSwapPaymentDates;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnSwapPaymentDatesTypeFormatValidator implements Validator<ReturnSwapPaymentDates> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapPaymentDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapPaymentDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapPaymentDates", ValidationResult.ValidationType.TYPE_FORMAT, "ReturnSwapPaymentDates", path, "", res.getError());
				}
				return success("ReturnSwapPaymentDates", ValidationResult.ValidationType.TYPE_FORMAT, "ReturnSwapPaymentDates", path, "");
			})
			.collect(toList());
	}

}
