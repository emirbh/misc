package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.asic.rewrite.trade.functions.IsAllowableActionForASIC;
import drr.regulation.common.TransactionReportInstruction;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(NotionalQuantityLeg2Rule.NotionalQuantityLeg2RuleDefault.class)
public abstract class NotionalQuantityLeg2Rule implements ReportFunction<TransactionReportInstruction, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForASIC isAllowableActionForASIC;
	@Inject protected drr.regulation.common.trade.quantity.reports.NotionalQuantityLeg2Rule notionalQuantityLeg2Rule;

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
				.filterSingleNullSafe(item -> isAllowableActionForASIC.evaluate(item.get()));
			output = MapperS.of(notionalQuantityLeg2Rule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
