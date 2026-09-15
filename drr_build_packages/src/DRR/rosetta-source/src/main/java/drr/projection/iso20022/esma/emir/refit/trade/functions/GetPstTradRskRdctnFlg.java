package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;


@ImplementedBy(GetPstTradRskRdctnFlg.GetPstTradRskRdctnFlgDefault.class)
public abstract class GetPstTradRskRdctnFlg implements RosettaFunction {

	/**
	* @param drrReport 
	* @return pstTradRskRdctnFlg 
	*/
	public Boolean evaluate(ESMAEMIRTransactionReport drrReport) {
		Boolean pstTradRskRdctnFlg = doEvaluate(drrReport);
		
		return pstTradRskRdctnFlg;
	}

	protected abstract Boolean doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetPstTradRskRdctnFlgDefault extends GetPstTradRskRdctnFlg {
		@Override
		protected Boolean doEvaluate(ESMAEMIRTransactionReport drrReport) {
			Boolean pstTradRskRdctnFlg = null;
			return assignOutput(pstTradRskRdctnFlg, drrReport);
		}
		
		protected Boolean assignOutput(Boolean pstTradRskRdctnFlg, ESMAEMIRTransactionReport drrReport) {
			pstTradRskRdctnFlg = MapperS.of(drrReport).<Boolean>map("getPtrr", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPtrr()).get();
			
			return pstTradRskRdctnFlg;
		}
	}
}
