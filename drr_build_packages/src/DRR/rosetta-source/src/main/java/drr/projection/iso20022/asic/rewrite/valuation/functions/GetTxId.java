package drr.projection.iso20022.asic.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;


@ImplementedBy(GetTxId.GetTxIdDefault.class)
public abstract class GetTxId implements RosettaFunction {

	/**
	* @param drrReport 
	* @return uti 
	*/
	public String evaluate(ASICValuationReport drrReport) {
		String uti = doEvaluate(drrReport);
		
		return uti;
	}

	protected abstract String doEvaluate(ASICValuationReport drrReport);

	public static class GetTxIdDefault extends GetTxId {
		@Override
		protected String doEvaluate(ASICValuationReport drrReport) {
			String uti = null;
			return assignOutput(uti, drrReport);
		}
		
		protected String assignOutput(String uti, ASICValuationReport drrReport) {
			uti = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", aSICValuationReport -> aSICValuationReport.getUniqueTransactionIdentifier()).get();
			
			return uti;
		}
	}
}
