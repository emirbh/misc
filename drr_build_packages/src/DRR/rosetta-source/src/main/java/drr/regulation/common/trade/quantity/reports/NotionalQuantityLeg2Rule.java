package drr.regulation.common.trade.quantity.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.product.functions.IsCommodity;
import drr.base.qualification.product.functions.IsEquity;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(NotionalQuantityLeg2Rule.NotionalQuantityLeg2RuleDefault.class)
public abstract class NotionalQuantityLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsCommodity isCommodity;
	@Inject protected IsEquity isEquity;
	@Inject protected NotionalQuantityRule notionalQuantityRule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
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
			if (ComparisonResult.ofNullSafe(MapperS.of(isEquity.evaluate(productForEvent.evaluate(input)))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCommodity.evaluate(productForEvent.evaluate(input))))).getOrDefault(false)) {
				output = notionalQuantityRule.evaluate(payoutLeg2Rule.evaluate(input));
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
