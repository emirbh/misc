package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.GenericIdentification175;
import iso20022.auth108.iso.NonFinancialInstitutionSector10;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonFinancialInstitutionSector10OnlyExistsValidator implements ValidatorWithArg<NonFinancialInstitutionSector10, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonFinancialInstitutionSector10> ValidationResult<NonFinancialInstitutionSector10> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("sctr", ExistenceChecker.isSet((List<? extends GenericIdentification175>) o.getSctr()))
				.put("clrThrshld", ExistenceChecker.isSet((Boolean) o.getClrThrshld()))
				.put("drctlyLkdActvty", ExistenceChecker.isSet((Boolean) o.getDrctlyLkdActvty()))
				.put("fdrlInstn", ExistenceChecker.isSet((Boolean) o.getFdrlInstn()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonFinancialInstitutionSector10", ValidationResult.ValidationType.ONLY_EXISTS, "NonFinancialInstitutionSector10", path, "");
		}
		return failure("NonFinancialInstitutionSector10", ValidationResult.ValidationType.ONLY_EXISTS, "NonFinancialInstitutionSector10", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
