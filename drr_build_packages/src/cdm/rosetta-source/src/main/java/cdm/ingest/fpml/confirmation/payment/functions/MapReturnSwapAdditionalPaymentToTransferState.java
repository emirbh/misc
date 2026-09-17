package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferState;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrAdjustedOrRelativeDate;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.AdditionalPaymentAmount;
import fpml.consolidated.eq.shared.ReturnSwapAdditionalPayment;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReturnSwapAdditionalPaymentToTransferState.MapReturnSwapAdditionalPaymentToTransferStateDefault.class)
public abstract class MapReturnSwapAdditionalPaymentToTransferState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapPaymentToPartyReferencePayerReceiver mapPaymentToPartyReferencePayerReceiver;
	@Inject protected MapTransferCashAsset mapTransferCashAsset;
	@Inject protected MapTransferQuantity mapTransferQuantity;

	/**
	* @param fpmlReturnSwapAdditionalPayment 
	* @param cdmFeeType 
	* @return transferState 
	*/
	public TransferState evaluate(ReturnSwapAdditionalPayment fpmlReturnSwapAdditionalPayment, FeeTypeEnum cdmFeeType) {
		TransferState.TransferStateBuilder transferStateBuilder = doEvaluate(fpmlReturnSwapAdditionalPayment, cdmFeeType);
		
		final TransferState transferState;
		if (transferStateBuilder == null) {
			transferState = null;
		} else {
			transferState = transferStateBuilder.build();
			objectValidator.validate(TransferState.class, transferState);
		}
		
		return transferState;
	}

	protected abstract TransferState.TransferStateBuilder doEvaluate(ReturnSwapAdditionalPayment fpmlReturnSwapAdditionalPayment, FeeTypeEnum cdmFeeType);

	public static class MapReturnSwapAdditionalPaymentToTransferStateDefault extends MapReturnSwapAdditionalPaymentToTransferState {
		@Override
		protected TransferState.TransferStateBuilder doEvaluate(ReturnSwapAdditionalPayment fpmlReturnSwapAdditionalPayment, FeeTypeEnum cdmFeeType) {
			TransferState.TransferStateBuilder transferState = TransferState.builder();
			return assignOutput(transferState, fpmlReturnSwapAdditionalPayment, cdmFeeType);
		}
		
		protected TransferState.TransferStateBuilder assignOutput(TransferState.TransferStateBuilder transferState, ReturnSwapAdditionalPayment fpmlReturnSwapAdditionalPayment, FeeTypeEnum cdmFeeType) {
			if (exists(MapperS.of(fpmlReturnSwapAdditionalPayment)).getOrDefault(false)) {
				final TransferState.TransferStateBuilder withMetaArgument = TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlReturnSwapAdditionalPayment).<AdditionalPaymentAmount>map("getAdditionalPaymentAmount", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getAdditionalPaymentAmount()).<NonNegativeMoney>map("getPaymentAmount", additionalPaymentAmount -> additionalPaymentAmount.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlReturnSwapAdditionalPayment).<AdditionalPaymentAmount>map("getAdditionalPaymentAmount", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getAdditionalPaymentAmount()).<NonNegativeMoney>map("getPaymentAmount", additionalPaymentAmount -> additionalPaymentAmount.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlReturnSwapAdditionalPayment).<PartyReference>map("getPayerPartyReference", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getPayerPartyReference()).get(), MapperS.of(fpmlReturnSwapAdditionalPayment).<PartyReference>map("getReceiverPartyReference", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(null, MapperS.of(fpmlReturnSwapAdditionalPayment).<AdjustableOrRelativeDate>map("getAdditionalPaymentDate", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getAdditionalPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), MapperS.of(fpmlReturnSwapAdditionalPayment).<AdjustableOrRelativeDate>map("getAdditionalPaymentDate", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getAdditionalPaymentDate()).<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build() == null ? null : TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlReturnSwapAdditionalPayment).<AdditionalPaymentAmount>map("getAdditionalPaymentAmount", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getAdditionalPaymentAmount()).<NonNegativeMoney>map("getPaymentAmount", additionalPaymentAmount -> additionalPaymentAmount.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlReturnSwapAdditionalPayment).<AdditionalPaymentAmount>map("getAdditionalPaymentAmount", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getAdditionalPaymentAmount()).<NonNegativeMoney>map("getPaymentAmount", additionalPaymentAmount -> additionalPaymentAmount.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlReturnSwapAdditionalPayment).<PartyReference>map("getPayerPartyReference", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getPayerPartyReference()).get(), MapperS.of(fpmlReturnSwapAdditionalPayment).<PartyReference>map("getReceiverPartyReference", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(null, MapperS.of(fpmlReturnSwapAdditionalPayment).<AdjustableOrRelativeDate>map("getAdditionalPaymentDate", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getAdditionalPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), MapperS.of(fpmlReturnSwapAdditionalPayment).<AdjustableOrRelativeDate>map("getAdditionalPaymentDate", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getAdditionalPaymentDate()).<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build().toBuilder();
				withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlReturnSwapAdditionalPayment).<String>map("getId", returnSwapAdditionalPayment -> returnSwapAdditionalPayment.getId()).get());
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
