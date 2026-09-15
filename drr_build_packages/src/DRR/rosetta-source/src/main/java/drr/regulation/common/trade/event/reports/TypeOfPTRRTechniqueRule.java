package drr.regulation.common.trade.event.reports;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.ExecutionInstruction;
import cdm.event.common.Instruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsCompressed;
import drr.regulation.common.functions.IsPortfolioRebalancing;
import drr.standards.iso.RiskReductionTechniqueEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(TypeOfPTRRTechniqueRule.TypeOfPTRRTechniqueRuleDefault.class)
public abstract class TypeOfPTRRTechniqueRule implements ReportFunction<TransactionReportInstruction, RiskReductionTechniqueEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected IsCompressed isCompressed;
	@Inject protected IsPortfolioRebalancing isPortfolioRebalancing;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public RiskReductionTechniqueEnum evaluate(TransactionReportInstruction input) {
		RiskReductionTechniqueEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract RiskReductionTechniqueEnum doEvaluate(TransactionReportInstruction input);

	public static class TypeOfPTRRTechniqueRuleDefault extends TypeOfPTRRTechniqueRule {
		@Override
		protected RiskReductionTechniqueEnum doEvaluate(TransactionReportInstruction input) {
			RiskReductionTechniqueEnum output = null;
			return assignOutput(output, input);
		}
		
		protected RiskReductionTechniqueEnum assignOutput(RiskReductionTechniqueEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableAction.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(item -> {
					final Boolean boolean0 = isCompressed.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get());
					if ((boolean0 == null ? false : boolean0)) {
						if (areEqual(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Instruction>mapC("getInstruction", businessEvent -> businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction()).<ExecutionInstruction>map("getExecution", primitiveInstruction -> primitiveInstruction.getExecution()).<PartyRole>mapC("getPartyRoles", executionInstruction -> executionInstruction.getPartyRoles()).<PartyRoleEnum>map("getRole", partyRole -> partyRole.getRole()), MapperS.of(PartyRoleEnum.PTRR_SERVICE_PROVIDER), CardinalityOperator.Any).getOrDefault(false)) {
							return MapperS.of(RiskReductionTechniqueEnum.PWAS);
						}
						return MapperS.of(RiskReductionTechniqueEnum.PWOS);
					}
					final Boolean boolean1 = isPortfolioRebalancing.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).get());
					if ((boolean1 == null ? false : boolean1)) {
						return MapperS.of(RiskReductionTechniqueEnum.PRBM);
					}
					return MapperS.<RiskReductionTechniqueEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
