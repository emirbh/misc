package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.DerivativeEvent6__3;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvt3.GetDerivEvt3Default.class)
public abstract class GetDerivEvt3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvtId getDerivEvtId;
	@Inject protected GetDerivEvtTmStmp getDerivEvtTmStmp;

	/**
	* @param drrReport 
	* @return derivEvt 
	*/
	public DerivativeEvent6__3 evaluate(FCAUKEMIRTransactionReport drrReport) {
		DerivativeEvent6__3.DerivativeEvent6__3Builder derivEvtBuilder = doEvaluate(drrReport);
		
		final DerivativeEvent6__3 derivEvt;
		if (derivEvtBuilder == null) {
			derivEvt = null;
		} else {
			derivEvt = derivEvtBuilder.build();
			objectValidator.validate(DerivativeEvent6__3.class, derivEvt);
		}
		
		return derivEvt;
	}

	protected abstract DerivativeEvent6__3.DerivativeEvent6__3Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetDerivEvt3Default extends GetDerivEvt3 {
		@Override
		protected DerivativeEvent6__3.DerivativeEvent6__3Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			DerivativeEvent6__3.DerivativeEvent6__3Builder derivEvt = DerivativeEvent6__3.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__3.DerivativeEvent6__3Builder assignOutput(DerivativeEvent6__3.DerivativeEvent6__3Builder derivEvt, FCAUKEMIRTransactionReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__3.builder()
				.setId(getDerivEvtId.evaluate(drrReport))
				.setTmStmp(getDerivEvtTmStmp.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
