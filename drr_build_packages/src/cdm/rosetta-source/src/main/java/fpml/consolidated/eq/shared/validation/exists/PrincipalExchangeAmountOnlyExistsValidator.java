package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.PrincipalExchangeAmount;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PrincipalExchangeAmountOnlyExistsValidator implements ValidatorWithArg<PrincipalExchangeAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PrincipalExchangeAmount> ValidationResult<PrincipalExchangeAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amountRelativeTo", ExistenceChecker.isSet((AmountReference) o.getAmountRelativeTo()))
				.put("determinationMethod", ExistenceChecker.isSet((DeterminationMethod) o.getDeterminationMethod()))
				.put("principalAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPrincipalAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PrincipalExchangeAmount", ValidationResult.ValidationType.ONLY_EXISTS, "PrincipalExchangeAmount", path, "");
		}
		return failure("PrincipalExchangeAmount", ValidationResult.ValidationType.ONLY_EXISTS, "PrincipalExchangeAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
