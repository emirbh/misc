package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import iso20022.auth030.fca.Counterparty45__1;
import iso20022.auth030.fca.Counterparty46__1;
import iso20022.auth030.fca.TradeCounterpartyReport20__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeCounterpartyReport20__1.Create_TradeCounterpartyReport20__1Default.class)
public abstract class Create_TradeCounterpartyReport20__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_PartyIdentification248Choice__1 create_PartyIdentification248Choice__1;
	@Inject protected Create_PartyIdentification248Choice__2 create_PartyIdentification248Choice__2;
	@Inject protected GetSubmitgAgt getSubmitgAgt;

	/**
	* @param drrReport 
	* @return ctrPty 
	*/
	public TradeCounterpartyReport20__1 evaluate(FCAValuationReport drrReport) {
		TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPtyBuilder = doEvaluate(drrReport);
		
		final TradeCounterpartyReport20__1 ctrPty;
		if (ctrPtyBuilder == null) {
			ctrPty = null;
		} else {
			ctrPty = ctrPtyBuilder.build();
			objectValidator.validate(TradeCounterpartyReport20__1.class, ctrPty);
		}
		
		return ctrPty;
	}

	protected abstract TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(FCAValuationReport drrReport);

	public static class Create_TradeCounterpartyReport20__1Default extends Create_TradeCounterpartyReport20__1 {
		@Override
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder doEvaluate(FCAValuationReport drrReport) {
			TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty = TradeCounterpartyReport20__1.builder();
			return assignOutput(ctrPty, drrReport);
		}
		
		protected TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder assignOutput(TradeCounterpartyReport20__1.TradeCounterpartyReport20__1Builder ctrPty, FCAValuationReport drrReport) {
			ctrPty = toBuilder(TradeCounterpartyReport20__1.builder()
				.setRptgCtrPty(Counterparty45__1.builder()
					.setId(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty1", fCAValuationReport -> fCAValuationReport.getCounterparty1()).get()))
					.setNtr(null)
					.setDrctnOrSd(null)
					.build())
				.setOthrCtrPty(Counterparty46__1.builder()
					.setIdTp(create_PartyIdentification248Choice__2.evaluate(drrReport))
					.setRptgOblgtn(null)
					.build())
				.setSubmitgAgt(getSubmitgAgt.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(ctrPty)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
