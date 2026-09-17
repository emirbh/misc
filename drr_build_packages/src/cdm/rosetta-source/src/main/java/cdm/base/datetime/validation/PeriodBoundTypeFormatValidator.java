package cdm.base.datetime.validation;

import cdm.base.datetime.PeriodBound;
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

public class PeriodBoundTypeFormatValidator implements Validator<PeriodBound> {

	private List<ComparisonResult> getComparisonResults(PeriodBound o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PeriodBound", ValidationResult.ValidationType.TYPE_FORMAT, "PeriodBound", path, "", res.getError());
				}
				return success("PeriodBound", ValidationResult.ValidationType.TYPE_FORMAT, "PeriodBound", path, "");
			})
			.collect(toList());
	}

}
