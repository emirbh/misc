package cdm.observable.asset.fro.validation.exists;

import cdm.observable.asset.fro.ContractualDefinition;
import cdm.observable.asset.fro.FloatingRateIndexCalculationDefaults;
import cdm.observable.asset.fro.FloatingRateIndexDefinition;
import cdm.observable.asset.fro.FloatingRateIndexExternalMappings;
import cdm.observable.asset.fro.FloatingRateIndexIdentification;
import cdm.observable.asset.fro.FloatingRateIndexMappings;
import cdm.observable.asset.fro.FroHistory;
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

public class FloatingRateIndexDefinitionOnlyExistsValidator implements ValidatorWithArg<FloatingRateIndexDefinition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FloatingRateIndexDefinition> ValidationResult<FloatingRateIndexDefinition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fro", ExistenceChecker.isSet((FloatingRateIndexIdentification) o.getFro()))
				.put("calculationDefaults", ExistenceChecker.isSet((FloatingRateIndexCalculationDefaults) o.getCalculationDefaults()))
				.put("supportedDefinition", ExistenceChecker.isSet((List<? extends ContractualDefinition>) o.getSupportedDefinition()))
				.put("definitionalSource", ExistenceChecker.isSet((String) o.getDefinitionalSource()))
				.put("designatedMaturityApplicable", ExistenceChecker.isSet((Boolean) o.getDesignatedMaturityApplicable()))
				.put("mappings", ExistenceChecker.isSet((FloatingRateIndexMappings) o.getMappings()))
				.put("externalMappings", ExistenceChecker.isSet((FloatingRateIndexExternalMappings) o.getExternalMappings()))
				.put("inLoan", ExistenceChecker.isSet((Boolean) o.getInLoan()))
				.put("history", ExistenceChecker.isSet((FroHistory) o.getHistory()))
				.put("deprecationReason", ExistenceChecker.isSet((String) o.getDeprecationReason()))
				.put("fpmlDescription", ExistenceChecker.isSet((String) o.getFpmlDescription()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateIndexDefinition", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexDefinition", path, "");
		}
		return failure("FloatingRateIndexDefinition", ValidationResult.ValidationType.ONLY_EXISTS, "FloatingRateIndexDefinition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
