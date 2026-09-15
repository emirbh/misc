package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.standards.iosco.cde.version2.price.reports.FixedRateRule;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FixedRateLeg2Rule.FixedRateLeg2RuleDefault.class)
public abstract class FixedRateLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FixedRateRule fixedRateRule;
	@Inject protected InterestRateLeg2 interestRateLeg2;
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

	public static class FixedRateLeg2RuleDefault extends FixedRateLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = MapperS.of(fixedRateRule.evaluate(interestRateLeg2.evaluate(productForEvent.evaluate(thenArg.get())))).get();
			
			return output;
		}
	}
}
