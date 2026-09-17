package cdm.ingest.fpml.confirmation.product.commodityforward.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.com.CommodityForward;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommodityForwardPriceQuantityList.MapCommodityForwardPriceQuantityListDefault.class)
public abstract class MapCommodityForwardPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityForward 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(CommodityForward fpmlCommodityForward) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlCommodityForward);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CommodityForward fpmlCommodityForward);

	public static class MapCommodityForwardPriceQuantityListDefault extends MapCommodityForwardPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CommodityForward fpmlCommodityForward) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlCommodityForward);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, CommodityForward fpmlCommodityForward) {
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
