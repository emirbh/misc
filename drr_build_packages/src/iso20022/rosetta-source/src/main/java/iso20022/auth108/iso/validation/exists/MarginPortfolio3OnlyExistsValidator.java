package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.MarginPortfolio3;
import iso20022.auth108.iso.PortfolioCode5Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MarginPortfolio3OnlyExistsValidator implements ValidatorWithArg<MarginPortfolio3, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MarginPortfolio3> ValidationResult<MarginPortfolio3> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("initlMrgnPrtflCd", ExistenceChecker.isSet((PortfolioCode5Choice) o.getInitlMrgnPrtflCd()))
				.put("vartnMrgnPrtflCd", ExistenceChecker.isSet((PortfolioCode5Choice) o.getVartnMrgnPrtflCd()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MarginPortfolio3", ValidationResult.ValidationType.ONLY_EXISTS, "MarginPortfolio3", path, "");
		}
		return failure("MarginPortfolio3", ValidationResult.ValidationType.ONLY_EXISTS, "MarginPortfolio3", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
