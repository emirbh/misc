package drr.regulation.common.emir.reports;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.event.common.CounterpartyPositionBusinessEvent;
import cdm.event.common.CounterpartyPositionState;
import cdm.event.common.PositionEventIntentEnum;
import cdm.event.position.CounterpartyPosition;
import cdm.event.workflow.WorkflowStep;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.TradableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeCORR;
import drr.base.qualification.event.functions.IsActionTypeREVI;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.qualification.product.functions.IsProductETD;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EarlyTerminationDateRule.EarlyTerminationDateRuleDefault.class)
public abstract class EarlyTerminationDateRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.datetime.reports.EarlyTerminationDateRule earlyTerminationDateRule;
	@Inject protected IsActionTypeCORR isActionTypeCORR;
	@Inject protected IsActionTypeREVI isActionTypeREVI;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected IsProductETD isProductETD;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class EarlyTerminationDateRuleDefault extends EarlyTerminationDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isActionTypeCORR.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeREVI.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(item -> {
					if (exists(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent())).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isProductETD.evaluate(productForEvent.evaluate(item.get()))))).andNullSafe(areEqual(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<PositionEventIntentEnum>map("getIntent", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getIntent()), MapperS.of(PositionEventIntentEnum.CORPORATE_ACTION_ADJUSTMENT), CardinalityOperator.All).orNullSafe(areEqual(item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<PositionEventIntentEnum>map("getIntent", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getIntent()), MapperS.of(PositionEventIntentEnum.TRANSFER), CardinalityOperator.All))).andNullSafe(areEqual(item.<CounterpartyPositionState>map("getReportablePosition", transactionReportInstruction -> transactionReportInstruction.getReportablePosition()).<CounterpartyPosition>map("getCounterpartyPosition", counterpartyPositionState -> counterpartyPositionState.getCounterpartyPosition()).<TradableProduct>map("getPositionBase", counterpartyPosition -> counterpartyPosition.getPositionBase()).<TradeLot>mapC("getTradeLot", tradableProduct -> tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity()).<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule.getValue()).<BigDecimal>map("getValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All)).getOrDefault(false)) {
						return item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<CounterpartyPositionBusinessEvent>map("getCounterpartyPositionBusinessEvent", workflowStep -> workflowStep.getCounterpartyPositionBusinessEvent()).<Date>map("getEffectiveDate", counterpartyPositionBusinessEvent -> counterpartyPositionBusinessEvent.getEffectiveDate());
					}
					return MapperS.of(earlyTerminationDateRule.evaluate(item.get()));
				}).get();
			
			return output;
		}
	}
}
