package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.AmountAdjustmentEnum;
import fpml.consolidated.loan.Adjustment;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AdjustmentOnlyExistsValidator implements ValidatorWithArg<Adjustment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Adjustment> ValidationResult<Adjustment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("adjustmentType", ExistenceChecker.isSet((AmountAdjustmentEnum) o.getAdjustmentType()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Adjustment", ValidationResult.ValidationType.ONLY_EXISTS, "Adjustment", path, "");
		}
		return failure("Adjustment", ValidationResult.ValidationType.ONLY_EXISTS, "Adjustment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
