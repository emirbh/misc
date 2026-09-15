package drr.projection.dtcc.rds.harmonized.sec.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.functions.NotationStringFromEnum;
import drr.base.util.string.functions.SubString;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import iso20022.dtcc.rds.harmonized.HarmonizedData;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_SubmissionHarmonizedData.Create_SubmissionHarmonizedDataDefault.class)
public abstract class Create_SubmissionHarmonizedData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected NotationStringFromEnum notationStringFromEnum;
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return harmonized 
	*/
	public HarmonizedData evaluate(SECTransactionReport drrReport) {
		HarmonizedData.HarmonizedDataBuilder harmonizedBuilder = doEvaluate(drrReport);
		
		final HarmonizedData harmonized;
		if (harmonizedBuilder == null) {
			harmonized = null;
		} else {
			harmonized = harmonizedBuilder.build();
			objectValidator.validate(HarmonizedData.class, harmonized);
		}
		
		return harmonized;
	}

	protected abstract HarmonizedData.HarmonizedDataBuilder doEvaluate(SECTransactionReport drrReport);

	public static class Create_SubmissionHarmonizedDataDefault extends Create_SubmissionHarmonizedData {
		@Override
		protected HarmonizedData.HarmonizedDataBuilder doEvaluate(SECTransactionReport drrReport) {
			HarmonizedData.HarmonizedDataBuilder harmonized = HarmonizedData.builder();
			return assignOutput(harmonized, drrReport);
		}
		
		protected HarmonizedData.HarmonizedDataBuilder assignOutput(HarmonizedData.HarmonizedDataBuilder harmonized, SECTransactionReport drrReport) {
			final MapperC<ClearingExceptionsAndExemptionsEnum> thenArg0 = MapperS.of(drrReport).<ClearingExceptionsAndExemptionsEnum>mapC("getClearingExceptionsAndExemptionsCounterparty1", sECTransactionReport -> sECTransactionReport.getClearingExceptionsAndExemptionsCounterparty1());
			final MapperC<String> thenArg1 = thenArg0
				.mapItem(item -> item.map("to-string", ClearingExceptionsAndExemptionsEnum::toDisplayString));
			final MapperS<PriceNotationEnum> thenArg2 = MapperS.of(drrReport).<PriceNotationEnum>map("getPackageTransactionPriceNotation", sECTransactionReport -> sECTransactionReport.getPackageTransactionPriceNotation());
			final MapperS<PriceNotationEnum> thenArg3 = MapperS.of(drrReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", sECTransactionReport -> sECTransactionReport.getPackageTransactionSpreadNotation());
			final MapperS<FrequencyPeriodEnum> thenArg4 = MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod());
			final MapperS<String> ifThenElseResult0;
			if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.DAIL), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of("D");
			} else if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.WEEK), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of("W");
			} else if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.MNTH), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of("M");
			} else if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.YEAR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of("Y");
			} else if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.EXPI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of("T");
			} else {
				ifThenElseResult0 = thenArg4.map("to-string", FrequencyPeriodEnum::toDisplayString);
			}
			final MapperS<FrequencyPeriodEnum> thenArg5 = MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod());
			final MapperS<String> ifThenElseResult1;
			if (areEqual(thenArg5, MapperS.of(FrequencyPeriodEnum.DAIL), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("D");
			} else if (areEqual(thenArg5, MapperS.of(FrequencyPeriodEnum.WEEK), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("W");
			} else if (areEqual(thenArg5, MapperS.of(FrequencyPeriodEnum.MNTH), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("M");
			} else if (areEqual(thenArg5, MapperS.of(FrequencyPeriodEnum.YEAR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("Y");
			} else if (areEqual(thenArg5, MapperS.of(FrequencyPeriodEnum.EXPI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("T");
			} else {
				ifThenElseResult1 = thenArg5.map("to-string", FrequencyPeriodEnum::toDisplayString);
			}
			final Integer integer0 = MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()).get();
			final Integer integer1 = MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()).get();
			final Integer integer2 = MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get();
			final Integer integer3 = MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get();
			final Integer integer4 = MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get();
			final Integer integer5 = MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get();
			final MapperS<PriceNotationEnum> thenArg6 = MapperS.of(drrReport).<PriceNotationEnum>map("getPriceNotation", sECTransactionReport -> sECTransactionReport.getPriceNotation());
			final MapperS<PriceNotationEnum> thenArg7 = MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<PriceNotationEnum>map("getSpreadNotation", sECLeg -> sECLeg.getSpreadNotation());
			final MapperS<PriceNotationEnum> thenArg8 = MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<PriceNotationEnum>map("getSpreadNotation", sECLeg -> sECLeg.getSpreadNotation());
			final BigDecimal ifThenElseResult2;
			if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", sECTransactionReport -> sECTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", sECTransactionReport -> sECTransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get();
			} else if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", sECTransactionReport -> sECTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", sECTransactionReport -> sECTransactionReport.getStrikePrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get();
			} else if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", sECTransactionReport -> sECTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", sECTransactionReport -> sECTransactionReport.getStrikePrice()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get();
			} else if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", sECTransactionReport -> sECTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.PERCENTAGE), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", sECTransactionReport -> sECTransactionReport.getStrikePrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get();
			} else {
				ifThenElseResult2 = null;
			}
			String ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", sECTransactionReport -> sECTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", sECTransactionReport -> sECTransactionReport.getStrikePriceCurrency()).get(), 1, 3);
			}
			final MapperS<PriceNotationEnum> thenArg9 = MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", sECTransactionReport -> sECTransactionReport.getStrikePriceNotation());
			final String ifThenElseResult4;
			if (exists(MapperS.of(drrReport).<String>map("getPlatformIdentifier", sECTransactionReport -> sECTransactionReport.getPlatformIdentifier())).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<String>map("getPlatformIdentifier", sECTransactionReport -> sECTransactionReport.getPlatformIdentifier()).get();
			} else if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", sECTransactionReport -> sECTransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", sECTransactionReport -> sECTransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult4 = "BILT";
			} else {
				ifThenElseResult4 = null;
			}
			harmonized = toBuilder(HarmonizedData.builder()
				.setClearingStatus(MapperS.of(drrReport).<ClearedEnum>map("getCleared", sECTransactionReport -> sECTransactionReport.getCleared()).map("to-string", ClearedEnum::toDisplayString).get())
				.setClearingExceptionType(thenArg1.join(MapperS.of(";")).get())
				.setCustomBasketIndicator(MapperS.of(drrReport).<Boolean>map("getCustomBasketIndicator", sECTransactionReport -> sECTransactionReport.getCustomBasketIndicator()).get())
				.setNoaActionType(MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", sECTransactionReport -> sECTransactionReport.getActionType()).map("to-string", ActionTypeEnum::toDisplayString).get())
				.setEventType(MapperS.of(drrReport).<EventTypeEnum>map("getEventType", sECTransactionReport -> sECTransactionReport.getEventType()).map("to-string", EventTypeEnum::toDisplayString).get())
				.setAmendmentIndicator(MapperS.of(drrReport).<Boolean>map("getAmendmentIndicator", sECTransactionReport -> sECTransactionReport.getAmendmentIndicator()).get())
				.setNotionalAmount1(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", sECLeg -> sECLeg.getNotionalAmount()).get())
				.setNotionalAmount2(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", sECLeg -> sECLeg.getNotionalAmount()).get())
				.setNotionalCurrency1(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", sECLeg -> sECLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setNotionalCurrency2(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", sECLeg -> sECLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdeQuantityUnitOfMeasureLeg1(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<String>map("getQuantityUnitOfMeasure", sECLeg -> sECLeg.getQuantityUnitOfMeasure()).get())
				.setCdeQuantityUnitOfMeasureLeg2(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<String>map("getQuantityUnitOfMeasure", sECLeg -> sECLeg.getQuantityUnitOfMeasure()).get())
				.setLeg1TotalNotionalQuantity(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", sECLeg -> sECLeg.getTotalNotionalQuantity()).get())
				.setLeg2TotalNotionalQuantity(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", sECLeg -> sECLeg.getTotalNotionalQuantity()).get())
				.setPackageIndicator(MapperS.of(drrReport).<Boolean>map("getPackageIndicator", sECTransactionReport -> sECTransactionReport.getPackageIndicator()).get())
				.setCdePackageTransactionPrice(MapperC.<BigDecimal>of(MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", sECTransactionReport -> sECTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", sECTransactionReport -> sECTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", sECTransactionReport -> sECTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", sECTransactionReport -> sECTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setCdePackageTransactionPriceCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPackageTransactionPriceCurrency", sECTransactionReport -> sECTransactionReport.getPackageTransactionPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdePackageTransactionPriceNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg2.get())).get())
				.setCdePackageTransactionSpread(MapperC.<BigDecimal>of(MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", sECTransactionReport -> sECTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", sECTransactionReport -> sECTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", sECTransactionReport -> sECTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", sECTransactionReport -> sECTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setCdePackageTransactionSpreadCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", sECTransactionReport -> sECTransactionReport.getPackageTransactionSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdePackageTransactionSpreadNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg3.get())).get())
				.setCdeFixedRateDayCountConventionLeg1(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFixedRateDayCountConventionLeg2(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFloatingRateDayCountConventionLeg1(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFloatingRateDayCountConventionLeg2(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setResetFrequencyPeriod1(ifThenElseResult0.get())
				.setLeg2ResetFrequencyPeriod(ifThenElseResult1.get())
				.setResetFrequencyPeriodMultiplier1((integer0 == null ? null : BigDecimal.valueOf(integer0)))
				.setLeg2ResetFrequencyPeriodMultiplier((integer1 == null ? null : BigDecimal.valueOf(integer1)))
				.setCdeFixedRatePaymentFrequencyPeriodLeg1(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFixedRatePaymentFrequencyPeriodLeg2(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFloatingRatePaymentFrequencyPeriodLeg1(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFloatingRatePaymentFrequencyPeriodLeg2(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", sECLeg -> sECLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFixedRatePaymentFrequencyPeriodMultiplierLeg1((integer2 == null ? null : BigDecimal.valueOf(integer2)))
				.setCdeFixedRatePaymentFrequencyPeriodMultiplierLeg2((integer3 == null ? null : BigDecimal.valueOf(integer3)))
				.setCdeFloatingRatePaymentFrequencyPeriodMultiplierLeg1((integer4 == null ? null : BigDecimal.valueOf(integer4)))
				.setCdeFloatingRatePaymentFrequencyPeriodMultiplierLeg2((integer5 == null ? null : BigDecimal.valueOf(integer5)))
				.setLeg1FixedRateInitial(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", sECLeg -> sECLeg.getFixedRate()).get())
				.setLeg2FixedRateInitial(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", sECLeg -> sECLeg.getFixedRate()).get())
				.setPostPricedSwapIndicator(MapperS.of(drrReport).<Boolean>map("getPostPricedSwapIndicator", sECTransactionReport -> sECTransactionReport.getPostPricedSwapIndicator()).get())
				.setPrice1Price(MapperC.<BigDecimal>of(MapperS.of(drrReport).<PriceFormat>map("getPrice", sECTransactionReport -> sECTransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<PriceFormat>map("getPrice", sECTransactionReport -> sECTransactionReport.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal())).get())
				.setCdePriceCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", sECTransactionReport -> sECTransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdePriceNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg6.get())).get())
				.setPrice1Units(MapperS.of(drrReport).<String>map("getPriceUnitOfMeasure", sECTransactionReport -> sECTransactionReport.getPriceUnitOfMeasure()).get())
				.setLeg1SpreadAmount(MapperC.<BigDecimal>of(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setLeg2SpreadAmount(MapperC.<BigDecimal>of(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<PriceFormat>map("getSpread", sECLeg -> sECLeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setLeg1SpreadCurrency(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", sECLeg -> sECLeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setLeg2SpreadCurrency(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", sECLeg -> sECLeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdeSpreadNotationLeg1(MapperS.of(notationStringFromEnum.evaluate(thenArg7.get())).get())
				.setCdeSpreadNotationLeg2(MapperS.of(notationStringFromEnum.evaluate(thenArg8.get())).get())
				.setStrikePrice(ifThenElseResult2)
				.setStrikePriceCurrency(ifThenElseResult3)
				.setCdeStrikePriceNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg9.get())).get())
				.setPremiumAmount(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", sECTransactionReport -> sECTransactionReport.getOptionPremiumAmount()).get())
				.setPremiumCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", sECTransactionReport -> sECTransactionReport.getOptionPremiumCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdeFirstExerciseDate(MapperS.of(drrReport).<Date>map("getFirstExerciseDate", sECTransactionReport -> sECTransactionReport.getFirstExerciseDate()).get())
				.setIndexFactor(MapperS.of(drrReport).<BigDecimal>map("getIndexFactor", sECTransactionReport -> sECTransactionReport.getIndexFactor()).get())
				.setEmbeddedOptionOnSwap(MapperS.of(drrReport).<EmbeddedOptionTypeEnum>map("getEmbeddedOptionType", sECTransactionReport -> sECTransactionReport.getEmbeddedOptionType()).map("to-string", EmbeddedOptionTypeEnum::toDisplayString).get())
				.setSettlementCurrency1(MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", sECLeg -> sECLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setLeg2SettlementCurrency(MapperS.of(drrReport).<SECLeg>map("getLeg2", sECTransactionReport -> sECTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", sECLeg -> sECLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdeSettlementLocationLeg1(MapperS.of(drrReport).<ISOCountryCodeEnum>map("getSettlementLocation", sECTransactionReport -> sECTransactionReport.getSettlementLocation()).map("to-string", ISOCountryCodeEnum::toDisplayString).get())
				.setNonStandardTradeIndicator(MapperS.of(drrReport).<Boolean>map("getNonStandardizedTermIndicator", sECTransactionReport -> sECTransactionReport.getNonStandardizedTermIndicator()).get())
				.setCdeEffectiveDate(MapperS.of(drrReport).<Date>map("getEffectiveDate", sECTransactionReport -> sECTransactionReport.getEffectiveDate()).get())
				.setCdeExpirationDate(MapperS.of(drrReport).<Date>map("getExpirationDate", sECTransactionReport -> sECTransactionReport.getExpirationDate()).get())
				.setOriginalExecutionTimestamp(MapperS.of(drrReport).<ZonedDateTime>map("getExecutionTimestamp", sECTransactionReport -> sECTransactionReport.getExecutionTimestamp()).get())
				.setCdePlatformIdentifier(ifThenElseResult4)
				.setComment1(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<String>map("getComment1", dTCCAdditionalFields -> dTCCAdditionalFields.getComment1()).get())
				.setVersion(MapperC.<String>of(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<String>map("getVersionTransaction", dTCCAdditionalFields -> dTCCAdditionalFields.getVersionTransaction()), MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<String>map("getVersionPPD", dTCCAdditionalFields -> dTCCAdditionalFields.getVersionPPD())).get())
				.setLeg1FloatingRateIndex(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<String>map("getLeg1FloatingRateIndex", dTCCAdditionalFields -> dTCCAdditionalFields.getLeg1FloatingRateIndex()).get())
				.setLeg2FloatingRateIndex(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<String>map("getLeg2FloatingRateIndex", dTCCAdditionalFields -> dTCCAdditionalFields.getLeg2FloatingRateIndex()).get())
				.setResponsibleDataSubmitterIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getResponsibleDataSubmitterIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getResponsibleDataSubmitterIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setResponsibleDataSubmitterId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<String>map("getResponsibleDataSubmitterID", dTCCAdditionalFields -> dTCCAdditionalFields.getResponsibleDataSubmitterID()).get())
				.setMaturityDateOfTheUnderlying(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<Date>map("getMaturityDateOfTheUnderlying", dTCCAdditionalFields -> dTCCAdditionalFields.getMaturityDateOfTheUnderlying()).get())
				.setSefOrDcmAnonymousExecutionIndicator(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<Boolean>map("getSefOrDcmAnonymousExecutionIndicator", dTCCAdditionalFields -> dTCCAdditionalFields.getSefOrDcmAnonymousExecutionIndicator()).get())
				.build());
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
