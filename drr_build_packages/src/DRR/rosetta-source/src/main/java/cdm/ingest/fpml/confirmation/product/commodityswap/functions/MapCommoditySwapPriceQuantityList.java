package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CoalPhysicalLeg;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.com.CommoditySwap;
import fpml.consolidated.com.ElectricityPhysicalLeg;
import fpml.consolidated.com.EnvironmentalPhysicalLeg;
import fpml.consolidated.com.FixedLeg;
import fpml.consolidated.com.FloatingLeg;
import fpml.consolidated.com.GasPhysicalLeg;
import fpml.consolidated.com.OilPhysicalLeg;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwapPriceQuantityList.MapCommoditySwapPriceQuantityListDefault.class)
public abstract class MapCommoditySwapPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCoalPhysicalLegToPriceQuantity mapCoalPhysicalLegToPriceQuantity;
	@Inject protected MapElectricityPhysicalLegToPriceQuantity mapElectricityPhysicalLegToPriceQuantity;
	@Inject protected MapEnvironmentalPhysicalLegToPriceQuantity mapEnvironmentalPhysicalLegToPriceQuantity;
	@Inject protected MapFixedLegToPriceQuantity mapFixedLegToPriceQuantity;
	@Inject protected MapFloatingLegToPriceQuantity mapFloatingLegToPriceQuantity;
	@Inject protected MapGasPhysicalLegToPriceQuantity mapGasPhysicalLegToPriceQuantity;
	@Inject protected MapOilPhysicalLegToPriceQuantity mapOilPhysicalLegToPriceQuantity;

	/**
	* @param fpmlCommoditySwap 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(CommoditySwap fpmlCommoditySwap) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlCommoditySwap);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CommoditySwap fpmlCommoditySwap);

	protected abstract MapperC<? extends CommodityLeg> fpmlCommoditySwapLegList(CommoditySwap fpmlCommoditySwap);

	public static class MapCommoditySwapPriceQuantityListDefault extends MapCommoditySwapPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CommoditySwap fpmlCommoditySwap) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlCommoditySwap);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, CommoditySwap fpmlCommoditySwap) {
			priceQuantityList.addAll(toBuilder(fpmlCommoditySwapLegList(fpmlCommoditySwap)
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
			
			priceQuantityList.addAll(toBuilder(fpmlCommoditySwapLegList(fpmlCommoditySwap)
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
			
			priceQuantityList.addAll(toBuilder(fpmlCommoditySwapLegList(fpmlCommoditySwap)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<PriceQuantity>ofNull();
					}
					if (switchArgument instanceof GasPhysicalLeg) {
						final GasPhysicalLeg gasPhysicalLeg = (GasPhysicalLeg) switchArgument;
						return MapperS.of(mapGasPhysicalLegToPriceQuantity.evaluate(gasPhysicalLeg));
					}
					return MapperS.<PriceQuantity>ofNull();
				}).getMulti()));
			
			priceQuantityList.addAll(toBuilder(fpmlCommoditySwapLegList(fpmlCommoditySwap)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<PriceQuantity>ofNull();
					}
					if (switchArgument instanceof OilPhysicalLeg) {
						final OilPhysicalLeg oilPhysicalLeg = (OilPhysicalLeg) switchArgument;
						return MapperS.of(mapOilPhysicalLegToPriceQuantity.evaluate(oilPhysicalLeg));
					}
					return MapperS.<PriceQuantity>ofNull();
				}).getMulti()));
			
			priceQuantityList.addAll(toBuilder(fpmlCommoditySwapLegList(fpmlCommoditySwap)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<PriceQuantity>ofNull();
					}
					if (switchArgument instanceof ElectricityPhysicalLeg) {
						final ElectricityPhysicalLeg electricityPhysicalLeg = (ElectricityPhysicalLeg) switchArgument;
						return MapperS.of(mapElectricityPhysicalLegToPriceQuantity.evaluate(electricityPhysicalLeg));
					}
					return MapperS.<PriceQuantity>ofNull();
				}).getMulti()));
			
			priceQuantityList.addAll(toBuilder(fpmlCommoditySwapLegList(fpmlCommoditySwap)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<PriceQuantity>ofNull();
					}
					if (switchArgument instanceof EnvironmentalPhysicalLeg) {
						final EnvironmentalPhysicalLeg environmentalPhysicalLeg = (EnvironmentalPhysicalLeg) switchArgument;
						return MapperS.of(mapEnvironmentalPhysicalLegToPriceQuantity.evaluate(environmentalPhysicalLeg));
					}
					return MapperS.<PriceQuantity>ofNull();
				}).getMulti()));
			
			priceQuantityList.addAll(toBuilder(fpmlCommoditySwapLegList(fpmlCommoditySwap)
				.mapItem(item -> {
					final CommodityLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<PriceQuantity>ofNull();
					}
					if (switchArgument instanceof CoalPhysicalLeg) {
						final CoalPhysicalLeg coalPhysicalLeg = (CoalPhysicalLeg) switchArgument;
						return MapperS.of(mapCoalPhysicalLegToPriceQuantity.evaluate(coalPhysicalLeg));
					}
					return MapperS.<PriceQuantity>ofNull();
				}).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends CommodityLeg> fpmlCommoditySwapLegList(CommoditySwap fpmlCommoditySwap) {
			return MapperS.of(fpmlCommoditySwap).<CommodityLeg>mapC("getCommoditySwapLeg", commoditySwap -> commoditySwap.getCommoditySwapLeg());
		}
	}
}
