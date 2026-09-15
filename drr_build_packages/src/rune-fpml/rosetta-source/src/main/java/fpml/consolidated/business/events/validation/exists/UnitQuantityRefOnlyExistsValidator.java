package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.business.events.UnitQuantityRef;
import fpml.consolidated.shared.NotionalReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class UnitQuantityRefOnlyExistsValidator implements ValidatorWithArg<UnitQuantityRef, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends UnitQuantityRef> ValidationResult<UnitQuantityRef> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("quantityUnit", ExistenceChecker.isSet((QuantityUnit) o.getQuantityUnit()))
				.put("quantity", ExistenceChecker.isSet((BigDecimal) o.getQuantity()))
				.put("quantityReference", ExistenceChecker.isSet((NotionalReference) o.getQuantityReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("UnitQuantityRef", ValidationResult.ValidationType.ONLY_EXISTS, "UnitQuantityRef", path, "");
		}
		return failure("UnitQuantityRef", ValidationResult.ValidationType.ONLY_EXISTS, "UnitQuantityRef", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
