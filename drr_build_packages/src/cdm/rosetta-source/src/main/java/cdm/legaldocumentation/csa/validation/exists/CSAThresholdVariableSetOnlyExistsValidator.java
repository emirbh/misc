package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CSAThresholdVariableSet;
import cdm.observable.asset.CreditRatingAgencyEnum;
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

public class CSAThresholdVariableSetOnlyExistsValidator implements ValidatorWithArg<CSAThresholdVariableSet, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CSAThresholdVariableSet> ValidationResult<CSAThresholdVariableSet> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("name", ExistenceChecker.isSet((CreditRatingAgencyEnum) o.getName()))
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("amount", ExistenceChecker.isSet((Integer) o.getAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CSAThresholdVariableSet", ValidationResult.ValidationType.ONLY_EXISTS, "CSAThresholdVariableSet", path, "");
		}
		return failure("CSAThresholdVariableSet", ValidationResult.ValidationType.ONLY_EXISTS, "CSAThresholdVariableSet", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
