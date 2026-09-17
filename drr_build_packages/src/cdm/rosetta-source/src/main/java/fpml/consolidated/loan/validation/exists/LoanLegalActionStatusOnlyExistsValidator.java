package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionReference;
import fpml.consolidated.loan.LoanLegalActionStatus;
import fpml.consolidated.loan.LoanLegalActionStatusType;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanLegalActionStatusOnlyExistsValidator implements ValidatorWithArg<LoanLegalActionStatus, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanLegalActionStatus> ValidationResult<LoanLegalActionStatus> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("legalActionReference", ExistenceChecker.isSet((LoanLegalActionReference) o.getLegalActionReference()))
				.put("type", ExistenceChecker.isSet((LoanLegalActionStatusType) o._getType()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanLegalActionStatus", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionStatus", path, "");
		}
		return failure("LoanLegalActionStatus", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionStatus", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
