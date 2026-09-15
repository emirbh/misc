package drr.base.util.string.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ConditionValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SubString.SubStringDefault.class)
public abstract class SubString implements RosettaFunction {
	
	@Inject protected ConditionValidator conditionValidator;

	/**
	* @param text 
	* @param startIndex Position of the first character you want to extract. The first character is index 1.
	* @param length The number of characters to extract.
	* @return subString 
	*/
	public String evaluate(String text, Integer startIndex, Integer length) {
		// pre-conditions
		conditionValidator.validate(() -> notEqual(MapperS.of(startIndex), MapperS.of(0), CardinalityOperator.Any),
			"Minimum start index should be 1.");
		
		String subString = doEvaluate(text, startIndex, length);
		
		return subString;
	}

	protected abstract String doEvaluate(String text, Integer startIndex, Integer length);

	public static class SubStringDefault extends SubString {
		@Override
		protected String doEvaluate(String text, Integer startIndex, Integer length) {
			String subString = null;
			return assignOutput(subString, text, startIndex, length);
		}
		
		protected String assignOutput(String subString, String text, Integer startIndex, Integer length) {
			return subString;
		}
	}
}
