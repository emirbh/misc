package fpml.consolidated.fx.targets.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxExchangedCurrency;
import fpml.consolidated.fx.targets.FxPayoffCap;
import fpml.consolidated.fx.targets.FxStrike;
import fpml.consolidated.fx.targets.FxTargetLeverage;
import fpml.consolidated.fx.targets.FxTargetLinearPayoffRegion;
import fpml.consolidated.fx.targets.FxTargetRegionLowerBound;
import fpml.consolidated.fx.targets.FxTargetRegionUpperBound;
import fpml.consolidated.shared.NonNegativeAmountSchedule;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxTargetLinearPayoffRegionOnlyExistsValidator implements ValidatorWithArg<FxTargetLinearPayoffRegion, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxTargetLinearPayoffRegion> ValidationResult<FxTargetLinearPayoffRegion> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("exchangedCurrency1", ExistenceChecker.isSet((FxExchangedCurrency) o.getExchangedCurrency1()))
				.put("exchangedCurrency2", ExistenceChecker.isSet((FxExchangedCurrency) o.getExchangedCurrency2()))
				.put("strike", ExistenceChecker.isSet((FxStrike) o.getStrike()))
				.put("counterCurrencyAmount", ExistenceChecker.isSet((NonNegativeAmountSchedule) o.getCounterCurrencyAmount()))
				.put("lowerBound", ExistenceChecker.isSet((FxTargetRegionLowerBound) o.getLowerBound()))
				.put("upperBound", ExistenceChecker.isSet((FxTargetRegionUpperBound) o.getUpperBound()))
				.put("leverage", ExistenceChecker.isSet((FxTargetLeverage) o.getLeverage()))
				.put("payoffCap", ExistenceChecker.isSet((List<? extends FxPayoffCap>) o.getPayoffCap()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxTargetLinearPayoffRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetLinearPayoffRegion", path, "");
		}
		return failure("FxTargetLinearPayoffRegion", ValidationResult.ValidationType.ONLY_EXISTS, "FxTargetLinearPayoffRegion", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
