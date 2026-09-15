package drr.base.trade.quantity.reports;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(QuantityScheduleRule.QuantityScheduleRuleDefault.class)
public abstract class QuantityScheduleRule implements ReportFunction<PayoutLegWithAuxiliary, NonNegativeQuantitySchedule> {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public NonNegativeQuantitySchedule evaluate(PayoutLegWithAuxiliary input) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder outputBuilder = doEvaluate(input);
		
		final NonNegativeQuantitySchedule output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, output);
		}
		
		return output;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(PayoutLegWithAuxiliary input);

	public static class QuantityScheduleRuleDefault extends QuantityScheduleRule {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(PayoutLegWithAuxiliary input) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder output = NonNegativeQuantitySchedule.builder();
			return assignOutput(output, input);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder output, PayoutLegWithAuxiliary input) {
			final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule = MapperS.of(input)
				.mapSingleToItem(payout -> {
					final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg0 = payout.<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule());
					final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg1 = MapperS.of(thenArg0.getOrDefault(payout.<CreditDefaultPayout>map("getCreditDefaultPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCreditDefaultPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", creditDefaultPayout -> creditDefaultPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get()));
					final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg2 = MapperS.of(thenArg1.getOrDefault(payout.<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", performancePayout -> performancePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get()));
					final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg3 = MapperS.of(thenArg2.getOrDefault(payout.<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout()).<ResolvablePriceQuantity>map("getPriceQuantity", fixedPricePayout -> fixedPricePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get()));
					final MapperS<ReferenceWithMetaNonNegativeQuantitySchedule> thenArg4 = MapperS.of(thenArg3.getOrDefault(payout.<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", commodityPayout -> commodityPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get()));
					return MapperS.of(thenArg4.getOrDefault(payout.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<ResolvablePriceQuantity>map("getPriceQuantity", settlementPayout -> settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get()));
				}).get();
			if (referenceWithMetaNonNegativeQuantitySchedule == null) {
				output = null;
			} else {
				output = toBuilder(referenceWithMetaNonNegativeQuantitySchedule.getValue());
			}
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
