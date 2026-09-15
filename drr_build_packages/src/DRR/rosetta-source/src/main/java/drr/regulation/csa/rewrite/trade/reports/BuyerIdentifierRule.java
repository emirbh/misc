package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.standards.iosco.cde.version3.party.reports.Direction1BuyerIdentifierRule;
import javax.inject.Inject;


@ImplementedBy(BuyerIdentifierRule.BuyerIdentifierRuleDefault.class)
public abstract class BuyerIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Direction1BuyerIdentifierRule direction1BuyerIdentifierRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

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

	public static class BuyerIdentifierRuleDefault extends BuyerIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(direction1BuyerIdentifierRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
