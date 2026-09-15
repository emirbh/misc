package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.DeliveryTypeEnum;
import iso20022.auth030.fca.PhysicalTransferType4Code;


@ImplementedBy(GetDlvryTp.GetDlvryTpDefault.class)
public abstract class GetDlvryTp implements RosettaFunction {

	/**
	* @param drrReport 
	* @return dlvryTp 
	*/
	public PhysicalTransferType4Code evaluate(FCAUKEMIRTransactionReport drrReport) {
		PhysicalTransferType4Code dlvryTp = doEvaluate(drrReport);
		
		return dlvryTp;
	}

	protected abstract PhysicalTransferType4Code doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetDlvryTpDefault extends GetDlvryTp {
		@Override
		protected PhysicalTransferType4Code doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			PhysicalTransferType4Code dlvryTp = null;
			return assignOutput(dlvryTp, drrReport);
		}
		
		protected PhysicalTransferType4Code assignOutput(PhysicalTransferType4Code dlvryTp, FCAUKEMIRTransactionReport drrReport) {
			dlvryTp = MapperS.of(drrReport).<DeliveryTypeEnum>map("getDeliveryType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getDeliveryType()).checkedMap("to-enum", e -> PhysicalTransferType4Code.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return dlvryTp;
		}
	}
}
