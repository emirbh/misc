package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.AbstractLoanAllocationEvent;
import fpml.consolidated.loan.LoanAllocationNotificationChoice0;
import fpml.consolidated.loan.LoanAllocationSettlementTask;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanAllocationNotificationChoice0DeepPathUtil {
	public String chooseComment(LoanAllocationNotificationChoice0 loanAllocationNotificationChoice0) {
		final MapperS<AbstractLoanAllocationEvent> loanAllocationEventGroup = MapperS.of(loanAllocationNotificationChoice0).<AbstractLoanAllocationEvent>map("getLoanAllocationEventGroup", _loanAllocationNotificationChoice0 -> _loanAllocationNotificationChoice0.getLoanAllocationEventGroup());
		if (exists(loanAllocationEventGroup).getOrDefault(false)) {
			return loanAllocationEventGroup.<String>map("getComment", abstractLoanAllocationEvent -> abstractLoanAllocationEvent.getComment()).get();
		}
		final MapperS<LoanAllocationSettlementTask> settlementTask = MapperS.of(loanAllocationNotificationChoice0).<LoanAllocationSettlementTask>map("getSettlementTask", _loanAllocationNotificationChoice0 -> _loanAllocationNotificationChoice0.getSettlementTask());
		if (exists(settlementTask).getOrDefault(false)) {
			return settlementTask.<String>map("getComment", loanAllocationSettlementTask -> loanAllocationSettlementTask.getComment()).get();
		}
		return null;
	}
	
}
