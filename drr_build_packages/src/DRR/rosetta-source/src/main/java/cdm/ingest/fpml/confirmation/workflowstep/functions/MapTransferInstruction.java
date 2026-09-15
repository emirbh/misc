package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.event.common.TransferInstruction;
import cdm.ingest.fpml.confirmation.payment.functions.MapPaymentListToTransferStateList;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.shared.Payment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTransferInstruction.MapTransferInstructionDefault.class)
public abstract class MapTransferInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPaymentListToTransferStateList mapPaymentListToTransferStateList;

	/**
	* @param fpmlPaymentList 
	* @param cdmFeeType 
	* @return transferInstruction 
	*/
	public TransferInstruction evaluate(List<? extends Payment> fpmlPaymentList, FeeTypeEnum cdmFeeType) {
		TransferInstruction.TransferInstructionBuilder transferInstructionBuilder = doEvaluate(fpmlPaymentList, cdmFeeType);
		
		final TransferInstruction transferInstruction;
		if (transferInstructionBuilder == null) {
			transferInstruction = null;
		} else {
			transferInstruction = transferInstructionBuilder.build();
			objectValidator.validate(TransferInstruction.class, transferInstruction);
		}
		
		return transferInstruction;
	}

	protected abstract TransferInstruction.TransferInstructionBuilder doEvaluate(List<? extends Payment> fpmlPaymentList, FeeTypeEnum cdmFeeType);

	public static class MapTransferInstructionDefault extends MapTransferInstruction {
		@Override
		protected TransferInstruction.TransferInstructionBuilder doEvaluate(List<? extends Payment> fpmlPaymentList, FeeTypeEnum cdmFeeType) {
			if (fpmlPaymentList == null) {
				fpmlPaymentList = Collections.emptyList();
			}
			TransferInstruction.TransferInstructionBuilder transferInstruction = TransferInstruction.builder();
			return assignOutput(transferInstruction, fpmlPaymentList, cdmFeeType);
		}
		
		protected TransferInstruction.TransferInstructionBuilder assignOutput(TransferInstruction.TransferInstructionBuilder transferInstruction, List<? extends Payment> fpmlPaymentList, FeeTypeEnum cdmFeeType) {
			transferInstruction = toBuilder(TransferInstruction.builder()
				.setTransferState(new ArrayList(mapPaymentListToTransferStateList.evaluate(fpmlPaymentList, cdmFeeType)))
				.build());
			
			return Optional.ofNullable(transferInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
