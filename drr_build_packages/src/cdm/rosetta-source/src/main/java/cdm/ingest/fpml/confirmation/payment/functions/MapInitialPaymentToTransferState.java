package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferState;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.cd.InitialPayment;
import fpml.consolidated.shared.Money;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapInitialPaymentToTransferState.MapInitialPaymentToTransferStateDefault.class)
public abstract class MapInitialPaymentToTransferState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoneyToTransferCashAsset mapMoneyToTransferCashAsset;
	@Inject protected MapMoneyToTransferQuantity mapMoneyToTransferQuantity;
	@Inject protected MapPaymentToPartyReferencePayerReceiver mapPaymentToPartyReferencePayerReceiver;

	/**
	* @param fpmlInitialPayment 
	* @param cdmFeeType 
	* @return transferState 
	*/
	public TransferState evaluate(InitialPayment fpmlInitialPayment, FeeTypeEnum cdmFeeType) {
		TransferState.TransferStateBuilder transferStateBuilder = doEvaluate(fpmlInitialPayment, cdmFeeType);
		
		final TransferState transferState;
		if (transferStateBuilder == null) {
			transferState = null;
		} else {
			transferState = transferStateBuilder.build();
			objectValidator.validate(TransferState.class, transferState);
		}
		
		return transferState;
	}

	protected abstract TransferState.TransferStateBuilder doEvaluate(InitialPayment fpmlInitialPayment, FeeTypeEnum cdmFeeType);

	public static class MapInitialPaymentToTransferStateDefault extends MapInitialPaymentToTransferState {
		@Override
		protected TransferState.TransferStateBuilder doEvaluate(InitialPayment fpmlInitialPayment, FeeTypeEnum cdmFeeType) {
			TransferState.TransferStateBuilder transferState = TransferState.builder();
			return assignOutput(transferState, fpmlInitialPayment, cdmFeeType);
		}
		
		protected TransferState.TransferStateBuilder assignOutput(TransferState.TransferStateBuilder transferState, InitialPayment fpmlInitialPayment, FeeTypeEnum cdmFeeType) {
			if (exists(MapperS.of(fpmlInitialPayment)).getOrDefault(false)) {
				final TransferState.TransferStateBuilder withMetaArgument = TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapMoneyToTransferQuantity.evaluate(MapperS.of(fpmlInitialPayment).<Money>map("getPaymentAmount", initialPayment -> initialPayment.getPaymentAmount()).get()))
						.setAsset(mapMoneyToTransferCashAsset.evaluate(MapperS.of(fpmlInitialPayment).<Money>map("getPaymentAmount", initialPayment -> initialPayment.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlInitialPayment).<PartyReference>map("getPayerPartyReference", initialPayment -> initialPayment.getPayerPartyReference()).get(), MapperS.of(fpmlInitialPayment).<PartyReference>map("getReceiverPartyReference", initialPayment -> initialPayment.getReceiverPartyReference()).get()))
						.setSettlementDate(AdjustableOrAdjustedOrRelativeDate.builder()
							.setUnadjustedDate(MapperS.of(fpmlInitialPayment).<ZonedDateTime>map("getAdjustablePaymentDate", initialPayment -> initialPayment.getAdjustablePaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.setAdjustedDateValue(MapperS.of(fpmlInitialPayment).<ZonedDateTime>map("getAdjustedPaymentDate", initialPayment -> initialPayment.getAdjustedPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.build())
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build() == null ? null : TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapMoneyToTransferQuantity.evaluate(MapperS.of(fpmlInitialPayment).<Money>map("getPaymentAmount", initialPayment -> initialPayment.getPaymentAmount()).get()))
						.setAsset(mapMoneyToTransferCashAsset.evaluate(MapperS.of(fpmlInitialPayment).<Money>map("getPaymentAmount", initialPayment -> initialPayment.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlInitialPayment).<PartyReference>map("getPayerPartyReference", initialPayment -> initialPayment.getPayerPartyReference()).get(), MapperS.of(fpmlInitialPayment).<PartyReference>map("getReceiverPartyReference", initialPayment -> initialPayment.getReceiverPartyReference()).get()))
						.setSettlementDate(AdjustableOrAdjustedOrRelativeDate.builder()
							.setUnadjustedDate(MapperS.of(fpmlInitialPayment).<ZonedDateTime>map("getAdjustablePaymentDate", initialPayment -> initialPayment.getAdjustablePaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.setAdjustedDateValue(MapperS.of(fpmlInitialPayment).<ZonedDateTime>map("getAdjustedPaymentDate", initialPayment -> initialPayment.getAdjustedPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.build())
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build().toBuilder();
				withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlInitialPayment).<String>map("getId", initialPayment -> initialPayment.getId()).get());
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
