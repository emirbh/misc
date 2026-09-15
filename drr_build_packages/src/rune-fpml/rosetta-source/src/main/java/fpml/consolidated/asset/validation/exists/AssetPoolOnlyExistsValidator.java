package fpml.consolidated.asset.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetPool;
import fpml.consolidated.shared.IdentifiedDate;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AssetPoolOnlyExistsValidator implements ValidatorWithArg<AssetPool, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AssetPool> ValidationResult<AssetPool> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("version", ExistenceChecker.isSet((Integer) o.getVersion()))
				.put("effectiveDate", ExistenceChecker.isSet((IdentifiedDate) o.getEffectiveDate()))
				.put("initialFactor", ExistenceChecker.isSet((BigDecimal) o.getInitialFactor()))
				.put("currentFactor", ExistenceChecker.isSet((BigDecimal) o.getCurrentFactor()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetPool", ValidationResult.ValidationType.ONLY_EXISTS, "AssetPool", path, "");
		}
		return failure("AssetPool", ValidationResult.ValidationType.ONLY_EXISTS, "AssetPool", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
