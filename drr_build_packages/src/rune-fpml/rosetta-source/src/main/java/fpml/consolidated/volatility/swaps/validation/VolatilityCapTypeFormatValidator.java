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
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class VolatilityCapTypeFormatValidator implements Validator<VolatilityCap> {

	private List<ComparisonResult> getComparisonResults(VolatilityCap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("totalVolatilityCap", o.getTotalVolatilityCap(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("volatilityCapFactor", o.getVolatilityCapFactor(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityCap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityCap", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilityCap", path, "", res.getError());
				}
				return success("VolatilityCap", ValidationResult.ValidationType.TYPE_FORMAT, "VolatilityCap", path, "");
			})
			.collect(toList());
	}

}
