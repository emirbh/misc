package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.TradeIdentifierChoice;
import fpml.consolidated.loan.LoanAllocationIdentifier;
import fpml.consolidated.loan.LoanAllocationNotificationChoice1;
import fpml.consolidated.loan.LoanAllocationSummary;
import fpml.consolidated.loan.LoanAllocationType;
import fpml.consolidated.loan.LoanTradeReference;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.TradeId;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanAllocationNotificationChoice1DeepPathUtil {
	public List<TradeIdentifierChoice> chooseTradeIdentifierChoice(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
		final MapperS<LoanAllocationIdentifier> allocationId = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationIdentifier>map("getAllocationId", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationId());
		if (exists(allocationId).getOrDefault(false)) {
			return allocationId.<TradeIdentifierChoice>mapC("getTradeIdentifierChoice", loanAllocationIdentifier -> loanAllocationIdentifier.getTradeIdentifierChoice()).getMulti();
		}
		final MapperS<LoanAllocationSummary> allocationSummary = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationSummary>map("getAllocationSummary", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationSummary());
		if (exists(allocationSummary).getOrDefault(false)) {
			return allocationSummary.<TradeIdentifierChoice>mapC("getTradeIdentifierChoice", loanAllocationSummary -> loanAllocationSummary.getTradeIdentifierChoice()).getMulti();
		}
		final MapperS<LoanAllocationType> allocation = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationType>map("getAllocation", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocation());
		if (exists(allocation).getOrDefault(false)) {
			return allocation.<TradeIdentifierChoice>mapC("getTradeIdentifierChoice", loanAllocationType -> loanAllocationType.getTradeIdentifierChoice()).getMulti();
		}
		return Collections.<TradeIdentifierChoice>emptyList();
	}
	
	public AccountReference chooseAccountReference(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
		final MapperS<LoanAllocationIdentifier> allocationId = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationIdentifier>map("getAllocationId", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationId());
		if (exists(allocationId).getOrDefault(false)) {
			return allocationId.<AccountReference>map("getAccountReference", loanAllocationIdentifier -> loanAllocationIdentifier.getAccountReference()).get();
		}
		final MapperS<LoanAllocationSummary> allocationSummary = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationSummary>map("getAllocationSummary", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationSummary());
		if (exists(allocationSummary).getOrDefault(false)) {
			return allocationSummary.<AccountReference>map("getAccountReference", loanAllocationSummary -> loanAllocationSummary.getAccountReference()).get();
		}
		final MapperS<LoanAllocationType> allocation = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationType>map("getAllocation", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocation());
		if (exists(allocation).getOrDefault(false)) {
			return allocation.<AccountReference>map("getAccountReference", loanAllocationType -> loanAllocationType.getAccountReference()).get();
		}
		return null;
	}
	
	public String chooseId(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
		final MapperS<LoanAllocationIdentifier> allocationId = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationIdentifier>map("getAllocationId", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationId());
		if (exists(allocationId).getOrDefault(false)) {
			return allocationId.<String>map("getId", loanAllocationIdentifier -> loanAllocationIdentifier.getId()).get();
		}
		final MapperS<LoanAllocationSummary> allocationSummary = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationSummary>map("getAllocationSummary", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationSummary());
		if (exists(allocationSummary).getOrDefault(false)) {
			return allocationSummary.<String>map("getId", loanAllocationSummary -> loanAllocationSummary.getId()).get();
		}
		final MapperS<LoanAllocationType> allocation = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationType>map("getAllocation", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocation());
		if (exists(allocation).getOrDefault(false)) {
			return allocation.<String>map("getId", loanAllocationType -> loanAllocationType.getId()).get();
		}
		return null;
	}
	
	public PartyReference choosePartyReference(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
		final MapperS<LoanAllocationIdentifier> allocationId = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationIdentifier>map("getAllocationId", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationId());
		if (exists(allocationId).getOrDefault(false)) {
			return allocationId.<PartyReference>map("getPartyReference", loanAllocationIdentifier -> loanAllocationIdentifier.getPartyReference()).get();
		}
		final MapperS<LoanAllocationSummary> allocationSummary = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationSummary>map("getAllocationSummary", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationSummary());
		if (exists(allocationSummary).getOrDefault(false)) {
			return allocationSummary.<PartyReference>map("getPartyReference", loanAllocationSummary -> loanAllocationSummary.getPartyReference()).get();
		}
		final MapperS<LoanAllocationType> allocation = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationType>map("getAllocation", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocation());
		if (exists(allocation).getOrDefault(false)) {
			return allocation.<PartyReference>map("getPartyReference", loanAllocationType -> loanAllocationType.getPartyReference()).get();
		}
		return null;
	}
	
	public LoanTradeReference chooseLoanTradeReference(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
		final MapperS<LoanAllocationIdentifier> allocationId = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationIdentifier>map("getAllocationId", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationId());
		if (exists(allocationId).getOrDefault(false)) {
			return allocationId.<LoanTradeReference>map("getLoanTradeReference", loanAllocationIdentifier -> loanAllocationIdentifier.getLoanTradeReference()).get();
		}
		final MapperS<LoanAllocationSummary> allocationSummary = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationSummary>map("getAllocationSummary", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationSummary());
		if (exists(allocationSummary).getOrDefault(false)) {
			return allocationSummary.<LoanTradeReference>map("getLoanTradeReference", loanAllocationSummary -> loanAllocationSummary.getLoanTradeReference()).get();
		}
		final MapperS<LoanAllocationType> allocation = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationType>map("getAllocation", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocation());
		if (exists(allocation).getOrDefault(false)) {
			return allocation.<LoanTradeReference>map("getLoanTradeReference", loanAllocationType -> loanAllocationType.getLoanTradeReference()).get();
		}
		return null;
	}
	
	public IssuerId chooseIssuer(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
		final MapperS<LoanAllocationIdentifier> allocationId = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationIdentifier>map("getAllocationId", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationId());
		if (exists(allocationId).getOrDefault(false)) {
			return allocationId.<IssuerId>map("getIssuer", loanAllocationIdentifier -> loanAllocationIdentifier.getIssuer()).get();
		}
		final MapperS<LoanAllocationSummary> allocationSummary = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationSummary>map("getAllocationSummary", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationSummary());
		if (exists(allocationSummary).getOrDefault(false)) {
			return allocationSummary.<IssuerId>map("getIssuer", loanAllocationSummary -> loanAllocationSummary.getIssuer()).get();
		}
		final MapperS<LoanAllocationType> allocation = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationType>map("getAllocation", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocation());
		if (exists(allocation).getOrDefault(false)) {
			return allocation.<IssuerId>map("getIssuer", loanAllocationType -> loanAllocationType.getIssuer()).get();
		}
		return null;
	}
	
	public TradeId chooseTradeId(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1) {
		final MapperS<LoanAllocationIdentifier> allocationId = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationIdentifier>map("getAllocationId", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationId());
		if (exists(allocationId).getOrDefault(false)) {
			return allocationId.<TradeId>map("getTradeId", loanAllocationIdentifier -> loanAllocationIdentifier.getTradeId()).get();
		}
		final MapperS<LoanAllocationSummary> allocationSummary = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationSummary>map("getAllocationSummary", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocationSummary());
		if (exists(allocationSummary).getOrDefault(false)) {
			return allocationSummary.<TradeId>map("getTradeId", loanAllocationSummary -> loanAllocationSummary.getTradeId()).get();
		}
		final MapperS<LoanAllocationType> allocation = MapperS.of(loanAllocationNotificationChoice1).<LoanAllocationType>map("getAllocation", _loanAllocationNotificationChoice1 -> _loanAllocationNotificationChoice1.getAllocation());
		if (exists(allocation).getOrDefault(false)) {
			return allocation.<TradeId>map("getTradeId", loanAllocationType -> loanAllocationType.getTradeId()).get();
		}
		return null;
	}
	
}
