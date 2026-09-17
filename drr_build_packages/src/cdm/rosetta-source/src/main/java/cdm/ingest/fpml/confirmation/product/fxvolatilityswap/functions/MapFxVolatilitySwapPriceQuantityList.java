package cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNonNegativeMoneyToQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapQuotedCurrencyPairToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxVolatilitySwap;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxVolatilitySwapPriceQuantityList.MapFxVolatilitySwapPriceQuantityListDefault.class)
public abstract class MapFxVolatilitySwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNonNegativeMoneyToQuantityWithLocation mapNonNegativeMoneyToQuantityWithLocation;
	@Inject protected MapQuotedCurrencyPairToObservableWithLocation mapQuotedCurrencyPairToObservableWithLocation;

	/**
	* @param fpmlFxVolatilitySwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(FxVolatilitySwap fpmlFxVolatilitySwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlFxVolatilitySwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap);

	public static class MapFxVolatilitySwapPriceQuantityListDefault extends MapFxVolatilitySwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlFxVolatilitySwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, FxVolatilitySwap fpmlFxVolatilitySwap) {
			final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule = mapNonNegativeMoneyToQuantityWithLocation.evaluate(MapperS.of(fpmlFxVolatilitySwap).<NonNegativeMoney>map("getVegaNotional", fxVolatilitySwap -> fxVolatilitySwap.getVegaNotional()).get(), "vegaNotional", null);
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantity((fieldWithMetaNonNegativeQuantitySchedule == null ? Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList() : Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule)))
				.setObservable(mapQuotedCurrencyPairToObservableWithLocation.evaluate(MapperS.of(fpmlFxVolatilitySwap).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxVolatilitySwap -> fxVolatilitySwap.getQuotedCurrencyPair()).get(), MapperS.of(fpmlFxVolatilitySwap).<FxSpotRateSource>map("getFixingInformationSource", fxVolatilitySwap -> fxVolatilitySwap.getFixingInformationSource()).get()))
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
	}
}
