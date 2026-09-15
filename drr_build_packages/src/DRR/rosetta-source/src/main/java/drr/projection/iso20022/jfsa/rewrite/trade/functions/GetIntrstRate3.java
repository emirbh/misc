package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.InterestRate33Choice__1;
import iso20022.auth030.jfsa.InterestRate33Choice__3;
import iso20022.auth030.jfsa.InterestRateLegs14__3;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetIntrstRate3.GetIntrstRate3Default.class)
public abstract class GetIntrstRate3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_FixedRateLeg1 create_FixedRateLeg1;
	@Inject protected Create_FixedRateLeg2 create_FixedRateLeg2;
	@Inject protected Create_FloatingRate3Leg2 create_FloatingRate3Leg2;
	@Inject protected Create_FloatingRateLeg2 create_FloatingRateLeg2;

	/**
	* @param drrReport 
	* @return intrstRate 
	*/
	public InterestRateLegs14__3 evaluate(JFSATransactionReport drrReport) {
		InterestRateLegs14__3.InterestRateLegs14__3Builder intrstRateBuilder = doEvaluate(drrReport);
		
		final InterestRateLegs14__3 intrstRate;
		if (intrstRateBuilder == null) {
			intrstRate = null;
		} else {
			intrstRate = intrstRateBuilder.build();
			objectValidator.validate(InterestRateLegs14__3.class, intrstRate);
		}
		
		return intrstRate;
	}

	protected abstract InterestRateLegs14__3.InterestRateLegs14__3Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetIntrstRate3Default extends GetIntrstRate3 {
		@Override
		protected InterestRateLegs14__3.InterestRateLegs14__3Builder doEvaluate(JFSATransactionReport drrReport) {
			InterestRateLegs14__3.InterestRateLegs14__3Builder intrstRate = InterestRateLegs14__3.builder();
			return assignOutput(intrstRate, drrReport);
		}
		
		protected InterestRateLegs14__3.InterestRateLegs14__3Builder assignOutput(InterestRateLegs14__3.InterestRateLegs14__3Builder intrstRate, JFSATransactionReport drrReport) {
			intrstRate = toBuilder(InterestRateLegs14__3.builder()
				.setFrstLeg(InterestRate33Choice__3.builder()
					.setFxd(create_FixedRateLeg1.evaluate(drrReport))
					.setFltg(create_FloatingRate3Leg2.evaluate(drrReport))
					.build())
				.setScndLeg(InterestRate33Choice__1.builder()
					.setFxd(create_FixedRateLeg2.evaluate(drrReport))
					.setFltg(create_FloatingRateLeg2.evaluate(drrReport))
					.build())
				.build());
			
			return Optional.ofNullable(intrstRate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
