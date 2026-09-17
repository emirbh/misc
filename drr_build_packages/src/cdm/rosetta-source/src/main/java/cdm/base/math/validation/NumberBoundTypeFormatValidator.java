package cdm.base.math.validation;

import cdm.base.math.NumberBound;
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

public class NumberBoundTypeFormatValidator implements Validator<NumberBound> {

	private List<ComparisonResult> getComparisonResults(NumberBound o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NumberBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NumberBound", ValidationResult.ValidationType.TYPE_FORMAT, "NumberBound", path, "", res.getError());
				}
				return success("NumberBound", ValidationResult.ValidationType.TYPE_FORMAT, "NumberBound", path, "");
			})
			.collect(toList());
	}

}
