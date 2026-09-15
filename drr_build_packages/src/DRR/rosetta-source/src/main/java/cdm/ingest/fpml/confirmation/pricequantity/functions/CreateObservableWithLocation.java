package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.MetaFields;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CreateObservableWithLocation.CreateObservableWithLocationDefault.class)
public abstract class CreateObservableWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param observable 
	* @param keyValue 
	* @return observableWithLocation 
	*/
	public FieldWithMetaObservable evaluate(Observable observable, String keyValue) {
		FieldWithMetaObservable.FieldWithMetaObservableBuilder observableWithLocationBuilder = doEvaluate(observable, keyValue);
		
		final FieldWithMetaObservable observableWithLocation;
		if (observableWithLocationBuilder == null) {
			observableWithLocation = null;
		} else {
			observableWithLocation = observableWithLocationBuilder.build();
			objectValidator.validate(FieldWithMetaObservable.class, observableWithLocation);
		}
		
		return observableWithLocation;
	}

	protected abstract FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Observable observable, String keyValue);

	public static class CreateObservableWithLocationDefault extends CreateObservableWithLocation {
		@Override
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Observable observable, String keyValue) {
			FieldWithMetaObservable.FieldWithMetaObservableBuilder observableWithLocation = FieldWithMetaObservable.builder();
			return assignOutput(observableWithLocation, observable, keyValue);
		}
		
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder assignOutput(FieldWithMetaObservable.FieldWithMetaObservableBuilder observableWithLocation, Observable observable, String keyValue) {
			final Observable.ObservableBuilder withMetaArgument = observable == null ? null : observable.toBuilder();
			observableWithLocation = toBuilder(FieldWithMetaObservable.builder().setValue(withMetaArgument).setMeta(MetaFields.builder().setScopedKey(keyValue)));
			
			return Optional.ofNullable(observableWithLocation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
