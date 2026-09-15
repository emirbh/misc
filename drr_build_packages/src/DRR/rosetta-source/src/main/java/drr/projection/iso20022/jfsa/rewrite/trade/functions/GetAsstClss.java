package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ProductType4Code__1;


@ImplementedBy(GetAsstClss.GetAsstClssDefault.class)
public abstract class GetAsstClss implements RosettaFunction {

	/**
	* @param drrReport 
	* @return asstClss 
	*/
	public ProductType4Code__1 evaluate(JFSATransactionReport drrReport) {
		ProductType4Code__1 asstClss = doEvaluate(drrReport);
		
		return asstClss;
	}

	protected abstract ProductType4Code__1 doEvaluate(JFSATransactionReport drrReport);

	public static class GetAsstClssDefault extends GetAsstClss {
		@Override
		protected ProductType4Code__1 doEvaluate(JFSATransactionReport drrReport) {
			ProductType4Code__1 asstClss = null;
			return assignOutput(asstClss, drrReport);
		}
		
		protected ProductType4Code__1 assignOutput(ProductType4Code__1 asstClss, JFSATransactionReport drrReport) {
			asstClss = MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", jFSATransactionReport -> jFSATransactionReport.getAssetClass()).checkedMap("to-enum", e -> ProductType4Code__1.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return asstClss;
		}
	}
}
