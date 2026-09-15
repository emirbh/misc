package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapAssetToObservableWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCommodityNotionalQuantityToQuantityListWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.CommodityNotionalQuantity;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.CommodityOption;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommodityOptionPriceQuantityList.MapCommodityOptionPriceQuantityListDefault.class)
public abstract class MapCommodityOptionPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetToObservableWithLocation mapAssetToObservableWithLocation;
	@Inject protected MapCommodityNotionalQuantityToQuantityListWithLocation mapCommodityNotionalQuantityToQuantityListWithLocation;

	/**
	* @param fpmlCommodityOption 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(CommodityOption fpmlCommodityOption) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlCommodityOption);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CommodityOption fpmlCommodityOption);

	public static class MapCommodityOptionPriceQuantityListDefault extends MapCommodityOptionPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CommodityOption fpmlCommodityOption) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlCommodityOption);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, CommodityOption fpmlCommodityOption) {
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantity(new ArrayList(mapCommodityNotionalQuantityToQuantityListWithLocation.evaluate(MapperS.of(fpmlCommodityOption).<CommodityNotionalQuantity>map("getNotionalQuantity", commodityOption -> commodityOption.getNotionalQuantity()).get(), MapperS.of(fpmlCommodityOption).<BigDecimal>map("getTotalNotionalQuantity", commodityOption -> commodityOption.getTotalNotionalQuantity()).get(), MapperS.of(fpmlCommodityOption).<CommodityNotionalQuantitySchedule>map("getNotionalQuantitySchedule", commodityOption -> commodityOption.getNotionalQuantitySchedule()).get(), null)))
				.setObservable(mapAssetToObservableWithLocation.evaluate(MapperS.of(fpmlCommodityOption).<Commodity>map("getCommodity", commodityOption -> commodityOption.getCommodity()).get()))
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
