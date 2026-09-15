package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPeriodicPaymentToCalculationPeriodFrequency;
import cdm.ingest.fpml.confirmation.datetime.functions.MapPeriodicPaymentToPaymentDates;
import cdm.ingest.fpml.confirmation.datetime.functions.MapUnadjustedDateToAdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.other.functions.MapDayCountFractionEnum;
import cdm.ingest.fpml.confirmation.party.functions.FlipPayerAndReceiver;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedOrFloatingCalculationAmountToQuantityListWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapFixedRateToPriceScheduleWithAddress;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithAddress;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapFloatingRateSpecification;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import cdm.product.asset.FixedRateSpecification;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.InitialFixingDate;
import cdm.product.common.schedule.RateSchedule;
import cdm.product.common.schedule.ResetDates;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import fpml.consolidated.cd.CalculationAmount;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.FixedAmountCalculation;
import fpml.consolidated.cd.FixedRate;
import fpml.consolidated.cd.FloatingAmountCalculation;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.cd.ProtectionTerms;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.shared.AdjustableDate;
import fpml.consolidated.shared.DayCountFraction;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFeeLegToInterestRateLegPayout.MapFeeLegToInterestRateLegPayoutDefault.class)
public abstract class MapFeeLegToInterestRateLegPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FlipPayerAndReceiver flipPayerAndReceiver;
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapDayCountFractionEnum mapDayCountFractionEnum;
	@Inject protected MapFixedOrFloatingCalculationAmountToQuantityListWithAddress mapFixedOrFloatingCalculationAmountToQuantityListWithAddress;
	@Inject protected MapFixedRateToPriceScheduleWithAddress mapFixedRateToPriceScheduleWithAddress;
	@Inject protected MapFloatingRateSpecification mapFloatingRateSpecification;
	@Inject protected MapNotionalAmountToQuantityWithAddress mapNotionalAmountToQuantityWithAddress;
	@Inject protected MapPeriodicPaymentToCalculationPeriodFrequency mapPeriodicPaymentToCalculationPeriodFrequency;
	@Inject protected MapPeriodicPaymentToPaymentDates mapPeriodicPaymentToPaymentDates;
	@Inject protected MapUnadjustedDateToAdjustableOrRelativeDate mapUnadjustedDateToAdjustableOrRelativeDate;

	/**
	* @param fpmlFeeLeg 
	* @param fpmlProtectionTerms 
	* @param cdmGeneralTermsPayerReceiver 
	* @param cdmCounterpartyList 
	* @return payout 
	*/
	public Payout evaluate(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
		Payout.PayoutBuilder payoutBuilder = doEvaluate(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList);
		
		final Payout payout;
		if (payoutBuilder == null) {
			payout = null;
		} else {
			payout = payoutBuilder.build();
			objectValidator.validate(Payout.class, payout);
		}
		
		return payout;
	}

	protected abstract Payout.PayoutBuilder doEvaluate(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends FixedAmountCalculation> fixedAmountCalculation(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends FloatingAmountCalculation> floatingAmountCalculation(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList);

	protected abstract MapperS<? extends FloatingRateCalculation> fpmlFloatingRate(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFeeLegToInterestRateLegPayoutDefault extends MapFeeLegToInterestRateLegPayout {
		@Override
		protected Payout.PayoutBuilder doEvaluate(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
			if (fpmlProtectionTerms == null) {
				fpmlProtectionTerms = Collections.emptyList();
			}
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			Payout.PayoutBuilder payout = Payout.builder();
			return assignOutput(payout, fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList);
		}
		
		protected Payout.PayoutBuilder assignOutput(Payout.PayoutBuilder payout, FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
			final ReferenceWithMetaNonNegativeQuantitySchedule ifThenElseResult0;
			if (exists(fixedAmountCalculation(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).<CalculationAmount>map("getCalculationAmount", _fixedAmountCalculation -> _fixedAmountCalculation.getCalculationAmount())).orNullSafe(exists(floatingAmountCalculation(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).<CalculationAmount>map("getCalculationAmount", _floatingAmountCalculation -> _floatingAmountCalculation.getCalculationAmount()))).getOrDefault(false)) {
				ifThenElseResult0 = mapFixedOrFloatingCalculationAmountToQuantityListWithAddress.evaluate(fixedAmountCalculation(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).<CalculationAmount>map("getCalculationAmount", _fixedAmountCalculation -> _fixedAmountCalculation.getCalculationAmount()).get(), floatingAmountCalculation(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).<CalculationAmount>map("getCalculationAmount", _floatingAmountCalculation -> _floatingAmountCalculation.getCalculationAmount()).get(), fpmlFeeLeg);
			} else {
				ifThenElseResult0 = mapNotionalAmountToQuantityWithAddress.evaluate(MapperC.<ProtectionTerms>of(fpmlProtectionTerms).<Money>map("getCalculationAmount", protectionTerms -> protectionTerms.getCalculationAmount()).<BigDecimal>map("getAmount", money -> money.getAmount())
					.first().get(), null);
			}
			final ReferenceWithMetaPriceSchedule ifThenElseResult1;
			if (exists(fixedAmountCalculation(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).<FixedRate>map("getFixedRate", _fixedAmountCalculation -> _fixedAmountCalculation.getFixedRate())).getOrDefault(false)) {
				ifThenElseResult1 = mapFixedRateToPriceScheduleWithAddress.evaluate(fixedAmountCalculation(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).<FixedRate>map("getFixedRate", _fixedAmountCalculation -> _fixedAmountCalculation.getFixedRate()).<BigDecimal>map("getValue", fixedRate -> fixedRate.getValue()).get(), fpmlFeeLeg);
			} else {
				ifThenElseResult1 = ReferenceWithMetaPriceSchedule.builder().build();
			}
			FloatingRateSpecification ifThenElseResult2 = null;
			if (exists(fpmlFloatingRate(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList)).getOrDefault(false)) {
				ifThenElseResult2 = mapFloatingRateSpecification.evaluate(fpmlFloatingRate(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).get(), fpmlFeeLeg);
			}
			payout = toBuilder(Payout.builder()
				.setInterestRatePayout(InterestRatePayout.builder()
					.setPayerReceiver(flipPayerAndReceiver.evaluate(cdmGeneralTermsPayerReceiver))
					.setPriceQuantity(ResolvablePriceQuantity.builder()
						.setQuantitySchedule(ifThenElseResult0)
						.build())
					.setRateSpecification(RateSpecification.builder()
						.setFixedRateSpecification(FixedRateSpecification.builder()
							.setRateSchedule(RateSchedule.builder()
								.setPrice(ifThenElseResult1)
								.build())
							.build())
						.setFloatingRateSpecification(ifThenElseResult2)
						.build())
					.setDayCountFractionValue(mapDayCountFractionEnum.evaluate(fixedAmountCalculation(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).<DayCountFraction>map("getDayCountFraction", _fixedAmountCalculation -> _fixedAmountCalculation.getDayCountFraction()).<String>map("getValue", dayCountFraction -> dayCountFraction.getValue()).get()))
					.setCalculationPeriodDates(CalculationPeriodDates.builder()
						.setFirstPeriodStartDate(mapUnadjustedDateToAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).<ZonedDateTime>map("getFirstPeriodStartDate", periodicPayment -> periodicPayment.getFirstPeriodStartDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get(), null))
						.setCalculationPeriodFrequency(mapPeriodicPaymentToCalculationPeriodFrequency.evaluate(MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).get()))
						.build())
					.setPaymentDates(mapPeriodicPaymentToPaymentDates.evaluate(MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).get()))
					.setResetDates(ResetDates.builder()
						.setInitialFixingDate(InitialFixingDate.builder()
							.setInitialFixingDate(floatingAmountCalculation(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).<ZonedDateTime>map("getInitialFixingDate", _floatingAmountCalculation -> _floatingAmountCalculation.getInitialFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
							.build())
						.setFinalFixingDate(mapAdjustableDate.evaluate(floatingAmountCalculation(fpmlFeeLeg, fpmlProtectionTerms, cdmGeneralTermsPayerReceiver, cdmCounterpartyList).<AdjustableDate>map("getFinalFixingDate", _floatingAmountCalculation -> _floatingAmountCalculation.getFinalFixingDate()).get()))
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(payout)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends FixedAmountCalculation> fixedAmountCalculation(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).<FixedAmountCalculation>map("getFixedAmountCalculation", periodicPayment -> periodicPayment.getFixedAmountCalculation());
		}
		
		@Override
		protected MapperS<? extends FloatingAmountCalculation> floatingAmountCalculation(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).<FloatingAmountCalculation>map("getFloatingAmountCalculation", periodicPayment -> periodicPayment.getFloatingAmountCalculation());
		}
		
		@Override
		protected MapperS<? extends FloatingRateCalculation> fpmlFloatingRate(FeeLeg fpmlFeeLeg, List<? extends ProtectionTerms> fpmlProtectionTerms, PayerReceiver cdmGeneralTermsPayerReceiver, List<? extends Counterparty> cdmCounterpartyList) {
			return MapperS.of(fpmlFeeLeg).<PeriodicPayment>map("getPeriodicPayment", feeLeg -> feeLeg.getPeriodicPayment()).<FloatingAmountCalculation>map("getFloatingAmountCalculation", periodicPayment -> periodicPayment.getFloatingAmountCalculation()).<FloatingRateCalculation>map("getFloatingRate", _floatingAmountCalculation -> _floatingAmountCalculation.getFloatingRate());
		}
	}
}
