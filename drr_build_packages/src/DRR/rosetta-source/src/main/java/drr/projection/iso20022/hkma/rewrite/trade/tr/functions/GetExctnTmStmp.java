package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import java.time.ZonedDateTime;


@ImplementedBy(GetExctnTmStmp.GetExctnTmStmpDefault.class)
public abstract class GetExctnTmStmp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return exctnTmStmp 
	*/
	public ZonedDateTime evaluate(HKMATransactionReport drrReport) {
		ZonedDateTime exctnTmStmp = doEvaluate(drrReport);
		
		return exctnTmStmp;
	}

	protected abstract ZonedDateTime doEvaluate(HKMATransactionReport drrReport);

	public static class GetExctnTmStmpDefault extends GetExctnTmStmp {
		@Override
		protected ZonedDateTime doEvaluate(HKMATransactionReport drrReport) {
			ZonedDateTime exctnTmStmp = null;
			return assignOutput(exctnTmStmp, drrReport);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime exctnTmStmp, HKMATransactionReport drrReport) {
			exctnTmStmp = MapperS.of(drrReport).<ZonedDateTime>map("getExecutionTimestamp", hKMATransactionReport -> hKMATransactionReport.getExecutionTimestamp()).get();
			
			return exctnTmStmp;
		}
	}
}
