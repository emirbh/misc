package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.LoanLegalActionNotificationChoice1;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice0;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice1;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice2;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanLegalActionNotificationChoice1OnlyExistsValidator implements ValidatorWithArg<LoanLegalActionNotificationChoice1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanLegalActionNotificationChoice1> ValidationResult<LoanLegalActionNotificationChoice1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dealIdentifier", ExistenceChecker.isSet((DealIdentifier) o.getDealIdentifier()))
				.put("dealSummary", ExistenceChecker.isSet((DealSummary) o.getDealSummary()))
				.put("loanLegalActionNotificationChoiceChoice0", ExistenceChecker.isSet((List<? extends LoanLegalActionNotificationChoiceChoice0>) o.getLoanLegalActionNotificationChoiceChoice0()))
				.put("loanLegalActionNotificationChoiceChoice1", ExistenceChecker.isSet((List<? extends LoanLegalActionNotificationChoiceChoice1>) o.getLoanLegalActionNotificationChoiceChoice1()))
				.put("loanLegalActionNotificationChoiceChoice2", ExistenceChecker.isSet((List<? extends LoanLegalActionNotificationChoiceChoice2>) o.getLoanLegalActionNotificationChoiceChoice2()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanLegalActionNotificationChoice1", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionNotificationChoice1", path, "");
		}
		return failure("LoanLegalActionNotificationChoice1", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionNotificationChoice1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
