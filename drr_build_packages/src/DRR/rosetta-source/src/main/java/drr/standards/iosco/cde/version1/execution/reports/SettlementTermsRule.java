package drr.standards.iosco.cde.version1.execution.reports;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(SettlementTermsRule.SettlementTermsRuleDefault.class)
public abstract class SettlementTermsRule implements ReportFunction<PayoutLegWithAuxiliary, SettlementTerms> {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public SettlementTerms evaluate(PayoutLegWithAuxiliary input) {
		SettlementTerms.SettlementTermsBuilder outputBuilder = doEvaluate(input);
		
		final SettlementTerms output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(SettlementTerms.class, output);
		}
		
		return output;
	}

	protected abstract SettlementTerms.SettlementTermsBuilder doEvaluate(PayoutLegWithAuxiliary input);

	public static class SettlementTermsRuleDefault extends SettlementTermsRule {
		@Override
		protected SettlementTerms.SettlementTermsBuilder doEvaluate(PayoutLegWithAuxiliary input) {
			SettlementTerms.SettlementTermsBuilder output = SettlementTerms.builder();
			return assignOutput(output, input);
		}
		
		protected SettlementTerms.SettlementTermsBuilder assignOutput(SettlementTerms.SettlementTermsBuilder output, PayoutLegWithAuxiliary input) {
			output = toBuilder(MapperS.of(input)
				.mapSingleToItem(payout -> {
					final MapperS<SettlementTerms> thenArg0 = payout.<InterestRatePayout>map("getInterestRatePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getInterestRatePayout()).<SettlementTerms>map("getSettlementTerms", interestRatePayout -> interestRatePayout.getSettlementTerms());
					final MapperS<SettlementTerms> thenArg1 = MapperS.of(thenArg0.getOrDefault(payout.<CreditDefaultPayout>map("getCreditDefaultPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", creditDefaultPayout -> creditDefaultPayout.getSettlementTerms()).get()));
					final MapperS<SettlementTerms> thenArg2 = MapperS.of(thenArg1.getOrDefault(payout.<PerformancePayout>map("getPerformancePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getPerformancePayout()).<SettlementTerms>map("getSettlementTerms", performancePayout -> performancePayout.getSettlementTerms()).get()));
					final MapperS<SettlementTerms> thenArg3 = MapperS.of(thenArg2.getOrDefault(payout.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).get()));
					final MapperS<SettlementTerms> thenArg4 = MapperS.of(thenArg3.getOrDefault(payout.<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<SettlementTerms>map("getSettlementTerms", commodityPayout -> commodityPayout.getSettlementTerms()).get()));
					final MapperS<SettlementTerms> thenArg5 = MapperS.of(thenArg4.getOrDefault(payout.<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout()).<SettlementTerms>map("getSettlementTerms", fixedPricePayout -> fixedPricePayout.getSettlementTerms()).get()));
					final MapperS<SettlementTerms> thenArg6 = MapperS.of(thenArg5.getOrDefault(payout.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()).get()));
					final MapperS<SettlementTerms> thenArg7 = MapperS.of(thenArg6.getOrDefault(payout.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()).get()));
					final MapperS<SettlementTerms> thenArg8 = MapperS.of(thenArg7.getOrDefault(payout.<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<InterestRatePayout>map("getInterestRatePayout", payoutLeg -> payoutLeg.getInterestRatePayout()).<SettlementTerms>map("getSettlementTerms", interestRatePayout -> interestRatePayout.getSettlementTerms()).get()));
					return MapperS.of(thenArg8.getOrDefault(payout.<SettlementTerms>map("getSettlementTerms", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementTerms()).get()));
				}).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
