package fpml.consolidated.volatility.swaps.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.volatility.swaps.Volatility;
import fpml.consolidated.volatility.swaps.VolatilityCap;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VolatilityValidator implements Validator<Volatility> {

	private List<ComparisonResult> getComparisonResults(Volatility o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialLevel", (BigDecimal) o.getInitialLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialLevelSource", (DeterminationMethod) o.getInitialLevelSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("closingLevel", (Boolean) o.getClosingLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiringLevel", (Boolean) o.getExpiringLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expectedN", (Integer) o.getExpectedN() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatilityCap", (VolatilityCap) o.getVolatilityCap() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatilityStrikePrice", (BigDecimal) o.getVolatilityStrikePrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("vegaNotionalAmount", (BigDecimal) o.getVegaNotionalAmount() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Volatility o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Volatility", ValidationResult.ValidationType.CARDINALITY, "Volatility", path, "", res.getError());
				}
				return success("Volatility", ValidationResult.ValidationType.CARDINALITY, "Volatility", path, "");
			})
			.collect(toList());
	}

}
