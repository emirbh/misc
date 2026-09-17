package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualLeverage;
import fpml.consolidated.fx.accruals.FxAccrualLinearPayoffRegion;
import fpml.consolidated.fx.accruals.FxAccrualRegionLowerBound;
import fpml.consolidated.fx.accruals.FxAccrualRegionUpperBound;
import fpml.consolidated.fx.accruals.FxAverageStrike;
import fpml.consolidated.fx.accruals.FxForwardStrikePrice;
import fpml.consolidated.fx.targets.FxExchangedCurrency;
import fpml.consolidated.fx.targets.FxPayoffCap;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAccrualLinearPayoffRegionOnlyExistsValidator implements ValidatorWithArg<FxAccrualLinearPayoffRegion, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAccrualLinearPayoffRegion> ValidationResult<FxAccrualLinearPayoffRegion> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("exchangedCurrency1", ExistenceChecker.isSet((FxExchangedCurrency) o.getExchangedCurrency1()))
				.put("exchangedCurrency2", ExistenceChecker.isSet((FxExchangedCurrency) o.getExchangedCurrency2()))
				.put("strike", ExistenceChecker.isSet((FxForwardStrikePrice) o.getStrike()))
				.put("counterCurrencyAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getCounterCurrencyAmount()))
				.put("averageStrike", ExistenceChecker.isSet((FxAverageStrike) o.getAverageStrike()))
				.put("upperBound", ExistenceChecker.isSet((FxAccrualRegionUpperBound) o.getUpperBound()))
				.put("lowerBound", ExistenceChecker.isSet((FxAccrualRegionLowerBound) o.getLowerBound()))
				.put("leverage", ExistenceChecker.isSet((FxAccrualLeverage) o.getLeverage()))
				.put("payoffCap", ExistenceChecker.isSet((List<? extends FxPayoffCap>) o.getPayoffCap()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAccrualLinearPayoffRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualLinearPayoffRegion", path, "");
		}
		return failure("FxAccrualLinearPayoffRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxAccrualLinearPayoffRegion", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
