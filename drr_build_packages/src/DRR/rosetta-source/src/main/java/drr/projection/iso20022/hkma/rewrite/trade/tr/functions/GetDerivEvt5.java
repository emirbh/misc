package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.DerivativeEvent6__5;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvt5.GetDerivEvt5Default.class)
public abstract class GetDerivEvt5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvtId getDerivEvtId;

	/**
	* @param drrReport 
	* @return derivEvt 
	*/
	public DerivativeEvent6__5 evaluate(HKMATransactionReport drrReport) {
		DerivativeEvent6__5.DerivativeEvent6__5Builder derivEvtBuilder = doEvaluate(drrReport);
		
		final DerivativeEvent6__5 derivEvt;
		if (derivEvtBuilder == null) {
			derivEvt = null;
		} else {
			derivEvt = derivEvtBuilder.build();
			objectValidator.validate(DerivativeEvent6__5.class, derivEvt);
		}
		
		return derivEvt;
	}

	protected abstract DerivativeEvent6__5.DerivativeEvent6__5Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetDerivEvt5Default extends GetDerivEvt5 {
		@Override
		protected DerivativeEvent6__5.DerivativeEvent6__5Builder doEvaluate(HKMATransactionReport drrReport) {
			DerivativeEvent6__5.DerivativeEvent6__5Builder derivEvt = DerivativeEvent6__5.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__5.DerivativeEvent6__5Builder assignOutput(DerivativeEvent6__5.DerivativeEvent6__5Builder derivEvt, HKMATransactionReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__5.builder()
				.setId(getDerivEvtId.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
