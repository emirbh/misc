package drr.regulation.mas.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.execution.functions.Extract_TradingCapacity;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import drr.standards.iso.TradingCapacity7Code;
import javax.inject.Inject;


@ImplementedBy(TradingCapacityOfSpecifiedPersonRule.TradingCapacityOfSpecifiedPersonRuleDefault.class)
public abstract class TradingCapacityOfSpecifiedPersonRule implements ReportFunction<TransactionReportInstruction, TradingCapacity7Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Extract_TradingCapacity extract_TradingCapacity;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public TradingCapacity7Code evaluate(TransactionReportInstruction input) {
		TradingCapacity7Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract TradingCapacity7Code doEvaluate(TransactionReportInstruction input);

	public static class TradingCapacityOfSpecifiedPersonRuleDefault extends TradingCapacityOfSpecifiedPersonRule {
		@Override
		protected TradingCapacity7Code doEvaluate(TransactionReportInstruction input) {
			TradingCapacity7Code output = null;
			return assignOutput(output, input);
		}
		
		protected TradingCapacity7Code assignOutput(TradingCapacity7Code output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(extract_TradingCapacity.evaluate(item.get(), SupervisoryBodyEnum.MAS))).get();
			
			return output;
		}
	}
}
