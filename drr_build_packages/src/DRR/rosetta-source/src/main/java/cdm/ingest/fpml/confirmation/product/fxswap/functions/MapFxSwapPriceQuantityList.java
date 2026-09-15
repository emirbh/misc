package cdm.ingest.fpml.confirmation.product.fxswap.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFxCoreDetailsModelPriceQuantityList;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.fx.FxSwap;
import fpml.consolidated.fx.FxSwapLeg;
import fpml.consolidated.shared.Payment;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxSwapPriceQuantityList.MapFxSwapPriceQuantityListDefault.class)
public abstract class MapFxSwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxCoreDetailsModelPriceQuantityList mapFxCoreDetailsModelPriceQuantityList;

	/**
	* @param fpmlFxSwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(FxSwap fpmlFxSwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlFxSwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxSwap fpmlFxSwap);

	public static class MapFxSwapPriceQuantityListDefault extends MapFxSwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxSwap fpmlFxSwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlFxSwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, FxSwap fpmlFxSwap) {
			priceQuantityList.addAll(toBuilder(mapFxCoreDetailsModelPriceQuantityList.evaluate(MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<ExchangeRate>map("getExchangeRate", fxSwapLeg -> fxSwapLeg.getExchangeRate()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<Payment>map("getExchangedCurrency1", fxSwapLeg -> fxSwapLeg.getExchangedCurrency1()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<Payment>map("getExchangedCurrency2", fxSwapLeg -> fxSwapLeg.getExchangedCurrency2()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).get())));
			
			priceQuantityList.addAll(toBuilder(mapFxCoreDetailsModelPriceQuantityList.evaluate(MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<ExchangeRate>map("getExchangeRate", fxSwapLeg -> fxSwapLeg.getExchangeRate()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<Payment>map("getExchangedCurrency1", fxSwapLeg -> fxSwapLeg.getExchangedCurrency1()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<Payment>map("getExchangedCurrency2", fxSwapLeg -> fxSwapLeg.getExchangedCurrency2()).get(), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).get())));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
