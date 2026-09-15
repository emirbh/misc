package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;


@ImplementedBy(GetXprtnDt.GetXprtnDtDefault.class)
public abstract class GetXprtnDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return xprtnDt 
	*/
	public Date evaluate(HKMATransactionReport drrReport) {
		Date xprtnDt = doEvaluate(drrReport);
		
		return xprtnDt;
	}

	protected abstract Date doEvaluate(HKMATransactionReport drrReport);

	public static class GetXprtnDtDefault extends GetXprtnDt {
		@Override
		protected Date doEvaluate(HKMATransactionReport drrReport) {
			Date xprtnDt = null;
			return assignOutput(xprtnDt, drrReport);
		}
		
		protected Date assignOutput(Date xprtnDt, HKMATransactionReport drrReport) {
			xprtnDt = MapperS.of(drrReport).<Date>map("getExpirationDate", hKMATransactionReport -> hKMATransactionReport.getExpirationDate()).get();
			
			return xprtnDt;
		}
	}
}
