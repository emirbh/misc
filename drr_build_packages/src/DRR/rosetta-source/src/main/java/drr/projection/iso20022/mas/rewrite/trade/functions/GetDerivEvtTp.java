package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.EventTypeEnum;
import iso20022.auth030.mas.DerivativeEventType3Code;


@ImplementedBy(GetDerivEvtTp.GetDerivEvtTpDefault.class)
public abstract class GetDerivEvtTp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return tp 
	*/
	public DerivativeEventType3Code evaluate(MASTransactionReport drrReport) {
		DerivativeEventType3Code tp = doEvaluate(drrReport);
		
		return tp;
	}

	protected abstract DerivativeEventType3Code doEvaluate(MASTransactionReport drrReport);

	public static class GetDerivEvtTpDefault extends GetDerivEvtTp {
		@Override
		protected DerivativeEventType3Code doEvaluate(MASTransactionReport drrReport) {
			DerivativeEventType3Code tp = null;
			return assignOutput(tp, drrReport);
		}
		
		protected DerivativeEventType3Code assignOutput(DerivativeEventType3Code tp, MASTransactionReport drrReport) {
			tp = MapperS.of(drrReport).<EventTypeEnum>map("getEventType", mASTransactionReport -> mASTransactionReport.getEventType()).checkedMap("to-enum", e -> DerivativeEventType3Code.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return tp;
		}
	}
}
