package drr.regulation.common.trade.payment.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.IndexEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CommonPeriodicPaymentOnlyExistsValidator implements ValidatorWithArg<CommonPeriodicPayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CommonPeriodicPayment> ValidationResult<CommonPeriodicPayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fixedRateDayCountConvention", ExistenceChecker.isSet((InterestComputationMethod4Code) o.getFixedRateDayCountConvention()))
				.put("floatingRateDayCountConvention", ExistenceChecker.isSet((InterestComputationMethod4Code) o.getFloatingRateDayCountConvention()))
				.put("fixedRatePaymentFrequencyPeriod", ExistenceChecker.isSet((FrequencyPeriodEnum) o.getFixedRatePaymentFrequencyPeriod()))
				.put("floatingRatePaymentFrequencyPeriod", ExistenceChecker.isSet((FrequencyPeriodEnum) o.getFloatingRatePaymentFrequencyPeriod()))
				.put("fixedRatePaymentFrequencyPeriodMultiplier", ExistenceChecker.isSet((Integer) o.getFixedRatePaymentFrequencyPeriodMultiplier()))
				.put("floatingRatePaymentFrequencyPeriodMultiplier", ExistenceChecker.isSet((Integer) o.getFloatingRatePaymentFrequencyPeriodMultiplier()))
				.put("floatingRateResetFrequencyPeriod", ExistenceChecker.isSet((FrequencyPeriodEnum) o.getFloatingRateResetFrequencyPeriod()))
				.put("floatingRateResetFrequencyMultiplier", ExistenceChecker.isSet((Integer) o.getFloatingRateResetFrequencyMultiplier()))
				.put("floatingRateIndicator", ExistenceChecker.isSet((IndexEnum) o.getFloatingRateIndicator()))
				.put("floatingRateIdentifier", ExistenceChecker.isSet((String) o.getFloatingRateIdentifier()))
				.put("floatingRateReferencePeriod", ExistenceChecker.isSet((FrequencyPeriodEnum) o.getFloatingRateReferencePeriod()))
				.put("floatingRateReferencePeriodMultiplier", ExistenceChecker.isSet((Integer) o.getFloatingRateReferencePeriodMultiplier()))
				.put("nameOfTheFloatingRate", ExistenceChecker.isSet((String) o.getNameOfTheFloatingRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommonPeriodicPayment", ValidationResult.ValidationType.ONLY_EXISTS, "CommonPeriodicPayment", path, "");
		}
		return failure("CommonPeriodicPayment", ValidationResult.ValidationType.ONLY_EXISTS, "CommonPeriodicPayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
