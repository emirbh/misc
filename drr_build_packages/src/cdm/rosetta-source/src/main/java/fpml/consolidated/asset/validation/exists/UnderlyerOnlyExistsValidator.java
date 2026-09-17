package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Basket;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class UnderlyerOnlyExistsValidator implements ValidatorWithArg<Underlyer, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Underlyer> ValidationResult<Underlyer> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("singleUnderlyer", ExistenceChecker.isSet((SingleUnderlyer) o.getSingleUnderlyer()))
				.put("basket", ExistenceChecker.isSet((Basket) o.getBasket()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Underlyer", ValidationResult.ValidationType.ONLY_EXISTS, "Underlyer", path, "");
		}
		return failure("Underlyer", ValidationResult.ValidationType.ONLY_EXISTS, "Underlyer", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
