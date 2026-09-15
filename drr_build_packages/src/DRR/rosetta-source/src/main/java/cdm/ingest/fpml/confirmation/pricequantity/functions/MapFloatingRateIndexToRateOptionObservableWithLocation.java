package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.Index;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.Period;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFloatingRateIndexToRateOptionObservableWithLocation.MapFloatingRateIndexToRateOptionObservableWithLocationDefault.class)
public abstract class MapFloatingRateIndexToRateOptionObservableWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableKey createObservableKey;
	@Inject protected CreateObservableWithLocation createObservableWithLocation;
	@Inject protected MapFloatingRateIndexToRateOptionWithLocation mapFloatingRateIndexToRateOptionWithLocation;

	/**
	* @param fpmlFloatingRateIndex 
	* @param fpmlIndexTenor 
	* @param fpmlLeg 
	* @return observable 
	*/
	public FieldWithMetaObservable evaluate(FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg) {
		FieldWithMetaObservable.FieldWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlFloatingRateIndex, fpmlIndexTenor, fpmlLeg);
		
		final FieldWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(FieldWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg);

	public static class MapFloatingRateIndexToRateOptionObservableWithLocationDefault extends MapFloatingRateIndexToRateOptionObservableWithLocation {
		@Override
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg) {
			FieldWithMetaObservable.FieldWithMetaObservableBuilder observable = FieldWithMetaObservable.builder();
			return assignOutput(observable, fpmlFloatingRateIndex, fpmlIndexTenor, fpmlLeg);
		}
		
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder assignOutput(FieldWithMetaObservable.FieldWithMetaObservableBuilder observable, FloatingRateIndex fpmlFloatingRateIndex, Period fpmlIndexTenor, Leg fpmlLeg) {
			if (exists(MapperS.of(fpmlFloatingRateIndex)).andNullSafe(exists(MapperS.of(fpmlIndexTenor))).getOrDefault(false)) {
				observable = toBuilder(createObservableWithLocation.evaluate(Observable.builder()
					.setIndex(Index.builder()
						.setInterestRateIndex(mapFloatingRateIndexToRateOptionWithLocation.evaluate(fpmlFloatingRateIndex, fpmlIndexTenor, fpmlLeg))
						.build())
					.build(), createObservableKey.evaluate(null, fpmlLeg)));
			} else {
				observable = toBuilder(FieldWithMetaObservable.builder().build());
			}
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
