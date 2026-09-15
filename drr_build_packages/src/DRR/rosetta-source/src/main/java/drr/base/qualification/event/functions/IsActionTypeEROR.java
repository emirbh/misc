package drr.base.qualification.event.functions;

import cdm.event.common.ActionEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.ReportableActionEnum;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportableInformationBase;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsActionTypeEROR.IsActionTypeERORDefault.class)
public abstract class IsActionTypeEROR implements RosettaFunction {

	/**
	* @param reportableEvent 
	* @return isActionTypeEror 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isActionTypeEror = doEvaluate(reportableEvent);
		
		return isActionTypeEror;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<ActionEnum> workflowStepAction(ReportableEventBase reportableEvent);

	protected abstract MapperS<ReportableActionEnum> reportingAction(ReportableEventBase reportableEvent);

	public static class IsActionTypeERORDefault extends IsActionTypeEROR {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isActionTypeEror = null;
			return assignOutput(isActionTypeEror, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isActionTypeEror, ReportableEventBase reportableEvent) {
			isActionTypeEror = exists(reportingAction(reportableEvent)).andNullSafe(areEqual(reportingAction(reportableEvent), MapperS.of(ReportableActionEnum.ERROR), CardinalityOperator.All)).get();
			
			return isActionTypeEror;
		}
		
		@Override
		protected MapperS<ActionEnum> workflowStepAction(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<ActionEnum>map("getAction", workflowStep -> workflowStep.getAction());
		}
		
		@Override
		protected MapperS<ReportableActionEnum> reportingAction(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).<ReportableActionEnum>map("getReportableAction", reportableInformationBase -> reportableInformationBase.getReportableAction());
		}
	}
}
