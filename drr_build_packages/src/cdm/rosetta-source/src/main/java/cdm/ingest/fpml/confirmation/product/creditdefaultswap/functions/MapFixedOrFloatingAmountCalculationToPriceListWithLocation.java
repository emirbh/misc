package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedRateToPriceScheduleWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapSpreadScheduleToPriceWithLocation;
import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.FixedAmountCalculation;
import fpml.consolidated.cd.FixedRate;
import fpml.consolidated.cd.FloatingAmountCalculation;
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

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFixedOrFloatingAmountCalculationToPriceListWithLocation.MapFixedOrFloatingAmountCalculationToPriceListWithLocationDefault.class)
public abstract class MapFixedOrFloatingAmountCalculationToPriceListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFixedRateToPriceScheduleWithLocation mapFixedRateToPriceScheduleWithLocation;
	@Inject protected MapSpreadScheduleToPriceWithLocation mapSpreadScheduleToPriceWithLocation;

	/**
	* @param fpmlFixedAmountCalculation 
	* @param fpmlFloatingAmountCalculation 
	* @param fpmlCurrency 
	* @param fpmlLeg 
	* @return priceScheduleList 
	*/
	public List<? extends FieldWithMetaPriceSchedule> evaluate(FixedAmountCalculation fpmlFixedAmountCalculation, FloatingAmountCalculation fpmlFloatingAmountCalculation, Currency fpmlCurrency, Leg fpmlLeg) {
		List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceScheduleListBuilder = doEvaluate(fpmlFixedAmountCalculation, fpmlFloatingAmountCalculation, fpmlCurrency, fpmlLeg);
		
		final List<? extends FieldWithMetaPriceSchedule> priceScheduleList;
		if (priceScheduleListBuilder == null) {
			priceScheduleList = null;
		} else {
			priceScheduleList = priceScheduleListBuilder.stream().map(FieldWithMetaPriceSchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceScheduleList);
		}
		
		return priceScheduleList;
	}

	protected abstract List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(FixedAmountCalculation fpmlFixedAmountCalculation, FloatingAmountCalculation fpmlFloatingAmountCalculation, Currency fpmlCurrency, Leg fpmlLeg);

	public static class MapFixedOrFloatingAmountCalculationToPriceListWithLocationDefault extends MapFixedOrFloatingAmountCalculationToPriceListWithLocation {
		@Override
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(FixedAmountCalculation fpmlFixedAmountCalculation, FloatingAmountCalculation fpmlFloatingAmountCalculation, Currency fpmlCurrency, Leg fpmlLeg) {
			List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceScheduleList = new ArrayList<>();
			return assignOutput(priceScheduleList, fpmlFixedAmountCalculation, fpmlFloatingAmountCalculation, fpmlCurrency, fpmlLeg);
		}
		
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> assignOutput(List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceScheduleList, FixedAmountCalculation fpmlFixedAmountCalculation, FloatingAmountCalculation fpmlFloatingAmountCalculation, Currency fpmlCurrency, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFixedAmountCalculation).<FixedRate>map("getFixedRate", fixedAmountCalculation -> fixedAmountCalculation.getFixedRate())).getOrDefault(false)) {
				final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule = mapFixedRateToPriceScheduleWithLocation.evaluate(MapperS.of(fpmlFixedAmountCalculation).<FixedRate>map("getFixedRate", fixedAmountCalculation -> fixedAmountCalculation.getFixedRate()).<BigDecimal>map("getValue", fixedRate -> fixedRate.getValue()).get(), Collections.<Step>emptyList(), fpmlCurrency, fpmlLeg);
				if (fieldWithMetaPriceSchedule == null) {
					priceScheduleList.addAll(toBuilder(Collections.<FieldWithMetaPriceSchedule>emptyList()));
				} else {
					priceScheduleList.addAll(toBuilder(Collections.singletonList(fieldWithMetaPriceSchedule)));
				}
			} else if (exists(MapperS.of(fpmlFloatingAmountCalculation).<FloatingRateCalculation>map("getFloatingRate", floatingAmountCalculation -> floatingAmountCalculation.getFloatingRate())).getOrDefault(false)) {
				priceScheduleList.addAll(toBuilder(mapSpreadScheduleToPriceWithLocation.evaluate(MapperS.of(fpmlFloatingAmountCalculation).<FloatingRateCalculation>map("getFloatingRate", floatingAmountCalculation -> floatingAmountCalculation.getFloatingRate()).get(), fpmlCurrency, fpmlLeg)));
			} else {
				priceScheduleList.addAll(toBuilder(Collections.<FieldWithMetaPriceSchedule>emptyList()));
			}
			
			return Optional.ofNullable(priceScheduleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
