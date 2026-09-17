package cdm.ingest.fpml.confirmation.product.varianceswap.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.variance.swaps.VarianceLeg;
import fpml.consolidated.variance.swaps.VarianceSwap;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapVarianceSwapPriceQuantityList.MapVarianceSwapPriceQuantityListDefault.class)
public abstract class MapVarianceSwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVarianceLegToPriceQuantity mapVarianceLegToPriceQuantity;

	/**
	* @param fpmlVarianceSwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(VarianceSwap fpmlVarianceSwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlVarianceSwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VarianceSwap fpmlVarianceSwap);

	public static class MapVarianceSwapPriceQuantityListDefault extends MapVarianceSwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VarianceSwap fpmlVarianceSwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlVarianceSwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, VarianceSwap fpmlVarianceSwap) {
			priceQuantityList.addAll(toBuilder(MapperS.of(fpmlVarianceSwap).<VarianceLeg>mapC("getVarianceLeg", varianceSwap -> varianceSwap.getVarianceLeg())
				.mapItem(item -> MapperS.of(mapVarianceLegToPriceQuantity.evaluate(item.get()))).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
