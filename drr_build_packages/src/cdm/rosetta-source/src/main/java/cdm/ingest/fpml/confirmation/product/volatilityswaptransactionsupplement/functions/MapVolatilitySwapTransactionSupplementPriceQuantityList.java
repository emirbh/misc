package cdm.ingest.fpml.confirmation.product.volatilityswaptransactionsupplement.functions;

import cdm.ingest.fpml.confirmation.product.volatilityswap.functions.MapVolatilityLegToPriceQuantity;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapTransactionSupplementPriceQuantityList.MapVolatilitySwapTransactionSupplementPriceQuantityListDefault.class)
public abstract class MapVolatilitySwapTransactionSupplementPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapVolatilityLegToPriceQuantity mapVolatilityLegToPriceQuantity;

	/**
	* @param fpmlVolatilitySwapTransactionSupplement 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlVolatilitySwapTransactionSupplement);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement);

	public static class MapVolatilitySwapTransactionSupplementPriceQuantityListDefault extends MapVolatilitySwapTransactionSupplementPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlVolatilitySwapTransactionSupplement);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement) {
			priceQuantityList.addAll(toBuilder(MapperS.of(fpmlVolatilitySwapTransactionSupplement).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwapTransactionSupplement -> volatilitySwapTransactionSupplement.getVolatilityLeg())
				.mapItem(item -> MapperS.of(mapVolatilityLegToPriceQuantity.evaluate(item.get()))).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
