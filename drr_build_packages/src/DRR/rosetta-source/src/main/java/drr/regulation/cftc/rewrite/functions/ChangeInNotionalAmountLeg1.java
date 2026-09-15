package drr.regulation.cftc.rewrite.functions;

import cdm.base.math.functions.Abs;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Trade;
import cdm.event.qualification.functions.Qualify_ContractFormation;
import cdm.event.qualification.functions.Qualify_Execution;
import cdm.event.workflow.WorkflowStep;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.functions.IsActionTypeNEWT;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.functions.BeforeTradeForEvent;
import drr.regulation.cftc.rewrite.trade.reports.EventTypeRule;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.functions.PayoutFromProductLeg1;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg1Rule;
import drr.standards.iosco.cde.version2.quantity.functions.NotionalAmountFormat;
import drr.standards.iso.EventTypeEnum;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ChangeInNotionalAmountLeg1.ChangeInNotionalAmountLeg1Default.class)
public abstract class ChangeInNotionalAmountLeg1 implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected BeforeTradeForEvent beforeTradeForEvent;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected IsActionTypeNEWT isActionTypeNEWT;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
	@Inject protected NotionalAmountFormat notionalAmountFormat;
	@Inject protected PayoutForQuantityLeg1Rule payoutForQuantityLeg1Rule;
	@Inject protected PayoutFromProductLeg1 payoutFromProductLeg1;
	@Inject protected Qualify_ContractFormation qualify_ContractFormation;
	@Inject protected Qualify_Execution qualify_Execution;

	/**
	* @param transactionReportInstruction 
	* @param defaultValue 
	* @return change 
	*/
	public BigDecimal evaluate(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue) {
		BigDecimal change = doEvaluate(transactionReportInstruction, defaultValue);
		
		return change;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue);

	protected abstract MapperS<? extends BusinessEvent> businessEvent(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue);

	protected abstract MapperS<? extends PayoutLegWithAuxiliary> payoutBefore(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue);

	protected abstract MapperS<BigDecimal> NotionalAmountBefore(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue);

	protected abstract MapperS<BigDecimal> NotionalAmountAfter(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue);

	public static class ChangeInNotionalAmountLeg1Default extends ChangeInNotionalAmountLeg1 {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue) {
			BigDecimal change = null;
			return assignOutput(change, transactionReportInstruction, defaultValue);
		}
		
		protected BigDecimal assignOutput(BigDecimal change, TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue) {
			if (areEqual(NotionalAmountBefore(transactionReportInstruction, defaultValue), MapperS.of(defaultValue), CardinalityOperator.All).orNullSafe(areEqual(NotionalAmountAfter(transactionReportInstruction, defaultValue), MapperS.of(defaultValue), CardinalityOperator.All)).getOrDefault(false)) {
				change = defaultValue;
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(transactionReportInstruction))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeNEWT.evaluate(transactionReportInstruction))).andNullSafe(areEqual(MapperS.of(eventTypeRule.evaluate(transactionReportInstruction)), MapperS.of(EventTypeEnum.TRAD), CardinalityOperator.All)).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ContractFormation.evaluate(businessEvent(transactionReportInstruction, defaultValue).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Execution.evaluate(businessEvent(transactionReportInstruction, defaultValue).get())))))).getOrDefault(false)) {
				change = NotionalAmountAfter(transactionReportInstruction, defaultValue).get();
			} else {
				change = abs.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(NotionalAmountAfter(transactionReportInstruction, defaultValue), NotionalAmountBefore(transactionReportInstruction, defaultValue)).get());
			}
			
			return change;
		}
		
		@Override
		protected MapperS<? extends BusinessEvent> businessEvent(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue) {
			return MapperS.of(transactionReportInstruction).<WorkflowStep>map("getOriginatingWorkflowStep", _transactionReportInstruction -> _transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent());
		}
		
		@Override
		protected MapperS<? extends PayoutLegWithAuxiliary> payoutBefore(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue) {
			final MapperS<Trade> thenArg = MapperS.of(beforeTradeForEvent.evaluate(transactionReportInstruction));
			return thenArg
				.mapSingleToItem(item -> MapperS.of(payoutFromProductLeg1.evaluate(item.<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get(), item.<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get(), MapperS.of(transactionReportInstruction).<ReportableInformationBase>map("getReportableInformation", _transactionReportInstruction -> _transactionReportInstruction.getReportableInformation()).get())));
		}
		
		@Override
		protected MapperS<BigDecimal> NotionalAmountBefore(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue) {
			return MapperS.of(notionalAmountFormat.evaluate(payoutBefore(transactionReportInstruction, defaultValue).get(), defaultValue));
		}
		
		@Override
		protected MapperS<BigDecimal> NotionalAmountAfter(TransactionReportInstruction transactionReportInstruction, BigDecimal defaultValue) {
			return MapperS.of(notionalAmountFormat.evaluate(payoutForQuantityLeg1Rule.evaluate(transactionReportInstruction), defaultValue));
		}
	}
}
