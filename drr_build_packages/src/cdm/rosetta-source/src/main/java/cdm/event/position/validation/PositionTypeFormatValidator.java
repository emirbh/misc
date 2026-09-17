package cdm.event.position.validation;

import cdm.event.position.Position;
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

public class PositionTypeFormatValidator implements Validator<Position> {

	private List<ComparisonResult> getComparisonResults(Position o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Position o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Position", ValidationResult.ValidationType.TYPE_FORMAT, "Position", path, "", res.getError());
				}
				return success("Position", ValidationResult.ValidationType.TYPE_FORMAT, "Position", path, "");
			})
			.collect(toList());
	}

}
