package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;


@ImplementedBy(GetPltfmIdr.GetPltfmIdrDefault.class)
public abstract class GetPltfmIdr implements RosettaFunction {

	/**
	* @param drrReport 
	* @return pltfmIdr 
	*/
	public String evaluate(FCAUKEMIRTransactionReport drrReport) {
		String pltfmIdr = doEvaluate(drrReport);
		
		return pltfmIdr;
	}

	protected abstract String doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetPltfmIdrDefault extends GetPltfmIdr {
		@Override
		protected String doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			String pltfmIdr = null;
			return assignOutput(pltfmIdr, drrReport);
		}
		
		protected String assignOutput(String pltfmIdr, FCAUKEMIRTransactionReport drrReport) {
			pltfmIdr = MapperS.of(drrReport).<String>map("getVenueOfExecution", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getVenueOfExecution()).get();
			
			return pltfmIdr;
		}
	}
}
