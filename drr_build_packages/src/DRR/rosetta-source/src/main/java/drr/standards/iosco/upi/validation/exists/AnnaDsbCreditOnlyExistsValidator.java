package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbCredit;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbCreditOnlyExistsValidator implements ValidatorWithArg<AnnaDsbCredit, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbCredit> ValidationResult<AnnaDsbCredit> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ReturnorPayoutTrigger", ExistenceChecker.isSet((AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger()))
				.put("UnderlierCharacteristic", ExistenceChecker.isSet((AnnaDsbUnderlierCharacteristicEnum) o.getUnderlierCharacteristic()))
				.put("DebtSeniority", ExistenceChecker.isSet((AnnaDsbDebtSeniorityEnum) o.getDebtSeniority()))
				.put("UnderlyingInstrumentIndexTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit()))
				.put("UnderlyingInstrumentISIN", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentISIN()))
				.put("UnderlyingCreditIndexVersion", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexVersion()))
				.put("UnderlyingInstrumentIndexTermValue", ExistenceChecker.isSet((Integer) o.getUnderlyingInstrumentIndexTermValue()))
				.put("UnderlyingCreditIndexSeries", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexSeries()))
				.put("Underlying", ExistenceChecker.isSet((AnnaDsbUnderlying) o.getUnderlying()))
				.put("UnderlyingInstrumentIndexProp", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndexProp()))
				.put("UnderlyingInstrumentIndex", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentIndex()))
				.put("UnderlierName", ExistenceChecker.isSet((String) o.getUnderlierName()))
				.put("UnderlyingInstrumentLEI", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentLEI()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbCredit", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbCredit", path, "");
		}
		return failure("AnnaDsbCredit", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbCredit", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
