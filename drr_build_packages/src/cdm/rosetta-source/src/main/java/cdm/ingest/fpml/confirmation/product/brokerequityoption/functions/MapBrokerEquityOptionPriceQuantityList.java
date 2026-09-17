package cdm.ingest.fpml.confirmation.product.brokerequityoption.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapEquityDerivativeBaseQuantityListWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapUnderlyerToObservableWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Underlyer;
import fpml.consolidated.eqd.BrokerEquityOption;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapBrokerEquityOptionPriceQuantityList.MapBrokerEquityOptionPriceQuantityListDefault.class)
public abstract class MapBrokerEquityOptionPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEquityDerivativeBaseQuantityListWithLocation mapEquityDerivativeBaseQuantityListWithLocation;
	@Inject protected MapUnderlyerToObservableWithLocation mapUnderlyerToObservableWithLocation;

	/**
	* @param fpmlBrokerEquityOption 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(BrokerEquityOption fpmlBrokerEquityOption) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlBrokerEquityOption);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(BrokerEquityOption fpmlBrokerEquityOption);

	public static class MapBrokerEquityOptionPriceQuantityListDefault extends MapBrokerEquityOptionPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(BrokerEquityOption fpmlBrokerEquityOption) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlBrokerEquityOption);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, BrokerEquityOption fpmlBrokerEquityOption) {
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantity(new ArrayList(mapEquityDerivativeBaseQuantityListWithLocation.evaluate(fpmlBrokerEquityOption, MapperS.of(fpmlBrokerEquityOption).<BigDecimal>map("getNumberOfOptions", brokerEquityOption -> brokerEquityOption.getNumberOfOptions()).get(), null, null)))
				.setObservable(mapUnderlyerToObservableWithLocation.evaluate(MapperS.of(fpmlBrokerEquityOption).<Underlyer>map("getUnderlyer", brokerEquityOption -> brokerEquityOption.getUnderlyer()).get()))
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
