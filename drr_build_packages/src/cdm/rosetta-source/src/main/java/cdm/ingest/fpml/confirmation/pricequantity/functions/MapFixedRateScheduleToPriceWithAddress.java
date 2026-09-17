package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Schedule;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFixedRateScheduleToPriceWithAddress.MapFixedRateScheduleToPriceWithAddressDefault.class)
public abstract class MapFixedRateScheduleToPriceWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithAddress createPriceWithAddress;

	/**
	* @param fpmlFixedRateSchedule 
	* @param fpmlLeg 
	* @return priceSchedule 
	*/
	public ReferenceWithMetaPriceSchedule evaluate(Schedule fpmlFixedRateSchedule, Leg fpmlLeg) {
		ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlFixedRateSchedule, fpmlLeg);
		
		final ReferenceWithMetaPriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(ReferenceWithMetaPriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(Schedule fpmlFixedRateSchedule, Leg fpmlLeg);

	public static class MapFixedRateScheduleToPriceWithAddressDefault extends MapFixedRateScheduleToPriceWithAddress {
		@Override
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder doEvaluate(Schedule fpmlFixedRateSchedule, Leg fpmlLeg) {
			ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceSchedule = ReferenceWithMetaPriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlFixedRateSchedule, fpmlLeg);
		}
		
		protected ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder assignOutput(ReferenceWithMetaPriceSchedule.ReferenceWithMetaPriceScheduleBuilder priceSchedule, Schedule fpmlFixedRateSchedule, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFixedRateSchedule)).getOrDefault(false)) {
				priceSchedule = toBuilder(createPriceWithAddress.evaluate(createPriceKey.evaluate("fixedRateSchedule", fpmlLeg)));
			} else {
				priceSchedule = toBuilder(ReferenceWithMetaPriceSchedule.builder().build());
			}
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
