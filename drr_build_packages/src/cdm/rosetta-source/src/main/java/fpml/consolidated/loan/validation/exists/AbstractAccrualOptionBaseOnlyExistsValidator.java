package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractAccrualOptionBase;
import fpml.consolidated.loan.AccrualTypeId;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Period;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AbstractAccrualOptionBaseOnlyExistsValidator implements ValidatorWithArg<AbstractAccrualOptionBase, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends AbstractAccrualOptionBase> ValidationResult<AbstractAccrualOptionBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accrualOptionId", ExistenceChecker.isSet((AccrualTypeId) o.getAccrualOptionId()))
				.put("dayCountFraction", ExistenceChecker.isSet((DayCountFraction) o.getDayCountFraction()))
				.put("paymentFrequency", ExistenceChecker.isSet((Period) o.getPaymentFrequency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AbstractAccrualOptionBase", ValidationResult.ValidationType.ONLY_EXISTS, "AbstractAccrualOptionBase", path, "");
		}
		return failure("AbstractAccrualOptionBase", ValidationResult.ValidationType.ONLY_EXISTS, "AbstractAccrualOptionBase", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
