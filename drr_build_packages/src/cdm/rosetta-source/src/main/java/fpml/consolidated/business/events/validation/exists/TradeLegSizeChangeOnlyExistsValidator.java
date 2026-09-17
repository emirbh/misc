package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.TradeLegSizeChange;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.NotionalReference;
import fpml.consolidated.shared.NumberOfOptionsReference;
import fpml.consolidated.shared.NumberOfUnitsReference;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeLegSizeChangeOnlyExistsValidator implements ValidatorWithArg<TradeLegSizeChange, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeLegSizeChange> ValidationResult<TradeLegSizeChange> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalReference", ExistenceChecker.isSet((NotionalReference) o.getNotionalReference()))
				.put("changeInNotionalAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getChangeInNotionalAmount()))
				.put("outstandingNotionalAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getOutstandingNotionalAmount()))
				.put("numberOfOptionsReference", ExistenceChecker.isSet((NumberOfOptionsReference) o.getNumberOfOptionsReference()))
				.put("changeInNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getChangeInNumberOfOptions()))
				.put("outstandingNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfOptions()))
				.put("numberOfUnitsReference", ExistenceChecker.isSet((NumberOfUnitsReference) o.getNumberOfUnitsReference()))
				.put("changeInNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getChangeInNumberOfUnits()))
				.put("outstandingNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfUnits()))
				.put("notionalScheduleReference", ExistenceChecker.isSet((NotionalReference) o.getNotionalScheduleReference()))
				.put("changeInNotionalSchedule", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getChangeInNotionalSchedule()))
				.put("outstandingNotionalSchedule", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getOutstandingNotionalSchedule()))
				.put("knownAmountReference", ExistenceChecker.isSet((AmountReference) o.getKnownAmountReference()))
				.put("changeInKnownAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getChangeInKnownAmount()))
				.put("outstandingKnownAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getOutstandingKnownAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeLegSizeChange", ValidationResult.ValidationType.ONLY_EXISTS, "TradeLegSizeChange", path, "");
		}
		return failure("TradeLegSizeChange", ValidationResult.ValidationType.ONLY_EXISTS, "TradeLegSizeChange", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
