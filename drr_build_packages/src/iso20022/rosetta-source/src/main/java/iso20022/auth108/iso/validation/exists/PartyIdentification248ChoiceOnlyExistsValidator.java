package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.LegalPersonIdentification1;
import iso20022.auth108.iso.NaturalPersonIdentification3;
import iso20022.auth108.iso.PartyIdentification248Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PartyIdentification248ChoiceOnlyExistsValidator implements ValidatorWithArg<PartyIdentification248Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyIdentification248Choice> ValidationResult<PartyIdentification248Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("lgl", ExistenceChecker.isSet((LegalPersonIdentification1) o.getLgl()))
				.put("ntrl", ExistenceChecker.isSet((NaturalPersonIdentification3) o.getNtrl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyIdentification248Choice", ValidationResult.ValidationType.ONLY_EXISTS, "PartyIdentification248Choice", path, "");
		}
		return failure("PartyIdentification248Choice", ValidationResult.ValidationType.ONLY_EXISTS, "PartyIdentification248Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
