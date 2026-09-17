package cdm.base.datetime.validation;

import cdm.base.datetime.RelativeDates;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class RelativeDatesTypeFormatValidator implements Validator<RelativeDates> {

	private List<ComparisonResult> getComparisonResults(RelativeDates o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("periodMultiplier", o.getPeriodMultiplier(), empty(), of(0), empty(), empty()), 
				checkNumber("periodSkip", o.getPeriodSkip(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelativeDates o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelativeDates", ValidationResult.ValidationType.TYPE_FORMAT, "RelativeDates", path, "", res.getError());
				}
				return success("RelativeDates", ValidationResult.ValidationType.TYPE_FORMAT, "RelativeDates", path, "");
			})
			.collect(toList());
	}

}
