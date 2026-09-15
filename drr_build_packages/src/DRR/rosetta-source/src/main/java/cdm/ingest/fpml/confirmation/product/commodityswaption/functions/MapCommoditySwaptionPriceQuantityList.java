package cdm.ingest.fpml.confirmation.product.commodityswaption.functions;

import cdm.ingest.fpml.confirmation.product.commodityswap.functions.MapFixedLegToPriceQuantity;
import cdm.ingest.fpml.confirmation.product.commodityswap.functions.MapFloatingLegToPriceQuantity;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.com.CommoditySwaptionUnderlying;
import fpml.consolidated.com.FixedLeg;
import fpml.consolidated.com.FloatingLeg;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwaptionPriceQuantityList.MapCommoditySwaptionPriceQuantityListDefault.class)
public abstract class MapCommoditySwaptionPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFixedLegToPriceQuantity mapFixedLegToPriceQuantity;
	@Inject protected MapFloatingLegToPriceQuantity mapFloatingLegToPriceQuantity;

	/**
	* @param fpmlCommoditySwaption 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(CommoditySwaption fpmlCommoditySwaption) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlCommoditySwaption);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CommoditySwaption fpmlCommoditySwaption);

	protected abstract MapperC<? extends CommodityLeg> fpmlCommoditySwaptionLegList(CommoditySwaption fpmlCommoditySwaption);

	public static class MapCommoditySwaptionPriceQuantityListDefault extends MapCommoditySwaptionPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CommoditySwaption fpmlCommoditySwaption) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlCommoditySwaption);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, CommoditySwaption fpmlCommoditySwaption) {
			priceQuantityList.addAll(toBuilder(fpmlCommoditySwaptionLegList(fpmlCommoditySwaption)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<PriceQuantity>ofNull();
					}
					if (switchArgument instanceof FixedLeg) {
						final FixedLeg fixedLeg = (FixedLeg) switchArgument;
						return MapperS.of(mapFixedLegToPriceQuantity.evaluate(fixedLeg));
					}
					return MapperS.<PriceQuantity>ofNull();
				}).getMulti()));
			
			priceQuantityList.addAll(toBuilder(fpmlCommoditySwaptionLegList(fpmlCommoditySwaption)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<PriceQuantity>ofNull();
					}
					if (switchArgument instanceof FloatingLeg) {
						final FloatingLeg floatingLeg = (FloatingLeg) switchArgument;
						return MapperS.of(mapFloatingLegToPriceQuantity.evaluate(floatingLeg));
					}
					return MapperS.<PriceQuantity>ofNull();
				}).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends CommodityLeg> fpmlCommoditySwaptionLegList(CommoditySwaption fpmlCommoditySwaption) {
			return MapperS.of(fpmlCommoditySwaption).<CommoditySwaptionUnderlying>map("getCommoditySwap", commoditySwaption -> commoditySwaption.getCommoditySwap()).<CommodityLeg>mapC("getCommoditySwapLeg", commoditySwaptionUnderlying -> commoditySwaptionUnderlying.getCommoditySwapLeg());
		}
	}
}
