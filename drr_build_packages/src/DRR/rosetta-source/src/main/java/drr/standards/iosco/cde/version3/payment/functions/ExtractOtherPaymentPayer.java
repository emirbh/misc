package drr.standards.iosco.cde.version3.payment.functions;

import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(ExtractOtherPaymentPayer.ExtractOtherPaymentPayerDefault.class)
public abstract class ExtractOtherPaymentPayer implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version2.payment.functions.ExtractOtherPaymentPayer extractOtherPaymentPayer;

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

	public static class ExtractOtherPaymentPayerDefault extends ExtractOtherPaymentPayer {
		@Override
		protected String doEvaluate(TransferState transferState, TransactionReportInstructionBase transactionReportInstruction) {
			String partyPersonLei = null;
			return assignOutput(partyPersonLei, transferState, transactionReportInstruction);
		}
		
		protected String assignOutput(String partyPersonLei, TransferState transferState, TransactionReportInstructionBase transactionReportInstruction) {
			partyPersonLei = extractOtherPaymentPayer.evaluate(transferState, transactionReportInstruction);
			
			return partyPersonLei;
		}
	}
}
