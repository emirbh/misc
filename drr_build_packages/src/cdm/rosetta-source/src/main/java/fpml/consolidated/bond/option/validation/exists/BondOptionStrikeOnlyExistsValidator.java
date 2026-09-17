package fpml.consolidated.bond.option.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.bond.option.BondOptionStrike;
import fpml.consolidated.bond.option.ReferenceSwapCurve;
import fpml.consolidated.option.shared.OptionStrike;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class BondOptionStrikeOnlyExistsValidator implements ValidatorWithArg<BondOptionStrike, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends BondOptionStrike> ValidationResult<BondOptionStrike> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("referenceSwapCurve", ExistenceChecker.isSet((ReferenceSwapCurve) o.getReferenceSwapCurve()))
				.put("price", ExistenceChecker.isSet((OptionStrike) o.getPrice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BondOptionStrike", ValidationResult.ValidationType.ONLY_EXISTS, "BondOptionStrike", path, "");
		}
		return failure("BondOptionStrike", ValidationResult.ValidationType.ONLY_EXISTS, "BondOptionStrike", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
