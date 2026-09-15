package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import iso20022.auth030.asic.FloatingRate13__3;
import iso20022.auth030.asic.ResetDateAndValue1__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_FloatingRate3.Create_FloatingRate3Default.class)
public abstract class Create_FloatingRate3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param nextFloatingReferenceResetDateLeg 
	* @return out 
	*/
	public FloatingRate13__3 evaluate(Date nextFloatingReferenceResetDateLeg) {
		FloatingRate13__3.FloatingRate13__3Builder outBuilder = doEvaluate(nextFloatingReferenceResetDateLeg);
		
		final FloatingRate13__3 out;
		if (outBuilder == null) {
			out = null;
		} else {
			out = outBuilder.build();
			objectValidator.validate(FloatingRate13__3.class, out);
		}
		
		return out;
	}

	protected abstract FloatingRate13__3.FloatingRate13__3Builder doEvaluate(Date nextFloatingReferenceResetDateLeg);

	public static class Create_FloatingRate3Default extends Create_FloatingRate3 {
		@Override
		protected FloatingRate13__3.FloatingRate13__3Builder doEvaluate(Date nextFloatingReferenceResetDateLeg) {
			FloatingRate13__3.FloatingRate13__3Builder out = FloatingRate13__3.builder();
			return assignOutput(out, nextFloatingReferenceResetDateLeg);
		}
		
		protected FloatingRate13__3.FloatingRate13__3Builder assignOutput(FloatingRate13__3.FloatingRate13__3Builder out, Date nextFloatingReferenceResetDateLeg) {
			out = toBuilder(FloatingRate13__3.builder()
				.setNxtFltgRst(ResetDateAndValue1__1.builder()
					.setDt(nextFloatingReferenceResetDateLeg)
					.build())
				.build());
			
			return Optional.ofNullable(out)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
