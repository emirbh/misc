package cdm.base.math.validation;

import cdm.base.math.NumberBound;
import cdm.base.math.NumberRange;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NumberRangeValidator implements Validator<NumberRange> {

	private List<ComparisonResult> getComparisonResults(NumberRange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("lowerBound", (NumberBound) o.getLowerBound() != null ? 1 : 0, 0, 1), 
				checkCardinality("upperBound", (NumberBound) o.getUpperBound() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NumberRange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NumberRange", ValidationResult.ValidationType.CARDINALITY, "NumberRange", path, "", res.getError());
				}
				return success("NumberRange", ValidationResult.ValidationType.CARDINALITY, "NumberRange", path, "");
			})
			.collect(toList());
	}

}
