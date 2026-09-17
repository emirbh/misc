package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.InflationCalculationMethodEnum;
import fpml.consolidated.fpmlenum.InflationCalculationStyleEnum;
import fpml.consolidated.ird.FinalPrincipalExchangeCalculation;
import fpml.consolidated.ird.InflationRate;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.InterpolationMethod;
import fpml.consolidated.shared.MainPublication;
import fpml.consolidated.shared.Offset;
import fpml.consolidated.shared.RateSourcePage;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class InflationRateOnlyExistsValidator implements ValidatorWithArg<InflationRate, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends InflationRate> ValidationResult<InflationRate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("inflationRateIndex", ExistenceChecker.isSet((FloatingRateIndex) o.getInflationRateIndex()))
				.put("inflationLag", ExistenceChecker.isSet((Offset) o.getInflationLag()))
				.put("indexSource", ExistenceChecker.isSet((RateSourcePage) o.getIndexSource()))
				.put("mainPublication", ExistenceChecker.isSet((MainPublication) o.getMainPublication()))
				.put("interpolationMethod", ExistenceChecker.isSet((InterpolationMethod) o.getInterpolationMethod()))
				.put("initialIndexLevel", ExistenceChecker.isSet((BigDecimal) o.getInitialIndexLevel()))
				.put("fallbackBondApplicable", ExistenceChecker.isSet((Boolean) o.getFallbackBondApplicable()))
				.put("calculationMethod", ExistenceChecker.isSet((InflationCalculationMethodEnum) o.getCalculationMethod()))
				.put("calculationStyle", ExistenceChecker.isSet((InflationCalculationStyleEnum) o.getCalculationStyle()))
				.put("finalPrincipalExchangeCalculation", ExistenceChecker.isSet((FinalPrincipalExchangeCalculation) o.getFinalPrincipalExchangeCalculation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InflationRate", ValidationResult.ValidationType.ONLY_EXISTS, "InflationRate", path, "");
		}
		return failure("InflationRate", ValidationResult.ValidationType.ONLY_EXISTS, "InflationRate", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
