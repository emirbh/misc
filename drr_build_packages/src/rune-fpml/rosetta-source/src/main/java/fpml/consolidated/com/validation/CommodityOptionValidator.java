package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CommodityBarrier;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityExercise;
import fpml.consolidated.com.CommodityForward;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.com.CommodityPhysicalExercise;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.CommodityStrikeSchedule;
import fpml.consolidated.com.CommoditySwap;
import fpml.consolidated.com.FloatingStrikePrice;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.com.WeatherCalculationPeriods;
import fpml.consolidated.com.WeatherIndex;
import fpml.consolidated.com.WeatherIndexData;
import fpml.consolidated.com.WeatherLegCalculation;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Rounding;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommodityOptionValidator implements Validator<CommodityOption> {

	private List<ComparisonResult> getComparisonResults(CommodityOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("primaryAssetClass", (AssetClass) o.getPrimaryAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType() == null ? 0 : o.getEmbeddedOptionType().size(), 0, 2), 
				checkCardinality("buyerPartyReference", (PartyReference) o.getBuyerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerAccountReference", (AccountReference) o.getBuyerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerPartyReference", (PartyReference) o.getSellerPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerAccountReference", (AccountReference) o.getSellerAccountReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (PutCallEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("commodity", (Commodity) o.getCommodity() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (AdjustableOrRelativeDate) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("terminationDate", (AdjustableOrRelativeDate) o.getTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriodsSchedule", (CommodityCalculationPeriodsSchedule) o.getCalculationPeriodsSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationPeriods", (AdjustableDates) o.getCalculationPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingDates", (CommodityPricingDates) o.getPricingDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingMethod", (AveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("barrier", (CommodityBarrier) o.getBarrier() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalQuantitySchedule", (CommodityNotionalQuantitySchedule) o.getNotionalQuantitySchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalQuantity", (CommodityNotionalQuantity) o.getNotionalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("totalNotionalQuantity", (BigDecimal) o.getTotalNotionalQuantity() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityReference", (QuantityReference) o.getQuantityReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("exercise", (CommodityExercise) o.getExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePricePerUnit", (NonNegativeMoney) o.getStrikePricePerUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePricePerUnitSchedule", (CommodityStrikeSchedule) o.getStrikePricePerUnitSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingStrikePricePerUnit", (FloatingStrikePrice) o.getFloatingStrikePricePerUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingStrikePricePerUnitSchedule", (CommodityCalculationPeriodsSchedule) o.getFloatingStrikePricePerUnitSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("commoditySwap", (CommoditySwap) o.getCommoditySwap() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityForward", (CommodityForward) o.getCommodityForward() != null ? 1 : 0, 0, 1), 
				checkCardinality("physicalExercise", (CommodityPhysicalExercise) o.getPhysicalExercise() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherCalculationPeriods", (WeatherCalculationPeriods) o.getWeatherCalculationPeriods() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherCalculationPeriodsReference", (CalculationPeriodsReference) o.getWeatherCalculationPeriodsReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherNotionalAmount", (NonNegativeMoney) o.getWeatherNotionalAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherIndexStrikeLevel", (WeatherIndex) o.getWeatherIndexStrikeLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculation", (WeatherLegCalculation) o.getCalculation() != null ? 1 : 0, 0, 1), 
				checkCardinality("weatherIndexData", (WeatherIndexData) o.getWeatherIndexData() != null ? 1 : 0, 0, 1), 
				checkCardinality("commonPricing", (Boolean) o.getCommonPricing() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketDisruption", (CommodityMarketDisruption) o.getMarketDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDisruption", (CommodityBullionSettlementDisruptionEnum) o.getSettlementDisruption() != null ? 1 : 0, 0, 1), 
				checkCardinality("rounding", (Rounding) o.getRounding() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommodityOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommodityOption", ValidationResult.ValidationType.CARDINALITY, "CommodityOption", path, "", res.getError());
				}
				return success("CommodityOption", ValidationResult.ValidationType.CARDINALITY, "CommodityOption", path, "");
			})
			.collect(toList());
	}

}
