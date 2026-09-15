package fpml.consolidated.riskdef.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.DerivativeCalculationMethod;
import fpml.consolidated.riskdef.DerivativeCalculationProcedure;
import fpml.consolidated.riskdef.PerturbationType;
import fpml.consolidated.shared.PricingStructureReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DerivativeCalculationProcedureOnlyExistsValidator implements ValidatorWithArg<DerivativeCalculationProcedure, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DerivativeCalculationProcedure> ValidationResult<DerivativeCalculationProcedure> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("method", ExistenceChecker.isSet((DerivativeCalculationMethod) o.getMethod()))
				.put("perturbationAmount", ExistenceChecker.isSet((BigDecimal) o.getPerturbationAmount()))
				.put("averaged", ExistenceChecker.isSet((Boolean) o.getAveraged()))
				.put("perturbationType", ExistenceChecker.isSet((PerturbationType) o.getPerturbationType()))
				.put("derivativeFormula", ExistenceChecker.isSet((String) o.getDerivativeFormula()))
				.put("replacementMarketInput", ExistenceChecker.isSet((PricingStructureReference) o.getReplacementMarketInput()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DerivativeCalculationProcedure", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativeCalculationProcedure", path, "");
		}
		return failure("DerivativeCalculationProcedure", ValidationResult.ValidationType.ONLY_EXISTS, "DerivativeCalculationProcedure", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
