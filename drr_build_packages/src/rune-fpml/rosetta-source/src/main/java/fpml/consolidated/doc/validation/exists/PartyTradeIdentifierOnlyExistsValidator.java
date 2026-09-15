package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.LinkId;
import fpml.consolidated.doc.LinkedTrade;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.ProductComponentIdentifier;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.doc.TradeIdentifierExtended;
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

public class PartyTradeIdentifierOnlyExistsValidator implements ValidatorWithArg<PartyTradeIdentifier, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends PartyTradeIdentifier> ValidationResult<PartyTradeIdentifier> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("issuer", ExistenceChecker.isSet((IssuerId) o.getIssuer()))
				.put("tradeId", ExistenceChecker.isSet((TradeId) o.getTradeId()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("accountReference", ExistenceChecker.isSet((AccountReference) o.getAccountReference()))
				.put("tradeIdentifierChoice", ExistenceChecker.isSet((List<? extends TradeIdentifierChoice>) o.getTradeIdentifierChoice()))
				.put("linkId", ExistenceChecker.isSet((List<? extends LinkId>) o.getLinkId()))
				.put("allocationTradeId", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getAllocationTradeId()))
				.put("resultingTradeId", ExistenceChecker.isSet((List<? extends TradeIdentifierExtended>) o.getResultingTradeId()))
				.put("blockTradeId", ExistenceChecker.isSet((TradeIdentifier) o.getBlockTradeId()))
				.put("originatingTradeId", ExistenceChecker.isSet((List<? extends TradeIdentifier>) o.getOriginatingTradeId()))
				.put("productComponentIdentifier", ExistenceChecker.isSet((List<? extends ProductComponentIdentifier>) o.getProductComponentIdentifier()))
				.put("linkedTrade", ExistenceChecker.isSet((List<? extends LinkedTrade>) o.getLinkedTrade()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyTradeIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "PartyTradeIdentifier", path, "");
		}
		return failure("PartyTradeIdentifier", ValidationResult.ValidationType.ONLY_EXISTS, "PartyTradeIdentifier", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
