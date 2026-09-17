package cdm.ingest.fpml.confirmation.payment.functions;

import cdm.event.common.TransferState;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.option.shared.ClassifiablePayment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapClassifiablePaymentListToTransferStateList.MapClassifiablePaymentListToTransferStateListDefault.class)
public abstract class MapClassifiablePaymentListToTransferStateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNonNegativePaymentToTransferState mapNonNegativePaymentToTransferState;

	/**
	* @param fpmlClassifiablePaymentList 
	* @param cdmFeeType 
	* @return transferStateList 
	*/
	public List<? extends TransferState> evaluate(List<? extends ClassifiablePayment> fpmlClassifiablePaymentList, FeeTypeEnum cdmFeeType) {
		List<TransferState.TransferStateBuilder> transferStateListBuilder = doEvaluate(fpmlClassifiablePaymentList, cdmFeeType);
		
		final List<? extends TransferState> transferStateList;
		if (transferStateListBuilder == null) {
			transferStateList = null;
		} else {
			transferStateList = transferStateListBuilder.stream().map(TransferState::build).collect(Collectors.toList());
			objectValidator.validate(TransferState.class, transferStateList);
		}
		
		return transferStateList;
	}

	protected abstract List<TransferState.TransferStateBuilder> doEvaluate(List<? extends ClassifiablePayment> fpmlClassifiablePaymentList, FeeTypeEnum cdmFeeType);

	public static class MapClassifiablePaymentListToTransferStateListDefault extends MapClassifiablePaymentListToTransferStateList {
		@Override
		protected List<TransferState.TransferStateBuilder> doEvaluate(List<? extends ClassifiablePayment> fpmlClassifiablePaymentList, FeeTypeEnum cdmFeeType) {
			if (fpmlClassifiablePaymentList == null) {
				fpmlClassifiablePaymentList = Collections.emptyList();
			}
			List<TransferState.TransferStateBuilder> transferStateList = new ArrayList<>();
			return assignOutput(transferStateList, fpmlClassifiablePaymentList, cdmFeeType);
		}
		
		protected List<TransferState.TransferStateBuilder> assignOutput(List<TransferState.TransferStateBuilder> transferStateList, List<? extends ClassifiablePayment> fpmlClassifiablePaymentList, FeeTypeEnum cdmFeeType) {
			transferStateList.addAll(toBuilder(MapperC.<ClassifiablePayment>of(fpmlClassifiablePaymentList)
				.mapItem(item -> MapperS.of(mapNonNegativePaymentToTransferState.evaluate(item.get(), cdmFeeType))).getMulti()));
			
			return Optional.ofNullable(transferStateList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
