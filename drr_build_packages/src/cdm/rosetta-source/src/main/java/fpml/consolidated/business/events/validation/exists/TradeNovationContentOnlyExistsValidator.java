package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.TradeLegSizeChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.doc.CreditDerivativesNotices;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.FirstPeriodStartDate;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.ContractualDefinitions;
import fpml.consolidated.shared.ContractualTermsSupplement;
import fpml.consolidated.shared.Empty;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeNovationContentOnlyExistsValidator implements ValidatorWithArg<TradeNovationContent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeNovationContent> ValidationResult<TradeNovationContent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("newTradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getNewTradeIdentifier()))
				.put("newTrade", ExistenceChecker.isSet((Trade) o.getNewTrade()))
				.put("oldTradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getOldTradeIdentifier()))
				.put("oldTrade", ExistenceChecker.isSet((Trade) o.getOldTrade()))
				.put("feeTradeIdentifier", ExistenceChecker.isSet((PartyTradeIdentifier) o.getFeeTradeIdentifier()))
				.put("feeTrade", ExistenceChecker.isSet((Trade) o.getFeeTrade()))
				.put("transferor", ExistenceChecker.isSet((PartyReference) o.getTransferor()))
				.put("transferorAccount", ExistenceChecker.isSet((AccountReference) o.getTransferorAccount()))
				.put("transferee", ExistenceChecker.isSet((PartyReference) o.getTransferee()))
				.put("otherTransferee", ExistenceChecker.isSet((PartyReference) o.getOtherTransferee()))
				.put("transfereeAccount", ExistenceChecker.isSet((AccountReference) o.getTransfereeAccount()))
				.put("otherTransfereeAccount", ExistenceChecker.isSet((AccountReference) o.getOtherTransfereeAccount()))
				.put("remainingParty", ExistenceChecker.isSet((PartyReference) o.getRemainingParty()))
				.put("remainingPartyAccount", ExistenceChecker.isSet((AccountReference) o.getRemainingPartyAccount()))
				.put("otherRemainingParty", ExistenceChecker.isSet((PartyReference) o.getOtherRemainingParty()))
				.put("otherRemainingPartyAccount", ExistenceChecker.isSet((AccountReference) o.getOtherRemainingPartyAccount()))
				.put("novationDate", ExistenceChecker.isSet((ZonedDateTime) o.getNovationDate()))
				.put("executionDateTime", ExistenceChecker.isSet((ExecutionDateTime) o.getExecutionDateTime()))
				.put("novationTradeDate", ExistenceChecker.isSet((ZonedDateTime) o.getNovationTradeDate()))
				.put("novatedAmount", ExistenceChecker.isSet((List<? extends Money>) o.getNovatedAmount()))
				.put("remainingAmount", ExistenceChecker.isSet((List<? extends Money>) o.getRemainingAmount()))
				.put("novatedNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getNovatedNumberOfOptions()))
				.put("remainingNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getRemainingNumberOfOptions()))
				.put("novatedNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getNovatedNumberOfUnits()))
				.put("remainingNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getRemainingNumberOfUnits()))
				.put("novationAmount", ExistenceChecker.isSet((List<? extends TradeLegSizeChange>) o.getNovationAmount()))
				.put("fullFirstCalculationPeriod", ExistenceChecker.isSet((Boolean) o.getFullFirstCalculationPeriod()))
				.put("firstPeriodStartDate", ExistenceChecker.isSet((List<? extends FirstPeriodStartDate>) o.getFirstPeriodStartDate()))
				.put("nonReliance", ExistenceChecker.isSet((Empty) o.getNonReliance()))
				.put("creditDerivativesNotices", ExistenceChecker.isSet((CreditDerivativesNotices) o.getCreditDerivativesNotices()))
				.put("contractualDefinitions", ExistenceChecker.isSet((List<? extends ContractualDefinitions>) o.getContractualDefinitions()))
				.put("contractualTermsSupplement", ExistenceChecker.isSet((List<? extends ContractualTermsSupplement>) o.getContractualTermsSupplement()))
				.put("payment", ExistenceChecker.isSet((Payment) o.getPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeNovationContent", ValidationResult.ValidationType.ONLY_EXISTS, "TradeNovationContent", path, "");
		}
		return failure("TradeNovationContent", ValidationResult.ValidationType.ONLY_EXISTS, "TradeNovationContent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
