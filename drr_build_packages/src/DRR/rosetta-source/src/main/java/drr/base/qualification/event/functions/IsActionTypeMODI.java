package drr.base.qualification.event.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.ActionEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.common.Instruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.TermsChangeInstruction;
import cdm.event.common.TradeIdentifier;
import cdm.event.common.TradeState;
import cdm.event.common.functions.FilterOpenTradeStates;
import cdm.event.common.functions.QuantityDecreased;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.qualification.functions.Qualify_CorporateActionDetermined;
import cdm.event.qualification.functions.Qualify_CreditEventDetermined;
import cdm.event.qualification.functions.Qualify_Exercise;
import cdm.event.qualification.functions.Qualify_Increase;
import cdm.event.qualification.functions.Qualify_IndexTransition;
import cdm.event.workflow.WorkflowStep;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.event.ReportableActionEnum;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.functions.BeforeTradeForEvent;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.base.trade.functions.TradeStateForEvent;
import java.util.Collections;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsActionTypeMODI.IsActionTypeMODIDefault.class)
public abstract class IsActionTypeMODI implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected BeforeTradeForEvent beforeTradeForEvent;
	@Inject protected FilterOpenTradeStates filterOpenTradeStates;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsProductETD isProductETD;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected Qualify_CorporateActionDetermined qualify_CorporateActionDetermined;
	@Inject protected Qualify_CreditEventDetermined qualify_CreditEventDetermined;
	@Inject protected Qualify_Exercise qualify_Exercise;
	@Inject protected Qualify_Increase qualify_Increase;
	@Inject protected Qualify_IndexTransition qualify_IndexTransition;
	@Inject protected QuantityDecreased quantityDecreased;
	@Inject protected TradeForEvent tradeForEvent;
	@Inject protected TradeStateForEvent tradeStateForEvent;

	/**
	* @param reportableEvent 
	* @return result 
	*/
	public Boolean evaluate(ReportableEventBase reportableEvent) {
		Boolean result = doEvaluate(reportableEvent);
		
		return result;
	}

	protected abstract Boolean doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends BusinessEvent> businessEvent(ReportableEventBase reportableEvent);

	protected abstract MapperC<? extends PrimitiveInstruction> primitiveInstruction(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends ReferenceWithMetaTradeState> beforeTradeState(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends TradeState> afterTradeStateOpen(ReportableEventBase reportableEvent);

	protected abstract MapperC<? extends FieldWithMetaString> prevUTI(ReportableEventBase reportableEvent);

	protected abstract MapperC<? extends FieldWithMetaString> currUTI(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<ReportableActionEnum> reportableAction(ReportableEventBase reportableEvent);

	public static class IsActionTypeMODIDefault extends IsActionTypeMODI {
		@Override
		protected Boolean doEvaluate(ReportableEventBase reportableEvent) {
			Boolean result = null;
			return assignOutput(result, reportableEvent);
		}
		
		protected Boolean assignOutput(Boolean result, ReportableEventBase reportableEvent) {
			if (areEqual(MapperS.of(isProductETD.evaluate(product(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(notExists(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()))).getOrDefault(false)) {
				if (notEqual(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<ActionEnum>map("getAction", workflowStep -> workflowStep.getAction()), MapperS.of(ActionEnum.CORRECT), CardinalityOperator.Any).andNullSafe(notEqual(reportableAction(reportableEvent), MapperS.of(ReportableActionEnum.ERROR), CardinalityOperator.Any)).andNullSafe(areEqual(MapperS.of(isActionTypeTERM.evaluate(reportableEvent)), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
					if (areEqual(reportableAction(reportableEvent), MapperS.of(ReportableActionEnum.MODIFICATION), CardinalityOperator.All).getOrDefault(false)) {
						result = true;
					} else if (areEqual(businessEvent(reportableEvent).<EventIntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent()), MapperS.of(EventIntentEnum.CONTRACT_TERMS_AMENDMENT), CardinalityOperator.All).getOrDefault(false)) {
						result = true;
					} else {
						final ReferenceWithMetaTradeState referenceWithMetaTradeState = beforeTradeState(reportableEvent).get();
						if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Exercise.evaluate(businessEvent(reportableEvent).get()))).orNullSafe(areEqual(MapperC.<EventIntentEnum>of(MapperS.of(EventIntentEnum.OPTION_EXERCISE), MapperS.of(EventIntentEnum.OPTIONAL_EXTENSION), MapperS.of(EventIntentEnum.OPTIONAL_CANCELLATION), MapperS.of(EventIntentEnum.CORPORATE_ACTION_ADJUSTMENT), MapperS.of(EventIntentEnum.CREDIT_EVENT), MapperS.of(EventIntentEnum.DECREASE), MapperS.of(EventIntentEnum.INDEX_TRANSITION)), businessEvent(reportableEvent).<EventIntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent()), CardinalityOperator.Any)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CorporateActionDetermined.evaluate(businessEvent(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditEventDetermined.evaluate(businessEvent(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(quantityDecreased.evaluate((referenceWithMetaTradeState == null ? null : referenceWithMetaTradeState.getValue()), afterTradeStateOpen(reportableEvent).getMulti())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_IndexTransition.evaluate(businessEvent(reportableEvent).get())))).getOrDefault(false)) {
							if (exists(prevUTI(reportableEvent)).andNullSafe(areEqual(prevUTI(reportableEvent).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), currUTI(reportableEvent).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()), CardinalityOperator.All)).getOrDefault(false)) {
								result = true;
							} else {
								result = false;
							}
						} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Increase.evaluate(businessEvent(reportableEvent).get()))).orNullSafe(areEqual(businessEvent(reportableEvent).<EventIntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent()), MapperS.of(EventIntentEnum.INCREASE), CardinalityOperator.All)).getOrDefault(false)) {
							result = true;
						} else if (exists(primitiveInstruction(reportableEvent).<TermsChangeInstruction>map("getTermsChange", _primitiveInstruction -> _primitiveInstruction.getTermsChange())).getOrDefault(false)) {
							result = true;
						} else if (areEqual(reportableAction(reportableEvent), MapperS.of(ReportableActionEnum.UPDATE), CardinalityOperator.All).getOrDefault(false)) {
							result = true;
						} else {
							result = false;
						}
					}
				} else {
					result = false;
				}
			} else {
				result = false;
			}
			
			return result;
		}
		
		@Override
		protected MapperS<? extends BusinessEvent> businessEvent(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent());
		}
		
		@Override
		protected MapperC<? extends PrimitiveInstruction> primitiveInstruction(ReportableEventBase reportableEvent) {
			return businessEvent(reportableEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<PrimitiveInstruction>map("getPrimitiveInstruction", instruction -> instruction.getPrimitiveInstruction());
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaTradeState> beforeTradeState(ReportableEventBase reportableEvent) {
			return MapperS.of(businessEvent(reportableEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).get());
		}
		
		@Override
		protected MapperS<? extends TradeState> afterTradeStateOpen(ReportableEventBase reportableEvent) {
			final TradeState tradeState = tradeStateForEvent.evaluate(reportableEvent);
			return MapperS.of(MapperC.of(filterOpenTradeStates.evaluate((tradeState == null ? Collections.<TradeState>emptyList() : Collections.singletonList(tradeState)))).get());
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> prevUTI(ReportableEventBase reportableEvent) {
			final MapperC<TradeIdentifier> thenArg0 = MapperS.of(beforeTradeForEvent.evaluate(reportableEvent)).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
			final MapperS<TradeIdentifier> thenArg1 = MapperS.of(distinctIgnoringPrecision(thenArg0).get());
			return thenArg1
				.mapSingleToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
		}
		
		@Override
		protected MapperC<? extends FieldWithMetaString> currUTI(ReportableEventBase reportableEvent) {
			final MapperC<TradeIdentifier> thenArg0 = MapperS.of(tradeForEvent.evaluate(reportableEvent)).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
			final MapperS<TradeIdentifier> thenArg1 = MapperS.of(distinctIgnoringPrecision(thenArg0).get());
			return thenArg1
				.mapSingleToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForTrade.evaluate(tradeForEvent.evaluate(reportableEvent)));
		}
		
		@Override
		protected MapperS<ReportableActionEnum> reportableAction(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<ReportableInformationBase>map("getReportableInformation", reportableEventBase -> reportableEventBase.getReportableInformation()).<ReportableActionEnum>map("getReportableAction", reportableInformationBase -> reportableInformationBase.getReportableAction());
		}
	}
}
