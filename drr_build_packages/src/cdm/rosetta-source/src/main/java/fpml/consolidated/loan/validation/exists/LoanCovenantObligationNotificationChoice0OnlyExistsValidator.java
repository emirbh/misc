package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice0;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanCovenantObligationNotificationChoice0OnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligationNotificationChoice0, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligationNotificationChoice0> ValidationResult<LoanCovenantObligationNotificationChoice0> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dealIdentifier", ExistenceChecker.isSet((DealIdentifier) o.getDealIdentifier()))
				.put("dealSummary", ExistenceChecker.isSet((DealSummary) o.getDealSummary()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligationNotificationChoice0", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationNotificationChoice0", path, "");
		}
		return failure("LoanCovenantObligationNotificationChoice0", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationNotificationChoice0", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
