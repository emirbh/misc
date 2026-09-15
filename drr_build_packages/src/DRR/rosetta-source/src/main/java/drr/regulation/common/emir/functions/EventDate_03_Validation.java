package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.util.datetime.functions.CompareDateTo;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EventDate_03_Validation.EventDate_03_ValidationDefault.class)
public abstract class EventDate_03_Validation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CompareDateTo compareDateTo;

	/**
	* @param eventDate 
	* @return result 
	*/
	public Boolean evaluate(Date eventDate) {
		Boolean result = doEvaluate(eventDate);
		
		return result;
	}

	protected abstract Boolean doEvaluate(Date eventDate);

	public static class EventDate_03_ValidationDefault extends EventDate_03_Validation {
		@Override
		protected Boolean doEvaluate(Date eventDate) {
			Boolean result = null;
			return assignOutput(result, eventDate);
		}
		
		protected Boolean assignOutput(Boolean result, Date eventDate) {
			result = greaterThanEquals(MapperS.of(compareDateTo.evaluate(eventDate, 2014, 2, 12)), MapperS.of(0), CardinalityOperator.All).get();
			
			return result;
		}
	}
}
