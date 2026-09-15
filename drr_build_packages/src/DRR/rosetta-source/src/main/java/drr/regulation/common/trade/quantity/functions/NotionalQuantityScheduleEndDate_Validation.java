package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalQuantityScheduleEndDate_Validation.NotionalQuantityScheduleEndDate_ValidationDefault.class)
public abstract class NotionalQuantityScheduleEndDate_Validation implements RosettaFunction {

	/**
	* @param notionalQuantitySchedule 
	* @return result 
	*/
	public Boolean evaluate(List<? extends NotionalPeriod> notionalQuantitySchedule) {
		Boolean result = doEvaluate(notionalQuantitySchedule);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends NotionalPeriod> notionalQuantitySchedule);

	public static class NotionalQuantityScheduleEndDate_ValidationDefault extends NotionalQuantityScheduleEndDate_Validation {
		@Override
		protected Boolean doEvaluate(List<? extends NotionalPeriod> notionalQuantitySchedule) {
			if (notionalQuantitySchedule == null) {
				notionalQuantitySchedule = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, notionalQuantitySchedule);
		}
		
		protected Boolean assignOutput(Boolean result, List<? extends NotionalPeriod> notionalQuantitySchedule) {
			if (exists(MapperC.<NotionalPeriod>of(notionalQuantitySchedule).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue())).getOrDefault(false)) {
				result = exists(MapperC.<NotionalPeriod>of(notionalQuantitySchedule).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate())).get();
			} else {
				result = notExists(MapperC.<NotionalPeriod>of(notionalQuantitySchedule).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate())).get();
			}
			
			return result;
		}
	}
}
