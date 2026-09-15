package drr.standards.iosco.cde.version1.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.PartyLei;
import javax.inject.Inject;


@ImplementedBy(Counterparty1FromReportingSide.Counterparty1FromReportingSideDefault.class)
public abstract class Counterparty1FromReportingSide implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyLei partyLei;

	/**
	* @param reportingSide 
	* @return counterparty1 
	*/
	public String evaluate(ReportingSide reportingSide) {
		String counterparty1 = doEvaluate(reportingSide);
		
		return counterparty1;
	}

	protected abstract String doEvaluate(ReportingSide reportingSide);

	public static class Counterparty1FromReportingSideDefault extends Counterparty1FromReportingSide {
		@Override
		protected String doEvaluate(ReportingSide reportingSide) {
			String counterparty1 = null;
			return assignOutput(counterparty1, reportingSide);
		}
		
		protected String assignOutput(String counterparty1, ReportingSide reportingSide) {
			counterparty1 = partyLei.evaluate(MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getReportingParty", _reportingSide -> _reportingSide.getReportingParty()).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti());
			
			return counterparty1;
		}
	}
}
