package fpml.consolidated.fx.accruals.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.FxAveragingMethodEnum;
import fpml.consolidated.fx.accruals.FxAverageRate;
import fpml.consolidated.fx.accruals.FxCrossRateObservable;
import fpml.consolidated.fx.accruals.FxWeightedFixingSchedule;
import fpml.consolidated.shared.FxInformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxAverageRateOnlyExistsValidator implements ValidatorWithArg<FxAverageRate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxAverageRate> ValidationResult<FxAverageRate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("informationSource", ExistenceChecker.isSet((FxInformationSource) o.getInformationSource()))
				.put("crossRate", ExistenceChecker.isSet((List<? extends FxCrossRateObservable>) o.getCrossRate()))
				.put("fixingSchedule", ExistenceChecker.isSet((FxWeightedFixingSchedule) o.getFixingSchedule()))
				.put("averagingMethod", ExistenceChecker.isSet((FxAveragingMethodEnum) o.getAveragingMethod()))
				.put("precision", ExistenceChecker.isSet((Integer) o.getPrecision()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxAverageRate", ValidationResult.ValidationType.ONLY_EXISTS, "FxAverageRate", path, "");
		}
		return failure("FxAverageRate", ValidationResult.ValidationType.ONLY_EXISTS, "FxAverageRate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
