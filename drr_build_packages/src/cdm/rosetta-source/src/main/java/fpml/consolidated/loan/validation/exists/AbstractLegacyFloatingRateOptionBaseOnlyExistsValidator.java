package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLegacyFloatingRateOptionBase;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.loan.LegacyFloatingRateIndexLoan;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AbstractLegacyFloatingRateOptionBaseOnlyExistsValidator implements ValidatorWithArg<AbstractLegacyFloatingRateOptionBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AbstractLegacyFloatingRateOptionBase> ValidationResult<AbstractLegacyFloatingRateOptionBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accrualOptionId", ExistenceChecker.isSet((AccrualTypeId) o.getAccrualOptionId()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.put("legacyFloatingRateIndex", ExistenceChecker.isSet((LegacyFloatingRateIndexLoan) o.getLegacyFloatingRateIndex()))
				.put("indexTenor", ExistenceChecker.isSet((Period) o.getIndexTenor()))
				.put("spread", ExistenceChecker.isSet((BigDecimal) o.getSpread()))
				.put("pikSpread", ExistenceChecker.isSet((BigDecimal) o.getPikSpread()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AbstractLegacyFloatingRateOptionBase", ValidationResult.ValidationType.ONLY_EXISTS, "AbstractLegacyFloatingRateOptionBase", path, "");
		}
		return failure("AbstractLegacyFloatingRateOptionBase", ValidationResult.ValidationType.ONLY_EXISTS, "AbstractLegacyFloatingRateOptionBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
