package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice2;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanCovenantObligationNotificationChoice2DeepPathUtil {
	public List<InstrumentId> chooseInstrumentId(LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<InstrumentId>mapC("getInstrumentId", _facilityIdentifier -> _facilityIdentifier.getInstrumentId()).getMulti();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilitySummary>map("getFacilitySummary", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<InstrumentId>mapC("getInstrumentId", _facilitySummary -> _facilitySummary.getInstrumentId()).getMulti();
		}
		return Collections.<InstrumentId>emptyList();
	}
	
	public String chooseDescription(LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<String>map("getDescription", _facilityIdentifier -> _facilityIdentifier.getDescription()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilitySummary>map("getFacilitySummary", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<String>map("getDescription", _facilitySummary -> _facilitySummary.getDescription()).get();
		}
		return null;
	}
	
	public DealReference chooseDealReference(LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<DealReference>map("getDealReference", _facilityIdentifier -> _facilityIdentifier.getDealReference()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilitySummary>map("getFacilitySummary", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<DealReference>map("getDealReference", _facilitySummary -> _facilitySummary.getDealReference()).get();
		}
		return null;
	}
	
	public String chooseId(LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<String>map("getId", _facilityIdentifier -> _facilityIdentifier.getId()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilitySummary>map("getFacilitySummary", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<String>map("getId", _facilitySummary -> _facilitySummary.getId()).get();
		}
		return null;
	}
	
	public PartyReference choosePartyReference(LoanCovenantObligationNotificationChoice2 loanCovenantObligationNotificationChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<PartyReference>map("getPartyReference", _facilityIdentifier -> _facilityIdentifier.getPartyReference()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanCovenantObligationNotificationChoice2).<FacilitySummary>map("getFacilitySummary", _loanCovenantObligationNotificationChoice2 -> _loanCovenantObligationNotificationChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<PartyReference>map("getPartyReference", _facilitySummary -> _facilitySummary.getPartyReference()).get();
		}
		return null;
	}
	
}
