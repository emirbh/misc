package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;


@ImplementedBy(GetXprtnDt.GetXprtnDtDefault.class)
public abstract class GetXprtnDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return xprtnDt 
	*/
	public Date evaluate(ASICTransactionReport drrReport) {
		Date xprtnDt = doEvaluate(drrReport);
		
		return xprtnDt;
	}

	protected abstract Date doEvaluate(ASICTransactionReport drrReport);

	public static class GetXprtnDtDefault extends GetXprtnDt {
		@Override
		protected Date doEvaluate(ASICTransactionReport drrReport) {
			Date xprtnDt = null;
			return assignOutput(xprtnDt, drrReport);
		}
		
		protected Date assignOutput(Date xprtnDt, ASICTransactionReport drrReport) {
			xprtnDt = MapperS.of(drrReport).<Date>map("getExpirationDate", aSICTransactionReport -> aSICTransactionReport.getExpirationDate()).get();
			
			return xprtnDt;
		}
	}
}
