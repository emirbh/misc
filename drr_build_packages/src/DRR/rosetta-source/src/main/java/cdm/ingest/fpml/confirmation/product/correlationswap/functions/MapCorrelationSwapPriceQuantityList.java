package cdm.ingest.fpml.confirmation.product.correlationswap.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNonNegativeMoneyToQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.correlation.swaps.CorrelationAmount;
import fpml.consolidated.correlation.swaps.CorrelationLeg;
import fpml.consolidated.correlation.swaps.CorrelationSwap;
import fpml.consolidated.eq.shared.Correlation;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCorrelationSwapPriceQuantityList.MapCorrelationSwapPriceQuantityListDefault.class)
public abstract class MapCorrelationSwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNonNegativeMoneyToQuantityWithLocation mapNonNegativeMoneyToQuantityWithLocation;
	@Inject protected MapUnderlyerToObservableWithLocation mapUnderlyerToObservableWithLocation;

	/**
	* @param fpmlCorrelationSwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(CorrelationSwap fpmlCorrelationSwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlCorrelationSwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CorrelationSwap fpmlCorrelationSwap);

	protected abstract MapperS<? extends CorrelationLeg> correlationLeg(CorrelationSwap fpmlCorrelationSwap);

	public static class MapCorrelationSwapPriceQuantityListDefault extends MapCorrelationSwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CorrelationSwap fpmlCorrelationSwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlCorrelationSwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, CorrelationSwap fpmlCorrelationSwap) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = mapNonNegativeMoneyToQuantityWithLocation.evaluate(MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<CorrelationAmount>map("getAmount", _correlationLeg -> _correlationLeg.getAmount()).<Correlation>map("getCorrelation", correlationAmount -> correlationAmount.getCorrelation()).<NonNegativeMoney>map("getNotionalAmount", correlation -> correlation.getNotionalAmount()).get(), null, correlationLeg(fpmlCorrelationSwap).get());
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantity((fieldWithMetaNonNegativeQuantitySchedule == null ? Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList() : Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule)))
				.setObservable(mapUnderlyerToObservableWithLocation.evaluate(MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg()).<Underlyer>map("getUnderlyer", _correlationLeg -> _correlationLeg.getUnderlyer()).get()))
				.build();
			if (priceQuantity == null) {
				priceQuantityList.addAll(toBuilder(Collections.<PriceQuantity>emptyList()));
			} else {
				priceQuantityList.addAll(toBuilder(Collections.singletonList(priceQuantity)));
			}
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends CorrelationLeg> correlationLeg(CorrelationSwap fpmlCorrelationSwap) {
			return MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg());
		}
	}
}
