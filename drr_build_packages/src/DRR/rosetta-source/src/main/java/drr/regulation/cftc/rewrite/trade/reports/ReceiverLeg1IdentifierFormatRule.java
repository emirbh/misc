package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.base.util.party.functions.CounterpartiesForEvent;
import drr.base.util.party.functions.PartyIdentifierFormat;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.standards.iosco.cde.version2.party.functions.ReceiverParty;
import javax.inject.Inject;


@ImplementedBy(ReceiverLeg1IdentifierFormatRule.ReceiverLeg1IdentifierFormatRuleDefault.class)
public abstract class ReceiverLeg1IdentifierFormatRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierFormatEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CounterpartiesForEvent counterpartiesForEvent;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected PartyIdentifierFormat partyIdentifierFormat;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected ReceiverParty receiverParty;

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

	public static class ReceiverLeg1IdentifierFormatRuleDefault extends ReceiverLeg1IdentifierFormatRule {
		@Override
		protected PartyIdentifierFormatEnum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierFormatEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierFormatEnum assignOutput(PartyIdentifierFormatEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(partyIdentifierFormat.evaluate(receiverParty.evaluate(payoutLeg1Rule.evaluate(item.get()), counterpartiesForEvent.evaluate(item.get()))))).get();
			
			return output;
		}
	}
}
