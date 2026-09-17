package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.DateTimeList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapFpmlDateTimeListToDateTimeList.MapFpmlDateTimeListToDateTimeListDefault.class)
public abstract class MapFpmlDateTimeListToDateTimeList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmldateTime 
	* @return zonedDateTime 
	*/
	public List<? extends DateTimeList> evaluate(fpml.consolidated.shared.DateTimeList fpmldateTime) {
		List<DateTimeList.DateTimeListBuilder> zonedDateTimeBuilder = doEvaluate(fpmldateTime);
		
		final List<? extends DateTimeList> zonedDateTime;
		if (zonedDateTimeBuilder == null) {
			zonedDateTime = null;
		} else {
			zonedDateTime = zonedDateTimeBuilder.stream().map(DateTimeList::build).collect(Collectors.toList());
			objectValidator.validate(DateTimeList.class, zonedDateTime);
		}
		
		return zonedDateTime;
	}

	protected abstract List<DateTimeList.DateTimeListBuilder> doEvaluate(fpml.consolidated.shared.DateTimeList fpmldateTime);

	public static class MapFpmlDateTimeListToDateTimeListDefault extends MapFpmlDateTimeListToDateTimeList {
		@Override
		protected List<DateTimeList.DateTimeListBuilder> doEvaluate(fpml.consolidated.shared.DateTimeList fpmldateTime) {
			List<DateTimeList.DateTimeListBuilder> zonedDateTime = new ArrayList<>();
			return assignOutput(zonedDateTime, fpmldateTime);
		}
		
		protected List<DateTimeList.DateTimeListBuilder> assignOutput(List<DateTimeList.DateTimeListBuilder> zonedDateTime, fpml.consolidated.shared.DateTimeList fpmldateTime) {
			final DateTimeList dateTimeList = DateTimeList.builder()
				.setDateTime(MapperS.of(fpmldateTime).<ZonedDateTime>mapC("getDateTime", _dateTimeList -> _dateTimeList.getDateTime()).getMulti())
				.build();
			if (dateTimeList == null) {
				zonedDateTime.addAll(toBuilder(Collections.<DateTimeList>emptyList()));
			} else {
				zonedDateTime.addAll(toBuilder(Collections.singletonList(dateTimeList)));
			}
			
			return Optional.ofNullable(zonedDateTime)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
