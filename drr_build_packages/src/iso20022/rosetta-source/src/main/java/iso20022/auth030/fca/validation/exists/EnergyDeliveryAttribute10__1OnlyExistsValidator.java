package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.AmountAndDirection106__3;
import iso20022.auth030.fca.DatePeriod1;
import iso20022.auth030.fca.DurationType1Code;
import iso20022.auth030.fca.EnergyDeliveryAttribute10__1;
import iso20022.auth030.fca.EnergyQuantityUnit2Choice__1;
import iso20022.auth030.fca.Quantity47Choice__1;
import iso20022.auth030.fca.TimePeriodDetails1;
import iso20022.auth030.fca.WeekDay3Code__1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EnergyDeliveryAttribute10__1OnlyExistsValidator implements ValidatorWithArg<EnergyDeliveryAttribute10__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EnergyDeliveryAttribute10__1> ValidationResult<EnergyDeliveryAttribute10__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dlvryIntrvl", ExistenceChecker.isSet((List<? extends TimePeriodDetails1>) o.getDlvryIntrvl()))
				.put("dlvryDt", ExistenceChecker.isSet((DatePeriod1) o.getDlvryDt()))
				.put("drtn", ExistenceChecker.isSet((DurationType1Code) o.getDrtn()))
				.put("wkDay", ExistenceChecker.isSet((List<WeekDay3Code__1>) o.getWkDay()))
				.put("dlvryCpcty", ExistenceChecker.isSet((Quantity47Choice__1) o.getDlvryCpcty()))
				.put("qtyUnit", ExistenceChecker.isSet((EnergyQuantityUnit2Choice__1) o.getQtyUnit()))
				.put("pricTmIntrvlQty", ExistenceChecker.isSet((AmountAndDirection106__3) o.getPricTmIntrvlQty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EnergyDeliveryAttribute10__1", ValidationResult.ValidationType.ONLY_EXISTS, "EnergyDeliveryAttribute10__1", path, "");
		}
		return failure("EnergyDeliveryAttribute10__1", ValidationResult.ValidationType.ONLY_EXISTS, "EnergyDeliveryAttribute10__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
