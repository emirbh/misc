package cdm.ingest.fpml.confirmation.product.fxoption.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapInformationSource;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.observable.asset.FxSpotRateSource;
import cdm.product.common.schedule.ObservationTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxAsianFeature;
import fpml.consolidated.fx.FxAverageRateObservationSchedule;
import fpml.consolidated.fx.FxOptionFeatures;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxOptionFeaturesToObservationTerms.MapFxOptionFeaturesToObservationTermsDefault.class)
public abstract class MapFxOptionFeaturesToObservationTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapInformationSource mapInformationSource;
	@Inject protected MapObservationScheduleToObservationDates mapObservationScheduleToObservationDates;

	/**
	* @param fpmlFeatures 
	* @return observationTerms 
	*/
	public ObservationTerms evaluate(FxOptionFeatures fpmlFeatures) {
		ObservationTerms.ObservationTermsBuilder observationTermsBuilder = doEvaluate(fpmlFeatures);
		
		final ObservationTerms observationTerms;
		if (observationTermsBuilder == null) {
			observationTerms = null;
		} else {
			observationTerms = observationTermsBuilder.build();
			objectValidator.validate(ObservationTerms.class, observationTerms);
		}
		
		return observationTerms;
	}

	protected abstract ObservationTerms.ObservationTermsBuilder doEvaluate(FxOptionFeatures fpmlFeatures);

	public static class MapFxOptionFeaturesToObservationTermsDefault extends MapFxOptionFeaturesToObservationTerms {
		@Override
		protected ObservationTerms.ObservationTermsBuilder doEvaluate(FxOptionFeatures fpmlFeatures) {
			ObservationTerms.ObservationTermsBuilder observationTerms = ObservationTerms.builder();
			return assignOutput(observationTerms, fpmlFeatures);
		}
		
		protected ObservationTerms.ObservationTermsBuilder assignOutput(ObservationTerms.ObservationTermsBuilder observationTerms, FxOptionFeatures fpmlFeatures) {
			final MapperS<FxAsianFeature> thenArg = MapperS.of(fpmlFeatures).<FxAsianFeature>map("getAsian", fxOptionFeatures -> fxOptionFeatures.getAsian());
			observationTerms = toBuilder(thenArg
				.mapSingleToItem(item -> MapperS.of(ObservationTerms.builder()
					.setObservationTime(mapBusinessCenterTime.evaluate(item.<BusinessCenterTime>map("getFixingTime", fxAsianFeature -> fxAsianFeature.getFixingTime()).get()))
					.setInformationSource(FxSpotRateSource.builder()
						.setPrimarySource(mapInformationSource.evaluate(item.<InformationSource>map("getPrimaryRateSource", fxAsianFeature -> fxAsianFeature.getPrimaryRateSource()).get()))
						.build())
					.setObservationDates(mapObservationScheduleToObservationDates.evaluate(item.<FxAverageRateObservationSchedule>map("getObservationSchedule", fxAsianFeature -> fxAsianFeature.getObservationSchedule()).get()))
					.build())).get());
			
			return Optional.ofNullable(observationTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
