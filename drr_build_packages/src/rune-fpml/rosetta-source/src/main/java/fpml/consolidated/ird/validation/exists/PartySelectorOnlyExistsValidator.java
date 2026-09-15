package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.PartyDeterminationEnum;
import fpml.consolidated.ird.PartySelector;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartySelectorOnlyExistsValidator implements ValidatorWithArg<PartySelector, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartySelector> ValidationResult<PartySelector> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("partyDetermination", ExistenceChecker.isSet((PartyDeterminationEnum) o.getPartyDetermination()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartySelector", ValidationResult.ValidationType.ONLY_EXISTS, "PartySelector", path, "");
		}
		return failure("PartySelector", ValidationResult.ValidationType.ONLY_EXISTS, "PartySelector", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
