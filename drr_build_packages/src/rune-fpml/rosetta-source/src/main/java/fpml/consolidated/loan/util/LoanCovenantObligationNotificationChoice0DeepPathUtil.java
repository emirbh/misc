package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice0;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanCovenantObligationNotificationChoice0DeepPathUtil {
	public List<InstrumentId> chooseInstrumentId(LoanCovenantObligationNotificationChoice0 loanCovenantObligationNotificationChoice0) {
		final MapperS<DealIdentifier> dealIdentifier = MapperS.of(loanCovenantObligationNotificationChoice0).<DealIdentifier>map("getDealIdentifier", _loanCovenantObligationNotificationChoice0 -> _loanCovenantObligationNotificationChoice0.getDealIdentifier());
		if (exists(dealIdentifier).getOrDefault(false)) {
			return dealIdentifier.<InstrumentId>mapC("getInstrumentId", _dealIdentifier -> _dealIdentifier.getInstrumentId()).getMulti();
		}
		final MapperS<DealSummary> dealSummary = MapperS.of(loanCovenantObligationNotificationChoice0).<DealSummary>map("getDealSummary", _loanCovenantObligationNotificationChoice0 -> _loanCovenantObligationNotificationChoice0.getDealSummary());
		if (exists(dealSummary).getOrDefault(false)) {
			return dealSummary.<InstrumentId>mapC("getInstrumentId", _dealSummary -> _dealSummary.getInstrumentId()).getMulti();
		}
		return Collections.<InstrumentId>emptyList();
	}
	
	public String chooseDescription(LoanCovenantObligationNotificationChoice0 loanCovenantObligationNotificationChoice0) {
		final MapperS<DealIdentifier> dealIdentifier = MapperS.of(loanCovenantObligationNotificationChoice0).<DealIdentifier>map("getDealIdentifier", _loanCovenantObligationNotificationChoice0 -> _loanCovenantObligationNotificationChoice0.getDealIdentifier());
		if (exists(dealIdentifier).getOrDefault(false)) {
			return dealIdentifier.<String>map("getDescription", _dealIdentifier -> _dealIdentifier.getDescription()).get();
		}
		final MapperS<DealSummary> dealSummary = MapperS.of(loanCovenantObligationNotificationChoice0).<DealSummary>map("getDealSummary", _loanCovenantObligationNotificationChoice0 -> _loanCovenantObligationNotificationChoice0.getDealSummary());
		if (exists(dealSummary).getOrDefault(false)) {
			return dealSummary.<String>map("getDescription", _dealSummary -> _dealSummary.getDescription()).get();
		}
		return null;
	}
	
	public String chooseId(LoanCovenantObligationNotificationChoice0 loanCovenantObligationNotificationChoice0) {
		final MapperS<DealIdentifier> dealIdentifier = MapperS.of(loanCovenantObligationNotificationChoice0).<DealIdentifier>map("getDealIdentifier", _loanCovenantObligationNotificationChoice0 -> _loanCovenantObligationNotificationChoice0.getDealIdentifier());
		if (exists(dealIdentifier).getOrDefault(false)) {
			return dealIdentifier.<String>map("getId", _dealIdentifier -> _dealIdentifier.getId()).get();
		}
		final MapperS<DealSummary> dealSummary = MapperS.of(loanCovenantObligationNotificationChoice0).<DealSummary>map("getDealSummary", _loanCovenantObligationNotificationChoice0 -> _loanCovenantObligationNotificationChoice0.getDealSummary());
		if (exists(dealSummary).getOrDefault(false)) {
			return dealSummary.<String>map("getId", _dealSummary -> _dealSummary.getId()).get();
		}
		return null;
	}
	
	public PartyReference choosePartyReference(LoanCovenantObligationNotificationChoice0 loanCovenantObligationNotificationChoice0) {
		final MapperS<DealIdentifier> dealIdentifier = MapperS.of(loanCovenantObligationNotificationChoice0).<DealIdentifier>map("getDealIdentifier", _loanCovenantObligationNotificationChoice0 -> _loanCovenantObligationNotificationChoice0.getDealIdentifier());
		if (exists(dealIdentifier).getOrDefault(false)) {
			return dealIdentifier.<PartyReference>map("getPartyReference", _dealIdentifier -> _dealIdentifier.getPartyReference()).get();
		}
		final MapperS<DealSummary> dealSummary = MapperS.of(loanCovenantObligationNotificationChoice0).<DealSummary>map("getDealSummary", _loanCovenantObligationNotificationChoice0 -> _loanCovenantObligationNotificationChoice0.getDealSummary());
		if (exists(dealSummary).getOrDefault(false)) {
			return dealSummary.<PartyReference>map("getPartyReference", _dealSummary -> _dealSummary.getPartyReference()).get();
		}
		return null;
	}
	
}
