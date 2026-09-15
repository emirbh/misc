package drr.regulation.common.trade.execution.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsCleared;
import drr.base.trade.PartyInformation;
import drr.base.trade.functions.TradeForEvent;
import drr.base.util.party.functions.ExtractPartyFromRelatedPartyByRole;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.Counterparties;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingAccountOriginRule.ClearingAccountOriginRuleDefault.class)
public abstract class ClearingAccountOriginRule implements ReportFunction<TransactionReportInstruction, ClearingAccountOriginEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Counterparties counterparties;
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;
	@Inject protected IsCleared isCleared;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ClearingAccountOriginEnum evaluate(TransactionReportInstruction input) {
		ClearingAccountOriginEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ClearingAccountOriginEnum doEvaluate(TransactionReportInstruction input);

	public static class ClearingAccountOriginRuleDefault extends ClearingAccountOriginRule {
		@Override
		protected ClearingAccountOriginEnum doEvaluate(TransactionReportInstruction input) {
			ClearingAccountOriginEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ClearingAccountOriginEnum assignOutput(ClearingAccountOriginEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						if (areEqual(MapperC.<Party>of(counterparties.evaluate(tradeForEvent.evaluate(item.get()))), MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.CLEARING_FIRM)), CardinalityOperator.Any).getOrDefault(false)) {
							return MapperS.of(ClearingAccountOriginEnum.HOUS);
						}
						return MapperS.of(ClearingAccountOriginEnum.CLIE);
					}
					return MapperS.<ClearingAccountOriginEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
