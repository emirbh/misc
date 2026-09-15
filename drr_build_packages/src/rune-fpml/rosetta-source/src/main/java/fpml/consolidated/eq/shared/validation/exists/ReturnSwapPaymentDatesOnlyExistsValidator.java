package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.ReturnSwapPaymentDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AdjustableOrRelativeDates;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnSwapPaymentDatesOnlyExistsValidator implements ValidatorWithArg<ReturnSwapPaymentDates, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnSwapPaymentDates> ValidationResult<ReturnSwapPaymentDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("paymentDatesInterim", ExistenceChecker.isSet((AdjustableOrRelativeDates) o.getPaymentDatesInterim()))
				.put("paymentDateFinal", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getPaymentDateFinal()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnSwapPaymentDates", ValidationResult.ValidationType.ONLY_EXISTS, "ReturnSwapPaymentDates", path, "");
		}
		return failure("ReturnSwapPaymentDates", ValidationResult.ValidationType.ONLY_EXISTS, "ReturnSwapPaymentDates", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
