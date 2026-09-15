package drr.standards.iosco.cde.version3.payment.functions;

import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;


@ImplementedBy(IsOtherPayment.IsOtherPaymentDefault.class)
public abstract class IsOtherPayment implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.payment.functions.IsOtherPayment isOtherPayment;

	/**
	* @param transferState 
	* @return result 
	*/
	public Boolean evaluate(TransferState transferState) {
		Boolean result = doEvaluate(transferState);
		
		return result;
	}

	protected abstract Boolean doEvaluate(TransferState transferState);

	protected abstract MapperS<? extends TransferExpression> transferExpression(TransferState transferState);

	public static class IsOtherPaymentDefault extends IsOtherPayment {
		@Override
		protected Boolean doEvaluate(TransferState transferState) {
			Boolean result = null;
			return assignOutput(result, transferState);
		}
		
		protected Boolean assignOutput(Boolean result, TransferState transferState) {
			result = isOtherPayment.evaluate(transferState);
			
			return result;
		}
		
		@Override
		protected MapperS<? extends TransferExpression> transferExpression(TransferState transferState) {
			return MapperS.of(transferState).<Transfer>map("getTransfer", _transferState -> _transferState.getTransfer()).<TransferExpression>map("getTransferExpression", transfer -> transfer.getTransferExpression());
		}
	}
}
