package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalAmountScheduleCount_Validation.NotionalAmountScheduleCount_ValidationDefault.class)
public abstract class NotionalAmountScheduleCount_Validation implements RosettaFunction {

	/**
	* @param notionalAmountSchedule 
	* @return result 
	*/
	public Boolean evaluate(List<? extends NotionalPeriod> notionalAmountSchedule) {
		Boolean result = doEvaluate(notionalAmountSchedule);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends NotionalPeriod> notionalAmountSchedule);

	public static class NotionalAmountScheduleCount_ValidationDefault extends NotionalAmountScheduleCount_Validation {
		@Override
		protected Boolean doEvaluate(List<? extends NotionalPeriod> notionalAmountSchedule) {
			if (notionalAmountSchedule == null) {
				notionalAmountSchedule = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, notionalAmountSchedule);
		}
		
		protected Boolean assignOutput(Boolean result, List<? extends NotionalPeriod> notionalAmountSchedule) {
			result = areEqual(MapperS.of(MapperC.<NotionalPeriod>of(notionalAmountSchedule).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).resultCount()), MapperS.of(MapperC.<NotionalPeriod>of(notionalAmountSchedule).<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).resultCount()), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(MapperC.<NotionalPeriod>of(notionalAmountSchedule).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).resultCount()), MapperS.of(MapperC.<NotionalPeriod>of(notionalAmountSchedule).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).resultCount()), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
