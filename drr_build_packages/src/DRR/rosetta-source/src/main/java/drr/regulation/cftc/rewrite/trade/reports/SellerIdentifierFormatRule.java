package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.TradeForEvent;
import drr.base.util.party.PartyIdentifierFormatEnum;
import drr.base.util.party.functions.PartyIdentifierFormat;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version2.party.reports.Direction1SellerPartyRule;
import javax.inject.Inject;


@ImplementedBy(SellerIdentifierFormatRule.SellerIdentifierFormatRuleDefault.class)
public abstract class SellerIdentifierFormatRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierFormatEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Direction1SellerPartyRule direction1SellerPartyRule;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected PartyIdentifierFormat partyIdentifierFormat;
	@Inject protected TradeForEvent tradeForEvent;

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

	public static class SellerIdentifierFormatRuleDefault extends SellerIdentifierFormatRule {
		@Override
		protected PartyIdentifierFormatEnum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierFormatEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierFormatEnum assignOutput(PartyIdentifierFormatEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(partyIdentifierFormat.evaluate(direction1SellerPartyRule.evaluate(tradeForEvent.evaluate(item.get()))))).get();
			
			return output;
		}
	}
}
