package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.AbstractFacilityEvent;
import fpml.consolidated.loan.AbstractLcEvent;
import fpml.consolidated.loan.AbstractLoanServicingEvent;
import fpml.consolidated.loan.LoanLegalActionApprovalStatus;
import fpml.consolidated.loan.LoanLegalActionNotificationChoice0;
import fpml.consolidated.loan.LoanLegalActionReference;
import fpml.consolidated.loan.LoanLegalActionStatus;
import fpml.consolidated.loan.LoanLegalActionTask;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanLegalActionNotificationChoice0DeepPathUtil {
	public LoanLegalActionReference chooseLegalActionReference(LoanLegalActionNotificationChoice0 loanLegalActionNotificationChoice0) {
		final MapperS<AbstractFacilityEvent> facilityEventGroup = MapperS.of(loanLegalActionNotificationChoice0).<AbstractFacilityEvent>map("getFacilityEventGroup", _loanLegalActionNotificationChoice0 -> _loanLegalActionNotificationChoice0.getFacilityEventGroup());
		if (exists(facilityEventGroup).getOrDefault(false)) {
			return facilityEventGroup.<LoanLegalActionReference>map("getLegalActionReference", abstractFacilityEvent -> abstractFacilityEvent.getLegalActionReference()).get();
		}
		final MapperS<AbstractLcEvent> lcEventGroup = MapperS.of(loanLegalActionNotificationChoice0).<AbstractLcEvent>map("getLcEventGroup", _loanLegalActionNotificationChoice0 -> _loanLegalActionNotificationChoice0.getLcEventGroup());
		if (exists(lcEventGroup).getOrDefault(false)) {
			return lcEventGroup.<LoanLegalActionReference>map("getLegalActionReference", abstractLcEvent -> abstractLcEvent.getLegalActionReference()).get();
		}
		final MapperS<AbstractLoanServicingEvent> loanContractEventGroup = MapperS.of(loanLegalActionNotificationChoice0).<AbstractLoanServicingEvent>map("getLoanContractEventGroup", _loanLegalActionNotificationChoice0 -> _loanLegalActionNotificationChoice0.getLoanContractEventGroup());
		if (exists(loanContractEventGroup).getOrDefault(false)) {
			return loanContractEventGroup.<LoanLegalActionReference>map("getLegalActionReference", abstractLoanServicingEvent -> abstractLoanServicingEvent.getLegalActionReference()).get();
		}
		final MapperS<LoanLegalActionTask> legalActionTask = MapperS.of(loanLegalActionNotificationChoice0).<LoanLegalActionTask>map("getLegalActionTask", _loanLegalActionNotificationChoice0 -> _loanLegalActionNotificationChoice0.getLegalActionTask());
		if (exists(legalActionTask).getOrDefault(false)) {
			return legalActionTask.<LoanLegalActionReference>map("getLegalActionReference", loanLegalActionTask -> loanLegalActionTask.getLegalActionReference()).get();
		}
		final MapperS<LoanLegalActionStatus> legalActionStatus = MapperS.of(loanLegalActionNotificationChoice0).<LoanLegalActionStatus>map("getLegalActionStatus", _loanLegalActionNotificationChoice0 -> _loanLegalActionNotificationChoice0.getLegalActionStatus());
		if (exists(legalActionStatus).getOrDefault(false)) {
			return legalActionStatus.<LoanLegalActionReference>map("getLegalActionReference", loanLegalActionStatus -> loanLegalActionStatus.getLegalActionReference()).get();
		}
		final MapperS<LoanLegalActionApprovalStatus> legalActionApprovalStatus = MapperS.of(loanLegalActionNotificationChoice0).<LoanLegalActionApprovalStatus>map("getLegalActionApprovalStatus", _loanLegalActionNotificationChoice0 -> _loanLegalActionNotificationChoice0.getLegalActionApprovalStatus());
		if (exists(legalActionApprovalStatus).getOrDefault(false)) {
			return legalActionApprovalStatus.<LoanLegalActionReference>map("getLegalActionReference", loanLegalActionApprovalStatus -> loanLegalActionApprovalStatus.getLegalActionReference()).get();
		}
		return null;
	}
	
}
