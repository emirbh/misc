package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PaymentDetail;
import fpml.consolidated.shared.PaymentRule;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class PaymentDetailOnlyExistsValidator implements ValidatorWithArg<PaymentDetail, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PaymentDetail> ValidationResult<PaymentDetail> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getPaymentDate()))
				.put("paymentRule", ExistenceChecker.isSet((PaymentRule) o.getPaymentRule()))
				.put("paymentAmount", ExistenceChecker.isSet((Money) o.getPaymentAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PaymentDetail", ValidationResult.ValidationType.ONLY_EXISTS, "PaymentDetail", path, "");
		}
		return failure("PaymentDetail", ValidationResult.ValidationType.ONLY_EXISTS, "PaymentDetail", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
