package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapPriceQuantityList.MapVolatilitySwapPriceQuantityListDefault.class)
public abstract class MapVolatilitySwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVolatilityLegToPriceQuantity mapVolatilityLegToPriceQuantity;

	/**
	* @param fpmlVolatilitySwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(VolatilitySwap fpmlVolatilitySwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlVolatilitySwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VolatilitySwap fpmlVolatilitySwap);

	public static class MapVolatilitySwapPriceQuantityListDefault extends MapVolatilitySwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VolatilitySwap fpmlVolatilitySwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlVolatilitySwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, VolatilitySwap fpmlVolatilitySwap) {
			priceQuantityList.addAll(toBuilder(MapperS.of(fpmlVolatilitySwap).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwap -> volatilitySwap.getVolatilityLeg())
				.mapItem(item -> MapperS.of(mapVolatilityLegToPriceQuantity.evaluate(item.get()))).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
