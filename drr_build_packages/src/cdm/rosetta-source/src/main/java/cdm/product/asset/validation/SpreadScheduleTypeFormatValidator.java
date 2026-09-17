package cdm.product.asset.validation;

import cdm.product.asset.SpreadSchedule;
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

public class SpreadScheduleTypeFormatValidator implements Validator<SpreadSchedule> {

	private List<ComparisonResult> getComparisonResults(SpreadSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SpreadSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SpreadSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "SpreadSchedule", path, "", res.getError());
				}
				return success("SpreadSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "SpreadSchedule", path, "");
			})
			.collect(toList());
	}

}
