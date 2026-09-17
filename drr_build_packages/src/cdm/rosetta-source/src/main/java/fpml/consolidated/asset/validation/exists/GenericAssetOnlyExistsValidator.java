package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.GenericAsset;
import fpml.consolidated.asset.InstrumentType;
import fpml.consolidated.shared.InstrumentId;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GenericAssetOnlyExistsValidator implements ValidatorWithArg<GenericAsset, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GenericAsset> ValidationResult<GenericAsset> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("instrumentId", ExistenceChecker.isSet((List<? extends InstrumentId>) o.getInstrumentId()))
				.put("instrumentType", ExistenceChecker.isSet((List<? extends InstrumentType>) o.getInstrumentType()))
				.put("description", ExistenceChecker.isSet((String) o.getDescription()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GenericAsset", ValidationResult.ValidationType.ONLY_EXISTS, "GenericAsset", path, "");
		}
		return failure("GenericAsset", ValidationResult.ValidationType.ONLY_EXISTS, "GenericAsset", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
