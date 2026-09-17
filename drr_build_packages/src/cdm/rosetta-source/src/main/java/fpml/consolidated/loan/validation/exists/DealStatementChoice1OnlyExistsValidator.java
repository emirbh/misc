package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import fpml.consolidated.loan.DealStatementChoice1;
import fpml.consolidated.loan.LoanCovenantObligation;
import fpml.consolidated.loan.LoanCovenantObligationSummary;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DealStatementChoice1OnlyExistsValidator implements ValidatorWithArg<DealStatementChoice1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DealStatementChoice1> ValidationResult<DealStatementChoice1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("covenantIdentifier", ExistenceChecker.isSet((CovenantObligationIdentifier) o.getCovenantIdentifier()))
				.put("covenantSummary", ExistenceChecker.isSet((LoanCovenantObligationSummary) o.getCovenantSummary()))
				.put("covenant", ExistenceChecker.isSet((LoanCovenantObligation) o.getCovenant()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DealStatementChoice1", ValidationResult.ValidationType.ONLY_EXISTS, "DealStatementChoice1", path, "");
		}
		return failure("DealStatementChoice1", ValidationResult.ValidationType.ONLY_EXISTS, "DealStatementChoice1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
