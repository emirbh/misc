package drr.regulation.sec.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
import drr.regulation.sec.rewrite.trade.validation.SECTransactionReportTypeFormatValidator;
import drr.regulation.sec.rewrite.trade.validation.SECTransactionReportValidator;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_AmendmentIndicator_01;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_AmendmentIndicator_02;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_ClearingExceptionsAndExemptionsCounterparty1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_ClearingExceptionsAndExemptionsCounterparty2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_Comment1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_CorporateActionNewTradeParty1LEI;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_Counterparty1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_Counterparty1FinancialEntityIndicator;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_Counterparty2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_Counterparty2IdentifierSource;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_EffectiveDateOfTheNotionalAmountLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_EffectiveDateOfTheNotionalAmountLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_EndDateOfTheNotionalAmountLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_EndDateOfTheNotionalAmountLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_EventTimestamp;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_EventType;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_ExpirationDate;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FirstExerciseDate;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FixedRateDayCountConventionLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FixedRateLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodMultiplierLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodMultiplierLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FloatingRateDayCountConventionLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodMultiplierLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodMultiplierLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FloatingRateResetFrequencyPeriodLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FloatingRateResetFrequencyPeriodLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FloatingRateResetFrequencyPeriodMultiplierLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_FloatingRateResetFrequencyPeriodMultiplierLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_IndexFactor;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_NonStandardizedTermIndicator;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_NotionalAmountInEffectOnAssociatedEffectiveDateLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_NotionalAmountInEffectOnAssociatedEffectiveDateLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_OptionPremiumAmount;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_OptionPremiumCurrency;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_OtherPaymentAmount;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_OtherPaymentCurrency;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_OtherPaymentPayerIDType;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_OtherPaymentReceiverIDType;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_OtherPaymentType;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PackageTransactionPrice;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceCurrency;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceNotation;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PackageTransactionSpread;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PackageTransactionSpreadCurrency;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PackageTransactionSpreadNotation;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PlatformIdentifier;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_Price;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PriceCurrency;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PriceNotation;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_PriceUnitOfMeasure;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_ReportingTimestamp;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_ResponsibleDataSubmitterID;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_ResponsibleDataSubmitterIDType;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_SEForDCMAnonymousExecutionIndicator;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_SettlementCurrencyLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_SpreadCurrencyLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_SpreadCurrencyLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_SpreadLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_SpreadLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_SpreadNotationLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_SpreadNotationLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_StrikePrice;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_StrikePriceCurrencyCurrencyPair;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_StrikePriceNotation;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_SubmittedForParty;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_TotalNotionalQuantityLeg1;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_TotalNotionalQuantityLeg2;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_TradeParty1ExecutionAgentID;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_TradeParty1ExecutionAgentIDType;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_TradeParty1ReportingDestination;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_TradeParty2ExecutionAgentID;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_TradeParty2ExecutionAgentIDType;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_USIIDPrefix;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_UTIIDPrefix;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_UniqueProductIdentifier;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_UniqueSwapIdentifier;
import drr.regulation.sec.rewrite.trade.validation.datarule.SECTransactionReportDTCC_SEC_VR_UniqueTransactionIdentifier;
import drr.regulation.sec.rewrite.trade.validation.exists.SECTransactionReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=SECTransactionReport.class)
public class SECTransactionReportMeta implements RosettaMetaData<SECTransactionReport> {

	@Override
	public List<Validator<? super SECTransactionReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_ClearingExceptionsAndExemptionsCounterparty1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_ClearingExceptionsAndExemptionsCounterparty2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_Counterparty1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_Counterparty2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_Counterparty2IdentifierSource.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_Counterparty1FinancialEntityIndicator.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_EventType.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_AmendmentIndicator_01.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_AmendmentIndicator_02.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_EventTimestamp.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_NotionalAmountLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_NotionalCurrencyLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_NotionalAmountInEffectOnAssociatedEffectiveDateLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_NotionalAmountInEffectOnAssociatedEffectiveDateLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_EffectiveDateOfTheNotionalAmountLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_EffectiveDateOfTheNotionalAmountLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_EndDateOfTheNotionalAmountLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_EndDateOfTheNotionalAmountLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_TotalNotionalQuantityLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_TotalNotionalQuantityLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PackageTransactionPrice.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceCurrency.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PackageTransactionPriceNotation.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PackageTransactionSpread.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PackageTransactionSpreadCurrency.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PackageTransactionSpreadNotation.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FixedRateDayCountConventionLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FloatingRateDayCountConventionLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FloatingRateResetFrequencyPeriodLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FloatingRateResetFrequencyPeriodLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FloatingRateResetFrequencyPeriodMultiplierLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FloatingRateResetFrequencyPeriodMultiplierLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_OtherPaymentType.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_OtherPaymentAmount.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_OtherPaymentCurrency.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodMultiplierLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FixedRatePaymentFrequencyPeriodMultiplierLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodMultiplierLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FloatingRatePaymentFrequencyPeriodMultiplierLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FixedRateLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_Price.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PriceCurrency.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PriceNotation.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PriceUnitOfMeasure.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_SpreadLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_SpreadLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_SpreadCurrencyLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_SpreadCurrencyLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_SpreadNotationLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_SpreadNotationLeg2.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_StrikePrice.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_StrikePriceCurrencyCurrencyPair.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_StrikePriceNotation.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_OptionPremiumAmount.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_OptionPremiumCurrency.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_FirstExerciseDate.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_IndexFactor.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_UniqueProductIdentifier.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_SettlementCurrencyLeg1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_NonStandardizedTermIndicator.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_ExpirationDate.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_ReportingTimestamp.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_PlatformIdentifier.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_UniqueSwapIdentifier.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_USIIDPrefix.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_UniqueTransactionIdentifier.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_UTIIDPrefix.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_SubmittedForParty.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_TradeParty1ReportingDestination.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_Comment1.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_TradeParty2ExecutionAgentID.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_TradeParty2ExecutionAgentIDType.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_TradeParty1ExecutionAgentID.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_TradeParty1ExecutionAgentIDType.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_ResponsibleDataSubmitterIDType.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_ResponsibleDataSubmitterID.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_SEForDCMAnonymousExecutionIndicator.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_CorporateActionNewTradeParty1LEI.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_OtherPaymentPayerIDType.class),
			factory.<SECTransactionReport>create(SECTransactionReportDTCC_SEC_VR_OtherPaymentReceiverIDType.class)
		);
	}
	
	@Override
	public List<Function<? super SECTransactionReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SECTransactionReport> validator(ValidatorFactory factory) {
		return factory.<SECTransactionReport>create(SECTransactionReportValidator.class);
	}

	@Override
	public Validator<? super SECTransactionReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SECTransactionReport>create(SECTransactionReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SECTransactionReport> validator() {
		return new SECTransactionReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SECTransactionReport> typeFormatValidator() {
		return new SECTransactionReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SECTransactionReport, Set<String>> onlyExistsValidator() {
		return new SECTransactionReportOnlyExistsValidator();
	}
}
