package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.loan.LoanLegalActionNotificationChoiceChoice0;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanLegalActionNotificationChoiceChoice0DeepPathUtil {
	public List<InstrumentId> chooseInstrumentId(LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilityIdentifier>map("getFacilityIdentifier", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<InstrumentId>mapC("getInstrumentId", _facilityIdentifier -> _facilityIdentifier.getInstrumentId()).getMulti();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilitySummary>map("getFacilitySummary", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<InstrumentId>mapC("getInstrumentId", _facilitySummary -> _facilitySummary.getInstrumentId()).getMulti();
		}
		return Collections.<InstrumentId>emptyList();
	}
	
	public String chooseDescription(LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilityIdentifier>map("getFacilityIdentifier", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<String>map("getDescription", _facilityIdentifier -> _facilityIdentifier.getDescription()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilitySummary>map("getFacilitySummary", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<String>map("getDescription", _facilitySummary -> _facilitySummary.getDescription()).get();
		}
		return null;
	}
	
	public DealReference chooseDealReference(LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilityIdentifier>map("getFacilityIdentifier", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<DealReference>map("getDealReference", _facilityIdentifier -> _facilityIdentifier.getDealReference()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilitySummary>map("getFacilitySummary", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<DealReference>map("getDealReference", _facilitySummary -> _facilitySummary.getDealReference()).get();
		}
		return null;
	}
	
	public String chooseId(LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilityIdentifier>map("getFacilityIdentifier", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<String>map("getId", _facilityIdentifier -> _facilityIdentifier.getId()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilitySummary>map("getFacilitySummary", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<String>map("getId", _facilitySummary -> _facilitySummary.getId()).get();
		}
		return null;
	}
	
	public PartyReference choosePartyReference(LoanLegalActionNotificationChoiceChoice0 loanLegalActionNotificationChoiceChoice0) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilityIdentifier>map("getFacilityIdentifier", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<PartyReference>map("getPartyReference", _facilityIdentifier -> _facilityIdentifier.getPartyReference()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(loanLegalActionNotificationChoiceChoice0).<FacilitySummary>map("getFacilitySummary", _loanLegalActionNotificationChoiceChoice0 -> _loanLegalActionNotificationChoiceChoice0.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<PartyReference>map("getPartyReference", _facilitySummary -> _facilitySummary.getPartyReference()).get();
		}
		return null;
	}
	
}
