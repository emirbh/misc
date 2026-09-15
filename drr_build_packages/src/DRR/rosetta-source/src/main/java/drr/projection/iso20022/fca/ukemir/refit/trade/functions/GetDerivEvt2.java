package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.DerivativeEvent6__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvt2.GetDerivEvt2Default.class)
public abstract class GetDerivEvt2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvtId getDerivEvtId;
	@Inject protected GetDerivEvtTmStmp getDerivEvtTmStmp;
	@Inject protected GetDerivEvtTp getDerivEvtTp;

	/**
	* @param drrReport 
	* @return derivEvt 
	*/
	public DerivativeEvent6__2 evaluate(FCAUKEMIRTransactionReport drrReport) {
		DerivativeEvent6__2.DerivativeEvent6__2Builder derivEvtBuilder = doEvaluate(drrReport);
		
		final DerivativeEvent6__2 derivEvt;
		if (derivEvtBuilder == null) {
			derivEvt = null;
		} else {
			derivEvt = derivEvtBuilder.build();
			objectValidator.validate(DerivativeEvent6__2.class, derivEvt);
		}
		
		return derivEvt;
	}

	protected abstract DerivativeEvent6__2.DerivativeEvent6__2Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetDerivEvt2Default extends GetDerivEvt2 {
		@Override
		protected DerivativeEvent6__2.DerivativeEvent6__2Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			DerivativeEvent6__2.DerivativeEvent6__2Builder derivEvt = DerivativeEvent6__2.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__2.DerivativeEvent6__2Builder assignOutput(DerivativeEvent6__2.DerivativeEvent6__2Builder derivEvt, FCAUKEMIRTransactionReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__2.builder()
				.setId(getDerivEvtId.evaluate(drrReport))
				.setTp(getDerivEvtTp.evaluate(drrReport))
				.setTmStmp(getDerivEvtTmStmp.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
