package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ValuationTimestamp_06_Validation.ValuationTimestamp_06_ValidationDefault.class)
public abstract class ValuationTimestamp_06_Validation implements RosettaFunction {

	/**
	* @param valuationAmount 
	* @param valuationTimestamp 
	* @param eventDate 
	* @return result 
	*/
	public Boolean evaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp, Date eventDate) {
		Boolean result = doEvaluate(valuationAmount, valuationTimestamp, eventDate);
		
		return result;
	}

	protected abstract Boolean doEvaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp, Date eventDate);

	public static class ValuationTimestamp_06_ValidationDefault extends ValuationTimestamp_06_Validation {
		@Override
		protected Boolean doEvaluate(BigDecimal valuationAmount, ZonedDateTime valuationTimestamp, Date eventDate) {
			Boolean result = null;
			return assignOutput(result, valuationAmount, valuationTimestamp, eventDate);
		}
		
		protected Boolean assignOutput(Boolean result, BigDecimal valuationAmount, ZonedDateTime valuationTimestamp, Date eventDate) {
			if (exists(MapperS.of(valuationAmount)).getOrDefault(false)) {
				result = areEqual(MapperS.of(valuationTimestamp).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), MapperS.of(eventDate), CardinalityOperator.All).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
