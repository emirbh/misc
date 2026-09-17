package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationCategoryType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanCovenantObligationCategoryTypeOnlyExistsValidator implements ValidatorWithArg<LoanCovenantObligationCategoryType, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanCovenantObligationCategoryType> ValidationResult<LoanCovenantObligationCategoryType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("loanCovenantObligationCategoryTypeScheme", ExistenceChecker.isSet((String) o.getLoanCovenantObligationCategoryTypeScheme()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanCovenantObligationCategoryType", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationCategoryType", path, "");
		}
		return failure("LoanCovenantObligationCategoryType", ValidationResult.ValidationType.ONLY_EXISTS, "LoanCovenantObligationCategoryType", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
