package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CollateralTransferTiming;
import cdm.legaldocumentation.csa.LegacyDefinition;
import cdm.legaldocumentation.csa.LegacyTransferSettlementTiming;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CollateralTransferTimingOnlyExistsValidator implements ValidatorWithArg<CollateralTransferTiming, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CollateralTransferTiming> ValidationResult<CollateralTransferTiming> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("transferSettlementTiming", ExistenceChecker.isSet((LegacyTransferSettlementTiming) o.getTransferSettlementTiming()))
				.put("legacyDefinition", ExistenceChecker.isSet((LegacyDefinition) o.getLegacyDefinition()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CollateralTransferTiming", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralTransferTiming", path, "");
		}
		return failure("CollateralTransferTiming", ValidationResult.ValidationType.ONLY_EXISTS, "CollateralTransferTiming", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
