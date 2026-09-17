package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.AbstractFacilityEvent;
import fpml.consolidated.loan.AbstractLcEvent;
import fpml.consolidated.loan.AbstractLoanServicingEvent;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.LoanBulkServicingNotificationChoice;
import fpml.consolidated.loan.LoanLegalActionReference;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanBulkServicingNotificationChoiceDeepPathUtil {
	public BusinessEventIdentifier choosePreviousEventIdentifier(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<BusinessEventIdentifier>map("getPreviousEventIdentifier", abstractFacilityEvent -> abstractFacilityEvent.getPreviousEventIdentifier()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<BusinessEventIdentifier>map("getPreviousEventIdentifier", abstractLcEvent -> abstractLcEvent.getPreviousEventIdentifier()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<BusinessEventIdentifier>map("getPreviousEventIdentifier", abstractLoanServicingEvent -> abstractLoanServicingEvent.getPreviousEventIdentifier()).get();
		}
		return null;
	}
	
	public CashPayable chooseCashPayable(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<CashPayable>map("getCashPayable", abstractFacilityEvent -> abstractFacilityEvent.getCashPayable()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<CashPayable>map("getCashPayable", abstractLcEvent -> abstractLcEvent.getCashPayable()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<CashPayable>map("getCashPayable", abstractLoanServicingEvent -> abstractLoanServicingEvent.getCashPayable()).get();
		}
		return null;
	}
	
	public PartyReference chooseBorrowerPartyReference(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<PartyReference>map("getBorrowerPartyReference", abstractFacilityEvent -> abstractFacilityEvent.getBorrowerPartyReference()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<PartyReference>map("getBorrowerPartyReference", abstractLcEvent -> abstractLcEvent.getBorrowerPartyReference()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<PartyReference>map("getBorrowerPartyReference", abstractLoanServicingEvent -> abstractLoanServicingEvent.getBorrowerPartyReference()).get();
		}
		return null;
	}
	
	public BusinessEventIdentifier chooseCorrectedEventIdentifier(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", abstractFacilityEvent -> abstractFacilityEvent.getCorrectedEventIdentifier()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", abstractLcEvent -> abstractLcEvent.getCorrectedEventIdentifier()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<BusinessEventIdentifier>map("getCorrectedEventIdentifier", abstractLoanServicingEvent -> abstractLoanServicingEvent.getCorrectedEventIdentifier()).get();
		}
		return null;
	}
	
	public String chooseComment(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<String>map("getComment", abstractFacilityEvent -> abstractFacilityEvent.getComment()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<String>map("getComment", abstractLcEvent -> abstractLcEvent.getComment()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<String>map("getComment", abstractLoanServicingEvent -> abstractLoanServicingEvent.getComment()).get();
		}
		return null;
	}
	
	public ParentEventIdentifier chooseParentEventIdentifier(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<ParentEventIdentifier>map("getParentEventIdentifier", abstractFacilityEvent -> abstractFacilityEvent.getParentEventIdentifier()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<ParentEventIdentifier>map("getParentEventIdentifier", abstractLcEvent -> abstractLcEvent.getParentEventIdentifier()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<ParentEventIdentifier>map("getParentEventIdentifier", abstractLoanServicingEvent -> abstractLoanServicingEvent.getParentEventIdentifier()).get();
		}
		return null;
	}
	
	public List<BusinessEventIdentifier> chooseEventIdentifier(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<BusinessEventIdentifier>mapC("getEventIdentifier", abstractFacilityEvent -> abstractFacilityEvent.getEventIdentifier()).getMulti();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<BusinessEventIdentifier>mapC("getEventIdentifier", abstractLcEvent -> abstractLcEvent.getEventIdentifier()).getMulti();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<BusinessEventIdentifier>mapC("getEventIdentifier", abstractLoanServicingEvent -> abstractLoanServicingEvent.getEventIdentifier()).getMulti();
		}
		return Collections.<BusinessEventIdentifier>emptyList();
	}
	
	public PartyReference chooseLenderPartyReference(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<PartyReference>map("getLenderPartyReference", abstractFacilityEvent -> abstractFacilityEvent.getLenderPartyReference()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<PartyReference>map("getLenderPartyReference", abstractLcEvent -> abstractLcEvent.getLenderPartyReference()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<PartyReference>map("getLenderPartyReference", abstractLoanServicingEvent -> abstractLoanServicingEvent.getLenderPartyReference()).get();
		}
		return null;
	}
	
	public PartyReference chooseAgentPartyReference(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<PartyReference>map("getAgentPartyReference", abstractFacilityEvent -> abstractFacilityEvent.getAgentPartyReference()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<PartyReference>map("getAgentPartyReference", abstractLcEvent -> abstractLcEvent.getAgentPartyReference()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<PartyReference>map("getAgentPartyReference", abstractLoanServicingEvent -> abstractLoanServicingEvent.getAgentPartyReference()).get();
		}
		return null;
	}
	
	public ZonedDateTime chooseEffectiveDate(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<ZonedDateTime>map("getEffectiveDate", abstractFacilityEvent -> abstractFacilityEvent.getEffectiveDate()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<ZonedDateTime>map("getEffectiveDate", abstractLcEvent -> abstractLcEvent.getEffectiveDate()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<ZonedDateTime>map("getEffectiveDate", abstractLoanServicingEvent -> abstractLoanServicingEvent.getEffectiveDate()).get();
		}
		return null;
	}
	
	public LoanLegalActionReference chooseLegalActionReference(LoanBulkServicingNotificationChoice loanBulkServicingNotificationChoice) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<LoanLegalActionReference>map("getLegalActionReference", abstractFacilityEvent -> abstractFacilityEvent.getLegalActionReference()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLcEvent>map("getLcEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<LoanLegalActionReference>map("getLegalActionReference", abstractLcEvent -> abstractLcEvent.getLegalActionReference()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanBulkServicingNotificationChoice).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanBulkServicingNotificationChoice -> _loanBulkServicingNotificationChoice.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<LoanLegalActionReference>map("getLegalActionReference", abstractLoanServicingEvent -> abstractLoanServicingEvent.getLegalActionReference()).get();
		}
		return null;
	}
	
}
