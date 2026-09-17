package cdm.legaldocumentation.csa.validation.exists;

import cdm.legaldocumentation.csa.CashCTSTimeEnum;
import cdm.legaldocumentation.csa.LegacyTransferSettlementTiming;
import cdm.legaldocumentation.csa.SecuritiesCTSTimeEnum;
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

public class LegacyTransferSettlementTimingOnlyExistsValidator implements ValidatorWithArg<LegacyTransferSettlementTiming, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegacyTransferSettlementTiming> ValidationResult<LegacyTransferSettlementTiming> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashCollateralTransferSettlementTime", ExistenceChecker.isSet((CashCTSTimeEnum) o.getCashCollateralTransferSettlementTime()))
				.put("securititesCollateralTransferSettlementTime", ExistenceChecker.isSet((SecuritiesCTSTimeEnum) o.getSecurititesCollateralTransferSettlementTime()))
				.put("additionalLanguage", ExistenceChecker.isSet((String) o.getAdditionalLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegacyTransferSettlementTiming", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyTransferSettlementTiming", path, "");
		}
		return failure("LegacyTransferSettlementTiming", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyTransferSettlementTiming", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
