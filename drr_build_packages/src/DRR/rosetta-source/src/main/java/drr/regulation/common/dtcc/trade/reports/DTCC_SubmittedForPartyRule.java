package drr.regulation.common.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.cde.version3.party.reports.Counterparty1Rule;
import javax.inject.Inject;


@ImplementedBy(DTCC_SubmittedForPartyRule.DTCC_SubmittedForPartyRuleDefault.class)
public abstract class DTCC_SubmittedForPartyRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Counterparty1Rule counterparty1Rule;

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

	public static class DTCC_SubmittedForPartyRuleDefault extends DTCC_SubmittedForPartyRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(counterparty1Rule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
