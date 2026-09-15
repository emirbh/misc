package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutForQuantityLeg1Rule;
import drr.standards.iosco.cde.version3.quantity.functions.NotionalAmountFormat;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.inject.Inject;


@ImplementedBy(NotionalAmountLeg1Rule.NotionalAmountLeg1RuleDefault.class)
public abstract class NotionalAmountLeg1Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
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
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			final BigInteger bigInteger = new BigInteger("9999999999999999999999999");
			output = MapperS.of(notionalAmountFormat.evaluate(payoutForQuantityLeg1Rule.evaluate(thenArg.get()), (bigInteger == null ? null : new BigDecimal(bigInteger)))).get();
			
			return output;
		}
	}
}
