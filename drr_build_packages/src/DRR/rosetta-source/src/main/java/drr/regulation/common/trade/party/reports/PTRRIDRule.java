package drr.regulation.common.trade.party.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.base.staticdata.party.functions.FilterPartyRole;
import cdm.base.staticdata.party.functions.FilterRelatedPartyByRole;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.BusinessEvent;
import cdm.event.common.ExecutionInstruction;
import cdm.event.common.Instruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.PartyInformation;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsCompressed;
import drr.regulation.common.functions.IsPortfolioRebalancing;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PTRRIDRule.PTRRIDRuleDefault.class)
public abstract class PTRRIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterPartyRole filterPartyRole;
	@Inject protected FilterRelatedPartyByRole filterRelatedPartyByRole;
	@Inject protected IsCompressed isCompressed;
	@Inject protected IsPortfolioRebalancing isPortfolioRebalancing;

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

	public static class PTRRIDRuleDefault extends PTRRIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperC<FieldWithMetaString> thenArg = MapperS.of(input)
				.mapSingleToList(reportableEvent -> {
					final MapperC<Identifier> thenArg0 = reportableEvent.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<Identifier>mapC("getEventIdentifier", workflowStep -> workflowStep.getEventIdentifier());
					final MapperListOfLists<FieldWithMetaString> thenArg1 = thenArg0
						.mapItemToList(eventIdentifier -> {
							final MapperS<Identifier> _thenArg = eventIdentifier
								.filterSingleNullSafe(item -> {
									if (ComparisonResult.ofNullSafe(MapperS.of(isCompressed.evaluate(reportableEvent.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isPortfolioRebalancing.evaluate(reportableEvent.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get())))).getOrDefault(false)) {
										if (exists(reportableEvent.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Instruction>mapC("getInstruction", businessEvent -> businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction()).<ExecutionInstruction>map("getExecution", primitiveInstruction -> primitiveInstruction.getExecution())).getOrDefault(false)) {
											final ReferenceWithMetaParty referenceWithMetaParty1 = distinctIgnoringPrecision(MapperC.<PartyRole>of(filterPartyRole.evaluate(reportableEvent.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Instruction>mapC("getInstruction", businessEvent -> businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction()).<ExecutionInstruction>map("getExecution", primitiveInstruction -> primitiveInstruction.getExecution()).<PartyRole>mapC("getPartyRoles", executionInstruction -> executionInstruction.getPartyRoles()).getMulti(), PartyRoleEnum.PTRR_SERVICE_PROVIDER)).<ReferenceWithMetaParty>map("getPartyReference", partyRole -> partyRole.getPartyReference())).get();
											return exists(item.<ReferenceWithMetaParty>map("getIssuerReference", identifier -> identifier.getIssuerReference())).andNullSafe(areEqual(item.<ReferenceWithMetaParty>map("getIssuerReference", identifier -> identifier.getIssuerReference()).<Party>map("Type coercion", referenceWithMetaParty0 -> referenceWithMetaParty0 == null ? null : referenceWithMetaParty0.getValue()), (referenceWithMetaParty1 == null ? MapperS.<Party>ofNull() : MapperS.of(referenceWithMetaParty1.getValue())), CardinalityOperator.All)).get();
										}
										final ReferenceWithMetaParty referenceWithMetaParty3 = distinctIgnoringPrecision(MapperC.<RelatedParty>of(filterRelatedPartyByRole.evaluate(reportableEvent.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<PartyInformation>mapC("getGlobalPartyInformation", reportableInformation -> reportableInformation.getGlobalPartyInformation()).<RelatedParty>mapC("getRelatedParty", partyInformation -> partyInformation.getRelatedParty()).getMulti(), PartyRoleEnum.PTRR_SERVICE_PROVIDER)).<ReferenceWithMetaParty>map("getPartyReference", relatedParty -> relatedParty.getPartyReference())).get();
										return exists(item.<ReferenceWithMetaParty>map("getIssuerReference", identifier -> identifier.getIssuerReference())).andNullSafe(areEqual(item.<ReferenceWithMetaParty>map("getIssuerReference", identifier -> identifier.getIssuerReference()).<Party>map("Type coercion", referenceWithMetaParty2 -> referenceWithMetaParty2 == null ? null : referenceWithMetaParty2.getValue()), (referenceWithMetaParty3 == null ? MapperS.<Party>ofNull() : MapperS.of(referenceWithMetaParty3.getValue())), CardinalityOperator.All)).get();
									}
									return null;
								});
							return _thenArg
								.mapSingleToList(item -> eventIdentifier.<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
						});
					return thenArg1
						.flattenList();
				});
			final FieldWithMetaString fieldWithMetaString = MapperS.of(thenArg.get()).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
