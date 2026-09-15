package drr.enrichment.upi.functions;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.Frequency;
import cdm.base.datetime.Period;
import cdm.base.datetime.PeriodEnum;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.InflationRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaInflationRateIndexEnum;
import cdm.event.common.Trade;
import cdm.observable.asset.FloatingRateIndex;
import cdm.observable.asset.InflationIndex;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.regulation.common.functions.RateOption;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AnnaDsbUpiRequestOtherLegUnderlyingForRate.Create_AnnaDsbUpiRequestOtherLegUnderlyingForRateDefault.class)
public abstract class Create_AnnaDsbUpiRequestOtherLegUnderlyingForRate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected RateOption rateOption;
	@Inject protected TranslatePeriodEnum translatePeriodEnum;
	@Inject protected TranslatePeriodExtendedEnum translatePeriodExtendedEnum;

	/**
	* @param product 
	* @param trade 
	* @param useCase 
	* @return underlying 
	*/
	public AnnaDsbOtherLegUnderlying evaluate(NonTransferableProduct product, Trade trade, AnnaDsbUseCaseEnum useCase) {
		AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder underlyingBuilder = doEvaluate(product, trade, useCase);
		
		final AnnaDsbOtherLegUnderlying underlying;
		if (underlyingBuilder == null) {
			underlying = null;
		} else {
			underlying = underlyingBuilder.build();
			objectValidator.validate(AnnaDsbOtherLegUnderlying.class, underlying);
		}
		
		return underlying;
	}

	protected abstract AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder doEvaluate(NonTransferableProduct product, Trade trade, AnnaDsbUseCaseEnum useCase);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product, Trade trade, AnnaDsbUseCaseEnum useCase);

	protected abstract MapperS<? extends InterestRatePayout> interestRatePayoutFloatingLeg(NonTransferableProduct product, Trade trade, AnnaDsbUseCaseEnum useCase);

	public static class Create_AnnaDsbUpiRequestOtherLegUnderlyingForRateDefault extends Create_AnnaDsbUpiRequestOtherLegUnderlyingForRate {
		@Override
		protected AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder doEvaluate(NonTransferableProduct product, Trade trade, AnnaDsbUseCaseEnum useCase) {
			AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder underlying = AnnaDsbOtherLegUnderlying.builder();
			return assignOutput(underlying, product, trade, useCase);
		}
		
		protected AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder assignOutput(AnnaDsbOtherLegUnderlying.AnnaDsbOtherLegUnderlyingBuilder underlying, NonTransferableProduct product, Trade trade, AnnaDsbUseCaseEnum useCase) {
			final String ifThenElseResult0;
			if (exists(MapperS.of(rateOption.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).get())).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(rateOption.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).get())).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", floatingRateIndex -> floatingRateIndex.getFloatingRateIndex()).<FloatingRateIndexEnum>map("Type coercion", fieldWithMetaFloatingRateIndexEnum -> fieldWithMetaFloatingRateIndexEnum == null ? null : fieldWithMetaFloatingRateIndexEnum.getValue()).map("to-string", FloatingRateIndexEnum::toDisplayString).get();
			} else if (exists(MapperS.of(rateOption.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).get())).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(rateOption.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).get())).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()).<FieldWithMetaInflationRateIndexEnum>map("getInflationRateIndex", inflationIndex -> inflationIndex.getInflationRateIndex()).<InflationRateIndexEnum>map("Type coercion", fieldWithMetaInflationRateIndexEnum -> fieldWithMetaInflationRateIndexEnum == null ? null : fieldWithMetaInflationRateIndexEnum.getValue()).map("to-string", InflationRateIndexEnum::toDisplayString).get();
			} else {
				ifThenElseResult0 = null;
			}
			underlying
				.setOtherLegUnderlierID(ifThenElseResult0);
			
			AnnaDsbOtherLegUnderlierIDSourceEnum ifThenElseResult1 = null;
			if (exists(MapperS.of(rateOption.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).get()))).getOrDefault(false)) {
				ifThenElseResult1 = AnnaDsbOtherLegUnderlierIDSourceEnum.FPML;
			}
			underlying
				.setOtherLegUnderlierIDSource(ifThenElseResult1);
			
			final Integer ifThenElseResult2;
			if (exists(MapperS.of(rateOption.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).get())).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", floatingRateIndex -> floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier())).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(rateOption.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).get())).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", floatingRateIndex -> floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()).get();
			} else if (exists(interestRatePayoutFloatingLeg(product, trade, useCase).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier())).getOrDefault(false)) {
				ifThenElseResult2 = interestRatePayoutFloatingLeg(product, trade, useCase).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier()).get();
			} else {
				ifThenElseResult2 = interestRatePayoutFloatingLeg(product, trade, useCase).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<Integer>map("getPeriodMultiplier", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriodMultiplier()).get();
			}
			underlying
				.setOtherLegReferenceRateTermValue(ifThenElseResult2);
			
			final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum ifThenElseResult3;
			if (exists(MapperS.of(rateOption.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).get())).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", floatingRateIndex -> floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod())).getOrDefault(false)) {
				ifThenElseResult3 = translatePeriodEnum.evaluate(MapperS.of(rateOption.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).get())).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", floatingRateIndex -> floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod()).get());
			} else if (exists(interestRatePayoutFloatingLeg(product, trade, useCase).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod())).getOrDefault(false)) {
				ifThenElseResult3 = translatePeriodExtendedEnum.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()).get());
			} else {
				ifThenElseResult3 = translatePeriodExtendedEnum.evaluate(interestRatePayoutFloatingLeg(product, trade, useCase).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()).get());
			}
			underlying
				.setOtherLegReferenceRateTermUnit(ifThenElseResult3);
			
			return Optional.ofNullable(underlying)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product, Trade trade, AnnaDsbUseCaseEnum useCase) {
			return MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> interestRatePayoutFloatingLeg(NonTransferableProduct product, Trade trade, AnnaDsbUseCaseEnum useCase) {
			if (exists(MapperS.of(rateOption.evaluate(interestRateLeg2.evaluate(product))).<FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex())).orNullSafe(exists(MapperS.of(rateOption.evaluate(interestRateLeg2.evaluate(product))).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()))).getOrDefault(false)) {
				return MapperS.of(interestRateLeg2.evaluate(product));
			}
			return MapperS.<InterestRatePayout>ofNull();
		}
	}
}
