package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fx.targets.FxComplexBarrierBaseReference;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.fx.targets.FxLevel;
import fpml.consolidated.fx.targets.FxLevelReference;
import fpml.consolidated.fx.targets.FxPivotReference;
import fpml.consolidated.fx.targets.FxStrikeReference;
import fpml.consolidated.fx.targets.FxTargetLeverage;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetLeverageOnlyExistsValidator implements ValidatorWithArg<FxTargetLeverage, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetLeverage> ValidationResult<FxTargetLeverage> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("condition", ExistenceChecker.isSet((ConditionEnum) o.getCondition()))
				.put("level", ExistenceChecker.isSet((FxLevel) o.getLevel()))
				.put("strikeReference", ExistenceChecker.isSet((FxStrikeReference) o.getStrikeReference()))
				.put("pivotReference", ExistenceChecker.isSet((FxPivotReference) o.getPivotReference()))
				.put("barrierReference", ExistenceChecker.isSet((FxComplexBarrierBaseReference) o.getBarrierReference()))
				.put("levelReference", ExistenceChecker.isSet((FxLevelReference) o.getLevelReference()))
				.put("ratio", ExistenceChecker.isSet((Schedule) o.getRatio()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("counterCurrencyAmount", ExistenceChecker.isSet((List<? extends FxCounterCurrencyAmount>) o.getCounterCurrencyAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetLeverage", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetLeverage", path, "");
		}
		return failure("FxTargetLeverage", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetLeverage", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
