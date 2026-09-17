package cdm.observable.asset.fro.validation.exists;

import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import cdm.observable.asset.fro.ContractualDefinitionIdentifier;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ContractualDefinitionIdentifierOnlyExistsValidator implements ValidatorWithArg<ContractualDefinitionIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ContractualDefinitionIdentifier> ValidationResult<ContractualDefinitionIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("contractualDefinitionType", ExistenceChecker.isSet((ContractualDefinitionsEnum) o.getContractualDefinitionType()))
				.put("contractualDefinitionVersion", ExistenceChecker.isSet((String) o.getContractualDefinitionVersion()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ContractualDefinitionIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "ContractualDefinitionIdentifier", path, "");
		}
		return failure("ContractualDefinitionIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "ContractualDefinitionIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
