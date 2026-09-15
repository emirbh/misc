package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.FieldWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.shared.Leg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxCoreDetailsModelPriceListWithLocation.MapFxCoreDetailsModelPriceListWithLocationDefault.class)
public abstract class MapFxCoreDetailsModelPriceListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithLocation createPriceWithLocation;
	@Inject protected MapExchangeRateToPrice mapExchangeRateToPrice;

	/**
	* @param fpmlExchangeRate 
	* @param fpmlLeg 
	* @return priceList 
	*/
	public List<? extends FieldWithMetaPriceSchedule> evaluate(ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
		List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceListBuilder = doEvaluate(fpmlExchangeRate, fpmlLeg);
		
		final List<? extends FieldWithMetaPriceSchedule> priceList;
		if (priceListBuilder == null) {
			priceList = null;
		} else {
			priceList = priceListBuilder.stream().map(FieldWithMetaPriceSchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaPriceSchedule.class, priceList);
		}
		
		return priceList;
	}

	protected abstract List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(ExchangeRate fpmlExchangeRate, Leg fpmlLeg);

	public static class MapFxCoreDetailsModelPriceListWithLocationDefault extends MapFxCoreDetailsModelPriceListWithLocation {
		@Override
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> doEvaluate(ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
			List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceList = new ArrayList<>();
			return assignOutput(priceList, fpmlExchangeRate, fpmlLeg);
		}
		
		protected List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> assignOutput(List<FieldWithMetaPriceSchedule.FieldWithMetaPriceScheduleBuilder> priceList, ExchangeRate fpmlExchangeRate, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlExchangeRate)).getOrDefault(false)) {
				final FieldWithMetaPriceSchedule fieldWithMetaPriceSchedule = createPriceWithLocation.evaluate(mapExchangeRateToPrice.evaluate(fpmlExchangeRate), createPriceKey.evaluate("exchangeRate", fpmlLeg));
				if (fieldWithMetaPriceSchedule == null) {
					priceList.addAll(toBuilder(Collections.<FieldWithMetaPriceSchedule>emptyList()));
				} else {
					priceList.addAll(toBuilder(Collections.singletonList(fieldWithMetaPriceSchedule)));
				}
			} else {
				priceList.addAll(toBuilder(Collections.<FieldWithMetaPriceSchedule>emptyList()));
			}
			
			return Optional.ofNullable(priceList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
