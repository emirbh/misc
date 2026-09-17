package cdm.ingest.fpml.confirmation.product.fxvarianceswap.functions;

import cdm.ingest.fpml.confirmation.common.functions.MapInformationSource;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessCenterTime;
import cdm.product.common.schedule.ObservationTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxFixingScheduleSimple;
import fpml.consolidated.fx.FxPerformanceSwap;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.InformationSource;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxPerformanceSwapToObservationTerms.MapFxPerformanceSwapToObservationTermsDefault.class)
public abstract class MapFxPerformanceSwapToObservationTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapFxFixingScheduleToObservationDates mapFxFixingScheduleToObservationDates;
	@Inject protected MapInformationSource mapInformationSource;

	/**
	* @param fpmlFxPerformanceSwap 
	* @return observationTerms 
	*/
	public ObservationTerms evaluate(FxPerformanceSwap fpmlFxPerformanceSwap) {
		ObservationTerms.ObservationTermsBuilder observationTermsBuilder = doEvaluate(fpmlFxPerformanceSwap);
		
		final ObservationTerms observationTerms;
		if (observationTermsBuilder == null) {
			observationTerms = null;
		} else {
			observationTerms = observationTermsBuilder.build();
			objectValidator.validate(ObservationTerms.class, observationTerms);
		}
		
		return observationTerms;
	}

	protected abstract ObservationTerms.ObservationTermsBuilder doEvaluate(FxPerformanceSwap fpmlFxPerformanceSwap);

	protected abstract MapperS<? extends FxSpotRateSource> fpmlFixingInformationSource(FxPerformanceSwap fpmlFxPerformanceSwap);

	public static class MapFxPerformanceSwapToObservationTermsDefault extends MapFxPerformanceSwapToObservationTerms {
		@Override
		protected ObservationTerms.ObservationTermsBuilder doEvaluate(FxPerformanceSwap fpmlFxPerformanceSwap) {
			ObservationTerms.ObservationTermsBuilder observationTerms = ObservationTerms.builder();
			return assignOutput(observationTerms, fpmlFxPerformanceSwap);
		}
		
		protected ObservationTerms.ObservationTermsBuilder assignOutput(ObservationTerms.ObservationTermsBuilder observationTerms, FxPerformanceSwap fpmlFxPerformanceSwap) {
			observationTerms = toBuilder(ObservationTerms.builder()
				.setObservationTime(mapBusinessCenterTime.evaluate(MapperS.of(fpmlFxPerformanceSwap).<FxSpotRateSource>map("getFixingInformationSource", fxPerformanceSwap -> fxPerformanceSwap.getFixingInformationSource()).<BusinessCenterTime>map("getFixingTime", fxSpotRateSource -> fxSpotRateSource.getFixingTime()).get()))
				.setInformationSource(cdm.observable.asset.FxSpotRateSource.builder()
					.setPrimarySource(mapInformationSource.evaluate(MapperS.of(fpmlFxPerformanceSwap).<FxSpotRateSource>map("getFixingInformationSource", fxPerformanceSwap -> fxPerformanceSwap.getFixingInformationSource()).<InformationSource>map("getPrimaryRateSource", fxSpotRateSource -> fxSpotRateSource.getPrimaryRateSource()).get()))
					.build())
				.setObservationDates(mapFxFixingScheduleToObservationDates.evaluate(MapperS.of(fpmlFxPerformanceSwap).<FxFixingScheduleSimple>map("getFixingSchedule", fxPerformanceSwap -> fxPerformanceSwap.getFixingSchedule()).get()))
				.setNumberOfObservationDates(MapperS.of(fpmlFxPerformanceSwap).<Integer>map("getNumberOfReturns", fxPerformanceSwap -> fxPerformanceSwap.getNumberOfReturns()).get())
				.build());
			
			return Optional.ofNullable(observationTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends FxSpotRateSource> fpmlFixingInformationSource(FxPerformanceSwap fpmlFxPerformanceSwap) {
			return MapperS.of(fpmlFxPerformanceSwap).<FxSpotRateSource>map("getFixingInformationSource", fxPerformanceSwap -> fxPerformanceSwap.getFixingInformationSource());
		}
	}
}
