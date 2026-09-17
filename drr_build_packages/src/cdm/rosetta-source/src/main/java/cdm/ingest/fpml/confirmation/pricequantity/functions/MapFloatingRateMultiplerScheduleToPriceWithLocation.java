package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.Schedule;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFloatingRateMultiplerScheduleToPriceWithLocation.MapFloatingRateMultiplerScheduleToPriceWithLocationDefault.class)
public abstract class MapFloatingRateMultiplerScheduleToPriceWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithLocation createPriceWithLocation;
	@Inject protected MapScheduleToInterestRatePriceSchedule mapScheduleToInterestRatePriceSchedule;

	/**
	* @param fpmlRate 
	* @param fpmlCurrency 
	* @param fpmlLeg 
	* @return priceSchedule 
	*/
	public List<? extends FieldWithMetaPriceSchedule> evaluate(Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg) {
		List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceScheduleBuilder = doEvaluate(fpmlRate, fpmlCurrency, fpmlLeg);
		
		final List<? extends FieldWithMetaPriceSchedule> priceSchedule;
		if (priceScheduleBuilder == null) {
			priceSchedule = null;
		} else {
			priceSchedule = priceScheduleBuilder.stream().map(FieldWithMetaPriceSchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceSchedule);
		}
		
		return priceSchedule;
	}

	protected abstract List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg);

	protected abstract MapperS<? extends Schedule> floatingRateMultiplierSchedule(Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg);

	public static class MapFloatingRateMultiplerScheduleToPriceWithLocationDefault extends MapFloatingRateMultiplerScheduleToPriceWithLocation {
		@Override
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg) {
			List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedule = new ArrayList<>();
			return assignOutput(priceSchedule, fpmlRate, fpmlCurrency, fpmlLeg);
		}
		
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> assignOutput(List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedule, Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg) {
			priceSchedule.addAll(toBuilder(floatingRateMultiplierSchedule(fpmlRate, fpmlCurrency, fpmlLeg)
				.mapSingleToItem(item -> MapperS.of(createPriceWithLocation.evaluate(mapScheduleToInterestRatePriceSchedule.evaluate(item.get(), fpmlCurrency, ArithmeticOperationEnum.MULTIPLY), createPriceKey.evaluate("floatingRateMultiplerSchedule", fpmlLeg)))).getMulti()));
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Schedule> floatingRateMultiplierSchedule(Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg) {
			if (fpmlRate == null) {
				return MapperS.<Schedule>ofNull();
			}
			if (fpmlRate instanceof FloatingRateCalculation) {
				final FloatingRateCalculation floatingRateCalculation = (FloatingRateCalculation) fpmlRate;
				return MapperS.of(floatingRateCalculation).<Schedule>map("getFloatingRateMultiplierSchedule", _floatingRateCalculation -> _floatingRateCalculation.getFloatingRateMultiplierSchedule());
			}
			return MapperS.<Schedule>ofNull();
		}
	}
}
