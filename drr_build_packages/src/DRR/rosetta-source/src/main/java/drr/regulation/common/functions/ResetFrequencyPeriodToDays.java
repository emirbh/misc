package drr.regulation.common.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.ResetDates;
import cdm.product.common.schedule.ResetFrequency;
import cdm.product.common.schedule.metafields.ReferenceWithMetaCalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import javax.inject.Inject;


@ImplementedBy(ResetFrequencyPeriodToDays.ResetFrequencyPeriodToDaysDefault.class)
public abstract class ResetFrequencyPeriodToDays implements RosettaFunction {
	
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

	protected abstract MapperS<? extends ResetDates> resetDates(InterestRatePayout interestRatePayout);

	public static class ResetFrequencyPeriodToDaysDefault extends ResetFrequencyPeriodToDays {
		@Override
		protected Integer doEvaluate(InterestRatePayout interestRatePayout) {
			Integer result = null;
			return assignOutput(result, interestRatePayout);
		}
		
		protected Integer assignOutput(Integer result, InterestRatePayout interestRatePayout) {
			result = periodExtendedCalculation.evaluate(resetDates(interestRatePayout).<ResetFrequency>map("getResetFrequency", _resetDates -> _resetDates.getResetFrequency()).<PeriodExtendedEnum>map("getPeriod", resetFrequency -> resetFrequency.getPeriod()).get(), resetDates(interestRatePayout).<ResetFrequency>map("getResetFrequency", _resetDates -> _resetDates.getResetFrequency()).<Integer>map("getPeriodMultiplier", resetFrequency -> resetFrequency.getPeriodMultiplier()).get(), resetDates(interestRatePayout).<ReferenceWithMetaCalculationPeriodDates>map("getCalculationPeriodDatesReference", _resetDates -> _resetDates.getCalculationPeriodDatesReference()).<CalculationPeriodDates>map("Type coercion", referenceWithMetaCalculationPeriodDates0 -> referenceWithMetaCalculationPeriodDates0 == null ? null : referenceWithMetaCalculationPeriodDates0.getValue()).<AdjustableOrRelativeDate>map("getEffectiveDate", calculationPeriodDates -> calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get(), resetDates(interestRatePayout).<ReferenceWithMetaCalculationPeriodDates>map("getCalculationPeriodDatesReference", _resetDates -> _resetDates.getCalculationPeriodDatesReference()).<CalculationPeriodDates>map("Type coercion", referenceWithMetaCalculationPeriodDates1 -> referenceWithMetaCalculationPeriodDates1 == null ? null : referenceWithMetaCalculationPeriodDates1.getValue()).<AdjustableOrRelativeDate>map("getTerminationDate", calculationPeriodDates -> calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get());
			
			return result;
		}
		
		@Override
		protected MapperS<? extends ResetDates> resetDates(InterestRatePayout interestRatePayout) {
			return MapperS.of(interestRatePayout).<ResetDates>map("getResetDates", _interestRatePayout -> _interestRatePayout.getResetDates());
		}
	}
}
