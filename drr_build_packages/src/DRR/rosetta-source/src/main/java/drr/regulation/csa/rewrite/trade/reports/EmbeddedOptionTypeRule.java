package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import javax.inject.Inject;


@ImplementedBy(EmbeddedOptionTypeRule.EmbeddedOptionTypeRuleDefault.class)
public abstract class EmbeddedOptionTypeRule implements ReportFunction<TransactionReportInstruction, EmbeddedOptionTypeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.contract.reports.EmbeddedOptionTypeRule embeddedOptionTypeRule;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;

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
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(embeddedOptionTypeRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
