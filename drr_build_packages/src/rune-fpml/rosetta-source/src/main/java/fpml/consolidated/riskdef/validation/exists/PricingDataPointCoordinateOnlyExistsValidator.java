package fpml.consolidated.riskdef.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingDataPointCoordinate;
import fpml.consolidated.riskdef.PricingDataPointCoordinateChoice;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PricingDataPointCoordinateOnlyExistsValidator implements ValidatorWithArg<PricingDataPointCoordinate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PricingDataPointCoordinate> ValidationResult<PricingDataPointCoordinate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("pricingDataPointCoordinateChoice", ExistenceChecker.isSet((List<? extends PricingDataPointCoordinateChoice>) o.getPricingDataPointCoordinateChoice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PricingDataPointCoordinate", ValidationResult.ValidationType.ONLY_EXISTS, "PricingDataPointCoordinate", path, "");
		}
		return failure("PricingDataPointCoordinate", ValidationResult.ValidationType.ONLY_EXISTS, "PricingDataPointCoordinate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
