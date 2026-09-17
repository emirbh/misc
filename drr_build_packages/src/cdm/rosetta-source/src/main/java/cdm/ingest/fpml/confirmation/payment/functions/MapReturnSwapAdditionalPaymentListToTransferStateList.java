package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.event.common.TransferState;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.ReturnSwapAdditionalPayment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapReturnSwapAdditionalPaymentListToTransferStateList.MapReturnSwapAdditionalPaymentListToTransferStateListDefault.class)
public abstract class MapReturnSwapAdditionalPaymentListToTransferStateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapReturnSwapAdditionalPaymentToTransferState mapReturnSwapAdditionalPaymentToTransferState;

	/**
	* @param fpmlReturnSwapAdditionalPaymentList 
	* @param cdmFeeType 
	* @return transferStateList 
	*/
	public List<? extends TransferState> evaluate(List<? extends ReturnSwapAdditionalPayment> fpmlReturnSwapAdditionalPaymentList, FeeTypeEnum cdmFeeType) {
		List<TransferState.TransferStateBuilder> transferStateListBuilder = doEvaluate(fpmlReturnSwapAdditionalPaymentList, cdmFeeType);
		
		final List<? extends TransferState> transferStateList;
		if (transferStateListBuilder == null) {
			transferStateList = null;
		} else {
			transferStateList = transferStateListBuilder.stream().map(TransferState::build).collect(Collectors.toList());
			objectValidator.validate(TransferState.class, transferStateList);
		}
		
		return transferStateList;
	}

	protected abstract List<TransferState.TransferStateBuilder> doEvaluate(List<? extends ReturnSwapAdditionalPayment> fpmlReturnSwapAdditionalPaymentList, FeeTypeEnum cdmFeeType);

	public static class MapReturnSwapAdditionalPaymentListToTransferStateListDefault extends MapReturnSwapAdditionalPaymentListToTransferStateList {
		@Override
		protected List<TransferState.TransferStateBuilder> doEvaluate(List<? extends ReturnSwapAdditionalPayment> fpmlReturnSwapAdditionalPaymentList, FeeTypeEnum cdmFeeType) {
			if (fpmlReturnSwapAdditionalPaymentList == null) {
				fpmlReturnSwapAdditionalPaymentList = Collections.emptyList();
			}
			List<TransferState.TransferStateBuilder> transferStateList = new ArrayList<>();
			return assignOutput(transferStateList, fpmlReturnSwapAdditionalPaymentList, cdmFeeType);
		}
		
		protected List<TransferState.TransferStateBuilder> assignOutput(List<TransferState.TransferStateBuilder> transferStateList, List<? extends ReturnSwapAdditionalPayment> fpmlReturnSwapAdditionalPaymentList, FeeTypeEnum cdmFeeType) {
			transferStateList.addAll(toBuilder(MapperC.<ReturnSwapAdditionalPayment>of(fpmlReturnSwapAdditionalPaymentList)
				.mapItem(item -> MapperS.of(mapReturnSwapAdditionalPaymentToTransferState.evaluate(item.get(), cdmFeeType))).getMulti()));
			
			return Optional.ofNullable(transferStateList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
