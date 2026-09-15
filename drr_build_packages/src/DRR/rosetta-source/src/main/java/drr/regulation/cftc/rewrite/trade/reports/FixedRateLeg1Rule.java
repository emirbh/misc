package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.InterestRateLeg1;
import drr.standards.iosco.cde.version2.price.reports.FixedRateRule;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FixedRateLeg1Rule.FixedRateLeg1RuleDefault.class)
public abstract class FixedRateLeg1Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FixedRateRule fixedRateRule;
	@Inject protected InterestRateLeg1 interestRateLeg1;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;
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

	public static class FixedRateLeg1RuleDefault extends FixedRateLeg1Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = MapperS.of(fixedRateRule.evaluate(interestRateLeg1.evaluate(productForEvent.evaluate(thenArg.get())))).get();
			
			return output;
		}
	}
}
