package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.DerivativeEvent6__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvt1.GetDerivEvt1Default.class)
public abstract class GetDerivEvt1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvtTmStmp getDerivEvtTmStmp;

	/**
	* @param drrReport 
	* @return derivEvt 
	*/
	public DerivativeEvent6__1 evaluate(ESMAValuationReport drrReport) {
		DerivativeEvent6__1.DerivativeEvent6__1Builder derivEvtBuilder = doEvaluate(drrReport);
		
		final DerivativeEvent6__1 derivEvt;
		if (derivEvtBuilder == null) {
			derivEvt = null;
		} else {
			derivEvt = derivEvtBuilder.build();
			objectValidator.validate(DerivativeEvent6__1.class, derivEvt);
		}
		
		return derivEvt;
	}

	protected abstract DerivativeEvent6__1.DerivativeEvent6__1Builder doEvaluate(ESMAValuationReport drrReport);

	public static class GetDerivEvt1Default extends GetDerivEvt1 {
		@Override
		protected DerivativeEvent6__1.DerivativeEvent6__1Builder doEvaluate(ESMAValuationReport drrReport) {
			DerivativeEvent6__1.DerivativeEvent6__1Builder derivEvt = DerivativeEvent6__1.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__1.DerivativeEvent6__1Builder assignOutput(DerivativeEvent6__1.DerivativeEvent6__1Builder derivEvt, ESMAValuationReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__1.builder()
				.setTmStmp(getDerivEvtTmStmp.evaluate(drrReport))
				.setTp(null)
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
