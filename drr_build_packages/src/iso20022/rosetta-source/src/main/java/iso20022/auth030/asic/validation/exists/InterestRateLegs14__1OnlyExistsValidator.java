package iso20022.auth030.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.asic.InterestRate33Choice__1;
import iso20022.auth030.asic.InterestRate33Choice__2;
import iso20022.auth030.asic.InterestRateLegs14__1;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestRateLegs14__1OnlyExistsValidator implements ValidatorWithArg<InterestRateLegs14__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestRateLegs14__1> ValidationResult<InterestRateLegs14__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("frstLeg", ExistenceChecker.isSet((InterestRate33Choice__1) o.getFrstLeg()))
				.put("scndLeg", ExistenceChecker.isSet((InterestRate33Choice__2) o.getScndLeg()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestRateLegs14__1", ValidationResult.ValidationType.ONLY_EXISTS, "InterestRateLegs14__1", path, "");
		}
		return failure("InterestRateLegs14__1", ValidationResult.ValidationType.ONLY_EXISTS, "InterestRateLegs14__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
