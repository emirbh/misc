package cdm.ingest.fpml.confirmation.product.capfloor.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCapRateScheduleToPriceWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedRateScheduleToPriceWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFloorRateScheduleToPriceWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapSpreadScheduleToPriceWithLocation;
import cdm.ingest.fpml.confirmation.product.swap.functions.GetInterestRatePriceCurrency;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.CalculationPeriodAmount;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Rate;
import fpml.consolidated.shared.Schedule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCapfloorCalculationPeriodAmountToPriceList.MapCapfloorCalculationPeriodAmountToPriceListDefault.class)
public abstract class MapCapfloorCalculationPeriodAmountToPriceList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetInterestRatePriceCurrency getInterestRatePriceCurrency;
	@Inject protected MapCapRateScheduleToPriceWithLocation mapCapRateScheduleToPriceWithLocation;
	@Inject protected MapFixedRateScheduleToPriceWithLocation mapFixedRateScheduleToPriceWithLocation;
	@Inject protected MapFloorRateScheduleToPriceWithLocation mapFloorRateScheduleToPriceWithLocation;
	@Inject protected MapSpreadScheduleToPriceWithLocation mapSpreadScheduleToPriceWithLocation;

	/**
	* @param fpmlCalculationPeriodAmount 
	* @param fpmlLeg 
	* @return priceSchedules 
	*/
	public List<? extends FieldWithMetaPriceSchedule> evaluate(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg) {
		List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedulesBuilder = doEvaluate(fpmlCalculationPeriodAmount, fpmlLeg);
		
		final List<? extends FieldWithMetaPriceSchedule> priceSchedules;
		if (priceSchedulesBuilder == null) {
			priceSchedules = null;
		} else {
			priceSchedules = priceSchedulesBuilder.stream().map(FieldWithMetaPriceSchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceSchedules);
		}
		
		return priceSchedules;
	}

	protected abstract List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg);

	protected abstract MapperS<? extends Rate> fpmlRate(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg);

	protected abstract MapperS<? extends Currency> fpmlCurrency(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg);

	protected abstract MapperS<? extends Schedule> fixedRateSchedule(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg);

	public static class MapCapfloorCalculationPeriodAmountToPriceListDefault extends MapCapfloorCalculationPeriodAmountToPriceList {
		@Override
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg) {
			List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedules = new ArrayList<>();
			return assignOutput(priceSchedules, fpmlCalculationPeriodAmount, fpmlLeg);
		}
		
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> assignOutput(List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedules, CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg) {
			final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule = mapFixedRateScheduleToPriceWithLocation.evaluate(fixedRateSchedule(fpmlCalculationPeriodAmount, fpmlLeg).get(), fpmlCurrency(fpmlCalculationPeriodAmount, fpmlLeg).get(), fpmlLeg);
			if (fieldWithMetaPriceSchedule == null) {
				priceSchedules.addAll(toBuilder(Collections.<FieldWithMetaPriceSchedule>emptyList()));
			} else {
				priceSchedules.addAll(toBuilder(Collections.singletonList(fieldWithMetaPriceSchedule)));
			}
			
			priceSchedules.addAll(toBuilder(mapSpreadScheduleToPriceWithLocation.evaluate(fpmlRate(fpmlCalculationPeriodAmount, fpmlLeg).get(), fpmlCurrency(fpmlCalculationPeriodAmount, fpmlLeg).get(), fpmlLeg)));
			
			priceSchedules.addAll(toBuilder(mapCapRateScheduleToPriceWithLocation.evaluate(fpmlRate(fpmlCalculationPeriodAmount, fpmlLeg).get(), fpmlCurrency(fpmlCalculationPeriodAmount, fpmlLeg).get(), fpmlLeg)));
			
			priceSchedules.addAll(toBuilder(mapFloorRateScheduleToPriceWithLocation.evaluate(fpmlRate(fpmlCalculationPeriodAmount, fpmlLeg).get(), fpmlCurrency(fpmlCalculationPeriodAmount, fpmlLeg).get(), fpmlLeg)));
			
			return Optional.ofNullable(priceSchedules)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Rate> fpmlRate(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg) {
			return MapperS.of(fpmlCalculationPeriodAmount).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Rate>map("getRateCalculation", calculation -> calculation.getRateCalculation());
		}
		
		@Override
		protected MapperS<? extends Currency> fpmlCurrency(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg) {
			return MapperS.of(getInterestRatePriceCurrency.evaluate(fpmlCalculationPeriodAmount));
		}
		
		@Override
		protected MapperS<? extends Schedule> fixedRateSchedule(CalculationPeriodAmount fpmlCalculationPeriodAmount, Leg fpmlLeg) {
			return MapperS.of(MapperS.of(fpmlCalculationPeriodAmount).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Schedule>map("getFixedRateSchedule", calculation -> calculation.getFixedRateSchedule()).getOrDefault(MapperS.of(fpmlCalculationPeriodAmount).<Calculation>map("getCalculation", calculationPeriodAmount -> calculationPeriodAmount.getCalculation()).<Schedule>map("getFixedRateSchedule", calculation -> calculation.getFixedRateSchedule()).get()));
		}
	}
}
