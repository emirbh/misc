package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;


@ImplementedBy(GetTxId.GetTxIdDefault.class)
public abstract class GetTxId implements RosettaFunction {

	/**
	* @param drrReport 
	* @return uti 
	*/
	public String evaluate(MASTransactionReport drrReport) {
		String uti = doEvaluate(drrReport);
		
		return uti;
	}

	protected abstract String doEvaluate(MASTransactionReport drrReport);

	public static class GetTxIdDefault extends GetTxId {
		@Override
		protected String doEvaluate(MASTransactionReport drrReport) {
			String uti = null;
			return assignOutput(uti, drrReport);
		}
		
		protected String assignOutput(String uti, MASTransactionReport drrReport) {
			uti = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", mASTransactionReport -> mASTransactionReport.getUniqueTransactionIdentifier()).get();
			
			return uti;
		}
	}
}
