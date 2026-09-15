package drr.regulation.common.valuation.event.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ValuationReportInstruction;
import drr.standards.iso.ReportLevelEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(LevelRule.LevelRuleDefault.class)
public abstract class LevelRule implements ReportFunction<ValuationReportInstruction, ReportLevelEnum> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ReportLevelEnum evaluate(ValuationReportInstruction input) {
		ReportLevelEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ReportLevelEnum doEvaluate(ValuationReportInstruction input);

	public static class LevelRuleDefault extends LevelRule {
		@Override
		protected ReportLevelEnum doEvaluate(ValuationReportInstruction input) {
			ReportLevelEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ReportLevelEnum assignOutput(ReportLevelEnum output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<ReportLevelEnum>map("getLevel", valuationReportInstruction -> valuationReportInstruction.getLevel())).getOrDefault(false)) {
						return item.<ReportLevelEnum>map("getLevel", valuationReportInstruction -> valuationReportInstruction.getLevel());
					}
					return MapperS.<ReportLevelEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
