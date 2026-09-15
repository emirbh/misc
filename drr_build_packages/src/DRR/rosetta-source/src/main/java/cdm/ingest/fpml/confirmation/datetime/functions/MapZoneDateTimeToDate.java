package cdm.ingest.fpml.confirmation.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.time.ZonedDateTime;


@ImplementedBy(MapZoneDateTimeToDate.MapZoneDateTimeToDateDefault.class)
public abstract class MapZoneDateTimeToDate implements RosettaFunction {

	/**
	* @param fpmlZoneDateTime 
	* @return date 
	*/
	public Date evaluate(ZonedDateTime fpmlZoneDateTime) {
		Date date = doEvaluate(fpmlZoneDateTime);
		
		return date;
	}

	protected abstract Date doEvaluate(ZonedDateTime fpmlZoneDateTime);

	public static class MapZoneDateTimeToDateDefault extends MapZoneDateTimeToDate {
		@Override
		protected Date doEvaluate(ZonedDateTime fpmlZoneDateTime) {
			Date date = null;
			return assignOutput(date, fpmlZoneDateTime);
		}
		
		protected Date assignOutput(Date date, ZonedDateTime fpmlZoneDateTime) {
			date = MapperS.of(fpmlZoneDateTime).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get();
			
			return date;
		}
	}
}
