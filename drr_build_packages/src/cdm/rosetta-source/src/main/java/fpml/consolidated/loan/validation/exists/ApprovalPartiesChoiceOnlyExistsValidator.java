package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ApprovalPartiesChoice;
import fpml.consolidated.loan.IneligiblePartyReasonType;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ApprovalPartiesChoiceOnlyExistsValidator implements ValidatorWithArg<ApprovalPartiesChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ApprovalPartiesChoice> ValidationResult<ApprovalPartiesChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eligibleParty", ExistenceChecker.isSet((PartyReference) o.getEligibleParty()))
				.put("ineligibleParty", ExistenceChecker.isSet((PartyReference) o.getIneligibleParty()))
				.put("ineligibleReason", ExistenceChecker.isSet((IneligiblePartyReasonType) o.getIneligibleReason()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ApprovalPartiesChoice", ValidationResult.ValidationType.ONLY_EXISTS, "ApprovalPartiesChoice", path, "");
		}
		return failure("ApprovalPartiesChoice", ValidationResult.ValidationType.ONLY_EXISTS, "ApprovalPartiesChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
