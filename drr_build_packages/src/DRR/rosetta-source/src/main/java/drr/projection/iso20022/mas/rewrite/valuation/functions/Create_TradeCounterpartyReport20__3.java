package drr.projection.iso20022.mas.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.valuation.MASValuationReport;
import iso20022.auth030.mas.Counterparty45__2;
import iso20022.auth030.mas.Counterparty46__2;
import iso20022.auth030.mas.OrganisationIdentification15Choice__3;
import iso20022.auth030.mas.TradeCounterpartyReport20__3;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeCounterpartyReport20__3.Create_TradeCounterpartyReport20__3Default.class)
public abstract class Create_TradeCounterpartyReport20__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_PartyIdentification248Choice__1 create_PartyIdentification248Choice__1;
	@Inject protected Create_PartyIdentification248Choice__3 create_PartyIdentification248Choice__3;
	@Inject protected GetNttyRspnsblForRpt getNttyRspnsblForRpt;
	@Inject protected GetSubmitgAgt getSubmitgAgt;

	/**
	* @param drrReport 
	* @return ctrPty 
	*/
	public TradeCounterpartyReport20__3 evaluate(MASValuationReport drrReport) {
		TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder ctrPtyBuilder = doEvaluate(drrReport);
		
		final TradeCounterpartyReport20__3 ctrPty;
		if (ctrPtyBuilder == null) {
			ctrPty = null;
		} else {
			ctrPty = ctrPtyBuilder.build();
			objectValidator.validate(TradeCounterpartyReport20__3.class, ctrPty);
		}
		
		return ctrPty;
	}

	protected abstract TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder doEvaluate(MASValuationReport drrReport);

	public static class Create_TradeCounterpartyReport20__3Default extends Create_TradeCounterpartyReport20__3 {
		@Override
		protected TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder doEvaluate(MASValuationReport drrReport) {
			TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder ctrPty = TradeCounterpartyReport20__3.builder();
			return assignOutput(ctrPty, drrReport);
		}
		
		protected TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder assignOutput(TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder ctrPty, MASValuationReport drrReport) {
			final OrganisationIdentification15Choice__3 organisationIdentification15Choice__3 = OrganisationIdentification15Choice__3.builder()
				.setLei(MapperS.of(drrReport).<String>map("getExecutionAgentOfTheCounterparty1", mASValuationReport -> mASValuationReport.getExecutionAgentOfTheCounterparty1()).get())
				.build();
			ctrPty = toBuilder(TradeCounterpartyReport20__3.builder()
				.setRptgCtrPty(Counterparty45__2.builder()
					.setId(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty1", mASValuationReport -> mASValuationReport.getCounterparty1()).get()))
					.build())
				.setOthrCtrPty(Counterparty46__2.builder()
					.setIdTp(create_PartyIdentification248Choice__3.evaluate(drrReport))
					.build())
				.setSubmitgAgt(getSubmitgAgt.evaluate(drrReport))
				.setNttyRspnsblForRpt(getNttyRspnsblForRpt.evaluate(drrReport))
				.setExctnAgt((organisationIdentification15Choice__3 == null ? Collections.<OrganisationIdentification15Choice__3>emptyList() : Collections.singletonList(organisationIdentification15Choice__3)))
				.build());
			
			return Optional.ofNullable(ctrPty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
