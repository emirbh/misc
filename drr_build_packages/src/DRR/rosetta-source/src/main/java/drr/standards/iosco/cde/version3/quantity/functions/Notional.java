package drr.standards.iosco.cde.version3.quantity.functions;

import cdm.base.math.Measure;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Notional.NotionalDefault.class)
public abstract class Notional implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.quantity.functions.Notional notional;

	/**
	* @param payoutLeg 
	* @return measure 
	*/
	public Measure evaluate(PayoutLegWithAuxiliary payoutLeg) {
		Measure.MeasureBuilder measureBuilder = doEvaluate(payoutLeg);
		
		final Measure measure;
		if (measureBuilder == null) {
			measure = null;
		} else {
			measure = measureBuilder.build();
			objectValidator.validate(Measure.class, measure);
		}
		
		return measure;
	}

	protected abstract Measure.MeasureBuilder doEvaluate(PayoutLegWithAuxiliary payoutLeg);

	public static class NotionalDefault extends Notional {
		@Override
		protected Measure.MeasureBuilder doEvaluate(PayoutLegWithAuxiliary payoutLeg) {
			Measure.MeasureBuilder measure = Measure.builder();
			return assignOutput(measure, payoutLeg);
		}
		
		protected Measure.MeasureBuilder assignOutput(Measure.MeasureBuilder measure, PayoutLegWithAuxiliary payoutLeg) {
			measure = toBuilder(notional.evaluate(payoutLeg));
			
			return Optional.ofNullable(measure)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
