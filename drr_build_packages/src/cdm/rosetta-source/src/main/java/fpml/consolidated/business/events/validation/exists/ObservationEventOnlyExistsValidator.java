package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.ObservationEvent;
import fpml.consolidated.business.events.ObservationSource;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.shared.TimeZone;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ObservationEventOnlyExistsValidator implements ValidatorWithArg<ObservationEvent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ObservationEvent> ValidationResult<ObservationEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("date", ExistenceChecker.isSet((ZonedDateTime) o.getDate()))
				.put("time", ExistenceChecker.isSet((TimeZone) o.getTime()))
				.put("side", ExistenceChecker.isSet((QuotationRateTypeEnum) o.getSide()))
				.put("observedValue", ExistenceChecker.isSet((BigDecimal) o.getObservedValue()))
				.put("source", ExistenceChecker.isSet((ObservationSource) o.getSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ObservationEvent", ValidationResult.ValidationType.ONLY_EXISTS, "ObservationEvent", path, "");
		}
		return failure("ObservationEvent", ValidationResult.ValidationType.ONLY_EXISTS, "ObservationEvent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
