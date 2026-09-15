package fpml.consolidated.doc.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.PackageSummary;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.ProductSummary;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.doc.TradeSummary;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.IssuerTradeId;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeHeaderOnlyExistsValidator implements ValidatorWithArg<TradeHeader, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeHeader> ValidationResult<TradeHeader> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("uniqueSwapIdentifier", ExistenceChecker.isSet((IssuerTradeId) o.getUniqueSwapIdentifier()))
				.put("uniqueTransactionIdentifier", ExistenceChecker.isSet((IssuerTradeId) o.getUniqueTransactionIdentifier()))
				.put("partyTradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getPartyTradeIdentifier()))
				.put("partyTradeInformation", ExistenceChecker.isSet((List<? extends PartyTradeInformation>) o.getPartyTradeInformation()))
				.put("tradeSummary", ExistenceChecker.isSet((TradeSummary) o.getTradeSummary()))
				.put("productSummary", ExistenceChecker.isSet((ProductSummary) o.getProductSummary()))
				.put("originatingPackage", ExistenceChecker.isSet((PackageSummary) o.getOriginatingPackage()))
				.put("tradeDate", ExistenceChecker.isSet((IdentifiedDate) o.getTradeDate()))
				.put("clearedDate", ExistenceChecker.isSet((IdentifiedDate) o.getClearedDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeHeader", ValidationResult.ValidationType.ONLY_EXISTS, "TradeHeader", path, "");
		}
		return failure("TradeHeader", ValidationResult.ValidationType.ONLY_EXISTS, "TradeHeader", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
