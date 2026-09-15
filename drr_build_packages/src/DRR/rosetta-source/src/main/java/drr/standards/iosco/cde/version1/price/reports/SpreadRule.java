package drr.standards.iosco.cde.version1.price.reports;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.asset.SpreadSchedule;
import cdm.product.common.settlement.CommodityPriceReturnTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SpreadRule.SpreadRuleDefault.class)
public abstract class SpreadRule implements ReportFunction<PayoutLegWithAuxiliary, PriceSchedule> {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceSchedule evaluate(PayoutLegWithAuxiliary input) {
		PriceSchedule.PriceScheduleBuilder outputBuilder = doEvaluate(input);
		
		final PriceSchedule output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PriceSchedule.class, output);
		}
		
		return output;
	}

	protected abstract PriceSchedule.PriceScheduleBuilder doEvaluate(PayoutLegWithAuxiliary input);

	public static class SpreadRuleDefault extends SpreadRule {
		@Override
		protected PriceSchedule.PriceScheduleBuilder doEvaluate(PayoutLegWithAuxiliary input) {
			PriceSchedule.PriceScheduleBuilder output = PriceSchedule.builder();
			return assignOutput(output, input);
		}
		
		protected PriceSchedule.PriceScheduleBuilder assignOutput(PriceSchedule.PriceScheduleBuilder output, PayoutLegWithAuxiliary input) {
			final MapperS<SpreadSchedule> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(item.<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<CommodityPriceReturnTerms>map("getCommodityPriceReturnTerms", commodityPayout -> commodityPayout.getCommodityPriceReturnTerms()).<SpreadSchedule>map("getSpread", commodityPriceReturnTerms -> commodityPriceReturnTerms.getSpread())).getOrDefault(false)) {
						return item.<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<CommodityPriceReturnTerms>map("getCommodityPriceReturnTerms", commodityPayout -> commodityPayout.getCommodityPriceReturnTerms()).<SpreadSchedule>map("getSpread", commodityPriceReturnTerms -> commodityPriceReturnTerms.getSpread());
					}
					if (exists(item.<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule())).getOrDefault(false)) {
						return item.<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<SpreadSchedule>map("getSpreadSchedule", floatingRateSpecification -> floatingRateSpecification.getSpreadSchedule());
					}
					return MapperS.<SpreadSchedule>ofNull();
				});
			final ReferenceWithMetaPriceSchedule referenceWithMetaPriceSchedule = thenArg
				.mapSingleToItem(item -> item.<ReferenceWithMetaPriceSchedule>map("getPrice", spreadSchedule -> spreadSchedule.getPrice())).get();
			if (referenceWithMetaPriceSchedule == null) {
				output = null;
			} else {
				output = toBuilder(referenceWithMetaPriceSchedule.getValue());
			}
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
