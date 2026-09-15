package drr.regulation.common.functions;

import cdm.base.staticdata.party.PartyIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.PartyLei;
import javax.inject.Inject;


@ImplementedBy(ExtractPartyResponsibleForReportingIdentifier.ExtractPartyResponsibleForReportingIdentifierDefault.class)
public abstract class ExtractPartyResponsibleForReportingIdentifier implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyResponsibleForReporting extractPartyResponsibleForReporting;
	@Inject protected PartyLei partyLei;

	/**
	* @param reportingSide 
	* @return identifier 
	*/
	public String evaluate(ReportingSide reportingSide) {
		String identifier = doEvaluate(reportingSide);
		
		return identifier;
	}

	protected abstract String doEvaluate(ReportingSide reportingSide);

	public static class ExtractPartyResponsibleForReportingIdentifierDefault extends ExtractPartyResponsibleForReportingIdentifier {
		@Override
		protected String doEvaluate(ReportingSide reportingSide) {
			String identifier = null;
			return assignOutput(identifier, reportingSide);
		}
		
		protected String assignOutput(String identifier, ReportingSide reportingSide) {
			identifier = MapperS.of(extractPartyResponsibleForReporting.evaluate(reportingSide))
				.mapSingleToItem(item -> MapperS.of(partyLei.evaluate(item.<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti()))).get();
			
			return identifier;
		}
	}
}
