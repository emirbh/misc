package fpml.consolidated.shared.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.CashflowId;
import fpml.consolidated.shared.CashflowType;
import fpml.consolidated.shared.GrossCashflow;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.PartyTradeIdentifierReference;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class GrossCashflowOnlyExistsValidator implements ValidatorWithArg<GrossCashflow, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends GrossCashflow> ValidationResult<GrossCashflow> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashflowId", ExistenceChecker.isSet((CashflowId) o.getCashflowId()))
				.put("partyTradeIdentifierReference", ExistenceChecker.isSet((PartyTradeIdentifierReference) o.getPartyTradeIdentifierReference()))
				.put("payerPartyReference", ExistenceChecker.isSet((PartyReference) o.getPayerPartyReference()))
				.put("payerAccountReference", ExistenceChecker.isSet((AccountReference) o.getPayerAccountReference()))
				.put("receiverPartyReference", ExistenceChecker.isSet((PartyReference) o.getReceiverPartyReference()))
				.put("receiverAccountReference", ExistenceChecker.isSet((AccountReference) o.getReceiverAccountReference()))
				.put("cashflowAmount", ExistenceChecker.isSet((Money) o.getCashflowAmount()))
				.put("cashflowType", ExistenceChecker.isSet((CashflowType) o.getCashflowType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GrossCashflow", ValidationResult.ValidationType.ONLY_EXISTS, "GrossCashflow", path, "");
		}
		return failure("GrossCashflow", ValidationResult.ValidationType.ONLY_EXISTS, "GrossCashflow", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
