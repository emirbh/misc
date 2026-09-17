package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.DualExchangeRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DualExchangeRateTypeFormatValidator implements Validator<DualExchangeRate> {

	private List<ComparisonResult> getComparisonResults(DualExchangeRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DualExchangeRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DualExchangeRate", ValidationResult.ValidationType.TYPE_FORMAT, "DualExchangeRate", path, "", res.getError());
				}
				return success("DualExchangeRate", ValidationResult.ValidationType.TYPE_FORMAT, "DualExchangeRate", path, "");
			})
			.collect(toList());
	}

}
