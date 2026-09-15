package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.FxFixingDate;
import fpml.consolidated.ird.NonDeliverableSettlement;
import fpml.consolidated.ird.PriceSourceDisruption;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.SettlementRateOption;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class NonDeliverableSettlementOnlyExistsValidator implements ValidatorWithArg<NonDeliverableSettlement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends NonDeliverableSettlement> ValidationResult<NonDeliverableSettlement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("referenceCurrency", ExistenceChecker.isSet((Currency) o.getReferenceCurrency()))
				.put("fxFixingDate", ExistenceChecker.isSet((FxFixingDate) o.getFxFixingDate()))
				.put("fxFixingSchedule", ExistenceChecker.isSet((AdjustableDates) o.getFxFixingSchedule()))
				.put("settlementRateOption", ExistenceChecker.isSet((SettlementRateOption) o.getSettlementRateOption()))
				.put("priceSourceDisruption", ExistenceChecker.isSet((PriceSourceDisruption) o.getPriceSourceDisruption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("NonDeliverableSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "NonDeliverableSettlement", path, "");
		}
		return failure("NonDeliverableSettlement", ValidationResult.ValidationType.ONLY_EXISTS, "NonDeliverableSettlement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
