package cdm.base.math.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(StringEquals.StringEqualsDefault.class)
public abstract class StringEquals implements RosettaFunction {

	/**
	* @param s1 
	* @param s2 
	* @return result 
	*/
	public Boolean evaluate(String s1, String s2) {
		Boolean result = doEvaluate(s1, s2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(String s1, String s2);

	public static class StringEqualsDefault extends StringEquals {
		@Override
		protected Boolean doEvaluate(String s1, String s2) {
			Boolean result = null;
			return assignOutput(result, s1, s2);
		}
		
		protected Boolean assignOutput(Boolean result, String s1, String s2) {
			result = areEqual(MapperS.of(s1), MapperS.of(s2), CardinalityOperator.All).get();
			
			return result;
		}
	}
}
