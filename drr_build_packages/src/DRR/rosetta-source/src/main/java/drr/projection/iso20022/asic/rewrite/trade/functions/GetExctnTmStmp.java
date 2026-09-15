package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import java.time.ZonedDateTime;


@ImplementedBy(GetExctnTmStmp.GetExctnTmStmpDefault.class)
public abstract class GetExctnTmStmp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return exctnTmStmp 
	*/
	public ZonedDateTime evaluate(ASICTransactionReport drrReport) {
		ZonedDateTime exctnTmStmp = doEvaluate(drrReport);
		
		return exctnTmStmp;
	}

	protected abstract ZonedDateTime doEvaluate(ASICTransactionReport drrReport);

	public static class GetExctnTmStmpDefault extends GetExctnTmStmp {
		@Override
		protected ZonedDateTime doEvaluate(ASICTransactionReport drrReport) {
			ZonedDateTime exctnTmStmp = null;
			return assignOutput(exctnTmStmp, drrReport);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime exctnTmStmp, ASICTransactionReport drrReport) {
			exctnTmStmp = MapperS.of(drrReport).<ZonedDateTime>map("getExecutionTimestamp", aSICTransactionReport -> aSICTransactionReport.getExecutionTimestamp()).get();
			
			return exctnTmStmp;
		}
	}
}
