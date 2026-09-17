package cdm.observable.asset.fro.validation.exists;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.identifier.Identifier;
import cdm.observable.asset.fro.ContractualDefinitionIdentifier;
import cdm.observable.asset.fro.FloatingRateIndexMap;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FloatingRateIndexMapOnlyExistsValidator implements ValidatorWithArg<FloatingRateIndexMap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateIndexMap> ValidationResult<FloatingRateIndexMap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("index", ExistenceChecker.isSet((List<FloatingRateIndexEnum>) o.getIndex()))
				.put("contractualDefinitionIdentifier", ExistenceChecker.isSet((ContractualDefinitionIdentifier) o.getContractualDefinitionIdentifier()))
				.put("identifier", ExistenceChecker.isSet((Identifier) o.getIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateIndexMap", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexMap", path, "");
		}
		return failure("FloatingRateIndexMap", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexMap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
