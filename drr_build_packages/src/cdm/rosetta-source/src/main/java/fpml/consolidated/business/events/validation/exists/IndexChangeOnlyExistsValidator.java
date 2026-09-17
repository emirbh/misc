package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.IndexChange;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class IndexChangeOnlyExistsValidator implements ValidatorWithArg<IndexChange, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends IndexChange> ValidationResult<IndexChange> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("indexFactor", ExistenceChecker.isSet((BigDecimal) o.getIndexFactor()))
				.put("factoredCalculationAmount", ExistenceChecker.isSet((Money) o.getFactoredCalculationAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("IndexChange", ValidationResult.ValidationType.ONLY_EXISTS, "IndexChange", path, "");
		}
		return failure("IndexChange", ValidationResult.ValidationType.ONLY_EXISTS, "IndexChange", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
