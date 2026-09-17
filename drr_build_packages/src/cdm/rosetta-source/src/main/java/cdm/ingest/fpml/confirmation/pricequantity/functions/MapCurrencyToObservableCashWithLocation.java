package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Leg;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCurrencyToObservableCashWithLocation.MapCurrencyToObservableCashWithLocationDefault.class)
public abstract class MapCurrencyToObservableCashWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableKey createObservableKey;
	@Inject protected CreateObservableWithLocation createObservableWithLocation;
	@Inject protected MapCurrencyToAssetCash mapCurrencyToAssetCash;

	/**
	* @param fpmlCurrency 
	* @param fpmlLeg 
	* @return observable 
	*/
	public FieldWithMetaObservable evaluate(Currency fpmlCurrency, Leg fpmlLeg) {
		FieldWithMetaObservable.FieldWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlCurrency, fpmlLeg);
		
		final FieldWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(FieldWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Currency fpmlCurrency, Leg fpmlLeg);

	public static class MapCurrencyToObservableCashWithLocationDefault extends MapCurrencyToObservableCashWithLocation {
		@Override
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Currency fpmlCurrency, Leg fpmlLeg) {
			FieldWithMetaObservable.FieldWithMetaObservableBuilder observable = FieldWithMetaObservable.builder();
			return assignOutput(observable, fpmlCurrency, fpmlLeg);
		}
		
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder assignOutput(FieldWithMetaObservable.FieldWithMetaObservableBuilder observable, Currency fpmlCurrency, Leg fpmlLeg) {
			observable = toBuilder(createObservableWithLocation.evaluate(Observable.builder()
				.setAsset(mapCurrencyToAssetCash.evaluate(fpmlCurrency))
				.build(), createObservableKey.evaluate(MapperS.of(fpmlCurrency).<String>map("getValue", currency -> currency.getValue()).get(), fpmlLeg)));
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
