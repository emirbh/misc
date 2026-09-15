package drr.regulation.common.trade.index.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.index.functions.GetSeniority;
import drr.standards.iso.SeniorityEnum;
import javax.inject.Inject;


@ImplementedBy(SeniorityRule.SeniorityRuleDefault.class)
public abstract class SeniorityRule implements ReportFunction<TransactionReportInstruction, SeniorityEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetSeniority getSeniority;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public SeniorityEnum evaluate(TransactionReportInstruction input) {
		SeniorityEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract SeniorityEnum doEvaluate(TransactionReportInstruction input);

	public static class SeniorityRuleDefault extends SeniorityRule {
		@Override
		protected SeniorityEnum doEvaluate(TransactionReportInstruction input) {
			SeniorityEnum output = null;
			return assignOutput(output, input);
		}
		
		protected SeniorityEnum assignOutput(SeniorityEnum output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(getSeniority.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
