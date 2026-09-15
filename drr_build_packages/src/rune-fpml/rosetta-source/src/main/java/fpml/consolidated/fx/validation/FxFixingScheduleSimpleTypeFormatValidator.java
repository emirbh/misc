package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxFixingScheduleSimple;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxFixingScheduleSimpleTypeFormatValidator implements Validator<FxFixingScheduleSimple> {

	private List<ComparisonResult> getComparisonResults(FxFixingScheduleSimple o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingScheduleSimple o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFixingScheduleSimple", ValidationResult.ValidationType.TYPE_FORMAT, "FxFixingScheduleSimple", path, "", res.getError());
				}
				return success("FxFixingScheduleSimple", ValidationResult.ValidationType.TYPE_FORMAT, "FxFixingScheduleSimple", path, "");
			})
			.collect(toList());
	}

}
