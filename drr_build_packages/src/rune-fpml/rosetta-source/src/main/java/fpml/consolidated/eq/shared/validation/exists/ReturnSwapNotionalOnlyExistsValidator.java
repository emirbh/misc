package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.DeterminationMethodReference;
import fpml.consolidated.shared.NotionalAmount;
import fpml.consolidated.shared.ReturnSwapNotionalAmountReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnSwapNotionalOnlyExistsValidator implements ValidatorWithArg<ReturnSwapNotional, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnSwapNotional> ValidationResult<ReturnSwapNotional> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("relativeNotionalAmount", ExistenceChecker.isSet((ReturnSwapNotionalAmountReference) o.getRelativeNotionalAmount()))
				.put("relativeDeterminationMethod", ExistenceChecker.isSet((DeterminationMethodReference) o.getRelativeDeterminationMethod()))
				.put("determinationMethod", ExistenceChecker.isSet((DeterminationMethod) o.getDeterminationMethod()))
				.put("notionalAmount", ExistenceChecker.isSet((NotionalAmount) o.getNotionalAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnSwapNotional", ValidationResult.ValidationType.ONLY_EXISTS, "ReturnSwapNotional", path, "");
		}
		return failure("ReturnSwapNotional", ValidationResult.ValidationType.ONLY_EXISTS, "ReturnSwapNotional", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
