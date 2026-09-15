package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.DerivativePartyIdentification1Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DerivativePartyIdentification1ChoiceOnlyExistsValidator implements ValidatorWithArg<DerivativePartyIdentification1Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DerivativePartyIdentification1Choice> ValidationResult<DerivativePartyIdentification1Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ctry", ExistenceChecker.isSet((String) o.getCtry()))
				.put("ctrySubDvsn", ExistenceChecker.isSet((String) o.getCtrySubDvsn()))
				.put("lei", ExistenceChecker.isSet((String) o.getLei()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DerivativePartyIdentification1Choice", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativePartyIdentification1Choice", path, "");
		}
		return failure("DerivativePartyIdentification1Choice", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativePartyIdentification1Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
