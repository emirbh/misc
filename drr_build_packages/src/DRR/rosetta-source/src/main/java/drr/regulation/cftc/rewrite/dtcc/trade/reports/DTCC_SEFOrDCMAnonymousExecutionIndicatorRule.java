package drr.regulation.cftc.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.functions.DTCC_SEFOrDCMAnonymousExecutionIndicator;
import javax.inject.Inject;


@ImplementedBy(DTCC_SEFOrDCMAnonymousExecutionIndicatorRule.DTCC_SEFOrDCMAnonymousExecutionIndicatorRuleDefault.class)
public abstract class DTCC_SEFOrDCMAnonymousExecutionIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DTCC_SEFOrDCMAnonymousExecutionIndicator dTCC_SEFOrDCMAnonymousExecutionIndicator;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class DTCC_SEFOrDCMAnonymousExecutionIndicatorRuleDefault extends DTCC_SEFOrDCMAnonymousExecutionIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(dTCC_SEFOrDCMAnonymousExecutionIndicator.evaluate(item.get(), SupervisoryBodyEnum.CFTC))).get();
			
			return output;
		}
	}
}
