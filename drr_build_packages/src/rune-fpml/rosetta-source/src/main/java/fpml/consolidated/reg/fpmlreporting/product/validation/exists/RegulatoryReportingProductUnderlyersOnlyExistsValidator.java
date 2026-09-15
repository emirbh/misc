package fpml.consolidated.reg.fpmlreporting.product.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.generic.TradeUnderlyer2;
import fpml.consolidated.reg.fpmlreporting.product.RegulatoryReportingProductUnderlyers;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class RegulatoryReportingProductUnderlyersOnlyExistsValidator implements ValidatorWithArg<RegulatoryReportingProductUnderlyers, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends RegulatoryReportingProductUnderlyers> ValidationResult<RegulatoryReportingProductUnderlyers> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("underlyer", ExistenceChecker.isSet((List<? extends TradeUnderlyer2>) o.getUnderlyer()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RegulatoryReportingProductUnderlyers", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductUnderlyers", path, "");
		}
		return failure("RegulatoryReportingProductUnderlyers", ValidationResult.ValidationType.ONLY_EXISTS, "RegulatoryReportingProductUnderlyers", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
