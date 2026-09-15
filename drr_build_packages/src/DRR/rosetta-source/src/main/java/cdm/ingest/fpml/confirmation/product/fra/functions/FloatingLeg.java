package cdm.ingest.fpml.confirmation.product.fra.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Leg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(FloatingLeg.FloatingLegDefault.class)
public abstract class FloatingLeg implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @return fpmlFloatingLeg 
	*/
	public Leg evaluate() {
		Leg.LegBuilder fpmlFloatingLegBuilder = doEvaluate();
		
		final Leg fpmlFloatingLeg;
		if (fpmlFloatingLegBuilder == null) {
			fpmlFloatingLeg = null;
		} else {
			fpmlFloatingLeg = fpmlFloatingLegBuilder.build();
			objectValidator.validate(Leg.class, fpmlFloatingLeg);
		}
		
		return fpmlFloatingLeg;
	}

	protected abstract Leg.LegBuilder doEvaluate();

	public static class FloatingLegDefault extends FloatingLeg {
		@Override
		protected Leg.LegBuilder doEvaluate() {
			Leg.LegBuilder fpmlFloatingLeg = Leg.builder();
			return assignOutput(fpmlFloatingLeg);
		}
		
		protected Leg.LegBuilder assignOutput(Leg.LegBuilder fpmlFloatingLeg) {
			fpmlFloatingLeg = toBuilder(Leg.builder()
				.setId("floatingLeg")
				.build());
			
			return Optional.ofNullable(fpmlFloatingLeg)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
