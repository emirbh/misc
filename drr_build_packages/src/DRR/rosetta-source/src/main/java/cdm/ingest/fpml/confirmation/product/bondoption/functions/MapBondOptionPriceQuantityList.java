package cdm.ingest.fpml.confirmation.product.bondoption.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapAssetToObservableWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapOptionBaseExtendedQuantityListWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Bond;
import fpml.consolidated.asset.ConvertibleBond;
import fpml.consolidated.bond.option.BondOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapBondOptionPriceQuantityList.MapBondOptionPriceQuantityListDefault.class)
public abstract class MapBondOptionPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetToObservableWithLocation mapAssetToObservableWithLocation;
	@Inject protected MapOptionBaseExtendedQuantityListWithLocation mapOptionBaseExtendedQuantityListWithLocation;

	/**
	* @param fpmlBondOption 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(BondOption fpmlBondOption) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlBondOption);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(BondOption fpmlBondOption);

	protected abstract MapperS<? extends Bond> fpmlUnderlyingAsset(BondOption fpmlBondOption);

	public static class MapBondOptionPriceQuantityListDefault extends MapBondOptionPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(BondOption fpmlBondOption) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlBondOption);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, BondOption fpmlBondOption) {
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantity(new ArrayList(mapOptionBaseExtendedQuantityListWithLocation.evaluate(fpmlBondOption)))
				.setObservable(mapAssetToObservableWithLocation.evaluate(fpmlUnderlyingAsset(fpmlBondOption).get()))
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
		
		@Override
		protected MapperS<? extends Bond> fpmlUnderlyingAsset(BondOption fpmlBondOption) {
			return MapperS.of(MapperS.of(fpmlBondOption).<Bond>map("getBond", bondOption -> bondOption.getBond()).getOrDefault(MapperS.of(fpmlBondOption).<ConvertibleBond>map("getConvertibleBond", bondOption -> bondOption.getConvertibleBond()).get()));
		}
	}
}
