package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;


@ImplementedBy(GetRptTrckgNb.GetRptTrckgNbDefault.class)
public abstract class GetRptTrckgNb implements RosettaFunction {

	/**
	* @param drrReport 
	* @return rptTrckgNb 
	*/
	public String evaluate(ESMAEMIRTransactionReport drrReport) {
		String rptTrckgNb = doEvaluate(drrReport);
		
		return rptTrckgNb;
	}

	protected abstract String doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetRptTrckgNbDefault extends GetRptTrckgNb {
		@Override
		protected String doEvaluate(ESMAEMIRTransactionReport drrReport) {
			String rptTrckgNb = null;
			return assignOutput(rptTrckgNb, drrReport);
		}
		
		protected String assignOutput(String rptTrckgNb, ESMAEMIRTransactionReport drrReport) {
			rptTrckgNb = MapperS.of(drrReport).<String>map("getReportTrackingNumber", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getReportTrackingNumber()).get();
			
			return rptTrckgNb;
		}
	}
}
