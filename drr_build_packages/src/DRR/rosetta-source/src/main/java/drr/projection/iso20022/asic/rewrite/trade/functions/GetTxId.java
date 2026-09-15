package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;


@ImplementedBy(GetTxId.GetTxIdDefault.class)
public abstract class GetTxId implements RosettaFunction {

	/**
	* @param drrReport 
	* @return uti 
	*/
	public String evaluate(ASICTransactionReport drrReport) {
		String uti = doEvaluate(drrReport);
		
		return uti;
	}

	protected abstract String doEvaluate(ASICTransactionReport drrReport);

	public static class GetTxIdDefault extends GetTxId {
		@Override
		protected String doEvaluate(ASICTransactionReport drrReport) {
			String uti = null;
			return assignOutput(uti, drrReport);
		}
		
		protected String assignOutput(String uti, ASICTransactionReport drrReport) {
			uti = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", aSICTransactionReport -> aSICTransactionReport.getUniqueTransactionIdentifier()).get();
			
			return uti;
		}
	}
}
