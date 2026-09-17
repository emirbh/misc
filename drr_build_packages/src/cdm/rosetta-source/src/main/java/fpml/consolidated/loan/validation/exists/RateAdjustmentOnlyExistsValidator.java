package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.RateAdjustment;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RateAdjustmentOnlyExistsValidator implements ValidatorWithArg<RateAdjustment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RateAdjustment> ValidationResult<RateAdjustment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("margin", ExistenceChecker.isSet((BigDecimal) o.getMargin()))
				.put("pikSpread", ExistenceChecker.isSet((BigDecimal) o.getPikSpread()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RateAdjustment", ValidationResult.ValidationType.ONLY_EXISTS, "RateAdjustment", path, "");
		}
		return failure("RateAdjustment", ValidationResult.ValidationType.ONLY_EXISTS, "RateAdjustment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
