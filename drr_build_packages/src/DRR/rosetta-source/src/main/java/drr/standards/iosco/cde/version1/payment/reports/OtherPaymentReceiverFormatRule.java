package drr.standards.iosco.cde.version1.payment.reports;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.base.util.party.functions.PartyIdentifierFormat;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentReceiverFormatRule.OtherPaymentReceiverFormatRuleDefault.class)
public abstract class OtherPaymentReceiverFormatRule implements ReportFunction<TransferState, PartyIdentifierFormatEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyIdentifierFormat partyIdentifierFormat;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierFormatEnum evaluate(TransferState input) {
		PartyIdentifierFormatEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierFormatEnum doEvaluate(TransferState input);

	public static class OtherPaymentReceiverFormatRuleDefault extends OtherPaymentReceiverFormatRule {
		@Override
		protected PartyIdentifierFormatEnum doEvaluate(TransferState input) {
			PartyIdentifierFormatEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierFormatEnum assignOutput(PartyIdentifierFormatEnum output, TransferState input) {
			final MapperS<ReferenceWithMetaParty> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getReceiverPartyReference()));
			output = thenArg
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.get();
					return MapperS.of(partyIdentifierFormat.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
				}).get();
			
			return output;
		}
	}
}
