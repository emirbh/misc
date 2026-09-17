package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.AmendmentEffectiveDate;
import cdm.legaldocumentation.csa.AmendmentEffectiveDateEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AmendmentEffectiveDateOnlyExistsValidator implements ValidatorWithArg<AmendmentEffectiveDate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AmendmentEffectiveDate> ValidationResult<AmendmentEffectiveDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("date", ExistenceChecker.isSet((Date) o.getDate()))
				.put("specificDate", ExistenceChecker.isSet((AmendmentEffectiveDateEnum) o.getSpecificDate()))
				.put("customProvision", ExistenceChecker.isSet((String) o.getCustomProvision()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AmendmentEffectiveDate", ValidationResult.ValidationType.ONLY_EXISTS, "AmendmentEffectiveDate", path, "");
		}
		return failure("AmendmentEffectiveDate", ValidationResult.ValidationType.ONLY_EXISTS, "AmendmentEffectiveDate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
