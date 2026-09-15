package drr.base.qualification.event.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.qualification.functions.Qualify_ValuationUpdate;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import javax.inject.Inject;


@ImplementedBy(IsActionTypeVALU.IsActionTypeVALUDefault.class)
public abstract class IsActionTypeVALU implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Qualify_ValuationUpdate qualify_ValuationUpdate;

	/**
	* @param reportableEvent 
	* @return isActionTypeValu 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isActionTypeValu = doEvaluate(reportableEvent);
		
		return isActionTypeValu;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	public static class IsActionTypeVALUDefault extends IsActionTypeVALU {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isActionTypeValu = null;
			return assignOutput(isActionTypeValu, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isActionTypeValu, ReportableEventBase reportableEvent) {
			isActionTypeValu = qualify_ValuationUpdate.evaluate(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).get());
			
			return isActionTypeValu;
		}
	}
}
