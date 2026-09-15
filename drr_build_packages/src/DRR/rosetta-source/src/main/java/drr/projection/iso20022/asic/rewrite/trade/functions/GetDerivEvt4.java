package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.DerivativeEvent6__4;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvt4.GetDerivEvt4Default.class)
public abstract class GetDerivEvt4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvtTmStmp getDerivEvtTmStmp;

	/**
	* @param drrReport 
	* @return derivEvt 
	*/
	public DerivativeEvent6__4 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract DerivativeEvent6__4.DerivativeEvent6__4Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetDerivEvt4Default extends GetDerivEvt4 {
		@Override
		protected DerivativeEvent6__4.DerivativeEvent6__4Builder doEvaluate(ASICTransactionReport drrReport) {
			DerivativeEvent6__4.DerivativeEvent6__4Builder derivEvt = DerivativeEvent6__4.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__4.DerivativeEvent6__4Builder assignOutput(DerivativeEvent6__4.DerivativeEvent6__4Builder derivEvt, ASICTransactionReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__4.builder()
				.setTmStmp(getDerivEvtTmStmp.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
