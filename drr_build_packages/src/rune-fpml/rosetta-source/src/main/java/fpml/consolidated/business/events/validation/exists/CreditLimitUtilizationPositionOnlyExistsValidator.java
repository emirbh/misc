package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditLimitUtilizationPosition;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CreditLimitUtilizationPositionOnlyExistsValidator implements ValidatorWithArg<CreditLimitUtilizationPosition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CreditLimitUtilizationPosition> ValidationResult<CreditLimitUtilizationPosition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("short", ExistenceChecker.isSet((BigDecimal) o.getShort()))
				.put("long", ExistenceChecker.isSet((BigDecimal) o.getLong()))
				.put("global", ExistenceChecker.isSet((BigDecimal) o.getGlobal()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditLimitUtilizationPosition", ValidationResult.ValidationType.ONLY_EXISTS, "CreditLimitUtilizationPosition", path, "");
		}
		return failure("CreditLimitUtilizationPosition", ValidationResult.ValidationType.ONLY_EXISTS, "CreditLimitUtilizationPosition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
