package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlenum.AccrualReferenceAmountTypeEnum;
import fpml.consolidated.loan.LegacyAccrualPeriod;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LegacyAccrualPeriodOnlyExistsValidator implements ValidatorWithArg<LegacyAccrualPeriod, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LegacyAccrualPeriod> ValidationResult<LegacyAccrualPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("startDate", ExistenceChecker.isSet((ZonedDateTime) o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet((ZonedDateTime) o.getEndDate()))
				.put("numberOfDays", ExistenceChecker.isSet((Integer) o.getNumberOfDays()))
				.put("referenceAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getReferenceAmount()))
				.put("referenceAmountType", ExistenceChecker.isSet((AccrualReferenceAmountTypeEnum) o.getReferenceAmountType()))
				.put("rate", ExistenceChecker.isSet((BigDecimal) o.getRate()))
				.put("accrualAmount", ExistenceChecker.isSet((MoneyWithParticipantShare) o.getAccrualAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegacyAccrualPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyAccrualPeriod", path, "");
		}
		return failure("LegacyAccrualPeriod", ValidationResult.ValidationType.ONLY_EXISTS, "LegacyAccrualPeriod", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
