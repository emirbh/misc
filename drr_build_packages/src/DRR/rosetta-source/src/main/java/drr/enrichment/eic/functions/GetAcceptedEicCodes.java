package drr.enrichment.eic.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.util.ArrayList;
import java.util.List;


@ImplementedBy(GetAcceptedEicCodes.GetAcceptedEicCodesDefault.class)
public abstract class GetAcceptedEicCodes implements RosettaFunction {

	/**
	* @return acceptedEicCodes 
	*/
	public List<String> evaluate() {
		List<String> acceptedEicCodes = doEvaluate();
		
		return acceptedEicCodes;
	}

	protected abstract List<String> doEvaluate();

	public static class GetAcceptedEicCodesDefault extends GetAcceptedEicCodes {
		@Override
		protected List<String> doEvaluate() {
			List<String> acceptedEicCodes = new ArrayList<>();
			return assignOutput(acceptedEicCodes);
		}
		
		protected List<String> assignOutput(List<String> acceptedEicCodes) {
			return acceptedEicCodes;
		}
	}
}
