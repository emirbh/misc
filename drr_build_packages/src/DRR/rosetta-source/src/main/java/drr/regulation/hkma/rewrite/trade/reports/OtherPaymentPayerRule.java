package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.hkma.rewrite.trade.functions.Extract_HKMAPartyIdentifier;
import drr.regulation.hkma.rewrite.trade.functions.Filter_HKMAPriorityPartyIdentifiers;
import drr.standards.iosco.cde.version3.payment.functions.IsOtherPayment;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentPayerRule.OtherPaymentPayerRuleDefault.class)
public abstract class OtherPaymentPayerRule implements ReportFunction<TransferState, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Extract_HKMAPartyIdentifier extract_HKMAPartyIdentifier;
	@Inject protected Filter_HKMAPriorityPartyIdentifiers filter_HKMAPriorityPartyIdentifiers;
	@Inject protected IsOtherPayment isOtherPayment;

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

	public static class OtherPaymentPayerRuleDefault extends OtherPaymentPayerRule {
		@Override
		protected String doEvaluate(TransferState input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransferState input) {
			final MapperS<TransferState> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isOtherPayment.evaluate(item.get()));
			final MapperS<ReferenceWithMetaParty> thenArg1 = thenArg0
				.mapSingleToItem(item -> item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getPayerPartyReference()));
			final ReferenceWithMetaParty referenceWithMetaParty = thenArg1.get();
			final MapperS<PartyIdentifier> thenArg2 = MapperS.of(filter_HKMAPriorityPartyIdentifiers.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
			output = MapperS.of(extract_HKMAPartyIdentifier.evaluate(thenArg2.get())).get();
			
			return output;
		}
	}
}
