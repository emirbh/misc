package drr.enrichment.common.test.functions;

import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TransactionReportInstructionFromIngestionDefault.Create_TransactionReportInstructionFromIngestionDefaultDefault.class)
public abstract class Create_TransactionReportInstructionFromIngestionDefault implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Enrich_TransactionReportInstructionTestPackDefault enrich_TransactionReportInstructionTestPackDefault;

	/**
	* @param originatingWorkflowStep 
	* @param reportableInformation 
	* @return transactionReportInstruction 
	*/
	public TransactionReportInstruction evaluate(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation) {
		TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstructionBuilder = doEvaluate(originatingWorkflowStep, reportableInformation);
		
		final TransactionReportInstruction transactionReportInstruction;
		if (transactionReportInstructionBuilder == null) {
			transactionReportInstruction = null;
		} else {
			transactionReportInstruction = transactionReportInstructionBuilder.build();
			objectValidator.validate(TransactionReportInstruction.class, transactionReportInstruction);
		}
		
		return transactionReportInstruction;
	}

	protected abstract TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation);

	public static class Create_TransactionReportInstructionFromIngestionDefaultDefault extends Create_TransactionReportInstructionFromIngestionDefault {
		@Override
		protected TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation) {
			TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction = TransactionReportInstruction.builder();
			return assignOutput(transactionReportInstruction, originatingWorkflowStep, reportableInformation);
		}
		
		protected TransactionReportInstruction.TransactionReportInstructionBuilder assignOutput(TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction, WorkflowStep originatingWorkflowStep, ReportableInformation reportableInformation) {
			transactionReportInstruction = toBuilder(enrich_TransactionReportInstructionTestPackDefault.evaluate(ReportableEvent.builder()
				.setOriginatingWorkflowStep(originatingWorkflowStep)
				.setReportableInformation(reportableInformation)
				.build()));
			
			return Optional.ofNullable(transactionReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
