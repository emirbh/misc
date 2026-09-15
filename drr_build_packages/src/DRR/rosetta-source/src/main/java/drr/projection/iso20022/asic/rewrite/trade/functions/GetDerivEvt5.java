package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.DerivativeEvent6__5;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvt5.GetDerivEvt5Default.class)
public abstract class GetDerivEvt5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvtTmStmp getDerivEvtTmStmp;
	@Inject protected GetDerivEvtTp getDerivEvtTp;

	/**
	* @param drrReport 
	* @return derivEvt 
	*/
	public DerivativeEvent6__5 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract DerivativeEvent6__5.DerivativeEvent6__5Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetDerivEvt5Default extends GetDerivEvt5 {
		@Override
		protected DerivativeEvent6__5.DerivativeEvent6__5Builder doEvaluate(ASICTransactionReport drrReport) {
			DerivativeEvent6__5.DerivativeEvent6__5Builder derivEvt = DerivativeEvent6__5.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__5.DerivativeEvent6__5Builder assignOutput(DerivativeEvent6__5.DerivativeEvent6__5Builder derivEvt, ASICTransactionReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__5.builder()
				.setTp(getDerivEvtTp.evaluate(drrReport))
				.setTmStmp(getDerivEvtTmStmp.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
