package fpml.consolidated.loan.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.loan.CovenantObligationId;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import fpml.consolidated.loan.LoanCovenantObligation;
import fpml.consolidated.loan.LoanCovenantObligationNotificationChoice1;
import fpml.consolidated.loan.LoanCovenantObligationSummary;
import fpml.consolidated.loan.VersionedCovenantObligationId;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class LoanCovenantObligationNotificationChoice1DeepPathUtil {
	public String chooseName(LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1) {
		final MapperS<CovenantObligationIdentifier> covenantIdentifier = MapperS.of(loanCovenantObligationNotificationChoice1).<CovenantObligationIdentifier>map("getCovenantIdentifier", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantIdentifier());
		if (exists(covenantIdentifier).getOrDefault(false)) {
			return covenantIdentifier.<String>map("getName", covenantObligationIdentifier -> covenantObligationIdentifier.getName()).get();
		}
		final MapperS<LoanCovenantObligationSummary> covenantSummary = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligationSummary>map("getCovenantSummary", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantSummary());
		if (exists(covenantSummary).getOrDefault(false)) {
			return covenantSummary.<String>map("getName", loanCovenantObligationSummary -> loanCovenantObligationSummary.getName()).get();
		}
		final MapperS<LoanCovenantObligation> covenant = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligation>map("getCovenant", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenant());
		if (exists(covenant).getOrDefault(false)) {
			return covenant.<String>map("getName", loanCovenantObligation -> loanCovenantObligation.getName()).get();
		}
		return null;
	}
	
	public List<CovenantObligationId> chooseCovenantObligationId(LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1) {
		final MapperS<CovenantObligationIdentifier> covenantIdentifier = MapperS.of(loanCovenantObligationNotificationChoice1).<CovenantObligationIdentifier>map("getCovenantIdentifier", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantIdentifier());
		if (exists(covenantIdentifier).getOrDefault(false)) {
			return covenantIdentifier.<CovenantObligationId>mapC("getCovenantObligationId", covenantObligationIdentifier -> covenantObligationIdentifier.getCovenantObligationId()).getMulti();
		}
		final MapperS<LoanCovenantObligationSummary> covenantSummary = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligationSummary>map("getCovenantSummary", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantSummary());
		if (exists(covenantSummary).getOrDefault(false)) {
			return covenantSummary.<CovenantObligationId>mapC("getCovenantObligationId", loanCovenantObligationSummary -> loanCovenantObligationSummary.getCovenantObligationId()).getMulti();
		}
		final MapperS<LoanCovenantObligation> covenant = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligation>map("getCovenant", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenant());
		if (exists(covenant).getOrDefault(false)) {
			return covenant.<CovenantObligationId>mapC("getCovenantObligationId", loanCovenantObligation -> loanCovenantObligation.getCovenantObligationId()).getMulti();
		}
		return Collections.<CovenantObligationId>emptyList();
	}
	
	public List<VersionedCovenantObligationId> chooseVersionedCovenantObligationId(LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1) {
		final MapperS<CovenantObligationIdentifier> covenantIdentifier = MapperS.of(loanCovenantObligationNotificationChoice1).<CovenantObligationIdentifier>map("getCovenantIdentifier", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantIdentifier());
		if (exists(covenantIdentifier).getOrDefault(false)) {
			return covenantIdentifier.<VersionedCovenantObligationId>mapC("getVersionedCovenantObligationId", covenantObligationIdentifier -> covenantObligationIdentifier.getVersionedCovenantObligationId()).getMulti();
		}
		final MapperS<LoanCovenantObligationSummary> covenantSummary = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligationSummary>map("getCovenantSummary", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantSummary());
		if (exists(covenantSummary).getOrDefault(false)) {
			return covenantSummary.<VersionedCovenantObligationId>mapC("getVersionedCovenantObligationId", loanCovenantObligationSummary -> loanCovenantObligationSummary.getVersionedCovenantObligationId()).getMulti();
		}
		final MapperS<LoanCovenantObligation> covenant = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligation>map("getCovenant", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenant());
		if (exists(covenant).getOrDefault(false)) {
			return covenant.<VersionedCovenantObligationId>mapC("getVersionedCovenantObligationId", loanCovenantObligation -> loanCovenantObligation.getVersionedCovenantObligationId()).getMulti();
		}
		return Collections.<VersionedCovenantObligationId>emptyList();
	}
	
	public String chooseId(LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1) {
		final MapperS<CovenantObligationIdentifier> covenantIdentifier = MapperS.of(loanCovenantObligationNotificationChoice1).<CovenantObligationIdentifier>map("getCovenantIdentifier", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantIdentifier());
		if (exists(covenantIdentifier).getOrDefault(false)) {
			return covenantIdentifier.<String>map("getId", covenantObligationIdentifier -> covenantObligationIdentifier.getId()).get();
		}
		final MapperS<LoanCovenantObligationSummary> covenantSummary = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligationSummary>map("getCovenantSummary", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantSummary());
		if (exists(covenantSummary).getOrDefault(false)) {
			return covenantSummary.<String>map("getId", loanCovenantObligationSummary -> loanCovenantObligationSummary.getId()).get();
		}
		final MapperS<LoanCovenantObligation> covenant = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligation>map("getCovenant", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenant());
		if (exists(covenant).getOrDefault(false)) {
			return covenant.<String>map("getId", loanCovenantObligation -> loanCovenantObligation.getId()).get();
		}
		return null;
	}
	
	public PartyReference choosePartyReference(LoanCovenantObligationNotificationChoice1 loanCovenantObligationNotificationChoice1) {
		final MapperS<CovenantObligationIdentifier> covenantIdentifier = MapperS.of(loanCovenantObligationNotificationChoice1).<CovenantObligationIdentifier>map("getCovenantIdentifier", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantIdentifier());
		if (exists(covenantIdentifier).getOrDefault(false)) {
			return covenantIdentifier.<PartyReference>map("getPartyReference", covenantObligationIdentifier -> covenantObligationIdentifier.getPartyReference()).get();
		}
		final MapperS<LoanCovenantObligationSummary> covenantSummary = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligationSummary>map("getCovenantSummary", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenantSummary());
		if (exists(covenantSummary).getOrDefault(false)) {
			return covenantSummary.<PartyReference>map("getPartyReference", loanCovenantObligationSummary -> loanCovenantObligationSummary.getPartyReference()).get();
		}
		final MapperS<LoanCovenantObligation> covenant = MapperS.of(loanCovenantObligationNotificationChoice1).<LoanCovenantObligation>map("getCovenant", _loanCovenantObligationNotificationChoice1 -> _loanCovenantObligationNotificationChoice1.getCovenant());
		if (exists(covenant).getOrDefault(false)) {
			return covenant.<PartyReference>map("getPartyReference", loanCovenantObligation -> loanCovenantObligation.getPartyReference()).get();
		}
		return null;
	}
	
}
