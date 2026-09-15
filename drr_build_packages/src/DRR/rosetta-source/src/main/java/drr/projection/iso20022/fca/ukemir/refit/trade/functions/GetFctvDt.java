package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;


@ImplementedBy(GetFctvDt.GetFctvDtDefault.class)
public abstract class GetFctvDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return fctvDt 
	*/
	public Date evaluate(FCAUKEMIRTransactionReport drrReport) {
		Date fctvDt = doEvaluate(drrReport);
		
		return fctvDt;
	}

	protected abstract Date doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetFctvDtDefault extends GetFctvDt {
		@Override
		protected Date doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			Date fctvDt = null;
			return assignOutput(fctvDt, drrReport);
		}
		
		protected Date assignOutput(Date fctvDt, FCAUKEMIRTransactionReport drrReport) {
			fctvDt = MapperS.of(drrReport).<Date>map("getEffectiveDate", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getEffectiveDate()).get();
			
			return fctvDt;
		}
	}
}
