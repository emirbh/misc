package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.ApplicableRegime;
import cdm.legaldocumentation.csa.Regime;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegimeOnlyExistsValidator implements ValidatorWithArg<Regime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Regime> ValidationResult<Regime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("applicableRegime", ExistenceChecker.isSet((List<? extends ApplicableRegime>) o.getApplicableRegime()))
				.put("fallbackToMandatoryMethodDays", ExistenceChecker.isSet((BigDecimal) o.getFallbackToMandatoryMethodDays()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Regime", ValidationResult.ValidationType.ONLY_EXISTS, "Regime", path, "");
		}
		return failure("Regime", ValidationResult.ValidationType.ONLY_EXISTS, "Regime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
