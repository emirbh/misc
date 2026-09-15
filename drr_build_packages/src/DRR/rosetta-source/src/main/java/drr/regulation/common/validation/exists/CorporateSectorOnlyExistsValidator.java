package drr.regulation.common.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.CorporateSector;
import drr.regulation.common.FinancialSectorEnum;
import drr.regulation.common.NonFinancialSector;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CorporateSectorOnlyExistsValidator implements ValidatorWithArg<CorporateSector, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CorporateSector> ValidationResult<CorporateSector> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("financialSector", ExistenceChecker.isSet((List<FinancialSectorEnum>) o.getFinancialSector()))
				.put("nonFinancialSector", ExistenceChecker.isSet((List<? extends NonFinancialSector>) o.getNonFinancialSector()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CorporateSector", ValidationResult.ValidationType.ONLY_EXISTS, "CorporateSector", path, "");
		}
		return failure("CorporateSector", ValidationResult.ValidationType.ONLY_EXISTS, "CorporateSector", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
