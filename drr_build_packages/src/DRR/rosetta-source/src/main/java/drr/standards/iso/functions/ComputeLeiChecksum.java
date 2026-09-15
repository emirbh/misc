package drr.standards.iso.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;


@ImplementedBy(ComputeLeiChecksum.ComputeLeiChecksumDefault.class)
public abstract class ComputeLeiChecksum implements RosettaFunction {

	/**
	* @param lei18 
	* @return checksum2 
	*/
	public String evaluate(String lei18) {
		String checksum2 = doEvaluate(lei18);
		
		return checksum2;
	}

	protected abstract String doEvaluate(String lei18);

	public static class ComputeLeiChecksumDefault extends ComputeLeiChecksum {
		@Override
		protected String doEvaluate(String lei18) {
			String checksum2 = null;
			return assignOutput(checksum2, lei18);
		}
		
		protected String assignOutput(String checksum2, String lei18) {
			return checksum2;
		}
	}
}
