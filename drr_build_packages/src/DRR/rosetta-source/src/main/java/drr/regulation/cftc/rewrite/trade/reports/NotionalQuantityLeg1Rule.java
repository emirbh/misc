package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.trade.functions.ProductForTrade;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NotionalQuantityLeg1Rule.NotionalQuantityLeg1RuleDefault.class)
public abstract class NotionalQuantityLeg1Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
	@Inject protected IsEquity isEquity;
	@Inject protected drr.regulation.common.trade.quantity.reports.NotionalQuantityLeg1Rule notionalQuantityLeg1Rule;
	@Inject protected ProductForTrade productForTrade;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstruction input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstruction input);

	public static class NotionalQuantityLeg1RuleDefault extends NotionalQuantityLeg1Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			final MapperS<BigDecimal> ifThenElseResult;
			if (areEqual(MapperS.of(isEquity.evaluate(productForTrade.evaluate(tradeForEvent.evaluate(thenArg.get())))), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(notionalQuantityLeg1Rule.evaluate(thenArg.get()));
			} else {
				ifThenElseResult = MapperS.<BigDecimal>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
