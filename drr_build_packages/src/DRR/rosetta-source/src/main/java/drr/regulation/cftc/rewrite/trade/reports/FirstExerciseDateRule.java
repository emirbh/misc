package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;


@ImplementedBy(FirstExerciseDateRule.FirstExerciseDateRuleDefault.class)
public abstract class FirstExerciseDateRule implements ReportFunction<TransactionReportInstruction, Date> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version3.price.reports.FirstExerciseDateRule firstExerciseDateRule;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(TransactionReportInstruction input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(TransactionReportInstruction input);

	public static class FirstExerciseDateRuleDefault extends FirstExerciseDateRule {
		@Override
		protected Date doEvaluate(TransactionReportInstruction input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(firstExerciseDateRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
