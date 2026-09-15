package drr.regulation.common.trade.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;


@ImplementedBy(IntragroupRule.IntragroupRuleDefault.class)
public abstract class IntragroupRule implements ReportFunction<TransactionReportInstruction, Boolean> {

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

	public static class IntragroupRuleDefault extends IntragroupRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			output = MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<Boolean>map("getIntragroup", reportableInformation -> reportableInformation.getIntragroup()).get();
			
			return output;
		}
	}
}
