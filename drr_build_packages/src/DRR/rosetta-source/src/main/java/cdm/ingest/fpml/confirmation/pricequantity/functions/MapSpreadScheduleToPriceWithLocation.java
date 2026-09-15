package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.ird.InflationRateCalculation;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.SpreadSchedule;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapSpreadScheduleToPriceWithLocation.MapSpreadScheduleToPriceWithLocationDefault.class)
public abstract class MapSpreadScheduleToPriceWithLocation implements RosettaFunction {
	
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

	protected abstract MapperC<? extends SpreadSchedule> spreadSchedule(Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg);

	public static class MapSpreadScheduleToPriceWithLocationDefault extends MapSpreadScheduleToPriceWithLocation {
		@Override
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg) {
			List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedule = new ArrayList<>();
			return assignOutput(priceSchedule, fpmlRate, fpmlCurrency, fpmlLeg);
		}
		
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> assignOutput(List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedule, Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg) {
			priceSchedule.addAll(toBuilder(spreadSchedule(fpmlRate, fpmlCurrency, fpmlLeg)
				.mapItem(item -> MapperS.of(createPriceWithLocation.evaluate(mapScheduleToInterestRatePriceSchedule.evaluate(item.get(), fpmlCurrency, ArithmeticOperationEnum.ADD), createPriceKey.evaluate("spreadSchedule", fpmlLeg)))).getMulti()));
			
			return Optional.ofNullable(priceSchedule)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends SpreadSchedule> spreadSchedule(Rate fpmlRate, Currency fpmlCurrency, Leg fpmlLeg) {
			if (fpmlRate == null) {
				return MapperC.<SpreadSchedule>ofNull();
			}
			if (fpmlRate instanceof FloatingRateCalculation) {
				final FloatingRateCalculation floatingRateCalculation = (FloatingRateCalculation) fpmlRate;
				return MapperS.of(floatingRateCalculation).<SpreadSchedule>mapC("getSpreadSchedule", _floatingRateCalculation -> _floatingRateCalculation.getSpreadSchedule());
			}
			if (fpmlRate instanceof InflationRateCalculation) {
				final InflationRateCalculation inflationRateCalculation = (InflationRateCalculation) fpmlRate;
				return MapperS.of(inflationRateCalculation).<SpreadSchedule>mapC("getSpreadSchedule", _inflationRateCalculation -> _inflationRateCalculation.getSpreadSchedule());
			}
			return MapperC.<SpreadSchedule>ofNull();
		}
	}
}
