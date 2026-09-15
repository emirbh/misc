package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.DerivativeEvent6__4;
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
	public DerivativeEvent6__4 evaluate(ESMAValuationReport drrReport) {
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

	protected abstract DerivativeEvent6__4.DerivativeEvent6__4Builder doEvaluate(ESMAValuationReport drrReport);

	public static class GetDerivEvt4Default extends GetDerivEvt4 {
		@Override
		protected DerivativeEvent6__4.DerivativeEvent6__4Builder doEvaluate(ESMAValuationReport drrReport) {
			DerivativeEvent6__4.DerivativeEvent6__4Builder derivEvt = DerivativeEvent6__4.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__4.DerivativeEvent6__4Builder assignOutput(DerivativeEvent6__4.DerivativeEvent6__4Builder derivEvt, ESMAValuationReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__4.builder()
				.setTmStmp(getDerivEvtTmStmp.evaluate(drrReport))
				.setTp(null)
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
