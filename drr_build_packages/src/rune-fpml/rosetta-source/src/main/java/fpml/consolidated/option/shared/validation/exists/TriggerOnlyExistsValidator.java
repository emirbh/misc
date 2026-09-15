package fpml.consolidated.option.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.TriggerTimeTypeEnum;
import fpml.consolidated.fpmlenum.TriggerTypeEnum;
import fpml.consolidated.option.shared.CreditEvents;
import fpml.consolidated.option.shared.CreditEventsReference;
import fpml.consolidated.option.shared.Trigger;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TriggerOnlyExistsValidator implements ValidatorWithArg<Trigger, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Trigger> ValidationResult<Trigger> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("level", ExistenceChecker.isSet((BigDecimal) o.getLevel()))
				.put("levelPercentage", ExistenceChecker.isSet((BigDecimal) o.getLevelPercentage()))
				.put("creditEvents", ExistenceChecker.isSet((CreditEvents) o.getCreditEvents()))
				.put("creditEventsReference", ExistenceChecker.isSet((CreditEventsReference) o.getCreditEventsReference()))
				.put("triggerType", ExistenceChecker.isSet((TriggerTypeEnum) o.getTriggerType()))
				.put("triggerTimeType", ExistenceChecker.isSet((TriggerTimeTypeEnum) o.getTriggerTimeType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Trigger", ValidationResult.ValidationType.ONLY_EXISTS, "Trigger", path, "");
		}
		return failure("Trigger", ValidationResult.ValidationType.ONLY_EXISTS, "Trigger", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
