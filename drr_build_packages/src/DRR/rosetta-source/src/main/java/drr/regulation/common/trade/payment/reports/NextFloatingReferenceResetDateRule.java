package drr.regulation.common.trade.payment.reports;

import cdm.base.datetime.RelativeDateOffset;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.ResetDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.reports.ReportFunction;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(NextFloatingReferenceResetDateRule.NextFloatingReferenceResetDateRuleDefault.class)
public abstract class NextFloatingReferenceResetDateRule implements ReportFunction<InterestRatePayout, Date> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Date evaluate(InterestRatePayout input) {
		Date output = doEvaluate(input);
		
		return output;
	}

	protected abstract Date doEvaluate(InterestRatePayout input);

	public static class NextFloatingReferenceResetDateRuleDefault extends NextFloatingReferenceResetDateRule {
		@Override
		protected Date doEvaluate(InterestRatePayout input) {
			Date output = null;
			return assignOutput(output, input);
		}
		
		protected Date assignOutput(Date output, InterestRatePayout input) {
			if (exists(MapperS.of(input).<ResetDates>map("getResetDates", interestRatePayout -> interestRatePayout.getResetDates())).getOrDefault(false)) {
				output = MapperS.of(input).<ResetDates>map("getResetDates", interestRatePayout -> interestRatePayout.getResetDates()).<RelativeDateOffset>map("getFixingDates", resetDates -> resetDates.getFixingDates()).<Date>map("getAdjustedDate", relativeDateOffset -> relativeDateOffset.getAdjustedDate()).get();
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
