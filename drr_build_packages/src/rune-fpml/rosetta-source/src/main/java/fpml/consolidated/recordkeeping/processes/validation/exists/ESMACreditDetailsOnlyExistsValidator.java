package fpml.consolidated.recordkeeping.processes.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.ESMACreditDetails;
import fpml.consolidated.recordkeeping.processes.ESMACreditSeniority;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ESMACreditDetailsOnlyExistsValidator implements ValidatorWithArg<ESMACreditDetails, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ESMACreditDetails> ValidationResult<ESMACreditDetails> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("seniority", ExistenceChecker.isSet((ESMACreditSeniority) o.getSeniority()))
				.put("indexFactor", ExistenceChecker.isSet((List<BigDecimal>) o.getIndexFactor()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ESMACreditDetails", ValidationResult.ValidationType.ONLY_EXISTS, "ESMACreditDetails", path, "");
		}
		return failure("ESMACreditDetails", ValidationResult.ValidationType.ONLY_EXISTS, "ESMACreditDetails", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
