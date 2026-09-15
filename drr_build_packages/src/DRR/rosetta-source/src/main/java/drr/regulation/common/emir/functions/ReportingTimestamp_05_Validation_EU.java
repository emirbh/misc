package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.util.datetime.functions.CompareDateTo;
import java.time.ZonedDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReportingTimestamp_05_Validation_EU.ReportingTimestamp_05_Validation_EUDefault.class)
public abstract class ReportingTimestamp_05_Validation_EU implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CompareDateTo compareDateTo;

	/**
	* @param reportingTimestamp 
	* @return result 
	*/
	public Boolean evaluate(ZonedDateTime reportingTimestamp) {
		Boolean result = doEvaluate(reportingTimestamp);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ZonedDateTime reportingTimestamp);

	public static class ReportingTimestamp_05_Validation_EUDefault extends ReportingTimestamp_05_Validation_EU {
		@Override
		protected Boolean doEvaluate(ZonedDateTime reportingTimestamp) {
			Boolean result = null;
			return assignOutput(result, reportingTimestamp);
		}
		
		protected Boolean assignOutput(Boolean result, ZonedDateTime reportingTimestamp) {
			result = greaterThanEquals(MapperS.of(compareDateTo.evaluate(MapperS.of(reportingTimestamp).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), 2024, 4, 29)), MapperS.of(0), CardinalityOperator.All).get();
			
			return result;
		}
	}
}
