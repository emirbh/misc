package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.NetAndGross;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NetAndGrossOnlyExistsValidator implements ValidatorWithArg<NetAndGross, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NetAndGross> ValidationResult<NetAndGross> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("net", ExistenceChecker.isSet((BigDecimal) o.getNet()))
				.put("gross", ExistenceChecker.isSet((BigDecimal) o.getGross()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NetAndGross", ValidationResult.ValidationType.ONLY_EXISTS, "NetAndGross", path, "");
		}
		return failure("NetAndGross", ValidationResult.ValidationType.ONLY_EXISTS, "NetAndGross", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
