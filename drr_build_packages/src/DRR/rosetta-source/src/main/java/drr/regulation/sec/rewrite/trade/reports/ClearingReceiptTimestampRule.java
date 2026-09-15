package drr.regulation.sec.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeEROR;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import java.time.ZonedDateTime;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ClearingReceiptTimestampRule.ClearingReceiptTimestampRuleDefault.class)
public abstract class ClearingReceiptTimestampRule implements ReportFunction<TransactionReportInstruction, ZonedDateTime> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.datetime.reports.ClearingReceiptTimestampRule clearingReceiptTimestampRule;
	@Inject protected IsActionTypeEROR isActionTypeEROR;
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;

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
				.filterSingleNullSafe(item -> ComparisonResult.ofNullSafe(MapperS.of(isAllowableActionForSEC.evaluate(item.get()))).andNullSafe(areEqual(MapperS.of(isActionTypeEROR.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(isActionTypePRTO.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All))).get());
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(clearingReceiptTimestampRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
