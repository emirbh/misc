package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.event.common.TransferState;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.SinglePayment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapSinglePaymentListToTransferStateList.MapSinglePaymentListToTransferStateListDefault.class)
public abstract class MapSinglePaymentListToTransferStateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSinglePaymentToTransferState mapSinglePaymentToTransferState;

	/**
	* @param fpmlSinglePaymentList 
	* @param cdmFeeType 
	* @return transferState 
	*/
	public List<? extends TransferState> evaluate(List<? extends SinglePayment> fpmlSinglePaymentList, FeeTypeEnum cdmFeeType) {
		List<TransferState.TransferStateBuilder> transferStateBuilder = doEvaluate(fpmlSinglePaymentList, cdmFeeType);
		
		final List<? extends TransferState> transferState;
		if (transferStateBuilder == null) {
			transferState = null;
		} else {
			transferState = transferStateBuilder.stream().map(TransferState::build).collect(Collectors.toList());
			objectValidator.validate(TransferState.class, transferState);
		}
		
		return transferState;
	}

	protected abstract List<TransferState.TransferStateBuilder> doEvaluate(List<? extends SinglePayment> fpmlSinglePaymentList, FeeTypeEnum cdmFeeType);

	public static class MapSinglePaymentListToTransferStateListDefault extends MapSinglePaymentListToTransferStateList {
		@Override
		protected List<TransferState.TransferStateBuilder> doEvaluate(List<? extends SinglePayment> fpmlSinglePaymentList, FeeTypeEnum cdmFeeType) {
			if (fpmlSinglePaymentList == null) {
				fpmlSinglePaymentList = Collections.emptyList();
			}
			List<TransferState.TransferStateBuilder> transferState = new ArrayList<>();
			return assignOutput(transferState, fpmlSinglePaymentList, cdmFeeType);
		}
		
		protected List<TransferState.TransferStateBuilder> assignOutput(List<TransferState.TransferStateBuilder> transferState, List<? extends SinglePayment> fpmlSinglePaymentList, FeeTypeEnum cdmFeeType) {
			transferState.addAll(toBuilder(MapperC.<SinglePayment>of(fpmlSinglePaymentList)
				.mapItem(item -> MapperS.of(mapSinglePaymentToTransferState.evaluate(item.get(), cdmFeeType))).getMulti()));
			
			return Optional.ofNullable(transferState)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
