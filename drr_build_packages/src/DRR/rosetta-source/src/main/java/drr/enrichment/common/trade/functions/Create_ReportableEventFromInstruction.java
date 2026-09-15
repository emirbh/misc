package drr.enrichment.common.trade.functions;

import cdm.event.common.ActionEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.workflow.EventInstruction;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.functions.Create_AcceptedWorkflowStepFromInstruction;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.ReportableActionEnum;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_ReportableEventFromInstruction.Create_ReportableEventFromInstructionDefault.class)
public abstract class Create_ReportableEventFromInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_AcceptedWorkflowStepFromInstruction create_AcceptedWorkflowStepFromInstruction;

	/**
	* @param reportableEvent 
	* @return enrichedReportableEvent 
	*/
	public ReportableEvent evaluate(ReportableEvent reportableEvent) {
		ReportableEvent.ReportableEventBuilder enrichedReportableEventBuilder = doEvaluate(reportableEvent);
		
		final ReportableEvent enrichedReportableEvent;
		if (enrichedReportableEventBuilder == null) {
			enrichedReportableEvent = null;
		} else {
			enrichedReportableEvent = enrichedReportableEventBuilder.build();
			objectValidator.validate(ReportableEvent.class, enrichedReportableEvent);
		}
		
		return enrichedReportableEvent;
	}

	protected abstract ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent);

	public static class Create_ReportableEventFromInstructionDefault extends Create_ReportableEventFromInstruction {
		@Override
		protected ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent) {
			ReportableEvent.ReportableEventBuilder enrichedReportableEvent = ReportableEvent.builder();
			return assignOutput(enrichedReportableEvent, reportableEvent);
		}
		
		protected ReportableEvent.ReportableEventBuilder assignOutput(ReportableEvent.ReportableEventBuilder enrichedReportableEvent, ReportableEvent reportableEvent) {
			enrichedReportableEvent = toBuilder(reportableEvent, () -> ReportableEvent.builder());
			
			final ReportableActionEnum ifThenElseResult0;
			if (areEqual(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).<ActionEnum>map("getAction", workflowStep -> workflowStep.getAction()), MapperS.of(ActionEnum.CANCEL), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = ReportableActionEnum.ERROR;
			} else {
				ifThenElseResult0 = MapperS.of(reportableEvent).<ReportableInformation>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).<ReportableActionEnum>map("getReportableAction", reportableInformation -> reportableInformation.getReportableAction()).get();
			}
			enrichedReportableEvent
				.getOrCreateReportableInformation()
				.setReportableAction(ifThenElseResult0);
			
			final ActionEnum ifThenElseResult1;
			if (areEqual(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).<ActionEnum>map("getAction", workflowStep -> workflowStep.getAction()), MapperS.of(ActionEnum.CANCEL), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = ActionEnum.NEW;
			} else {
				ifThenElseResult1 = MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).<ActionEnum>map("getAction", workflowStep -> workflowStep.getAction()).get();
			}
			enrichedReportableEvent
				.getOrCreateOriginatingWorkflowStep()
				.setAction(ifThenElseResult1);
			
			final WorkflowStep ifThenElseResult2;
			if (notExists(MapperS.of(enrichedReportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent())).andNullSafe(exists(MapperS.of(enrichedReportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).<EventInstruction>map("getProposedEvent", workflowStep -> workflowStep.getProposedEvent()))).getOrDefault(false)) {
				ifThenElseResult2 = create_AcceptedWorkflowStepFromInstruction.evaluate(MapperS.of(enrichedReportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).get());
			} else {
				ifThenElseResult2 = MapperS.of(enrichedReportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).get();
			}
			enrichedReportableEvent
				.setOriginatingWorkflowStep(ifThenElseResult2);
			
			return Optional.ofNullable(enrichedReportableEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
