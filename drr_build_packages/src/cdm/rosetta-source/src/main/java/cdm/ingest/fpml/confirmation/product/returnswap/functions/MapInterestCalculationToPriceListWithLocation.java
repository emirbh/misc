package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedRateToPriceScheduleWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapSpreadScheduleToPriceWithLocation;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.InterestCalculation;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapInterestCalculationToPriceListWithLocation.MapInterestCalculationToPriceListWithLocationDefault.class)
public abstract class MapInterestCalculationToPriceListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFixedRateToPriceScheduleWithLocation mapFixedRateToPriceScheduleWithLocation;
	@Inject protected MapSpreadScheduleToPriceWithLocation mapSpreadScheduleToPriceWithLocation;

	/**
	* @param fpmlInterestCalculation 
	* @param fpmlCurrency 
	* @param fpmlLeg 
	* @return priceSchedules 
	*/
	public List<? extends FieldWithMetaPriceSchedule> evaluate(InterestCalculation fpmlInterestCalculation, Currency fpmlCurrency, Leg fpmlLeg) {
		List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedulesBuilder = doEvaluate(fpmlInterestCalculation, fpmlCurrency, fpmlLeg);
		
		final List<? extends FieldWithMetaPriceSchedule> priceSchedules;
		if (priceSchedulesBuilder == null) {
			priceSchedules = null;
		} else {
			priceSchedules = priceSchedulesBuilder.stream().map(FieldWithMetaPriceSchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceSchedules);
		}
		
		return priceSchedules;
	}

	protected abstract List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(InterestCalculation fpmlInterestCalculation, Currency fpmlCurrency, Leg fpmlLeg);

	protected abstract MapperS<? extends FloatingRateCalculation> fpmlRate(InterestCalculation fpmlInterestCalculation, Currency fpmlCurrency, Leg fpmlLeg);

	public static class MapInterestCalculationToPriceListWithLocationDefault extends MapInterestCalculationToPriceListWithLocation {
		@Override
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(InterestCalculation fpmlInterestCalculation, Currency fpmlCurrency, Leg fpmlLeg) {
			List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedules = new ArrayList<>();
			return assignOutput(priceSchedules, fpmlInterestCalculation, fpmlCurrency, fpmlLeg);
		}
		
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> assignOutput(List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceSchedules, InterestCalculation fpmlInterestCalculation, Currency fpmlCurrency, Leg fpmlLeg) {
			final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule = mapFixedRateToPriceScheduleWithLocation.evaluate(MapperS.of(fpmlInterestCalculation).<BigDecimal>map("getFixedRate", interestCalculation -> interestCalculation.getFixedRate()).get(), Collections.<Step>emptyList(), fpmlCurrency, fpmlLeg);
			if (fieldWithMetaPriceSchedule == null) {
				priceSchedules.addAll(toBuilder(Collections.<FieldWithMetaPriceSchedule>emptyList()));
			} else {
				priceSchedules.addAll(toBuilder(Collections.singletonList(fieldWithMetaPriceSchedule)));
			}
			
			priceSchedules.addAll(toBuilder(mapSpreadScheduleToPriceWithLocation.evaluate(fpmlRate(fpmlInterestCalculation, fpmlCurrency, fpmlLeg).get(), fpmlCurrency, fpmlLeg)));
			
			return Optional.ofNullable(priceSchedules)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends FloatingRateCalculation> fpmlRate(InterestCalculation fpmlInterestCalculation, Currency fpmlCurrency, Leg fpmlLeg) {
			return MapperS.of(fpmlInterestCalculation).<FloatingRateCalculation>map("getFloatingRateCalculation", interestCalculation -> interestCalculation.getFloatingRateCalculation());
		}
	}
}
