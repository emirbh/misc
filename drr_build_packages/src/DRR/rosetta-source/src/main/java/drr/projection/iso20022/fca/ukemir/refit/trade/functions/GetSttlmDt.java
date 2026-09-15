package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;


@ImplementedBy(GetSttlmDt.GetSttlmDtDefault.class)
public abstract class GetSttlmDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return sttlmDt 
	*/
	public Date evaluate(FCAUKEMIRTransactionReport drrReport) {
		Date sttlmDt = doEvaluate(drrReport);
		
		return sttlmDt;
	}

	protected abstract Date doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetSttlmDtDefault extends GetSttlmDt {
		@Override
		protected Date doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			Date sttlmDt = null;
			return assignOutput(sttlmDt, drrReport);
		}
		
		protected Date assignOutput(Date sttlmDt, FCAUKEMIRTransactionReport drrReport) {
			sttlmDt = MapperS.of(drrReport).<Date>map("getFinalContractualSettlementDate", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getFinalContractualSettlementDate()).get();
			
			return sttlmDt;
		}
	}
}
