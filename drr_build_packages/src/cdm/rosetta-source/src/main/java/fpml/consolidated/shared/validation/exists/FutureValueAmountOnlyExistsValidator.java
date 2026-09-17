package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FutureValueAmount;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FutureValueAmountOnlyExistsValidator implements ValidatorWithArg<FutureValueAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FutureValueAmount> ValidationResult<FutureValueAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("amount", ExistenceChecker.isSet((BigDecimal) o.getAmount()))
				.put("calculationPeriodNumberOfDays", ExistenceChecker.isSet((Integer) o.getCalculationPeriodNumberOfDays()))
				.put("valueDate", ExistenceChecker.isSet((ZonedDateTime) o.getValueDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FutureValueAmount", ValidationResult.ValidationType.ONLY_EXISTS, "FutureValueAmount", path, "");
		}
		return failure("FutureValueAmount", ValidationResult.ValidationType.ONLY_EXISTS, "FutureValueAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
