package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeTERM;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.jfsa.rewrite.trade.functions.IsAllowableActionForJFSA;
import java.time.ZonedDateTime;
import javax.inject.Inject;


@ImplementedBy(ClearingReceiptTimestampRule.ClearingReceiptTimestampRuleDefault.class)
public abstract class ClearingReceiptTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.datetime.reports.ClearingReceiptTimestampRule clearingReceiptTimestampRule;
	@Inject protected IsActionTypeTERM isActionTypeTERM;
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

	public static class ClearingReceiptTimestampRuleDefault extends ClearingReceiptTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(TransactionReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForJFSA.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isActionTypeTERM.evaluate(item.get())))).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(clearingReceiptTimestampRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
