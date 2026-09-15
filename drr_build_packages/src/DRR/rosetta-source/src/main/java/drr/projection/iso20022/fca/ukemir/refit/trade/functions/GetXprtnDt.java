package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;


@ImplementedBy(GetXprtnDt.GetXprtnDtDefault.class)
public abstract class GetXprtnDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return xprtnDt 
	*/
	public Date evaluate(FCAUKEMIRTransactionReport drrReport) {
		Date xprtnDt = doEvaluate(drrReport);
		
		return xprtnDt;
	}

	protected abstract Date doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetXprtnDtDefault extends GetXprtnDt {
		@Override
		protected Date doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			Date xprtnDt = null;
			return assignOutput(xprtnDt, drrReport);
		}
		
		protected Date assignOutput(Date xprtnDt, FCAUKEMIRTransactionReport drrReport) {
			xprtnDt = MapperS.of(drrReport).<Date>map("getExpirationDate", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getExpirationDate()).get();
			
			return xprtnDt;
		}
	}
}
