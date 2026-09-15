package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.DiscountingTypeEnum;
import fpml.consolidated.ird.Discounting;
import fpml.consolidated.shared.DayCountFraction;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DiscountingOnlyExistsValidator implements ValidatorWithArg<Discounting, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Discounting> ValidationResult<Discounting> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("discountingType", ExistenceChecker.isSet((DiscountingTypeEnum) o.getDiscountingType()))
				.put("discountRate", ExistenceChecker.isSet((BigDecimal) o.getDiscountRate()))
				.put("discountRateDayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDiscountRateDayCountFraction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Discounting", ValidationResult.ValidationType.ONLY_EXISTS, "Discounting", path, "");
		}
		return failure("Discounting", ValidationResult.ValidationType.ONLY_EXISTS, "Discounting", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
