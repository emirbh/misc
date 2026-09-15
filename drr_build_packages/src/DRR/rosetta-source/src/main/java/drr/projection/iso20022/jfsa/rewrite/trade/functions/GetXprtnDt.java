package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;


@ImplementedBy(GetXprtnDt.GetXprtnDtDefault.class)
public abstract class GetXprtnDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return xprtnDt 
	*/
	public Date evaluate(JFSATransactionReport drrReport) {
		Date xprtnDt = doEvaluate(drrReport);
		
		return xprtnDt;
	}

	protected abstract Date doEvaluate(JFSATransactionReport drrReport);

	public static class GetXprtnDtDefault extends GetXprtnDt {
		@Override
		protected Date doEvaluate(JFSATransactionReport drrReport) {
			Date xprtnDt = null;
			return assignOutput(xprtnDt, drrReport);
		}
		
		protected Date assignOutput(Date xprtnDt, JFSATransactionReport drrReport) {
			xprtnDt = MapperS.of(drrReport).<Date>map("getExpirationDate", jFSATransactionReport -> jFSATransactionReport.getExpirationDate()).get();
			
			return xprtnDt;
		}
	}
}
