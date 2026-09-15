package fpml.consolidated.reg.fpmlreporting.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioChoice;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPosition;
import fpml.consolidated.shared.PositiveMoney;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralPortfolioChoiceOnlyExistsValidator implements ValidatorWithArg<CollateralPortfolioChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralPortfolioChoice> ValidationResult<CollateralPortfolioChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cash", ExistenceChecker.isSet((PositiveMoney) o.getCash()))
				.put("nonCash", ExistenceChecker.isSet((CollateralPosition) o.getNonCash()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralPortfolioChoice", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralPortfolioChoice", path, "");
		}
		return failure("CollateralPortfolioChoice", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralPortfolioChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
