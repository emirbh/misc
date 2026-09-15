package drr.standards.iosco.cde.version2.payment.reports;

import cdm.event.common.TransferState;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.PartyIdentifierFormatEnum;
import javax.inject.Inject;


@ImplementedBy(OtherPaymentPayerFormatRule.OtherPaymentPayerFormatRuleDefault.class)
public abstract class OtherPaymentPayerFormatRule implements ReportFunction<TransferState, PartyIdentifierFormatEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.payment.reports.OtherPaymentPayerFormatRule otherPaymentPayerFormatRule;

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

	public static class OtherPaymentPayerFormatRuleDefault extends OtherPaymentPayerFormatRule {
		@Override
		protected PartyIdentifierFormatEnum doEvaluate(TransferState input) {
			PartyIdentifierFormatEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierFormatEnum assignOutput(PartyIdentifierFormatEnum output, TransferState input) {
			output = otherPaymentPayerFormatRule.evaluate(input);
			
			return output;
		}
	}
}
