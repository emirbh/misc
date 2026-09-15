package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;


@ImplementedBy(GetTxId.GetTxIdDefault.class)
public abstract class GetTxId implements RosettaFunction {

	/**
	* @param drrReport 
	* @return uti 
	*/
	public String evaluate(HKMATransactionReport drrReport) {
		String uti = doEvaluate(drrReport);
		
		return uti;
	}

	protected abstract String doEvaluate(HKMATransactionReport drrReport);

	public static class GetTxIdDefault extends GetTxId {
		@Override
		protected String doEvaluate(HKMATransactionReport drrReport) {
			String uti = null;
			return assignOutput(uti, drrReport);
		}
		
		protected String assignOutput(String uti, HKMATransactionReport drrReport) {
			uti = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", hKMATransactionReport -> hKMATransactionReport.getUniqueTransactionIdentifier()).get();
			
			return uti;
		}
	}
}
