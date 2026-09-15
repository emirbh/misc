package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;


@ImplementedBy(GetPrmPmtDt.GetPrmPmtDtDefault.class)
public abstract class GetPrmPmtDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return prmPmtDt 
	*/
	public Date evaluate(JFSATransactionReport drrReport) {
		Date prmPmtDt = doEvaluate(drrReport);
		
		return prmPmtDt;
	}

	protected abstract Date doEvaluate(JFSATransactionReport drrReport);

	public static class GetPrmPmtDtDefault extends GetPrmPmtDt {
		@Override
		protected Date doEvaluate(JFSATransactionReport drrReport) {
			Date prmPmtDt = null;
			return assignOutput(prmPmtDt, drrReport);
		}
		
		protected Date assignOutput(Date prmPmtDt, JFSATransactionReport drrReport) {
			prmPmtDt = MapperS.of(drrReport).<Date>map("getOptionPremiumPaymentDate", jFSATransactionReport -> jFSATransactionReport.getOptionPremiumPaymentDate()).get();
			
			return prmPmtDt;
		}
	}
}
