package drr.standards.iosco.cde.version1.party.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.base.util.party.functions.PartyLeiAndPersonByRoles;
import javax.inject.Inject;


@ImplementedBy(Counterparty2FromReportingSide.Counterparty2FromReportingSideDefault.class)
public abstract class Counterparty2FromReportingSide implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;

	/**
	* @param reportingSide 
	* @return counterparty2 
	*/
	public String evaluate(ReportingSide reportingSide) {
		String counterparty2 = doEvaluate(reportingSide);
		
		return counterparty2;
	}

	protected abstract String doEvaluate(ReportingSide reportingSide);

	public static class Counterparty2FromReportingSideDefault extends Counterparty2FromReportingSide {
		@Override
		protected String doEvaluate(ReportingSide reportingSide) {
			String counterparty2 = null;
			return assignOutput(counterparty2, reportingSide);
		}
		
		protected String assignOutput(String counterparty2, ReportingSide reportingSide) {
			final ReferenceWithMetaParty referenceWithMetaParty0 = MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getReportingCounterparty", _reportingSide -> _reportingSide.getReportingCounterparty()).get();
			final ReferenceWithMetaParty referenceWithMetaParty1 = MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getReportingParty", _reportingSide -> _reportingSide.getReportingParty()).get();
			counterparty2 = partyLeiAndPersonByRoles.evaluate((referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), (referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()));
			
			return counterparty2;
		}
	}
}
