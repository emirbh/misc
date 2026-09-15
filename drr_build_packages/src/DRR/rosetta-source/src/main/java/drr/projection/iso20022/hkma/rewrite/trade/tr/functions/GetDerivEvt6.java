package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.DerivativeEvent6__6;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetDerivEvt6.GetDerivEvt6Default.class)
public abstract class GetDerivEvt6 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvtTp4 getDerivEvtTp4;

	/**
	* @param drrReport 
	* @return derivEvt 
	*/
	public DerivativeEvent6__6 evaluate(HKMATransactionReport drrReport) {
		DerivativeEvent6__6.DerivativeEvent6__6Builder derivEvtBuilder = doEvaluate(drrReport);
		
		final DerivativeEvent6__6 derivEvt;
		if (derivEvtBuilder == null) {
			derivEvt = null;
		} else {
			derivEvt = derivEvtBuilder.build();
			objectValidator.validate(DerivativeEvent6__6.class, derivEvt);
		}
		
		return derivEvt;
	}

	protected abstract DerivativeEvent6__6.DerivativeEvent6__6Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetDerivEvt6Default extends GetDerivEvt6 {
		@Override
		protected DerivativeEvent6__6.DerivativeEvent6__6Builder doEvaluate(HKMATransactionReport drrReport) {
			DerivativeEvent6__6.DerivativeEvent6__6Builder derivEvt = DerivativeEvent6__6.builder();
			return assignOutput(derivEvt, drrReport);
		}
		
		protected DerivativeEvent6__6.DerivativeEvent6__6Builder assignOutput(DerivativeEvent6__6.DerivativeEvent6__6Builder derivEvt, HKMATransactionReport drrReport) {
			derivEvt = toBuilder(DerivativeEvent6__6.builder()
				.setTp(getDerivEvtTp4.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(derivEvt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
