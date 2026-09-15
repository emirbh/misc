package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValuationTimestamp_07_Validation.ValuationTimestamp_07_ValidationDefault.class)
public abstract class ValuationTimestamp_07_Validation implements RosettaFunction {

	/**
	* @param valuationAmount 
	* @param valuationTimestamp 
	* @return result 
	*/
	public Boolean evaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp) {
		Boolean result = doEvaluate(valuationAmount, valuationTimestamp);
		
		return result;
	}

	protected abstract Boolean doEvaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp);

	public static class ValuationTimestamp_07_ValidationDefault extends ValuationTimestamp_07_Validation {
		@Override
		protected Boolean doEvaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp) {
			Boolean result = null;
			return assignOutput(result, valuationAmount, valuationTimestamp);
		}
		
		protected Boolean assignOutput(Boolean result, BigDecimal valuationAmount, ZonedDateTime valuationTimestamp) {
			if (notExists(MapperS.of(valuationAmount)).getOrDefault(false)) {
				result = notExists(MapperS.of(valuationTimestamp)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
