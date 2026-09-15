package drr.regulation.sec.rewrite.dtcc.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(DTCC_OtherPaymentPayerIDTypeRule.DTCC_OtherPaymentPayerIDTypeRuleDefault.class)
public abstract class DTCC_OtherPaymentPayerIDTypeRule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_OtherPaymentPayerIDTypeRule dTCC_OtherPaymentPayerIDTypeRule;
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<String> evaluate(TransactionReportInstruction input) {
		List<String> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<String> doEvaluate(TransactionReportInstruction input);

	public static class DTCC_OtherPaymentPayerIDTypeRuleDefault extends DTCC_OtherPaymentPayerIDTypeRule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = thenArg
				.mapSingleToList(item -> MapperC.<String>of(dTCC_OtherPaymentPayerIDTypeRule.evaluate(item.get()))).getMulti();
			
			return output;
		}
	}
}
