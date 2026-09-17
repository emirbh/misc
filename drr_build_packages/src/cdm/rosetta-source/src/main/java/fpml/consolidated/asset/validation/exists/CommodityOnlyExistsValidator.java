package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.asset.CommodityBase;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.asset.CommodityDetails;
import fpml.consolidated.asset.CommodityInformationSource;
import fpml.consolidated.asset.DeliveryNearby;
import fpml.consolidated.asset.InstrumentType;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.fpmlenum.DeliveryDatesEnum;
import fpml.consolidated.fpmlenum.SpecifiedPriceEnum;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.ExchangeId;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.Offset;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommodityOnlyExistsValidator implements ValidatorWithArg<Commodity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Commodity> ValidationResult<Commodity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("instrumentType", ExistenceChecker.isSet((List<? extends InstrumentType>) o.getInstrumentType()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.put("commodityBase", ExistenceChecker.isSet((CommodityBase) o.getCommodityBase()))
				.put("commodityDetails", ExistenceChecker.isSet((CommodityDetails) o.getCommodityDetails()))
				.put("commodityClassification", ExistenceChecker.isSet((List<? extends CommodityClassification>) o.getCommodityClassification()))
				.put("unit", ExistenceChecker.isSet((QuantityUnit) o.getUnit()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("exchangeId", ExistenceChecker.isSet((ExchangeId) o.getExchangeId()))
				.put("publication", ExistenceChecker.isSet((CommodityInformationSource) o.getPublication()))
				.put("specifiedPrice", ExistenceChecker.isSet((SpecifiedPriceEnum) o.getSpecifiedPrice()))
				.put("deliveryDates", ExistenceChecker.isSet((DeliveryDatesEnum) o.getDeliveryDates()))
				.put("deliveryNearby", ExistenceChecker.isSet((DeliveryNearby) o.getDeliveryNearby()))
				.put("deliveryDate", ExistenceChecker.isSet((AdjustableDate) o.getDeliveryDate()))
				.put("deliveryDateYearMonth", ExistenceChecker.isSet((String) o.getDeliveryDateYearMonth()))
				.put("deliveryDateRollConvention", ExistenceChecker.isSet((Offset) o.getDeliveryDateRollConvention()))
				.put("deliveryDateExpirationConvention", ExistenceChecker.isSet((Offset) o.getDeliveryDateExpirationConvention()))
				.put("multiplier", ExistenceChecker.isSet((BigDecimal) o.getMultiplier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Commodity", ValidationResult.ValidationType.ONLY_EXISTS, "Commodity", path, "");
		}
		return failure("Commodity", ValidationResult.ValidationType.ONLY_EXISTS, "Commodity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
