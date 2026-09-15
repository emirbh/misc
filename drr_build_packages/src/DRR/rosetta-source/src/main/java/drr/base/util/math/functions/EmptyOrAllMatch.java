package drr.base.util.math.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EmptyOrAllMatch.EmptyOrAllMatchDefault.class)
public abstract class EmptyOrAllMatch implements RosettaFunction {

	/**
	* @param list 
	* @param expectedResult 
	* @return result 
	*/
	public Boolean evaluate(List<Boolean> list, Boolean expectedResult) {
		Boolean result = doEvaluate(list, expectedResult);
		
		return result;
	}

	protected abstract Boolean doEvaluate(List<Boolean> list, Boolean expectedResult);

	public static class EmptyOrAllMatchDefault extends EmptyOrAllMatch {
		@Override
		protected Boolean doEvaluate(List<Boolean> list, Boolean expectedResult) {
			if (list == null) {
				list = Collections.emptyList();
			}
			Boolean result = null;
			return assignOutput(result, list, expectedResult);
		}
		
		protected Boolean assignOutput(Boolean result, List<Boolean> list, Boolean expectedResult) {
			if (notExists(MapperC.<Boolean>of(list)).getOrDefault(false)) {
				result = true;
			} else {
				result = areEqual(MapperC.<Boolean>of(list), MapperS.of(expectedResult), CardinalityOperator.All).get();
			}
			
			return result;
		}
	}
}
