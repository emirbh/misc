package drr.projection.dtcc.rds.harmonized.csa.rewrite.trade.functions;

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
import drr.regulation.common.AllocationIndicatorEnum;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.common.trade.payment.CommonPeriodicPayment;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
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
	public HarmonizedData evaluate(CSATransactionReport drrReport) {
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

	protected abstract HarmonizedData.HarmonizedDataBuilder doEvaluate(CSATransactionReport drrReport);

	public static class Create_SubmissionHarmonizedDataDefault extends Create_SubmissionHarmonizedData {
		@Override
		protected HarmonizedData.HarmonizedDataBuilder doEvaluate(CSATransactionReport drrReport) {
			HarmonizedData.HarmonizedDataBuilder harmonized = HarmonizedData.builder();
			return assignOutput(harmonized, drrReport);
		}
		
		protected HarmonizedData.HarmonizedDataBuilder assignOutput(HarmonizedData.HarmonizedDataBuilder harmonized, CSATransactionReport drrReport) {
			final Integer integer0 = MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get();
			final Integer integer1 = MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFixedRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriodMultiplier()).get();
			final Integer integer2 = MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get();
			final Integer integer3 = MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRatePaymentFrequencyPeriodMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriodMultiplier()).get();
			final String ifThenElseResult0;
			if (exists(MapperS.of(drrReport).<String>map("getPlatformIdentifier", cSATransactionReport -> cSATransactionReport.getPlatformIdentifier())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getPlatformIdentifier", cSATransactionReport -> cSATransactionReport.getPlatformIdentifier()).get();
			} else if (areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", cSATransactionReport -> cSATransactionReport.getCleared()), MapperS.of(ClearedEnum.N), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<ClearedEnum>map("getCleared", cSATransactionReport -> cSATransactionReport.getCleared()), MapperS.of(ClearedEnum.I), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult0 = "BILT";
			} else {
				ifThenElseResult0 = null;
			}
			final MapperS<PriceNotationEnum> thenArg0 = MapperS.of(drrReport).<PriceNotationEnum>map("getPriceNotation", cSATransactionReport -> cSATransactionReport.getPriceNotation());
			final MapperS<PriceNotationEnum> thenArg1 = MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<PriceNotationEnum>map("getSpreadNotation", cSALeg -> cSALeg.getSpreadNotation());
			final MapperS<PriceNotationEnum> thenArg2 = MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<PriceNotationEnum>map("getSpreadNotation", cSALeg -> cSALeg.getSpreadNotation());
			final MapperS<FrequencyPeriodEnum> thenArg3 = MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod());
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
			final Integer integer4 = MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()).get();
			final String ifThenElseResult2;
			if (areEqual(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<OptionStyleEnum>map("getOptionStyle", dTCCAdditionalFields -> dTCCAdditionalFields.getOptionStyle()), MapperS.of(OptionStyleEnum.EURO), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = "European";
			} else if (areEqual(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<OptionStyleEnum>map("getOptionStyle", dTCCAdditionalFields -> dTCCAdditionalFields.getOptionStyle()), MapperS.of(OptionStyleEnum.AMER), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = "American";
			} else if (areEqual(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<OptionStyleEnum>map("getOptionStyle", dTCCAdditionalFields -> dTCCAdditionalFields.getOptionStyle()), MapperS.of(OptionStyleEnum.BERM), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = "Bermudan";
			} else if (areEqual(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<OptionStyleEnum>map("getOptionStyle", dTCCAdditionalFields -> dTCCAdditionalFields.getOptionStyle()), MapperS.of(OptionStyleEnum.ASIA), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = "Asian";
			} else {
				ifThenElseResult2 = null;
			}
			final Integer integer5 = MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<Integer>map("getQuantityFrequencyMultiplier", cSALeg -> cSALeg.getQuantityFrequencyMultiplier()).get();
			final Integer integer6 = MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<Integer>map("getQuantityFrequencyMultiplier", cSALeg -> cSALeg.getQuantityFrequencyMultiplier()).get();
			final MapperS<FrequencyPeriodEnum> thenArg4 = MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRateResetFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyPeriod());
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
			final Integer integer7 = MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<Integer>map("getFloatingRateResetFrequencyMultiplier", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateResetFrequencyMultiplier()).get();
			final BigDecimal ifThenElseResult4;
			if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cSATransactionReport -> cSATransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", cSATransactionReport -> cSATransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get();
			} else if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cSATransactionReport -> cSATransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.DECIMAL), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", cSATransactionReport -> cSATransactionReport.getStrikePrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get();
			} else if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cSATransactionReport -> cSATransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.BASIS), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", cSATransactionReport -> cSATransactionReport.getStrikePrice()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis()).get();
			} else if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cSATransactionReport -> cSATransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.PERCENTAGE), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<PriceFormat>map("getStrikePrice", cSATransactionReport -> cSATransactionReport.getStrikePrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get();
			} else {
				ifThenElseResult4 = null;
			}
			String ifThenElseResult5 = null;
			if (areEqual(MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cSATransactionReport -> cSATransactionReport.getStrikePriceNotation()), MapperS.of(PriceNotationEnum.MONETARY), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult5 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", cSATransactionReport -> cSATransactionReport.getStrikePriceCurrency()).get(), 1, 3);
			}
			String ifThenElseResult6 = null;
			if (areEqual(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()), MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult6 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", cSATransactionReport -> cSATransactionReport.getStrikePriceCurrency()).get(), 5, 3);
			}
			final MapperS<PriceNotationEnum> thenArg5 = MapperS.of(drrReport).<PriceNotationEnum>map("getStrikePriceNotation", cSATransactionReport -> cSATransactionReport.getStrikePriceNotation());
			final String ifThenElseResult7;
			if (exists(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getVersionTransaction", dTCCAdditionalFields -> dTCCAdditionalFields.getVersionTransaction())).getOrDefault(false)) {
				ifThenElseResult7 = MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getVersionTransaction", dTCCAdditionalFields -> dTCCAdditionalFields.getVersionTransaction()).get();
			} else if (exists(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getVersionPPD", dTCCAdditionalFields -> dTCCAdditionalFields.getVersionPPD())).getOrDefault(false)) {
				ifThenElseResult7 = MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getVersionPPD", dTCCAdditionalFields -> dTCCAdditionalFields.getVersionPPD()).get();
			} else {
				ifThenElseResult7 = null;
			}
			final MapperS<PriceNotationEnum> thenArg6 = MapperS.of(drrReport).<PriceNotationEnum>map("getPackageTransactionPriceNotation", cSATransactionReport -> cSATransactionReport.getPackageTransactionPriceNotation());
			final MapperS<PriceNotationEnum> thenArg7 = MapperS.of(drrReport).<PriceNotationEnum>map("getPackageTransactionSpreadNotation", cSATransactionReport -> cSATransactionReport.getPackageTransactionSpreadNotation());
			final MapperC<ClearingExceptionsAndExemptionsEnum> thenArg8 = MapperS.of(drrReport).<ClearingExceptionsAndExemptionsEnum>mapC("getClearingExceptionsAndExemptionsCounterparty1", cSATransactionReport -> cSATransactionReport.getClearingExceptionsAndExemptionsCounterparty1());
			final MapperC<String> thenArg9 = thenArg8
				.mapItem(item -> item.map("to-string", ClearingExceptionsAndExemptionsEnum::toDisplayString));
			harmonized = toBuilder(HarmonizedData.builder()
				.setAmendmentIndicator(MapperS.of(drrReport).<Boolean>map("getAmendmentIndicator", cSATransactionReport -> cSATransactionReport.getAmendmentIndicator()).get())
				.setCdePackageTransactionSpreadCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPackageTransactionSpreadCurrency", cSATransactionReport -> cSATransactionReport.getPackageTransactionSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setClearingVenueIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getClearingVenueIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getClearingVenueIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setClearingVenueId(MapperS.of(drrReport).<String>map("getCentralCounterparty", cSATransactionReport -> cSATransactionReport.getCentralCounterparty()).get())
				.setTradeParty1ClearingBrokerId(MapperS.of(drrReport).<String>map("getClearingMember", cSATransactionReport -> cSATransactionReport.getClearingMember()).get())
				.setTradeParty1ClearingBrokerIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty1ClearingBrokerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ClearingBrokerIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setBuyerPayer1(MapperS.of(drrReport).<String>map("getBuyerIdentifier", cSATransactionReport -> cSATransactionReport.getBuyerIdentifier()).get())
				.setCdeCallAmountLeg1(MapperS.of(drrReport).<BigDecimal>map("getCallAmount", cSATransactionReport -> cSATransactionReport.getCallAmount()).get())
				.setCdeCallCurrencyLeg1(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getCallCurrency", cSATransactionReport -> cSATransactionReport.getCallCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdeEffectiveDate(MapperS.of(drrReport).<Date>map("getEffectiveDate", cSATransactionReport -> cSATransactionReport.getEffectiveDate()).get())
				.setCustomBasketIndicator(MapperS.of(drrReport).<Boolean>map("getCustomBasketIndicator", cSATransactionReport -> cSATransactionReport.getCustomBasketIndicator()).get())
				.setCdeExpirationDate(MapperS.of(drrReport).<Date>map("getExpirationDate", cSATransactionReport -> cSATransactionReport.getExpirationDate()).get())
				.setCdeFinalContractualSettlementDate(MapperS.of(drrReport).<Date>map("getFinalContractualSettlementDate", cSATransactionReport -> cSATransactionReport.getFinalContractualSettlementDate()).get())
				.setCdeFirstExerciseDate(MapperS.of(drrReport).<Date>map("getFirstExerciseDate", cSATransactionReport -> cSATransactionReport.getFirstExerciseDate()).get())
				.setCdeFixedRateDayCountConventionLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFixedRateDayCountConventionLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFixedRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFixedRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFixedRatePaymentFrequencyPeriodMultiplierLeg1((integer0 == null ? null : BigDecimal.valueOf(integer0)))
				.setCdeFixedRatePaymentFrequencyPeriodMultiplierLeg2((integer1 == null ? null : BigDecimal.valueOf(integer1)))
				.setCdeFixedRatePaymentFrequencyPeriodLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFixedRatePaymentFrequencyPeriodLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFixedRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFixedRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFloatingRateDayCountConventionLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFloatingRateDayCountConventionLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<InterestComputationMethod4Code>map("getFloatingRateDayCountConvention", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRateDayCountConvention()).map("to-string", InterestComputationMethod4Code::toDisplayString).get())
				.setCdeFloatingRatePaymentFrequencyPeriodMultiplierLeg1((integer2 == null ? null : BigDecimal.valueOf(integer2)))
				.setCdeFloatingRatePaymentFrequencyPeriodMultiplierLeg2((integer3 == null ? null : BigDecimal.valueOf(integer3)))
				.setCdeFloatingRatePaymentFrequencyPeriodLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdeFloatingRatePaymentFrequencyPeriodLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<CommonPeriodicPayment>map("getPeriodicPayment", cSALeg -> cSALeg.getPeriodicPayment()).<FrequencyPeriodEnum>map("getFloatingRatePaymentFrequencyPeriod", commonPeriodicPayment -> commonPeriodicPayment.getFloatingRatePaymentFrequencyPeriod()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setCdePlatformIdentifier(ifThenElseResult0)
				.setCdePriceCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", cSATransactionReport -> cSATransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdePriceNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg0.get())).get())
				.setCdePutAmountLeg1(MapperS.of(drrReport).<BigDecimal>map("getPutAmount", cSATransactionReport -> cSATransactionReport.getPutAmount()).get())
				.setCdePutCurrencyLeg1(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPutCurrency", cSATransactionReport -> cSATransactionReport.getPutCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdeQuantityUnitOfMeasureLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getQuantityUnitOfMeasure", cSALeg -> cSALeg.getQuantityUnitOfMeasure()).get())
				.setCdeQuantityUnitOfMeasureLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getQuantityUnitOfMeasure", cSALeg -> cSALeg.getQuantityUnitOfMeasure()).get())
				.setCdeReceiverIdentifierLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getReceiverIdentifier", cSALeg -> cSALeg.getReceiverIdentifier()).get())
				.setCdeSettlementLocationLeg1(MapperS.of(drrReport).<ISOCountryCodeEnum>map("getSettlementLocation", cSATransactionReport -> cSATransactionReport.getSettlementLocation()).map("to-string", ISOCountryCodeEnum::toDisplayString).get())
				.setCdeSpreadNotationLeg1(MapperS.of(notationStringFromEnum.evaluate(thenArg1.get())).get())
				.setCdeSpreadNotationLeg2(MapperS.of(notationStringFromEnum.evaluate(thenArg2.get())).get())
				.setClearingStatus(MapperS.of(drrReport).<ClearedEnum>map("getCleared", cSATransactionReport -> cSATransactionReport.getCleared()).map("to-string", ClearedEnum::toDisplayString).get())
				.setEventType(MapperS.of(drrReport).<EventTypeEnum>map("getEventType", cSATransactionReport -> cSATransactionReport.getEventType()).map("to-string", EventTypeEnum::toDisplayString).get())
				.setFixingDateLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<ZonedDateTime>map("getFixingDate", cSALeg -> cSALeg.getFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setFixingDateLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<ZonedDateTime>map("getFixingDate", cSALeg -> cSALeg.getFixingDate()).<Date>map("Date", zdt -> Date.of(zdt.toLocalDate())).get())
				.setIndexFactor(MapperS.of(drrReport).<BigDecimal>map("getIndexFactor", cSATransactionReport -> cSATransactionReport.getIndexFactor()).get())
				.setExchangeRate(MapperS.of(drrReport).<BigDecimal>map("getExchangeRate", cSATransactionReport -> cSATransactionReport.getExchangeRate()).get())
				.setLeg1FixedRateInitial(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", cSALeg -> cSALeg.getFixedRate()).get())
				.setLeg1NotionalQuantity(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<BigDecimal>map("getNotionalQuantity", cSALeg -> cSALeg.getNotionalQuantity()).get())
				.setLeg1SpreadCurrency(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", cSALeg -> cSALeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setLeg1TotalNotionalQuantity(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<BigDecimal>map("getTotalNotionalQuantity", cSALeg -> cSALeg.getTotalNotionalQuantity()).get())
				.setLeg2FixedRateInitial(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<BigDecimal>map("getFixedRate", cSALeg -> cSALeg.getFixedRate()).get())
				.setLeg2NotionalQuantity(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<BigDecimal>map("getNotionalQuantity", cSALeg -> cSALeg.getNotionalQuantity()).get())
				.setLeg2QuantityFrequency(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<FrequencyPeriodEnum>map("getQuantityFrequency", cSALeg -> cSALeg.getQuantityFrequency()).map("to-string", FrequencyPeriodEnum::toDisplayString).get())
				.setLeg2ResetFrequencyPeriod(ifThenElseResult1.get())
				.setLeg2ResetFrequencyPeriodMultiplier((integer4 == null ? null : BigDecimal.valueOf(integer4)))
				.setLeg2SettlementCurrency(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", cSALeg -> cSALeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setLeg2SpreadCurrency(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSpreadCurrency", cSALeg -> cSALeg.getSpreadCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setLeg2TotalNotionalQuantity(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<BigDecimal>map("getTotalNotionalQuantity", cSALeg -> cSALeg.getTotalNotionalQuantity()).get())
				.setNewSdrIdentifier(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getNewSDRIdentifier", dTCCAdditionalFields -> dTCCAdditionalFields.getNewSDRIdentifier()).get())
				.setNoaActionType(MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", cSATransactionReport -> cSATransactionReport.getActionType()).map("to-string", ActionTypeEnum::toDisplayString).get())
				.setNonStandardTradeIndicator(MapperS.of(drrReport).<Boolean>map("getNonStandardizedTermIndicator", cSATransactionReport -> cSATransactionReport.getNonStandardizedTermIndicator()).get())
				.setNotionalAmount1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", cSALeg -> cSALeg.getNotionalAmount()).get())
				.setNotionalAmount2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", cSALeg -> cSALeg.getNotionalAmount()).get())
				.setNotionalCurrency1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cSALeg -> cSALeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setNotionalCurrency2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cSALeg -> cSALeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setOptionStyle(ifThenElseResult2)
				.setOptionType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getOptionType", dTCCAdditionalFields -> dTCCAdditionalFields.getOptionType()).get())
				.setOriginalExecutionTimestamp(MapperS.of(drrReport).<ZonedDateTime>map("getExecutionTimestamp", cSATransactionReport -> cSATransactionReport.getExecutionTimestamp()).get())
				.setPayment1Payer(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier()).get())
				.setPayment1Receiver(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getReceiverIdentifier", cSALeg -> cSALeg.getReceiverIdentifier()).get())
				.setPayment2Payer(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getPayerIdentifier", cSALeg -> cSALeg.getPayerIdentifier()).get())
				.setPremiumAmount(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", cSATransactionReport -> cSATransactionReport.getOptionPremiumAmount()).get())
				.setPremiumCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", cSATransactionReport -> cSATransactionReport.getOptionPremiumCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setPremiumPaymentDateUnadjusted(MapperS.of(drrReport).<Date>map("getOptionPremiumPaymentDate", cSATransactionReport -> cSATransactionReport.getOptionPremiumPaymentDate()).get())
				.setPrice1Price(MapperC.<BigDecimal>of(MapperS.of(drrReport).<PriceFormat>map("getPrice", cSATransactionReport -> cSATransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<PriceFormat>map("getPrice", cSATransactionReport -> cSATransactionReport.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal())).get())
				.setPrice1Units(MapperS.of(drrReport).<String>map("getPriceUnitOfMeasure", cSATransactionReport -> cSATransactionReport.getPriceUnitOfMeasure()).get())
				.setPriorUtiId(MapperS.of(drrReport).<String>map("getPriorUTI", cSATransactionReport -> cSATransactionReport.getPriorUTI()).get())
				.setQuantityFrequencyMultiplierLeg1((integer5 == null ? null : BigDecimal.valueOf(integer5)))
				.setQuantityFrequencyMultiplierLeg2((integer6 == null ? null : BigDecimal.valueOf(integer6)))
				.setResetFrequencyPeriod1(ifThenElseResult3.get())
				.setResetFrequencyPeriodMultiplier1((integer7 == null ? null : BigDecimal.valueOf(integer7)))
				.setSellerPayer2(MapperS.of(drrReport).<String>map("getSellerIdentifier", cSATransactionReport -> cSATransactionReport.getSellerIdentifier()).get())
				.setSettlementCurrency1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", cSALeg -> cSALeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setStrikePrice(ifThenElseResult4)
				.setStrikePriceCurrency(ifThenElseResult5)
				.setCdeStrikePriceCurrency2(ifThenElseResult6)
				.setCdeStrikePriceNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg5.get())).get())
				.setSettlementType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getSettlementType", dTCCAdditionalFields -> dTCCAdditionalFields.getSettlementType()).get())
				.setLeg1CommodityInstrumentId(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getCommodityInstrumentID", cSALeg -> cSALeg.getCommodityInstrumentID()).get())
				.setLeg2CommodityInstrumentId(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getCommodityInstrumentID", cSALeg -> cSALeg.getCommodityInstrumentID()).get())
				.setLeg1FloatingRateIndex(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getFloatingRateIndex", cSALeg -> cSALeg.getFloatingRateIndex()).get())
				.setLeg2FloatingRateIndex(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getFloatingRateIndex", cSALeg -> cSALeg.getFloatingRateIndex()).get())
				.setLeg1CommodityUnderlyerId(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getCommodityUnderlyerID", cSALeg -> cSALeg.getCommodityUnderlyerID()).get())
				.setLeg2CommodityUnderlyerId(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getCommodityUnderlyerID", cSALeg -> cSALeg.getCommodityUnderlyerID()).get())
				.setResponsibleDataSubmitterId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getResponsibleDataSubmitterID", dTCCAdditionalFields -> dTCCAdditionalFields.getResponsibleDataSubmitterID()).get())
				.setResponsibleDataSubmitterIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getResponsibleDataSubmitterIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getResponsibleDataSubmitterIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setSecondaryAssetClass(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getSecondaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getSecondaryAssetClass()).map("to-string", AssetClassEnum::toDisplayString).get())
				.setTradeParty1BrokerIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getTradeParty1BrokerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1BrokerIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setTradeParty1BrokerId(MapperS.of(drrReport).<String>map("getBrokerID", cSATransactionReport -> cSATransactionReport.getBrokerID()).get())
				.setLeg2SpreadAmount(MapperC.<BigDecimal>of(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setCdeCryptoAssetUnderlyingIndicatorLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<Boolean>map("getCryptoAssetUnderlyingIndicator", cSALeg -> cSALeg.getCryptoAssetUnderlyingIndicator()).get())
				.setCdeCryptoAssetUnderlyingIndicatorLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<Boolean>map("getCryptoAssetUnderlyingIndicator", cSALeg -> cSALeg.getCryptoAssetUnderlyingIndicator()).get())
				.setCdeCustomBasketCode(MapperS.of(drrReport).<String>map("getCustomBasketCode", cSATransactionReport -> cSATransactionReport.getCustomBasketCode()).get())
				.setUnderlierIdOtherLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getUnderlierIDOther", cSALeg -> cSALeg.getUnderlierIDOther()).get())
				.setUnderlierIdOtherLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getUnderlierIDOther", cSALeg -> cSALeg.getUnderlierIDOther()).get())
				.setUnderlierIdOtherSourceLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getUnderlierIDOtherSource", cSALeg -> cSALeg.getUnderlierIDOtherSource()).map("to-string", Object::toString).get())
				.setUnderlierIdOtherSourceLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getUnderlierIDOtherSource", cSALeg -> cSALeg.getUnderlierIDOtherSource()).map("to-string", Object::toString).get())
				.setCdeUnderlyingAssetTradingPlatformIdLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getUnderlyingAssetTradingPlatformIdentifier", cSALeg -> cSALeg.getUnderlyingAssetTradingPlatformIdentifier()).get())
				.setCdeUnderlyingAssetTradingPlatformIdLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getUnderlyingAssetTradingPlatformIdentifier", cSALeg -> cSALeg.getUnderlyingAssetTradingPlatformIdentifier()).get())
				.setCdeUnderlyingAssetPriceSourceLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<String>map("getUnderlyingAssetPriceSource", cSALeg -> cSALeg.getUnderlyingAssetPriceSource()).get())
				.setCdeUnderlyingAssetPriceSourceLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<String>map("getUnderlyingAssetPriceSource", cSALeg -> cSALeg.getUnderlyingAssetPriceSource()).get())
				.setLeg1SpreadAmount(MapperC.<BigDecimal>of(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setLoadType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getLoadType", dTCCAdditionalFields -> dTCCAdditionalFields.getLoadType()).get())
				.setDeliveryLocation(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getDeliveryLocation", dTCCAdditionalFields -> dTCCAdditionalFields.getDeliveryLocation()).get())
				.setExchangeRateBasisCurrency1(subString.evaluate(MapperS.of(drrReport).<String>map("getExchangeRateBasis", cSATransactionReport -> cSATransactionReport.getExchangeRateBasis()).get(), 1, 3))
				.setExchangeRateBasisCurrency2(subString.evaluate(MapperS.of(drrReport).<String>map("getExchangeRateBasis", cSATransactionReport -> cSATransactionReport.getExchangeRateBasis()).get(), 5, 3))
				.setVersion(ifThenElseResult7)
				.setComment1(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getComment1", dTCCAdditionalFields -> dTCCAdditionalFields.getComment1()).get())
				.setExecutionVenueId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getExecutionVenueID", dTCCAdditionalFields -> dTCCAdditionalFields.getExecutionVenueID()).get())
				.setExecutionVenueIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<PartyIdentifierTypeEnum>map("getExecutionVenueIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getExecutionVenueIDType()).map("to-string", PartyIdentifierTypeEnum::toDisplayString).get())
				.setMasterAgreementType(MapperS.of(drrReport).<MasterAgreementEnum>map("getMasterAgreementType", cSATransactionReport -> cSATransactionReport.getMasterAgreementType()).map("to-string", MasterAgreementEnum::toDisplayString).get())
				.setMasterAgreementVersion(MapperS.of(drrReport).<Integer>map("getMasterAgreementVersion", cSATransactionReport -> cSATransactionReport.getMasterAgreementVersion()).map("to-string", Object::toString).get())
				.setMaturityDateOfTheUnderlying(MapperS.of(drrReport).<Date>map("getMaturityDateOfTheUnderlying", cSATransactionReport -> cSATransactionReport.getMaturityDateOfTheUnderlying()).get())
				.setLevel(MapperS.of(drrReport).<ReportLevelEnum>map("getLevel", cSATransactionReport -> cSATransactionReport.getLevel()).map("to-string", ReportLevelEnum::toDisplayString).get())
				.setAllocationType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<AllocationIndicatorEnum>map("getAllocationType", dTCCAdditionalFields -> dTCCAdditionalFields.getAllocationType()).map("to-string", AllocationIndicatorEnum::toDisplayString).get())
				.setInteraffiliate(MapperS.of(drrReport).<Boolean>map("getInterAffiliateIndicator", cSATransactionReport -> cSATransactionReport.getInterAffiliateIndicator()).get())
				.setEventIdentifier(MapperS.of(drrReport).<String>map("getEventIdentifier", cSATransactionReport -> cSATransactionReport.getEventIdentifier()).get())
				.setPackageIndicator(MapperS.of(drrReport).<Boolean>map("getPackageIndicator", cSATransactionReport -> cSATransactionReport.getPackageIndicator()).get())
				.setCdePackageIdentifier(MapperS.of(drrReport).<String>map("getPackageIdentifier", cSATransactionReport -> cSATransactionReport.getPackageIdentifier()).get())
				.setCdePackageTransactionPrice(MapperC.<BigDecimal>of(MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", cSATransactionReport -> cSATransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", cSATransactionReport -> cSATransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", cSATransactionReport -> cSATransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionPrice", cSATransactionReport -> cSATransactionReport.getPackageTransactionPrice()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setCdePackageTransactionPriceCurrency(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPackageTransactionPriceCurrency", cSATransactionReport -> cSATransactionReport.getPackageTransactionPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setCdePackageTransactionPriceNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg6.get())).get())
				.setCdePackageTransactionSpread(MapperC.<BigDecimal>of(MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", cSATransactionReport -> cSATransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", cSATransactionReport -> cSATransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", cSATransactionReport -> cSATransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()), MapperS.of(drrReport).<PriceFormat>map("getPackageTransactionSpread", cSATransactionReport -> cSATransactionReport.getPackageTransactionSpread()).<BigDecimal>map("getBasis", priceFormat -> priceFormat.getBasis())).get())
				.setCdePackageTransactionSpreadNotation(MapperS.of(notationStringFromEnum.evaluate(thenArg7.get())).get())
				.setInitialMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getInitialMarginCollateralPortfolioCode", cSATransactionReport -> cSATransactionReport.getInitialMarginCollateralPortfolioCode()).get())
				.setVariationMarginCollateralPortfolioCode(MapperS.of(drrReport).<String>map("getVariationMarginCollateralPortfolioCode", cSATransactionReport -> cSATransactionReport.getVariationMarginCollateralPortfolioCode()).get())
				.setSefOrDcmAnonymousExecutionIndicator(MapperS.of(drrReport).<Boolean>map("getPlatformAnonymousExecutionIndicator", cSATransactionReport -> cSATransactionReport.getPlatformAnonymousExecutionIndicator()).get())
				.setPriorUsiId(MapperS.of(drrReport).<String>map("getPriorUSI", cSATransactionReport -> cSATransactionReport.getPriorUSI()).get())
				.setAttachmentPoint(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexAttachmentPoint", cSATransactionReport -> cSATransactionReport.getCdSIndexAttachmentPoint()).get())
				.setExhaustionPoint(MapperS.of(drrReport).<BigDecimal>map("getCdSIndexDetachmentPoint", cSATransactionReport -> cSATransactionReport.getCdSIndexDetachmentPoint()).get())
				.setClearingExceptionType(thenArg9.join(MapperS.of(";")).get())
				.setEmbeddedOptionOnSwap(MapperS.of(drrReport).<EmbeddedOptionTypeEnum>map("getEmbeddedOptionType", cSATransactionReport -> cSATransactionReport.getEmbeddedOptionType()).map("to-string", EmbeddedOptionTypeEnum::toDisplayString).get())
				.setPriorUsiIdPrefix(null)
				.setPriorUtiIdPrefix(null)
				.setTradeParty2CountryOfTheOtherCounterparty(MapperS.of(drrReport).<String>map("getCountryAndProvinceOrTerritoryOfIndividual", cSATransactionReport -> cSATransactionReport.getCountryAndProvinceOrTerritoryOfIndividual()).get())
				.setClearingReceiptDatetime(MapperS.of(drrReport).<ZonedDateTime>map("getClearingReceiptTimestamp", cSATransactionReport -> cSATransactionReport.getClearingReceiptTimestamp()).get())
				.setLeg1SettlementPeriod(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>map("getLeg1SettlementPeriod", dTCCAdditionalFields -> dTCCAdditionalFields.getLeg1SettlementPeriod()).get())
				.setOrigin(MapperS.of(drrReport).<ClearingAccountOriginEnum>map("getClearingAccountOrigin", cSATransactionReport -> cSATransactionReport.getClearingAccountOrigin()).map("to-string", ClearingAccountOriginEnum::toDisplayString).get())
				.build());
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
