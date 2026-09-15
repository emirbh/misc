package drr.standards.iosco.cde.version3.event.reports;

import cdm.event.common.BusinessEvent;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.common.Instruction;
import cdm.event.common.PositionEventIntentEnum;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.QuantityChangeInstruction;
import cdm.event.common.TransferInstruction;
import cdm.event.qualification.functions.Qualify_Allocation;
import cdm.event.qualification.functions.Qualify_ClearedTrade;
import cdm.event.qualification.functions.Qualify_Compression;
import cdm.event.qualification.functions.Qualify_ContractFormation;
import cdm.event.qualification.functions.Qualify_CorporateActionDetermined;
import cdm.event.qualification.functions.Qualify_CreditEventDetermined;
import cdm.event.qualification.functions.Qualify_Exercise;
import cdm.event.qualification.functions.Qualify_FullReturn;
import cdm.event.qualification.functions.Qualify_Increase;
import cdm.event.qualification.functions.Qualify_IndexTransition;
import cdm.event.qualification.functions.Qualify_Novation;
import cdm.event.qualification.functions.Qualify_PartialNovation;
import cdm.event.qualification.functions.Qualify_PartialTermination;
import cdm.event.qualification.functions.Qualify_PortfolioRebalancing;
import cdm.event.qualification.functions.Qualify_Reallocation;
import cdm.event.qualification.functions.Qualify_Renegotiation;
import cdm.event.qualification.functions.Qualify_Termination;
import cdm.event.workflow.WorkflowState;
import cdm.event.workflow.WorkflowStatusEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeCORR;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypeMODI;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsActionTypePOSC;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.base.qualification.event.functions.IsActionTypePositionMODI;
import drr.base.qualification.event.functions.IsActionTypeREVI;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.event.functions.IsActionTypeVALU;
import drr.base.qualification.event.functions.IsEventTypePTNG;
import drr.base.qualification.event.functions.IsEventTypeUPDT;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iso.EventTypeEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EventTypeRule.EventTypeRuleDefault.class)
public abstract class EventTypeRule implements ReportFunction<TransactionReportInstructionBase, EventTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeCORR isActionTypeCORR;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypeMODI isActionTypeMODI;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypePOSC isActionTypePOSC;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsActionTypePositionMODI isActionTypePositionMODI;
	@Inject protected IsActionTypeREVI isActionTypeREVI;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsActionTypeVALU isActionTypeVALU;
	@Inject protected IsEventTypePTNG isEventTypePTNG;
	@Inject protected IsEventTypeUPDT isEventTypeUPDT;
	@Inject protected Qualify_Allocation qualify_Allocation;
	@Inject protected Qualify_ClearedTrade qualify_ClearedTrade;
	@Inject protected Qualify_Compression qualify_Compression;
	@Inject protected Qualify_ContractFormation qualify_ContractFormation;
	@Inject protected Qualify_CorporateActionDetermined qualify_CorporateActionDetermined;
	@Inject protected Qualify_CreditEventDetermined qualify_CreditEventDetermined;
	@Inject protected Qualify_Exercise qualify_Exercise;
	@Inject protected Qualify_FullReturn qualify_FullReturn;
	@Inject protected Qualify_Increase qualify_Increase;
	@Inject protected Qualify_IndexTransition qualify_IndexTransition;
	@Inject protected Qualify_Novation qualify_Novation;
	@Inject protected Qualify_PartialNovation qualify_PartialNovation;
	@Inject protected Qualify_PartialTermination qualify_PartialTermination;
	@Inject protected Qualify_PortfolioRebalancing qualify_PortfolioRebalancing;
	@Inject protected Qualify_Reallocation qualify_Reallocation;
	@Inject protected Qualify_Renegotiation qualify_Renegotiation;
	@Inject protected Qualify_Termination qualify_Termination;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public EventTypeEnum evaluate(TransactionReportInstructionBase input) {
		EventTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract EventTypeEnum doEvaluate(TransactionReportInstructionBase input);

	public static class EventTypeRuleDefault extends EventTypeRule {
		@Override
		protected EventTypeEnum doEvaluate(TransactionReportInstructionBase input) {
			EventTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected EventTypeEnum assignOutput(EventTypeEnum output, TransactionReportInstructionBase input) {
			final MapperS<TransactionReportInstructionBase> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isActionTypeNEWT.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeMODI.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePositionMODI.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(reportableEvent -> {
					if (areEqual(MapperS.of(isActionTypeCORR.evaluate(thenArg.get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypeEROR.evaluate(thenArg.get())), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isActionTypeREVI.evaluate(thenArg.get())), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isActionTypePOSC.evaluate(thenArg.get())), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isActionTypeVALU.evaluate(thenArg.get())), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
						return thenArg.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep())
							.mapSingleToItem(workflowStep -> {
								if (exists(workflowStep.<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent())).getOrDefault(false)) {
									return workflowStep.<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent())
										.mapSingleToItem(item -> {
											if (ComparisonResult.ofNullSafe(MapperS.of(isEventTypePTNG.evaluate(reportableEvent.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePRTO.evaluate(reportableEvent.get())))).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.PTNG);
											}
											final Boolean boolean0 = isEventTypeUPDT.evaluate(reportableEvent.get());
											if ((boolean0 == null ? false : boolean0)) {
												return MapperS.of(EventTypeEnum.UPDT);
											}
											if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Novation.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_PartialNovation.evaluate(item.get())))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.NOVATION), CardinalityOperator.All)).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.NOVA);
											}
											if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Allocation.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Reallocation.evaluate(item.get())))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.ALLOCATION), CardinalityOperator.All)).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.ALOC);
											}
											if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Exercise.evaluate(item.get()))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.OPTION_EXERCISE), CardinalityOperator.All)).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.EXER);
											}
											if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ClearedTrade.evaluate(item.get()))).orNullSafe(areEqual(reportableEvent.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<WorkflowState>map("getWorkflowState", _workflowStep -> _workflowStep.getWorkflowState()).<WorkflowStatusEnum>map("getWorkflowStatus", workflowState -> workflowState.getWorkflowStatus()), MapperS.of(WorkflowStatusEnum.CLEARED), CardinalityOperator.All)).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.CLEARING), CardinalityOperator.All)).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.CLRG);
											}
											if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Compression.evaluate(item.get()))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.COMPRESSION), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_PortfolioRebalancing.evaluate(item.get())))).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.COMP);
											}
											if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Termination.evaluate(item.get()))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.EARLY_TERMINATION_PROVISION), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_PartialTermination.evaluate(item.get())))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.DECREASE), CardinalityOperator.All)).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.ETRM);
											}
											if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditEventDetermined.evaluate(item.get()))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.CREDIT_EVENT), CardinalityOperator.All)).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.CREV);
											}
											if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CorporateActionDetermined.evaluate(item.get()))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.CORPORATE_ACTION_ADJUSTMENT), CardinalityOperator.All)).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.CORP);
											}
											if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ContractFormation.evaluate(item.get()))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.INCREASE), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Increase.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Renegotiation.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_IndexTransition.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_FullReturn.evaluate(item.get())))).orNullSafe(exists(item.<Instruction>mapC("getInstruction", businessEvent -> businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction()).<QuantityChangeInstruction>map("getQuantityChange", primitiveInstruction -> primitiveInstruction.getQuantityChange()))).orNullSafe(exists(item.<Instruction>mapC("getInstruction", businessEvent -> businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction()).<TransferInstruction>map("getTransfer", primitiveInstruction -> primitiveInstruction.getTransfer()))).orNullSafe(areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.CONTRACT_TERMS_AMENDMENT), CardinalityOperator.All)).getOrDefault(false)) {
												return MapperS.of(EventTypeEnum.TRAD);
											}
											final Boolean boolean1 = isActionTypeMODI.evaluate(reportableEvent.get());
											if ((boolean1 == null ? false : boolean1)) {
												return MapperS.<EventTypeEnum>ofNull();
											}
											return MapperS.<EventTypeEnum>ofNull();
										});
								}
								if (exists(workflowStep.<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", _workflowStep -> _workflowStep.getCounterpartyPositionBusinessEvent())).getOrDefault(false)) {
									if (areEqual(workflowStep.<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", _workflowStep -> _workflowStep.getCounterpartyPositionBusinessEvent()).<PositionEventIntentEnum>map("getIntent", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getIntent()), MapperS.of(PositionEventIntentEnum.OPTION_EXERCISE), CardinalityOperator.All).getOrDefault(false)) {
										return MapperS.of(EventTypeEnum.EXER);
									}
									if (areEqual(workflowStep.<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", _workflowStep -> _workflowStep.getCounterpartyPositionBusinessEvent()).<PositionEventIntentEnum>map("getIntent", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getIntent()), MapperS.of(PositionEventIntentEnum.TRANSFER), CardinalityOperator.All).getOrDefault(false)) {
										return MapperS.of(EventTypeEnum.NOVA);
									}
									if (areEqual(workflowStep.<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", _workflowStep -> _workflowStep.getCounterpartyPositionBusinessEvent()).<PositionEventIntentEnum>map("getIntent", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getIntent()), MapperS.of(PositionEventIntentEnum.CORPORATE_ACTION_ADJUSTMENT), CardinalityOperator.All).getOrDefault(false)) {
										return MapperS.of(EventTypeEnum.CORP);
									}
									return MapperS.of(EventTypeEnum.INCP);
								}
								return MapperS.<EventTypeEnum>ofNull();
							});
					}
					return MapperS.<EventTypeEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
