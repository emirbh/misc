package fpml.consolidated.mktenv.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.mktenv.MultiDimensionalPricingData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MultiDimensionalPricingDataTypeFormatValidator implements Validator<MultiDimensionalPricingData> {

	private List<ComparisonResult> getComparisonResults(MultiDimensionalPricingData o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MultiDimensionalPricingData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MultiDimensionalPricingData", ValidationResult.ValidationType.TYPE_FORMAT, "MultiDimensionalPricingData", path, "", res.getError());
				}
				return success("MultiDimensionalPricingData", ValidationResult.ValidationType.TYPE_FORMAT, "MultiDimensionalPricingData", path, "");
			})
			.collect(toList());
	}

}
