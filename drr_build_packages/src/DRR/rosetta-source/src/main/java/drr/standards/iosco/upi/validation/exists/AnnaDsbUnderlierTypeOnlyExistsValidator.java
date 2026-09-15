package drr.standards.iosco.upi.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierType;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AnnaDsbUnderlierTypeOnlyExistsValidator implements ValidatorWithArg<AnnaDsbUnderlierType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AnnaDsbUnderlierType> ValidationResult<AnnaDsbUnderlierType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("UnderlierIDSource", ExistenceChecker.isSet((AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource()))
				.put("DebtSeniority", ExistenceChecker.isSet((AnnaDsbDebtSeniorityEnum) o.getDebtSeniority()))
				.put("UnderlyingInstrumentIndexTermValue", ExistenceChecker.isSet((Integer) o.getUnderlyingInstrumentIndexTermValue()))
				.put("UnderlyingCreditIndexSeries", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexSeries()))
				.put("UnderlierID", ExistenceChecker.isSet((String) o.getUnderlierID()))
				.put("UnderlyingInstrumentIndexTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit()))
				.put("UnderlyingCreditIndexVersion", ExistenceChecker.isSet((Integer) o.getUnderlyingCreditIndexVersion()))
				.put("ReferenceRateTermValue", ExistenceChecker.isSet((Integer) o.getReferenceRateTermValue()))
				.put("ReferenceRateTermUnit", ExistenceChecker.isSet((AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getReferenceRateTermUnit()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AnnaDsbUnderlierType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlierType", path, "");
		}
		return failure("AnnaDsbUnderlierType", ValidationResult.ValidationType.ONLY_EXISTS, "AnnaDsbUnderlierType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
