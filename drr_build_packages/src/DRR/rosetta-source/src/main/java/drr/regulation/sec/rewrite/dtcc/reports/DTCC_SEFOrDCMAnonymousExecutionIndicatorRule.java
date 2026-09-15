package drr.regulation.sec.rewrite.dtcc.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.functions.DTCC_SEFOrDCMAnonymousExecutionIndicator;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import javax.inject.Inject;


@ImplementedBy(DTCC_SEFOrDCMAnonymousExecutionIndicatorRule.DTCC_SEFOrDCMAnonymousExecutionIndicatorRuleDefault.class)
public abstract class DTCC_SEFOrDCMAnonymousExecutionIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected DTCC_SEFOrDCMAnonymousExecutionIndicator dTCC_SEFOrDCMAnonymousExecutionIndicator;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;

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
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(dTCC_SEFOrDCMAnonymousExecutionIndicator.evaluate(item.get(), SupervisoryBodyEnum.SEC))).get();
			
			return output;
		}
	}
}
