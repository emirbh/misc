package drr.regulation.mas.rewrite.trade.reports;

import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsFRA;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.payment.functions.FloatingInterestRatePayoutFromPayout;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.common.trade.underlier.reports.NameOfTheFloatingRateRule;
import drr.regulation.mas.rewrite.trade.functions.IsAllowableActionForMAS;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NameOfTheFloatingRateLeg1Rule.NameOfTheFloatingRateLeg1RuleDefault.class)
public abstract class NameOfTheFloatingRateLeg1Rule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FloatingInterestRatePayoutFromPayout floatingInterestRatePayoutFromPayout;
	@Inject protected IsAllowableActionForMAS isAllowableActionForMAS;
	@Inject protected IsFRA isFRA;
	@Inject protected NameOfTheFloatingRateRule nameOfTheFloatingRateRule;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected ProductForEvent productForEvent;

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

	public static class NameOfTheFloatingRateLeg1RuleDefault extends NameOfTheFloatingRateLeg1Rule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForMAS.evaluate(item.get()));
			final MapperS<TransactionReportInstruction> thenArg1 = thenArg0
				.filterSingleNullSafe(item -> areEqual(MapperS.of(isFRA.evaluate(productForEvent.evaluate(item.get()))), MapperS.of(false), CardinalityOperator.All).get());
			final MapperS<InterestRatePayout> thenArg2 = MapperS.of(floatingInterestRatePayoutFromPayout.evaluate(payoutLeg1Rule.evaluate(thenArg1.get())));
			final String string = nameOfTheFloatingRateRule.evaluate(thenArg2.get());
			final FieldWithMetaString fieldWithMetaString = (string == null ? MapperS.<FieldWithMetaString>ofNull() : MapperS.of(FieldWithMetaString.builder().setValue(string).build())).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
