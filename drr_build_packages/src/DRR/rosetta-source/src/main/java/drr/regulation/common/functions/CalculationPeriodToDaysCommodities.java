package drr.regulation.common.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.asset.CommodityPayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import javax.inject.Inject;


@ImplementedBy(CalculationPeriodToDaysCommodities.CalculationPeriodToDaysCommoditiesDefault.class)
public abstract class CalculationPeriodToDaysCommodities implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected PeriodExtendedCalculation periodExtendedCalculation;

	/**
	* @param commodityPayout 
	* @return result 
	*/
	public Integer evaluate(CommodityPayout commodityPayout) {
		Integer result = doEvaluate(commodityPayout);
		
		return result;
	}

	protected abstract Integer doEvaluate(CommodityPayout commodityPayout);

	protected abstract MapperS<? extends CalculationPeriodDates> calculationPeriodDates(CommodityPayout commodityPayout);

	public static class CalculationPeriodToDaysCommoditiesDefault extends CalculationPeriodToDaysCommodities {
		@Override
		protected Integer doEvaluate(CommodityPayout commodityPayout) {
			Integer result = null;
			return assignOutput(result, commodityPayout);
		}
		
		protected Integer assignOutput(Integer result, CommodityPayout commodityPayout) {
			result = periodExtendedCalculation.evaluate(calculationPeriodDates(commodityPayout).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()).get(), calculationPeriodDates(commodityPayout).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).<Integer>map("getPeriodMultiplier", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriodMultiplier()).get(), calculationPeriodDates(commodityPayout).<AdjustableOrRelativeDate>map("getEffectiveDate", _calculationPeriodDates -> _calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get(), calculationPeriodDates(commodityPayout).<AdjustableOrRelativeDate>map("getTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get());
			
			return result;
		}
		
		@Override
		protected MapperS<? extends CalculationPeriodDates> calculationPeriodDates(CommodityPayout commodityPayout) {
			return MapperS.of(commodityPayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _commodityPayout -> _commodityPayout.getCalculationPeriodDates());
		}
	}
}
