package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.Direction2;
import iso20022.auth030.jfsa.Direction4Choice;
import iso20022.auth030.jfsa.OptionParty1Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class Direction4ChoiceOnlyExistsValidator implements ValidatorWithArg<Direction4Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Direction4Choice> ValidationResult<Direction4Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("drctn", ExistenceChecker.isSet((Direction2) o.getDrctn()))
				.put("ctrPtySd", ExistenceChecker.isSet((OptionParty1Code) o.getCtrPtySd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Direction4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "Direction4Choice", path, "");
		}
		return failure("Direction4Choice", ValidationResult.ValidationType.ONLY_EXISTS, "Direction4Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
