package iso20022.auth108.iso.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.CollateralPortfolioCode5Choice;
import iso20022.auth108.iso.CollateralisationType3Code;
import iso20022.auth108.iso.MarginCollateralReport4;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MarginCollateralReport4OnlyExistsValidator implements ValidatorWithArg<MarginCollateralReport4, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MarginCollateralReport4> ValidationResult<MarginCollateralReport4> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collPrtflCd", ExistenceChecker.isSet((CollateralPortfolioCode5Choice) o.getCollPrtflCd()))
				.put("collstnCtgy", ExistenceChecker.isSet((CollateralisationType3Code) o.getCollstnCtgy()))
				.put("tmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getTmStmp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MarginCollateralReport4", ValidationResult.ValidationType.ONLY_EXISTS, "MarginCollateralReport4", path, "");
		}
		return failure("MarginCollateralReport4", ValidationResult.ValidationType.ONLY_EXISTS, "MarginCollateralReport4", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
