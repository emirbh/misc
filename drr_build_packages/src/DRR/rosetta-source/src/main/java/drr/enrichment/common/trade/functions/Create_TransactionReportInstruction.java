package drr.enrichment.common.trade.functions;

import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TransactionReportInstruction.Create_TransactionReportInstructionDefault.class)
public abstract class Create_TransactionReportInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableEvent 
	* @param reportingSide 
	* @return transactionReportInstruction 
	*/
	public TransactionReportInstruction evaluate(ReportableEvent reportableEvent, ReportingSide reportingSide) {
		TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstructionBuilder = doEvaluate(reportableEvent, reportingSide);
		
		final TransactionReportInstruction transactionReportInstruction;
		if (transactionReportInstructionBuilder == null) {
			transactionReportInstruction = null;
		} else {
			transactionReportInstruction = transactionReportInstructionBuilder.build();
			objectValidator.validate(TransactionReportInstruction.class, transactionReportInstruction);
		}
		
		return transactionReportInstruction;
	}

	protected abstract TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent, ReportingSide reportingSide);

	public static class Create_TransactionReportInstructionDefault extends Create_TransactionReportInstruction {
		@Override
		protected TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent, ReportingSide reportingSide) {
			TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction = TransactionReportInstruction.builder();
			return assignOutput(transactionReportInstruction, reportableEvent, reportingSide);
		}
		
		protected TransactionReportInstruction.TransactionReportInstructionBuilder assignOutput(TransactionReportInstruction.TransactionReportInstructionBuilder transactionReportInstruction, ReportableEvent reportableEvent, ReportingSide reportingSide) {
			transactionReportInstruction = toBuilder(TransactionReportInstruction.builder()
				.setOriginatingWorkflowStep(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).get())
				.setReportableTrade(MapperS.of(reportableEvent).<TradeState>map("getReportableTrade", _reportableEvent -> _reportableEvent.getReportableTrade()).get())
				.setReportableInformation(MapperS.of(reportableEvent).<ReportableInformation>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get())
				.setReportablePosition(MapperS.of(reportableEvent).<CounterpartyPositionState>map("getReportablePosition", _reportableEvent -> _reportableEvent.getReportablePosition()).get())
				.setReportingSide(reportingSide)
				.build());
			
			return Optional.ofNullable(transactionReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
