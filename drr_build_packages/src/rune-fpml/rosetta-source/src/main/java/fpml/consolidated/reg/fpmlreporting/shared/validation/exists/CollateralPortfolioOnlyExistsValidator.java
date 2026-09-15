package fpml.consolidated.reg.fpmlreporting.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolio;
import fpml.consolidated.reg.fpmlreporting.shared.CollateralPortfolioChoice;
import fpml.consolidated.shared.PositiveMoney;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralPortfolioOnlyExistsValidator implements ValidatorWithArg<CollateralPortfolio, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralPortfolio> ValidationResult<CollateralPortfolio> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("valueDate", ExistenceChecker.isSet((ZonedDateTime) o.getValueDate()))
				.put("collateralPortfolioChoice", ExistenceChecker.isSet((List<? extends CollateralPortfolioChoice>) o.getCollateralPortfolioChoice()))
				.put("totalValuationAmount", ExistenceChecker.isSet((List<? extends PositiveMoney>) o.getTotalValuationAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralPortfolio", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralPortfolio", path, "");
		}
		return failure("CollateralPortfolio", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralPortfolio", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
