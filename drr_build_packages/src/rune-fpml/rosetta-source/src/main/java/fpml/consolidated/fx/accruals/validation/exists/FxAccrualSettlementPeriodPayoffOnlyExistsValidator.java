package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualPayoffRegionReference;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodPayoff;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
import fpml.consolidated.fx.targets.SettlementPeriodLeverage;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualSettlementPeriodPayoffOnlyExistsValidator implements ValidatorWithArg<FxAccrualSettlementPeriodPayoff, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualSettlementPeriodPayoff> ValidationResult<FxAccrualSettlementPeriodPayoff> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payoffRegionReference", ExistenceChecker.isSet((FxAccrualPayoffRegionReference) o.getPayoffRegionReference()))
				.put("strike", ExistenceChecker.isSet((BigDecimal) o.getStrike()))
				.put("counterCurrencyAmount", ExistenceChecker.isSet((BigDecimal) o.getCounterCurrencyAmount()))
				.put("averageStrikeFixingDates", ExistenceChecker.isSet((SettlementPeriodFixingDates) o.getAverageStrikeFixingDates()))
				.put("averageRateFixingDates", ExistenceChecker.isSet((SettlementPeriodFixingDates) o.getAverageRateFixingDates()))
				.put("lowerBound", ExistenceChecker.isSet((BigDecimal) o.getLowerBound()))
				.put("upperBound", ExistenceChecker.isSet((BigDecimal) o.getUpperBound()))
				.put("leverage", ExistenceChecker.isSet((SettlementPeriodLeverage) o.getLeverage()))
				.put("payoffCap", ExistenceChecker.isSet((BigDecimal) o.getPayoffCap()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualSettlementPeriodPayoff", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualSettlementPeriodPayoff", path, "");
		}
		return failure("FxAccrualSettlementPeriodPayoff", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualSettlementPeriodPayoff", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
