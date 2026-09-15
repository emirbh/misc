package drr.base.trade.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.event.qualification.functions.Qualify_Compression;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(BeforeTradeForEvent.BeforeTradeForEventDefault.class)
public abstract class BeforeTradeForEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BeforeTradeByUTI beforeTradeByUTI;
	@Inject protected Qualify_Compression qualify_Compression;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @return reportableTrade 
	*/
	public Trade evaluate(ReportableEventBase reportableEvent) {
		Trade.TradeBuilder reportableTradeBuilder = doEvaluate(reportableEvent);
		
		final Trade reportableTrade;
		if (reportableTradeBuilder == null) {
			reportableTrade = null;
		} else {
			reportableTrade = reportableTradeBuilder.build();
			objectValidator.validate(Trade.class, reportableTrade);
		}
		
		return reportableTrade;
	}

	protected abstract Trade.TradeBuilder doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends BusinessEvent> businessEvent(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends FieldWithMetaString> afterTradeUTI(ReportableEventBase reportableEvent);

	public static class BeforeTradeForEventDefault extends BeforeTradeForEvent {
		@Override
		protected Trade.TradeBuilder doEvaluate(ReportableEventBase reportableEvent) {
			Trade.TradeBuilder reportableTrade = Trade.builder();
			return assignOutput(reportableTrade, reportableEvent);
		}
		
		protected Trade.TradeBuilder assignOutput(Trade.TradeBuilder reportableTrade, ReportableEventBase reportableEvent) {
			if (areEqual(MapperS.of(qualify_Compression.evaluate(businessEvent(reportableEvent).get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString = afterTradeUTI(reportableEvent).get();
				reportableTrade = toBuilder(beforeTradeByUTI.evaluate(reportableEvent, (fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
			} else {
				reportableTrade = toBuilder(businessEvent(reportableEvent).<Instruction>mapC("getInstruction", _businessEvent -> _businessEvent.getInstruction()).<ReferenceWithMetaTradeState>map("getBefore", instruction -> instruction.getBefore()).<TradeState>map("Type coercion", referenceWithMetaTradeState -> referenceWithMetaTradeState.getValue()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get());
			}
			
			return Optional.ofNullable(reportableTrade)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends BusinessEvent> businessEvent(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> afterTradeUTI(ReportableEventBase reportableEvent) {
			final MapperC<TradeIdentifier> thenArg0 = MapperS.of(tradeForEvent.evaluate(reportableEvent)).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
			final MapperListOfLists<FieldWithMetaString> thenArg1 = thenArg0
				.mapItemToList(item -> item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
			final MapperC<FieldWithMetaString> thenArg2 = thenArg1
				.flattenList();
			return MapperS.of(thenArg2.get());
		}
	}
}
