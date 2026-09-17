package cdm.legaldocumentation.master.isda.validation.exists;

import cdm.legaldocumentation.master.isda.PartyTerminationCurrencySelection;
import cdm.legaldocumentation.master.isda.TerminationCurrencySelection;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TerminationCurrencySelectionOnlyExistsValidator implements ValidatorWithArg<TerminationCurrencySelection, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TerminationCurrencySelection> ValidationResult<TerminationCurrencySelection> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("statedCurrency", ExistenceChecker.isSet((String) o.getStatedCurrency()))
				.put("fallbackCurrency", ExistenceChecker.isSet((String) o.getFallbackCurrency()))
				.put("partyElection", ExistenceChecker.isSet((List<? extends PartyTerminationCurrencySelection>) o.getPartyElection()))
				.put("bothAffected", ExistenceChecker.isSet((String) o.getBothAffected()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TerminationCurrencySelection", ValidationResult.ValidationType.ONLY_EXISTS, "TerminationCurrencySelection", path, "");
		}
		return failure("TerminationCurrencySelection", ValidationResult.ValidationType.ONLY_EXISTS, "TerminationCurrencySelection", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
