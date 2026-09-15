package drr.regulation.csa.rewrite.dtcc.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.standards.iso.OptionStyleEnum;
import javax.inject.Inject;


@ImplementedBy(DTCC_OptionStyleRule.DTCC_OptionStyleRuleDefault.class)
public abstract class DTCC_OptionStyleRule implements ReportFunction<TransactionReportInstruction, OptionStyleEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.dtcc.trade.reports.DTCC_OptionStyleRule dTCC_OptionStyleRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public OptionStyleEnum evaluate(TransactionReportInstruction input) {
		OptionStyleEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract OptionStyleEnum doEvaluate(TransactionReportInstruction input);

	public static class DTCC_OptionStyleRuleDefault extends DTCC_OptionStyleRule {
		@Override
		protected OptionStyleEnum doEvaluate(TransactionReportInstruction input) {
			OptionStyleEnum output = null;
			return assignOutput(output, input);
		}
		
		protected OptionStyleEnum assignOutput(OptionStyleEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(dTCC_OptionStyleRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
