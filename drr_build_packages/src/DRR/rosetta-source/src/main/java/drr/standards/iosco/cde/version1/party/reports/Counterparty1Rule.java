package drr.standards.iosco.cde.version1.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.base.trade.TransactionReportInstructionBase;
import drr.standards.iosco.cde.version1.party.functions.Counterparty1FromReportingSide;
import javax.inject.Inject;


@ImplementedBy(Counterparty1Rule.Counterparty1RuleDefault.class)
public abstract class Counterparty1Rule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Counterparty1FromReportingSide counterparty1FromReportingSide;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class Counterparty1RuleDefault extends Counterparty1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(counterparty1FromReportingSide.evaluate(item.<ReportingSide>map("getReportingSide", transactionReportInstructionBase -> transactionReportInstructionBase.getReportingSide()).get()))).get();
			
			return output;
		}
	}
}
