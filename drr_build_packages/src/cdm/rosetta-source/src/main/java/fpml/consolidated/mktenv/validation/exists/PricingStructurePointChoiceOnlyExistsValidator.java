package fpml.consolidated.mktenv.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.PricingStructurePointChoice;
import fpml.consolidated.riskdef.PricingDataPointCoordinate;
import fpml.consolidated.riskdef.PricingDataPointCoordinateReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PricingStructurePointChoiceOnlyExistsValidator implements ValidatorWithArg<PricingStructurePointChoice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PricingStructurePointChoice> ValidationResult<PricingStructurePointChoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("coordinate", ExistenceChecker.isSet((PricingDataPointCoordinate) o.getCoordinate()))
				.put("coordinateReference", ExistenceChecker.isSet((PricingDataPointCoordinateReference) o.getCoordinateReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PricingStructurePointChoice", ValidationResult.ValidationType.ONLY_EXISTS, "PricingStructurePointChoice", path, "");
		}
		return failure("PricingStructurePointChoice", ValidationResult.ValidationType.ONLY_EXISTS, "PricingStructurePointChoice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
