package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.FixedRate10__1;
import iso20022.auth030.fca.FloatingRate13__1;
import iso20022.auth030.fca.InterestRate33Choice__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestRate33Choice__1OnlyExistsValidator implements ValidatorWithArg<InterestRate33Choice__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestRate33Choice__1> ValidationResult<InterestRate33Choice__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxd", ExistenceChecker.isSet((FixedRate10__1) o.getFxd()))
				.put("fltg", ExistenceChecker.isSet((FloatingRate13__1) o.getFltg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestRate33Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "InterestRate33Choice__1", path, "");
		}
		return failure("InterestRate33Choice__1", ValidationResult.ValidationType.ONLY_EXISTS, "InterestRate33Choice__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
