package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.execution.functions.PlatformIdentifier;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import java.util.Collections;
import javax.inject.Inject;


@ImplementedBy(PlatformIdentifierRule.PlatformIdentifierRuleDefault.class)
public abstract class PlatformIdentifierRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected PlatformIdentifier platformIdentifier;

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

	public static class PlatformIdentifierRuleDefault extends PlatformIdentifierRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			final SupervisoryBodyEnum supervisoryBodyEnum = SupervisoryBodyEnum.HKMA;
			output = MapperS.of(platformIdentifier.evaluate(thenArg.get(), RegimeNameEnum.HKMA, (supervisoryBodyEnum == null ? Collections.<SupervisoryBodyEnum>emptyList() : Collections.singletonList(supervisoryBodyEnum)))).get();
			
			return output;
		}
	}
}
