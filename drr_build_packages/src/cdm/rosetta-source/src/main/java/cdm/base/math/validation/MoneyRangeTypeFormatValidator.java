package cdm.base.math.validation;

import cdm.base.math.MoneyRange;
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

public class MoneyRangeTypeFormatValidator implements Validator<MoneyRange> {

	private List<ComparisonResult> getComparisonResults(MoneyRange o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MoneyRange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MoneyRange", ValidationResult.ValidationType.TYPE_FORMAT, "MoneyRange", path, "", res.getError());
				}
				return success("MoneyRange", ValidationResult.ValidationType.TYPE_FORMAT, "MoneyRange", path, "");
			})
			.collect(toList());
	}

}
