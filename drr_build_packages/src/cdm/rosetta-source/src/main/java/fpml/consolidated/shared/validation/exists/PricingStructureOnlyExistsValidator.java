package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PricingStructure;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PricingStructureOnlyExistsValidator implements ValidatorWithArg<PricingStructure, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PricingStructure> ValidationResult<PricingStructure> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PricingStructure", ValidationResult.ValidationType.ONLY_EXISTS, "PricingStructure", path, "");
		}
		return failure("PricingStructure", ValidationResult.ValidationType.ONLY_EXISTS, "PricingStructure", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
