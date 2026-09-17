package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.NotificationTime;
import cdm.legaldocumentation.csa.NotificationTimeElection;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NotificationTimeOnlyExistsValidator implements ValidatorWithArg<NotificationTime, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NotificationTime> ValidationResult<NotificationTime> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyElections", ExistenceChecker.isSet((List<? extends NotificationTimeElection>) o.getPartyElections()))
				.put("disputeNotificationReference", ExistenceChecker.isSet((Boolean) o.getDisputeNotificationReference()))
				.put("transferTimingProviso", ExistenceChecker.isSet((Boolean) o.getTransferTimingProviso()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NotificationTime", ValidationResult.ValidationType.ONLY_EXISTS, "NotificationTime", path, "");
		}
		return failure("NotificationTime", ValidationResult.ValidationType.ONLY_EXISTS, "NotificationTime", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
