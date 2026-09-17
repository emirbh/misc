package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.meta.Reference;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuotedCurrencyPairToObservableWithAddress.MapQuotedCurrencyPairToObservableWithAddressDefault.class)
public abstract class MapQuotedCurrencyPairToObservableWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableKeyForQuotedCurrencyPair createObservableKeyForQuotedCurrencyPair;

	/**
	* @param fpmlQuotedCurrencyPair 
	* @return observable 
	*/
	public ReferenceWithMetaObservable evaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair) {
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlQuotedCurrencyPair);
		
		final ReferenceWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(ReferenceWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair);

	public static class MapQuotedCurrencyPairToObservableWithAddressDefault extends MapQuotedCurrencyPairToObservableWithAddress {
		@Override
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable = ReferenceWithMetaObservable.builder();
			return assignOutput(observable, fpmlQuotedCurrencyPair);
		}
		
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder assignOutput(ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable, QuotedCurrencyPair fpmlQuotedCurrencyPair) {
			observable = toBuilder(ReferenceWithMetaObservable.builder().setValue(null).setReference(Reference.builder().setReference(createObservableKeyForQuotedCurrencyPair.evaluate(fpmlQuotedCurrencyPair))).build());
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
