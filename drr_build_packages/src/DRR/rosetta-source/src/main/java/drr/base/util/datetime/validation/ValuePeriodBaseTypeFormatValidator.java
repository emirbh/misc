package drr.base.util.datetime.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.util.datetime.ValuePeriodBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ValuePeriodBaseTypeFormatValidator implements Validator<ValuePeriodBase> {

	private List<ComparisonResult> getComparisonResults(ValuePeriodBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ValuePeriodBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ValuePeriodBase", ValidationResult.ValidationType.TYPE_FORMAT, "ValuePeriodBase", path, "", res.getError());
				}
				return success("ValuePeriodBase", ValidationResult.ValidationType.TYPE_FORMAT, "ValuePeriodBase", path, "");
			})
			.collect(toList());
	}

}
