package drr.regulation.hkma.rewrite.trade.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.hkma.rewrite.trade.functions.IsAllowableActionForHKMA;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;


@ImplementedBy(TraderLocationRule.TraderLocationRuleDefault.class)
public abstract class TraderLocationRule implements ReportFunction<TransactionReportInstruction, List<ISOCountryCodeEnum>> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableActionForHKMA isAllowableActionForHKMA;
	@Inject protected drr.regulation.common.trade.execution.reports.TraderLocationRule traderLocationRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public List<ISOCountryCodeEnum> evaluate(TransactionReportInstruction input) {
		List<ISOCountryCodeEnum> output = doEvaluate(input);
		
		return output;
	}

	protected abstract List<ISOCountryCodeEnum> doEvaluate(TransactionReportInstruction input);

	public static class TraderLocationRuleDefault extends TraderLocationRule {
		@Override
		protected List<ISOCountryCodeEnum> doEvaluate(TransactionReportInstruction input) {
			List<ISOCountryCodeEnum> output = new ArrayList<>();
			return assignOutput(output, input);
		}
		
		protected List<ISOCountryCodeEnum> assignOutput(List<ISOCountryCodeEnum> output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForHKMA.evaluate(item.get()));
			output = thenArg
				.mapSingleToList(item -> MapperC.<ISOCountryCodeEnum>of(traderLocationRule.evaluate(item.get()))).getMulti();
			
			return output;
		}
	}
}
