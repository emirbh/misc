package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
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
import fpml.consolidated.com.CommodityPremium;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.CommoditySettlementPeriodsNotionalQuantity;
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
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.Rounding;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityOptionOnlyExistsValidator implements ValidatorWithArg<CommodityOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityOption> ValidationResult<CommodityOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("primaryAssetClass", ExistenceChecker.isSet((AssetClass) o.getPrimaryAssetClass()))
				.put("secondaryAssetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getSecondaryAssetClass()))
				.put("productType", ExistenceChecker.isSet((List<? extends ProductType>) o.getProductType()))
				.put("productId", ExistenceChecker.isSet((List<? extends ProductId>) o.getProductId()))
				.put("embeddedOptionType", ExistenceChecker.isSet((List<? extends EmbeddedOptionType>) o.getEmbeddedOptionType()))
				.put("assetClass", ExistenceChecker.isSet((List<? extends AssetClass>) o.getAssetClass()))
				.put("buyerPartyReference", ExistenceChecker.isSet((PartyReference) o.getBuyerPartyReference()))
				.put("buyerAccountReference", ExistenceChecker.isSet((AccountReference) o.getBuyerAccountReference()))
				.put("sellerPartyReference", ExistenceChecker.isSet((PartyReference) o.getSellerPartyReference()))
				.put("sellerAccountReference", ExistenceChecker.isSet((AccountReference) o.getSellerAccountReference()))
				.put("optionType", ExistenceChecker.isSet((PutCallEnum) o.getOptionType()))
				.put("commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("calculationPeriodsSchedule", ExistenceChecker.isSet((CommodityCalculationPeriodsSchedule) o.getCalculationPeriodsSchedule()))
				.put("calculationPeriods", ExistenceChecker.isSet((AdjustableDates) o.getCalculationPeriods()))
				.put("pricingDates", ExistenceChecker.isSet((CommodityPricingDates) o.getPricingDates()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.put("barrier", ExistenceChecker.isSet((CommodityBarrier) o.getBarrier()))
				.put("notionalQuantitySchedule", ExistenceChecker.isSet((CommodityNotionalQuantitySchedule) o.getNotionalQuantitySchedule()))
				.put("notionalQuantity", ExistenceChecker.isSet((CommodityNotionalQuantity) o.getNotionalQuantity()))
				.put("settlementPeriodsNotionalQuantity", ExistenceChecker.isSet((List<? extends CommoditySettlementPeriodsNotionalQuantity>) o.getSettlementPeriodsNotionalQuantity()))
				.put("totalNotionalQuantity", ExistenceChecker.isSet((BigDecimal) o.getTotalNotionalQuantity()))
				.put("quantityReference", ExistenceChecker.isSet((QuantityReference) o.getQuantityReference()))
				.put("exercise", ExistenceChecker.isSet((CommodityExercise) o.getExercise()))
				.put("strikePricePerUnit", ExistenceChecker.isSet((NonNegativeMoney) o.getStrikePricePerUnit()))
				.put("strikePricePerUnitSchedule", ExistenceChecker.isSet((CommodityStrikeSchedule) o.getStrikePricePerUnitSchedule()))
				.put("floatingStrikePricePerUnit", ExistenceChecker.isSet((FloatingStrikePrice) o.getFloatingStrikePricePerUnit()))
				.put("floatingStrikePricePerUnitSchedule", ExistenceChecker.isSet((CommodityCalculationPeriodsSchedule) o.getFloatingStrikePricePerUnitSchedule()))
				.put("commoditySwap", ExistenceChecker.isSet((CommoditySwap) o.getCommoditySwap()))
				.put("commodityForward", ExistenceChecker.isSet((CommodityForward) o.getCommodityForward()))
				.put("physicalExercise", ExistenceChecker.isSet((CommodityPhysicalExercise) o.getPhysicalExercise()))
				.put("weatherCalculationPeriods", ExistenceChecker.isSet((WeatherCalculationPeriods) o.getWeatherCalculationPeriods()))
				.put("weatherCalculationPeriodsReference", ExistenceChecker.isSet((CalculationPeriodsReference) o.getWeatherCalculationPeriodsReference()))
				.put("weatherNotionalAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getWeatherNotionalAmount()))
				.put("weatherIndexStrikeLevel", ExistenceChecker.isSet((WeatherIndex) o.getWeatherIndexStrikeLevel()))
				.put("calculation", ExistenceChecker.isSet((WeatherLegCalculation) o.getCalculation()))
				.put("weatherIndexData", ExistenceChecker.isSet((WeatherIndexData) o.getWeatherIndexData()))
				.put("premium", ExistenceChecker.isSet((List<? extends CommodityPremium>) o.getPremium()))
				.put("commonPricing", ExistenceChecker.isSet((Boolean) o.getCommonPricing()))
				.put("marketDisruption", ExistenceChecker.isSet((CommodityMarketDisruption) o.getMarketDisruption()))
				.put("settlementDisruption", ExistenceChecker.isSet((CommodityBullionSettlementDisruptionEnum) o.getSettlementDisruption()))
				.put("rounding", ExistenceChecker.isSet((Rounding) o.getRounding()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityOption", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityOption", path, "");
		}
		return failure("CommodityOption", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
