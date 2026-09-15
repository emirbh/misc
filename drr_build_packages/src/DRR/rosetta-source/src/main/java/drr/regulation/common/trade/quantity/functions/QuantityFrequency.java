package drr.regulation.common.trade.quantity.functions;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.Frequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.asset.CommodityPayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.ObservationTerms;
import cdm.product.template.OptionPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.functions.ConvertPeriodtoISOFrequencyPeriod;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(QuantityFrequency.QuantityFrequencyDefault.class)
public abstract class QuantityFrequency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CommodityQuantityWithFrequency commodityQuantityWithFrequency;
	@Inject protected ConvertPeriodtoISOFrequencyPeriod convertPeriodtoISOFrequencyPeriod;

	/**
	* @param payout 
	* @return quantityFrequency 
	*/
	public drr.regulation.common.trade.quantity.QuantityFrequency evaluate(PayoutLegWithAuxiliary payout) {
		drr.regulation.common.trade.quantity.QuantityFrequency.QuantityFrequencyBuilder quantityFrequencyBuilder = doEvaluate(payout);
		
		final drr.regulation.common.trade.quantity.QuantityFrequency quantityFrequency;
		if (quantityFrequencyBuilder == null) {
			quantityFrequency = null;
		} else {
			quantityFrequency = quantityFrequencyBuilder.build();
			objectValidator.validate(drr.regulation.common.trade.quantity.QuantityFrequency.class, quantityFrequency);
		}
		
		return quantityFrequency;
	}

	protected abstract drr.regulation.common.trade.quantity.QuantityFrequency.QuantityFrequencyBuilder doEvaluate(PayoutLegWithAuxiliary payout);

	protected abstract MapperS<? extends Frequency> frequencyPeriod(PayoutLegWithAuxiliary payout);

	protected abstract MapperS<? extends CalculationPeriodFrequency> calculationPeriodFrequency(PayoutLegWithAuxiliary payout);

	public static class QuantityFrequencyDefault extends QuantityFrequency {
		@Override
		protected drr.regulation.common.trade.quantity.QuantityFrequency.QuantityFrequencyBuilder doEvaluate(PayoutLegWithAuxiliary payout) {
			drr.regulation.common.trade.quantity.QuantityFrequency.QuantityFrequencyBuilder quantityFrequency = drr.regulation.common.trade.quantity.QuantityFrequency.builder();
			return assignOutput(quantityFrequency, payout);
		}
		
		protected drr.regulation.common.trade.quantity.QuantityFrequency.QuantityFrequencyBuilder assignOutput(drr.regulation.common.trade.quantity.QuantityFrequency.QuantityFrequencyBuilder quantityFrequency, PayoutLegWithAuxiliary payout) {
			if (exists(frequencyPeriod(payout)).andNullSafe(areEqual(frequencyPeriod(payout).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.C), CardinalityOperator.All)).getOrDefault(false)) {
				final MapperS<FrequencyPeriodEnum> thenArg = MapperS.of(convertPeriodtoISOFrequencyPeriod.evaluate(calculationPeriodFrequency(payout).<PeriodExtendedEnum>map("getPeriod", _calculationPeriodFrequency -> _calculationPeriodFrequency.getPeriod()).get()));
				quantityFrequency = toBuilder(drr.regulation.common.trade.quantity.QuantityFrequency.builder()
					.setPeriod(MapperS.of(thenArg.getOrDefault(FrequencyPeriodEnum.ADHO)).get())
					.setPeriodMultiplier(calculationPeriodFrequency(payout).<Integer>map("getPeriodMultiplier", _calculationPeriodFrequency -> _calculationPeriodFrequency.getPeriodMultiplier()).get())
					.build());
			} else if (exists(frequencyPeriod(payout)).andNullSafe(notEqual(frequencyPeriod(payout).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.C), CardinalityOperator.Any)).getOrDefault(false)) {
				quantityFrequency = toBuilder(drr.regulation.common.trade.quantity.QuantityFrequency.builder()
					.setPeriod(convertPeriodtoISOFrequencyPeriod.evaluate(frequencyPeriod(payout).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()).get()))
					.setPeriodMultiplier(frequencyPeriod(payout).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier()).get())
					.build());
			} else {
				quantityFrequency = null;
			}
			
			return Optional.ofNullable(quantityFrequency)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Frequency> frequencyPeriod(PayoutLegWithAuxiliary payout) {
			return MapperS.of(commodityQuantityWithFrequency.evaluate(payout)).<Frequency>map("getFrequency", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getFrequency());
		}
		
		@Override
		protected MapperS<? extends CalculationPeriodFrequency> calculationPeriodFrequency(PayoutLegWithAuxiliary payout) {
			final MapperS<CalculationPeriodFrequency> thenArg0 = MapperS.of(payout).<CommodityPayout>map("getCommodityPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getCommodityPayout()).<CalculationPeriodDates>map("getCalculationPeriodDates", commodityPayout -> commodityPayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency());
			final MapperS<CalculationPeriodFrequency> thenArg1 = MapperS.of(thenArg0.getOrDefault(MapperS.of(payout).<OptionPayout>map("getOptionPayout", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getOptionPayout()).<ObservationTerms>map("getObservationTerms", optionPayout -> optionPayout.getObservationTerms()).<CalculationPeriodDates>map("getCalculationPeriodDates", observationTerms -> observationTerms.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).get()));
			return MapperS.of(thenArg1.getOrDefault(MapperS.of(payout).<PayoutLeg>map("getAuxiliaryLeg", payoutLegWithAuxiliary -> payoutLegWithAuxiliary.getAuxiliaryLeg()).<CommodityPayout>map("getCommodityPayout", payoutLeg -> payoutLeg.getCommodityPayout()).<CalculationPeriodDates>map("getCalculationPeriodDates", commodityPayout -> commodityPayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).get()));
		}
	}
}
