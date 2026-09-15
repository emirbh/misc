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

@ImplementedBy(IsActionTypeCORR.IsActionTypeCORRDefault.class)
public abstract class IsActionTypeCORR implements RosettaFunction {

	/**
	* @param reportableEvent 
	* @return isActionTypeCorr 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isActionTypeCorr = doEvaluate(reportableEvent);
		
		return isActionTypeCorr;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<ActionEnum> workflowStepAction(ReportableEventBase reportableEvent);

	protected abstract MapperS<ReportableActionEnum> reportingAction(ReportableEventBase reportableEvent);

	public static class IsActionTypeCORRDefault extends IsActionTypeCORR {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isActionTypeCorr = null;
			return assignOutput(isActionTypeCorr, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isActionTypeCorr, ReportableEventBase reportableEvent) {
			isActionTypeCorr = exists(reportingAction(reportableEvent)).andNullSafe(areEqual(reportingAction(reportableEvent), MapperS.of(ReportableActionEnum.CORRECT), CardinalityOperator.All)).orNullSafe(areEqual(workflowStepAction(reportableEvent), MapperS.of(ActionEnum.CORRECT), CardinalityOperator.All)).get();
			
			return isActionTypeCorr;
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
