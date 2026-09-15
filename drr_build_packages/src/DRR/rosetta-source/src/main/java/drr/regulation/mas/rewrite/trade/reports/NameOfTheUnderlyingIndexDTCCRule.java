package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.underlier.reports.NameOfTheUnderlyingIndexRule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import javax.inject.Inject;


@ImplementedBy(NameOfTheUnderlyingIndexDTCCRule.NameOfTheUnderlyingIndexDTCCRuleDefault.class)
public abstract class NameOfTheUnderlyingIndexDTCCRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected NameOfTheUnderlyingIndexRule nameOfTheUnderlyingIndexRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class NameOfTheUnderlyingIndexDTCCRuleDefault extends NameOfTheUnderlyingIndexDTCCRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			output = MapperS.of(nameOfTheUnderlyingIndexRule.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
