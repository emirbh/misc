package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.FloatingRate13__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_FloatingRate2Leg2.Create_FloatingRate2Leg2Default.class)
public abstract class Create_FloatingRate2Leg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_FloatingRate13__2 create_FloatingRate13__2;
	@Inject protected Create_FloatingRateLeg2 create_FloatingRateLeg2;

	/**
	* @param drrReport 
	* @return fltg 
	*/
	public FloatingRate13__2 evaluate(JFSATransactionReport drrReport) {
		FloatingRate13__2.FloatingRate13__2Builder fltgBuilder = doEvaluate(drrReport);
		
		final FloatingRate13__2 fltg;
		if (fltgBuilder == null) {
			fltg = null;
		} else {
			fltg = fltgBuilder.build();
			objectValidator.validate(FloatingRate13__2.class, fltg);
		}
		
		return fltg;
	}

	protected abstract FloatingRate13__2.FloatingRate13__2Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_FloatingRate2Leg2Default extends Create_FloatingRate2Leg2 {
		@Override
		protected FloatingRate13__2.FloatingRate13__2Builder doEvaluate(JFSATransactionReport drrReport) {
			FloatingRate13__2.FloatingRate13__2Builder fltg = FloatingRate13__2.builder();
			return assignOutput(fltg, drrReport);
		}
		
		protected FloatingRate13__2.FloatingRate13__2Builder assignOutput(FloatingRate13__2.FloatingRate13__2Builder fltg, JFSATransactionReport drrReport) {
			fltg = toBuilder(create_FloatingRate13__2.evaluate(create_FloatingRateLeg2.evaluate(drrReport)));
			
			return Optional.ofNullable(fltg)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
