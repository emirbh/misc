package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationDueDate;
import fpml.consolidated.shared.DateOffset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanCovenantObligationDueDateOnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligationDueDate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligationDueDate> ValidationResult<LoanCovenantObligationDueDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("specificDate", ExistenceChecker.isSet((ZonedDateTime) o.getSpecificDate()))
				.put("dateOffset", ExistenceChecker.isSet((DateOffset) o.getDateOffset()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligationDueDate", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationDueDate", path, "");
		}
		return failure("LoanCovenantObligationDueDate", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationDueDate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
