package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.AveragingPeriod;
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

public class AveragingPeriodTypeFormatValidator implements Validator<AveragingPeriod> {

	private List<ComparisonResult> getComparisonResults(AveragingPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AveragingPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AveragingPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "AveragingPeriod", path, "", res.getError());
				}
				return success("AveragingPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "AveragingPeriod", path, "");
			})
			.collect(toList());
	}

}
