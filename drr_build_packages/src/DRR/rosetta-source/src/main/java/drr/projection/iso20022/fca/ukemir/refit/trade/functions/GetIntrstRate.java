package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.IndexEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import iso20022.auth030.fca.Frequency13Code__1;
import iso20022.auth030.fca.InterestRate33Choice__1;
import iso20022.auth030.fca.InterestRateLegs14__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetIntrstRate.GetIntrstRateDefault.class)
public abstract class GetIntrstRate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_FixedRate create_FixedRate;
	@Inject protected Create_FloatingRate create_FloatingRate;

	/**
	* @param drrReport 
	* @return intrstRate 
	*/
	public InterestRateLegs14__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRateBuilder = doEvaluate(drrReport);
		
		final InterestRateLegs14__1 intrstRate;
		if (intrstRateBuilder == null) {
			intrstRate = null;
		} else {
			intrstRate = intrstRateBuilder.build();
			objectValidator.validate(InterestRateLegs14__1.class, intrstRate);
		}
		
		return intrstRate;
	}

	protected abstract InterestRateLegs14__1.InterestRateLegs14__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetIntrstRateDefault extends GetIntrstRate {
		@Override
		protected InterestRateLegs14__1.InterestRateLegs14__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRate = InterestRateLegs14__1.builder();
			return assignOutput(intrstRate, drrReport);
		}
		
		protected InterestRateLegs14__1.InterestRateLegs14__1Builder assignOutput(InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRate, FCAUKEMIRTransactionReport drrReport) {
			intrstRate = toBuilder(InterestRateLegs14__1.builder()
				.setFrstLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg1", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getLeg1())
					.mapSingleToItem(item -> MapperS.of(InterestRate33Choice__1.builder()
						.setFxd(create_FixedRate.evaluate(item.<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).checkedMap("to-enum", e -> iso20022.auth030.fca.InterestComputationMethod4Code.valueOf(e.name()), IllegalArgumentException.class).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get()))
						.setFltg(create_FloatingRate.evaluate(item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<String>map("getFloatingRateIdentifier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateIdentifier()).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<String>map("getNameOfTheFloatingRate", commonPeriodicPayment -> commonPeriodicPayment.getNameOfTheFloatingRate()).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<IndexEnum>map("getFloatingRateIndicator", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateIndicator()).map("to-string", IndexEnum::toDisplayString).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateReferencePeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateReferencePeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateReferencePeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateReferencePeriodMultiplier()).get(), item.<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get(), item.<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get(), item.<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get(), item.<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).checkedMap("to-enum", e -> iso20022.auth030.fca.InterestComputationMethod4Code.valueOf(e.name()), IllegalArgumentException.class).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()).get()))
						.build())).get())
				.setScndLeg(MapperS.of(drrReport).<CommonLeg>map("getLeg2", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getLeg2())
					.mapSingleToItem(item -> MapperS.of(InterestRate33Choice__1.builder()
						.setFxd(create_FixedRate.evaluate(item.<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).checkedMap("to-enum", e -> iso20022.auth030.fca.InterestComputationMethod4Code.valueOf(e.name()), IllegalArgumentException.class).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get()))
						.setFltg(create_FloatingRate.evaluate(item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<String>map("getFloatingRateIdentifier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateIdentifier()).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<String>map("getNameOfTheFloatingRate", commonPeriodicPayment -> commonPeriodicPayment.getNameOfTheFloatingRate()).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<IndexEnum>map("getFloatingRateIndicator", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateIndicator()).map("to-string", IndexEnum::toDisplayString).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateReferencePeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateReferencePeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateReferencePeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateReferencePeriodMultiplier()).get(), item.<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get(), item.<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get(), item.<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get(), item.<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).checkedMap("to-enum", e -> iso20022.auth030.fca.InterestComputationMethod4Code.valueOf(e.name()), IllegalArgumentException.class).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get(), item.<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()).get()))
						.build())).get())
				.build());
			
			return Optional.ofNullable(intrstRate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
