package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.DateAndDateTime2Choice__1;
import iso20022.auth030.fca.DerivativeEvent6__2;
import iso20022.auth030.fca.DerivativeEventType3Code__1;
import iso20022.auth030.fca.EventIdentifier1Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DerivativeEvent6__2OnlyExistsValidator implements ValidatorWithArg<DerivativeEvent6__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DerivativeEvent6__2> ValidationResult<DerivativeEvent6__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tp", ExistenceChecker.isSet((DerivativeEventType3Code__1) o.getTp()))
				.put("id", ExistenceChecker.isSet((EventIdentifier1Choice__1) o.getId()))
				.put("tmStmp", ExistenceChecker.isSet((DateAndDateTime2Choice__1) o.getTmStmp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DerivativeEvent6__2", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativeEvent6__2", path, "");
		}
		return failure("DerivativeEvent6__2", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativeEvent6__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
