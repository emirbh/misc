package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealStatementChoice0;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class DealStatementChoice0DeepPathUtil {
	public List<InstrumentId> chooseInstrumentId(DealStatementChoice0 dealStatementChoice0) {
		final MapperS<DealIdentifier> dealIdentifier = MapperS.of(dealStatementChoice0).<DealIdentifier>map("getDealIdentifier", _dealStatementChoice0 -> _dealStatementChoice0.getDealIdentifier());
		if (exists(dealIdentifier).getOrDefault(false)) {
			return dealIdentifier.<InstrumentId>mapC("getInstrumentId", _dealIdentifier -> _dealIdentifier.getInstrumentId()).getMulti();
		}
		final MapperS<DealSummary> dealSummary = MapperS.of(dealStatementChoice0).<DealSummary>map("getDealSummary", _dealStatementChoice0 -> _dealStatementChoice0.getDealSummary());
		if (exists(dealSummary).getOrDefault(false)) {
			return dealSummary.<InstrumentId>mapC("getInstrumentId", _dealSummary -> _dealSummary.getInstrumentId()).getMulti();
		}
		return Collections.<InstrumentId>emptyList();
	}
	
	public String chooseDescription(DealStatementChoice0 dealStatementChoice0) {
		final MapperS<DealIdentifier> dealIdentifier = MapperS.of(dealStatementChoice0).<DealIdentifier>map("getDealIdentifier", _dealStatementChoice0 -> _dealStatementChoice0.getDealIdentifier());
		if (exists(dealIdentifier).getOrDefault(false)) {
			return dealIdentifier.<String>map("getDescription", _dealIdentifier -> _dealIdentifier.getDescription()).get();
		}
		final MapperS<DealSummary> dealSummary = MapperS.of(dealStatementChoice0).<DealSummary>map("getDealSummary", _dealStatementChoice0 -> _dealStatementChoice0.getDealSummary());
		if (exists(dealSummary).getOrDefault(false)) {
			return dealSummary.<String>map("getDescription", _dealSummary -> _dealSummary.getDescription()).get();
		}
		return null;
	}
	
	public String chooseId(DealStatementChoice0 dealStatementChoice0) {
		final MapperS<DealIdentifier> dealIdentifier = MapperS.of(dealStatementChoice0).<DealIdentifier>map("getDealIdentifier", _dealStatementChoice0 -> _dealStatementChoice0.getDealIdentifier());
		if (exists(dealIdentifier).getOrDefault(false)) {
			return dealIdentifier.<String>map("getId", _dealIdentifier -> _dealIdentifier.getId()).get();
		}
		final MapperS<DealSummary> dealSummary = MapperS.of(dealStatementChoice0).<DealSummary>map("getDealSummary", _dealStatementChoice0 -> _dealStatementChoice0.getDealSummary());
		if (exists(dealSummary).getOrDefault(false)) {
			return dealSummary.<String>map("getId", _dealSummary -> _dealSummary.getId()).get();
		}
		return null;
	}
	
	public PartyReference choosePartyReference(DealStatementChoice0 dealStatementChoice0) {
		final MapperS<DealIdentifier> dealIdentifier = MapperS.of(dealStatementChoice0).<DealIdentifier>map("getDealIdentifier", _dealStatementChoice0 -> _dealStatementChoice0.getDealIdentifier());
		if (exists(dealIdentifier).getOrDefault(false)) {
			return dealIdentifier.<PartyReference>map("getPartyReference", _dealIdentifier -> _dealIdentifier.getPartyReference()).get();
		}
		final MapperS<DealSummary> dealSummary = MapperS.of(dealStatementChoice0).<DealSummary>map("getDealSummary", _dealStatementChoice0 -> _dealStatementChoice0.getDealSummary());
		if (exists(dealSummary).getOrDefault(false)) {
			return dealSummary.<PartyReference>map("getPartyReference", _dealSummary -> _dealSummary.getPartyReference()).get();
		}
		return null;
	}
	
}
