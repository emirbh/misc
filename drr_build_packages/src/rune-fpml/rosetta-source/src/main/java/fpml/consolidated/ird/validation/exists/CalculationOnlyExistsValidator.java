package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.CompoundingMethodEnum;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.Discounting;
import fpml.consolidated.ird.FxLinkedNotionalSchedule;
import fpml.consolidated.ird.Notional;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.FutureValueAmount;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.Schedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CalculationOnlyExistsValidator implements ValidatorWithArg<Calculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends Calculation> ValidationResult<Calculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalSchedule", ExistenceChecker.isSet((Notional) o.getNotionalSchedule()))
				.put("fxLinkedNotionalSchedule", ExistenceChecker.isSet((FxLinkedNotionalSchedule) o.getFxLinkedNotionalSchedule()))
				.put("currentNotional", ExistenceChecker.isSet((Money) o.getCurrentNotional()))
				.put("fixedRateSchedule", ExistenceChecker.isSet((Schedule) o.getFixedRateSchedule()))
				.put("futureValueNotional", ExistenceChecker.isSet((FutureValueAmount) o.getFutureValueNotional()))
				.put("rateCalculation", ExistenceChecker.isSet((Rate) o.getRateCalculation()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("discounting", ExistenceChecker.isSet((Discounting) o.getDiscounting()))
				.put("compoundingMethod", ExistenceChecker.isSet((CompoundingMethodEnum) o.getCompoundingMethod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Calculation", ValidationResult.ValidationType.ONLY_EXISTS, "Calculation", path, "");
		}
		return failure("Calculation", ValidationResult.ValidationType.ONLY_EXISTS, "Calculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
