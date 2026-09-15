package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Delta_03_Validation.Delta_03_ValidationDefault.class)
public abstract class Delta_03_Validation implements RosettaFunction {

	/**
	* @param delta 
	* @return result 
	*/
	public Boolean evaluate(BigDecimal delta) {
		Boolean result = doEvaluate(delta);
		
		return result;
	}

	protected abstract Boolean doEvaluate(BigDecimal delta);

	public static class Delta_03_ValidationDefault extends Delta_03_Validation {
		@Override
		protected Boolean doEvaluate(BigDecimal delta) {
			Boolean result = null;
			return assignOutput(result, delta);
		}
		
		protected Boolean assignOutput(Boolean result, BigDecimal delta) {
			if (exists(MapperS.of(delta)).getOrDefault(false)) {
				result = greaterThanEquals(MapperS.of(delta), MapperS.of(BigDecimal.valueOf(-1)), CardinalityOperator.All).andNullSafe(lessThanEquals(MapperS.of(delta), MapperS.of(BigDecimal.valueOf(1)), CardinalityOperator.All)).get();
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
