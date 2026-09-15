package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualRegion;
import fpml.consolidated.fx.accruals.FxAccrualRegionLowerBound;
import fpml.consolidated.fx.accruals.FxAccrualRegionUpperBound;
import fpml.consolidated.fx.accruals.FxRateObservableReference;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualRegionOnlyExistsValidator implements ValidatorWithArg<FxAccrualRegion, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualRegion> ValidationResult<FxAccrualRegion> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("observableReference", ExistenceChecker.isSet((FxRateObservableReference) o.getObservableReference()))
				.put("upperBound", ExistenceChecker.isSet((FxAccrualRegionUpperBound) o.getUpperBound()))
				.put("lowerBound", ExistenceChecker.isSet((FxAccrualRegionLowerBound) o.getLowerBound()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
				.put("accrualFactor", ExistenceChecker.isSet((Schedule) o.getAccrualFactor()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("counterCurrencyAmount", ExistenceChecker.isSet((FxCounterCurrencyAmount) o.getCounterCurrencyAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualRegion", path, "");
		}
		return failure("FxAccrualRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualRegion", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
