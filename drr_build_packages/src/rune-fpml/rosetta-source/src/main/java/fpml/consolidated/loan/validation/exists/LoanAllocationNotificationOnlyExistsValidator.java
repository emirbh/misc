package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.LoanAllocationNotification;
import fpml.consolidated.loan.LoanAllocationNotificationChoice0;
import fpml.consolidated.loan.LoanAllocationNotificationChoice1;
import fpml.consolidated.loan.LoanAllocationNotificationChoice2;
import fpml.consolidated.loan.LoanAllocationPayment;
import fpml.consolidated.loan.LoanTradeSummary;
import fpml.consolidated.loan.LoanTradingPartyRole;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanAllocationNotificationOnlyExistsValidator implements ValidatorWithArg<LoanAllocationNotification, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanAllocationNotification> ValidationResult<LoanAllocationNotification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validation", ExistenceChecker.isSet((List<? extends Validation>) o.getValidation()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("parentCorrelationId", ExistenceChecker.isSet((CorrelationId) o.getParentCorrelationId()))
				.put("correlationId", ExistenceChecker.isSet((List<? extends CorrelationId>) o.getCorrelationId()))
				.put("sequenceNumber", ExistenceChecker.isSet((Integer) o.getSequenceNumber()))
				.put("onBehalfOf", ExistenceChecker.isSet((List<? extends OnBehalfOf>) o.getOnBehalfOf()))
				.put("noticeDate", ExistenceChecker.isSet((ZonedDateTime) o.getNoticeDate()))
				.put("partyReference", ExistenceChecker.isSet((PartyReference) o.getPartyReference()))
				.put("role", ExistenceChecker.isSet((LoanTradingPartyRole) o.getRole()))
				.put("payment", ExistenceChecker.isSet((List<? extends LoanAllocationPayment>) o.getPayment()))
				.put("loanAllocationNotificationChoice0", ExistenceChecker.isSet((List<? extends LoanAllocationNotificationChoice0>) o.getLoanAllocationNotificationChoice0()))
				.put("loanAllocationNotificationChoice1", ExistenceChecker.isSet((List<? extends LoanAllocationNotificationChoice1>) o.getLoanAllocationNotificationChoice1()))
				.put("tradeIdentifier", ExistenceChecker.isSet((TradeIdentifier) o.getTradeIdentifier()))
				.put("tradeSummary", ExistenceChecker.isSet((LoanTradeSummary) o.getTradeSummary()))
				.put("dealIdentifier", ExistenceChecker.isSet((DealIdentifier) o.getDealIdentifier()))
				.put("dealSummary", ExistenceChecker.isSet((DealSummary) o.getDealSummary()))
				.put("facilityIdentifier", ExistenceChecker.isSet((FacilityIdentifier) o.getFacilityIdentifier()))
				.put("facilitySummary", ExistenceChecker.isSet((FacilitySummary) o.getFacilitySummary()))
				.put("loanAllocationNotificationChoice2", ExistenceChecker.isSet((List<? extends LoanAllocationNotificationChoice2>) o.getLoanAllocationNotificationChoice2()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanAllocationNotification", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationNotification", path, "");
		}
		return failure("LoanAllocationNotification", ValidationResult.ValidationType.ONLY_EXISTS, "LoanAllocationNotification", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
