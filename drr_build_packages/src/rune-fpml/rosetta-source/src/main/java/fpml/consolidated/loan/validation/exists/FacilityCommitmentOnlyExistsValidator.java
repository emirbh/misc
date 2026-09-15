package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityCommitment;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FacilityCommitmentOnlyExistsValidator implements ValidatorWithArg<FacilityCommitment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FacilityCommitment> ValidationResult<FacilityCommitment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("totalCommitmentAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getTotalCommitmentAmount()))
				.put("requiredFundedAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getRequiredFundedAmount()))
				.put("unfundedAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getUnfundedAmount()))
				.put("requiredUnfundedAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getRequiredUnfundedAmount()))
				.put("fundedAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getFundedAmount()))
				.put("unavailableToUtilizeAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getUnavailableToUtilizeAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FacilityCommitment", ValidationResult.ValidationType.ONLY_EXISTS, "FacilityCommitment", path, "");
		}
		return failure("FacilityCommitment", ValidationResult.ValidationType.ONLY_EXISTS, "FacilityCommitment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
