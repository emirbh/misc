package cdm.observable.asset.validation;

import cdm.observable.asset.ValuationDates;
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

public class ValuationDatesTypeFormatValidator implements Validator<ValuationDates> {

	private List<ComparisonResult> getComparisonResults(ValuationDates o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuationDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuationDates", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationDates", path, "", res.getError());
				}
				return success("ValuationDates", ValidationResult.ValidationType.TYPE_FORMAT, "ValuationDates", path, "");
			})
			.collect(toList());
	}

}
