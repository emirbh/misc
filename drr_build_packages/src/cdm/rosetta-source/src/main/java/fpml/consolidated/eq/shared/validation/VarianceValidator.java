package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ExchangeTradedContract;
import fpml.consolidated.eq.shared.BoundedVariance;
import fpml.consolidated.eq.shared.Variance;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.NonNegativeMoney;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class VarianceValidator implements Validator<Variance> {

	private List<ComparisonResult> getComparisonResults(Variance o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialLevel", (BigDecimal) o.getInitialLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialLevelSource", (DeterminationMethod) o.getInitialLevelSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("closingLevel", (Boolean) o.getClosingLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiringLevel", (Boolean) o.getExpiringLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("expectedN", (Integer) o.getExpectedN() != null ? 1 : 0, 0, 1), 
				checkCardinality("varianceAmount", (NonNegativeMoney) o.getVarianceAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("volatilityStrikePrice", (BigDecimal) o.getVolatilityStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("varianceStrikePrice", (BigDecimal) o.getVarianceStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("varianceCap", (Boolean) o.getVarianceCap() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedVarianceCap", (BigDecimal) o.getUnadjustedVarianceCap() != null ? 1 : 0, 0, 1), 
				checkCardinality("boundedVariance", (BoundedVariance) o.getBoundedVariance() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeTradedContractNearest", (ExchangeTradedContract) o.getExchangeTradedContractNearest() != null ? 1 : 0, 0, 1), 
				checkCardinality("vegaNotionalAmount", (BigDecimal) o.getVegaNotionalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Variance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Variance", ValidationResult.ValidationType.CARDINALITY, "Variance", path, "", res.getError());
				}
				return success("Variance", ValidationResult.ValidationType.CARDINALITY, "Variance", path, "");
			})
			.collect(toList());
	}

}
