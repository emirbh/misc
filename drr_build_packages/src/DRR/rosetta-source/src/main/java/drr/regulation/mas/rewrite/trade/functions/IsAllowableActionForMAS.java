package drr.regulation.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.functions.IsActionTypeCORR;
import drr.base.qualification.event.functions.IsActionTypeMODI;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsActionTypePOSC;
import drr.base.qualification.event.functions.IsActionTypePositionMODI;
import drr.base.qualification.event.functions.IsActionTypeREVI;
import drr.base.trade.ReportableEventBase;
import javax.inject.Inject;


@ImplementedBy(IsAllowableActionForMAS.IsAllowableActionForMASDefault.class)
public abstract class IsAllowableActionForMAS implements RosettaFunction {
	
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

	public static class IsAllowableActionForMASDefault extends IsAllowableActionForMAS {
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
