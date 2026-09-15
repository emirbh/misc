package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;


@ImplementedBy(GetFctvDt.GetFctvDtDefault.class)
public abstract class GetFctvDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return fctvDt 
	*/
	public Date evaluate(JFSATransactionReport drrReport) {
		Date fctvDt = doEvaluate(drrReport);
		
		return fctvDt;
	}

	protected abstract Date doEvaluate(JFSATransactionReport drrReport);

	public static class GetFctvDtDefault extends GetFctvDt {
		@Override
		protected Date doEvaluate(JFSATransactionReport drrReport) {
			Date fctvDt = null;
			return assignOutput(fctvDt, drrReport);
		}
		
		protected Date assignOutput(Date fctvDt, JFSATransactionReport drrReport) {
			fctvDt = MapperS.of(drrReport).<Date>map("getEffectiveDate", jFSATransactionReport -> jFSATransactionReport.getEffectiveDate()).get();
			
			return fctvDt;
		}
	}
}
