package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.FloatingRate13__3;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_FloatingRate3Leg2.Create_FloatingRate3Leg2Default.class)
public abstract class Create_FloatingRate3Leg2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_FloatingRate13__3 create_FloatingRate13__3;
	@Inject protected Create_FloatingRateLeg2 create_FloatingRateLeg2;

	/**
	* @param drrReport 
	* @return fltg 
	*/
	public FloatingRate13__3 evaluate(JFSATransactionReport drrReport) {
		FloatingRate13__3.FloatingRate13__3Builder fltgBuilder = doEvaluate(drrReport);
		
		final FloatingRate13__3 fltg;
		if (fltgBuilder == null) {
			fltg = null;
		} else {
			fltg = fltgBuilder.build();
			objectValidator.validate(FloatingRate13__3.class, fltg);
		}
		
		return fltg;
	}

	protected abstract FloatingRate13__3.FloatingRate13__3Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_FloatingRate3Leg2Default extends Create_FloatingRate3Leg2 {
		@Override
		protected FloatingRate13__3.FloatingRate13__3Builder doEvaluate(JFSATransactionReport drrReport) {
			FloatingRate13__3.FloatingRate13__3Builder fltg = FloatingRate13__3.builder();
			return assignOutput(fltg, drrReport);
		}
		
		protected FloatingRate13__3.FloatingRate13__3Builder assignOutput(FloatingRate13__3.FloatingRate13__3Builder fltg, JFSATransactionReport drrReport) {
			fltg = toBuilder(create_FloatingRate13__3.evaluate(create_FloatingRateLeg2.evaluate(drrReport)));
			
			return Optional.ofNullable(fltg)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
