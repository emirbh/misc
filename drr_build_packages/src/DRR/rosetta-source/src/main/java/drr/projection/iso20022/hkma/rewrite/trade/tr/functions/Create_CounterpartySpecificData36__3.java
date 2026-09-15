package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.CounterpartySpecificData36__3;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CounterpartySpecificData36__3.Create_CounterpartySpecificData36__3Default.class)
public abstract class Create_CounterpartySpecificData36__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeCounterpartyReport20__2 create_TradeCounterpartyReport20__2;

	/**
	* @param drrReport 
	* @return ctrPtySpcfcData 
	*/
	public CounterpartySpecificData36__3 evaluate(HKMATransactionReport drrReport) {
		CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder ctrPtySpcfcDataBuilder = doEvaluate(drrReport);
		
		final CounterpartySpecificData36__3 ctrPtySpcfcData;
		if (ctrPtySpcfcDataBuilder == null) {
			ctrPtySpcfcData = null;
		} else {
			ctrPtySpcfcData = ctrPtySpcfcDataBuilder.build();
			objectValidator.validate(CounterpartySpecificData36__3.class, ctrPtySpcfcData);
		}
		
		return ctrPtySpcfcData;
	}

	protected abstract CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_CounterpartySpecificData36__3Default extends Create_CounterpartySpecificData36__3 {
		@Override
		protected CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder doEvaluate(HKMATransactionReport drrReport) {
			CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder ctrPtySpcfcData = CounterpartySpecificData36__3.builder();
			return assignOutput(ctrPtySpcfcData, drrReport);
		}
		
		protected CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder assignOutput(CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder ctrPtySpcfcData, HKMATransactionReport drrReport) {
			ctrPtySpcfcData = toBuilder(CounterpartySpecificData36__3.builder()
				.setCtrPty(create_TradeCounterpartyReport20__2.evaluate(drrReport))
				.setValtn(null)
				.setRptgTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", hKMATransactionReport -> hKMATransactionReport.getReportingTimestamp()).get())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
