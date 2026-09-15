package drr.base.qualification.event.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.ReportableActionEnum;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportableInformationBase;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsActionTypePRTO.IsActionTypePRTODefault.class)
public abstract class IsActionTypePRTO implements RosettaFunction {

	/**
	* @param reportableEvent 
	* @return isActionTypePrto 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isActionTypePrto = doEvaluate(reportableEvent);
		
		return isActionTypePrto;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<ReportableActionEnum> action(ReportableEventBase reportableEvent);

	public static class IsActionTypePRTODefault extends IsActionTypePRTO {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isActionTypePrto = null;
			return assignOutput(isActionTypePrto, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isActionTypePrto, ReportableEventBase reportableEvent) {
			isActionTypePrto = exists(action(reportableEvent)).andNullSafe(areEqual(action(reportableEvent), MapperS.of(ReportableActionEnum.TRANSFER_OUT), CardinalityOperator.All)).get();
			
			return isActionTypePrto;
		}
		
		@Override
		protected MapperS<ReportableActionEnum> action(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).<ReportableActionEnum>map("getReportableAction", reportableInformationBase -> reportableInformationBase.getReportableAction());
		}
	}
}
