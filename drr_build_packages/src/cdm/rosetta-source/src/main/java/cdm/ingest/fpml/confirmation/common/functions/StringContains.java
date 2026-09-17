package cdm.ingest.fpml.confirmation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;


@ImplementedBy(StringContains.StringContainsDefault.class)
public abstract class StringContains implements RosettaFunction {

	/**
	* @param input 
	* @param str 
	* @return result 
	*/
	public Boolean evaluate(String input, String str) {
		Boolean result = doEvaluate(input, str);
		
		return result;
	}

	protected abstract Boolean doEvaluate(String input, String str);

	public static class StringContainsDefault extends StringContains {
		@Override
		protected Boolean doEvaluate(String input, String str) {
			Boolean result = null;
			return assignOutput(result, input, str);
		}
		
		protected Boolean assignOutput(Boolean result, String input, String str) {
			return result;
		}
	}
}
