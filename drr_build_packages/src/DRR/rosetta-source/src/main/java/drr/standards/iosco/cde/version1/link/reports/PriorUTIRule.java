package drr.standards.iosco.cde.version1.link.reports;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.TradeIdentifierTypeEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.PositionEventIntentEnum;
import cdm.event.common.PositionIdentifier;
import cdm.event.common.Trade;
import cdm.event.common.TradeIdentifier;
import cdm.event.position.CounterpartyPosition;
import cdm.event.qualification.functions.Qualify_Compression;
import cdm.event.workflow.WorkflowStep;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.functions.BeforeTradeForEvent;
import drr.base.trade.functions.TradeForEvent;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(PriorUTIRule.PriorUTIRuleDefault.class)
public abstract class PriorUTIRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected BeforeTradeForEvent beforeTradeForEvent;
	@Inject protected Qualify_Compression qualify_Compression;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class PriorUTIRuleDefault extends PriorUTIRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final FieldWithMetaString fieldWithMetaString = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent())).andNullSafe(areEqual(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<PositionEventIntentEnum>map("getIntent", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getIntent()), MapperS.of(PositionEventIntentEnum.CORPORATE_ACTION_ADJUSTMENT), CardinalityOperator.All).orNullSafe(areEqual(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<PositionEventIntentEnum>map("getIntent", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getIntent()), MapperS.of(PositionEventIntentEnum.TRANSFER), CardinalityOperator.All)).andNullSafe(notEqual(item.<CounterpartyPositionState>map("getReportablePosition", transactionReportInstructionBase -> transactionReportInstructionBase.getReportablePosition()).<CounterpartyPosition>map("getCounterpartyPosition", counterpartyPositionState -> counterpartyPositionState.getCounterpartyPosition()).<TradableProduct>map("getPositionBase", counterpartyPosition -> counterpartyPosition.getPositionBase()).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).orNullSafe(areEqual(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<PositionEventIntentEnum>map("getIntent", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getIntent()), MapperS.of(PositionEventIntentEnum.OPTION_EXERCISE), CardinalityOperator.All).andNullSafe(exists(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<CounterpartyPositionState>mapC("getAfter", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getAfter()).<CounterpartyPosition>map("getCounterpartyPosition", counterpartyPositionState -> counterpartyPositionState.getCounterpartyPosition()).<TradableProduct>map("getPositionBase", counterpartyPosition -> counterpartyPosition.getPositionBase()).<NonTransferableProduct>map("getProduct", tradableProduct -> tradableProduct.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()))))).getOrDefault(false)) {
						final MapperS<PositionIdentifier> thenArg0 = item
							.mapSingleToItem(_item -> _item.<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<PositionIdentifier>map("getCounterpartyPositionPriorUTI", reportableInformationBase -> reportableInformationBase.getCounterpartyPositionPriorUTI()));
						final MapperS<PositionIdentifier> thenArg1 = thenArg0
							.filterSingleNullSafe(_item -> areEqual(_item.<TradeIdentifierTypeEnum>map("getIdentifierType", positionIdentifier -> positionIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
						final MapperC<FieldWithMetaString> thenArg2 = thenArg1
							.mapSingleToList(_item -> _item.<AssignedIdentifier>mapC("getAssignedIdentifier", positionIdentifier -> positionIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
						return MapperS.of(thenArg2.get());
					}
					if (notEqual(MapperS.of(tradeForEvent.evaluate(item.get())).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue()), MapperS.of(beforeTradeForEvent.evaluate(item.get())).<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()).<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()).<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString.getValue()), CardinalityOperator.Any).andNullSafe(areEqual(MapperS.of(qualify_Compression.evaluate(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstructionBase -> transactionReportInstructionBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).get())), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
						final MapperS<Trade> thenArg3 = MapperS.of(beforeTradeForEvent.evaluate(item.get()));
						final MapperC<TradeIdentifier> thenArg4 = thenArg3
							.mapSingleToList(_item -> _item.<TradeIdentifier>mapC("getTradeIdentifier", trade -> trade.getTradeIdentifier()));
						final MapperC<TradeIdentifier> thenArg5 = thenArg4
							.filterItemNullSafe(_item -> areEqual(_item.<TradeIdentifierTypeEnum>map("getIdentifierType", tradeIdentifier -> tradeIdentifier.getIdentifierType()), MapperS.of(TradeIdentifierTypeEnum.UNIQUE_TRANSACTION_IDENTIFIER), CardinalityOperator.All).get());
						final MapperListOfLists<FieldWithMetaString> thenArg6 = thenArg5
							.mapItemToList(_item -> _item.<AssignedIdentifier>mapC("getAssignedIdentifier", tradeIdentifier -> tradeIdentifier.getAssignedIdentifier()).<FieldWithMetaString>map("getIdentifier", assignedIdentifier -> assignedIdentifier.getIdentifier()));
						final MapperC<FieldWithMetaString> thenArg7 = thenArg6
							.flattenList();
						final MapperC<FieldWithMetaString> thenArg8 = distinctIgnoringPrecision(thenArg7);
						return MapperS.of(thenArg8.get());
					}
					return MapperS.<FieldWithMetaString>ofNull();
				}).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
