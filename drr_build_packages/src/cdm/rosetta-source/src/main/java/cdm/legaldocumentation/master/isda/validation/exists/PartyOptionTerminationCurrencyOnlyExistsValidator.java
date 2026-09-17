package cdm.legaldocumentation.master.isda.validation.exists;

import cdm.legaldocumentation.common.TerminationCurrencyConditionEnum;
import cdm.legaldocumentation.master.isda.PartyOptionTerminationCurrency;
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

public class PartyOptionTerminationCurrencyOnlyExistsValidator implements ValidatorWithArg<PartyOptionTerminationCurrency, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyOptionTerminationCurrency> ValidationResult<PartyOptionTerminationCurrency> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("bothAffectedTermCurrencyOption", ExistenceChecker.isSet((String) o.getBothAffectedTermCurrencyOption()))
				.put("terminationCurrencySpecifiedCondition", ExistenceChecker.isSet((String) o.getTerminationCurrencySpecifiedCondition()))
				.put("terminationCurrencyCondition", ExistenceChecker.isSet((TerminationCurrencyConditionEnum) o.getTerminationCurrencyCondition()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyOptionTerminationCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "PartyOptionTerminationCurrency", path, "");
		}
		return failure("PartyOptionTerminationCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "PartyOptionTerminationCurrency", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
