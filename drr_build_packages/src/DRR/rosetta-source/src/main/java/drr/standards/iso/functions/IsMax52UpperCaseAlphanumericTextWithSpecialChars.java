package drr.standards.iso.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.util.string.functions.StringContains;
import javax.inject.Inject;


@ImplementedBy(IsMax52UpperCaseAlphanumericTextWithSpecialChars.IsMax52UpperCaseAlphanumericTextWithSpecialCharsDefault.class)
public abstract class IsMax52UpperCaseAlphanumericTextWithSpecialChars implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected StringContains stringContains;

	/**
	* @param text 
	* @return result 
	*/
	public Boolean evaluate(String text) {
		Boolean result = doEvaluate(text);
		
		return result;
	}

	protected abstract Boolean doEvaluate(String text);

	public static class IsMax52UpperCaseAlphanumericTextWithSpecialCharsDefault extends IsMax52UpperCaseAlphanumericTextWithSpecialChars {
		@Override
		protected Boolean doEvaluate(String text) {
			Boolean result = null;
			return assignOutput(result, text);
		}
		
		protected Boolean assignOutput(Boolean result, String text) {
			result = stringContains.evaluate(text, "^[A-Z0-9]{18}[0-9]{2}(?:[A-Z0-9\\:.\\-_]{0,31}[A-Z0-9])?$");
			
			return result;
		}
	}
}
