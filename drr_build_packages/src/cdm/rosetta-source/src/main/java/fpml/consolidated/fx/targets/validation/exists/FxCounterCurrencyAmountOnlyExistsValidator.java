package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.fx.targets.FxStrikeReference;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.NonNegativeStep;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxCounterCurrencyAmountOnlyExistsValidator implements ValidatorWithArg<FxCounterCurrencyAmount, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxCounterCurrencyAmount> ValidationResult<FxCounterCurrencyAmount> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("initialValue", ExistenceChecker.isSet((BigDecimal) o.getInitialValue()))
				.put("step", ExistenceChecker.isSet((List<? extends NonNegativeStep>) o.getStep()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("strikeReference", ExistenceChecker.isSet((FxStrikeReference) o.getStrikeReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxCounterCurrencyAmount", ValidationResult.ValidationType.ONLY_EXISTS, "FxCounterCurrencyAmount", path, "");
		}
		return failure("FxCounterCurrencyAmount", ValidationResult.ValidationType.ONLY_EXISTS, "FxCounterCurrencyAmount", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
