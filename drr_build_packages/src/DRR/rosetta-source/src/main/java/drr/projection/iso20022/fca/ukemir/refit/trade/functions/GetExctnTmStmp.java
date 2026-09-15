package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import java.time.ZonedDateTime;


@ImplementedBy(GetExctnTmStmp.GetExctnTmStmpDefault.class)
public abstract class GetExctnTmStmp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return exctnTmStmp 
	*/
	public ZonedDateTime evaluate(FCAUKEMIRTransactionReport drrReport) {
		ZonedDateTime exctnTmStmp = doEvaluate(drrReport);
		
		return exctnTmStmp;
	}

	protected abstract ZonedDateTime doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetExctnTmStmpDefault extends GetExctnTmStmp {
		@Override
		protected ZonedDateTime doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			ZonedDateTime exctnTmStmp = null;
			return assignOutput(exctnTmStmp, drrReport);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime exctnTmStmp, FCAUKEMIRTransactionReport drrReport) {
			exctnTmStmp = MapperS.of(drrReport).<ZonedDateTime>map("getExecutionTimestamp", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getExecutionTimestamp()).get();
			
			return exctnTmStmp;
		}
	}
}
