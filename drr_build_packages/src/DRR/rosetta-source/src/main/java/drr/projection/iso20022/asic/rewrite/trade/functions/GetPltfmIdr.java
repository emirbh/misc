package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;


@ImplementedBy(GetPltfmIdr.GetPltfmIdrDefault.class)
public abstract class GetPltfmIdr implements RosettaFunction {

	/**
	* @param drrReport 
	* @return pltfmIdr 
	*/
	public String evaluate(ASICTransactionReport drrReport) {
		String pltfmIdr = doEvaluate(drrReport);
		
		return pltfmIdr;
	}

	protected abstract String doEvaluate(ASICTransactionReport drrReport);

	public static class GetPltfmIdrDefault extends GetPltfmIdr {
		@Override
		protected String doEvaluate(ASICTransactionReport drrReport) {
			String pltfmIdr = null;
			return assignOutput(pltfmIdr, drrReport);
		}
		
		protected String assignOutput(String pltfmIdr, ASICTransactionReport drrReport) {
			pltfmIdr = MapperS.of(drrReport).<String>map("getPlatformIdentifier", aSICTransactionReport -> aSICTransactionReport.getPlatformIdentifier()).get();
			
			return pltfmIdr;
		}
	}
}
