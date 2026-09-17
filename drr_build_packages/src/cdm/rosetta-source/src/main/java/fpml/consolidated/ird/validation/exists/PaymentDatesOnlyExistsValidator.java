package fpml.consolidated.ird.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.PayRelativeToEnum;
import fpml.consolidated.ird.CalculationPeriodDatesReference;
import fpml.consolidated.ird.PaymentDates;
import fpml.consolidated.ird.ResetDatesReference;
import fpml.consolidated.ird.ValuationDatesReference;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Offset;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PaymentDatesOnlyExistsValidator implements ValidatorWithArg<PaymentDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PaymentDates> ValidationResult<PaymentDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("calculationPeriodDatesReference", ExistenceChecker.isSet((CalculationPeriodDatesReference) o.getCalculationPeriodDatesReference()))
				.put("resetDatesReference", ExistenceChecker.isSet((ResetDatesReference) o.getResetDatesReference()))
				.put("valuationDatesReference", ExistenceChecker.isSet((ValuationDatesReference) o.getValuationDatesReference()))
				.put("paymentFrequency", ExistenceChecker.isSet((Frequency) o.getPaymentFrequency()))
				.put("firstPaymentDate", ExistenceChecker.isSet((ZonedDateTime) o.getFirstPaymentDate()))
				.put("lastRegularPaymentDate", ExistenceChecker.isSet((ZonedDateTime) o.getLastRegularPaymentDate()))
				.put("payRelativeTo", ExistenceChecker.isSet((PayRelativeToEnum) o.getPayRelativeTo()))
				.put("paymentDaysOffset", ExistenceChecker.isSet((Offset) o.getPaymentDaysOffset()))
				.put("paymentDatesAdjustments", ExistenceChecker.isSet((BusinessDayAdjustments) o.getPaymentDatesAdjustments()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PaymentDates", ValidationResult.ValidationType.ONLY_EXISTS, "PaymentDates", path, "");
		}
		return failure("PaymentDates", ValidationResult.ValidationType.ONLY_EXISTS, "PaymentDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
