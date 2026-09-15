package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;


@ImplementedBy(GetEarlyTermntnDt.GetEarlyTermntnDtDefault.class)
public abstract class GetEarlyTermntnDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return earlyTermntnDt 
	*/
	public Date evaluate(JFSATransactionReport drrReport) {
		Date earlyTermntnDt = doEvaluate(drrReport);
		
		return earlyTermntnDt;
	}

	protected abstract Date doEvaluate(JFSATransactionReport drrReport);

	public static class GetEarlyTermntnDtDefault extends GetEarlyTermntnDt {
		@Override
		protected Date doEvaluate(JFSATransactionReport drrReport) {
			Date earlyTermntnDt = null;
			return assignOutput(earlyTermntnDt, drrReport);
		}
		
		protected Date assignOutput(Date earlyTermntnDt, JFSATransactionReport drrReport) {
			earlyTermntnDt = MapperS.of(drrReport).<Date>map("getEarlyTerminationDate", jFSATransactionReport -> jFSATransactionReport.getEarlyTerminationDate()).get();
			
			return earlyTermntnDt;
		}
	}
}
