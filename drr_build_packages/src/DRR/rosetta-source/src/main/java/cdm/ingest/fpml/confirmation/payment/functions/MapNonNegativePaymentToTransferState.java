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
import fpml.consolidated.shared.NonNegativePayment;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelativeDateOffset;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapNonNegativePaymentToTransferState.MapNonNegativePaymentToTransferStateDefault.class)
public abstract class MapNonNegativePaymentToTransferState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapPaymentToPartyReferencePayerReceiver mapPaymentToPartyReferencePayerReceiver;
	@Inject protected MapTransferCashAsset mapTransferCashAsset;
	@Inject protected MapTransferQuantity mapTransferQuantity;

	/**
	* @param fpmlNonNegativePayment 
	* @param cdmFeeType 
	* @return transferState 
	*/
	public TransferState evaluate(NonNegativePayment fpmlNonNegativePayment, FeeTypeEnum cdmFeeType) {
		TransferState.TransferStateBuilder transferStateBuilder = doEvaluate(fpmlNonNegativePayment, cdmFeeType);
		
		final TransferState transferState;
		if (transferStateBuilder == null) {
			transferState = null;
		} else {
			transferState = transferStateBuilder.build();
			objectValidator.validate(TransferState.class, transferState);
		}
		
		return transferState;
	}

	protected abstract TransferState.TransferStateBuilder doEvaluate(NonNegativePayment fpmlNonNegativePayment, FeeTypeEnum cdmFeeType);

	public static class MapNonNegativePaymentToTransferStateDefault extends MapNonNegativePaymentToTransferState {
		@Override
		protected TransferState.TransferStateBuilder doEvaluate(NonNegativePayment fpmlNonNegativePayment, FeeTypeEnum cdmFeeType) {
			TransferState.TransferStateBuilder transferState = TransferState.builder();
			return assignOutput(transferState, fpmlNonNegativePayment, cdmFeeType);
		}
		
		protected TransferState.TransferStateBuilder assignOutput(TransferState.TransferStateBuilder transferState, NonNegativePayment fpmlNonNegativePayment, FeeTypeEnum cdmFeeType) {
			if (exists(MapperS.of(fpmlNonNegativePayment)).getOrDefault(false)) {
				final TransferState.TransferStateBuilder withMetaArgument = TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlNonNegativePayment).<NonNegativeMoney>map("getPaymentAmount", nonNegativePayment -> nonNegativePayment.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlNonNegativePayment).<NonNegativeMoney>map("getPaymentAmount", nonNegativePayment -> nonNegativePayment.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlNonNegativePayment).<PartyReference>map("getPayerPartyReference", nonNegativePayment -> nonNegativePayment.getPayerPartyReference()).get(), MapperS.of(fpmlNonNegativePayment).<PartyReference>map("getReceiverPartyReference", nonNegativePayment -> nonNegativePayment.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(MapperS.of(fpmlNonNegativePayment).<AdjustableOrRelativeDate>map("getPaymentDate", nonNegativePayment -> nonNegativePayment.getPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<IdentifiedDate>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperS.of(fpmlNonNegativePayment).<AdjustableOrRelativeDate>map("getPaymentDate", nonNegativePayment -> nonNegativePayment.getPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), MapperS.of(fpmlNonNegativePayment).<AdjustableOrRelativeDate>map("getPaymentDate", nonNegativePayment -> nonNegativePayment.getPaymentDate()).<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build() == null ? null : TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlNonNegativePayment).<NonNegativeMoney>map("getPaymentAmount", nonNegativePayment -> nonNegativePayment.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlNonNegativePayment).<NonNegativeMoney>map("getPaymentAmount", nonNegativePayment -> nonNegativePayment.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlNonNegativePayment).<PartyReference>map("getPayerPartyReference", nonNegativePayment -> nonNegativePayment.getPayerPartyReference()).get(), MapperS.of(fpmlNonNegativePayment).<PartyReference>map("getReceiverPartyReference", nonNegativePayment -> nonNegativePayment.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(MapperS.of(fpmlNonNegativePayment).<AdjustableOrRelativeDate>map("getPaymentDate", nonNegativePayment -> nonNegativePayment.getPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<IdentifiedDate>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), MapperS.of(fpmlNonNegativePayment).<AdjustableOrRelativeDate>map("getPaymentDate", nonNegativePayment -> nonNegativePayment.getPaymentDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).get(), MapperS.of(fpmlNonNegativePayment).<AdjustableOrRelativeDate>map("getPaymentDate", nonNegativePayment -> nonNegativePayment.getPaymentDate()).<RelativeDateOffset>map("getRelativeDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getRelativeDate()).get()))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build().toBuilder();
				withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlNonNegativePayment).<String>map("getId", nonNegativePayment -> nonNegativePayment.getId()).get());
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
