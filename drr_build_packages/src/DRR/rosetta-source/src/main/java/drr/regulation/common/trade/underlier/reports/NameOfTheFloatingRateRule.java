package drr.regulation.common.trade.underlier.reports;

import cdm.observable.asset.util.InterestRateIndexDeepPathUtil;
import cdm.product.asset.InterestRatePayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.functions.RateOption;
import javax.inject.Inject;


@ImplementedBy(NameOfTheFloatingRateRule.NameOfTheFloatingRateRuleDefault.class)
public abstract class NameOfTheFloatingRateRule implements ReportFunction<InterestRatePayout, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected InterestRateIndexDeepPathUtil interestRateIndexDeepPathUtil;
	@Inject protected RateOption rateOption;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(InterestRatePayout input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(InterestRatePayout input);

	public static class NameOfTheFloatingRateRuleDefault extends NameOfTheFloatingRateRule {
		@Override
		protected String doEvaluate(InterestRatePayout input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, InterestRatePayout input) {
			final FieldWithMetaString fieldWithMetaString = MapperS.of(rateOption.evaluate(input)).<FieldWithMetaString>map("chooseName", interestRateIndex -> interestRateIndexDeepPathUtil.chooseName(interestRateIndex)).get();
			if (fieldWithMetaString == null) {
				output = null;
			} else {
				output = fieldWithMetaString.getValue();
			}
			
			return output;
		}
	}
}
