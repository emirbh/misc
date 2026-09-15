package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;


@ImplementedBy(GetDerivBasedOnCrptAsst.GetDerivBasedOnCrptAsstDefault.class)
public abstract class GetDerivBasedOnCrptAsst implements RosettaFunction {

	/**
	* @param drrReport 
	* @return derivBasedOnCrptAsst 
	*/
	public Boolean evaluate(JFSATransactionReport drrReport) {
		Boolean derivBasedOnCrptAsst = doEvaluate(drrReport);
		
		return derivBasedOnCrptAsst;
	}

	protected abstract Boolean doEvaluate(JFSATransactionReport drrReport);

	public static class GetDerivBasedOnCrptAsstDefault extends GetDerivBasedOnCrptAsst {
		@Override
		protected Boolean doEvaluate(JFSATransactionReport drrReport) {
			Boolean derivBasedOnCrptAsst = null;
			return assignOutput(derivBasedOnCrptAsst, drrReport);
		}
		
		protected Boolean assignOutput(Boolean derivBasedOnCrptAsst, JFSATransactionReport drrReport) {
			derivBasedOnCrptAsst = MapperS.of(drrReport).<Boolean>map("getCryptoAssetUnderlyingIndicator", jFSATransactionReport -> jFSATransactionReport.getCryptoAssetUnderlyingIndicator()).get();
			
			return derivBasedOnCrptAsst;
		}
	}
}
