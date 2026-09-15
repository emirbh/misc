package drr.regulation.cftc.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.cftc.rewrite.trade.CFTCPart43TransactionReport;
import drr.regulation.cftc.rewrite.trade.validation.CFTCPart43TransactionReportTypeFormatValidator;
import drr.regulation.cftc.rewrite.trade.validation.CFTCPart43TransactionReportValidator;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportAmendmentIndicatorCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportCallAmountCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportCallCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportCounterparty1Format;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportCounterparty2Format;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0014_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0015_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0028_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0031_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0031_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0031_03;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0032_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0032_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0032_03;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0033_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0033_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0035_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0035_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0042_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0042_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0055_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0055_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0056_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0056_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0063_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0063_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0063_03;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0063_04;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0087_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0093_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0102_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0102_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_0103_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_04;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_05;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_06;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_08;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_09;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_10;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_11;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_12;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_13;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_14;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_15;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_16;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_17;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_18;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_19;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_20;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_23;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportDayCountConventionCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportEffectiveDateOfTheNotionalAmountCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportEndDateOfTheNotionalAmountCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportEventTimestampCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportEventTypeCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportExchangeRateBasisCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportExchangeRateCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportExpirationDateCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportFirstExerciseDateCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportFixedRateCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportFloatingRateResetFrequencyPeriodCond;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportFloatingRateResetFrequencyPeriodMultiplierCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportIndexFactorCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportNonStandardizedTermIndicatorCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportNotionalAmountCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportNotionalAmountScheduleCondition_01;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportNotionalAmountScheduleCondition_02;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportNotionalCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportNotionalQuantityCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportOptionPremiumAmountCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportOptionPremiumCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportOtherPartyPaymentPayerIdentifierFormat;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportOtherPartyPaymentReceiverIdentifierFormat;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportOtherPaymentTypeCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPackageTransactionPriceCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPackageTransactionPriceCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPackageTransactionSpreadCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPackageTransactionSpreadCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPaymentFrequencyPeriodCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPaymentFrequencyPeriodMultiplierCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPlatformIdentifierCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPriceCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPriceCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPriceNotationCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPriceUnitOfMesureCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPrimeBrokerageTransactionIndicatorCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPutAmountCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportPutCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportQuantityFrequencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportQuantityFrequencyMultiplierCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportQuantityUnitOfMeasureCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportReportingTimestampCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportSettlementCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportSpreadCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportSpreadCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportSpreadNotationCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportStrikePriceCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportStrikePriceCurrencyCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportStrikePriceNotationCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportTotalNotionalQuantityCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportUniqueSwapIdentifierCondition;
import drr.regulation.cftc.rewrite.trade.validation.datarule.CFTCPart43TransactionReportUniqueTransactionIdentifierCondition;
import drr.regulation.cftc.rewrite.trade.validation.exists.CFTCPart43TransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CFTCPart43TransactionReport.class)
public class CFTCPart43TransactionReportMeta implements RosettaMetaData<CFTCPart43TransactionReport> {

	@Override
	public List<Validator<? super CFTCPart43TransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportCounterparty1Format.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportCounterparty2Format.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportOtherPartyPaymentPayerIdentifierFormat.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportOtherPartyPaymentReceiverIdentifierFormat.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportEventTypeCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportAmendmentIndicatorCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0028_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportEventTimestampCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportNotionalAmountCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportNotionalCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportNotionalAmountScheduleCondition_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportNotionalAmountScheduleCondition_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0033_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0033_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportEffectiveDateOfTheNotionalAmountCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportEndDateOfTheNotionalAmountCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportCallAmountCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportCallCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPutAmountCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPutCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportNotionalQuantityCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportQuantityFrequencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportQuantityFrequencyMultiplierCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportQuantityUnitOfMeasureCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportTotalNotionalQuantityCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPackageTransactionPriceCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPackageTransactionPriceCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPackageTransactionSpreadCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPackageTransactionSpreadCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDayCountConventionCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportFloatingRateResetFrequencyPeriodCond.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportFloatingRateResetFrequencyPeriodMultiplierCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportOtherPaymentTypeCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPaymentFrequencyPeriodCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPaymentFrequencyPeriodMultiplierCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportExchangeRateCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportExchangeRateBasisCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportFixedRateCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPriceCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPriceCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPriceNotationCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPriceUnitOfMesureCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportSpreadCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportSpreadCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportSpreadNotationCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportStrikePriceCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportStrikePriceCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportStrikePriceNotationCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportOptionPremiumAmountCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportOptionPremiumCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportFirstExerciseDateCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportIndexFactorCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportSettlementCurrencyCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportNonStandardizedTermIndicatorCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportExpirationDateCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportReportingTimestampCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPlatformIdentifierCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportPrimeBrokerageTransactionIndicatorCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportUniqueSwapIdentifierCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportUniqueTransactionIdentifierCondition.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0014_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0015_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0031_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0031_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0031_03.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0032_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0032_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0032_03.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0035_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0035_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0042_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0042_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0055_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0055_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0056_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0056_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0063_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0063_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0063_03.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0063_04.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0087_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0093_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0102_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0102_02.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_0103_01.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_04.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_05.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_06.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_08.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_09.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_10.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_11.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_12.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_13.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_14.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_15.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_16.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_17.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_18.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_19.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_20.class),
			factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportDTCC_CFTC_VR_DTCC_23.class)
		);
	}
	
	@Override
	public List<Function<? super CFTCPart43TransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CFTCPart43TransactionReport> validator(ValidatorFactory factory) {
		return factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportValidator.class);
	}

	@Override
	public Validator<? super CFTCPart43TransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CFTCPart43TransactionReport>create(CFTCPart43TransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CFTCPart43TransactionReport> validator() {
		return new CFTCPart43TransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CFTCPart43TransactionReport> typeFormatValidator() {
		return new CFTCPart43TransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CFTCPart43TransactionReport, Set<String>> onlyExistsValidator() {
		return new CFTCPart43TransactionReportOnlyExistsValidator();
	}
}
