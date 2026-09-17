package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.FxHaircutCurrency;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxHaircutCurrencyOnlyExistsValidator implements ValidatorWithArg<FxHaircutCurrency, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxHaircutCurrency> ValidationResult<FxHaircutCurrency> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isTerminationCurrency", ExistenceChecker.isSet((Boolean) o.getIsTerminationCurrency()))
				.put("fxDesignatedCurrency", ExistenceChecker.isSet((FieldWithMetaString) o.getFxDesignatedCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxHaircutCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "FxHaircutCurrency", path, "");
		}
		return failure("FxHaircutCurrency", ValidationResult.ValidationType.ONLY_EXISTS, "FxHaircutCurrency", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
