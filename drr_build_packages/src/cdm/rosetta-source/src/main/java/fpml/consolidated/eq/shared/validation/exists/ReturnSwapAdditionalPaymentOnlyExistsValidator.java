package fpml.consolidated.eq.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.AdditionalPaymentAmount;
import fpml.consolidated.eq.shared.ReturnSwapAdditionalPayment;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PaymentType;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class ReturnSwapAdditionalPaymentOnlyExistsValidator implements ValidatorWithArg<ReturnSwapAdditionalPayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends ReturnSwapAdditionalPayment> ValidationResult<ReturnSwapAdditionalPayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("additionalPaymentAmount", ExistenceChecker.isSet((AdditionalPaymentAmount) o.getAdditionalPaymentAmount()))
				.put("additionalPaymentDate", ExistenceChecker.isSet((AdjustableOrRelativeDate) o.getAdditionalPaymentDate()))
				.put("paymentType", ExistenceChecker.isSet((PaymentType) o.getPaymentType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReturnSwapAdditionalPayment", ValidationResult.ValidationType.ONLY_EXISTS, "ReturnSwapAdditionalPayment", path, "");
		}
		return failure("ReturnSwapAdditionalPayment", ValidationResult.ValidationType.ONLY_EXISTS, "ReturnSwapAdditionalPayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
