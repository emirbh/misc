package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.WeatherIndex;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class WeatherIndexTypeFormatValidator implements Validator<WeatherIndex> {

	private List<ComparisonResult> getComparisonResults(WeatherIndex o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherIndex", ValidationResult.ValidationType.TYPE_FORMAT, "WeatherIndex", path, "", res.getError());
				}
				return success("WeatherIndex", ValidationResult.ValidationType.TYPE_FORMAT, "WeatherIndex", path, "");
			})
			.collect(toList());
	}

}
