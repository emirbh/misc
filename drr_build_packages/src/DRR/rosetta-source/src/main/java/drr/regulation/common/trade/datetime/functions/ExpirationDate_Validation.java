package drr.regulation.common.trade.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.standards.iso.ActionTypeEnum;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExpirationDate_Validation.ExpirationDate_ValidationDefault.class)
public abstract class ExpirationDate_Validation implements RosettaFunction {

	/**
	* @param actionType 
	* @param effectiveDate 
	* @param executionTimestamp 
	* @param expirationDate 
	* @return result 
	*/
	public Boolean evaluate(ActionTypeEnum actionType, Date effectiveDate, ZonedDateTime executionTimestamp, Date expirationDate) {
		Boolean result = doEvaluate(actionType, effectiveDate, executionTimestamp, expirationDate);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ActionTypeEnum actionType, Date effectiveDate, ZonedDateTime executionTimestamp, Date expirationDate);

	public static class ExpirationDate_ValidationDefault extends ExpirationDate_Validation {
		@Override
		protected Boolean doEvaluate(ActionTypeEnum actionType, Date effectiveDate, ZonedDateTime executionTimestamp, Date expirationDate) {
			Boolean result = null;
			return assignOutput(result, actionType, effectiveDate, executionTimestamp, expirationDate);
		}
		
		protected Boolean assignOutput(Boolean result, ActionTypeEnum actionType, Date effectiveDate, ZonedDateTime executionTimestamp, Date expirationDate) {
			if (areEqual(MapperC.<ActionTypeEnum>of(MapperS.of(ActionTypeEnum.NEWT), MapperS.of(ActionTypeEnum.MODI), MapperS.of(ActionTypeEnum.CORR), MapperS.of(ActionTypeEnum.REVI)), MapperS.of(actionType), CardinalityOperator.Any).getOrDefault(false)) {
				result = greaterThanEquals(MapperS.of(expirationDate), MapperS.of(executionTimestamp).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())), CardinalityOperator.All).andNullSafe(greaterThanEquals(MapperS.of(expirationDate), MapperS.of(effectiveDate), CardinalityOperator.All)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
