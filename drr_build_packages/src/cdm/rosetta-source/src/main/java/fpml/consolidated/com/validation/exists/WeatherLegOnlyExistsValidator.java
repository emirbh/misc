package fpml.consolidated.com.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CalculationPeriodsReference;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.com.WeatherCalculationPeriods;
import fpml.consolidated.com.WeatherIndex;
import fpml.consolidated.com.WeatherIndexData;
import fpml.consolidated.com.WeatherLeg;
import fpml.consolidated.com.WeatherLegCalculation;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class WeatherLegOnlyExistsValidator implements ValidatorWithArg<WeatherLeg, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends WeatherLeg> ValidationResult<WeatherLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("weatherIndexLevel", ExistenceChecker.isSet((WeatherIndex) o.getWeatherIndexLevel()))
				.put("weatherCalculationPeriods", ExistenceChecker.isSet((WeatherCalculationPeriods) o.getWeatherCalculationPeriods()))
				.put("weatherCalculationPeriodsReference", ExistenceChecker.isSet((CalculationPeriodsReference) o.getWeatherCalculationPeriodsReference()))
				.put("weatherNotionalAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getWeatherNotionalAmount()))
				.put("calculation", ExistenceChecker.isSet((WeatherLegCalculation) o.getCalculation()))
				.put("paymentDates", ExistenceChecker.isSet((CommodityRelativePaymentDates) o.getPaymentDates()))
				.put("weatherIndexData", ExistenceChecker.isSet((WeatherIndexData) o.getWeatherIndexData()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("WeatherLeg", ValidationResult.ValidationType.ONLY_EXISTS, "WeatherLeg", path, "");
		}
		return failure("WeatherLeg", ValidationResult.ValidationType.ONLY_EXISTS, "WeatherLeg", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
