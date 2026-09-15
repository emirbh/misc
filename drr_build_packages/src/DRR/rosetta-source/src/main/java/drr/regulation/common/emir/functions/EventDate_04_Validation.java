package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EventDate_04_Validation.EventDate_04_ValidationDefault.class)
public abstract class EventDate_04_Validation implements RosettaFunction {

	/**
	* @param eventDate 
	* @param reportingTimestamp 
	* @return result 
	*/
	public Boolean evaluate(Date eventDate, ZonedDateTime reportingTimestamp) {
		Boolean result = doEvaluate(eventDate, reportingTimestamp);
		
		return result;
	}

	protected abstract Boolean doEvaluate(Date eventDate, ZonedDateTime reportingTimestamp);

	public static class EventDate_04_ValidationDefault extends EventDate_04_Validation {
		@Override
		protected Boolean doEvaluate(Date eventDate, ZonedDateTime reportingTimestamp) {
			Boolean result = null;
			return assignOutput(result, eventDate, reportingTimestamp);
		}
		
		protected Boolean assignOutput(Boolean result, Date eventDate, ZonedDateTime reportingTimestamp) {
			result = lessThanEquals(MapperS.of(eventDate), MapperS.of(reportingTimestamp).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), CardinalityOperator.All).get();
			
			return result;
		}
	}
}
