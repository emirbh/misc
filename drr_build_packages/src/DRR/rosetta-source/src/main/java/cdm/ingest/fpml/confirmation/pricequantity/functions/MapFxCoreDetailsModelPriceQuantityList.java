package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.Payment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFxCoreDetailsModelPriceQuantityList.MapFxCoreDetailsModelPriceQuantityListDefault.class)
public abstract class MapFxCoreDetailsModelPriceQuantityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetFpmlExchangedCurrency getFpmlExchangedCurrency;
	@Inject protected MapCurrencyToObservableCashWithLocation mapCurrencyToObservableCashWithLocation;
	@Inject protected MapFxCoreDetailsModelPriceListWithLocation mapFxCoreDetailsModelPriceListWithLocation;
	@Inject protected MapFxCoreDetailsModelQuantityListWithLocation mapFxCoreDetailsModelQuantityListWithLocation;

	/**
	* @param fpmlExchangeRate 
	* @param fpmlExchangedCurrency1 
	* @param fpmlExchangedCurrency2 
	* @param fpmlLeg 
	* @return priceQuantityList 
	*/
	public List<? extends PriceQuantity> evaluate(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg) {
		List<PriceQuantity.PriceQuantityBuilder> priceQuantityListBuilder = doEvaluate(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg);
		
		final List<? extends PriceQuantity> priceQuantityList;
		if (priceQuantityListBuilder == null) {
			priceQuantityList = null;
		} else {
			priceQuantityList = priceQuantityListBuilder.stream().map(PriceQuantity::build).collect(Collectors.toList());
			objectValidator.validate(PriceQuantity.class, priceQuantityList);
		}
		
		return priceQuantityList;
	}

	protected abstract List<PriceQuantity.PriceQuantityBuilder> doEvaluate(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg);

	protected abstract MapperS<? extends Payment> exchangedCurrency(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg);

	public static class MapFxCoreDetailsModelPriceQuantityListDefault extends MapFxCoreDetailsModelPriceQuantityList {
		@Override
		protected List<PriceQuantity.PriceQuantityBuilder> doEvaluate(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg) {
			List<PriceQuantity.PriceQuantityBuilder> priceQuantityList = new ArrayList<>();
			return assignOutput(priceQuantityList, fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg);
		}
		
		protected List<PriceQuantity.PriceQuantityBuilder> assignOutput(List<PriceQuantity.PriceQuantityBuilder> priceQuantityList, ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg) {
			final PriceQuantity priceQuantity = PriceQuantity.builder()
				.setPrice(new ArrayList(mapFxCoreDetailsModelPriceListWithLocation.evaluate(fpmlExchangeRate, fpmlLeg)))
				.setQuantity(new ArrayList(mapFxCoreDetailsModelQuantityListWithLocation.evaluate(fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg)))
				.setObservable(mapCurrencyToObservableCashWithLocation.evaluate(exchangedCurrency(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2, fpmlLeg).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount()).<Currency>map("getCurrency", nonNegativeMoney -> nonNegativeMoney.getCurrency()).get(), fpmlLeg))
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
		protected MapperS<? extends Payment> exchangedCurrency(ExchangeRate fpmlExchangeRate, Payment fpmlExchangedCurrency1, Payment fpmlExchangedCurrency2, Leg fpmlLeg) {
			return MapperS.of(getFpmlExchangedCurrency.evaluate(fpmlExchangeRate, fpmlExchangedCurrency1, fpmlExchangedCurrency2));
		}
	}
}
