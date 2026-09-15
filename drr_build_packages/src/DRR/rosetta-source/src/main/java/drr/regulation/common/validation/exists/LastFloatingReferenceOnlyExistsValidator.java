package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.LastFloatingReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LastFloatingReferenceOnlyExistsValidator implements ValidatorWithArg<LastFloatingReference, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LastFloatingReference> ValidationResult<LastFloatingReference> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("lastFloatingReferenceResetDateLeg1", ExistenceChecker.isSet((Date) o.getLastFloatingReferenceResetDateLeg1()))
				.put("lastFloatingReferenceResetDateLeg2", ExistenceChecker.isSet((Date) o.getLastFloatingReferenceResetDateLeg2()))
				.put("lastFloatingReferenceValueLeg1", ExistenceChecker.isSet((BigDecimal) o.getLastFloatingReferenceValueLeg1()))
				.put("lastFloatingReferenceValueLeg2", ExistenceChecker.isSet((BigDecimal) o.getLastFloatingReferenceValueLeg2()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LastFloatingReference", ValidationResult.ValidationType.ONLY_EXISTS, "LastFloatingReference", path, "");
		}
		return failure("LastFloatingReference", ValidationResult.ValidationType.ONLY_EXISTS, "LastFloatingReference", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
