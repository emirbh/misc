package fpml.consolidated.repo.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.repo.InitialMarginCalculation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InitialMarginCalculationOnlyExistsValidator implements ValidatorWithArg<InitialMarginCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InitialMarginCalculation> ValidationResult<InitialMarginCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("marginRatio", ExistenceChecker.isSet((BigDecimal) o.getMarginRatio()))
				.put("marginRatioThreshold", ExistenceChecker.isSet((List<BigDecimal>) o.getMarginRatioThreshold()))
				.put("haircut", ExistenceChecker.isSet((BigDecimal) o.getHaircut()))
				.put("haircutThreshold", ExistenceChecker.isSet((List<BigDecimal>) o.getHaircutThreshold()))
				.put("assetReference", ExistenceChecker.isSet((AssetReference) o.getAssetReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InitialMarginCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "InitialMarginCalculation", path, "");
		}
		return failure("InitialMarginCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "InitialMarginCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
