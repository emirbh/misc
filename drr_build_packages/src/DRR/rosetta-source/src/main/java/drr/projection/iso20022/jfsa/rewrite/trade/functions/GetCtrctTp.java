package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonContractType;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.FinancialInstrumentContractType2Code;


@ImplementedBy(GetCtrctTp.GetCtrctTpDefault.class)
public abstract class GetCtrctTp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return ctrctTp 
	*/
	public FinancialInstrumentContractType2Code evaluate(JFSATransactionReport drrReport) {
		FinancialInstrumentContractType2Code ctrctTp = doEvaluate(drrReport);
		
		return ctrctTp;
	}

	protected abstract FinancialInstrumentContractType2Code doEvaluate(JFSATransactionReport drrReport);

	public static class GetCtrctTpDefault extends GetCtrctTp {
		@Override
		protected FinancialInstrumentContractType2Code doEvaluate(JFSATransactionReport drrReport) {
			FinancialInstrumentContractType2Code ctrctTp = null;
			return assignOutput(ctrctTp, drrReport);
		}
		
		protected FinancialInstrumentContractType2Code assignOutput(FinancialInstrumentContractType2Code ctrctTp, JFSATransactionReport drrReport) {
			ctrctTp = MapperS.of(drrReport).<CommonContractType>map("getContractType", jFSATransactionReport -> jFSATransactionReport.getContractType()).checkedMap("to-enum", e -> FinancialInstrumentContractType2Code.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return ctrctTp;
		}
	}
}
