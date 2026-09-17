package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferState;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrAdjustedOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapZoneDateTimeToDate;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.EquityPremium;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapEquityPremiumToTransferState.MapEquityPremiumToTransferStateDefault.class)
public abstract class MapEquityPremiumToTransferState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapPaymentToPartyReferencePayerReceiver mapPaymentToPartyReferencePayerReceiver;
	@Inject protected MapTransferCashAsset mapTransferCashAsset;
	@Inject protected MapTransferQuantity mapTransferQuantity;
	@Inject protected MapZoneDateTimeToDate mapZoneDateTimeToDate;

	/**
	* @param fpmlEquityPremium 
	* @param cdmFeeType 
	* @return transferState 
	*/
	public TransferState evaluate(EquityPremium fpmlEquityPremium, FeeTypeEnum cdmFeeType) {
		TransferState.TransferStateBuilder transferStateBuilder = doEvaluate(fpmlEquityPremium, cdmFeeType);
		
		final TransferState transferState;
		if (transferStateBuilder == null) {
			transferState = null;
		} else {
			transferState = transferStateBuilder.build();
			objectValidator.validate(TransferState.class, transferState);
		}
		
		return transferState;
	}

	protected abstract TransferState.TransferStateBuilder doEvaluate(EquityPremium fpmlEquityPremium, FeeTypeEnum cdmFeeType);

	public static class MapEquityPremiumToTransferStateDefault extends MapEquityPremiumToTransferState {
		@Override
		protected TransferState.TransferStateBuilder doEvaluate(EquityPremium fpmlEquityPremium, FeeTypeEnum cdmFeeType) {
			TransferState.TransferStateBuilder transferState = TransferState.builder();
			return assignOutput(transferState, fpmlEquityPremium, cdmFeeType);
		}
		
		protected TransferState.TransferStateBuilder assignOutput(TransferState.TransferStateBuilder transferState, EquityPremium fpmlEquityPremium, FeeTypeEnum cdmFeeType) {
			if (exists(MapperS.of(fpmlEquityPremium)).getOrDefault(false)) {
				final TransferState.TransferStateBuilder withMetaArgument = TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlEquityPremium).<NonNegativeMoney>map("getPaymentAmount", equityPremium -> equityPremium.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlEquityPremium).<NonNegativeMoney>map("getPaymentAmount", equityPremium -> equityPremium.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlEquityPremium).<PartyReference>map("getPayerPartyReference", equityPremium -> equityPremium.getPayerPartyReference()).get(), MapperS.of(fpmlEquityPremium).<PartyReference>map("getReceiverPartyReference", equityPremium -> equityPremium.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(mapZoneDateTimeToDate.evaluate(MapperS.of(fpmlEquityPremium).<AdjustableDate>map("getPaymentDate", equityPremium -> equityPremium.getPaymentDate()).<IdentifiedDate>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).get()), MapperS.of(fpmlEquityPremium).<AdjustableDate>map("getPaymentDate", equityPremium -> equityPremium.getPaymentDate()).get(), null))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build() == null ? null : TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapTransferQuantity.evaluate(MapperS.of(fpmlEquityPremium).<NonNegativeMoney>map("getPaymentAmount", equityPremium -> equityPremium.getPaymentAmount()).get()))
						.setAsset(mapTransferCashAsset.evaluate(MapperS.of(fpmlEquityPremium).<NonNegativeMoney>map("getPaymentAmount", equityPremium -> equityPremium.getPaymentAmount()).get()))
						.setPayerReceiver(mapPaymentToPartyReferencePayerReceiver.evaluate(MapperS.of(fpmlEquityPremium).<PartyReference>map("getPayerPartyReference", equityPremium -> equityPremium.getPayerPartyReference()).get(), MapperS.of(fpmlEquityPremium).<PartyReference>map("getReceiverPartyReference", equityPremium -> equityPremium.getReceiverPartyReference()).get()))
						.setSettlementDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(mapZoneDateTimeToDate.evaluate(MapperS.of(fpmlEquityPremium).<AdjustableDate>map("getPaymentDate", equityPremium -> equityPremium.getPaymentDate()).<IdentifiedDate>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).<ZonedDateTime>map("getValue", identifiedDate -> identifiedDate.getValue()).get()), MapperS.of(fpmlEquityPremium).<AdjustableDate>map("getPaymentDate", equityPremium -> equityPremium.getPaymentDate()).get(), null))
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build().toBuilder();
				withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlEquityPremium).<String>map("getId", equityPremium -> equityPremium.getId()).get());
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
