package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
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

@ImplementedBy(MapUnderlyerToObservableWithAddress.MapUnderlyerToObservableWithAddressDefault.class)
public abstract class MapUnderlyerToObservableWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableWithAddress createObservableWithAddress;
	@Inject protected ObservableKeyValue observableKeyValue;

	/**
	* @param fpmlUnderlyer 
	* @return observable 
	*/
	public ReferenceWithMetaObservable evaluate(Underlyer fpmlUnderlyer) {
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlUnderlyer);
		
		final ReferenceWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(ReferenceWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(Underlyer fpmlUnderlyer);

	protected abstract MapperS<? extends Basket> basket(Underlyer fpmlUnderlyer);

	protected abstract MapperS<? extends Asset> asset(Underlyer fpmlUnderlyer);

	public static class MapUnderlyerToObservableWithAddressDefault extends MapUnderlyerToObservableWithAddress {
		@Override
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(Underlyer fpmlUnderlyer) {
			ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable = ReferenceWithMetaObservable.builder();
			return assignOutput(observable, fpmlUnderlyer);
		}
		
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder assignOutput(ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable, Underlyer fpmlUnderlyer) {
			if (exists(basket(fpmlUnderlyer)).getOrDefault(false)) {
				observable = toBuilder(createObservableWithAddress.evaluate(observableKeyValue.evaluate(basket(fpmlUnderlyer).get())));
			} else if (exists(asset(fpmlUnderlyer)).getOrDefault(false)) {
				observable = toBuilder(createObservableWithAddress.evaluate(observableKeyValue.evaluate(asset(fpmlUnderlyer).get())));
			} else {
				observable = toBuilder(ReferenceWithMetaObservable.builder().build());
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
