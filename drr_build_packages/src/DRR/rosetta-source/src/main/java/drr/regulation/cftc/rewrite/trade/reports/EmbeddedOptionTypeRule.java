package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.cftc.rewrite.trade.functions.IsAllowableActionForCFTC;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import javax.inject.Inject;


@ImplementedBy(EmbeddedOptionTypeRule.EmbeddedOptionTypeRuleDefault.class)
public abstract class EmbeddedOptionTypeRule implements ReportFunction<TransactionReportInstruction, EmbeddedOptionTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.contract.reports.EmbeddedOptionTypeRule embeddedOptionTypeRule;
	@Inject protected IsAllowableActionForCFTC isAllowableActionForCFTC;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public EmbeddedOptionTypeEnum evaluate(TransactionReportInstruction input) {
		EmbeddedOptionTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract EmbeddedOptionTypeEnum doEvaluate(TransactionReportInstruction input);

	public static class EmbeddedOptionTypeRuleDefault extends EmbeddedOptionTypeRule {
		@Override
		protected EmbeddedOptionTypeEnum doEvaluate(TransactionReportInstruction input) {
			EmbeddedOptionTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected EmbeddedOptionTypeEnum assignOutput(EmbeddedOptionTypeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCFTC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(embeddedOptionTypeRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
