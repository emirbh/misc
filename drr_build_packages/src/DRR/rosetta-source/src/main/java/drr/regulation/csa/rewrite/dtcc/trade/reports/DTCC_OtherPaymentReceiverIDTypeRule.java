package drr.regulation.csa.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(DTCC_OtherPaymentReceiverIDTypeRule.DTCC_OtherPaymentReceiverIDTypeRuleDefault.class)
public abstract class DTCC_OtherPaymentReceiverIDTypeRule implements ReportFunction<TransactionReportInstruction, List<String>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_OtherPaymentReceiverIDTypeRule dTCC_OtherPaymentReceiverIDTypeRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

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

	public static class DTCC_OtherPaymentReceiverIDTypeRuleDefault extends DTCC_OtherPaymentReceiverIDTypeRule {
		@Override
		protected List<String> doEvaluate(TransactionReportInstruction input) {
			List<String> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<String> assignOutput(List<String> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToList(item -> MapperC.<String>of(dTCC_OtherPaymentReceiverIDTypeRule.evaluate(item.get()))).getMulti();
			
			return output;
		}
	}
}
