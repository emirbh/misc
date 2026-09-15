package drr.standards.iosco.cde.version1.payment.functions;

import cdm.event.common.ScheduledTransfer;
import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferState;
import cdm.observable.asset.FeeTypeEnum;
import cdm.product.common.settlement.ScheduledTransferEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsOtherPayment.IsOtherPaymentDefault.class)
public abstract class IsOtherPayment implements RosettaFunction {

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
			result = areEqual(transferExpression(transferState).<FeeTypeEnum>map("getPriceTransfer", _transferExpression -> _transferExpression.getPriceTransfer()), MapperS.of(FeeTypeEnum.UPFRONT), CardinalityOperator.All).orNullSafe(areEqual(transferExpression(transferState).<FeeTypeEnum>map("getPriceTransfer", _transferExpression -> _transferExpression.getPriceTransfer()), MapperS.of(FeeTypeEnum.TERMINATION), CardinalityOperator.All)).orNullSafe(areEqual(transferExpression(transferState).<FeeTypeEnum>map("getPriceTransfer", _transferExpression -> _transferExpression.getPriceTransfer()), MapperS.of(FeeTypeEnum.PARTIAL_TERMINATION), CardinalityOperator.All)).orNullSafe(areEqual(transferExpression(transferState).<ScheduledTransfer>map("getScheduledTransfer", _transferExpression -> _transferExpression.getScheduledTransfer()).<ScheduledTransferEnum>map("getTransferType", scheduledTransfer -> scheduledTransfer.getTransferType()), MapperS.of(ScheduledTransferEnum.PRINCIPAL_PAYMENT), CardinalityOperator.All)).get();
			
			return result;
		}
		
		@Override
		protected MapperS<? extends TransferExpression> transferExpression(TransferState transferState) {
			return MapperS.of(transferState).<Transfer>map("getTransfer", _transferState -> _transferState.getTransfer()).<TransferExpression>map("getTransferExpression", transfer -> transfer.getTransferExpression());
		}
	}
}
