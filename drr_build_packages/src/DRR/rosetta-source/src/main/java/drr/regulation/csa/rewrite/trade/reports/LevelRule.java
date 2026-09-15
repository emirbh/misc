package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.standards.iso.ReportLevelEnum;
import javax.inject.Inject;


@ImplementedBy(LevelRule.LevelRuleDefault.class)
public abstract class LevelRule implements ReportFunction<TransactionReportInstruction, ReportLevelEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected drr.standards.iosco.cde.version3.event.reports.LevelRule levelRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ReportLevelEnum evaluate(TransactionReportInstruction input) {
		ReportLevelEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ReportLevelEnum doEvaluate(TransactionReportInstruction input);

	public static class LevelRuleDefault extends LevelRule {
		@Override
		protected ReportLevelEnum doEvaluate(TransactionReportInstruction input) {
			ReportLevelEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ReportLevelEnum assignOutput(ReportLevelEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(levelRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
