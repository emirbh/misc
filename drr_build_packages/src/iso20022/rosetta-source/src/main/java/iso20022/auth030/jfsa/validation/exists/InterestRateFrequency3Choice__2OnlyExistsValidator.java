package iso20022.auth030.jfsa.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.InterestRateContractTerm4;
import iso20022.auth030.jfsa.InterestRateFrequency3Choice__2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InterestRateFrequency3Choice__2OnlyExistsValidator implements ValidatorWithArg<InterestRateFrequency3Choice__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InterestRateFrequency3Choice__2> ValidationResult<InterestRateFrequency3Choice__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("term", ExistenceChecker.isSet((InterestRateContractTerm4) o.getTerm()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestRateFrequency3Choice__2", ValidationResult.ValidationType.ONLY_EXISTS, "InterestRateFrequency3Choice__2", path, "");
		}
		return failure("InterestRateFrequency3Choice__2", ValidationResult.ValidationType.ONLY_EXISTS, "InterestRateFrequency3Choice__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
