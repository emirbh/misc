package fpml.consolidated.reg.fpmlreporting.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.GenericSecurity;
import fpml.consolidated.asset.PriceQuoteUnits;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPosition;
import fpml.consolidated.repo.RelativePrice;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PositiveMoney;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralPositionValidator implements Validator<CollateralPosition> {

	private List<ComparisonResult> getComparisonResults(CollateralPosition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("security", (GenericSecurity) o.getSecurity() != null ? 1 : 0, 1, 1), 
				checkCardinality("nominalAmount", (Money) o.getNominalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantity", (BigDecimal) o.getQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleanPrice", (BigDecimal) o.getCleanPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("accruals", (BigDecimal) o.getAccruals() != null ? 1 : 0, 0, 1), 
				checkCardinality("dirtyPrice", (BigDecimal) o.getDirtyPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("relativePrice", (RelativePrice) o.getRelativePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("yieldToMaturity", (BigDecimal) o.getYieldToMaturity() != null ? 1 : 0, 0, 1), 
				checkCardinality("inflationFactor", (BigDecimal) o.getInflationFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("allInPrice", (BigDecimal) o.getAllInPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("unitPrice", (NonNegativeMoney) o.getUnitPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("quoteUnits", (PriceQuoteUnits) o.getQuoteUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationAmount", (PositiveMoney) o.getValuationAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("marginRatio", (BigDecimal) o.getMarginRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("haircut", (BigDecimal) o.getHaircut() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralPosition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralPosition", ValidationResult.ValidationType.CARDINALITY, "CollateralPosition", path, "", res.getError());
				}
				return success("CollateralPosition", ValidationResult.ValidationType.CARDINALITY, "CollateralPosition", path, "");
			})
			.collect(toList());
	}

}
