package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.CollateralPortfolioCode5Choice;
import iso20022.auth108.iso.MarginPortfolio3;
import iso20022.auth108.iso.PortfolioCode3Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralPortfolioCode5ChoiceOnlyExistsValidator implements ValidatorWithArg<CollateralPortfolioCode5Choice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralPortfolioCode5Choice> ValidationResult<CollateralPortfolioCode5Choice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("prtfl", ExistenceChecker.isSet((PortfolioCode3Choice) o.getPrtfl()))
				.put("mrgnPrtflCd", ExistenceChecker.isSet((MarginPortfolio3) o.getMrgnPrtflCd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralPortfolioCode5Choice", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralPortfolioCode5Choice", path, "");
		}
		return failure("CollateralPortfolioCode5Choice", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralPortfolioCode5Choice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
