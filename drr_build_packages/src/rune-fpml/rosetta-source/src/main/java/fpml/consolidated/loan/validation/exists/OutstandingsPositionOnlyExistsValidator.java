package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.loan.LetterOfCreditReference;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.OutstandingsPosition;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class OutstandingsPositionOnlyExistsValidator implements ValidatorWithArg<OutstandingsPosition, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends OutstandingsPosition> ValidationResult<OutstandingsPosition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("loanContractReference", ExistenceChecker.isSet((LoanContractReference) o.getLoanContractReference()))
				.put("letterOfCreditReference", ExistenceChecker.isSet((LetterOfCreditReference) o.getLetterOfCreditReference()))
				.put("amount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAmount()))
				.put("priorAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getPriorAmount()))
				.put("facilityFxRate", ExistenceChecker.isSet((FxTerms) o.getFacilityFxRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OutstandingsPosition", ValidationResult.ValidationType.ONLY_EXISTS, "OutstandingsPosition", path, "");
		}
		return failure("OutstandingsPosition", ValidationResult.ValidationType.ONLY_EXISTS, "OutstandingsPosition", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
