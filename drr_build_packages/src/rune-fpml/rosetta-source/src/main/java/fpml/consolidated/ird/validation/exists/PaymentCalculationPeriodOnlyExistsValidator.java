package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CalculationPeriod;
import fpml.consolidated.ird.PaymentCalculationPeriod;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PaymentCalculationPeriodOnlyExistsValidator implements ValidatorWithArg<PaymentCalculationPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PaymentCalculationPeriod> ValidationResult<PaymentCalculationPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("href", ExistenceChecker.isSet((String) o.getHref()))
				.put("unadjustedPaymentDate", ExistenceChecker.isSet((ZonedDateTime) o.getUnadjustedPaymentDate()))
				.put("adjustedPaymentDate", ExistenceChecker.isSet((ZonedDateTime) o.getAdjustedPaymentDate()))
				.put("calculationPeriod", ExistenceChecker.isSet((List<? extends CalculationPeriod>) o.getCalculationPeriod()))
				.put("fixedPaymentAmount", ExistenceChecker.isSet((BigDecimal) o.getFixedPaymentAmount()))
				.put("discountFactor", ExistenceChecker.isSet((BigDecimal) o.getDiscountFactor()))
				.put("forecastPaymentAmount", ExistenceChecker.isSet((Money) o.getForecastPaymentAmount()))
				.put("presentValueAmount", ExistenceChecker.isSet((Money) o.getPresentValueAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PaymentCalculationPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "PaymentCalculationPeriod", path, "");
		}
		return failure("PaymentCalculationPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "PaymentCalculationPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
