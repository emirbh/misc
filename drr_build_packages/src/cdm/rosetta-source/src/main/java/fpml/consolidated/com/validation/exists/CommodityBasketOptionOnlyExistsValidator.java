package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityBasketByNotional;
import fpml.consolidated.com.CommodityBasketByPercentage;
import fpml.consolidated.com.CommodityBasketOption;
import fpml.consolidated.com.CommodityCalculationPeriodsSchedule;
import fpml.consolidated.com.CommodityExerciseBasket;
import fpml.consolidated.com.CommodityMarketDisruption;
import fpml.consolidated.com.CommodityPremium;
import fpml.consolidated.com.CommodityStrikeSchedule;
import fpml.consolidated.com.FloatingStrikePrice;
import fpml.consolidated.com.StrikePriceBasketReference;
import fpml.consolidated.com.StrikePriceUnderlyingReference;
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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBasketOptionOnlyExistsValidator implements ValidatorWithArg<CommodityBasketOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBasketOption> ValidationResult<CommodityBasketOption> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("effectiveDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getTerminationDate()))
				.put("calculationPeriodsSchedule", ExistenceChecker.isSet((CommodityCalculationPeriodsSchedule) o.getCalculationPeriodsSchedule()))
				.put("calculationPeriods", ExistenceChecker.isSet((AdjustableDates) o.getCalculationPeriods()))
				.put("notionalQuantityBasket", ExistenceChecker.isSet((CommodityBasketByNotional) o.getNotionalQuantityBasket()))
				.put("notionalAmountBasket", ExistenceChecker.isSet((CommodityBasketByPercentage) o.getNotionalAmountBasket()))
				.put("strikePriceUnderlyingReference", ExistenceChecker.isSet((StrikePriceUnderlyingReference) o.getStrikePriceUnderlyingReference()))
				.put("strikePriceBasketReference", ExistenceChecker.isSet((StrikePriceBasketReference) o.getStrikePriceBasketReference()))
				.put("strikePricePerUnit", ExistenceChecker.isSet((NonNegativeMoney) o.getStrikePricePerUnit()))
				.put("strikePricePerUnitSchedule", ExistenceChecker.isSet((CommodityStrikeSchedule) o.getStrikePricePerUnitSchedule()))
				.put("floatingStrikePricePerUnit", ExistenceChecker.isSet((FloatingStrikePrice) o.getFloatingStrikePricePerUnit()))
				.put("floatingStrikePricePerUnitSchedule", ExistenceChecker.isSet((CommodityCalculationPeriodsSchedule) o.getFloatingStrikePricePerUnitSchedule()))
				.put("exercise", ExistenceChecker.isSet((CommodityExerciseBasket) o.getExercise()))
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
			return success("CommodityBasketOption", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasketOption", path, "");
		}
		return failure("CommodityBasketOption", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasketOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
