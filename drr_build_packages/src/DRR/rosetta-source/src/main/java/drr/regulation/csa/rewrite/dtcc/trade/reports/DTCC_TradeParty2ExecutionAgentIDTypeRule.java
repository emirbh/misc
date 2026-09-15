package drr.regulation.csa.rewrite.dtcc.trade.reports;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;


@ImplementedBy(DTCC_TradeParty2ExecutionAgentIDTypeRule.DTCC_TradeParty2ExecutionAgentIDTypeRuleDefault.class)
public abstract class DTCC_TradeParty2ExecutionAgentIDTypeRule implements ReportFunction<TransactionReportInstruction, PartyIdentifierTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty2ExecutionAgentIDTypeRule dTCC_TradeParty2ExecutionAgentIDTypeRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PartyIdentifierTypeEnum evaluate(TransactionReportInstruction input) {
		PartyIdentifierTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PartyIdentifierTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class DTCC_TradeParty2ExecutionAgentIDTypeRuleDefault extends DTCC_TradeParty2ExecutionAgentIDTypeRule {
		@Override
		protected PartyIdentifierTypeEnum doEvaluate(TransactionReportInstruction input) {
			PartyIdentifierTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PartyIdentifierTypeEnum assignOutput(PartyIdentifierTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(dTCC_TradeParty2ExecutionAgentIDTypeRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
