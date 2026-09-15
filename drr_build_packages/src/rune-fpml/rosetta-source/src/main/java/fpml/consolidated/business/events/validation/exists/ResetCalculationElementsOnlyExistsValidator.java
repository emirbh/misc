package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CashflowFixing;
import fpml.consolidated.business.events.ResetCalculationElements;
import fpml.consolidated.business.events.ResetCalculationPeriod;
import fpml.consolidated.shared.CashflowNotional;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ResetCalculationElementsOnlyExistsValidator implements ValidatorWithArg<ResetCalculationElements, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ResetCalculationElements> ValidationResult<ResetCalculationElements> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notional", ExistenceChecker.isSet((CashflowNotional) o.getNotional()))
				.put("calculatedRate", ExistenceChecker.isSet((CashflowFixing) o.getCalculatedRate()))
				.put("calculationPeriod", ExistenceChecker.isSet((ResetCalculationPeriod) o.getCalculationPeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ResetCalculationElements", ValidationResult.ValidationType.ONLY_EXISTS, "ResetCalculationElements", path, "");
		}
		return failure("ResetCalculationElements", ValidationResult.ValidationType.ONLY_EXISTS, "ResetCalculationElements", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
