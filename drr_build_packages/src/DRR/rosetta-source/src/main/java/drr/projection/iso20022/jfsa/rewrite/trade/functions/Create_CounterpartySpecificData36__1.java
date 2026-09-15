package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.CounterpartySpecificData36__1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CounterpartySpecificData36__1.Create_CounterpartySpecificData36__1Default.class)
public abstract class Create_CounterpartySpecificData36__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeCounterpartyReport20__1 create_TradeCounterpartyReport20__1;

	/**
	* @param drrReport 
	* @return ctrPtySpcfcData 
	*/
	public CounterpartySpecificData36__1 evaluate(JFSATransactionReport drrReport) {
		CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder ctrPtySpcfcDataBuilder = doEvaluate(drrReport);
		
		final CounterpartySpecificData36__1 ctrPtySpcfcData;
		if (ctrPtySpcfcDataBuilder == null) {
			ctrPtySpcfcData = null;
		} else {
			ctrPtySpcfcData = ctrPtySpcfcDataBuilder.build();
			objectValidator.validate(CounterpartySpecificData36__1.class, ctrPtySpcfcData);
		}
		
		return ctrPtySpcfcData;
	}

	protected abstract CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_CounterpartySpecificData36__1Default extends Create_CounterpartySpecificData36__1 {
		@Override
		protected CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder doEvaluate(JFSATransactionReport drrReport) {
			CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder ctrPtySpcfcData = CounterpartySpecificData36__1.builder();
			return assignOutput(ctrPtySpcfcData, drrReport);
		}
		
		protected CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder assignOutput(CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder ctrPtySpcfcData, JFSATransactionReport drrReport) {
			ctrPtySpcfcData = toBuilder(CounterpartySpecificData36__1.builder()
				.setCtrPty(create_TradeCounterpartyReport20__1.evaluate(drrReport))
				.setRptgTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", jFSATransactionReport -> jFSATransactionReport.getReportingTimestamp()).get())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
