package fpml.consolidated.accumulator.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.accumulator.Gearing;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GearingTypeFormatValidator implements Validator<Gearing> {

	private List<ComparisonResult> getComparisonResults(Gearing o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Gearing o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Gearing", ValidationResult.ValidationType.TYPE_FORMAT, "Gearing", path, "", res.getError());
				}
				return success("Gearing", ValidationResult.ValidationType.TYPE_FORMAT, "Gearing", path, "");
			})
			.collect(toList());
	}

}
