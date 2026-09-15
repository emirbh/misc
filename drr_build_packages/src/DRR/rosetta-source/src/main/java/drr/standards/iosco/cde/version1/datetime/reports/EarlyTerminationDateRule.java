package drr.standards.iosco.cde.version1.datetime.reports;

import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.TradeState;
import cdm.event.common.functions.QuantityDecreasedToZero;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import javax.inject.Inject;


@ImplementedBy(EarlyTerminationDateRule.EarlyTerminationDateRuleDefault.class)
public abstract class EarlyTerminationDateRule implements ReportFunction<TransactionReportInstructionBase, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected QuantityDecreasedToZero quantityDecreasedToZero;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstructionBase input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstructionBase input);

	public static class EarlyTerminationDateRuleDefault extends EarlyTerminationDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstructionBase input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					final Boolean _boolean = quantityDecreasedToZero.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Instruction>mapC("getInstruction", businessEvent -> businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState.getValue()).getMulti(), item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<TradeState>mapC("getAfter", businessEvent -> businessEvent.getAfter()).getMulti());
					if ((_boolean == null ? false : _boolean)) {
						return item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Date>map("getEffectiveDate", businessEvent -> businessEvent.getEffectiveDate());
					}
					return MapperS.<Date>ofNull();
				}).get();
			
			return output;
		}
	}
}
