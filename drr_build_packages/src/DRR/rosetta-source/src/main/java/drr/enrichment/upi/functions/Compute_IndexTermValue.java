package drr.enrichment.upi.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;


@ImplementedBy(Compute_IndexTermValue.Compute_IndexTermValueDefault.class)
public abstract class Compute_IndexTermValue implements RosettaFunction {

	/**
	* @param terminationDate 
	* @param effectiveDate 
	* @return result 
	*/
	public Integer evaluate(Date terminationDate, Date effectiveDate) {
		Integer result = doEvaluate(terminationDate, effectiveDate);
		
		return result;
	}

	protected abstract Integer doEvaluate(Date terminationDate, Date effectiveDate);

	public static class Compute_IndexTermValueDefault extends Compute_IndexTermValue {
		@Override
		protected Integer doEvaluate(Date terminationDate, Date effectiveDate) {
			Integer result = null;
			return assignOutput(result, terminationDate, effectiveDate);
		}
		
		protected Integer assignOutput(Integer result, Date terminationDate, Date effectiveDate) {
			return result;
		}
	}
}
