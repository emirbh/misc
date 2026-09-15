package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;


@ImplementedBy(GetFctvDt.GetFctvDtDefault.class)
public abstract class GetFctvDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return fctvDt 
	*/
	public Date evaluate(HKMATransactionReport drrReport) {
		Date fctvDt = doEvaluate(drrReport);
		
		return fctvDt;
	}

	protected abstract Date doEvaluate(HKMATransactionReport drrReport);

	public static class GetFctvDtDefault extends GetFctvDt {
		@Override
		protected Date doEvaluate(HKMATransactionReport drrReport) {
			Date fctvDt = null;
			return assignOutput(fctvDt, drrReport);
		}
		
		protected Date assignOutput(Date fctvDt, HKMATransactionReport drrReport) {
			fctvDt = MapperS.of(drrReport).<Date>map("getEffectiveDate", hKMATransactionReport -> hKMATransactionReport.getEffectiveDate()).get();
			
			return fctvDt;
		}
	}
}
