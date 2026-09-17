package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalAttributeDecimal;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CoalAttributeDecimalOnlyExistsValidator implements ValidatorWithArg<CoalAttributeDecimal, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CoalAttributeDecimal> ValidationResult<CoalAttributeDecimal> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("standardContent", ExistenceChecker.isSet((BigDecimal) o.getStandardContent()))
				.put("rejectionLimit", ExistenceChecker.isSet((BigDecimal) o.getRejectionLimit()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CoalAttributeDecimal", ValidationResult.ValidationType.ONLY_EXISTS, "CoalAttributeDecimal", path, "");
		}
		return failure("CoalAttributeDecimal", ValidationResult.ValidationType.ONLY_EXISTS, "CoalAttributeDecimal", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
