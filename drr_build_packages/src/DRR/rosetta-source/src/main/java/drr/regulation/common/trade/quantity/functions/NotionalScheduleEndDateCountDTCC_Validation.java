package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalScheduleEndDateCountDTCC_Validation.NotionalScheduleEndDateCountDTCC_ValidationDefault.class)
public abstract class NotionalScheduleEndDateCountDTCC_Validation implements RosettaFunction {

	/**
	* @param value 
	* @param endDate 
	* @return result 
	*/
	public Boolean evaluate(List<BigDecimal> value, List<Date> endDate) {
		Boolean result = doEvaluate(value, endDate);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<BigDecimal> value, List<Date> endDate);

	public static class NotionalScheduleEndDateCountDTCC_ValidationDefault extends NotionalScheduleEndDateCountDTCC_Validation {
		@Override
		protected Boolean doEvaluate(List<BigDecimal> value, List<Date> endDate) {
			if (value == null) {
				value = Collections.emptyList();
			}
			if (endDate == null) {
				endDate = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, value, endDate);
		}
		
		protected Boolean assignOutput(Boolean result, List<BigDecimal> value, List<Date> endDate) {
			if (greaterThanEquals(MapperS.of(MapperC.<Date>of(endDate).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				result = areEqual(MapperS.of(MapperC.<Date>of(endDate).resultCount()), MapperS.of(MapperC.<BigDecimal>of(value).resultCount()), CardinalityOperator.All).get();
			} else {
				result = true;
			}
			
			return result;
		}
	}
}
