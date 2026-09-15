package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.execution.functions.Extract_TradingCapacity;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import drr.standards.iso.TradingCapacity7Code;
import javax.inject.Inject;


@ImplementedBy(TradingCapacityRule.TradingCapacityRuleDefault.class)
public abstract class TradingCapacityRule implements ReportFunction<TransactionReportInstruction, TradingCapacity7Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Extract_TradingCapacity extract_TradingCapacity;
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;

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

	public static class TradingCapacityRuleDefault extends TradingCapacityRule {
		@Override
		protected TradingCapacity7Code doEvaluate(TransactionReportInstruction input) {
			TradingCapacity7Code output = null;
			return assignOutput(output, input);
		}
		
		protected TradingCapacity7Code assignOutput(TradingCapacity7Code output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(extract_TradingCapacity.evaluate(item.get(), SupervisoryBodyEnum.HKMA))).get();
			
			return output;
		}
	}
}
