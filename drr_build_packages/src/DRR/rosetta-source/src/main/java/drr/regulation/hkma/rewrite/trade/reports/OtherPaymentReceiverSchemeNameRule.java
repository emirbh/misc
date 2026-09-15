package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.Transfer;
import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.hkma.rewrite.trade.functions.Extract_HKMASchemeName;
import drr.regulation.hkma.rewrite.trade.functions.Filter_HKMAPriorityPartyIdentifiers;
import drr.standards.iosco.cde.version3.payment.functions.IsOtherPayment;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OtherPaymentReceiverSchemeNameRule.OtherPaymentReceiverSchemeNameRuleDefault.class)
public abstract class OtherPaymentReceiverSchemeNameRule implements ReportFunction<TransferState, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Extract_HKMASchemeName extract_HKMASchemeName;
	@Inject protected Filter_HKMAPriorityPartyIdentifiers filter_HKMAPriorityPartyIdentifiers;
	@Inject protected IsOtherPayment isOtherPayment;
	@Inject protected OtherPaymentReceiverFormatRule otherPaymentReceiverFormatRule;

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

	public static class OtherPaymentReceiverSchemeNameRuleDefault extends OtherPaymentReceiverSchemeNameRule {
		@Override
		protected String doEvaluate(TransferState input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransferState input) {
			final MapperS<TransferState> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isOtherPayment.evaluate(item.get()));
			final MapperS<ReferenceWithMetaParty> ifThenElseResult;
			if (areEqual(MapperS.of(otherPaymentReceiverFormatRule.evaluate(thenArg0.get())), MapperS.of(PartyIdentifierFormatEnum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = thenArg0
					.mapSingleToItem(item -> item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", transfer -> transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", partyReferencePayerReceiver -> partyReferencePayerReceiver.getReceiverPartyReference()));
			} else {
				ifThenElseResult = MapperS.<ReferenceWithMetaParty>ofNull();
			}
			final ReferenceWithMetaParty referenceWithMetaParty = ifThenElseResult.get();
			final MapperS<PartyIdentifier> thenArg1 = MapperS.of(filter_HKMAPriorityPartyIdentifiers.evaluate((referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue())));
			output = MapperS.of(extract_HKMASchemeName.evaluate(thenArg1.get())).map("to-string", HKTRPartyScheme::toDisplayString).get();
			
			return output;
		}
	}
}
