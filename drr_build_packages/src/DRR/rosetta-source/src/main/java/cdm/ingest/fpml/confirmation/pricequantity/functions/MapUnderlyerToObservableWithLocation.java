package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.Basket;
import fpml.consolidated.asset.SingleUnderlyer;
import fpml.consolidated.asset.Underlyer;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapUnderlyerToObservableWithLocation.MapUnderlyerToObservableWithLocationDefault.class)
public abstract class MapUnderlyerToObservableWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetToObservableWithLocation mapAssetToObservableWithLocation;

	/**
	* @param fpmlUnderlyer 
	* @return observable 
	*/
	public FieldWithMetaObservable evaluate(Underlyer fpmlUnderlyer) {
		FieldWithMetaObservable.FieldWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlUnderlyer);
		
		final FieldWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(FieldWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Underlyer fpmlUnderlyer);

	protected abstract MapperS<? extends Basket> basket(Underlyer fpmlUnderlyer);

	protected abstract MapperS<? extends Asset> asset(Underlyer fpmlUnderlyer);

	public static class MapUnderlyerToObservableWithLocationDefault extends MapUnderlyerToObservableWithLocation {
		@Override
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Underlyer fpmlUnderlyer) {
			FieldWithMetaObservable.FieldWithMetaObservableBuilder observable = FieldWithMetaObservable.builder();
			return assignOutput(observable, fpmlUnderlyer);
		}
		
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder assignOutput(FieldWithMetaObservable.FieldWithMetaObservableBuilder observable, Underlyer fpmlUnderlyer) {
			if (exists(basket(fpmlUnderlyer)).getOrDefault(false)) {
				observable = toBuilder(mapAssetToObservableWithLocation.evaluate(basket(fpmlUnderlyer).get()));
			} else if (exists(asset(fpmlUnderlyer)).getOrDefault(false)) {
				observable = toBuilder(mapAssetToObservableWithLocation.evaluate(asset(fpmlUnderlyer).get()));
			} else {
				observable = toBuilder(FieldWithMetaObservable.builder().build());
			}
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Basket> basket(Underlyer fpmlUnderlyer) {
			return MapperS.of(fpmlUnderlyer).<Basket>map("getBasket", underlyer -> underlyer.getBasket());
		}
		
		@Override
		protected MapperS<? extends Asset> asset(Underlyer fpmlUnderlyer) {
			return MapperS.of(fpmlUnderlyer).<SingleUnderlyer>map("getSingleUnderlyer", underlyer -> underlyer.getSingleUnderlyer()).<Asset>map("getUnderlyingAsset", singleUnderlyer -> singleUnderlyer.getUnderlyingAsset());
		}
	}
}
