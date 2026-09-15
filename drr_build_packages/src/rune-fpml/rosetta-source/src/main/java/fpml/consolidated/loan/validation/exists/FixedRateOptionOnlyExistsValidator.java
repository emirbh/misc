package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.FixedRateOption;
import fpml.consolidated.loan.RateLimits;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FixedRateOptionOnlyExistsValidator implements ValidatorWithArg<FixedRateOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FixedRateOption> ValidationResult<FixedRateOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accrualOptionId", ExistenceChecker.isSet((AccrualTypeId) o.getAccrualOptionId()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.put("pikSpread", ExistenceChecker.isSet((BigDecimal) o.getPikSpread()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("allInRateLimits", ExistenceChecker.isSet((RateLimits) o.getAllInRateLimits()))
				.put("borrowerPartyReference", ExistenceChecker.isSet((List<? extends PartyReference>) o.getBorrowerPartyReference()))
				.put("drawdownNoticeDays", ExistenceChecker.isSet((Integer) o.getDrawdownNoticeDays()))
				.put("fxRateSetNoticeDays", ExistenceChecker.isSet((Integer) o.getFxRateSetNoticeDays()))
				.put("rateSetNoticeDays", ExistenceChecker.isSet((Integer) o.getRateSetNoticeDays()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FixedRateOption", ValidationResult.ValidationType.ONLY_EXISTS, "FixedRateOption", path, "");
		}
		return failure("FixedRateOption", ValidationResult.ValidationType.ONLY_EXISTS, "FixedRateOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
