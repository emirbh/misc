package drr.regulation.jfsa.rewrite.trade.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IntendedToClear;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsCleared;
import drr.base.trade.PartyInformation;
import drr.base.util.party.functions.ExtractPartyFromRelatedPartyByRole;
import drr.base.util.party.functions.PartyLei;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iso.EventTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OriginalSwapSDRIdentifierRule.OriginalSwapSDRIdentifierRuleDefault.class)
public abstract class OriginalSwapSDRIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected ExtractPartyFromRelatedPartyByRole extractPartyFromRelatedPartyByRole;
	@Inject protected IntendedToClear intendedToClear;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;
	@Inject protected IsCleared isCleared;
	@Inject protected PartyLei partyLei;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class OriginalSwapSDRIdentifierRuleDefault extends OriginalSwapSDRIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			final MapperS<Party> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isCleared.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(true), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(eventTypeRule.evaluate(item.get())), MapperS.of(EventTypeEnum.CLRG), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.PRIOR_TRADE_REPOSITORY));
					}
					if (areEqual(MapperS.of(intendedToClear.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())), MapperS.of(true), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypeTERM.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(extractPartyFromRelatedPartyByRole.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.TRADE_REPOSITORY));
					}
					return MapperS.<Party>ofNull();
				});
			output = thenArg1
				.mapSingleToItem(item -> MapperS.of(partyLei.evaluate(item.<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti()))).get();
			
			return output;
		}
	}
}
