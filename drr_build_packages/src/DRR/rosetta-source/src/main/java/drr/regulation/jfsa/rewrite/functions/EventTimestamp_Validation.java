package drr.regulation.jfsa.rewrite.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EventTimestamp_Validation.EventTimestamp_ValidationDefault.class)
public abstract class EventTimestamp_Validation implements RosettaFunction {

	/**
	* @param eventTimestamp 
	* @param executionTimestamp 
	* @param reportingTimestamp 
	* @param expirationDate 
	* @param earlyTerminationDate 
	* @return result 
	*/
	public Boolean evaluate(ZonedDateTime eventTimestamp, ZonedDateTime executionTimestamp, ZonedDateTime reportingTimestamp, Date expirationDate, Date earlyTerminationDate) {
		Boolean result = doEvaluate(eventTimestamp, executionTimestamp, reportingTimestamp, expirationDate, earlyTerminationDate);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ZonedDateTime eventTimestamp, ZonedDateTime executionTimestamp, ZonedDateTime reportingTimestamp, Date expirationDate, Date earlyTerminationDate);

	public static class EventTimestamp_ValidationDefault extends EventTimestamp_Validation {
		@Override
		protected Boolean doEvaluate(ZonedDateTime eventTimestamp, ZonedDateTime executionTimestamp, ZonedDateTime reportingTimestamp, Date expirationDate, Date earlyTerminationDate) {
			Boolean result = null;
			return assignOutput(result, eventTimestamp, executionTimestamp, reportingTimestamp, expirationDate, earlyTerminationDate);
		}
		
		protected Boolean assignOutput(Boolean result, ZonedDateTime eventTimestamp, ZonedDateTime executionTimestamp, ZonedDateTime reportingTimestamp, Date expirationDate, Date earlyTerminationDate) {
			final ComparisonResult ifThenElseResult0;
			if (exists(MapperS.of(expirationDate)).getOrDefault(false)) {
				ifThenElseResult0 = lessThanEquals(MapperS.of(eventTimestamp).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(expirationDate), CardinalityOperator.All);
			} else {
				ifThenElseResult0 = ComparisonResult.ofNullSafe(MapperS.of(true));
			}
			final ComparisonResult ifThenElseResult1;
			if (exists(MapperS.of(earlyTerminationDate)).getOrDefault(false)) {
				ifThenElseResult1 = lessThanEquals(MapperS.of(eventTimestamp).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(earlyTerminationDate), CardinalityOperator.All);
			} else {
				ifThenElseResult1 = ComparisonResult.ofNullSafe(MapperS.of(true));
			}
			result = exists(MapperS.of(eventTimestamp)).andNullSafe(exists(MapperS.of(executionTimestamp))).andNullSafe(exists(MapperS.of(reportingTimestamp))).andNullSafe(greaterThanEquals(MapperS.of(eventTimestamp), MapperS.of(executionTimestamp), CardinalityOperator.All)).andNullSafe(lessThanEquals(MapperS.of(eventTimestamp), MapperS.of(reportingTimestamp), CardinalityOperator.All)).andNullSafe(ifThenElseResult0).andNullSafe(ifThenElseResult1).get();
			
			return result;
		}
	}
}
