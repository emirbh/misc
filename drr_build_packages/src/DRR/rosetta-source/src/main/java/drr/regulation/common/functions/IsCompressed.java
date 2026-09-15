package drr.regulation.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.qualification.functions.Qualify_Compression;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsCompressed.IsCompressedDefault.class)
public abstract class IsCompressed implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_Compression qualify_Compression;

	/**
	* @param originatingWorkflowStep 
	* @return result 
	*/
	public Boolean evaluate(WorkflowStep originatingWorkflowStep) {
		Boolean result = doEvaluate(originatingWorkflowStep);
		
		return result;
	}

	protected abstract Boolean doEvaluate(WorkflowStep originatingWorkflowStep);

	public static class IsCompressedDefault extends IsCompressed {
		@Override
		protected Boolean doEvaluate(WorkflowStep originatingWorkflowStep) {
			Boolean result = null;
			return assignOutput(result, originatingWorkflowStep);
		}
		
		protected Boolean assignOutput(Boolean result, WorkflowStep originatingWorkflowStep) {
			result = areEqual(MapperS.of(qualify_Compression.evaluate(MapperS.of(originatingWorkflowStep).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).get())), MapperS.of(true), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(originatingWorkflowStep).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.COMPRESSION), CardinalityOperator.All)).get();
			
			return result;
		}
	}
}
