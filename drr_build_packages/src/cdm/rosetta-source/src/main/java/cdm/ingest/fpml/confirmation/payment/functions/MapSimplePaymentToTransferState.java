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
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelativeDateOffset;
import fpml.consolidated.shared.SimplePayment;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSimplePaymentToTransferState.MapSimplePaymentToTransferStateDefault.class)
public abstract class MapSimplePaymentToTransferState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapPaymentToPartyReferencePayerReceiver mapPaymentToPartyReferencePayerReceiver;
	@Inject protected MapTransferCashAsset mapTransferCashAsset;
	@Inject protected MapTransferQuantity mapTransferQuantity;

	/**
	* @param fpmlSimplePayment 
	* @param cdmFeeType 
	* @return transferState 
	*/
	public TransferState evaluate(SimplePayment fpmlSimplePayment, FeeTypeEnum cdmFeeType) {
		TransferState.TransferStateBuilder transferStateBuilder = doEvaluate(fpmlSimplePayment, cdmFeeType);
		
		final TransferState transferState;
		if (transferStateBuilder == null) {
			transferState = null;
		} else {
			transferState = transferStateBuilder.build();
			objectValidator.validate(TransferState.class, transferState);
		}
		
		return transferState;
	}

	protected abstract TransferState.TransferStateBuilder doEvaluate(SimplePayment fpmlSimplePayment, FeeTypeEnum cdmFeeType);

	public static class MapSimplePaymentToTransferStateDefault extends MapSimplePaymentToTransferState {
		@Override
		protected TransferState.TransferStateBuilder doEvaluate(SimplePayment fpmlSimplePayment, FeeTypeEnum cdmFeeType) {
			TransferState.TransferStateBuilder transferState = TransferState.builder();
			return assignOutput(transferState, fpmlSimplePayment, cdmFeeType);
		}
		
		protected TransferState.TransferStateBuilder assignOutput(TransferState.TransferStateBuilder transferState, SimplePayment fpmlSimplePayment, FeeTypeEnum cdmFeeType) {
			if (exists(MapperS.of(fpmlSimplePayment)).getOrDefault(false)) {
				final TransferState.TransferStateBuilder withMetaArgument = TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlSimplePayment).<NonNegativeMoney>map("getPaymentAmount", simplePayment -> simplePayment.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlSimplePayment).<NonNegativeMoney>map("getPaymentAmount", simplePayment -> simplePayment.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlSimplePayment).<PartyReference>map("getPayerPartyReference", simplePayment -> simplePayment.getPayerPartyReference()).get(), MapperS.of(fpmlSimplePayment).<PartyReference>map("getReceiverPartyReference", simplePayment -> simplePayment.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(MapperS.of(fpmlSimplePayment).<AdjustableOrRelativeDate>map("getPaymentDate", simplePayment -> simplePayment.getPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<IdentifiedDate>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperS.of(fpmlSimplePayment).<AdjustableOrRelativeDate>map("getPaymentDate", simplePayment -> simplePayment.getPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), MapperS.of(fpmlSimplePayment).<AdjustableOrRelativeDate>map("getPaymentDate", simplePayment -> simplePayment.getPaymentDate()).<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build() == null ? null : TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlSimplePayment).<NonNegativeMoney>map("getPaymentAmount", simplePayment -> simplePayment.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlSimplePayment).<NonNegativeMoney>map("getPaymentAmount", simplePayment -> simplePayment.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlSimplePayment).<PartyReference>map("getPayerPartyReference", simplePayment -> simplePayment.getPayerPartyReference()).get(), MapperS.of(fpmlSimplePayment).<PartyReference>map("getReceiverPartyReference", simplePayment -> simplePayment.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(MapperS.of(fpmlSimplePayment).<AdjustableOrRelativeDate>map("getPaymentDate", simplePayment -> simplePayment.getPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<IdentifiedDate>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperS.of(fpmlSimplePayment).<AdjustableOrRelativeDate>map("getPaymentDate", simplePayment -> simplePayment.getPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), MapperS.of(fpmlSimplePayment).<AdjustableOrRelativeDate>map("getPaymentDate", simplePayment -> simplePayment.getPaymentDate()).<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build().toBuilder();
				withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlSimplePayment).<String>map("getId", simplePayment -> simplePayment.getId()).get());
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
