package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.DeliveryTypeEnum;
import iso20022.auth030.esma.PhysicalTransferType4Code;


@ImplementedBy(GetDlvryTp.GetDlvryTpDefault.class)
public abstract class GetDlvryTp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return dlvryTp 
	*/
	public PhysicalTransferType4Code evaluate(ESMAEMIRTransactionReport drrReport) {
		PhysicalTransferType4Code dlvryTp = doEvaluate(drrReport);
		
		return dlvryTp;
	}

	protected abstract PhysicalTransferType4Code doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetDlvryTpDefault extends GetDlvryTp {
		@Override
		protected PhysicalTransferType4Code doEvaluate(ESMAEMIRTransactionReport drrReport) {
			PhysicalTransferType4Code dlvryTp = null;
			return assignOutput(dlvryTp, drrReport);
		}
		
		protected PhysicalTransferType4Code assignOutput(PhysicalTransferType4Code dlvryTp, ESMAEMIRTransactionReport drrReport) {
			dlvryTp = MapperS.of(drrReport).<DeliveryTypeEnum>map("getDeliveryType", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getDeliveryType()).checkedMap("to-enum", e -> PhysicalTransferType4Code.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return dlvryTp;
		}
	}
}
