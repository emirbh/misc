package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.NonFinancialSector;
import drr.regulation.common.NonFinancialSectorEnum;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonFinancialSectorOnlyExistsValidator implements ValidatorWithArg<NonFinancialSector, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonFinancialSector> ValidationResult<NonFinancialSector> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("ordinal", ExistenceChecker.isSet((Integer) o.getOrdinal()))
				.put("nonFinancialSectorIndicator", ExistenceChecker.isSet((NonFinancialSectorEnum) o.getNonFinancialSectorIndicator()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonFinancialSector", ValidationResult.ValidationType.ONLY_EXISTS, "NonFinancialSector", path, "");
		}
		return failure("NonFinancialSector", ValidationResult.ValidationType.ONLY_EXISTS, "NonFinancialSector", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
