package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;


@ImplementedBy(GetSttlmDt.GetSttlmDtDefault.class)
public abstract class GetSttlmDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return sttlmDt 
	*/
	public Date evaluate(JFSATransactionReport drrReport) {
		Date sttlmDt = doEvaluate(drrReport);
		
		return sttlmDt;
	}

	protected abstract Date doEvaluate(JFSATransactionReport drrReport);

	public static class GetSttlmDtDefault extends GetSttlmDt {
		@Override
		protected Date doEvaluate(JFSATransactionReport drrReport) {
			Date sttlmDt = null;
			return assignOutput(sttlmDt, drrReport);
		}
		
		protected Date assignOutput(Date sttlmDt, JFSATransactionReport drrReport) {
			sttlmDt = MapperS.of(drrReport).<Date>map("getFinalContractualSettlementDate", jFSATransactionReport -> jFSATransactionReport.getFinalContractualSettlementDate()).get();
			
			return sttlmDt;
		}
	}
}
