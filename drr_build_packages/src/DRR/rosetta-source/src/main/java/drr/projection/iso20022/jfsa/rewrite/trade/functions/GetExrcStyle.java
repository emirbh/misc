package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.OptionStyleEnum;
import iso20022.auth030.jfsa.OptionStyle6Code;


@ImplementedBy(GetExrcStyle.GetExrcStyleDefault.class)
public abstract class GetExrcStyle implements RosettaFunction {

	/**
	* @param drrReport 
	* @return exrcStyle 
	*/
	public OptionStyle6Code evaluate(JFSATransactionReport drrReport) {
		OptionStyle6Code exrcStyle = doEvaluate(drrReport);
		
		return exrcStyle;
	}

	protected abstract OptionStyle6Code doEvaluate(JFSATransactionReport drrReport);

	public static class GetExrcStyleDefault extends GetExrcStyle {
		@Override
		protected OptionStyle6Code doEvaluate(JFSATransactionReport drrReport) {
			OptionStyle6Code exrcStyle = null;
			return assignOutput(exrcStyle, drrReport);
		}
		
		protected OptionStyle6Code assignOutput(OptionStyle6Code exrcStyle, JFSATransactionReport drrReport) {
			exrcStyle = MapperS.of(drrReport).<OptionStyleEnum>map("getOptionStyle", jFSATransactionReport -> jFSATransactionReport.getOptionStyle()).checkedMap("to-enum", e -> OptionStyle6Code.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return exrcStyle;
		}
	}
}
