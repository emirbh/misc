package drr.regulation.common.trade.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractReportSubmittingPartyIdentifier;
import javax.inject.Inject;


@ImplementedBy(ReportSubmittingEntityRule.ReportSubmittingEntityRuleDefault.class)
public abstract class ReportSubmittingEntityRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractReportSubmittingPartyIdentifier extractReportSubmittingPartyIdentifier;

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

	public static class ReportSubmittingEntityRuleDefault extends ReportSubmittingEntityRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(extractReportSubmittingPartyIdentifier.evaluate(item.<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).get()))).get();
			
			return output;
		}
	}
}
