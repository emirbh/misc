package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LetterOfCredit;
import fpml.consolidated.loan.LetterOfCreditSummary;
import fpml.consolidated.loan.LoanContractIdentifier;
import fpml.consolidated.loan.LoanLegalActionStatementChoice2;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanLegalActionStatementChoice2OnlyExistsValidator implements ValidatorWithArg<LoanLegalActionStatementChoice2, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanLegalActionStatementChoice2> ValidationResult<LoanLegalActionStatementChoice2> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("letterOfCreditIdentifier", ExistenceChecker.isSet((LoanContractIdentifier) o.getLetterOfCreditIdentifier()))
				.put("letterOfCreditSummary", ExistenceChecker.isSet((LetterOfCreditSummary) o.getLetterOfCreditSummary()))
				.put("letterOfCredit", ExistenceChecker.isSet((LetterOfCredit) o.getLetterOfCredit()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanLegalActionStatementChoice2", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionStatementChoice2", path, "");
		}
		return failure("LoanLegalActionStatementChoice2", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionStatementChoice2", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
