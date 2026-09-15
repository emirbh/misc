package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.Counterparty45__3;
import iso20022.auth030.asic.Counterparty46__3;
import iso20022.auth030.asic.ReportingExemption1__1;
import iso20022.auth030.asic.TradeCounterpartyReport20__3;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeCounterpartyReport20__3.Create_TradeCounterpartyReport20__3Default.class)
public abstract class Create_TradeCounterpartyReport20__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_PartyIdentification248Choice__1 create_PartyIdentification248Choice__1;
	@Inject protected Create_PartyIdentification248Choice__3 create_PartyIdentification248Choice__3;
	@Inject protected GetExctnAgt getExctnAgt;
	@Inject protected GetNttyRspnsblForRpt getNttyRspnsblForRpt;
	@Inject protected GetSubmitgAgt getSubmitgAgt;

	/**
	* @param drrReport 
	* @return ctrPty 
	*/
	public TradeCounterpartyReport20__3 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder doEvaluate(ASICTransactionReport drrReport);

	public static class Create_TradeCounterpartyReport20__3Default extends Create_TradeCounterpartyReport20__3 {
		@Override
		protected TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder doEvaluate(ASICTransactionReport drrReport) {
			TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder ctrPty = TradeCounterpartyReport20__3.builder();
			return assignOutput(ctrPty, drrReport);
		}
		
		protected TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder assignOutput(TradeCounterpartyReport20__3.TradeCounterpartyReport20__3Builder ctrPty, ASICTransactionReport drrReport) {
			ctrPty = toBuilder(TradeCounterpartyReport20__3.builder()
				.setRptgCtrPty(Counterparty45__3.builder()
					.setId(create_PartyIdentification248Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty1", aSICTransactionReport -> aSICTransactionReport.getCounterparty1()).get()))
					.setRptgXmptn(ReportingExemption1__1.builder()
						.setRsn(MapperS.of(drrReport).<String>map("getSmallScaleBuySideEntityIndicator", aSICTransactionReport -> aSICTransactionReport.getSmallScaleBuySideEntityIndicator()).get())
						.build())
					.build())
				.setOthrCtrPty(Counterparty46__3.builder()
					.setIdTp(create_PartyIdentification248Choice__3.evaluate(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", aSICTransactionReport -> aSICTransactionReport.getCounterparty2IdentifierType()).get(), MapperS.of(drrReport).<String>map("getCounterparty2", aSICTransactionReport -> aSICTransactionReport.getCounterparty2()).get()))
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
