package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CommodityBasketUnderlyingByNotional;
import fpml.consolidated.com.CommodityFx;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.CommoditySettlementPeriodsNotionalQuantity;
import fpml.consolidated.com.QuantityReference;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.PayerReceiverEnum;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityBasketUnderlyingByNotionalOnlyExistsValidator implements ValidatorWithArg<CommodityBasketUnderlyingByNotional, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommodityBasketUnderlyingByNotional> ValidationResult<CommodityBasketUnderlyingByNotional> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("direction", ExistenceChecker.isSet((PayerReceiverEnum) o.getDirection()))
				.put("commodity", ExistenceChecker.isSet((Commodity) o.getCommodity()))
				.put("pricingDates", ExistenceChecker.isSet((CommodityPricingDates) o.getPricingDates()))
				.put("averagingMethod", ExistenceChecker.isSet((AveragingMethodEnum) o.getAveragingMethod()))
				.put("fx", ExistenceChecker.isSet((CommodityFx) o.getFx()))
				.put("conversionFactor", ExistenceChecker.isSet((BigDecimal) o.getConversionFactor()))
				.put("notionalQuantitySchedule", ExistenceChecker.isSet((CommodityNotionalQuantitySchedule) o.getNotionalQuantitySchedule()))
				.put("notionalQuantity", ExistenceChecker.isSet((CommodityNotionalQuantity) o.getNotionalQuantity()))
				.put("settlementPeriodsNotionalQuantity", ExistenceChecker.isSet((List<? extends CommoditySettlementPeriodsNotionalQuantity>) o.getSettlementPeriodsNotionalQuantity()))
				.put("totalNotionalQuantity", ExistenceChecker.isSet((BigDecimal) o.getTotalNotionalQuantity()))
				.put("quantityReference", ExistenceChecker.isSet((QuantityReference) o.getQuantityReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityBasketUnderlyingByNotional", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasketUnderlyingByNotional", path, "");
		}
		return failure("CommodityBasketUnderlyingByNotional", ValidationResult.ValidationType.ONLY_EXISTS, "CommodityBasketUnderlyingByNotional", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
