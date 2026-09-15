package drr.standards.iso.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.util.string.functions.SubString;
import javax.inject.Inject;


@ImplementedBy(IsValidLeiFromGlobalUti.IsValidLeiFromGlobalUtiDefault.class)
public abstract class IsValidLeiFromGlobalUti implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsValidLei isValidLei;
	@Inject protected SubString subString;

	/**
	* @param uti 
	* @return valid 
	*/
	public Boolean evaluate(String uti) {
		Boolean valid = doEvaluate(uti);
		
		return valid;
	}

	protected abstract Boolean doEvaluate(String uti);

	public static class IsValidLeiFromGlobalUtiDefault extends IsValidLeiFromGlobalUti {
		@Override
		protected Boolean doEvaluate(String uti) {
			Boolean valid = null;
			return assignOutput(valid, uti);
		}
		
		protected Boolean assignOutput(Boolean valid, String uti) {
			valid = isValidLei.evaluate(subString.evaluate(uti, 1, 20));
			
			return valid;
		}
	}
}
