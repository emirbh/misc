package cdm.product.asset.validation;

import cdm.product.asset.InterestRatePayout;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestRatePayoutTypeFormatValidator implements Validator<InterestRatePayout> {

	private List<ComparisonResult> getComparisonResults(InterestRatePayout o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRatePayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRatePayout", ValidationResult.ValidationType.TYPE_FORMAT, "InterestRatePayout", path, "", res.getError());
				}
				return success("InterestRatePayout", ValidationResult.ValidationType.TYPE_FORMAT, "InterestRatePayout", path, "");
			})
			.collect(toList());
	}

}
