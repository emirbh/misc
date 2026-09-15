package drr.regulation.csa.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;


@ImplementedBy(SettlementLocationRule.SettlementLocationRuleDefault.class)
public abstract class SettlementLocationRule implements ReportFunction<TransactionReportInstruction, ISOCountryCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected drr.regulation.common.trade.execution.reports.SettlementLocationRule settlementLocationRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ISOCountryCodeEnum evaluate(TransactionReportInstruction input) {
		ISOCountryCodeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ISOCountryCodeEnum doEvaluate(TransactionReportInstruction input);

	public static class SettlementLocationRuleDefault extends SettlementLocationRule {
		@Override
		protected ISOCountryCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCountryCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCountryCodeEnum assignOutput(ISOCountryCodeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(settlementLocationRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
