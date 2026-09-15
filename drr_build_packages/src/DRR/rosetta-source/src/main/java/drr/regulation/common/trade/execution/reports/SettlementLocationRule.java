package drr.regulation.common.trade.execution.reports;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SettlementLocationRule.SettlementLocationRuleDefault.class)
public abstract class SettlementLocationRule implements ReportFunction<TransactionReportInstruction, ISOCountryCodeEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected drr.standards.iosco.cde.version3.execution.reports.SettlementLocationRule settlementLocationRule;

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
			final MapperC<ISOCountryCodeEnum> thenArg = MapperC.<ISOCountryCodeEnum>of(MapperS.of(settlementLocationRule.evaluate(payoutLeg1Rule.evaluate(input))), MapperS.of(settlementLocationRule.evaluate(payoutLeg2Rule.evaluate(input))));
			output = MapperS.of(distinctIgnoringPrecision(thenArg).get()).get();
			
			return output;
		}
	}
}
