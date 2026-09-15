package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.EventTypeEnum;
import iso20022.auth030.hkma.tr.DerivativeEventType3Code__4;


@ImplementedBy(GetDerivEvtTp4.GetDerivEvtTp4Default.class)
public abstract class GetDerivEvtTp4 implements RosettaFunction {

	/**
	* @param drrReport 
	* @return tp 
	*/
	public DerivativeEventType3Code__4 evaluate(HKMATransactionReport drrReport) {
		DerivativeEventType3Code__4 tp = doEvaluate(drrReport);
		
		return tp;
	}

	protected abstract DerivativeEventType3Code__4 doEvaluate(HKMATransactionReport drrReport);

	public static class GetDerivEvtTp4Default extends GetDerivEvtTp4 {
		@Override
		protected DerivativeEventType3Code__4 doEvaluate(HKMATransactionReport drrReport) {
			DerivativeEventType3Code__4 tp = null;
			return assignOutput(tp, drrReport);
		}
		
		protected DerivativeEventType3Code__4 assignOutput(DerivativeEventType3Code__4 tp, HKMATransactionReport drrReport) {
			tp = MapperS.of(drrReport).<EventTypeEnum>map("getEventType", hKMATransactionReport -> hKMATransactionReport.getEventType()).checkedMap("to-enum", e -> DerivativeEventType3Code__4.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return tp;
		}
	}
}
