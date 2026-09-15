package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Rate;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapRateOptionToObservableWithLocation.MapRateOptionToObservableWithLocationDefault.class)
public abstract class MapRateOptionToObservableWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableKey createObservableKey;
	@Inject protected CreateObservableWithLocation createObservableWithLocation;
	@Inject protected MapRateOptionWithLocation mapRateOptionWithLocation;

	/**
	* @param fpmlRate 
	* @param fpmlLeg 
	* @return observable 
	*/
	public FieldWithMetaObservable evaluate(Rate fpmlRate, Leg fpmlLeg) {
		FieldWithMetaObservable.FieldWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlRate, fpmlLeg);
		
		final FieldWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(FieldWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Rate fpmlRate, Leg fpmlLeg);

	protected abstract MapperS<? extends FieldWithMetaInterestRateIndex> interestRateIndex(Rate fpmlRate, Leg fpmlLeg);

	public static class MapRateOptionToObservableWithLocationDefault extends MapRateOptionToObservableWithLocation {
		@Override
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(Rate fpmlRate, Leg fpmlLeg) {
			FieldWithMetaObservable.FieldWithMetaObservableBuilder observable = FieldWithMetaObservable.builder();
			return assignOutput(observable, fpmlRate, fpmlLeg);
		}
		
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder assignOutput(FieldWithMetaObservable.FieldWithMetaObservableBuilder observable, Rate fpmlRate, Leg fpmlLeg) {
			if (exists(interestRateIndex(fpmlRate, fpmlLeg)).getOrDefault(false)) {
				observable = toBuilder(createObservableWithLocation.evaluate(Observable.builder()
					.setIndex(Index.builder()
						.setInterestRateIndex(interestRateIndex(fpmlRate, fpmlLeg).get())
						.build())
					.build(), createObservableKey.evaluate(null, fpmlLeg)));
			} else {
				observable = toBuilder(FieldWithMetaObservable.builder().build());
			}
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaInterestRateIndex> interestRateIndex(Rate fpmlRate, Leg fpmlLeg) {
			return MapperS.of(mapRateOptionWithLocation.evaluate(fpmlRate, fpmlLeg));
		}
	}
}
