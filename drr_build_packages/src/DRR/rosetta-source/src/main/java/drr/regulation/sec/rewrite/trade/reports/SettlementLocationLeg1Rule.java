package drr.regulation.sec.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.execution.reports.SettlementLocationRule;
import drr.regulation.sec.rewrite.trade.functions.IsAllowableActionForSEC;
import javax.inject.Inject;


@ImplementedBy(SettlementLocationLeg1Rule.SettlementLocationLeg1RuleDefault.class)
public abstract class SettlementLocationLeg1Rule implements ReportFunction<TransactionReportInstruction, ISOCountryCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForSEC isAllowableActionForSEC;
	@Inject protected SettlementLocationRule settlementLocationRule;

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

	public static class SettlementLocationLeg1RuleDefault extends SettlementLocationLeg1Rule {
		@Override
		protected ISOCountryCodeEnum doEvaluate(TransactionReportInstruction input) {
			ISOCountryCodeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ISOCountryCodeEnum assignOutput(ISOCountryCodeEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForSEC.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> MapperS.of(settlementLocationRule.evaluate(item.get()))).get();
			
			return output;
		}
	}
}
