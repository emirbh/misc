package drr.standards.iosco.cde.version1.price.reports;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.schedule.RateSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.functions.FormatToBaseOneRate;
import java.math.BigDecimal;
import javax.inject.Inject;


@ImplementedBy(FixedRateRule.FixedRateRuleDefault.class)
public abstract class FixedRateRule implements ReportFunction<InterestRatePayout, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FormatToBaseOneRate formatToBaseOneRate;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(InterestRatePayout input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(InterestRatePayout input);

	public static class FixedRateRuleDefault extends FixedRateRule {
		@Override
		protected BigDecimal doEvaluate(InterestRatePayout input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, InterestRatePayout input) {
			final MapperS<BigDecimal> thenArg = MapperS.of(input).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRateSpecification", rateSpecification -> rateSpecification.getFixedRateSpecification()).<RateSchedule>map("getRateSchedule", fixedRateSpecification -> fixedRateSpecification.getRateSchedule()).<ReferenceWithMetaPriceSchedule>map("getPrice", rateSchedule -> rateSchedule.getPrice()).<PriceSchedule>map("Type coercion", referenceWithMetaPriceSchedule -> referenceWithMetaPriceSchedule == null ? null : referenceWithMetaPriceSchedule.getValue()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue());
			output = MapperS.of(formatToBaseOneRate.evaluate(thenArg.get())).get();
			
			return output;
		}
	}
}
