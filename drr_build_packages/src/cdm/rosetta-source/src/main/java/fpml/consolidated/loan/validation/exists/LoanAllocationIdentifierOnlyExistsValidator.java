package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.loan.LoanAllocationIdentifier;
import fpml.consolidated.loan.LoanTradeReference;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanAllocationIdentifierOnlyExistsValidator implements ValidatorWithArg<LoanAllocationIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanAllocationIdentifier> ValidationResult<LoanAllocationIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("issuer", ExistenceChecker.isSet((IssuerId) o.getIssuer()))
				.put("tradeId", ExistenceChecker.isSet((TradeId) o.getTradeId()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("accountReference", ExistenceChecker.isSet((AccountReference) o.getAccountReference()))
				.put("tradeIdentifierChoice", ExistenceChecker.isSet((List<? extends TradeIdentifierChoice>) o.getTradeIdentifierChoice()))
				.put("loanTradeReference", ExistenceChecker.isSet((LoanTradeReference) o.getLoanTradeReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanAllocationIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationIdentifier", path, "");
		}
		return failure("LoanAllocationIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
