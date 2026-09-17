package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.TradeLegPriceChange;
import fpml.consolidated.business.events.TradeLegSizeChange;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Payment;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeNotionalChangeOnlyExistsValidator implements ValidatorWithArg<TradeNotionalChange, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeNotionalChange> ValidationResult<TradeNotionalChange> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("tradeIdentifier", ExistenceChecker.isSet((List<? extends PartyTradeIdentifier>) o.getTradeIdentifier()))
				.put("originalTrade", ExistenceChecker.isSet((Trade) o.getOriginalTrade()))
				.put("resultingTrade", ExistenceChecker.isSet((Trade) o.getResultingTrade()))
				.put("agreementDate", ExistenceChecker.isSet((ZonedDateTime) o.getAgreementDate()))
				.put("executionDateTime", ExistenceChecker.isSet((ExecutionDateTime) o.getExecutionDateTime()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("payment", ExistenceChecker.isSet((List<? extends Payment>) o.getPayment()))
				.put("changeInNotionalAmount", ExistenceChecker.isSet((List<? extends NonNegativeMoney>) o.getChangeInNotionalAmount()))
				.put("outstandingNotionalAmount", ExistenceChecker.isSet((List<? extends NonNegativeMoney>) o.getOutstandingNotionalAmount()))
				.put("changeInNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getChangeInNumberOfOptions()))
				.put("outstandingNumberOfOptions", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfOptions()))
				.put("changeInNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getChangeInNumberOfUnits()))
				.put("outstandingNumberOfUnits", ExistenceChecker.isSet((BigDecimal) o.getOutstandingNumberOfUnits()))
				.put("sizeChange", ExistenceChecker.isSet((List<? extends TradeLegSizeChange>) o.getSizeChange()))
				.put("priceChange", ExistenceChecker.isSet((List<? extends TradeLegPriceChange>) o.getPriceChange()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeNotionalChange", ValidationResult.ValidationType.ONLY_EXISTS, "TradeNotionalChange", path, "");
		}
		return failure("TradeNotionalChange", ValidationResult.ValidationType.ONLY_EXISTS, "TradeNotionalChange", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
