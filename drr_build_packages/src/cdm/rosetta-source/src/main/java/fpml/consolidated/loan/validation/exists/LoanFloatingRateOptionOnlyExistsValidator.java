package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.LoanFloatingRate;
import fpml.consolidated.loan.LoanFloatingRateOption;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Period;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanFloatingRateOptionOnlyExistsValidator implements ValidatorWithArg<LoanFloatingRateOption, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanFloatingRateOption> ValidationResult<LoanFloatingRateOption> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accrualOptionId", ExistenceChecker.isSet((AccrualTypeId) o.getAccrualOptionId()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.put("rate", ExistenceChecker.isSet((LoanFloatingRate) o.getRate()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
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
			return success("LoanFloatingRateOption", ValidationResult.ValidationType.ONLY_EXISTS, "LoanFloatingRateOption", path, "");
		}
		return failure("LoanFloatingRateOption", ValidationResult.ValidationType.ONLY_EXISTS, "LoanFloatingRateOption", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
