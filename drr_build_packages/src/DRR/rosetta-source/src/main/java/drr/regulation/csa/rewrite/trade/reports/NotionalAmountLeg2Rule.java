package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.PayoutForQuantityLeg2;
import drr.standards.iosco.cde.version3.quantity.functions.NotionalAmountFormat;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(NotionalAmountLeg2Rule.NotionalAmountLeg2RuleDefault.class)
public abstract class NotionalAmountLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected NotionalAmountFormat notionalAmountFormat;
	@Inject protected PayoutForQuantityLeg2 payoutForQuantityLeg2;

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

	public static class NotionalAmountLeg2RuleDefault extends NotionalAmountLeg2Rule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstruction input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = MapperS.of(notionalAmountFormat.evaluate(payoutForQuantityLeg2.evaluate(thenArg.get()), new BigDecimal("99999999999999999999.99999"))).get();
			
			return output;
		}
	}
}
