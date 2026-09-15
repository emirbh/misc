package fpml.consolidated.reg.fpmlreporting.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioId;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralPortfolioIdOnlyExistsValidator implements ValidatorWithArg<CollateralPortfolioId, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralPortfolioId> ValidationResult<CollateralPortfolioId> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("value", ExistenceChecker.isSet((String) o.getValue()))
				.put("collateralPortfolioIdScheme", ExistenceChecker.isSet((String) o.getCollateralPortfolioIdScheme()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralPortfolioId", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralPortfolioId", path, "");
		}
		return failure("CollateralPortfolioId", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralPortfolioId", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
