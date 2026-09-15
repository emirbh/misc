package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.EventTypeEnum;
import iso20022.auth030.hkma.tr.DerivativeEvent6__4;
import iso20022.auth030.hkma.tr.DerivativeEventType3Code__3;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvt4.GetDerivEvt4Default.class)
public abstract class GetDerivEvt4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvtId getDerivEvtId;
	@Inject protected GetDerivEvtTmStmp getDerivEvtTmStmp;

	/**
	* @param drrReport 
	* @return derivEvt 
	*/
	public DerivativeEvent6__4 evaluate(HKMATransactionReport drrReport) {
		DerivativeEvent6__4.DerivativeEvent6__4Builder derivEvtBuilder = doEvaluate(drrReport);
		
		final DerivativeEvent6__4 derivEvt;
		if (derivEvtBuilder == null) {
			derivEvt = null;
		} else {
			derivEvt = derivEvtBuilder.build();
			objectValidator.validate(DerivativeEvent6__4.class, derivEvt);
		}
		
		return derivEvt;
	}

	protected abstract DerivativeEvent6__4.DerivativeEvent6__4Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetDerivEvt4Default extends GetDerivEvt4 {
		@Override
		protected DerivativeEvent6__4.DerivativeEvent6__4Builder doEvaluate(HKMATransactionReport drrReport) {
			DerivativeEvent6__4.DerivativeEvent6__4Builder derivEvt = DerivativeEvent6__4.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__4.DerivativeEvent6__4Builder assignOutput(DerivativeEvent6__4.DerivativeEvent6__4Builder derivEvt, HKMATransactionReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__4.builder()
				.setTmStmp(getDerivEvtTmStmp.evaluate(drrReport))
				.setTp(MapperS.of(drrReport).<EventTypeEnum>map("getEventType", hKMATransactionReport -> hKMATransactionReport.getEventType()).checkedMap("to-enum", e -> DerivativeEventType3Code__3.valueOf(e.name()), IllegalArgumentException.class).get())
				.setId(getDerivEvtId.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
