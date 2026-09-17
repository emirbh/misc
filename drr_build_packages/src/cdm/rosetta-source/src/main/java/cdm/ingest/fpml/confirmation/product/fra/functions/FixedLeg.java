package cdm.ingest.fpml.confirmation.product.fra.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Leg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(FixedLeg.FixedLegDefault.class)
public abstract class FixedLeg implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @return fpmlFixedLeg 
	*/
	public Leg evaluate() {
		Leg.LegBuilder fpmlFixedLegBuilder = doEvaluate();
		
		final Leg fpmlFixedLeg;
		if (fpmlFixedLegBuilder == null) {
			fpmlFixedLeg = null;
		} else {
			fpmlFixedLeg = fpmlFixedLegBuilder.build();
			objectValidator.validate(Leg.class, fpmlFixedLeg);
		}
		
		return fpmlFixedLeg;
	}

	protected abstract Leg.LegBuilder doEvaluate();

	public static class FixedLegDefault extends FixedLeg {
		@Override
		protected Leg.LegBuilder doEvaluate() {
			Leg.LegBuilder fpmlFixedLeg = Leg.builder();
			return assignOutput(fpmlFixedLeg);
		}
		
		protected Leg.LegBuilder assignOutput(Leg.LegBuilder fpmlFixedLeg) {
			fpmlFixedLeg = toBuilder(Leg.builder()
				.setId("fixedLeg")
				.build());
			
			return Optional.ofNullable(fpmlFixedLeg)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
