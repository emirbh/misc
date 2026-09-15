package iso20022.auth108.asic.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.asic.CollateralPortfolioCode6Choice__1;
import iso20022.auth108.asic.CollateralisationType3Code__1;
import iso20022.auth108.asic.MarginCollateralReport5__1;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MarginCollateralReport5__1OnlyExistsValidator implements ValidatorWithArg<MarginCollateralReport5__1, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MarginCollateralReport5__1> ValidationResult<MarginCollateralReport5__1> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("collPrtflCd", ExistenceChecker.isSet((CollateralPortfolioCode6Choice__1) o.getCollPrtflCd()))
				.put("collstnCtgy", ExistenceChecker.isSet((CollateralisationType3Code__1) o.getCollstnCtgy()))
				.put("tmStmp", ExistenceChecker.isSet((ZonedDateTime) o.getTmStmp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MarginCollateralReport5__1", ValidationResult.ValidationType.ONLY_EXISTS, "MarginCollateralReport5__1", path, "");
		}
		return failure("MarginCollateralReport5__1", ValidationResult.ValidationType.ONLY_EXISTS, "MarginCollateralReport5__1", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
