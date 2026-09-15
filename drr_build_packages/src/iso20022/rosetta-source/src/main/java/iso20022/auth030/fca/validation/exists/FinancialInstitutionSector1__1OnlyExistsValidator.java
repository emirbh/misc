package iso20022.auth030.fca.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.FinancialInstitutionSector1__1;
import iso20022.auth030.fca.FinancialPartyClassification2Choice__1;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FinancialInstitutionSector1__1OnlyExistsValidator implements ValidatorWithArg<FinancialInstitutionSector1__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FinancialInstitutionSector1__1> ValidationResult<FinancialInstitutionSector1__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("sctr", ExistenceChecker.isSet((List<? extends FinancialPartyClassification2Choice__1>) o.getSctr()))
				.put("clrThrshld", ExistenceChecker.isSet((Boolean) o.getClrThrshld()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FinancialInstitutionSector1__1", ValidationResult.ValidationType.ONLY_EXISTS, "FinancialInstitutionSector1__1", path, "");
		}
		return failure("FinancialInstitutionSector1__1", ValidationResult.ValidationType.ONLY_EXISTS, "FinancialInstitutionSector1__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
