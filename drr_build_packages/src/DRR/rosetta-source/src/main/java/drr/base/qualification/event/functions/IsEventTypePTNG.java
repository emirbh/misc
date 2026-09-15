package drr.base.qualification.event.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.ReportableActionEnum;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportableInformationBase;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsEventTypePTNG.IsEventTypePTNGDefault.class)
public abstract class IsEventTypePTNG implements RosettaFunction {

	/**
	* @param reportableEvent 
	* @return isEventTypePtng 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isEventTypePtng = doEvaluate(reportableEvent);
		
		return isEventTypePtng;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<ReportableActionEnum> event(ReportableEventBase reportableEvent);

	public static class IsEventTypePTNGDefault extends IsEventTypePTNG {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isEventTypePtng = null;
			return assignOutput(isEventTypePtng, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isEventTypePtng, ReportableEventBase reportableEvent) {
			isEventTypePtng = exists(event(reportableEvent)).andNullSafe(areEqual(event(reportableEvent), MapperS.of(ReportableActionEnum.TRANSFER_IN), CardinalityOperator.All)).get();
			
			return isEventTypePtng;
		}
		
		@Override
		protected MapperS<ReportableActionEnum> event(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).<ReportableActionEnum>map("getReportableAction", reportableInformationBase -> reportableInformationBase.getReportableAction());
		}
	}
}
