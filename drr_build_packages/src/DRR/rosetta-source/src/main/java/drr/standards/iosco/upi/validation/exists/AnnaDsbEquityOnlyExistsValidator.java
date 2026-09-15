package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbEquity;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbEquityOnlyExistsValidator implements ValidatorWithArg<AnnaDsbEquity, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbEquity> ValidationResult<AnnaDsbEquity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ReturnorPayoutTrigger", ExistenceChecker.isSet((AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger()))
				.put("UnderlierCharacteristic", ExistenceChecker.isSet((AnnaDsbUnderlierCharacteristicEnum) o.getUnderlierCharacteristic()))
				.put("Underlying", ExistenceChecker.isSet((AnnaDsbUnderlying) o.getUnderlying()))
				.put("UnderlyingInstrumentISIN", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentISIN()))
				.put("UnderlyingInstrumentIndex", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndex()))
				.put("UnderlyingInstrumentIndexProp", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndexProp()))
				.put("UnderlierName", ExistenceChecker.isSet((String) o.getUnderlierName()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbEquity", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbEquity", path, "");
		}
		return failure("AnnaDsbEquity", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbEquity", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
