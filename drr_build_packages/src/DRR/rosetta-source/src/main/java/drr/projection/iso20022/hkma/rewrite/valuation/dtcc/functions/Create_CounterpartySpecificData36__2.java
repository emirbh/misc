package drr.projection.iso20022.hkma.rewrite.valuation.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import iso20022.auth030.hkma.dtcc.CounterpartySpecificData36__2;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_CounterpartySpecificData36__2.Create_CounterpartySpecificData36__2Default.class)
public abstract class Create_CounterpartySpecificData36__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradeCounterpartyReport20__2 create_TradeCounterpartyReport20__2;

	/**
	* @param drrReport 
	* @return ctrPtySpcfcData 
	*/
	public CounterpartySpecificData36__2 evaluate(HKMAValuationReport drrReport) {
		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder ctrPtySpcfcDataBuilder = doEvaluate(drrReport);
		
		final CounterpartySpecificData36__2 ctrPtySpcfcData;
		if (ctrPtySpcfcDataBuilder == null) {
			ctrPtySpcfcData = null;
		} else {
			ctrPtySpcfcData = ctrPtySpcfcDataBuilder.build();
			objectValidator.validate(CounterpartySpecificData36__2.class, ctrPtySpcfcData);
		}
		
		return ctrPtySpcfcData;
	}

	protected abstract CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder doEvaluate(HKMAValuationReport drrReport);

	public static class Create_CounterpartySpecificData36__2Default extends Create_CounterpartySpecificData36__2 {
		@Override
		protected CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder doEvaluate(HKMAValuationReport drrReport) {
			CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder ctrPtySpcfcData = CounterpartySpecificData36__2.builder();
			return assignOutput(ctrPtySpcfcData, drrReport);
		}
		
		protected CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder assignOutput(CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder ctrPtySpcfcData, HKMAValuationReport drrReport) {
			ctrPtySpcfcData = toBuilder(CounterpartySpecificData36__2.builder()
				.setCtrPty(create_TradeCounterpartyReport20__2.evaluate(drrReport))
				.setRptgTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", hKMAValuationReport -> hKMAValuationReport.getReportingTimestamp()).get())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
