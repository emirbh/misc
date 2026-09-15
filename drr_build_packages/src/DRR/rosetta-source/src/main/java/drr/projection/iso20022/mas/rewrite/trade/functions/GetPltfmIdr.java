package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;


@ImplementedBy(GetPltfmIdr.GetPltfmIdrDefault.class)
public abstract class GetPltfmIdr implements RosettaFunction {

	/**
	* @param drrReport 
	* @return pltfmIdr 
	*/
	public String evaluate(MASTransactionReport drrReport) {
		String pltfmIdr = doEvaluate(drrReport);
		
		return pltfmIdr;
	}

	protected abstract String doEvaluate(MASTransactionReport drrReport);

	public static class GetPltfmIdrDefault extends GetPltfmIdr {
		@Override
		protected String doEvaluate(MASTransactionReport drrReport) {
			String pltfmIdr = null;
			return assignOutput(pltfmIdr, drrReport);
		}
		
		protected String assignOutput(String pltfmIdr, MASTransactionReport drrReport) {
			pltfmIdr = MapperS.of(drrReport).<String>map("getPlatformIdentifier", mASTransactionReport -> mASTransactionReport.getPlatformIdentifier()).get();
			
			return pltfmIdr;
		}
	}
}
