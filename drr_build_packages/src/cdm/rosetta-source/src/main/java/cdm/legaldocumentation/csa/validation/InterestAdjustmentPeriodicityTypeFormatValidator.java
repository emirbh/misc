package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.InterestAdjustmentPeriodicity;
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

public class InterestAdjustmentPeriodicityTypeFormatValidator implements Validator<InterestAdjustmentPeriodicity> {

	private List<ComparisonResult> getComparisonResults(InterestAdjustmentPeriodicity o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAdjustmentPeriodicity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestAdjustmentPeriodicity", ValidationResult.ValidationType.TYPE_FORMAT, "InterestAdjustmentPeriodicity", path, "", res.getError());
				}
				return success("InterestAdjustmentPeriodicity", ValidationResult.ValidationType.TYPE_FORMAT, "InterestAdjustmentPeriodicity", path, "");
			})
			.collect(toList());
	}

}
