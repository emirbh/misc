package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.ConditionEnum;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.fx.accruals.FxAccrualAverageStrikeReference;
import fpml.consolidated.fx.accruals.FxAccrualLeverage;
import fpml.consolidated.fx.accruals.FxAccrualStrikeReference;
import fpml.consolidated.fx.accruals.FxAccrualTriggerReference;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.fx.targets.FxLevel;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import fpml.consolidated.shared.Schedule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualLeverageOnlyExistsValidator implements ValidatorWithArg<FxAccrualLeverage, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualLeverage> ValidationResult<FxAccrualLeverage> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("condition", ExistenceChecker.isSet((ConditionEnum) o.getCondition()))
				.put("level", ExistenceChecker.isSet((FxLevel) o.getLevel()))
				.put("quoteBasis", ExistenceChecker.isSet((QuoteBasisEnum) o.getQuoteBasis()))
				.put("strikeReference", ExistenceChecker.isSet((FxAccrualStrikeReference) o.getStrikeReference()))
				.put("averageStrikeReference", ExistenceChecker.isSet((FxAccrualAverageStrikeReference) o.getAverageStrikeReference()))
				.put("triggerReference", ExistenceChecker.isSet((FxAccrualTriggerReference) o.getTriggerReference()))
				.put("ratio", ExistenceChecker.isSet((Schedule) o.getRatio()))
				.put("notionalAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getNotionalAmount()))
				.put("counterCurrencyAmount", ExistenceChecker.isSet((FxCounterCurrencyAmount) o.getCounterCurrencyAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualLeverage", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualLeverage", path, "");
		}
		return failure("FxAccrualLeverage", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualLeverage", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
