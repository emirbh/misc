package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.Basket;
import fpml.consolidated.asset.Index;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAssetToObservableWithLocation.MapAssetToObservableWithLocationDefault.class)
public abstract class MapAssetToObservableWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableWithLocation createObservableWithLocation;
	@Inject protected MapAsset mapAsset;
	@Inject protected MapBasket mapBasket;
	@Inject protected MapEquityIndex mapEquityIndex;
	@Inject protected ObservableKeyValue observableKeyValue;

	/**
	* @param fpmlAsset 
	* @return observable 
	*/
	public FieldWithMetaObservable evaluate(Asset fpmlAsset) {
		FieldWithMetaObservable.FieldWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlAsset);
		
		final FieldWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(FieldWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Asset fpmlAsset);

	protected abstract MapperS<? extends Observable> observableWithoutLocation(Asset fpmlAsset);

	public static class MapAssetToObservableWithLocationDefault extends MapAssetToObservableWithLocation {
		@Override
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Asset fpmlAsset) {
			FieldWithMetaObservable.FieldWithMetaObservableBuilder observable = FieldWithMetaObservable.builder();
			return assignOutput(observable, fpmlAsset);
		}
		
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder assignOutput(FieldWithMetaObservable.FieldWithMetaObservableBuilder observable, Asset fpmlAsset) {
			observable = toBuilder(createObservableWithLocation.evaluate(observableWithoutLocation(fpmlAsset).get(), observableKeyValue.evaluate(fpmlAsset)));
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Observable> observableWithoutLocation(Asset fpmlAsset) {
			if (fpmlAsset == null) {
				return MapperS.<Observable>ofNull();
			}
			if (fpmlAsset instanceof Basket) {
				final Basket basket = (Basket) fpmlAsset;
				return MapperS.of(Observable.builder()
					.setBasket(mapBasket.evaluate(basket))
					.build());
			}
			if (fpmlAsset instanceof Index) {
				final Index index = (Index) fpmlAsset;
				return MapperS.of(Observable.builder()
					.setIndex(mapEquityIndex.evaluate(index))
					.build());
			}
			return MapperS.of(Observable.builder()
				.setAsset(mapAsset.evaluate(fpmlAsset))
				.build());
		}
	}
}
