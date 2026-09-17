package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Schedule;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFixedRateScheduleToPriceWithLocation.MapFixedRateScheduleToPriceWithLocationDefault.class)
public abstract class MapFixedRateScheduleToPriceWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithLocation createPriceWithLocation;
	@Inject protected MapScheduleToInterestRatePriceSchedule mapScheduleToInterestRatePriceSchedule;

	/**
	* @param fpmlFixedRateSchedule 
	* @param fpmlCurrency 
	* @param fpmlLeg 
	* @return priceSchedule 
	*/
	public FieldWithMetaPriceSchedule evaluate(Schedule fpmlFixedRateSchedule, Currency fpmlCurrency, Leg fpmlLeg) {
		FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceScheduleBuilder = doEvaluate(fpmlFixedRateSchedule, fpmlCurrency, fpmlLeg);
		
		final FieldWithMetaPriceSchedule priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.build();
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(Schedule fpmlFixedRateSchedule, Currency fpmlCurrency, Leg fpmlLeg);

	public static class MapFixedRateScheduleToPriceWithLocationDefault extends MapFixedRateScheduleToPriceWithLocation {
		@Override
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder doEvaluate(Schedule fpmlFixedRateSchedule, Currency fpmlCurrency, Leg fpmlLeg) {
			FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceSchedule = FieldWithMetaPriceSchedule.builder();
			return assignOutput(priceSchedule, fpmlFixedRateSchedule, fpmlCurrency, fpmlLeg);
		}
		
		protected FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder assignOutput(FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder priceSchedule, Schedule fpmlFixedRateSchedule, Currency fpmlCurrency, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFixedRateSchedule)).getOrDefault(false)) {
				priceSchedule = toBuilder(createPriceWithLocation.evaluate(mapScheduleToInterestRatePriceSchedule.evaluate(fpmlFixedRateSchedule, fpmlCurrency, null), createPriceKey.evaluate("fixedRateSchedule", fpmlLeg)));
			} else {
				priceSchedule = toBuilder(FieldWithMetaPriceSchedule.builder().build());
			}
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
