package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValuationTimestamp_01_Validation.ValuationTimestamp_01_ValidationDefault.class)
public abstract class ValuationTimestamp_01_Validation implements RosettaFunction {

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

	public static class ValuationTimestamp_01_ValidationDefault extends ValuationTimestamp_01_Validation {
		@Override
		protected Boolean doEvaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp) {
			Boolean result = null;
			return assignOutput(result, valuationAmount, valuationTimestamp);
		}
		
		protected Boolean assignOutput(Boolean result, BigDecimal valuationAmount, ZonedDateTime valuationTimestamp) {
			if (exists(MapperS.of(valuationAmount)).getOrDefault(false)) {
				result = exists(MapperS.of(valuationTimestamp)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
