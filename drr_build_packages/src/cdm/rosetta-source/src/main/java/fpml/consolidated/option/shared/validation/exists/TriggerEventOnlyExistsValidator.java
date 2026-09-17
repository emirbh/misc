package fpml.consolidated.option.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.AveragingSchedule;
import fpml.consolidated.option.shared.FeaturePayment;
import fpml.consolidated.option.shared.Trigger;
import fpml.consolidated.option.shared.TriggerEvent;
import fpml.consolidated.shared.DateList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TriggerEventOnlyExistsValidator implements ValidatorWithArg<TriggerEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TriggerEvent> ValidationResult<TriggerEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("schedule", ExistenceChecker.isSet((List<? extends AveragingSchedule>) o.getSchedule()))
				.put("triggerDates", ExistenceChecker.isSet((DateList) o.getTriggerDates()))
				.put("trigger", ExistenceChecker.isSet((Trigger) o.getTrigger()))
				.put("featurePayment", ExistenceChecker.isSet((FeaturePayment) o.getFeaturePayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TriggerEvent", ValidationResult.ValidationType.ONLY_EXISTS, "TriggerEvent", path, "");
		}
		return failure("TriggerEvent", ValidationResult.ValidationType.ONLY_EXISTS, "TriggerEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
