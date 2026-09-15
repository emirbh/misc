package drr.standards.iosco.cde.version1.payment.functions;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.util.party.functions.PartyLeiAndPersonByRoles;
import javax.inject.Inject;


@ImplementedBy(ExtractOtherPaymentReceiver.ExtractOtherPaymentReceiverDefault.class)
public abstract class ExtractOtherPaymentReceiver implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;

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
			final ReferenceWithMetaParty referenceWithMetaParty0 = MapperS.of(transferState).<Transfer>map("getTransfer", _transferState -> _transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getReceiverPartyReference()).get();
			final ReferenceWithMetaParty referenceWithMetaParty1 = MapperS.of(transactionReportInstruction).<ReportingSide>map("getReportingSide", transactionReportInstructionBase -> transactionReportInstructionBase.getReportingSide()).<ReferenceWithMetaParty>map("getReportingParty", reportingSide -> reportingSide.getReportingParty()).get();
			partyPersonLei = partyLeiAndPersonByRoles.evaluate((referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), (referenceWithMetaParty1 == null ? null : referenceWithMetaParty1.getValue()));
			
			return partyPersonLei;
		}
	}
}
