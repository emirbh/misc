package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommodity;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.quantity.reports.NotionalQuantityRule;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.PayoutLeg2;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(NotionalQuantityLeg2Rule.NotionalQuantityLeg2RuleDefault.class)
public abstract class NotionalQuantityLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected IsCommodity isCommodity;
	@Inject protected IsEquity isEquity;
	@Inject protected NotionalQuantityRule notionalQuantityRule;
	@Inject protected PayoutLeg2 payoutLeg2;
	@Inject protected ProductForEvent productForEvent;

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

	public static class NotionalQuantityLeg2RuleDefault extends NotionalQuantityLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<BigDecimal> ifThenElseResult;
			if (ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(productForEvent.evaluate(thenArg.get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommodity.evaluate(productForEvent.evaluate(thenArg.get()))))).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(notionalQuantityRule.evaluate(payoutLeg2.evaluate(thenArg.get())));
			} else {
				ifThenElseResult = MapperS.<BigDecimal>ofNull();
			}
			output = ifThenElseResult.get();
			
			return output;
		}
	}
}
