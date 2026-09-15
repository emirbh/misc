package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;


@ImplementedBy(GetMtrtyDtOfUndrlyg.GetMtrtyDtOfUndrlygDefault.class)
public abstract class GetMtrtyDtOfUndrlyg implements RosettaFunction {

	/**
	* @param drrReport 
	* @return mtrtyDtOfUndrlyg 
	*/
	public Date evaluate(JFSATransactionReport drrReport) {
		Date mtrtyDtOfUndrlyg = doEvaluate(drrReport);
		
		return mtrtyDtOfUndrlyg;
	}

	protected abstract Date doEvaluate(JFSATransactionReport drrReport);

	public static class GetMtrtyDtOfUndrlygDefault extends GetMtrtyDtOfUndrlyg {
		@Override
		protected Date doEvaluate(JFSATransactionReport drrReport) {
			Date mtrtyDtOfUndrlyg = null;
			return assignOutput(mtrtyDtOfUndrlyg, drrReport);
		}
		
		protected Date assignOutput(Date mtrtyDtOfUndrlyg, JFSATransactionReport drrReport) {
			mtrtyDtOfUndrlyg = MapperS.of(drrReport).<Date>map("getMaturityDateOfTheUnderlying", jFSATransactionReport -> jFSATransactionReport.getMaturityDateOfTheUnderlying()).get();
			
			return mtrtyDtOfUndrlyg;
		}
	}
}
