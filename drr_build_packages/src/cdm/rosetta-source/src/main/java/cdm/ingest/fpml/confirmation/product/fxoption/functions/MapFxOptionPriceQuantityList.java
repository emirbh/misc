package cdm.ingest.fpml.confirmation.product.fxoption.functions;

import cdm.ingest.fpml.confirmation.pricequantity.functions.MapCurrencyToObservableCashWithLocation;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFxOptionToQuantityListWithLocation;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.shared.Currency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxOptionPriceQuantityList.MapFxOptionPriceQuantityListDefault.class)
public abstract class MapFxOptionPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetExchangedCurrencyAmount getExchangedCurrencyAmount;
	@Inject protected MapCurrencyToObservableCashWithLocation mapCurrencyToObservableCashWithLocation;
	@Inject protected MapFxOptionToQuantityListWithLocation mapFxOptionToQuantityListWithLocation;

	/**
	* @param fpmlFxOption 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(FxOption fpmlFxOption) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlFxOption);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxOption fpmlFxOption);

	protected abstract MapperS<? extends Currency> exchangeCurrency(FxOption fpmlFxOption);

	public static class MapFxOptionPriceQuantityListDefault extends MapFxOptionPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(FxOption fpmlFxOption) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlFxOption);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, FxOption fpmlFxOption) {
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setQuantity(new ArrayList(mapFxOptionToQuantityListWithLocation.evaluate(fpmlFxOption)))
				.setObservable(mapCurrencyToObservableCashWithLocation.evaluate(exchangeCurrency(fpmlFxOption).get(), null))
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
		protected MapperS<? extends Currency> exchangeCurrency(FxOption fpmlFxOption) {
			return MapperS.of(getExchangedCurrencyAmount.evaluate(fpmlFxOption)).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency());
		}
	}
}
