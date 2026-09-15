package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.Counterparty45__2;
import iso20022.auth030.hkma.dtcc.Counterparty46__2;
import iso20022.auth030.hkma.dtcc.TradeCounterpartyReport20__2;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeCounterpartyReport20__2.Create_TradeCounterpartyReport20__2Default.class)
public abstract class Create_TradeCounterpartyReport20__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_PartyIdentification248Choice__1 create_PartyIdentification248Choice__1;
	@Inject protected Create_PartyIdentification248Choice__5 create_PartyIdentification248Choice__5;
	@Inject protected GetExctnAgt getExctnAgt;
	@Inject protected GetNttyRspnsblForRpt getNttyRspnsblForRpt;
	@Inject protected GetSubmitgAgt getSubmitgAgt;

	/**
	* @param drrReport 
	* @return ctrPty 
	*/
	public TradeCounterpartyReport20__2 evaluate(HKMATransactionReport drrReport) {
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

	protected abstract TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_TradeCounterpartyReport20__2Default extends Create_TradeCounterpartyReport20__2 {
		@Override
		protected TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder doEvaluate(HKMATransactionReport drrReport) {
			TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder ctrPty = TradeCounterpartyReport20__2.builder();
			return assignOutput(ctrPty, drrReport);
		}
		
		protected TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder assignOutput(TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder ctrPty, HKMATransactionReport drrReport) {
			ctrPty = toBuilder(TradeCounterpartyReport20__2.builder()
				.setRptgCtrPty(Counterparty45__2.builder()
					.setId(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty1", hKMATransactionReport -> hKMATransactionReport.getCounterparty1()).get()))
					.build())
				.setOthrCtrPty(Counterparty46__2.builder()
					.setIdTp(create_PartyIdentification248Choice__5.evaluate(drrReport))
					.build())
				.setSubmitgAgt(getSubmitgAgt.evaluate(drrReport))
				.setNttyRspnsblForRpt(getNttyRspnsblForRpt.evaluate(drrReport))
				.setExctnAgt(new ArrayList(getExctnAgt.evaluate(drrReport)))
				.build());
			
			return Optional.ofNullable(ctrPty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
