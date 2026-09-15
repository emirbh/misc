package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;


@ImplementedBy(GetPltfmIdr.GetPltfmIdrDefault.class)
public abstract class GetPltfmIdr implements RosettaFunction {

	/**
	* @param drrReport 
	* @return pltfmIdr 
	*/
	public String evaluate(HKMATransactionReport drrReport) {
		String pltfmIdr = doEvaluate(drrReport);
		
		return pltfmIdr;
	}

	protected abstract String doEvaluate(HKMATransactionReport drrReport);

	public static class GetPltfmIdrDefault extends GetPltfmIdr {
		@Override
		protected String doEvaluate(HKMATransactionReport drrReport) {
			String pltfmIdr = null;
			return assignOutput(pltfmIdr, drrReport);
		}
		
		protected String assignOutput(String pltfmIdr, HKMATransactionReport drrReport) {
			pltfmIdr = MapperS.of(drrReport).<String>map("getPlatformIdentifier", hKMATransactionReport -> hKMATransactionReport.getPlatformIdentifier()).get();
			
			return pltfmIdr;
		}
	}
}
