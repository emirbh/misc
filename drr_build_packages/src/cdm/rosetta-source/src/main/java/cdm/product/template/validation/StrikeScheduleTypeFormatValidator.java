package cdm.product.template.validation;

import cdm.product.template.StrikeSchedule;
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

public class StrikeScheduleTypeFormatValidator implements Validator<StrikeSchedule> {

	private List<ComparisonResult> getComparisonResults(StrikeSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrikeSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StrikeSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "StrikeSchedule", path, "", res.getError());
				}
				return success("StrikeSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "StrikeSchedule", path, "");
			})
			.collect(toList());
	}

}
