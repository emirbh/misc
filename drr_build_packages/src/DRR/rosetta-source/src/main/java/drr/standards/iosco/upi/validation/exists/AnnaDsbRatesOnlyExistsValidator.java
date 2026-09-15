package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import drr.standards.iosco.upi.AnnaDsbRates;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbRatesOnlyExistsValidator implements ValidatorWithArg<AnnaDsbRates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbRates> ValidationResult<AnnaDsbRates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ReturnorPayoutTrigger", ExistenceChecker.isSet((AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger()))
				.put("ReferenceRate", ExistenceChecker.isSet((String) o.getReferenceRate()))
				.put("UnderlierCharacteristic", ExistenceChecker.isSet((String) o.getUnderlierCharacteristic()))
				.put("UnderlyingInstrumentISIN", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentISIN()))
				.put("OtherLegReferenceRateTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getOtherLegReferenceRateTermUnit()))
				.put("NotionalCurrency", ExistenceChecker.isSet((String) o.getNotionalCurrency()))
				.put("OtherLegUnderlying", ExistenceChecker.isSet((AnnaDsbOtherLegUnderlying) o.getOtherLegUnderlying()))
				.put("OtherNotionalCurrency", ExistenceChecker.isSet((String) o.getOtherNotionalCurrency()))
				.put("ReferenceRateTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getReferenceRateTermUnit()))
				.put("OtherLegReferenceRateTermValue", ExistenceChecker.isSet((Integer) o.getOtherLegReferenceRateTermValue()))
				.put("OtherLegReferenceRate", ExistenceChecker.isSet((String) o.getOtherLegReferenceRate()))
				.put("Underlying", ExistenceChecker.isSet((AnnaDsbUnderlying) o.getUnderlying()))
				.put("OtherLegUnderlierCharacteristic", ExistenceChecker.isSet((AnnaDsbUnderlierCharacteristicEnum) o.getOtherLegUnderlierCharacteristic()))
				.put("ReferenceRateTermValue", ExistenceChecker.isSet((Integer) o.getReferenceRateTermValue()))
				.put("UnderlierName", ExistenceChecker.isSet((String) o.getUnderlierName()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbRates", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbRates", path, "");
		}
		return failure("AnnaDsbRates", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbRates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
