package drr.base.qualification.event.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.ReportableActionEnum;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportableInformationBase;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsEventTypeUPDT.IsEventTypeUPDTDefault.class)
public abstract class IsEventTypeUPDT implements RosettaFunction {

	/**
	* @param reportableEvent 
	* @return isEventTypeUpdt 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isEventTypeUpdt = doEvaluate(reportableEvent);
		
		return isEventTypeUpdt;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<ReportableActionEnum> event(ReportableEventBase reportableEvent);

	public static class IsEventTypeUPDTDefault extends IsEventTypeUPDT {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isEventTypeUpdt = null;
			return assignOutput(isEventTypeUpdt, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isEventTypeUpdt, ReportableEventBase reportableEvent) {
			isEventTypeUpdt = exists(event(reportableEvent)).andNullSafe(areEqual(event(reportableEvent), MapperS.of(ReportableActionEnum.UPDATE), CardinalityOperator.All)).get();
			
			return isEventTypeUpdt;
		}
		
		@Override
		protected MapperS<ReportableActionEnum> event(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).<ReportableActionEnum>map("getReportableAction", reportableInformationBase -> reportableInformationBase.getReportableAction());
		}
	}
}
