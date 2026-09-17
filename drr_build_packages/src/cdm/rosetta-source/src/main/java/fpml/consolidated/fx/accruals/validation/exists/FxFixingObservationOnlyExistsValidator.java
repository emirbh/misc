package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxFixingObservation;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxFixingObservationOnlyExistsValidator implements ValidatorWithArg<FxFixingObservation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxFixingObservation> ValidationResult<FxFixingObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("date", ExistenceChecker.isSet((ZonedDateTime) o.getDate()))
				.put("weight", ExistenceChecker.isSet((BigDecimal) o.getWeight()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxFixingObservation", ValidationResult.ValidationType.ONLY_EXISTS, "FxFixingObservation", path, "");
		}
		return failure("FxFixingObservation", ValidationResult.ValidationType.ONLY_EXISTS, "FxFixingObservation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
