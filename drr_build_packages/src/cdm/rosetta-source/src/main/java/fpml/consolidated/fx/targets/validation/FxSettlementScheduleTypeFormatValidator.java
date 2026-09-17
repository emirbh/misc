package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxSettlementScheduleTypeFormatValidator implements Validator<FxSettlementSchedule> {

	private List<ComparisonResult> getComparisonResults(FxSettlementSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxSettlementSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxSettlementSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "FxSettlementSchedule", path, "", res.getError());
				}
				return success("FxSettlementSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "FxSettlementSchedule", path, "");
			})
			.collect(toList());
	}

}
