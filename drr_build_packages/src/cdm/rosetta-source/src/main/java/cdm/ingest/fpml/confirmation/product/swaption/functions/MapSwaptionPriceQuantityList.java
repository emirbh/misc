package cdm.ingest.fpml.confirmation.product.swaption.functions;

import cdm.ingest.fpml.confirmation.product.swap.functions.MapSwapPriceQuantityList;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.ird.Swaption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapSwaptionPriceQuantityList.MapSwaptionPriceQuantityListDefault.class)
public abstract class MapSwaptionPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSwapPriceQuantityList mapSwapPriceQuantityList;

	/**
	* @param fpmlSwaption 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(Swaption fpmlSwaption) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlSwaption);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(Swaption fpmlSwaption);

	public static class MapSwaptionPriceQuantityListDefault extends MapSwaptionPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(Swaption fpmlSwaption) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlSwaption);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, Swaption fpmlSwaption) {
			priceQuantityList.addAll(toBuilder(mapSwapPriceQuantityList.evaluate(MapperS.of(fpmlSwaption).<Swap>map("getSwap", swaption -> swaption.getSwap()).get())));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
