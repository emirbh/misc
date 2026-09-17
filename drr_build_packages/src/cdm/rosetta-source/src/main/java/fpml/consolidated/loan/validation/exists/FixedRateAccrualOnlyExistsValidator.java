package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.FixedRateAccrual;
import fpml.consolidated.loan.PaymentProjection;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FixedRateAccrualOnlyExistsValidator implements ValidatorWithArg<FixedRateAccrual, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FixedRateAccrual> ValidationResult<FixedRateAccrual> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accrualOptionId", ExistenceChecker.isSet((AccrualTypeId) o.getAccrualOptionId()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.put("pikSpread", ExistenceChecker.isSet((BigDecimal) o.getPikSpread()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
				.put("numberOfDays", ExistenceChecker.isSet((Integer) o.getNumberOfDays()))
				.put("penaltySpread", ExistenceChecker.isSet((BigDecimal) o.getPenaltySpread()))
				.put("defaultSpread", ExistenceChecker.isSet((BigDecimal) o.getDefaultSpread()))
				.put("mandatoryCostRate", ExistenceChecker.isSet((BigDecimal) o.getMandatoryCostRate()))
				.put("allInRate", ExistenceChecker.isSet((BigDecimal) o.getAllInRate()))
				.put("paymentProjection", ExistenceChecker.isSet((PaymentProjection) o.getPaymentProjection()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FixedRateAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "FixedRateAccrual", path, "");
		}
		return failure("FixedRateAccrual", ValidationResult.ValidationType.ONLY_EXISTS, "FixedRateAccrual", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
