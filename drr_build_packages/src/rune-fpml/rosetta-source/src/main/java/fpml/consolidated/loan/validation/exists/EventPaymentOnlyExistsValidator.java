package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.EventPayment;
import fpml.consolidated.loan.EventPaymentSequence;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SettlementInstruction;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class EventPaymentOnlyExistsValidator implements ValidatorWithArg<EventPayment, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends EventPayment> ValidationResult<EventPayment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("paymentAmount", ExistenceChecker.isSet((NonNegativeMoney) o.getPaymentAmount()))
				.put("paymentDate", ExistenceChecker.isSet((AdjustableDate) o.getPaymentDate()))
				.put("eventPaymentSequence", ExistenceChecker.isSet((List<? extends EventPaymentSequence>) o.getEventPaymentSequence()))
				.put("settlementInstruction", ExistenceChecker.isSet((SettlementInstruction) o.getSettlementInstruction()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EventPayment", ValidationResult.ValidationType.ONLY_EXISTS, "EventPayment", path, "");
		}
		return failure("EventPayment", ValidationResult.ValidationType.ONLY_EXISTS, "EventPayment", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
