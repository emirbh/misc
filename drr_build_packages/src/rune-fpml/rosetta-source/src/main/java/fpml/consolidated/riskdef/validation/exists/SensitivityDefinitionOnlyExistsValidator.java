package fpml.consolidated.riskdef.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.DerivativeFormula;
import fpml.consolidated.riskdef.PricingParameterDerivative;
import fpml.consolidated.riskdef.SensitivityDefinition;
import fpml.consolidated.riskdef.SensitivityDefinitionChoice;
import fpml.consolidated.riskdef.TimeDimension;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SensitivityDefinitionOnlyExistsValidator implements ValidatorWithArg<SensitivityDefinition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SensitivityDefinition> ValidationResult<SensitivityDefinition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("name", ExistenceChecker.isSet((String) o.getName()))
				.put("valuationScenarioReference", ExistenceChecker.isSet((ValuationScenarioReference) o.getValuationScenarioReference()))
				.put("partialDerivative", ExistenceChecker.isSet((List<? extends PricingParameterDerivative>) o.getPartialDerivative()))
				.put("formula", ExistenceChecker.isSet((DerivativeFormula) o.getFormula()))
				.put("term", ExistenceChecker.isSet((TimeDimension) o.getTerm()))
				.put("sensitivityDefinitionChoice", ExistenceChecker.isSet((List<? extends SensitivityDefinitionChoice>) o.getSensitivityDefinitionChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SensitivityDefinition", ValidationResult.ValidationType.ONLY_EXISTS, "SensitivityDefinition", path, "");
		}
		return failure("SensitivityDefinition", ValidationResult.ValidationType.ONLY_EXISTS, "SensitivityDefinition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
