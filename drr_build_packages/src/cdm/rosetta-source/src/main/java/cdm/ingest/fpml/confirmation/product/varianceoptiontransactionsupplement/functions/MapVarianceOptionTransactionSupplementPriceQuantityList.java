package cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions;

import cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions.MapVarianceSwapTransactionSupplementPriceQuantityList;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapVarianceOptionTransactionSupplementPriceQuantityList.MapVarianceOptionTransactionSupplementPriceQuantityListDefault.class)
public abstract class MapVarianceOptionTransactionSupplementPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVarianceSwapTransactionSupplementPriceQuantityList mapVarianceSwapTransactionSupplementPriceQuantityList;

	/**
	* @param fpmlVarianceOptionTransactionSupplement 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlVarianceOptionTransactionSupplement);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement);

	public static class MapVarianceOptionTransactionSupplementPriceQuantityListDefault extends MapVarianceOptionTransactionSupplementPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlVarianceOptionTransactionSupplement);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement) {
			priceQuantityList.addAll(toBuilder(mapVarianceSwapTransactionSupplementPriceQuantityList.evaluate(MapperS.of(fpmlVarianceOptionTransactionSupplement).<VarianceSwapTransactionSupplement>map("getVarianceSwapTransactionSupplement", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getVarianceSwapTransactionSupplement()).get())));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
