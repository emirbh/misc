package drr.regulation.common.emir.reports;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.functions.FilterPartyRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.BusinessEvent;
import cdm.event.common.ExecutionInstruction;
import cdm.event.common.Instruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.util.party.functions.PartyLei;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PTRRServiceProviderRule.PTRRServiceProviderRuleDefault.class)
public abstract class PTRRServiceProviderRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterPartyRole filterPartyRole;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected PTRRRule pTRRRule;
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

	public static class PTRRServiceProviderRuleDefault extends PTRRServiceProviderRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableAction.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			final MapperS<ReferenceWithMetaParty> thenArg1 = thenArg0
				.mapSingleToItem(item -> {
					final Boolean _boolean = pTRRRule.evaluate(item.get());
					if ((_boolean == null ? false : _boolean)) {
						return MapperS.of(distinctIgnoringPrecision(MapperC.<PartyRole>of(filterPartyRole.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Instruction>mapC("getInstruction", businessEvent -> businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction()).<ExecutionInstruction>map("getExecution", primitiveInstruction -> primitiveInstruction.getExecution()).<PartyRole>mapC("getPartyRoles", executionInstruction -> executionInstruction.getPartyRoles()).getMulti(), PartyRoleEnum.PTRR_SERVICE_PROVIDER)).<ReferenceWithMetaParty>map("getPartyReference", partyRole -> partyRole.getPartyReference())).get());
					}
					return MapperS.<ReferenceWithMetaParty>ofNull();
				});
			output = thenArg1
				.mapSingleToItem(item -> MapperS.of(partyLei.evaluate(item.<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty == null ? null : referenceWithMetaParty.getValue()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId()).getMulti()))).get();
			
			return output;
		}
	}
}
