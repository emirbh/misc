package drr.base.util.datetime.functions;

import cdm.base.datetime.AdjustableDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MaxAdjustableDate.MaxAdjustableDateDefault.class)
public abstract class MaxAdjustableDate implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableDateResolution adjustableDateResolution;

	/**
	* @param date1 
	* @param date2 
	* @return date 
	*/
	public Date evaluate(AdjustableDate date1, AdjustableDate date2) {
		Date date = doEvaluate(date1, date2);
		
		return date;
	}

	protected abstract Date doEvaluate(AdjustableDate date1, AdjustableDate date2);

	public static class MaxAdjustableDateDefault extends MaxAdjustableDate {
		@Override
		protected Date doEvaluate(AdjustableDate date1, AdjustableDate date2) {
			Date date = null;
			return assignOutput(date, date1, date2);
		}
		
		protected Date assignOutput(Date date, AdjustableDate date1, AdjustableDate date2) {
			if (greaterThan(MapperS.of(adjustableDateResolution.evaluate(date1)), MapperS.of(adjustableDateResolution.evaluate(date2)), CardinalityOperator.All).getOrDefault(false)) {
				date = adjustableDateResolution.evaluate(date1);
			} else {
				date = adjustableDateResolution.evaluate(date2);
			}
			
			return date;
		}
	}
}
