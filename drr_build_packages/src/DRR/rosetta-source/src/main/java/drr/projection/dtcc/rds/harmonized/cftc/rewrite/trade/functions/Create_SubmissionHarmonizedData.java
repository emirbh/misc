package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
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
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCTransactionReport;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.InterestComputationMethod4Code;
import drr.standards.iso.OptionStyleEnum;
import drr.standards.iso.ReportLevelEnum;
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
	public HarmonizedData evaluate(CFTCTransactionReport drrReport) {
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

	protected abstract HarmonizedData.HarmonizedDataBuilder doEvaluate(CFTCTransactionReport drrReport);

	public static class Create_SubmissionHarmonizedDataDefault extends Create_SubmissionHarmonizedData {
		@Override
		protected HarmonizedData.HarmonizedDataBuilder doEvaluate(CFTCTransactionReport drrReport) {
			HarmonizedData.HarmonizedDataBuilder harmonized = HarmonizedData.builder();
			return assignOutput(harmonized, drrReport);
		}
		
		protected HarmonizedData.HarmonizedDataBuilder assignOutput(HarmonizedData.HarmonizedDataBuilder harmonized, CFTCTransactionReport drrReport) {
			final Integer integer0 = MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get();
			final Integer integer1 = MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get();
			final Integer integer2 = MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get();
			final Integer integer3 = MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get();
			final String ifThenElseResult0;
			if (exists(MapperS.of(drrReport).<String>map("getPlatformIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getPlatformIdentifier())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getPlatformIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getPlatformIdentifier()).get();
			} else if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", cFTCTransactionReport -> cFTCTransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", cFTCTransactionReport -> cFTCTransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult0 = "BILT";
			} else {
				ifThenElseResult0 = null;
			}
			final MapperS<PriceNotationEnum> thenArg0 = MapperS.of(drrReport).<PriceNotationEnum>map("getPriceNotation", cFTCTransactionReport -> cFTCTransactionReport.getPriceNotation());
			final MapperS<PriceNotationEnum> thenArg1 = MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation());
			final MapperS<PriceNotationEnum> thenArg2 = MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<PriceNotationEnum>map("getSpreadNotation", commonLeg -> commonLeg.getSpreadNotation());
			final MapperS<FrequencyPeriodEnum> thenArg3 = MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod());
			final MapperS<String> ifThenElseResult1;
			if (areEqual(thenArg3, MapperS.of(FrequencyPeriodEnum.DAIL), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("D");
			} else if (areEqual(thenArg3, MapperS.of(FrequencyPeriodEnum.WEEK), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("W");
			} else if (areEqual(thenArg3, MapperS.of(FrequencyPeriodEnum.MNTH), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("M");
			} else if (areEqual(thenArg3, MapperS.of(FrequencyPeriodEnum.YEAR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("Y");
			} else if (areEqual(thenArg3, MapperS.of(FrequencyPeriodEnum.EXPI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of("T");
			} else {
				ifThenElseResult1 = thenArg3.map("to-string", FrequencyPeriodEnum::toDisplayString);
			}
			final Integer integer4 = MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()).get();
			final String ifThenElseResult2;
			if (areEqual(MapperS.of(drrReport).<OptionStyleEnum>map("getOptionStyle", cFTCTransactionReport -> cFTCTransactionReport.getOptionStyle()), MapperS.of(OptionStyleEnum.EURO), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = "European";
			} else if (areEqual(MapperS.of(drrReport).<OptionStyleEnum>map("getOptionStyle", cFTCTransactionReport -> cFTCTransactionReport.getOptionStyle()), MapperS.of(OptionStyleEnum.AMER), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = "American";
			} else if (areEqual(MapperS.of(drrReport).<OptionStyleEnum>map("getOptionStyle", cFTCTransactionReport -> cFTCTransactionReport.getOptionStyle()), MapperS.of(OptionStyleEnum.BERM), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = "Bermudan";
			} else if (areEqual(MapperS.of(drrReport).<OptionStyleEnum>map("getOptionStyle", cFTCTransactionReport -> cFTCTransactionReport.getOptionStyle()), MapperS.of(OptionStyleEnum.ASIA), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = "Asian";
			} else {
				ifThenElseResult2 = null;
			}
			final Integer integer5 = MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<Integer>map("getQuantityFrequencyMultiplier", commonLeg -> commonLeg.getQuantityFrequencyMultiplier()).get();
			final Integer integer6 = MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<Integer>map("getQuantityFrequencyMultiplier", commonLeg -> commonLeg.getQuantityFrequencyMultiplier()).get();
			final MapperS<FrequencyPeriodEnum> thenArg4 = MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod());
			final MapperS<String> ifThenElseResult3;
			if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.DAIL), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = MapperS.of("D");
			} else if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.WEEK), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = MapperS.of("W");
			} else if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.MNTH), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = MapperS.of("M");
			} else if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.YEAR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = MapperS.of("Y");
			} else if (areEqual(thenArg4, MapperS.of(FrequencyPeriodEnum.EXPI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = MapperS.of("T");
			} else {
				ifThenElseResult3 = thenArg4.map("to-string", FrequencyPeriodEnum::toDisplayString);
			}
			final Integer integer7 = MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()).get();
			final BigDecimal ifThenElseResult4;
			if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cFTCTransactionReport -> cFTCTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", cFTCTransactionReport -> cFTCTransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get();
			} else if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cFTCTransactionReport -> cFTCTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", cFTCTransactionReport -> cFTCTransactionReport.getStrikePrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get();
			} else if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cFTCTransactionReport -> cFTCTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", cFTCTransactionReport -> cFTCTransactionReport.getStrikePrice()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get();
			} else if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cFTCTransactionReport -> cFTCTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.PERCENTAGE), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", cFTCTransactionReport -> cFTCTransactionReport.getStrikePrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get();
			} else {
				ifThenElseResult4 = null;
			}
			String ifThenElseResult5 = null;
			if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cFTCTransactionReport -> cFTCTransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult5 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", cFTCTransactionReport -> cFTCTransactionReport.getStrikePriceCurrency()).get(), 1, 3);
			}
			String ifThenElseResult6 = null;
			if (areEqual(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult6 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", cFTCTransactionReport -> cFTCTransactionReport.getStrikePriceCurrency()).get(), 5, 3);
			}
			final MapperS<PriceNotationEnum> thenArg5 = MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cFTCTransactionReport -> cFTCTransactionReport.getStrikePriceNotation());
			final MapperS<PriceNotationEnum> thenArg6 = MapperS.of(drrReport).<PriceNotationEnum>map("getPackageTransactionPriceNotation", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionPriceNotation());
			final MapperS<PriceNotationEnum> thenArg7 = MapperS.of(drrReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionSpreadNotation());
			final MapperC<ClearingExceptionsAndExemptionsEnum> thenArg8 = MapperS.of(drrReport).<ClearingExceptionsAndExemptionsEnum>mapC("getClearingExceptionsAndExemptionsCounterparty1", cFTCTransactionReport -> cFTCTransactionReport.getClearingExceptionsAndExemptionsCounterparty1());
			final MapperC<String> thenArg9 = thenArg8
				.mapItem(item -> item.map("to-string", ClearingExceptionsAndExemptionsEnum::toDisplayString));
			harmonized = toBuilder(HarmonizedData.builder()
				.setAmendmentIndicator(MapperS.of(drrReport).<Boolean>map("getAmendmentIndicator", cFTCTransactionReport -> cFTCTransactionReport.getAmendmentIndicator()).get())
				.setCdePackageTransactionSpreadCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setClearingVenueId(MapperS.of(drrReport).<String>map("getCentralCounterparty", cFTCTransactionReport -> cFTCTransactionReport.getCentralCounterparty()).get())
				.setTradeParty1ClearingBrokerId(MapperS.of(drrReport).<String>map("getClearingMember", cFTCTransactionReport -> cFTCTransactionReport.getClearingMember()).get())
				.setBuyerPayer1(MapperS.of(drrReport).<String>map("getBuyerIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getBuyerIdentifier()).get())
				.setCdeCallAmountLeg1(MapperS.of(drrReport).<BigDecimal>map("getCallAmount", cFTCTransactionReport -> cFTCTransactionReport.getCallAmount()).get())
				.setCdeCallCurrencyLeg1(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getCallCurrency", cFTCTransactionReport -> cFTCTransactionReport.getCallCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdeEffectiveDate(MapperS.of(drrReport).<Date>map("getEffectiveDate", cFTCTransactionReport -> cFTCTransactionReport.getEffectiveDate()).get())
				.setCustomBasketIndicator(MapperS.of(drrReport).<Boolean>map("getCustomBasketIndicator", cFTCTransactionReport -> cFTCTransactionReport.getCustomBasketIndicator()).get())
				.setCdeExpirationDate(MapperS.of(drrReport).<Date>map("getExpirationDate", cFTCTransactionReport -> cFTCTransactionReport.getExpirationDate()).get())
				.setCdeFinalContractualSettlementDate(MapperS.of(drrReport).<Date>map("getFinalContractualSettlementDate", cFTCTransactionReport -> cFTCTransactionReport.getFinalContractualSettlementDate()).get())
				.setCdeFirstExerciseDate(MapperS.of(drrReport).<Date>map("getFirstExerciseDate", cFTCTransactionReport -> cFTCTransactionReport.getFirstExerciseDate()).get())
				.setCdeFixedRateDayCountConventionLeg1(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFixedRateDayCountConventionLeg2(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFixedRatePaymentFrequencyPeriodMultiplierLeg1((integer0 == null ? null : BigDecimal.valueOf(integer0)))
				.setCdeFixedRatePaymentFrequencyPeriodMultiplierLeg2((integer1 == null ? null : BigDecimal.valueOf(integer1)))
				.setCdeFixedRatePaymentFrequencyPeriodLeg1(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFixedRatePaymentFrequencyPeriodLeg2(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFloatingRateDayCountConventionLeg1(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFloatingRateDayCountConventionLeg2(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFloatingRatePaymentFrequencyPeriodMultiplierLeg1((integer2 == null ? null : BigDecimal.valueOf(integer2)))
				.setCdeFloatingRatePaymentFrequencyPeriodMultiplierLeg2((integer3 == null ? null : BigDecimal.valueOf(integer3)))
				.setCdeFloatingRatePaymentFrequencyPeriodLeg1(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFloatingRatePaymentFrequencyPeriodLeg2(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", commonLeg -> commonLeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdePlatformIdentifier(ifThenElseResult0)
				.setCdePriceCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", cFTCTransactionReport -> cFTCTransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdePriceNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg0.get())).get())
				.setCdePutAmountLeg1(MapperS.of(drrReport).<BigDecimal>map("getPutAmount", cFTCTransactionReport -> cFTCTransactionReport.getPutAmount()).get())
				.setCdePutCurrencyLeg1(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPutCurrency", cFTCTransactionReport -> cFTCTransactionReport.getPutCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdeQuantityUnitOfMeasureLeg1(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
				.setCdeQuantityUnitOfMeasureLeg2(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<String>map("getQuantityUnitOfMeasure", commonLeg -> commonLeg.getQuantityUnitOfMeasure()).get())
				.setCdeReceiverIdentifierLeg2(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<String>map("getReceiverIdentifier", commonLeg -> commonLeg.getReceiverIdentifier()).get())
				.setCdeSettlementLocationLeg1(MapperS.of(drrReport).<ISOCountryCodeEnum>map("getSettlementLocation", cFTCTransactionReport -> cFTCTransactionReport.getSettlementLocation()).map("to-string", ISOCountryCodeEnum::toDisplayString).get())
				.setCdeSpreadNotationLeg1(MapperS.of(notationStringFromEnum.evaluate(thenArg1.get())).get())
				.setCdeSpreadNotationLeg2(MapperS.of(notationStringFromEnum.evaluate(thenArg2.get())).get())
				.setClearingStatus(MapperS.of(drrReport).<ClearedEnum>map("getCleared", cFTCTransactionReport -> cFTCTransactionReport.getCleared()).map("to-string", ClearedEnum::toDisplayString).get())
				.setEventType(MapperS.of(drrReport).<EventTypeEnum>map("getEventType", cFTCTransactionReport -> cFTCTransactionReport.getEventType()).map("to-string", EventTypeEnum::toDisplayString).get())
				.setFixingDateLeg1(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<ZonedDateTime>map("getFixingDate", commonLeg -> commonLeg.getFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setFixingDateLeg2(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<ZonedDateTime>map("getFixingDate", commonLeg -> commonLeg.getFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setIndexFactor(MapperS.of(drrReport).<BigDecimal>map("getIndexFactor", cFTCTransactionReport -> cFTCTransactionReport.getIndexFactor()).get())
				.setExchangeRate(MapperS.of(drrReport).<BigDecimal>map("getExchangeRate", cFTCTransactionReport -> cFTCTransactionReport.getExchangeRate()).get())
				.setLeg1FixedRateInitial(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()).get())
				.setLeg1NotionalQuantity(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<BigDecimal>map("getNotionalQuantity", commonLeg -> commonLeg.getNotionalQuantity()).get())
				.setLeg1SpreadCurrency(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setLeg1TotalNotionalQuantity(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
				.setLeg2FixedRateInitial(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", commonLeg -> commonLeg.getFixedRate()).get())
				.setLeg2NotionalQuantity(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<BigDecimal>map("getNotionalQuantity", commonLeg -> commonLeg.getNotionalQuantity()).get())
				.setLeg2QuantityFrequency(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<FrequencyPeriodEnum>map("getQuantityFrequency", commonLeg -> commonLeg.getQuantityFrequency()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setLeg2ResetFrequencyPeriod(ifThenElseResult1.get())
				.setLeg2ResetFrequencyPeriodMultiplier((integer4 == null ? null : BigDecimal.valueOf(integer4)))
				.setLeg2SettlementCurrency(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setLeg2SpreadCurrency(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", commonLeg -> commonLeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setLeg2TotalNotionalQuantity(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", commonLeg -> commonLeg.getTotalNotionalQuantity()).get())
				.setNewSdrIdentifier(MapperS.of(drrReport).<String>map("getNewSDRIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getNewSDRIdentifier()).get())
				.setNoaActionType(MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", cFTCTransactionReport -> cFTCTransactionReport.getActionType()).map("to-string", ActionTypeEnum::toDisplayString).get())
				.setNonStandardTradeIndicator(MapperS.of(drrReport).<Boolean>map("getNonStandardizedTermIndicator", cFTCTransactionReport -> cFTCTransactionReport.getNonStandardizedTermIndicator()).get())
				.setNotionalAmount1(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get())
				.setNotionalAmount2(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get())
				.setNotionalCurrency1(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setNotionalCurrency2(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setOptionStyle(ifThenElseResult2)
				.setOriginalExecutionTimestamp(MapperS.of(drrReport).<ZonedDateTime>map("getExecutionTimestamp", cFTCTransactionReport -> cFTCTransactionReport.getExecutionTimestamp()).get())
				.setPayment1Payer(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<String>map("getPayerIdentifier", commonLeg -> commonLeg.getPayerIdentifier()).get())
				.setPayment1Receiver(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<String>map("getReceiverIdentifier", commonLeg -> commonLeg.getReceiverIdentifier()).get())
				.setPayment2Payer(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<String>map("getPayerIdentifier", commonLeg -> commonLeg.getPayerIdentifier()).get())
				.setPremiumAmount(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", cFTCTransactionReport -> cFTCTransactionReport.getOptionPremiumAmount()).get())
				.setPremiumCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", cFTCTransactionReport -> cFTCTransactionReport.getOptionPremiumCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setPremiumPaymentDateUnadjusted(MapperS.of(drrReport).<Date>map("getOptionPremiumPaymentDate", cFTCTransactionReport -> cFTCTransactionReport.getOptionPremiumPaymentDate()).get())
				.setPrice1Price(MapperC.<BigDecimal>of(MapperS.of(drrReport).<PriceFormat>map("getPrice", cFTCTransactionReport -> cFTCTransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<PriceFormat>map("getPrice", cFTCTransactionReport -> cFTCTransactionReport.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal())).get())
				.setPrice1Units(MapperS.of(drrReport).<String>map("getPriceUnitOfMeasure", cFTCTransactionReport -> cFTCTransactionReport.getPriceUnitOfMeasure()).get())
				.setPriorUtiId(MapperS.of(drrReport).<String>map("getPriorUTI", cFTCTransactionReport -> cFTCTransactionReport.getPriorUTI()).get())
				.setQuantityFrequencyMultiplierLeg1((integer5 == null ? null : BigDecimal.valueOf(integer5)))
				.setQuantityFrequencyMultiplierLeg2((integer6 == null ? null : BigDecimal.valueOf(integer6)))
				.setResetFrequencyPeriod1(ifThenElseResult3.get())
				.setResetFrequencyPeriodMultiplier1((integer7 == null ? null : BigDecimal.valueOf(integer7)))
				.setSellerPayer2(MapperS.of(drrReport).<String>map("getSellerIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getSellerIdentifier()).get())
				.setSettlementCurrency1(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setStrikePrice(ifThenElseResult4)
				.setStrikePriceCurrency(ifThenElseResult5)
				.setCdeStrikePriceCurrency2(ifThenElseResult6)
				.setCdeStrikePriceNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg5.get())).get())
				.setLeg2SpreadAmount(MapperC.<BigDecimal>of(MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<CommonLeg>map("getLeg2", cFTCTransactionReport -> cFTCTransactionReport.getLeg2()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setCdeCustomBasketCode(MapperS.of(drrReport).<String>map("getCustomBasketCode", cFTCTransactionReport -> cFTCTransactionReport.getCustomBasketCode()).get())
				.setLeg1SpreadAmount(MapperC.<BigDecimal>of(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<PriceFormat>map("getSpread", commonLeg -> commonLeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setExchangeRateBasisCurrency1(subString.evaluate(MapperS.of(drrReport).<String>map("getExchangeRateBasis", cFTCTransactionReport -> cFTCTransactionReport.getExchangeRateBasis()).get(), 1, 3))
				.setExchangeRateBasisCurrency2(subString.evaluate(MapperS.of(drrReport).<String>map("getExchangeRateBasis", cFTCTransactionReport -> cFTCTransactionReport.getExchangeRateBasis()).get(), 5, 3))
				.setMaturityDateOfTheUnderlying(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<Date>map("getMaturityDateOfTheUnderlying", dTCCAdditionalFields -> dTCCAdditionalFields.getMaturityDateOfTheUnderlying()).get())
				.setLevel(MapperS.of(drrReport).<ReportLevelEnum>map("getLevel", cFTCTransactionReport -> cFTCTransactionReport.getLevel()).map("to-string", ReportLevelEnum::toDisplayString).get())
				.setOriginalSwapSdrId(MapperS.of(drrReport).<String>map("getOriginalSwapSDRIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getOriginalSwapSDRIdentifier()).get())
				.setOriginalSwapUti(MapperS.of(drrReport).<String>map("getOriginalSwapUTI", cFTCTransactionReport -> cFTCTransactionReport.getOriginalSwapUTI()).get())
				.setEventIdentifier(MapperS.of(drrReport).<String>map("getEventIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getEventIdentifier()).get())
				.setPackageIndicator(MapperS.of(drrReport).<Boolean>map("getPackageIndicator", cFTCTransactionReport -> cFTCTransactionReport.getPackageIndicator()).get())
				.setCdePackageIdentifier(MapperS.of(drrReport).<String>map("getPackageIdentifier", cFTCTransactionReport -> cFTCTransactionReport.getPackageIdentifier()).get())
				.setCdePackageTransactionPrice(MapperC.<BigDecimal>of(MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setCdePackageTransactionPriceCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPackageTransactionPriceCurrency", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdePackageTransactionPriceNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg6.get())).get())
				.setCdePackageTransactionSpread(MapperC.<BigDecimal>of(MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", cFTCTransactionReport -> cFTCTransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setCdePackageTransactionSpreadNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg7.get())).get())
				.setPostPricedSwapIndicator(MapperS.of(drrReport).<Boolean>map("getPostPricedSwapIndicator", cFTCTransactionReport -> cFTCTransactionReport.getPostPricedSwapIndicator()).get())
				.setPrimeBrokerageTransactionIndicator(MapperS.of(drrReport).<Boolean>map("getPrimeBrokerageTransactionIndicator", cFTCTransactionReport -> cFTCTransactionReport.getPrimeBrokerageTransactionIndicator()).get())
				.setInitialMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", cFTCTransactionReport -> cFTCTransactionReport.getInitialMarginCollateralPortfolioCode()).get())
				.setVariationMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", cFTCTransactionReport -> cFTCTransactionReport.getVariationMarginCollateralPortfolioCode()).get())
				.setLargeNotionalOffFacilitySwapElectionIndicator(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<Boolean>map("getLargeNotionalOffFacilitySwapElectionIndicator", dTCCAdditionalFields -> dTCCAdditionalFields.getLargeNotionalOffFacilitySwapElectionIndicator()).get())
				.setSefOrDcmAnonymousExecutionIndicator(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<Boolean>map("getSefOrDcmAnonymousExecutionIndicator", dTCCAdditionalFields -> dTCCAdditionalFields.getSefOrDcmAnonymousExecutionIndicator()).get())
				.setBlockTradeElectionIndicator(MapperS.of(drrReport).<Boolean>map("getBlockTradeElectionIndicator", cFTCTransactionReport -> cFTCTransactionReport.getBlockTradeElectionIndicator()).get())
				.setSefOrDcmIndicator(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<Boolean>map("getSefOrDcmIndicator", dTCCAdditionalFields -> dTCCAdditionalFields.getSefOrDcmIndicator()).get())
				.setMandatoryClearingIndicator(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<Boolean>map("getMandatoryClearingIndicator", dTCCAdditionalFields -> dTCCAdditionalFields.getMandatoryClearingIndicator()).get())
				.setPriorUsiId(MapperS.of(drrReport).<String>map("getPriorUSI", cFTCTransactionReport -> cFTCTransactionReport.getPriorUSI()).get())
				.setAttachmentPoint(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexAttachmentPoint", cFTCTransactionReport -> cFTCTransactionReport.getCdSIndexAttachmentPoint()).get())
				.setExhaustionPoint(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexDetachmentPoint", cFTCTransactionReport -> cFTCTransactionReport.getCdSIndexDetachmentPoint()).get())
				.setClearingExceptionType(thenArg9.join(MapperS.of(";")).get())
				.setEmbeddedOptionOnSwap(MapperS.of(drrReport).<EmbeddedOptionTypeEnum>map("getEmbeddedOptionType", cFTCTransactionReport -> cFTCTransactionReport.getEmbeddedOptionType()).map("to-string", EmbeddedOptionTypeEnum::toDisplayString).get())
				.setPriorUsiIdPrefix(null)
				.setPriorUtiIdPrefix(null)
				.setClearingReceiptDatetime(MapperS.of(drrReport).<ZonedDateTime>map("getClearingReceiptTimestamp", cFTCTransactionReport -> cFTCTransactionReport.getClearingReceiptTimestamp()).get())
				.setOrigin(MapperS.of(drrReport).<ClearingAccountOriginEnum>map("getClearingAccountOrigin", cFTCTransactionReport -> cFTCTransactionReport.getClearingAccountOrigin()).map("to-string", ClearingAccountOriginEnum::toDisplayString).get())
				.setOptionType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getOptionType", dTCCAdditionalFields -> dTCCAdditionalFields.getOptionType()).get())
				.setSettlementType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getSettlementType", dTCCAdditionalFields -> dTCCAdditionalFields.getSettlementType()).get())
				.setLeg1CommodityInstrumentId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getLeg1CommodityInstrumentID", dTCCAdditionalFields -> dTCCAdditionalFields.getLeg1CommodityInstrumentID()).get())
				.setLeg2CommodityInstrumentId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getLeg2CommodityInstrumentID", dTCCAdditionalFields -> dTCCAdditionalFields.getLeg2CommodityInstrumentID()).get())
				.setLeg1CommodityUnderlyerId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getLeg1CommodityUnderlyerID", dTCCAdditionalFields -> dTCCAdditionalFields.getLeg1CommodityUnderlyerID()).get())
				.setLeg2CommodityUnderlyerId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getLeg2CommodityUnderlyerID", dTCCAdditionalFields -> dTCCAdditionalFields.getLeg2CommodityUnderlyerID()).get())
				.setResponsibleDataSubmitterId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getResponsibleDataSubmitterID", dTCCAdditionalFields -> dTCCAdditionalFields.getResponsibleDataSubmitterID()).get())
				.setResponsibleDataSubmitterIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getResponsibleDataSubmitterIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getResponsibleDataSubmitterIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setDeliveryLocation(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getDeliveryLocation", dTCCAdditionalFields -> dTCCAdditionalFields.getDeliveryLocation()).get())
				.setComment1(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<String>map("getComment1", dTCCAdditionalFields -> dTCCAdditionalFields.getComment1()).get())
				.setSdMspIndicatorCounterparty1(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<Boolean>map("getSdMspIndicatorCounterparty1", dTCCAdditionalFields -> dTCCAdditionalFields.getSdMspIndicatorCounterparty1()).get())
				.setSdMspIndicatorCounterparty2(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<Boolean>map("getSdMspIndicatorCounterparty2", dTCCAdditionalFields -> dTCCAdditionalFields.getSdMspIndicatorCounterparty2()).get())
				.setPhysicalCommodityContractIndicator(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<Boolean>map("getPhysicalCommodityContractIndicator", dTCCAdditionalFields -> dTCCAdditionalFields.getPhysicalCommodityContractIndicator()).get())
				.setChangeInNotionalAmount1(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<BigDecimal>map("getChangeInNotionalAmount1", dTCCAdditionalFields -> dTCCAdditionalFields.getChangeInNotionalAmount1()).get())
				.setChangeInNotionalAmount2(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<BigDecimal>map("getChangeInNotionalAmount2", dTCCAdditionalFields -> dTCCAdditionalFields.getChangeInNotionalAmount2()).get())
				.build());
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
