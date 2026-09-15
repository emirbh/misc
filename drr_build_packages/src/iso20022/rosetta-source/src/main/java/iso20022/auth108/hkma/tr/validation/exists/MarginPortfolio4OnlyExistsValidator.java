package iso20022.auth108.hkma.tr.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.tr.MarginPortfolio4;
import iso20022.auth108.hkma.tr.PortfolioCode5Choice;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MarginPortfolio4OnlyExistsValidator implements ValidatorWithArg<MarginPortfolio4, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MarginPortfolio4> ValidationResult<MarginPortfolio4> validate(RosettaPath path, T2 o, Set<String> fields) {
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
			return success("MarginPortfolio4", ValidationResult.ValidationType.ONLY_EXISTS, "MarginPortfolio4", path, "");
		}
		return failure("MarginPortfolio4", ValidationResult.ValidationType.ONLY_EXISTS, "MarginPortfolio4", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
