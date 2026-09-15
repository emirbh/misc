package fpml.consolidated.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.PGPData;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PGPDataOnlyExistsValidator implements ValidatorWithArg<PGPData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PGPData> ValidationResult<PGPData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pgpKeyID", ExistenceChecker.isSet((String) o.getPgpKeyID()))
				.put("pgpKeyPacket", ExistenceChecker.isSet((String) o.getPgpKeyPacket()))
				.put("anyContents0", ExistenceChecker.isSet((List<String>) o.getAnyContents0()))
				.put("anyContents1", ExistenceChecker.isSet((List<String>) o.getAnyContents1()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PGPData", ValidationResult.ValidationType.ONLY_EXISTS, "PGPData", path, "");
		}
		return failure("PGPData", ValidationResult.ValidationType.ONLY_EXISTS, "PGPData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
