package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.FieldWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.shared.Leg;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityClassificationListToObservableCommodityWithLocation.MapCommodityClassificationListToObservableCommodityWithLocationDefault.class)
public abstract class MapCommodityClassificationListToObservableCommodityWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableKey createObservableKey;
	@Inject protected CreateObservableWithLocation createObservableWithLocation;
	@Inject protected MapCommodityClassificationListToObservableCommodity mapCommodityClassificationListToObservableCommodity;

	/**
	* @param fpmlCommodityClassificationList 
	* @param fpmlLeg 
	* @return observable 
	*/
	public FieldWithMetaObservable evaluate(List<? extends CommodityClassification> fpmlCommodityClassificationList, Leg fpmlLeg) {
		FieldWithMetaObservable.FieldWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlCommodityClassificationList, fpmlLeg);
		
		final FieldWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(FieldWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(List<? extends CommodityClassification> fpmlCommodityClassificationList, Leg fpmlLeg);

	public static class MapCommodityClassificationListToObservableCommodityWithLocationDefault extends MapCommodityClassificationListToObservableCommodityWithLocation {
		@Override
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder doEvaluate(List<? extends CommodityClassification> fpmlCommodityClassificationList, Leg fpmlLeg) {
			if (fpmlCommodityClassificationList == null) {
				fpmlCommodityClassificationList = Collections.emptyList();
			}
			FieldWithMetaObservable.FieldWithMetaObservableBuilder observable = FieldWithMetaObservable.builder();
			return assignOutput(observable, fpmlCommodityClassificationList, fpmlLeg);
		}
		
		protected FieldWithMetaObservable.FieldWithMetaObservableBuilder assignOutput(FieldWithMetaObservable.FieldWithMetaObservableBuilder observable, List<? extends CommodityClassification> fpmlCommodityClassificationList, Leg fpmlLeg) {
			observable = toBuilder(createObservableWithLocation.evaluate(mapCommodityClassificationListToObservableCommodity.evaluate(fpmlCommodityClassificationList), createObservableKey.evaluate("commodityClassification", fpmlLeg)));
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
