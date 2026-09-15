package drr.base.qualification.event.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportableEventBase;
import javax.inject.Inject;


@ImplementedBy(IsAllowableAction.IsAllowableActionDefault.class)
public abstract class IsAllowableAction implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeCORR isActionTypeCORR;
	@Inject protected IsActionTypeMODI isActionTypeMODI;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypePOSC isActionTypePOSC;
	@Inject protected IsActionTypePositionMODI isActionTypePositionMODI;
	@Inject protected IsActionTypeREVI isActionTypeREVI;

	/**
	* @param reportableEvent 
	* @return isAllowableAction 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isAllowableAction = doEvaluate(reportableEvent);
		
		return isAllowableAction;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	public static class IsAllowableActionDefault extends IsAllowableAction {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isAllowableAction = null;
			return assignOutput(isAllowableAction, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isAllowableAction, ReportableEventBase reportableEvent) {
			isAllowableAction = ComparisonResult.ofNullSafe(MapperS.of(isActionTypeNEWT.evaluate(reportableEvent))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeMODI.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePositionMODI.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeCORR.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeREVI.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePOSC.evaluate(reportableEvent)))).get();
			
			return isAllowableAction;
		}
	}
}
