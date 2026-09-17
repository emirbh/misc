package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.PercentageTolerance;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PercentageToleranceOnlyExistsValidator implements ValidatorWithArg<PercentageTolerance, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PercentageTolerance> ValidationResult<PercentageTolerance> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("postitive", ExistenceChecker.isSet((BigDecimal) o.getPostitive()))
				.put("negative", ExistenceChecker.isSet((BigDecimal) o.getNegative()))
				.put("option", ExistenceChecker.isSet((PartyReference) o.getOption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PercentageTolerance", ValidationResult.ValidationType.ONLY_EXISTS, "PercentageTolerance", path, "");
		}
		return failure("PercentageTolerance", ValidationResult.ValidationType.ONLY_EXISTS, "PercentageTolerance", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
