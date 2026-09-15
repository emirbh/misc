package fpml.consolidated.fx.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FallbackReferencePrice;
import fpml.consolidated.shared.SettlementRateOption;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FallbackReferencePriceOnlyExistsValidator implements ValidatorWithArg<FallbackReferencePrice, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FallbackReferencePrice> ValidationResult<FallbackReferencePrice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("primaryRateSource", ExistenceChecker.isSet((SettlementRateOption) o.getPrimaryRateSource()))
				.put("secondaryRateSource", ExistenceChecker.isSet((List<? extends SettlementRateOption>) o.getSecondaryRateSource()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FallbackReferencePrice", ValidationResult.ValidationType.ONLY_EXISTS, "FallbackReferencePrice", path, "");
		}
		return failure("FallbackReferencePrice", ValidationResult.ValidationType.ONLY_EXISTS, "FallbackReferencePrice", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
