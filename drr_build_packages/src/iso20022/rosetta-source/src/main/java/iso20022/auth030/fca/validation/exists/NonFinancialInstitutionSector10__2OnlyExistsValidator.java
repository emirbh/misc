package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.GenericIdentification175__1;
import iso20022.auth030.fca.NonFinancialInstitutionSector10__2;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonFinancialInstitutionSector10__2OnlyExistsValidator implements ValidatorWithArg<NonFinancialInstitutionSector10__2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonFinancialInstitutionSector10__2> ValidationResult<NonFinancialInstitutionSector10__2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("sctr", ExistenceChecker.isSet((List<? extends GenericIdentification175__1>) o.getSctr()))
				.put("clrThrshld", ExistenceChecker.isSet((Boolean) o.getClrThrshld()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonFinancialInstitutionSector10__2", ValidationResult.ValidationType.ONLY_EXISTS, "NonFinancialInstitutionSector10__2", path, "");
		}
		return failure("NonFinancialInstitutionSector10__2", ValidationResult.ValidationType.ONLY_EXISTS, "NonFinancialInstitutionSector10__2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
