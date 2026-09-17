package cdm.ingest.fpml.confirmation.product.capfloor.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.InterestRateStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCapFloorPriceQuantityList.MapCapFloorPriceQuantityListDefault.class)
public abstract class MapCapFloorPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCapfloorPriceQuantity mapCapfloorPriceQuantity;

	/**
	* @param fpmlCapFloor 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(CapFloor fpmlCapFloor) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlCapFloor);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CapFloor fpmlCapFloor);

	public static class MapCapFloorPriceQuantityListDefault extends MapCapFloorPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(CapFloor fpmlCapFloor) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlCapFloor);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, CapFloor fpmlCapFloor) {
			priceQuantityList.addAll(toBuilder(MapperS.of(fpmlCapFloor).<InterestRateStream>map("getCapFloorStream", capFloor -> capFloor.getCapFloorStream())
				.mapSingleToItem(item -> MapperS.of(mapCapfloorPriceQuantity.evaluate(item.get()))).getMulti()));
			
			return Optional.ofNullable(priceQuantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
