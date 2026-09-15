package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;


@ImplementedBy(GetSttlmDt.GetSttlmDtDefault.class)
public abstract class GetSttlmDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return sttlmDt 
	*/
	public Date evaluate(MASTransactionReport drrReport) {
		Date sttlmDt = doEvaluate(drrReport);
		
		return sttlmDt;
	}

	protected abstract Date doEvaluate(MASTransactionReport drrReport);

	public static class GetSttlmDtDefault extends GetSttlmDt {
		@Override
		protected Date doEvaluate(MASTransactionReport drrReport) {
			Date sttlmDt = null;
			return assignOutput(sttlmDt, drrReport);
		}
		
		protected Date assignOutput(Date sttlmDt, MASTransactionReport drrReport) {
			sttlmDt = MapperS.of(drrReport).<Date>map("getFinalContractualSettlementDate", mASTransactionReport -> mASTransactionReport.getFinalContractualSettlementDate()).get();
			
			return sttlmDt;
		}
	}
}
