package fpml.consolidated.repo.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.RelativePrice;
import fpml.consolidated.repo.RelativePriceChoice;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RelativePriceOnlyExistsValidator implements ValidatorWithArg<RelativePrice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RelativePrice> ValidationResult<RelativePrice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("spread", ExistenceChecker.isSet((BigDecimal) o.getSpread()))
				.put("relativePriceChoice", ExistenceChecker.isSet((List<? extends RelativePriceChoice>) o.getRelativePriceChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RelativePrice", ValidationResult.ValidationType.ONLY_EXISTS, "RelativePrice", path, "");
		}
		return failure("RelativePrice", ValidationResult.ValidationType.ONLY_EXISTS, "RelativePrice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
