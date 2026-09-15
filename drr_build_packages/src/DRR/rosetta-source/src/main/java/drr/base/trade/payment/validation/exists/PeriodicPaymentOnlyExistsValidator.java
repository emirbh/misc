package drr.base.trade.payment.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.payment.PeriodicPayment;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PeriodicPaymentOnlyExistsValidator implements ValidatorWithArg<PeriodicPayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PeriodicPayment> ValidationResult<PeriodicPayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedRateDayCountConvention", ExistenceChecker.isSet((InterestComputationMethod4Code) o.getFixedRateDayCountConvention()))
				.put("floatingRateDayCountConvention", ExistenceChecker.isSet((InterestComputationMethod4Code) o.getFloatingRateDayCountConvention()))
				.put("fixedRatePaymentFrequencyPeriod", ExistenceChecker.isSet((FrequencyPeriodEnum) o.getFixedRatePaymentFrequencyPeriod()))
				.put("floatingRatePaymentFrequencyPeriod", ExistenceChecker.isSet((FrequencyPeriodEnum) o.getFloatingRatePaymentFrequencyPeriod()))
				.put("fixedRatePaymentFrequencyPeriodMultiplier", ExistenceChecker.isSet((Integer) o.getFixedRatePaymentFrequencyPeriodMultiplier()))
				.put("floatingRatePaymentFrequencyPeriodMultiplier", ExistenceChecker.isSet((Integer) o.getFloatingRatePaymentFrequencyPeriodMultiplier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PeriodicPayment", ValidationResult.ValidationType.ONLY_EXISTS, "PeriodicPayment", path, "");
		}
		return failure("PeriodicPayment", ValidationResult.ValidationType.ONLY_EXISTS, "PeriodicPayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
