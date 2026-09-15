package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;


@ImplementedBy(GetPltfmIdr.GetPltfmIdrDefault.class)
public abstract class GetPltfmIdr implements RosettaFunction {

	/**
	* @param drrReport 
	* @return pltfmIdr 
	*/
	public String evaluate(ESMAEMIRTransactionReport drrReport) {
		String pltfmIdr = doEvaluate(drrReport);
		
		return pltfmIdr;
	}

	protected abstract String doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetPltfmIdrDefault extends GetPltfmIdr {
		@Override
		protected String doEvaluate(ESMAEMIRTransactionReport drrReport) {
			String pltfmIdr = null;
			return assignOutput(pltfmIdr, drrReport);
		}
		
		protected String assignOutput(String pltfmIdr, ESMAEMIRTransactionReport drrReport) {
			pltfmIdr = MapperS.of(drrReport).<String>map("getVenueOfExecution", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getVenueOfExecution()).get();
			
			return pltfmIdr;
		}
	}
}
