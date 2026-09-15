package drr.projection.iso20022.asic.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.IndexEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import iso20022.auth030.asic.FixedRate10__1;
import iso20022.auth030.asic.FloatingRate13__1;
import iso20022.auth030.asic.FloatingRate13__2;
import iso20022.auth030.asic.Frequency13Code__1;
import iso20022.auth030.asic.InterestRate33Choice__1;
import iso20022.auth030.asic.InterestRate33Choice__2;
import iso20022.auth030.asic.InterestRateLegs14__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetIntrstRate.GetIntrstRateDefault.class)
public abstract class GetIntrstRate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_FixedRate create_FixedRate;
	@Inject protected Create_FloatingRate create_FloatingRate;
	@Inject protected Create_FloatingRate2 create_FloatingRate2;

	/**
	* @param drrReport 
	* @return intrstRate 
	*/
	public InterestRateLegs14__1 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract InterestRateLegs14__1.InterestRateLegs14__1Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetIntrstRateDefault extends GetIntrstRate {
		@Override
		protected InterestRateLegs14__1.InterestRateLegs14__1Builder doEvaluate(ASICTransactionReport drrReport) {
			InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRate = InterestRateLegs14__1.builder();
			return assignOutput(intrstRate, drrReport);
		}
		
		protected InterestRateLegs14__1.InterestRateLegs14__1Builder assignOutput(InterestRateLegs14__1.InterestRateLegs14__1Builder intrstRate, ASICTransactionReport drrReport) {
			FixedRate10__1 ifThenElseResult0 = null;
			if (exists(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())).getOrDefault(false)) {
				ifThenElseResult0 = create_FixedRate.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).checkedMap("to-enum", e -> iso20022.auth030.asic.InterestComputationMethod4Code.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get());
			}
			FloatingRate13__1 ifThenElseResult1 = null;
			if (areEqual(exists(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = create_FloatingRate.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).checkedMap("to-enum", e -> iso20022.auth030.asic.InterestComputationMethod4Code.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get());
			}
			FixedRate10__1 ifThenElseResult2 = null;
			if (exists(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())).getOrDefault(false)) {
				ifThenElseResult2 = create_FixedRate.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).checkedMap("to-enum", e -> iso20022.auth030.asic.InterestComputationMethod4Code.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get());
			}
			FloatingRate13__2 ifThenElseResult3 = null;
			if (areEqual(exists(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = create_FloatingRate2.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<IndexEnum>map("getFloatingRateIndicator", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateIndicator()).map("to-string", IndexEnum::toDisplayString).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateReferencePeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateReferencePeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateReferencePeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateReferencePeriodMultiplier()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).checkedMap("to-enum", e -> iso20022.auth030.asic.InterestComputationMethod4Code.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).checkedMap("to-enum", e -> Frequency13Code__1.valueOf(e.name()), IllegalArgumentException.class).get(), MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get());
			}
			intrstRate = toBuilder(InterestRateLegs14__1.builder()
				.setFrstLeg(InterestRate33Choice__1.builder()
					.setFxd(ifThenElseResult0)
					.setFltg(ifThenElseResult1)
					.build())
				.setScndLeg(InterestRate33Choice__2.builder()
					.setFxd(ifThenElseResult2)
					.setFltg(ifThenElseResult3)
					.build())
				.build());
			
			return Optional.ofNullable(intrstRate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
