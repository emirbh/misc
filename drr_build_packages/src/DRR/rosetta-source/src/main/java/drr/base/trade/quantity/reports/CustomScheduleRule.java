package drr.base.trade.quantity.reports;

import cdm.product.asset.CommodityPayout;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CustomScheduleRule.CustomScheduleRuleDefault.class)
public abstract class CustomScheduleRule implements ReportFunction<PayoutLegWithAuxiliary, CalculationSchedule> {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CalculationSchedule evaluate(PayoutLegWithAuxiliary input) {
		CalculationSchedule.CalculationScheduleBuilder outputBuilder = doEvaluate(input);
		
		final CalculationSchedule output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(CalculationSchedule.class, output);
		}
		
		return output;
	}

	protected abstract CalculationSchedule.CalculationScheduleBuilder doEvaluate(PayoutLegWithAuxiliary input);

	public static class CustomScheduleRuleDefault extends CustomScheduleRule {
		@Override
		protected CalculationSchedule.CalculationScheduleBuilder doEvaluate(PayoutLegWithAuxiliary input) {
			CalculationSchedule.CalculationScheduleBuilder output = CalculationSchedule.builder();
			return assignOutput(output, input);
		}
		
		protected CalculationSchedule.CalculationScheduleBuilder assignOutput(CalculationSchedule.CalculationScheduleBuilder output, PayoutLegWithAuxiliary input) {
			output = toBuilder(MapperS.of(input)
				.mapSingleToItem(payout -> {
					final MapperS<CalculationSchedule> thenArg0 = payout.<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout()).<CalculationSchedule>map("getSchedule", fixedPricePayout -> fixedPricePayout.getSchedule());
					final MapperS<CalculationSchedule> thenArg1 = MapperS.of(thenArg0.getOrDefault(payout.<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule()).get()));
					final MapperS<CalculationSchedule> thenArg2 = MapperS.of(thenArg1.getOrDefault(payout.<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<CalculationSchedule>map("getSchedule", optionPayout -> optionPayout.getSchedule()).get()));
					final MapperS<CalculationSchedule> thenArg3 = MapperS.of(thenArg2.getOrDefault(payout.<FixedPricePayout>map("getFixedPricePayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getFixedPricePayout()).<CalculationSchedule>map("getSchedule", fixedPricePayout -> fixedPricePayout.getSchedule()).get()));
					return MapperS.of(thenArg3.getOrDefault(payout.<SettlementPayout>map("getSettlementPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getSettlementPayout()).<CalculationSchedule>map("getSchedule", settlementPayout -> settlementPayout.getSchedule()).get()));
				}).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
