package drr.base.qualification.event.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.ReportableActionEnum;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportableInformationBase;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsActionTypeREVI.IsActionTypeREVIDefault.class)
public abstract class IsActionTypeREVI implements RosettaFunction {

	/**
	* @param reportableEvent 
	* @return isActionTypeRevi 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isActionTypeRevi = doEvaluate(reportableEvent);
		
		return isActionTypeRevi;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<ReportableActionEnum> action(ReportableEventBase reportableEvent);

	public static class IsActionTypeREVIDefault extends IsActionTypeREVI {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isActionTypeRevi = null;
			return assignOutput(isActionTypeRevi, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isActionTypeRevi, ReportableEventBase reportableEvent) {
			isActionTypeRevi = exists(action(reportableEvent)).andNullSafe(areEqual(action(reportableEvent), MapperS.of(ReportableActionEnum.REVIVE), CardinalityOperator.All)).get();
			
			return isActionTypeRevi;
		}
		
		@Override
		protected MapperS<ReportableActionEnum> action(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).<ReportableActionEnum>map("getReportableAction", reportableInformationBase -> reportableInformationBase.getReportableAction());
		}
	}
}
