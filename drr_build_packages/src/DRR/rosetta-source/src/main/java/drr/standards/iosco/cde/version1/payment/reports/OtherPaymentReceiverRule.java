package drr.standards.iosco.cde.version1.payment.reports;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.functions.PartyLeiAndPersonByRoles;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentReceiverRule.OtherPaymentReceiverRuleDefault.class)
public abstract class OtherPaymentReceiverRule implements ReportFunction<TransferState, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PartyLeiAndPersonByRoles partyLeiAndPersonByRoles;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransferState input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransferState input);

	public static class OtherPaymentReceiverRuleDefault extends OtherPaymentReceiverRule {
		@Override
		protected String doEvaluate(TransferState input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransferState input) {
			final MapperS<ReferenceWithMetaParty> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getReceiverPartyReference()));
			output = thenArg
				.mapSingleToItem(item -> {
					final ReferenceWithMetaParty referenceWithMetaParty = item.get();
					return MapperS.of(partyLeiAndPersonByRoles.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()), null));
				}).get();
			
			return output;
		}
	}
}
