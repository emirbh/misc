package drr.base.qualification.event.functions;

import cdm.event.common.ActionEnum;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.workflow.WorkflowStep;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsActionTypePOSC.IsActionTypePOSCDefault.class)
public abstract class IsActionTypePOSC implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsProductETD isProductETD;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return isActionTypePosc 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean isActionTypePosc = doEvaluate(reportableEvent);
		
		return isActionTypePosc;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	public static class IsActionTypePOSCDefault extends IsActionTypePOSC {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean isActionTypePosc = null;
			return assignOutput(isActionTypePosc, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean isActionTypePosc, ReportableEventBase reportableEvent) {
			isActionTypePosc = areEqual(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<ActionEnum>map("getAction", workflowStep -> workflowStep.getAction()), MapperS.of(ActionEnum.NEW), CardinalityOperator.All).andNullSafe(notExists(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()))).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(product(reportableEvent).get())))).get();
			
			return isActionTypePosc;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForTrade.evaluate(tradeForEvent.evaluate(reportableEvent)));
		}
	}
}
