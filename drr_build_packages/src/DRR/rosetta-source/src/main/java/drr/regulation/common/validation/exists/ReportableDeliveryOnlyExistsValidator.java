package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableDelivery;
import drr.standards.iso.DurationType1Code;
import drr.standards.iso.EnergyQuantityUnit2Code;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReportableDeliveryOnlyExistsValidator implements ValidatorWithArg<ReportableDelivery, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReportableDelivery> ValidationResult<ReportableDelivery> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("deliveryStartTime", ExistenceChecker.isSet((LocalTime) o.getDeliveryStartTime()))
				.put("deliveryEndTime", ExistenceChecker.isSet((LocalTime) o.getDeliveryEndTime()))
				.put("deliveryStartDate", ExistenceChecker.isSet((Date) o.getDeliveryStartDate()))
				.put("deliveryEndDate", ExistenceChecker.isSet((Date) o.getDeliveryEndDate()))
				.put("duration", ExistenceChecker.isSet((DurationType1Code) o.getDuration()))
				.put("daysOfTheWeek", ExistenceChecker.isSet((List<String>) o.getDaysOfTheWeek()))
				.put("deliveryCapacity", ExistenceChecker.isSet((BigDecimal) o.getDeliveryCapacity()))
				.put("quantityUnit", ExistenceChecker.isSet((EnergyQuantityUnit2Code) o.getQuantityUnit()))
				.put("priceTimeIntervalQuantity", ExistenceChecker.isSet((BigDecimal) o.getPriceTimeIntervalQuantity()))
				.put("currencyOfThePriceTimeIntervalQuantity", ExistenceChecker.isSet((String) o.getCurrencyOfThePriceTimeIntervalQuantity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReportableDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableDelivery", path, "");
		}
		return failure("ReportableDelivery", ValidationResult.ValidationType.ONLY_EXISTS, "ReportableDelivery", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
