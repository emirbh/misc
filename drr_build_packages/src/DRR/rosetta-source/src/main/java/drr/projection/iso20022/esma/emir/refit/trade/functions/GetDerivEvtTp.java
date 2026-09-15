package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.EventTypeEnum;
import iso20022.auth030.esma.DerivativeEventType3Code__1;


@ImplementedBy(GetDerivEvtTp.GetDerivEvtTpDefault.class)
public abstract class GetDerivEvtTp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return tp 
	*/
	public DerivativeEventType3Code__1 evaluate(ESMAEMIRTransactionReport drrReport) {
		DerivativeEventType3Code__1 tp = doEvaluate(drrReport);
		
		return tp;
	}

	protected abstract DerivativeEventType3Code__1 doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetDerivEvtTpDefault extends GetDerivEvtTp {
		@Override
		protected DerivativeEventType3Code__1 doEvaluate(ESMAEMIRTransactionReport drrReport) {
			DerivativeEventType3Code__1 tp = null;
			return assignOutput(tp, drrReport);
		}
		
		protected DerivativeEventType3Code__1 assignOutput(DerivativeEventType3Code__1 tp, ESMAEMIRTransactionReport drrReport) {
			tp = MapperS.of(drrReport).<EventTypeEnum>map("getEventType", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getEventType()).checkedMap("to-enum", e -> DerivativeEventType3Code__1.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return tp;
		}
	}
}
