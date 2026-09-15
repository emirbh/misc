package drr.regulation.cftc.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.functions.IsActionTypeCORR;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypeMODI;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.base.qualification.event.functions.IsActionTypePositionMODI;
import drr.base.qualification.event.functions.IsActionTypeREVI;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.trade.ReportableEventBase;
import javax.inject.Inject;


@ImplementedBy(IsAllowableActionForCFTC.IsAllowableActionForCFTCDefault.class)
public abstract class IsAllowableActionForCFTC implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeCORR isActionTypeCORR;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypeMODI isActionTypeMODI;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsActionTypePositionMODI isActionTypePositionMODI;
	@Inject protected IsActionTypeREVI isActionTypeREVI;
	@Inject protected IsActionTypeTERM isActionTypeTERM;

	/**
	* @param reportableEvent 
	* @return isAllowableAction 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isAllowableAction = doEvaluate(reportableEvent);
		
		return isAllowableAction;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	public static class IsAllowableActionForCFTCDefault extends IsAllowableActionForCFTC {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isAllowableAction = null;
			return assignOutput(isAllowableAction, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isAllowableAction, ReportableEventBase reportableEvent) {
			isAllowableAction = ComparisonResult.ofNullSafe(MapperS.of(isActionTypeNEWT.evaluate(reportableEvent))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeMODI.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePositionMODI.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeCORR.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeREVI.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeEROR.evaluate(reportableEvent)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypePRTO.evaluate(reportableEvent)))).get();
			
			return isAllowableAction;
		}
	}
}
