package fpml.consolidated.repo.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.asset.EquityAsset;
import fpml.consolidated.repo.RelativePriceChoice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RelativePriceChoiceOnlyExistsValidator implements ValidatorWithArg<RelativePriceChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RelativePriceChoice> ValidationResult<RelativePriceChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("bond", ExistenceChecker.isSet((Bond) o.getBond()))
				.put("convertibleBond", ExistenceChecker.isSet((ConvertibleBond) o.getConvertibleBond()))
				.put("equity", ExistenceChecker.isSet((EquityAsset) o.getEquity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RelativePriceChoice", ValidationResult.ValidationType.ONLY_EXISTS, "RelativePriceChoice", path, "");
		}
		return failure("RelativePriceChoice", ValidationResult.ValidationType.ONLY_EXISTS, "RelativePriceChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
