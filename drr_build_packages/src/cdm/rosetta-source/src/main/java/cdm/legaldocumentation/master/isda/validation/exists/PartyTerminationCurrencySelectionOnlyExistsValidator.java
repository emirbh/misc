package cdm.legaldocumentation.master.isda.validation.exists;

import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.master.isda.PartyTerminationCurrencySelection;
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

public class PartyTerminationCurrencySelectionOnlyExistsValidator implements ValidatorWithArg<PartyTerminationCurrencySelection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyTerminationCurrencySelection> ValidationResult<PartyTerminationCurrencySelection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet((Party) o.getParty()))
				.put("statedPartyCurrency", ExistenceChecker.isSet((String) o.getStatedPartyCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyTerminationCurrencySelection", ValidationResult.ValidationType.ONLY_EXISTS, "PartyTerminationCurrencySelection", path, "");
		}
		return failure("PartyTerminationCurrencySelection", ValidationResult.ValidationType.ONLY_EXISTS, "PartyTerminationCurrencySelection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
