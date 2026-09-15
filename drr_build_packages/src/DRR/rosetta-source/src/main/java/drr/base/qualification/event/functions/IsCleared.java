package drr.base.qualification.event.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.qualification.functions.Qualify_ClearedTrade;
import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.EventTimestampQualificationEnum;
import cdm.event.workflow.WorkflowState;
import cdm.event.workflow.WorkflowStatusEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsCleared.IsClearedDefault.class)
public abstract class IsCleared implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IntendedToClear intendedToClear;
	@Inject protected Qualify_ClearedTrade qualify_ClearedTrade;

	/**
	* @param originatingWorkflowStep 
	* @return result 
	*/
	public Boolean evaluate(WorkflowStep originatingWorkflowStep) {
		Boolean result = doEvaluate(originatingWorkflowStep);
		
		return result;
	}

	protected abstract Boolean doEvaluate(WorkflowStep originatingWorkflowStep);

	public static class IsClearedDefault extends IsCleared {
		@Override
		protected Boolean doEvaluate(WorkflowStep originatingWorkflowStep) {
			Boolean result = null;
			return assignOutput(result, originatingWorkflowStep);
		}
		
		protected Boolean assignOutput(Boolean result, WorkflowStep originatingWorkflowStep) {
			result = areEqual(MapperS.of(originatingWorkflowStep).<WorkflowState>map("getWorkflowState", workflowStep -> workflowStep.getWorkflowState()).<WorkflowStatusEnum>map("getWorkflowStatus", workflowState -> workflowState.getWorkflowStatus()), MapperS.of(WorkflowStatusEnum.CLEARED), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(originatingWorkflowStep).<EventTimestamp>mapC("getTimestamp", workflowStep -> workflowStep.getTimestamp()).<EventTimestampQualificationEnum>map("getQualification", eventTimestamp -> eventTimestamp.getQualification()), MapperS.of(EventTimestampQualificationEnum.CLEARING_DATE_TIME), CardinalityOperator.Any).orNullSafe(areEqual(MapperS.of(qualify_ClearedTrade.evaluate(MapperS.of(originatingWorkflowStep).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).get())), MapperS.of(true), CardinalityOperator.All)).orNullSafe(areEqual(MapperS.of(originatingWorkflowStep).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.CLEARING), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(intendedToClear.evaluate(originatingWorkflowStep)), MapperS.of(false), CardinalityOperator.All))).get();
			
			return result;
		}
	}
}
