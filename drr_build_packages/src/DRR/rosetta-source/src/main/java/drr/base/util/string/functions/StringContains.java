package drr.base.util.string.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;


@ImplementedBy(StringContains.StringContainsDefault.class)
public abstract class StringContains implements RosettaFunction {

	/**
	* @param input 
	* @param regex 
	* @return result 
	*/
	public Boolean evaluate(String input, String regex) {
		Boolean result = doEvaluate(input, regex);
		
		return result;
	}

	protected abstract Boolean doEvaluate(String input, String regex);

	public static class StringContainsDefault extends StringContains {
		@Override
		protected Boolean doEvaluate(String input, String regex) {
			Boolean result = null;
			return assignOutput(result, input, regex);
		}
		
		protected Boolean assignOutput(Boolean result, String input, String regex) {
			return result;
		}
	}
}
