package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.WeatherLegCalculation;
import fpml.consolidated.fpmlenum.WeatherSettlementLevelEnum;
import fpml.consolidated.shared.BusinessCenter;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.Rounding;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WeatherLegCalculationOnlyExistsValidator implements ValidatorWithArg<WeatherLegCalculation, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends WeatherLegCalculation> ValidationResult<WeatherLegCalculation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementLevel", ExistenceChecker.isSet((WeatherSettlementLevelEnum) o.getSettlementLevel()))
				.put("referenceLevelEqualsZero", ExistenceChecker.isSet((Boolean) o.getReferenceLevelEqualsZero()))
				.put("calculationDate", ExistenceChecker.isSet((Period) o.getCalculationDate()))
				.put("businessDays", ExistenceChecker.isSet((BusinessCenter) o.getBusinessDays()))
				.put("dataCorrection", ExistenceChecker.isSet((Boolean) o.getDataCorrection()))
				.put("correctionPeriod", ExistenceChecker.isSet((Period) o.getCorrectionPeriod()))
				.put("maximumPaymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getMaximumPaymentAmount()))
				.put("maximumTransactionPaymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getMaximumTransactionPaymentAmount()))
				.put("rounding", ExistenceChecker.isSet((Rounding) o.getRounding()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("WeatherLegCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "WeatherLegCalculation", path, "");
		}
		return failure("WeatherLegCalculation", ValidationResult.ValidationType.ONLY_EXISTS, "WeatherLegCalculation", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
