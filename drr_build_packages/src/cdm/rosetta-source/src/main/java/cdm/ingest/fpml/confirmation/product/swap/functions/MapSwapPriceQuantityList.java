package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.ird.Swap;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapSwapPriceQuantityList.MapSwapPriceQuantityListDefault.class)
public abstract class MapSwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSwapPriceQuantity mapSwapPriceQuantity;

	/**
	* @param fpmlSwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(Swap fpmlSwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlSwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(Swap fpmlSwap);

	public static class MapSwapPriceQuantityListDefault extends MapSwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(Swap fpmlSwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlSwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, Swap fpmlSwap) {
			priceQuantityList.addAll(toBuilder(MapperS.of(fpmlSwap).<InterestRateStream>mapC("getSwapStream", swap -> swap.getSwapStream())
				.mapItem(item -> MapperS.of(mapSwapPriceQuantity.evaluate(item.get()))).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
