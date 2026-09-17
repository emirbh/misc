package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ObservationSource;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.shared.InformationSource;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ObservationSourceOnlyExistsValidator implements ValidatorWithArg<ObservationSource, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ObservationSource> ValidationResult<ObservationSource> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("informationSource", ExistenceChecker.isSet((InformationSource) o.getInformationSource()))
				.put("underlyer", ExistenceChecker.isSet((TradeUnderlyer2) o.getUnderlyer()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ObservationSource", ValidationResult.ValidationType.ONLY_EXISTS, "ObservationSource", path, "");
		}
		return failure("ObservationSource", ValidationResult.ValidationType.ONLY_EXISTS, "ObservationSource", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
