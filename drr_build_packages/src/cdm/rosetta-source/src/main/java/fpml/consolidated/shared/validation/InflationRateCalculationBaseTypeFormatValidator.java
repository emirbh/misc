package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.InflationRateCalculationBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InflationRateCalculationBaseTypeFormatValidator implements Validator<InflationRateCalculationBase> {

	private List<ComparisonResult> getComparisonResults(InflationRateCalculationBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationRateCalculationBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InflationRateCalculationBase", ValidationResult.ValidationType.TYPE_FORMAT, "InflationRateCalculationBase", path, "", res.getError());
				}
				return success("InflationRateCalculationBase", ValidationResult.ValidationType.TYPE_FORMAT, "InflationRateCalculationBase", path, "");
			})
			.collect(toList());
	}

}
