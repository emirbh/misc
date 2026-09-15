package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.shared.Leg;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityClassificationListToObservableCommodityWithAddress.MapCommodityClassificationListToObservableCommodityWithAddressDefault.class)
public abstract class MapCommodityClassificationListToObservableCommodityWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateObservableKey createObservableKey;
	@Inject protected CreateObservableWithAddress createObservableWithAddress;

	/**
	* @param fpmlCommodityClassificationList 
	* @param fpmlLeg 
	* @return observable 
	*/
	public ReferenceWithMetaObservable evaluate(List<? extends CommodityClassification> fpmlCommodityClassificationList, Leg fpmlLeg) {
		ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observableBuilder = doEvaluate(fpmlCommodityClassificationList, fpmlLeg);
		
		final ReferenceWithMetaObservable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(ReferenceWithMetaObservable.class, observable);
		}
		
		return observable;
	}

	protected abstract ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(List<? extends CommodityClassification> fpmlCommodityClassificationList, Leg fpmlLeg);

	public static class MapCommodityClassificationListToObservableCommodityWithAddressDefault extends MapCommodityClassificationListToObservableCommodityWithAddress {
		@Override
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder doEvaluate(List<? extends CommodityClassification> fpmlCommodityClassificationList, Leg fpmlLeg) {
			if (fpmlCommodityClassificationList == null) {
				fpmlCommodityClassificationList = Collections.emptyList();
			}
			ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable = ReferenceWithMetaObservable.builder();
			return assignOutput(observable, fpmlCommodityClassificationList, fpmlLeg);
		}
		
		protected ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder assignOutput(ReferenceWithMetaObservable.ReferenceWithMetaObservableBuilder observable, List<? extends CommodityClassification> fpmlCommodityClassificationList, Leg fpmlLeg) {
			if (exists(MapperC.<CommodityClassification>of(fpmlCommodityClassificationList)).getOrDefault(false)) {
				observable = toBuilder(createObservableWithAddress.evaluate(createObservableKey.evaluate("commodityClassification", fpmlLeg)));
			} else {
				observable = toBuilder(ReferenceWithMetaObservable.builder().build());
			}
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
