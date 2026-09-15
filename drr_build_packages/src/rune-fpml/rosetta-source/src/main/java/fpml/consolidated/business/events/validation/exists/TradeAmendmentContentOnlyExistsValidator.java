package fpml.consolidated.business.events.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.AmountRef;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.MoneyRef;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.UnitQuantityRef;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.fpmlenum.NotionalChangeEnum;
import fpml.consolidated.shared.Payment;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class TradeAmendmentContentOnlyExistsValidator implements ValidatorWithArg<TradeAmendmentContent, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends TradeAmendmentContent> ValidationResult<TradeAmendmentContent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("eventIdentifier", ExistenceChecker.isSet((List<? extends BusinessEventIdentifier>) o.getEventIdentifier()))
				.put("trade", ExistenceChecker.isSet((Trade) o.getTrade()))
				.put("agreementDate", ExistenceChecker.isSet((ZonedDateTime) o.getAgreementDate()))
				.put("executionDateTime", ExistenceChecker.isSet((ExecutionDateTime) o.getExecutionDateTime()))
				.put("effectiveDate", ExistenceChecker.isSet((ZonedDateTime) o.getEffectiveDate()))
				.put("notionalChange", ExistenceChecker.isSet((NotionalChangeEnum) o.getNotionalChange()))
				.put("changeInNotional", ExistenceChecker.isSet((List<? extends MoneyRef>) o.getChangeInNotional()))
				.put("changeInNumberOfOptions", ExistenceChecker.isSet((List<? extends AmountRef>) o.getChangeInNumberOfOptions()))
				.put("changeInQuantity", ExistenceChecker.isSet((List<? extends UnitQuantityRef>) o.getChangeInQuantity()))
				.put("payment", ExistenceChecker.isSet((List<? extends Payment>) o.getPayment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeAmendmentContent", ValidationResult.ValidationType.ONLY_EXISTS, "TradeAmendmentContent", path, "");
		}
		return failure("TradeAmendmentContent", ValidationResult.ValidationType.ONLY_EXISTS, "TradeAmendmentContent", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
