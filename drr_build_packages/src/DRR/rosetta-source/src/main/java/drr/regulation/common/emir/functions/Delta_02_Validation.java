package drr.regulation.common.emir.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Delta_02_Validation.Delta_02_ValidationDefault.class)
public abstract class Delta_02_Validation implements RosettaFunction {

	/**
	* @param delta 
	* @return result 
	*/
	public Boolean evaluate(BigDecimal delta) {
		Boolean result = doEvaluate(delta);
		
		return result;
	}

	protected abstract Boolean doEvaluate(BigDecimal delta);

	public static class Delta_02_ValidationDefault extends Delta_02_Validation {
		@Override
		protected Boolean doEvaluate(BigDecimal delta) {
			Boolean result = null;
			return assignOutput(result, delta);
		}
		
		protected Boolean assignOutput(Boolean result, BigDecimal delta) {
			if (exists(MapperS.of(delta)).getOrDefault(false)) {
				result = true;
			} else {
				result = notExists(MapperS.of(delta)).get();
			}
			
			return result;
		}
	}
}
