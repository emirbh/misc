package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.datetime.reports.FixingDateRule;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(FixingDateLeg1Rule.FixingDateLeg1RuleDefault.class)
public abstract class FixingDateLeg1Rule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FixingDateRule fixingDateRule;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(TransactionReportInstruction input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(TransactionReportInstruction input);

	public static class FixingDateLeg1RuleDefault extends FixingDateLeg1Rule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = MapperS.of(fixingDateRule.evaluate(payoutLeg1Rule.evaluate(thenArg.get()))).get();
			
			return output;
		}
	}
}
