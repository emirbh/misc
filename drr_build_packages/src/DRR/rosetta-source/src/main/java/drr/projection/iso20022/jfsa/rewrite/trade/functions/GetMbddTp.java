package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import iso20022.auth030.jfsa.EmbeddedType1Code;


@ImplementedBy(GetMbddTp.GetMbddTpDefault.class)
public abstract class GetMbddTp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return mbddTp 
	*/
	public EmbeddedType1Code evaluate(JFSATransactionReport drrReport) {
		EmbeddedType1Code mbddTp = doEvaluate(drrReport);
		
		return mbddTp;
	}

	protected abstract EmbeddedType1Code doEvaluate(JFSATransactionReport drrReport);

	public static class GetMbddTpDefault extends GetMbddTp {
		@Override
		protected EmbeddedType1Code doEvaluate(JFSATransactionReport drrReport) {
			EmbeddedType1Code mbddTp = null;
			return assignOutput(mbddTp, drrReport);
		}
		
		protected EmbeddedType1Code assignOutput(EmbeddedType1Code mbddTp, JFSATransactionReport drrReport) {
			mbddTp = MapperS.of(drrReport).<EmbeddedOptionTypeEnum>map("getEmbeddedOptionType", jFSATransactionReport -> jFSATransactionReport.getEmbeddedOptionType()).checkedMap("to-enum", e -> EmbeddedType1Code.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return mbddTp;
		}
	}
}
