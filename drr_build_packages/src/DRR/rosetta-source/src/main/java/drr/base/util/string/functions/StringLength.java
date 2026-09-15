package drr.base.util.string.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;


@ImplementedBy(StringLength.StringLengthDefault.class)
public abstract class StringLength implements RosettaFunction {

	/**
	* @param str 
	* @return result 
	*/
	public Integer evaluate(String str) {
		Integer result = doEvaluate(str);
		
		return result;
	}

	protected abstract Integer doEvaluate(String str);

	public static class StringLengthDefault extends StringLength {
		@Override
		protected Integer doEvaluate(String str) {
			Integer result = null;
			return assignOutput(result, str);
		}
		
		protected Integer assignOutput(Integer result, String str) {
			return result;
		}
	}
}
