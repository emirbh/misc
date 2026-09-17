package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CustodianEvent;
import cdm.legaldocumentation.csa.CustodianEventEndDate;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CustodianEventOnlyExistsValidator implements ValidatorWithArg<CustodianEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CustodianEvent> ValidationResult<CustodianEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isApplicable", ExistenceChecker.isSet((Boolean) o.getIsApplicable()))
				.put("endDate", ExistenceChecker.isSet((CustodianEventEndDate) o.getEndDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CustodianEvent", ValidationResult.ValidationType.ONLY_EXISTS, "CustodianEvent", path, "");
		}
		return failure("CustodianEvent", ValidationResult.ValidationType.ONLY_EXISTS, "CustodianEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
