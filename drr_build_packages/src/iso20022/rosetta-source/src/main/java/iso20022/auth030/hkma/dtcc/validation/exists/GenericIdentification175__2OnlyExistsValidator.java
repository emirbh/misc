package iso20022.auth030.hkma.dtcc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.GenericIdentification175__2;
import iso20022.auth030.hkma.dtcc.HKTRPartyScheme;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericIdentification175__2OnlyExistsValidator implements ValidatorWithArg<GenericIdentification175__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericIdentification175__2> ValidationResult<GenericIdentification175__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("schmeNm", ExistenceChecker.isSet((HKTRPartyScheme) o.getSchmeNm()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericIdentification175__2", ValidationResult.ValidationType.ONLY_EXISTS, "GenericIdentification175__2", path, "");
		}
		return failure("GenericIdentification175__2", ValidationResult.ValidationType.ONLY_EXISTS, "GenericIdentification175__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
