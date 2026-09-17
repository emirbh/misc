package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.event.common.TransferState;
import cdm.ingest.fpml.confirmation.other.functions.MapFeeTypeEnum;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Payment;
import fpml.consolidated.shared.PaymentType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapPaymentListToTransferStateList.MapPaymentListToTransferStateListDefault.class)
public abstract class MapPaymentListToTransferStateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFeeTypeEnum mapFeeTypeEnum;
	@Inject protected MapPaymentToTransferState mapPaymentToTransferState;

	/**
	* @param fpmlPaymentList 
	* @param cdmFeeType 
	* @return transferStateList 
	*/
	public List<? extends TransferState> evaluate(List<? extends Payment> fpmlPaymentList, FeeTypeEnum cdmFeeType) {
		List<TransferState.TransferStateBuilder> transferStateListBuilder = doEvaluate(fpmlPaymentList, cdmFeeType);
		
		final List<? extends TransferState> transferStateList;
		if (transferStateListBuilder == null) {
			transferStateList = null;
		} else {
			transferStateList = transferStateListBuilder.stream().map(TransferState::build).collect(Collectors.toList());
			objectValidator.validate(TransferState.class, transferStateList);
		}
		
		return transferStateList;
	}

	protected abstract List<TransferState.TransferStateBuilder> doEvaluate(List<? extends Payment> fpmlPaymentList, FeeTypeEnum cdmFeeType);

	public static class MapPaymentListToTransferStateListDefault extends MapPaymentListToTransferStateList {
		@Override
		protected List<TransferState.TransferStateBuilder> doEvaluate(List<? extends Payment> fpmlPaymentList, FeeTypeEnum cdmFeeType) {
			if (fpmlPaymentList == null) {
				fpmlPaymentList = Collections.emptyList();
			}
			List<TransferState.TransferStateBuilder> transferStateList = new ArrayList<>();
			return assignOutput(transferStateList, fpmlPaymentList, cdmFeeType);
		}
		
		protected List<TransferState.TransferStateBuilder> assignOutput(List<TransferState.TransferStateBuilder> transferStateList, List<? extends Payment> fpmlPaymentList, FeeTypeEnum cdmFeeType) {
			transferStateList.addAll(toBuilder(MapperC.<Payment>of(fpmlPaymentList)
				.mapItem(item -> MapperS.of(mapPaymentToTransferState.evaluate(item.get(), MapperS.of(mapFeeTypeEnum.evaluate(item.<PaymentType>map("getPaymentType", payment -> payment.getPaymentType()).<String>map("getValue", paymentType -> paymentType.getValue()).get())).getOrDefault(cdmFeeType)))).getMulti()));
			
			return Optional.ofNullable(transferStateList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
