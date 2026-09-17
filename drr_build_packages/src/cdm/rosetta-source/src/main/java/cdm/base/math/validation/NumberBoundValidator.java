package cdm.base.math.validation;

import cdm.base.math.NumberBound;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NumberBoundValidator implements Validator<NumberBound> {

	private List<ComparisonResult> getComparisonResults(NumberBound o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("number", (BigDecimal) o.getNumber() != null ? 1 : 0, 1, 1), 
				checkCardinality("inclusive", (Boolean) o.getInclusive() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NumberBound o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NumberBound", ValidationResult.ValidationType.CARDINALITY, "NumberBound", path, "", res.getError());
				}
				return success("NumberBound", ValidationResult.ValidationType.CARDINALITY, "NumberBound", path, "");
			})
			.collect(toList());
	}

}
