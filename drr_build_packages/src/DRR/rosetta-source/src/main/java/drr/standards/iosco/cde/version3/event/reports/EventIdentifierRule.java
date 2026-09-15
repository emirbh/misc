package drr.standards.iosco.cde.version3.event.reports;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.TransactionReportInstructionBase;


@ImplementedBy(EventIdentifierRule.EventIdentifierRuleDefault.class)
public abstract class EventIdentifierRule implements ReportFunction<TransactionReportInstructionBase, String> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class EventIdentifierRuleDefault extends EventIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final FieldWithMetaString fieldWithMetaString = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<Identifier>mapC("getEventIdentifier", workflowStep -> workflowStep.getEventIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", identifier -> identifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).get())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
