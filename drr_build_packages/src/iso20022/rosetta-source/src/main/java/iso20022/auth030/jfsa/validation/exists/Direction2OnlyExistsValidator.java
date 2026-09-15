package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.Direction2;
import iso20022.auth030.jfsa.OptionParty3Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class Direction2OnlyExistsValidator implements ValidatorWithArg<Direction2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Direction2> ValidationResult<Direction2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("drctnOfTheFrstLeg", ExistenceChecker.isSet((OptionParty3Code) o.getDrctnOfTheFrstLeg()))
				.put("drctnOfTheScndLeg", ExistenceChecker.isSet((OptionParty3Code) o.getDrctnOfTheScndLeg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Direction2", ValidationResult.ValidationType.ONLY_EXISTS, "Direction2", path, "");
		}
		return failure("Direction2", ValidationResult.ValidationType.ONLY_EXISTS, "Direction2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
