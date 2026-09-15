package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.WeatherCalculationPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WeatherCalculationPeriodTypeFormatValidator implements Validator<WeatherCalculationPeriod> {

	private List<ComparisonResult> getComparisonResults(WeatherCalculationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherCalculationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherCalculationPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "WeatherCalculationPeriod", path, "", res.getError());
				}
				return success("WeatherCalculationPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "WeatherCalculationPeriod", path, "");
			})
			.collect(toList());
	}

}
