package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbOther;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbOtherOnlyExistsValidator implements ValidatorWithArg<AnnaDsbOther, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbOther> ValidationResult<AnnaDsbOther> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("UnderlierIDSource", ExistenceChecker.isSet((AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource()))
				.put("DebtSeniority", ExistenceChecker.isSet((AnnaDsbDebtSeniorityEnum) o.getDebtSeniority()))
				.put("UnderlyingInstrumentIndexTermValue", ExistenceChecker.isSet((Integer) o.getUnderlyingInstrumentIndexTermValue()))
				.put("UnderlyingCreditIndexSeries", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexSeries()))
				.put("UnderlierID", ExistenceChecker.isSet((String) o.getUnderlierID()))
				.put("UnderlyingInstrumentIndexTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit()))
				.put("UnderlyingCreditIndexVersion", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexVersion()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbOther", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbOther", path, "");
		}
		return failure("AnnaDsbOther", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbOther", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
