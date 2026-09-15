package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.base.util.party.functions.CounterpartiesForEvent;
import drr.base.util.party.functions.PartyIdentifierFormat;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.standards.iosco.cde.version2.party.functions.PayerParty;
import javax.inject.Inject;


@ImplementedBy(PayerLeg2IdentifierFormatRule.PayerLeg2IdentifierFormatRuleDefault.class)
public abstract class PayerLeg2IdentifierFormatRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierFormatEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CounterpartiesForEvent counterpartiesForEvent;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected PartyIdentifierFormat partyIdentifierFormat;
	@Inject protected PayerParty payerParty;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierFormatEnum evaluate(TransactionReportInstruction input) {
		PartyIdentifierFormatEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierFormatEnum doEvaluate(TransactionReportInstruction input);

	public static class PayerLeg2IdentifierFormatRuleDefault extends PayerLeg2IdentifierFormatRule {
		@Override
		protected PartyIdentifierFormatEnum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierFormatEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierFormatEnum assignOutput(PartyIdentifierFormatEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(partyIdentifierFormat.evaluate(payerParty.evaluate(payoutLeg2Rule.evaluate(item.get()), counterpartiesForEvent.evaluate(item.get()))))).get();
			
			return output;
		}
	}
}
