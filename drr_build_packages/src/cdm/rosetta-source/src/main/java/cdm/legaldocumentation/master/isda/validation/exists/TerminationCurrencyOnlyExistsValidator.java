package cdm.legaldocumentation.master.isda.validation.exists;

import cdm.legaldocumentation.master.isda.PartyOptionTerminationCurrency;
import cdm.legaldocumentation.master.isda.TerminationCurrency;
import cdm.legaldocumentation.master.isda.TerminationCurrencySelection;
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

public class TerminationCurrencyOnlyExistsValidator implements ValidatorWithArg<TerminationCurrency, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TerminationCurrency> ValidationResult<TerminationCurrency> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("statedTerminationCurrency", ExistenceChecker.isSet((TerminationCurrencySelection) o.getStatedTerminationCurrency()))
				.put("partyOptionTerminationCurrency", ExistenceChecker.isSet((PartyOptionTerminationCurrency) o.getPartyOptionTerminationCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TerminationCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "TerminationCurrency", path, "");
		}
		return failure("TerminationCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "TerminationCurrency", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
