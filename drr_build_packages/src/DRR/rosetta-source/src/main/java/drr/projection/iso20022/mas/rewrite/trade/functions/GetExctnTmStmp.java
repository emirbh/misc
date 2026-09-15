package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import java.time.ZonedDateTime;


@ImplementedBy(GetExctnTmStmp.GetExctnTmStmpDefault.class)
public abstract class GetExctnTmStmp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return exctnTmStmp 
	*/
	public ZonedDateTime evaluate(MASTransactionReport drrReport) {
		ZonedDateTime exctnTmStmp = doEvaluate(drrReport);
		
		return exctnTmStmp;
	}

	protected abstract ZonedDateTime doEvaluate(MASTransactionReport drrReport);

	public static class GetExctnTmStmpDefault extends GetExctnTmStmp {
		@Override
		protected ZonedDateTime doEvaluate(MASTransactionReport drrReport) {
			ZonedDateTime exctnTmStmp = null;
			return assignOutput(exctnTmStmp, drrReport);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime exctnTmStmp, MASTransactionReport drrReport) {
			exctnTmStmp = MapperS.of(drrReport).<ZonedDateTime>map("getExecutionTimestamp", mASTransactionReport -> mASTransactionReport.getExecutionTimestamp()).get();
			
			return exctnTmStmp;
		}
	}
}
