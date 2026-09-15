package drr.regulation.common.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import javax.inject.Inject;


@ImplementedBy(CalculationPeriodToDays.CalculationPeriodToDaysDefault.class)
public abstract class CalculationPeriodToDays implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PeriodExtendedCalculation periodExtendedCalculation;

	/**
	* @param interestRatePayout 
	* @return result 
	*/
	public Integer evaluate(InterestRatePayout interestRatePayout) {
		Integer result = doEvaluate(interestRatePayout);
		
		return result;
	}

	protected abstract Integer doEvaluate(InterestRatePayout interestRatePayout);

	protected abstract MapperS<? extends CalculationPeriodDates> calculationPeriodDates(InterestRatePayout interestRatePayout);

	public static class CalculationPeriodToDaysDefault extends CalculationPeriodToDays {
		@Override
		protected Integer doEvaluate(InterestRatePayout interestRatePayout) {
			Integer result = null;
			return assignOutput(result, interestRatePayout);
		}
		
		protected Integer assignOutput(Integer result, InterestRatePayout interestRatePayout) {
			result = periodExtendedCalculation.evaluate(calculationPeriodDates(interestRatePayout).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()).get(), calculationPeriodDates(interestRatePayout).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).<Integer>map("getPeriodMultiplier", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriodMultiplier()).get(), calculationPeriodDates(interestRatePayout).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get(), calculationPeriodDates(interestRatePayout).<AdjustableOrRelativeDate>map("getTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get());
			
			return result;
		}
		
		@Override
		protected MapperS<? extends CalculationPeriodDates> calculationPeriodDates(InterestRatePayout interestRatePayout) {
			return MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates());
		}
	}
}
