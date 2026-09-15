package fpml.consolidated.volatility.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.volatility.swaps.VolatilityCap;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VolatilityCapValidator implements Validator<VolatilityCap> {

	private List<ComparisonResult> getComparisonResults(VolatilityCap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalVolatilityCap", (BigDecimal) o.getTotalVolatilityCap() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatilityCapFactor", (BigDecimal) o.getVolatilityCapFactor() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityCap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityCap", ValidationResult.ValidationType.CARDINALITY, "VolatilityCap", path, "", res.getError());
				}
				return success("VolatilityCap", ValidationResult.ValidationType.CARDINALITY, "VolatilityCap", path, "");
			})
			.collect(toList());
	}

}
