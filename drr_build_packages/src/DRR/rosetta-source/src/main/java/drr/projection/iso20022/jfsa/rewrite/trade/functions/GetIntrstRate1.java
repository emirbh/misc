package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.InterestRate33Choice__1;
import iso20022.auth030.jfsa.InterestRate33Choice__2;
import iso20022.auth030.jfsa.InterestRateLegs14__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetIntrstRate1.GetIntrstRate1Default.class)
public abstract class GetIntrstRate1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_FixedRateLeg1 create_FixedRateLeg1;
	@Inject protected Create_FixedRateLeg2 create_FixedRateLeg2;
	@Inject protected Create_FloatingRate2Leg2 create_FloatingRate2Leg2;
	@Inject protected Create_FloatingRateLeg1 create_FloatingRateLeg1;

	/**
	* @param drrReport 
	* @return intrstRate 
	*/
	public InterestRateLegs14__1 evaluate(JFSATransactionReport drrReport) {
		InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRateBuilder = doEvaluate(drrReport);
		
		final InterestRateLegs14__1 intrstRate;
		if (intrstRateBuilder == null) {
			intrstRate = null;
		} else {
			intrstRate = intrstRateBuilder.build();
			objectValidator.validate(InterestRateLegs14__1.class, intrstRate);
		}
		
		return intrstRate;
	}

	protected abstract InterestRateLegs14__1.InterestRateLegs14__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetIntrstRate1Default extends GetIntrstRate1 {
		@Override
		protected InterestRateLegs14__1.InterestRateLegs14__1Builder doEvaluate(JFSATransactionReport drrReport) {
			InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRate = InterestRateLegs14__1.builder();
			return assignOutput(intrstRate, drrReport);
		}
		
		protected InterestRateLegs14__1.InterestRateLegs14__1Builder assignOutput(InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRate, JFSATransactionReport drrReport) {
			intrstRate = toBuilder(InterestRateLegs14__1.builder()
				.setFrstLeg(InterestRate33Choice__1.builder()
					.setFxd(create_FixedRateLeg1.evaluate(drrReport))
					.setFltg(create_FloatingRateLeg1.evaluate(drrReport))
					.build())
				.setScndLeg(InterestRate33Choice__2.builder()
					.setFxd(create_FixedRateLeg2.evaluate(drrReport))
					.setFltg(create_FloatingRate2Leg2.evaluate(drrReport))
					.build())
				.build());
			
			return Optional.ofNullable(intrstRate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
