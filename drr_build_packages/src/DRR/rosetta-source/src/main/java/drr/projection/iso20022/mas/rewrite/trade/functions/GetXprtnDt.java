package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;


@ImplementedBy(GetXprtnDt.GetXprtnDtDefault.class)
public abstract class GetXprtnDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return xprtnDt 
	*/
	public Date evaluate(MASTransactionReport drrReport) {
		Date xprtnDt = doEvaluate(drrReport);
		
		return xprtnDt;
	}

	protected abstract Date doEvaluate(MASTransactionReport drrReport);

	public static class GetXprtnDtDefault extends GetXprtnDt {
		@Override
		protected Date doEvaluate(MASTransactionReport drrReport) {
			Date xprtnDt = null;
			return assignOutput(xprtnDt, drrReport);
		}
		
		protected Date assignOutput(Date xprtnDt, MASTransactionReport drrReport) {
			xprtnDt = MapperS.of(drrReport).<Date>map("getExpirationDate", mASTransactionReport -> mASTransactionReport.getExpirationDate()).get();
			
			return xprtnDt;
		}
	}
}
