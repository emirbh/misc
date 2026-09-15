package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.meta.Reference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreateObservableWithAddress.CreateObservableWithAddressDefault.class)
public abstract class CreateObservableWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param keyValue 
	* @return observableWithAddress 
	*/
	public ReferenceWithMetaObservable evaluate(String keyValue) {
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observableWithAddressBuilder = doEvaluate(keyValue);
		
		final ReferenceWithMetaObservable observableWithAddress;
		if (observableWithAddressBuilder == null) {
			observableWithAddress = null;
		} else {
			observableWithAddress = observableWithAddressBuilder.build();
			objectValidator.validate(ReferenceWithMetaObservable.class, observableWithAddress);
		}
		
		return observableWithAddress;
	}

	protected abstract ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(String keyValue);

	public static class CreateObservableWithAddressDefault extends CreateObservableWithAddress {
		@Override
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(String keyValue) {
			ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observableWithAddress = ReferenceWithMetaObservable.builder();
			return assignOutput(observableWithAddress, keyValue);
		}
		
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder assignOutput(ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observableWithAddress, String keyValue) {
			observableWithAddress = toBuilder(ReferenceWithMetaObservable.builder().setValue(null).setReference(Reference.builder().setReference(keyValue)).build());
			
			return Optional.ofNullable(observableWithAddress)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
