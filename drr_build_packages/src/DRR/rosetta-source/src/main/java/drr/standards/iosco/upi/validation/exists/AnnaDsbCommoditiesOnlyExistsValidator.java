package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbBaseProduct;
import drr.standards.iosco.upi.AnnaDsbCommodities;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlying;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbCommoditiesOnlyExistsValidator implements ValidatorWithArg<AnnaDsbCommodities, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbCommodities> ValidationResult<AnnaDsbCommodities> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ReturnorPayoutTrigger", ExistenceChecker.isSet((AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger()))
				.put("SubProduct", ExistenceChecker.isSet((String) o.getSubProduct()))
				.put("UnderlierCharacteristic", ExistenceChecker.isSet((AnnaDsbUnderlierCharacteristicEnum) o.getUnderlierCharacteristic()))
				.put("ReferenceRate", ExistenceChecker.isSet((String) o.getReferenceRate()))
				.put("AdditionalSubProduct", ExistenceChecker.isSet((String) o.getAdditionalSubProduct()))
				.put("OtherReferenceRate", ExistenceChecker.isSet((String) o.getOtherReferenceRate()))
				.put("NotionalCurrency", ExistenceChecker.isSet((String) o.getNotionalCurrency()))
				.put("OtherNotionalCurrency", ExistenceChecker.isSet((String) o.getOtherNotionalCurrency()))
				.put("OtherUnderlying", ExistenceChecker.isSet((AnnaDsbOtherUnderlying) o.getOtherUnderlying()))
				.put("OtherUnderlierCharacteristic", ExistenceChecker.isSet((AnnaDsbUnderlierCharacteristicEnum) o.getOtherUnderlierCharacteristic()))
				.put("OtherSubProduct", ExistenceChecker.isSet((String) o.getOtherSubProduct()))
				.put("Underlying", ExistenceChecker.isSet((AnnaDsbUnderlying) o.getUnderlying()))
				.put("OtherBaseProduct", ExistenceChecker.isSet((AnnaDsbBaseProduct) o.getOtherBaseProduct()))
				.put("UnderlyingInstrumentIndex", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndex()))
				.put("UnderlyingInstrumentIndexProp", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndexProp()))
				.put("BaseProduct", ExistenceChecker.isSet((AnnaDsbBaseProduct) o.getBaseProduct()))
				.put("UnderlierName", ExistenceChecker.isSet((String) o.getUnderlierName()))
				.put("OtherAdditionalSubProduct", ExistenceChecker.isSet((String) o.getOtherAdditionalSubProduct()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbCommodities", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbCommodities", path, "");
		}
		return failure("AnnaDsbCommodities", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbCommodities", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
