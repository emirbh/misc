package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;


@ImplementedBy(GetFctvDt.GetFctvDtDefault.class)
public abstract class GetFctvDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return fctvDt 
	*/
	public Date evaluate(ESMAEMIRTransactionReport drrReport) {
		Date fctvDt = doEvaluate(drrReport);
		
		return fctvDt;
	}

	protected abstract Date doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetFctvDtDefault extends GetFctvDt {
		@Override
		protected Date doEvaluate(ESMAEMIRTransactionReport drrReport) {
			Date fctvDt = null;
			return assignOutput(fctvDt, drrReport);
		}
		
		protected Date assignOutput(Date fctvDt, ESMAEMIRTransactionReport drrReport) {
			fctvDt = MapperS.of(drrReport).<Date>map("getEffectiveDate", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getEffectiveDate()).get();
			
			return fctvDt;
		}
	}
}
