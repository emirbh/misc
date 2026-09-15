package drr.base.util.string.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;


@ImplementedBy(ReplaceAll.ReplaceAllDefault.class)
public abstract class ReplaceAll implements RosettaFunction {

	/**
	* @param input 
	* @param regex 
	* @param replacement 
	* @return result 
	*/
	public String evaluate(String input, String regex, String replacement) {
		String result = doEvaluate(input, regex, replacement);
		
		return result;
	}

	protected abstract String doEvaluate(String input, String regex, String replacement);

	public static class ReplaceAllDefault extends ReplaceAll {
		@Override
		protected String doEvaluate(String input, String regex, String replacement) {
			String result = null;
			return assignOutput(result, input, regex, replacement);
		}
		
		protected String assignOutput(String result, String input, String regex, String replacement) {
			return result;
		}
	}
}
