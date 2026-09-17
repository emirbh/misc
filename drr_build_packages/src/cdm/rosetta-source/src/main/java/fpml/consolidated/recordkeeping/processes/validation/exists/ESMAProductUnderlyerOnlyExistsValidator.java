package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.ESMAIndexIdentification;
import fpml.consolidated.recordkeeping.processes.ESMAProductUnderlyer;
import fpml.consolidated.shared.InstrumentId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ESMAProductUnderlyerOnlyExistsValidator implements ValidatorWithArg<ESMAProductUnderlyer, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ESMAProductUnderlyer> ValidationResult<ESMAProductUnderlyer> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("index", ExistenceChecker.isSet((ESMAIndexIdentification) o.getIndex()))
				.put("maturityDate", ExistenceChecker.isSet((ZonedDateTime) o.getMaturityDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ESMAProductUnderlyer", ValidationResult.ValidationType.ONLY_EXISTS, "ESMAProductUnderlyer", path, "");
		}
		return failure("ESMAProductUnderlyer", ValidationResult.ValidationType.ONLY_EXISTS, "ESMAProductUnderlyer", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
