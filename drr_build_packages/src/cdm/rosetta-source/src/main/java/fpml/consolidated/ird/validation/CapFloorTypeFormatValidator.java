package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.CapFloor;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CapFloorTypeFormatValidator implements Validator<CapFloor> {

	private List<ComparisonResult> getComparisonResults(CapFloor o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CapFloor o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CapFloor", ValidationResult.ValidationType.TYPE_FORMAT, "CapFloor", path, "", res.getError());
				}
				return success("CapFloor", ValidationResult.ValidationType.TYPE_FORMAT, "CapFloor", path, "");
			})
			.collect(toList());
	}

}
