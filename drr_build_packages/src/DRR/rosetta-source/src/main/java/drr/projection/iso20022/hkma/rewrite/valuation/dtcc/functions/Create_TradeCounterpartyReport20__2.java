package drr.projection.iso20022.hkma.rewrite.valuation.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import iso20022.auth030.hkma.dtcc.Counterparty45__2;
import iso20022.auth030.hkma.dtcc.Counterparty46__2;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__4;
import iso20022.auth030.hkma.dtcc.TradeCounterpartyReport20__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeCounterpartyReport20__2.Create_TradeCounterpartyReport20__2Default.class)
public abstract class Create_TradeCounterpartyReport20__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_PartyIdentification248Choice__1 create_PartyIdentification248Choice__1;
	@Inject protected Create_PartyIdentification248Choice__5 create_PartyIdentification248Choice__5;
	@Inject protected GetNttyRspnsblForRpt getNttyRspnsblForRpt;

	/**
	* @param drrReport 
	* @return ctrPty 
	*/
	public TradeCounterpartyReport20__2 evaluate(HKMAValuationReport drrReport) {
		TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder ctrPtyBuilder = doEvaluate(drrReport);
		
		final TradeCounterpartyReport20__2 ctrPty;
		if (ctrPtyBuilder == null) {
			ctrPty = null;
		} else {
			ctrPty = ctrPtyBuilder.build();
			objectValidator.validate(TradeCounterpartyReport20__2.class, ctrPty);
		}
		
		return ctrPty;
	}

	protected abstract TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder doEvaluate(HKMAValuationReport drrReport);

	public static class Create_TradeCounterpartyReport20__2Default extends Create_TradeCounterpartyReport20__2 {
		@Override
		protected TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder doEvaluate(HKMAValuationReport drrReport) {
			TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder ctrPty = TradeCounterpartyReport20__2.builder();
			return assignOutput(ctrPty, drrReport);
		}
		
		protected TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder assignOutput(TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder ctrPty, HKMAValuationReport drrReport) {
			ctrPty = toBuilder(TradeCounterpartyReport20__2.builder()
				.setRptgCtrPty(Counterparty45__2.builder()
					.setId(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty1", hKMAValuationReport -> hKMAValuationReport.getCounterparty1()).get()))
					.build())
				.setOthrCtrPty(Counterparty46__2.builder()
					.setIdTp(create_PartyIdentification248Choice__5.evaluate(drrReport))
					.build())
				.setSubmitgAgt(OrganisationIdentification15Choice__4.builder()
					.setLei(MapperS.of(drrReport).<String>map("getSubmitterIdentifier", hKMAValuationReport -> hKMAValuationReport.getSubmitterIdentifier()).get())
					.setOthr(null)
					.build())
				.setNttyRspnsblForRpt(getNttyRspnsblForRpt.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(ctrPty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
