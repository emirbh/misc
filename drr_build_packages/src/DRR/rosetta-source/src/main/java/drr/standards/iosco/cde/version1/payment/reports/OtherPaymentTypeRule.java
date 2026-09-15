package drr.standards.iosco.cde.version1.payment.reports;

import cdm.event.common.ScheduledTransfer;
import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferState;
import cdm.observable.asset.FeeTypeEnum;
import cdm.product.common.settlement.ScheduledTransferEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.PaymentType4Code;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OtherPaymentTypeRule.OtherPaymentTypeRuleDefault.class)
public abstract class OtherPaymentTypeRule implements ReportFunction<TransferState, PaymentType4Code> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PaymentType4Code evaluate(TransferState input) {
		PaymentType4Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract PaymentType4Code doEvaluate(TransferState input);

	public static class OtherPaymentTypeRuleDefault extends OtherPaymentTypeRule {
		@Override
		protected PaymentType4Code doEvaluate(TransferState input) {
			PaymentType4Code output = null;
			return assignOutput(output, input);
		}
		
		protected PaymentType4Code assignOutput(PaymentType4Code output, TransferState input) {
			final MapperS<TransferExpression> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<TransferExpression>map("getTransferExpression", transfer -> transfer.getTransferExpression()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(item.<FeeTypeEnum>map("getPriceTransfer", transferExpression -> transferExpression.getPriceTransfer()), MapperS.of(FeeTypeEnum.UPFRONT), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(PaymentType4Code.UFRO);
					}
					if (areEqual(item.<FeeTypeEnum>map("getPriceTransfer", transferExpression -> transferExpression.getPriceTransfer()), MapperS.of(FeeTypeEnum.TERMINATION), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(PaymentType4Code.UWIN);
					}
					if (areEqual(item.<ScheduledTransfer>map("getScheduledTransfer", transferExpression -> transferExpression.getScheduledTransfer()).<ScheduledTransferEnum>map("getTransferType", scheduledTransfer -> scheduledTransfer.getTransferType()), MapperS.of(ScheduledTransferEnum.PRINCIPAL_PAYMENT), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(PaymentType4Code.PEXH);
					}
					return MapperS.<PaymentType4Code>ofNull();
				}).get();
			
			return output;
		}
	}
}
