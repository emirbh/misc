package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValuationTimestamp_04_Validation.ValuationTimestamp_04_ValidationDefault.class)
public abstract class ValuationTimestamp_04_Validation implements RosettaFunction {

	/**
	* @param valuationAmount 
	* @param valuationTimestamp 
	* @param reportingTimestamp 
	* @return result 
	*/
	public Boolean evaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp, ZonedDateTime reportingTimestamp) {
		Boolean result = doEvaluate(valuationAmount, valuationTimestamp, reportingTimestamp);
		
		return result;
	}

	protected abstract Boolean doEvaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp, ZonedDateTime reportingTimestamp);

	public static class ValuationTimestamp_04_ValidationDefault extends ValuationTimestamp_04_Validation {
		@Override
		protected Boolean doEvaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp, ZonedDateTime reportingTimestamp) {
			Boolean result = null;
			return assignOutput(result, valuationAmount, valuationTimestamp, reportingTimestamp);
		}
		
		protected Boolean assignOutput(Boolean result, BigDecimal valuationAmount, ZonedDateTime valuationTimestamp, ZonedDateTime reportingTimestamp) {
			if (exists(MapperS.of(valuationAmount)).getOrDefault(false)) {
				result = lessThanEquals(MapperS.of(valuationTimestamp), MapperS.of(reportingTimestamp), CardinalityOperator.All).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
