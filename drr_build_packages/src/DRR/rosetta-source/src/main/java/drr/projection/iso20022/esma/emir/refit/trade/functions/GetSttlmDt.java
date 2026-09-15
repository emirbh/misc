package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;


@ImplementedBy(GetSttlmDt.GetSttlmDtDefault.class)
public abstract class GetSttlmDt implements RosettaFunction {

	/**
	* @param drrReport 
	* @return sttlmDt 
	*/
	public Date evaluate(ESMAEMIRTransactionReport drrReport) {
		Date sttlmDt = doEvaluate(drrReport);
		
		return sttlmDt;
	}

	protected abstract Date doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetSttlmDtDefault extends GetSttlmDt {
		@Override
		protected Date doEvaluate(ESMAEMIRTransactionReport drrReport) {
			Date sttlmDt = null;
			return assignOutput(sttlmDt, drrReport);
		}
		
		protected Date assignOutput(Date sttlmDt, ESMAEMIRTransactionReport drrReport) {
			sttlmDt = MapperS.of(drrReport).<Date>map("getFinalContractualSettlementDate", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getFinalContractualSettlementDate()).get();
			
			return sttlmDt;
		}
	}
}
