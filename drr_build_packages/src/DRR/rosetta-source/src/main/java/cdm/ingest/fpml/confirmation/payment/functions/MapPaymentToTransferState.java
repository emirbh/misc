package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferState;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDate;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.AdjustableOrAdjustedDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPaymentToTransferState.MapPaymentToTransferStateDefault.class)
public abstract class MapPaymentToTransferState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapPaymentToPartyReferencePayerReceiver mapPaymentToPartyReferencePayerReceiver;
	@Inject protected MapTransferCashAsset mapTransferCashAsset;
	@Inject protected MapTransferQuantity mapTransferQuantity;

	/**
	* @param fpmlPayment 
	* @param cdmFeeType 
	* @return transferState 
	*/
	public TransferState evaluate(Payment fpmlPayment, FeeTypeEnum cdmFeeType) {
		TransferState.TransferStateBuilder transferStateBuilder = doEvaluate(fpmlPayment, cdmFeeType);
		
		final TransferState transferState;
		if (transferStateBuilder == null) {
			transferState = null;
		} else {
			transferState = transferStateBuilder.build();
			objectValidator.validate(TransferState.class, transferState);
		}
		
		return transferState;
	}

	protected abstract TransferState.TransferStateBuilder doEvaluate(Payment fpmlPayment, FeeTypeEnum cdmFeeType);

	public static class MapPaymentToTransferStateDefault extends MapPaymentToTransferState {
		@Override
		protected TransferState.TransferStateBuilder doEvaluate(Payment fpmlPayment, FeeTypeEnum cdmFeeType) {
			TransferState.TransferStateBuilder transferState = TransferState.builder();
			return assignOutput(transferState, fpmlPayment, cdmFeeType);
		}
		
		protected TransferState.TransferStateBuilder assignOutput(TransferState.TransferStateBuilder transferState, Payment fpmlPayment, FeeTypeEnum cdmFeeType) {
			if (exists(MapperS.of(fpmlPayment)).getOrDefault(false)) {
				final TransferState.TransferStateBuilder withMetaArgument = TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlPayment).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlPayment).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlPayment).<PartyReference>map("getPayerPartyReference", payment -> payment.getPayerPartyReference()).get(), MapperS.of(fpmlPayment).<PartyReference>map("getReceiverPartyReference", payment -> payment.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDate.evaluate(MapperS.of(fpmlPayment).<AdjustableOrAdjustedDate>map("getPaymentDate", payment -> payment.getPaymentDate()).get()))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build() == null ? null : TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlPayment).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlPayment).<NonNegativeMoney>map("getPaymentAmount", payment -> payment.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlPayment).<PartyReference>map("getPayerPartyReference", payment -> payment.getPayerPartyReference()).get(), MapperS.of(fpmlPayment).<PartyReference>map("getReceiverPartyReference", payment -> payment.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedDateToAdjustableOrAdjustedOrRelativeDate.evaluate(MapperS.of(fpmlPayment).<AdjustableOrAdjustedDate>map("getPaymentDate", payment -> payment.getPaymentDate()).get()))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build().toBuilder();
				withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlPayment).<String>map("getId", payment -> payment.getId()).get());
				transferState = toBuilder(withMetaArgument);
			} else {
				transferState = null;
			}
			
			return Optional.ofNullable(transferState)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
