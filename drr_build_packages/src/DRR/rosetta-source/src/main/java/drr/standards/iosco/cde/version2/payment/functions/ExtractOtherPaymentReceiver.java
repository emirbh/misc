package drr.standards.iosco.cde.version2.payment.functions;

import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(ExtractOtherPaymentReceiver.ExtractOtherPaymentReceiverDefault.class)
public abstract class ExtractOtherPaymentReceiver implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.payment.functions.ExtractOtherPaymentReceiver extractOtherPaymentReceiver;

	/**
	* @param transferState 
	* @param transactionReportInstruction 
	* @return partyPersonLei 
	*/
	public String evaluate(TransferState transferState, TransactionReportInstructionBase transactionReportInstruction) {
		String partyPersonLei = doEvaluate(transferState, transactionReportInstruction);
		
		return partyPersonLei;
	}

	protected abstract String doEvaluate(TransferState transferState, TransactionReportInstructionBase transactionReportInstruction);

	public static class ExtractOtherPaymentReceiverDefault extends ExtractOtherPaymentReceiver {
		@Override
		protected String doEvaluate(TransferState transferState, TransactionReportInstructionBase transactionReportInstruction) {
			String partyPersonLei = null;
			return assignOutput(partyPersonLei, transferState, transactionReportInstruction);
		}
		
		protected String assignOutput(String partyPersonLei, TransferState transferState, TransactionReportInstructionBase transactionReportInstruction) {
			partyPersonLei = extractOtherPaymentReceiver.evaluate(transferState, transactionReportInstruction);
			
			return partyPersonLei;
		}
	}
}
