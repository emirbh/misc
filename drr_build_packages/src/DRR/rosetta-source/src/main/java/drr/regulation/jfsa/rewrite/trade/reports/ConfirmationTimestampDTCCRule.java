package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.datetime.reports.ConfirmationTimestampRule;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ConfirmationTimestampDTCCRule.ConfirmationTimestampDTCCRuleDefault.class)
public abstract class ConfirmationTimestampDTCCRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ConfirmationTimestampRule confirmationTimestampRule;
	@Inject protected IsAllowableActionForJFSA isAllowableActionForJFSA;

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

	public static class ConfirmationTimestampDTCCRuleDefault extends ConfirmationTimestampDTCCRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForJFSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(confirmationTimestampRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
