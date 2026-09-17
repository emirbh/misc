package cdm.observable.asset.fro.validation.exists;

import cdm.base.staticdata.identifier.Identifier;
import cdm.observable.asset.fro.ContractualDefinition;
import cdm.observable.asset.fro.ContractualDefinitionIdentifier;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ContractualDefinitionOnlyExistsValidator implements ValidatorWithArg<ContractualDefinition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ContractualDefinition> ValidationResult<ContractualDefinition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet((Identifier) o.getIdentifier()))
				.put("contractualDefinitionIdentifier", ExistenceChecker.isSet((ContractualDefinitionIdentifier) o.getContractualDefinitionIdentifier()))
				.put("publicationDate", ExistenceChecker.isSet((Date) o.getPublicationDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ContractualDefinition", ValidationResult.ValidationType.ONLY_EXISTS, "ContractualDefinition", path, "");
		}
		return failure("ContractualDefinition", ValidationResult.ValidationType.ONLY_EXISTS, "ContractualDefinition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
