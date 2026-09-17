package cdm.observable.asset.validation;

import cdm.observable.asset.PriceSchedule;
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

public class PriceScheduleTypeFormatValidator implements Validator<PriceSchedule> {

	private List<ComparisonResult> getComparisonResults(PriceSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PriceSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PriceSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "PriceSchedule", path, "", res.getError());
				}
				return success("PriceSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "PriceSchedule", path, "");
			})
			.collect(toList());
	}

}
