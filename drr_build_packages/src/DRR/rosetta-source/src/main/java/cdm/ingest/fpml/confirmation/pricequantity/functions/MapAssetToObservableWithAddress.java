package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.Asset;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapAssetToObservableWithAddress.MapAssetToObservableWithAddressDefault.class)
public abstract class MapAssetToObservableWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableWithAddress createObservableWithAddress;
	@Inject protected ObservableKeyValue observableKeyValue;

	/**
	* @param fpmlAsset 
	* @return observable 
	*/
	public ReferenceWithMetaObservable evaluate(Asset fpmlAsset) {
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlAsset);
		
		final ReferenceWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(ReferenceWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(Asset fpmlAsset);

	public static class MapAssetToObservableWithAddressDefault extends MapAssetToObservableWithAddress {
		@Override
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(Asset fpmlAsset) {
			ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable = ReferenceWithMetaObservable.builder();
			return assignOutput(observable, fpmlAsset);
		}
		
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder assignOutput(ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable, Asset fpmlAsset) {
			if (exists(MapperS.of(fpmlAsset)).getOrDefault(false)) {
				observable = toBuilder(createObservableWithAddress.evaluate(observableKeyValue.evaluate(fpmlAsset)));
			} else {
				observable = toBuilder(ReferenceWithMetaObservable.builder().build());
			}
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
