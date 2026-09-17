package cdm.observable.asset.validation;

import cdm.observable.asset.PerformanceValuationDates;
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

public class PerformanceValuationDatesTypeFormatValidator implements Validator<PerformanceValuationDates> {

	private List<ComparisonResult> getComparisonResults(PerformanceValuationDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PerformanceValuationDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PerformanceValuationDates", ValidationResult.ValidationType.TYPE_FORMAT, "PerformanceValuationDates", path, "", res.getError());
				}
				return success("PerformanceValuationDates", ValidationResult.ValidationType.TYPE_FORMAT, "PerformanceValuationDates", path, "");
			})
			.collect(toList());
	}

}
