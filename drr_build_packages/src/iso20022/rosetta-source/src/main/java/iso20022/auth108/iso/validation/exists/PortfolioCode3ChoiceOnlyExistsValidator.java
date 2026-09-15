package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.NotApplicable1Code;
import iso20022.auth108.iso.PortfolioCode3Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PortfolioCode3ChoiceOnlyExistsValidator implements ValidatorWithArg<PortfolioCode3Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PortfolioCode3Choice> ValidationResult<PortfolioCode3Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cd", ExistenceChecker.isSet((String) o.getCd()))
				.put("noPrtfl", ExistenceChecker.isSet((NotApplicable1Code) o.getNoPrtfl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PortfolioCode3Choice", ValidationResult.ValidationType.ONLY_EXISTS, "PortfolioCode3Choice", path, "");
		}
		return failure("PortfolioCode3Choice", ValidationResult.ValidationType.ONLY_EXISTS, "PortfolioCode3Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
