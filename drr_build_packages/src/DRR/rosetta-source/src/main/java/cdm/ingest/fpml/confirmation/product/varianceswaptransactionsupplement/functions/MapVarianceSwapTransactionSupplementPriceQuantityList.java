package cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions;

import cdm.ingest.fpml.confirmation.product.varianceswap.functions.MapVarianceLegToPriceQuantity;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.variance.swaps.VarianceLeg;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapVarianceSwapTransactionSupplementPriceQuantityList.MapVarianceSwapTransactionSupplementPriceQuantityListDefault.class)
public abstract class MapVarianceSwapTransactionSupplementPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVarianceLegToPriceQuantity mapVarianceLegToPriceQuantity;

	/**
	* @param fpmlVarianceSwapTransactionSupplement 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlVarianceSwapTransactionSupplement);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement);

	public static class MapVarianceSwapTransactionSupplementPriceQuantityListDefault extends MapVarianceSwapTransactionSupplementPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlVarianceSwapTransactionSupplement);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement) {
			priceQuantityList.addAll(toBuilder(MapperS.of(fpmlVarianceSwapTransactionSupplement).<VarianceLeg>mapC("getVarianceLeg", varianceSwapTransactionSupplement -> varianceSwapTransactionSupplement.getVarianceLeg())
				.mapItem(item -> MapperS.of(mapVarianceLegToPriceQuantity.evaluate(item.get()))).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
