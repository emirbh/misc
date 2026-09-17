package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanSimplePayment;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanSimplePaymentOnlyExistsValidator implements ValidatorWithArg<LoanSimplePayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanSimplePayment> ValidationResult<LoanSimplePayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("paymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPaymentAmount()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableDate) o.getPaymentDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanSimplePayment", ValidationResult.ValidationType.ONLY_EXISTS, "LoanSimplePayment", path, "");
		}
		return failure("LoanSimplePayment", ValidationResult.ValidationType.ONLY_EXISTS, "LoanSimplePayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
