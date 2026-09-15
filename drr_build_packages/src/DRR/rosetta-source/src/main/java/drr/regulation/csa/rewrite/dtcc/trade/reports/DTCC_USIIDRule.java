package drr.regulation.csa.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.regulation.csa.rewrite.trade.functions.SupervisoryBodyForCSA;
import drr.standards.iosco.uti.functions.GetUniqueSwapIdentifier;
import javax.inject.Inject;


@ImplementedBy(DTCC_USIIDRule.DTCC_USIIDRuleDefault.class)
public abstract class DTCC_USIIDRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetUniqueSwapIdentifier getUniqueSwapIdentifier;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected SupervisoryBodyForCSA supervisoryBodyForCSA;

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

	public static class DTCC_USIIDRuleDefault extends DTCC_USIIDRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(getUniqueSwapIdentifier.evaluate(item.get(), supervisoryBodyForCSA.evaluate()))).get();
			
			return output;
		}
	}
}
