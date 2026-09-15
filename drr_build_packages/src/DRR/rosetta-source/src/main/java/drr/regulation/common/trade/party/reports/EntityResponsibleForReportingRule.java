package drr.regulation.common.trade.party.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.ExtractPartyResponsibleForReportingIdentifier;
import javax.inject.Inject;


@ImplementedBy(EntityResponsibleForReportingRule.EntityResponsibleForReportingRuleDefault.class)
public abstract class EntityResponsibleForReportingRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyResponsibleForReportingIdentifier extractPartyResponsibleForReportingIdentifier;

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

	public static class EntityResponsibleForReportingRuleDefault extends EntityResponsibleForReportingRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = extractPartyResponsibleForReportingIdentifier.evaluate(MapperS.of(input).<ReportingSide>map("getReportingSide", transactionReportInstruction -> transactionReportInstruction.getReportingSide()).get());
			
			return output;
		}
	}
}
