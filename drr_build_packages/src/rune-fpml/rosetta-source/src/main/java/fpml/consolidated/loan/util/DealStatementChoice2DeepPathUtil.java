package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.DealStatementChoice2;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.FacilitySummary;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class DealStatementChoice2DeepPathUtil {
	public List<InstrumentId> chooseInstrumentId(DealStatementChoice2 dealStatementChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(dealStatementChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _dealStatementChoice2 -> _dealStatementChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<InstrumentId>mapC("getInstrumentId", _facilityIdentifier -> _facilityIdentifier.getInstrumentId()).getMulti();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(dealStatementChoice2).<FacilitySummary>map("getFacilitySummary", _dealStatementChoice2 -> _dealStatementChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<InstrumentId>mapC("getInstrumentId", _facilitySummary -> _facilitySummary.getInstrumentId()).getMulti();
		}
		return Collections.<InstrumentId>emptyList();
	}
	
	public String chooseDescription(DealStatementChoice2 dealStatementChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(dealStatementChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _dealStatementChoice2 -> _dealStatementChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<String>map("getDescription", _facilityIdentifier -> _facilityIdentifier.getDescription()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(dealStatementChoice2).<FacilitySummary>map("getFacilitySummary", _dealStatementChoice2 -> _dealStatementChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<String>map("getDescription", _facilitySummary -> _facilitySummary.getDescription()).get();
		}
		return null;
	}
	
	public DealReference chooseDealReference(DealStatementChoice2 dealStatementChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(dealStatementChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _dealStatementChoice2 -> _dealStatementChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<DealReference>map("getDealReference", _facilityIdentifier -> _facilityIdentifier.getDealReference()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(dealStatementChoice2).<FacilitySummary>map("getFacilitySummary", _dealStatementChoice2 -> _dealStatementChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<DealReference>map("getDealReference", _facilitySummary -> _facilitySummary.getDealReference()).get();
		}
		return null;
	}
	
	public String chooseId(DealStatementChoice2 dealStatementChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(dealStatementChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _dealStatementChoice2 -> _dealStatementChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<String>map("getId", _facilityIdentifier -> _facilityIdentifier.getId()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(dealStatementChoice2).<FacilitySummary>map("getFacilitySummary", _dealStatementChoice2 -> _dealStatementChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<String>map("getId", _facilitySummary -> _facilitySummary.getId()).get();
		}
		return null;
	}
	
	public PartyReference choosePartyReference(DealStatementChoice2 dealStatementChoice2) {
		final MapperS<FacilityIdentifier> facilityIdentifier = MapperS.of(dealStatementChoice2).<FacilityIdentifier>map("getFacilityIdentifier", _dealStatementChoice2 -> _dealStatementChoice2.getFacilityIdentifier());
		if (exists(facilityIdentifier).getOrDefault(false)) {
			return facilityIdentifier.<PartyReference>map("getPartyReference", _facilityIdentifier -> _facilityIdentifier.getPartyReference()).get();
		}
		final MapperS<FacilitySummary> facilitySummary = MapperS.of(dealStatementChoice2).<FacilitySummary>map("getFacilitySummary", _dealStatementChoice2 -> _dealStatementChoice2.getFacilitySummary());
		if (exists(facilitySummary).getOrDefault(false)) {
			return facilitySummary.<PartyReference>map("getPartyReference", _facilitySummary -> _facilitySummary.getPartyReference()).get();
		}
		return null;
	}
	
}
