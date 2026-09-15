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
import fpml.consolidated.cd.SinglePayment;
import fpml.consolidated.shared.Money;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSinglePaymentToTransferState.MapSinglePaymentToTransferStateDefault.class)
public abstract class MapSinglePaymentToTransferState implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoneyToTransferCashAsset mapMoneyToTransferCashAsset;
	@Inject protected MapMoneyToTransferQuantity mapMoneyToTransferQuantity;

	/**
	* @param fpmlSinglePayment 
	* @param cdmFeeType 
	* @return transferState 
	*/
	public TransferState evaluate(SinglePayment fpmlSinglePayment, FeeTypeEnum cdmFeeType) {
		TransferState.TransferStateBuilder transferStateBuilder = doEvaluate(fpmlSinglePayment, cdmFeeType);
		
		final TransferState transferState;
		if (transferStateBuilder == null) {
			transferState = null;
		} else {
			transferState = transferStateBuilder.build();
			objectValidator.validate(TransferState.class, transferState);
		}
		
		return transferState;
	}

	protected abstract TransferState.TransferStateBuilder doEvaluate(SinglePayment fpmlSinglePayment, FeeTypeEnum cdmFeeType);

	public static class MapSinglePaymentToTransferStateDefault extends MapSinglePaymentToTransferState {
		@Override
		protected TransferState.TransferStateBuilder doEvaluate(SinglePayment fpmlSinglePayment, FeeTypeEnum cdmFeeType) {
			TransferState.TransferStateBuilder transferState = TransferState.builder();
			return assignOutput(transferState, fpmlSinglePayment, cdmFeeType);
		}
		
		protected TransferState.TransferStateBuilder assignOutput(TransferState.TransferStateBuilder transferState, SinglePayment fpmlSinglePayment, FeeTypeEnum cdmFeeType) {
			if (exists(MapperS.of(fpmlSinglePayment)).getOrDefault(false)) {
				final TransferState.TransferStateBuilder withMetaArgument = TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapMoneyToTransferQuantity.evaluate(MapperS.of(fpmlSinglePayment).<Money>map("getFixedAmount", singlePayment -> singlePayment.getFixedAmount()).get()))
						.setAsset(mapMoneyToTransferCashAsset.evaluate(MapperS.of(fpmlSinglePayment).<Money>map("getFixedAmount", singlePayment -> singlePayment.getFixedAmount()).get()))
						.setPayerReceiver(null)
						.setSettlementDate(AdjustableOrAdjustedOrRelativeDate.builder()
							.setUnadjustedDate(MapperS.of(fpmlSinglePayment).<ZonedDateTime>map("getAdjustablePaymentDate", singlePayment -> singlePayment.getAdjustablePaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.setAdjustedDateValue(MapperS.of(fpmlSinglePayment).<ZonedDateTime>map("getAdjustedPaymentDate", singlePayment -> singlePayment.getAdjustedPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.build())
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build() == null ? null : TransferState.builder()
					.setTransfer(Transfer.builder()
						.setQuantity(mapMoneyToTransferQuantity.evaluate(MapperS.of(fpmlSinglePayment).<Money>map("getFixedAmount", singlePayment -> singlePayment.getFixedAmount()).get()))
						.setAsset(mapMoneyToTransferCashAsset.evaluate(MapperS.of(fpmlSinglePayment).<Money>map("getFixedAmount", singlePayment -> singlePayment.getFixedAmount()).get()))
						.setPayerReceiver(null)
						.setSettlementDate(AdjustableOrAdjustedOrRelativeDate.builder()
							.setUnadjustedDate(MapperS.of(fpmlSinglePayment).<ZonedDateTime>map("getAdjustablePaymentDate", singlePayment -> singlePayment.getAdjustablePaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.setAdjustedDateValue(MapperS.of(fpmlSinglePayment).<ZonedDateTime>map("getAdjustedPaymentDate", singlePayment -> singlePayment.getAdjustedPaymentDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.build())
						.setTransferExpression(TransferExpression.builder()
							.setPriceTransfer(cdmFeeType)
							.build())
						.build())
					.build().toBuilder();
				withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlSinglePayment).<String>map("getId", singlePayment -> singlePayment.getId()).get());
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
