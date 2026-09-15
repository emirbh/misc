package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import java.time.ZonedDateTime;


@ImplementedBy(GetExctnTmStmp.GetExctnTmStmpDefault.class)
public abstract class GetExctnTmStmp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return exctnTmStmp 
	*/
	public ZonedDateTime evaluate(ESMAEMIRTransactionReport drrReport) {
		ZonedDateTime exctnTmStmp = doEvaluate(drrReport);
		
		return exctnTmStmp;
	}

	protected abstract ZonedDateTime doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetExctnTmStmpDefault extends GetExctnTmStmp {
		@Override
		protected ZonedDateTime doEvaluate(ESMAEMIRTransactionReport drrReport) {
			ZonedDateTime exctnTmStmp = null;
			return assignOutput(exctnTmStmp, drrReport);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime exctnTmStmp, ESMAEMIRTransactionReport drrReport) {
			exctnTmStmp = MapperS.of(drrReport).<ZonedDateTime>map("getExecutionTimestamp", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getExecutionTimestamp()).get();
			
			return exctnTmStmp;
		}
	}
}
