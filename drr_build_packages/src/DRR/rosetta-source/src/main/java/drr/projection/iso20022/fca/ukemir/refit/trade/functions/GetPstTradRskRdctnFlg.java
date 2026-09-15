package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;


@ImplementedBy(GetPstTradRskRdctnFlg.GetPstTradRskRdctnFlgDefault.class)
public abstract class GetPstTradRskRdctnFlg implements RosettaFunction {

	/**
	* @param drrReport 
	* @return pstTradRskRdctnFlg 
	*/
	public Boolean evaluate(FCAUKEMIRTransactionReport drrReport) {
		Boolean pstTradRskRdctnFlg = doEvaluate(drrReport);
		
		return pstTradRskRdctnFlg;
	}

	protected abstract Boolean doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetPstTradRskRdctnFlgDefault extends GetPstTradRskRdctnFlg {
		@Override
		protected Boolean doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			Boolean pstTradRskRdctnFlg = null;
			return assignOutput(pstTradRskRdctnFlg, drrReport);
		}
		
		protected Boolean assignOutput(Boolean pstTradRskRdctnFlg, FCAUKEMIRTransactionReport drrReport) {
			pstTradRskRdctnFlg = MapperS.of(drrReport).<Boolean>map("getPtrr", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPtrr()).get();
			
			return pstTradRskRdctnFlg;
		}
	}
}
