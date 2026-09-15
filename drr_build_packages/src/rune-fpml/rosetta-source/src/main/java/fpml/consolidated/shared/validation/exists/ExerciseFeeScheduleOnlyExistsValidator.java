package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AmountSchedule;
import fpml.consolidated.shared.ExerciseFeeSchedule;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.Schedule;
import fpml.consolidated.shared.ScheduleReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ExerciseFeeScheduleOnlyExistsValidator implements ValidatorWithArg<ExerciseFeeSchedule, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ExerciseFeeSchedule> ValidationResult<ExerciseFeeSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("notionalReference", ExistenceChecker.isSet((ScheduleReference) o.getNotionalReference()))
				.put("feeAmountSchedule", ExistenceChecker.isSet((AmountSchedule) o.getFeeAmountSchedule()))
				.put("feeRateSchedule", ExistenceChecker.isSet((Schedule) o.getFeeRateSchedule()))
				.put("feePaymentDate", ExistenceChecker.isSet((RelativeDateOffset) o.getFeePaymentDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExerciseFeeSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "ExerciseFeeSchedule", path, "");
		}
		return failure("ExerciseFeeSchedule", ValidationResult.ValidationType.ONLY_EXISTS, "ExerciseFeeSchedule", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
