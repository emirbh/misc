package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.InflationRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InflationRateTypeFormatValidator implements Validator<InflationRate> {

	private List<ComparisonResult> getComparisonResults(InflationRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InflationRate", ValidationResult.ValidationType.TYPE_FORMAT, "InflationRate", path, "", res.getError());
				}
				return success("InflationRate", ValidationResult.ValidationType.TYPE_FORMAT, "InflationRate", path, "");
			})
			.collect(toList());
	}

}
