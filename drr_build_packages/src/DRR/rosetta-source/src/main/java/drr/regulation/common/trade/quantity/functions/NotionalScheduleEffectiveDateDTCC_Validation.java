package drr.regulation.common.trade.quantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalScheduleEffectiveDateDTCC_Validation.NotionalScheduleEffectiveDateDTCC_ValidationDefault.class)
public abstract class NotionalScheduleEffectiveDateDTCC_Validation implements RosettaFunction {

	/**
	* @param value 
	* @param effectiveDate 
	* @return result 
	*/
	public Boolean evaluate(List<BigDecimal> value, List<Date> effectiveDate) {
		Boolean result = doEvaluate(value, effectiveDate);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<BigDecimal> value, List<Date> effectiveDate);

	public static class NotionalScheduleEffectiveDateDTCC_ValidationDefault extends NotionalScheduleEffectiveDateDTCC_Validation {
		@Override
		protected Boolean doEvaluate(List<BigDecimal> value, List<Date> effectiveDate) {
			if (value == null) {
				value = Collections.emptyList();
			}
			if (effectiveDate == null) {
				effectiveDate = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, value, effectiveDate);
		}
		
		protected Boolean assignOutput(Boolean result, List<BigDecimal> value, List<Date> effectiveDate) {
			if (exists(MapperC.<BigDecimal>of(value)).getOrDefault(false)) {
				final ComparisonResult ifThenElseResult;
				if (greaterThan(MapperS.of(MapperC.<Date>of(effectiveDate).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult = areEqual(MapperS.of(MapperC.<Date>of(effectiveDate).resultCount()), MapperS.of(MapperC.<BigDecimal>of(value).resultCount()), CardinalityOperator.All);
				} else {
					ifThenElseResult = ComparisonResult.ofNullSafe(MapperS.of(true));
				}
				result = exists(MapperC.<Date>of(effectiveDate)).andNullSafe(ifThenElseResult).get();
			} else {
				result = notExists(MapperC.<Date>of(effectiveDate)).get();
			}
			
			return result;
		}
	}
}
