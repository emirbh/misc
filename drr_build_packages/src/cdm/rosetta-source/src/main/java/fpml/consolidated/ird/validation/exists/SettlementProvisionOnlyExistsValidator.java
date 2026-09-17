package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.NonDeliverableSettlement;
import fpml.consolidated.ird.SettlementProvision;
import fpml.consolidated.shared.Currency;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class SettlementProvisionOnlyExistsValidator implements ValidatorWithArg<SettlementProvision, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends SettlementProvision> ValidationResult<SettlementProvision> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementCurrency", ExistenceChecker.isSet((Currency) o.getSettlementCurrency()))
				.put("nonDeliverableSettlement", ExistenceChecker.isSet((NonDeliverableSettlement) o.getNonDeliverableSettlement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementProvision", ValidationResult.ValidationType.ONLY_EXISTS, "SettlementProvision", path, "");
		}
		return failure("SettlementProvision", ValidationResult.ValidationType.ONLY_EXISTS, "SettlementProvision", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
