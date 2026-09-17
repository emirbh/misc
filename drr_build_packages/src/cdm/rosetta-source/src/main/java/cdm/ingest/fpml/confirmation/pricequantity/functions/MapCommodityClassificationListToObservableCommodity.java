package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.observable.asset.Observable;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.CommodityClassification;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityClassificationListToObservableCommodity.MapCommodityClassificationListToObservableCommodityDefault.class)
public abstract class MapCommodityClassificationListToObservableCommodity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityClassificationToTaxonomy mapCommodityClassificationToTaxonomy;

	/**
	* @param fpmlCommodityClassificationList 
	* @return observable 
	*/
	public Observable evaluate(List<? extends CommodityClassification> fpmlCommodityClassificationList) {
		Observable.ObservableBuilder observableBuilder = doEvaluate(fpmlCommodityClassificationList);
		
		final Observable observable;
		if (observableBuilder == null) {
			observable = null;
		} else {
			observable = observableBuilder.build();
			objectValidator.validate(Observable.class, observable);
		}
		
		return observable;
	}

	protected abstract Observable.ObservableBuilder doEvaluate(List<? extends CommodityClassification> fpmlCommodityClassificationList);

	public static class MapCommodityClassificationListToObservableCommodityDefault extends MapCommodityClassificationListToObservableCommodity {
		@Override
		protected Observable.ObservableBuilder doEvaluate(List<? extends CommodityClassification> fpmlCommodityClassificationList) {
			if (fpmlCommodityClassificationList == null) {
				fpmlCommodityClassificationList = Collections.emptyList();
			}
			Observable.ObservableBuilder observable = Observable.builder();
			return assignOutput(observable, fpmlCommodityClassificationList);
		}
		
		protected Observable.ObservableBuilder assignOutput(Observable.ObservableBuilder observable, List<? extends CommodityClassification> fpmlCommodityClassificationList) {
			observable = toBuilder(Observable.builder()
				.setAsset(Asset.builder()
					.setCommodity(Commodity.builder()
						.setIdentifier(Collections.<AssetIdentifier>emptyList())
						.setPriceQuoteType(null)
						.setTaxonomy(MapperC.<CommodityClassification>of(fpmlCommodityClassificationList)
							.mapItem(item -> MapperS.of(mapCommodityClassificationToTaxonomy.evaluate(item.get()))).getMulti())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(observable)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
