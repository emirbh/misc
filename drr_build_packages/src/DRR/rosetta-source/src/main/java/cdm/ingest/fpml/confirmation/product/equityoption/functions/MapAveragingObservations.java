package cdm.ingest.fpml.confirmation.product.equityoption.functions;

import cdm.product.common.schedule.AveragingObservationList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.option.shared.WeightedAveragingObservation;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapAveragingObservations.MapAveragingObservationsDefault.class)
public abstract class MapAveragingObservations implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlAveragingObservationList 
	* @return observationList 
	*/
	public List<? extends AveragingObservationList> evaluate(List<? extends fpml.consolidated.option.shared.AveragingObservationList> fpmlAveragingObservationList) {
		List<AveragingObservationList.AveragingObservationListBuilder> observationListBuilder = doEvaluate(fpmlAveragingObservationList);
		
		final List<? extends AveragingObservationList> observationList;
		if (observationListBuilder == null) {
			observationList = null;
		} else {
			observationList = observationListBuilder.stream().map(AveragingObservationList::build).collect(Collectors.toList());
			objectValidator.validate(AveragingObservationList.class, observationList);
		}
		
		return observationList;
	}

	protected abstract List<AveragingObservationList.AveragingObservationListBuilder> doEvaluate(List<? extends fpml.consolidated.option.shared.AveragingObservationList> fpmlAveragingObservationList);

	protected abstract MapperS<? extends WeightedAveragingObservation> averagingObservation(List<? extends fpml.consolidated.option.shared.AveragingObservationList> fpmlAveragingObservationList);

	public static class MapAveragingObservationsDefault extends MapAveragingObservations {
		@Override
		protected List<AveragingObservationList.AveragingObservationListBuilder> doEvaluate(List<? extends fpml.consolidated.option.shared.AveragingObservationList> fpmlAveragingObservationList) {
			if (fpmlAveragingObservationList == null) {
				fpmlAveragingObservationList = Collections.emptyList();
			}
			List<AveragingObservationList.AveragingObservationListBuilder> observationList = new ArrayList<>();
			return assignOutput(observationList, fpmlAveragingObservationList);
		}
		
		protected List<AveragingObservationList.AveragingObservationListBuilder> assignOutput(List<AveragingObservationList.AveragingObservationListBuilder> observationList, List<? extends fpml.consolidated.option.shared.AveragingObservationList> fpmlAveragingObservationList) {
			final cdm.product.common.schedule.WeightedAveragingObservation weightedAveragingObservation = cdm.product.common.schedule.WeightedAveragingObservation.builder()
				.setDateTime(averagingObservation(fpmlAveragingObservationList).<ZonedDateTime>map("getDateTime", _weightedAveragingObservation -> _weightedAveragingObservation.getDateTime()).get())
				.setObservationNumber(averagingObservation(fpmlAveragingObservationList).<Integer>map("getObservationNumber", _weightedAveragingObservation -> _weightedAveragingObservation.getObservationNumber()).get())
				.setWeight(averagingObservation(fpmlAveragingObservationList).<BigDecimal>map("getWeight", _weightedAveragingObservation -> _weightedAveragingObservation.getWeight()).get())
				.build();
			final AveragingObservationList averagingObservationList = AveragingObservationList.builder()
				.setAveragingObservation((weightedAveragingObservation == null ? Collections.<cdm.product.common.schedule.WeightedAveragingObservation>emptyList() : Collections.singletonList(weightedAveragingObservation)))
				.build();
			if (averagingObservationList == null) {
				observationList.addAll(toBuilder(Collections.<AveragingObservationList>emptyList()));
			} else {
				observationList.addAll(toBuilder(Collections.singletonList(averagingObservationList)));
			}
			
			return Optional.ofNullable(observationList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends WeightedAveragingObservation> averagingObservation(List<? extends fpml.consolidated.option.shared.AveragingObservationList> fpmlAveragingObservationList) {
			return MapperC.<fpml.consolidated.option.shared.AveragingObservationList>of(fpmlAveragingObservationList).<WeightedAveragingObservation>mapC("getAveragingObservation", averagingObservationList -> averagingObservationList.getAveragingObservation())
				.first();
		}
	}
}
