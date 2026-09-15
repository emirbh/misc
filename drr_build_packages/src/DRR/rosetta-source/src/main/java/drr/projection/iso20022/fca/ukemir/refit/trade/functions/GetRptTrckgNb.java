package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;


@ImplementedBy(GetRptTrckgNb.GetRptTrckgNbDefault.class)
public abstract class GetRptTrckgNb implements RosettaFunction {

	/**
	* @param drrReport 
	* @return rptTrckgNb 
	*/
	public String evaluate(FCAUKEMIRTransactionReport drrReport) {
		String rptTrckgNb = doEvaluate(drrReport);
		
		return rptTrckgNb;
	}

	protected abstract String doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetRptTrckgNbDefault extends GetRptTrckgNb {
		@Override
		protected String doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			String rptTrckgNb = null;
			return assignOutput(rptTrckgNb, drrReport);
		}
		
		protected String assignOutput(String rptTrckgNb, FCAUKEMIRTransactionReport drrReport) {
			rptTrckgNb = MapperS.of(drrReport).<String>map("getReportTrackingNumber", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getReportTrackingNumber()).get();
			
			return rptTrckgNb;
		}
	}
}
