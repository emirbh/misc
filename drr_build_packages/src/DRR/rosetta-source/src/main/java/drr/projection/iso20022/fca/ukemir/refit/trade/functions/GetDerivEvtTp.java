package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.EventTypeEnum;
import iso20022.auth030.fca.DerivativeEventType3Code__1;


@ImplementedBy(GetDerivEvtTp.GetDerivEvtTpDefault.class)
public abstract class GetDerivEvtTp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return tp 
	*/
	public DerivativeEventType3Code__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		DerivativeEventType3Code__1 tp = doEvaluate(drrReport);
		
		return tp;
	}

	protected abstract DerivativeEventType3Code__1 doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetDerivEvtTpDefault extends GetDerivEvtTp {
		@Override
		protected DerivativeEventType3Code__1 doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			DerivativeEventType3Code__1 tp = null;
			return assignOutput(tp, drrReport);
		}
		
		protected DerivativeEventType3Code__1 assignOutput(DerivativeEventType3Code__1 tp, FCAUKEMIRTransactionReport drrReport) {
			tp = MapperS.of(drrReport).<EventTypeEnum>map("getEventType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getEventType()).checkedMap("to-enum", e -> DerivativeEventType3Code__1.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return tp;
		}
	}
}
