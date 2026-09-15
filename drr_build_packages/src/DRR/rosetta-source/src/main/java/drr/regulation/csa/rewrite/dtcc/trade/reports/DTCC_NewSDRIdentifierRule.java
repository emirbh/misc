package drr.regulation.csa.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypePRTO;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.link.reports.NewSDRIdentifierRule;
import javax.inject.Inject;


@ImplementedBy(DTCC_NewSDRIdentifierRule.DTCC_NewSDRIdentifierRuleDefault.class)
public abstract class DTCC_NewSDRIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypePRTO isActionTypePRTO;
	@Inject protected NewSDRIdentifierRule newSDRIdentifierRule;

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

	public static class DTCC_NewSDRIdentifierRuleDefault extends DTCC_NewSDRIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isActionTypePRTO.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(newSDRIdentifierRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
