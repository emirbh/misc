package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;


@ImplementedBy(GetFctvDt.GetFctvDtDefault.class)
public abstract class GetFctvDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return fctvDt 
	*/
	public Date evaluate(MASTransactionReport drrReport) {
		Date fctvDt = doEvaluate(drrReport);
		
		return fctvDt;
	}

	protected abstract Date doEvaluate(MASTransactionReport drrReport);

	public static class GetFctvDtDefault extends GetFctvDt {
		@Override
		protected Date doEvaluate(MASTransactionReport drrReport) {
			Date fctvDt = null;
			return assignOutput(fctvDt, drrReport);
		}
		
		protected Date assignOutput(Date fctvDt, MASTransactionReport drrReport) {
			fctvDt = MapperS.of(drrReport).<Date>map("getEffectiveDate", mASTransactionReport -> mASTransactionReport.getEffectiveDate()).get();
			
			return fctvDt;
		}
	}
}
