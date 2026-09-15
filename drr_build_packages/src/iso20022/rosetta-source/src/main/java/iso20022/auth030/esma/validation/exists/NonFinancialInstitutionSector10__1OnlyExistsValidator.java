package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.GenericIdentification175__1;
import iso20022.auth030.esma.NonFinancialInstitutionSector10__1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonFinancialInstitutionSector10__1OnlyExistsValidator implements ValidatorWithArg<NonFinancialInstitutionSector10__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonFinancialInstitutionSector10__1> ValidationResult<NonFinancialInstitutionSector10__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("sctr", ExistenceChecker.isSet((List<? extends GenericIdentification175__1>) o.getSctr()))
				.put("clrThrshld", ExistenceChecker.isSet((Boolean) o.getClrThrshld()))
				.put("drctlyLkdActvty", ExistenceChecker.isSet((Boolean) o.getDrctlyLkdActvty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonFinancialInstitutionSector10__1", ValidationResult.ValidationType.ONLY_EXISTS, "NonFinancialInstitutionSector10__1", path, "");
		}
		return failure("NonFinancialInstitutionSector10__1", ValidationResult.ValidationType.ONLY_EXISTS, "NonFinancialInstitutionSector10__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
