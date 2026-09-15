package drr.regulation.sec.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg1Rule;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import drr.standards.iosco.cde.version2.quantity.functions.NotionalAmountFormat;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(NotionalAmountLeg1Rule.NotionalAmountLeg1RuleDefault.class)
public abstract class NotionalAmountLeg1Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
	@Inject protected NotionalAmountFormat notionalAmountFormat;
	@Inject protected PayoutForQuantityLeg1Rule payoutForQuantityLeg1Rule;

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

	public static class NotionalAmountLeg1RuleDefault extends NotionalAmountLeg1Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(notionalAmountFormat.evaluate(payoutForQuantityLeg1Rule.evaluate(item.get()), new BigDecimal("99999999999999999999.99999")))).get();
			
			return output;
		}
	}
}
