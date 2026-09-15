package cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions;

import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountWithIdToQuantityWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapQuotedCurrencyPairToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxVarianceSwap;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import fpml.consolidated.shared.Step;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxVarianceSwapPriceQuantityList.MapFxVarianceSwapPriceQuantityListDefault.class)
public abstract class MapFxVarianceSwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountWithIdToQuantityWithLocation mapNotionalAmountWithIdToQuantityWithLocation;
	@Inject protected MapQuotedCurrencyPairToObservableWithLocation mapQuotedCurrencyPairToObservableWithLocation;

	/**
	* @param fpmlFxVarianceSwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(FxVarianceSwap fpmlFxVarianceSwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlFxVarianceSwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxVarianceSwap fpmlFxVarianceSwap);

	public static class MapFxVarianceSwapPriceQuantityListDefault extends MapFxVarianceSwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxVarianceSwap fpmlFxVarianceSwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlFxVarianceSwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, FxVarianceSwap fpmlFxVarianceSwap) {
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantity(MapperC.<FieldWithMetaNonNegativeQuantitySchedule>of(MapperS.of(mapNotionalAmountWithIdToQuantityWithLocation.evaluate(MapperS.of(fpmlFxVarianceSwap).<NonNegativeMoney>map("getVegaNotional", fxVarianceSwap -> fxVarianceSwap.getVegaNotional()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlFxVarianceSwap).<NonNegativeMoney>map("getVegaNotional", fxVarianceSwap -> fxVarianceSwap.getVegaNotional()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), "vegaNotional", null)), MapperS.of(mapNotionalAmountWithIdToQuantityWithLocation.evaluate(MapperS.of(fpmlFxVarianceSwap).<NonNegativeMoney>map("getNotional", fxVarianceSwap -> fxVarianceSwap.getNotional()).<BigDecimal>map("getAmount", nonNegativeMoney -> nonNegativeMoney.getAmount()).get(), Collections.<Step>emptyList(), MapperS.of(fpmlFxVarianceSwap).<NonNegativeMoney>map("getNotional", fxVarianceSwap -> fxVarianceSwap.getNotional()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), "notional", null))).getMulti())
				.setObservable(mapQuotedCurrencyPairToObservableWithLocation.evaluate(MapperS.of(fpmlFxVarianceSwap).<QuotedCurrencyPair>map("getQuotedCurrencyPair", fxVarianceSwap -> fxVarianceSwap.getQuotedCurrencyPair()).get(), MapperS.of(fpmlFxVarianceSwap).<FxSpotRateSource>map("getFixingInformationSource", fxVarianceSwap -> fxVarianceSwap.getFixingInformationSource()).get()))
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
