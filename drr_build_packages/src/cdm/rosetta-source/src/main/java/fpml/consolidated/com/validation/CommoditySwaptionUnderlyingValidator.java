package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.CommoditySwaptionUnderlying;
import fpml.consolidated.com.WeatherLeg;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.Rounding;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommoditySwaptionUnderlyingValidator implements Validator<CommoditySwaptionUnderlying> {

	private List<ComparisonResult> getComparisonResults(CommoditySwaptionUnderlying o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementCurrency", (IdentifiedCurrency) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherLeg", (List<? extends WeatherLeg>) o.getWeatherLeg() == null ? 0 : o.getWeatherLeg().size(), 0, 2), 
				checkCardinality("commonPricing", (Boolean) o.getCommonPricing() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketDisruption", (CommodityMarketDisruption) o.getMarketDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDisruption", (CommodityBullionSettlementDisruptionEnum) o.getSettlementDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommoditySwaptionUnderlying o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommoditySwaptionUnderlying", ValidationResult.ValidationType.CARDINALITY, "CommoditySwaptionUnderlying", path, "", res.getError());
				}
				return success("CommoditySwaptionUnderlying", ValidationResult.ValidationType.CARDINALITY, "CommoditySwaptionUnderlying", path, "");
			})
			.collect(toList());
	}

}
