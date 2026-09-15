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
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsActionTypeNEWT.IsActionTypeNEWTDefault.class)
public abstract class IsActionTypeNEWT implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeMODI isActionTypeMODI;
	@Inject protected IsActionTypePOSC isActionTypePOSC;
	@Inject protected IsActionTypePositionMODI isActionTypePositionMODI;
	@Inject protected IsActionTypeTERM isActionTypeTERM;

	/**
	* @param reportableEvent 
	* @return isActionTypeNewt 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isActionTypeNewt = doEvaluate(reportableEvent);
		
		return isActionTypeNewt;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	public static class IsActionTypeNEWTDefault extends IsActionTypeNEWT {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isActionTypeNewt = null;
			return assignOutput(isActionTypeNewt, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isActionTypeNewt, ReportableEventBase reportableEvent) {
			isActionTypeNewt = areEqual(MapperS.of(isActionTypeTERM.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypeMODI.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isActionTypePositionMODI.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isActionTypePOSC.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<ActionEnum>map("getAction", workflowStep -> workflowStep.getAction()), MapperS.of(ActionEnum.NEW), CardinalityOperator.All).orNullSafe(notExists(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<ActionEnum>map("getAction", workflowStep -> workflowStep.getAction())))).andNullSafe(notExists(MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).<ReportableActionEnum>map("getReportableAction", reportableInformationBase -> reportableInformationBase.getReportableAction()))).get();
			
			return isActionTypeNewt;
		}
	}
}
