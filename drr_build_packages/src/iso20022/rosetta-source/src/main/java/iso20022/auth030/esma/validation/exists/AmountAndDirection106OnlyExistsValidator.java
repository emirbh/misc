package iso20022.auth030.esma.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd19DecimalAmount;
import iso20022.auth030.esma.AmountAndDirection106;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AmountAndDirection106OnlyExistsValidator implements ValidatorWithArg<AmountAndDirection106, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AmountAndDirection106> ValidationResult<AmountAndDirection106> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("amt", ExistenceChecker.isSet((ActiveOrHistoricCurrencyAnd19DecimalAmount) o.getAmt()))
				.put("sgn", ExistenceChecker.isSet((Boolean) o.getSgn()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AmountAndDirection106", ValidationResult.ValidationType.ONLY_EXISTS, "AmountAndDirection106", path, "");
		}
		return failure("AmountAndDirection106", ValidationResult.ValidationType.ONLY_EXISTS, "AmountAndDirection106", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
