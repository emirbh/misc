package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.FxRateSourceFixing;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxRateSourceFixingTypeFormatValidator implements Validator<FxRateSourceFixing> {

	private List<ComparisonResult> getComparisonResults(FxRateSourceFixing o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxRateSourceFixing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxRateSourceFixing", ValidationResult.ValidationType.TYPE_FORMAT, "FxRateSourceFixing", path, "", res.getError());
				}
				return success("FxRateSourceFixing", ValidationResult.ValidationType.TYPE_FORMAT, "FxRateSourceFixing", path, "");
			})
			.collect(toList());
	}

}
