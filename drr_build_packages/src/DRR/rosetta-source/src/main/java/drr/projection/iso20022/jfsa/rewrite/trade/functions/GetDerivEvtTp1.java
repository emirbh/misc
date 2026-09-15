package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.EventTypeEnum;
import iso20022.auth030.jfsa.DerivativeEventType3Code__1;


@ImplementedBy(GetDerivEvtTp1.GetDerivEvtTp1Default.class)
public abstract class GetDerivEvtTp1 implements RosettaFunction {

	/**
	* @param drrReport 
	* @return tp 
	*/
	public DerivativeEventType3Code__1 evaluate(JFSATransactionReport drrReport) {
		DerivativeEventType3Code__1 tp = doEvaluate(drrReport);
		
		return tp;
	}

	protected abstract DerivativeEventType3Code__1 doEvaluate(JFSATransactionReport drrReport);

	public static class GetDerivEvtTp1Default extends GetDerivEvtTp1 {
		@Override
		protected DerivativeEventType3Code__1 doEvaluate(JFSATransactionReport drrReport) {
			DerivativeEventType3Code__1 tp = null;
			return assignOutput(tp, drrReport);
		}
		
		protected DerivativeEventType3Code__1 assignOutput(DerivativeEventType3Code__1 tp, JFSATransactionReport drrReport) {
			tp = MapperS.of(drrReport).<EventTypeEnum>map("getEventType", jFSATransactionReport -> jFSATransactionReport.getEventType()).checkedMap("to-enum", e -> DerivativeEventType3Code__1.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return tp;
		}
	}
}
