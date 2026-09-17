package cdm.ingest.fpml.confirmation.product.equityoption.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapEquityDerivativeBaseQuantityListWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eqd.EquityOption;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapEquityOptionPriceQuantityList.MapEquityOptionPriceQuantityListDefault.class)
public abstract class MapEquityOptionPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEquityDerivativeBaseQuantityListWithLocation mapEquityDerivativeBaseQuantityListWithLocation;
	@Inject protected MapUnderlyerToObservableWithLocation mapUnderlyerToObservableWithLocation;

	/**
	* @param fpmlEquityOption 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(EquityOption fpmlEquityOption) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlEquityOption);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(EquityOption fpmlEquityOption);

	public static class MapEquityOptionPriceQuantityListDefault extends MapEquityOptionPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(EquityOption fpmlEquityOption) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlEquityOption);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, EquityOption fpmlEquityOption) {
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantity(new ArrayList(mapEquityDerivativeBaseQuantityListWithLocation.evaluate(fpmlEquityOption, MapperS.of(fpmlEquityOption).<BigDecimal>map("getNumberOfOptions", equityOption -> equityOption.getNumberOfOptions()).get(), MapperS.of(fpmlEquityOption).<BigDecimal>map("getOptionEntitlement", equityOption -> equityOption.getOptionEntitlement()).get(), MapperS.of(fpmlEquityOption).<Underlyer>map("getUnderlyer", equityOption -> equityOption.getUnderlyer()).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<BigDecimal>map("getOpenUnits", singleUnderlyer -> singleUnderlyer.getOpenUnits()).get())))
				.setObservable(mapUnderlyerToObservableWithLocation.evaluate(MapperS.of(fpmlEquityOption).<Underlyer>map("getUnderlyer", equityOption -> equityOption.getUnderlyer()).get()))
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
