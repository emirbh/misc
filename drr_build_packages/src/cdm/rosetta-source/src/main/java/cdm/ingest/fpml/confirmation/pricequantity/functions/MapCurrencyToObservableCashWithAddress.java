package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCurrencyToObservableCashWithAddress.MapCurrencyToObservableCashWithAddressDefault.class)
public abstract class MapCurrencyToObservableCashWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableKey createObservableKey;
	@Inject protected CreateObservableWithAddress createObservableWithAddress;

	/**
	* @param fpmlCurrency 
	* @param fpmlLeg 
	* @return observable 
	*/
	public ReferenceWithMetaObservable evaluate(Currency fpmlCurrency, Leg fpmlLeg) {
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlCurrency, fpmlLeg);
		
		final ReferenceWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(ReferenceWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(Currency fpmlCurrency, Leg fpmlLeg);

	public static class MapCurrencyToObservableCashWithAddressDefault extends MapCurrencyToObservableCashWithAddress {
		@Override
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(Currency fpmlCurrency, Leg fpmlLeg) {
			ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable = ReferenceWithMetaObservable.builder();
			return assignOutput(observable, fpmlCurrency, fpmlLeg);
		}
		
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder assignOutput(ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable, Currency fpmlCurrency, Leg fpmlLeg) {
			observable = toBuilder(createObservableWithAddress.evaluate(createObservableKey.evaluate(MapperS.of(fpmlCurrency).<String>map("getValue", currency -> currency.getValue()).get(), fpmlLeg)));
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
