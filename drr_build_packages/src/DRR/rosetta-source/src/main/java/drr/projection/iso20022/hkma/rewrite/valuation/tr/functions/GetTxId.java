package drr.projection.iso20022.hkma.rewrite.valuation.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;


@ImplementedBy(GetTxId.GetTxIdDefault.class)
public abstract class GetTxId implements RosettaFunction {

	/**
	* @param drrReport 
	* @return uti 
	*/
	public String evaluate(HKMAValuationReport drrReport) {
		String uti = doEvaluate(drrReport);
		
		return uti;
	}

	protected abstract String doEvaluate(HKMAValuationReport drrReport);

	public static class GetTxIdDefault extends GetTxId {
		@Override
		protected String doEvaluate(HKMAValuationReport drrReport) {
			String uti = null;
			return assignOutput(uti, drrReport);
		}
		
		protected String assignOutput(String uti, HKMAValuationReport drrReport) {
			uti = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", hKMAValuationReport -> hKMAValuationReport.getUniqueTransactionIdentifier()).get();
			
			return uti;
		}
	}
}
