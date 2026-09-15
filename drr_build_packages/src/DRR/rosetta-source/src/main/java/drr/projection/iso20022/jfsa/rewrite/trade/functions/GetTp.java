package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.OptionTypeCode;
import iso20022.auth030.jfsa.OptionType2Code;


@ImplementedBy(GetTp.GetTpDefault.class)
public abstract class GetTp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return tp 
	*/
	public OptionType2Code evaluate(JFSATransactionReport drrReport) {
		OptionType2Code tp = doEvaluate(drrReport);
		
		return tp;
	}

	protected abstract OptionType2Code doEvaluate(JFSATransactionReport drrReport);

	public static class GetTpDefault extends GetTp {
		@Override
		protected OptionType2Code doEvaluate(JFSATransactionReport drrReport) {
			OptionType2Code tp = null;
			return assignOutput(tp, drrReport);
		}
		
		protected OptionType2Code assignOutput(OptionType2Code tp, JFSATransactionReport drrReport) {
			tp = MapperS.of(drrReport).<OptionTypeCode>map("getOptionType", jFSATransactionReport -> jFSATransactionReport.getOptionType()).checkedMap("to-enum", e -> OptionType2Code.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return tp;
		}
	}
}
