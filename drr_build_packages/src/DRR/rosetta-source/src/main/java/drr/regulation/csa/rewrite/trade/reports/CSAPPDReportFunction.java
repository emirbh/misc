package drr.regulation.csa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.reports.EnrichmentDataRule;
import drr.enrichment.common.reports.UpiPostEnrichmentDataRule;
import drr.enrichment.common.reports.UpiPreEnrichmentDataRule;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import drr.regulation.common.dtcc.trade.reports.DTCC_Comment1Rule;
import drr.regulation.common.dtcc.trade.reports.DTCC_CorporateActionNewTradeParty1LEIRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_DeliveryLocationRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_MaturityDateOfTheUnderlyingRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_OptionStyleRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_OptionTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_PrimaryAssetClassRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_ProductIDRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_ResponsibleDataSubmitterIDRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_ResponsibleDataSubmitterIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_SettlementTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_SubmittedForPartyRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_SubmittingPartyIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeLegTypesRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty1ExecutionAgentIDRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty1ExecutionAgentIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty1ReportingDestinationRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty2ExecutionAgentIDRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty2ExecutionAgentIDTypeRule;
import drr.regulation.common.trade.contract.reports.UnderlyingAssetTypeRule;
import drr.regulation.common.trade.link.reports.PriorUSIRule;
import drr.regulation.common.trade.quantity.reports.NotionalScheduleRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_Leg1CommodityInstrumentIDRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_Leg1CommodityUnderlyerIDRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_Leg1FloatingRateIndexRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_Leg2CommodityInstrumentIDRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_Leg2CommodityUnderlyerIDRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_Leg2FloatingRateIndexRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_MessageIDRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_MessageTypePPDRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_TradeParty1IDTypeRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_TradeParty1TransactionIDRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_USIIDPrefixRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_USIIDRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_UnderlyingAssetNameRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_UnderlyingAssetReportRule;
import drr.regulation.csa.rewrite.dtcc.trade.reports.DTCC_VersionPPDRule;
import drr.regulation.csa.rewrite.trade.CSATransactionReportPPD;
import drr.regulation.csa.rewrite.trade.labels.CSAPPDLabelProvider;
import drr.standards.iosco.cde.version3.datetime.reports.ReportingTimestampRule;
import drr.standards.iosco.cde.version3.event.reports.ActionTypeRule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty1Rule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2IdentifierTypeIndicatorRule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2Rule;
import drr.standards.iosco.cde.version3.price.reports.ExchangeRateBasisRule;
import drr.standards.iosco.upi.reports.UniqueProductIdentifierRule;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.csa.rewrite.trade", body="CSA", corpusList={"PPD"})
@RuneLabelProvider(labelProvider=CSAPPDLabelProvider.class)
@ImplementedBy(CSAPPDReportFunction.CSAPPDReportFunctionDefault.class)
public abstract class CSAPPDReportFunction implements ReportFunction<TransactionReportInstruction, CSATransactionReportPPD> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected AmendmentIndicatorRule amendmentIndicatorRule;
	@Inject protected CallAmountRule callAmountRule;
	@Inject protected CallCurrencyRule callCurrencyRule;
	@Inject protected ClearedRule clearedRule;
	@Inject protected ClearingExceptionsAndExemptionsCounterparty1Rule clearingExceptionsAndExemptionsCounterparty1Rule;
	@Inject protected ClearingExceptionsAndExemptionsCounterparty2Rule clearingExceptionsAndExemptionsCounterparty2Rule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierSourceRule counterparty2IdentifierSourceRule;
	@Inject protected Counterparty2IdentifierTypeIndicatorRule counterparty2IdentifierTypeIndicatorRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CustomBasketIndicatorRule customBasketIndicatorRule;
	@Inject protected DTCC_Comment1Rule dTCC_Comment1Rule;
	@Inject protected DTCC_CorporateActionNewTradeParty1LEIRule dTCC_CorporateActionNewTradeParty1LEIRule;
	@Inject protected DTCC_DeliveryLocationRule dTCC_DeliveryLocationRule;
	@Inject protected DTCC_Leg1CommodityInstrumentIDRule dTCC_Leg1CommodityInstrumentIDRule;
	@Inject protected DTCC_Leg1CommodityUnderlyerIDRule dTCC_Leg1CommodityUnderlyerIDRule;
	@Inject protected DTCC_Leg1FloatingRateIndexRule dTCC_Leg1FloatingRateIndexRule;
	@Inject protected DTCC_Leg2CommodityInstrumentIDRule dTCC_Leg2CommodityInstrumentIDRule;
	@Inject protected DTCC_Leg2CommodityUnderlyerIDRule dTCC_Leg2CommodityUnderlyerIDRule;
	@Inject protected DTCC_Leg2FloatingRateIndexRule dTCC_Leg2FloatingRateIndexRule;
	@Inject protected DTCC_MaturityDateOfTheUnderlyingRule dTCC_MaturityDateOfTheUnderlyingRule;
	@Inject protected DTCC_MessageIDRule dTCC_MessageIDRule;
	@Inject protected DTCC_MessageTypePPDRule dTCC_MessageTypePPDRule;
	@Inject protected DTCC_OptionStyleRule dTCC_OptionStyleRule;
	@Inject protected DTCC_OptionTypeRule dTCC_OptionTypeRule;
	@Inject protected DTCC_PrimaryAssetClassRule dTCC_PrimaryAssetClassRule;
	@Inject protected DTCC_ProductIDRule dTCC_ProductIDRule;
	@Inject protected DTCC_ResponsibleDataSubmitterIDRule dTCC_ResponsibleDataSubmitterIDRule;
	@Inject protected DTCC_ResponsibleDataSubmitterIDTypeRule dTCC_ResponsibleDataSubmitterIDTypeRule;
	@Inject protected DTCC_SettlementTypeRule dTCC_SettlementTypeRule;
	@Inject protected DTCC_SubmittedForPartyRule dTCC_SubmittedForPartyRule;
	@Inject protected DTCC_SubmittingPartyIDTypeRule dTCC_SubmittingPartyIDTypeRule;
	@Inject protected DTCC_TradeLegTypesRule dTCC_TradeLegTypesRule;
	@Inject protected DTCC_TradeParty1ExecutionAgentIDRule dTCC_TradeParty1ExecutionAgentIDRule;
	@Inject protected DTCC_TradeParty1ExecutionAgentIDTypeRule dTCC_TradeParty1ExecutionAgentIDTypeRule;
	@Inject protected DTCC_TradeParty1IDTypeRule dTCC_TradeParty1IDTypeRule;
	@Inject protected DTCC_TradeParty1ReportingDestinationRule dTCC_TradeParty1ReportingDestinationRule;
	@Inject protected DTCC_TradeParty1TransactionIDRule dTCC_TradeParty1TransactionIDRule;
	@Inject protected DTCC_TradeParty2ExecutionAgentIDRule dTCC_TradeParty2ExecutionAgentIDRule;
	@Inject protected DTCC_TradeParty2ExecutionAgentIDTypeRule dTCC_TradeParty2ExecutionAgentIDTypeRule;
	@Inject protected DTCC_USIIDPrefixRule dTCC_USIIDPrefixRule;
	@Inject protected DTCC_USIIDRule dTCC_USIIDRule;
	@Inject protected DTCC_UnderlyingAssetNameRule dTCC_UnderlyingAssetNameRule;
	@Inject protected DTCC_UnderlyingAssetReportRule dTCC_UnderlyingAssetReportRule;
	@Inject protected DTCC_VersionPPDRule dTCC_VersionPPDRule;
	@Inject protected DeliveryTypeRule deliveryTypeRule;
	@Inject protected EffectiveDateRule effectiveDateRule;
	@Inject protected EmbeddedOptionTypeRule embeddedOptionTypeRule;
	@Inject protected EnrichmentDataRule enrichmentDataRule;
	@Inject protected EventTimestampRule eventTimestampRule;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected ExchangeRateBasisRule exchangeRateBasisRule;
	@Inject protected ExchangeRateRule exchangeRateRule;
	@Inject protected ExecutionTimestampRule executionTimestampRule;
	@Inject protected ExecutionVenueTypeRule executionVenueTypeRule;
	@Inject protected ExpirationDateRule expirationDateRule;
	@Inject protected FirstExerciseDateRule firstExerciseDateRule;
	@Inject protected FixedRateDayCountConventionLeg1Rule fixedRateDayCountConventionLeg1Rule;
	@Inject protected FixedRateDayCountConventionLeg2Rule fixedRateDayCountConventionLeg2Rule;
	@Inject protected FixedRateLeg1Rule fixedRateLeg1Rule;
	@Inject protected FixedRateLeg2Rule fixedRateLeg2Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodLeg1Rule fixedRatePaymentFrequencyPeriodLeg1Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodLeg2Rule fixedRatePaymentFrequencyPeriodLeg2Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodMultiplierLeg1Rule fixedRatePaymentFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected FixingDateLeg1Rule fixingDateLeg1Rule;
	@Inject protected FixingDateLeg2Rule fixingDateLeg2Rule;
	@Inject protected FloatingRateDayCountConventionLeg1Rule floatingRateDayCountConventionLeg1Rule;
	@Inject protected FloatingRateDayCountConventionLeg2Rule floatingRateDayCountConventionLeg2Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodLeg1Rule floatingRatePaymentFrequencyPeriodLeg1Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodLeg2Rule floatingRatePaymentFrequencyPeriodLeg2Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodMultiplierLeg1Rule floatingRatePaymentFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodMultiplierLeg2Rule floatingRatePaymentFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected FloatingRateResetFrequencyMultiplierOfLeg1Rule floatingRateResetFrequencyMultiplierOfLeg1Rule;
	@Inject protected FloatingRateResetFrequencyMultiplierOfLeg2Rule floatingRateResetFrequencyMultiplierOfLeg2Rule;
	@Inject protected FloatingRateResetFrequencyPeriodOfLeg1Rule floatingRateResetFrequencyPeriodOfLeg1Rule;
	@Inject protected FloatingRateResetFrequencyPeriodOfLeg2Rule floatingRateResetFrequencyPeriodOfLeg2Rule;
	@Inject protected IndexFactorRule indexFactorRule;
	@Inject protected InstrumentTypeRule instrumentTypeRule;
	@Inject protected NonStandardizedTermIndicatorRule nonStandardizedTermIndicatorRule;
	@Inject protected NotionalAmountLeg1Rule notionalAmountLeg1Rule;
	@Inject protected NotionalAmountLeg2Rule notionalAmountLeg2Rule;
	@Inject protected NotionalAmountScheduleLeg1Rule notionalAmountScheduleLeg1Rule;
	@Inject protected NotionalAmountScheduleLeg2Rule notionalAmountScheduleLeg2Rule;
	@Inject protected NotionalCurrencyLeg1Rule notionalCurrencyLeg1Rule;
	@Inject protected NotionalCurrencyLeg2Rule notionalCurrencyLeg2Rule;
	@Inject protected NotionalQuantityLeg1Rule notionalQuantityLeg1Rule;
	@Inject protected NotionalQuantityLeg2Rule notionalQuantityLeg2Rule;
	@Inject protected NotionalQuantityScheduleLeg1Rule notionalQuantityScheduleLeg1Rule;
	@Inject protected NotionalQuantityScheduleLeg2Rule notionalQuantityScheduleLeg2Rule;
	@Inject protected NotionalScheduleRule notionalScheduleRule;
	@Inject protected OptionPremiumAmountRule optionPremiumAmountRule;
	@Inject protected OptionPremiumCurrencyRule optionPremiumCurrencyRule;
	@Inject protected OtherPaymentRule otherPaymentRule;
	@Inject protected PackageIndicatorRule packageIndicatorRule;
	@Inject protected PackageTransactionPriceCurrencyRule packageTransactionPriceCurrencyRule;
	@Inject protected PackageTransactionPriceNotationRule packageTransactionPriceNotationRule;
	@Inject protected PackageTransactionPriceRule packageTransactionPriceRule;
	@Inject protected PackageTransactionSpreadCurrencyRule packageTransactionSpreadCurrencyRule;
	@Inject protected PackageTransactionSpreadNotationRule packageTransactionSpreadNotationRule;
	@Inject protected PackageTransactionSpreadRule packageTransactionSpreadRule;
	@Inject protected PlatformAnonymousExecutionIndicatorRule platformAnonymousExecutionIndicatorRule;
	@Inject protected PlatformIdentifierRule platformIdentifierRule;
	@Inject protected PriceCurrencyRule priceCurrencyRule;
	@Inject protected PriceNotationRule priceNotationRule;
	@Inject protected PriceRule priceRule;
	@Inject protected PriceUnitOfMeasureRule priceUnitOfMeasureRule;
	@Inject protected PriorUSIRule priorUSIRule;
	@Inject protected PutAmountRule putAmountRule;
	@Inject protected PutCurrencyRule putCurrencyRule;
	@Inject protected QuantityFrequencyPeriodLeg1Rule quantityFrequencyPeriodLeg1Rule;
	@Inject protected QuantityFrequencyPeriodLeg2Rule quantityFrequencyPeriodLeg2Rule;
	@Inject protected QuantityFrequencyPeriodMultiplierLeg1Rule quantityFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected QuantityFrequencyPeriodMultiplierLeg2Rule quantityFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected QuantityUnitOfMeasureLeg1Rule quantityUnitOfMeasureLeg1Rule;
	@Inject protected QuantityUnitOfMeasureLeg2Rule quantityUnitOfMeasureLeg2Rule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected ReturnorPayoutTriggerRule returnorPayoutTriggerRule;
	@Inject protected SettlementCurrencyLeg1Rule settlementCurrencyLeg1Rule;
	@Inject protected SettlementCurrencyLeg2Rule settlementCurrencyLeg2Rule;
	@Inject protected SettlementLocationRule settlementLocationRule;
	@Inject protected SpreadCurrencyLeg1Rule spreadCurrencyLeg1Rule;
	@Inject protected SpreadCurrencyLeg2Rule spreadCurrencyLeg2Rule;
	@Inject protected SpreadLeg1Rule spreadLeg1Rule;
	@Inject protected SpreadLeg2Rule spreadLeg2Rule;
	@Inject protected SpreadNotationLeg1Rule spreadNotationLeg1Rule;
	@Inject protected SpreadNotationLeg2Rule spreadNotationLeg2Rule;
	@Inject protected StrikePriceCurrencyCurrencyPairRule strikePriceCurrencyCurrencyPairRule;
	@Inject protected StrikePriceNotationRule strikePriceNotationRule;
	@Inject protected StrikePriceRule strikePriceRule;
	@Inject protected SubmitterIdentifierRule submitterIdentifierRule;
	@Inject protected SubsequentPositionUTIRule subsequentPositionUTIRule;
	@Inject protected TotalNotionalQuantityLeg1Rule totalNotionalQuantityLeg1Rule;
	@Inject protected TotalNotionalQuantityLeg2Rule totalNotionalQuantityLeg2Rule;
	@Inject protected UnderlyingAssetTypeRule underlyingAssetTypeRule;
	@Inject protected UniqueProductIdentifierRule uniqueProductIdentifierRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected UpiPostEnrichmentDataRule upiPostEnrichmentDataRule;
	@Inject protected UpiPreEnrichmentDataRule upiPreEnrichmentDataRule;
	@Inject protected emptyRuleRule _emptyRuleRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CSATransactionReportPPD evaluate(TransactionReportInstruction input) {
		CSATransactionReportPPD.CSATransactionReportPPDBuilder outputBuilder = doEvaluate(input);
		
		final CSATransactionReportPPD output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(CSATransactionReportPPD.class, output);
		}
		
		return output;
	}

	protected abstract CSATransactionReportPPD.CSATransactionReportPPDBuilder doEvaluate(TransactionReportInstruction input);

	public static class CSAPPDReportFunctionDefault extends CSAPPDReportFunction {
		@Override
		protected CSATransactionReportPPD.CSATransactionReportPPDBuilder doEvaluate(TransactionReportInstruction input) {
			CSATransactionReportPPD.CSATransactionReportPPDBuilder output = CSATransactionReportPPD.builder();
			return assignOutput(output, input);
		}
		
		protected CSATransactionReportPPD.CSATransactionReportPPDBuilder assignOutput(CSATransactionReportPPD.CSATransactionReportPPDBuilder output, TransactionReportInstruction input) {
			output
				.setEffectiveDate(effectiveDateRule.evaluate(input));
			
			output
				.setReportingTimestamp(reportingTimestampRule.evaluate(input));
			
			output
				.setExecutionTimestamp(executionTimestampRule.evaluate(input));
			
			output
				.setExpirationDate(expirationDateRule.evaluate(input));
			
			output
				.setCounterparty1(counterparty1Rule.evaluate(input));
			
			output
				.setCounterparty2(counterparty2Rule.evaluate(input));
			
			output
				.setCounterparty2IdentifierType(counterparty2IdentifierTypeIndicatorRule.evaluate(input));
			
			output
				.setClearedOverriddenAsClearedEnum(clearedRule.evaluate(input));
			
			output
				.setCallAmount(callAmountRule.evaluate(input));
			
			output
				.setPutAmount(putAmountRule.evaluate(input));
			
			output
				.setCallCurrency(callCurrencyRule.evaluate(input));
			
			output
				.setPutCurrency(putCurrencyRule.evaluate(input));
			
			output
				.setPrice(priceRule.evaluate(input));
			
			output
				.setPriceNotation(priceNotationRule.evaluate(input));
			
			output
				.setPriceCurrency(priceCurrencyRule.evaluate(input));
			
			output
				.setPackageTransactionPrice(packageTransactionPriceRule.evaluate(input));
			
			output
				.setPackageTransactionPriceNotation(packageTransactionPriceNotationRule.evaluate(input));
			
			output
				.setPackageTransactionPriceCurrency(packageTransactionPriceCurrencyRule.evaluate(input));
			
			output
				.setPackageTransactionSpread(packageTransactionSpreadRule.evaluate(input));
			
			output
				.setPackageTransactionSpreadNotation(packageTransactionSpreadNotationRule.evaluate(input));
			
			output
				.setPackageTransactionSpreadCurrency(packageTransactionSpreadCurrencyRule.evaluate(input));
			
			output
				.setStrikePrice(strikePriceRule.evaluate(input));
			
			output
				.setStrikePriceNotation(strikePriceNotationRule.evaluate(input));
			
			output
				.setStrikePriceCurrency(strikePriceCurrencyCurrencyPairRule.evaluate(input));
			
			output
				.setPriceUnitOfMeasure(priceUnitOfMeasureRule.evaluate(input));
			
			output
				.setOptionPremiumAmount(optionPremiumAmountRule.evaluate(input));
			
			output
				.setOptionPremiumCurrency(optionPremiumCurrencyRule.evaluate(input));
			
			output
				.setExchangeRate(exchangeRateRule.evaluate(input));
			
			output
				.setExchangeRateBasis(exchangeRateBasisRule.evaluate(input));
			
			output
				.setFirstExerciseDate(firstExerciseDateRule.evaluate(input));
			
			output
				.setSettlementLocation(settlementLocationRule.evaluate(input));
			
			output
				.setOtherPayment(otherPaymentRule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFixedRateDayCountConvention(fixedRateDayCountConventionLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateDayCountConvention(floatingRateDayCountConventionLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriod(fixedRatePaymentFrequencyPeriodLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriod(floatingRatePaymentFrequencyPeriodLeg1Rule.evaluate(input));
			
			final BigDecimal bigDecimal0 = fixedRatePaymentFrequencyPeriodMultiplierLeg1Rule.evaluate(input);
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriodMultiplier((bigDecimal0 == null ? null : bigDecimal0.intValueExact()));
			
			final BigDecimal bigDecimal1 = floatingRatePaymentFrequencyPeriodMultiplierLeg1Rule.evaluate(input);
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriodMultiplier((bigDecimal1 == null ? null : bigDecimal1.intValueExact()));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyPeriod(floatingRateResetFrequencyPeriodOfLeg1Rule.evaluate(input));
			
			final BigDecimal bigDecimal2 = floatingRateResetFrequencyMultiplierOfLeg1Rule.evaluate(input);
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyMultiplier((bigDecimal2 == null ? null : bigDecimal2.intValueExact()));
			
			output
				.getOrCreateLeg1()
				.setNotionalAmount(notionalAmountLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setNotionalAmountSchedule(notionalAmountScheduleLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setNotionalQuantitySchedule(notionalQuantityScheduleLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setNotionalCurrency(notionalCurrencyLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setTotalNotionalQuantity(totalNotionalQuantityLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setFixedRate(fixedRateLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setSettlementCurrency(settlementCurrencyLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setSpread(spreadLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setSpreadNotation(spreadNotationLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setSpreadCurrency(spreadCurrencyLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setQuantityUnitOfMeasure(quantityUnitOfMeasureLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setNotionalQuantity(notionalQuantityLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setFixingDate(fixingDateLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setQuantityFrequency(quantityFrequencyPeriodLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setQuantityFrequencyMultiplier(quantityFrequencyPeriodMultiplierLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setCommodityUnderlyerID(dTCC_Leg1CommodityUnderlyerIDRule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setCommodityInstrumentID(dTCC_Leg1CommodityInstrumentIDRule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setFloatingRateIndex(dTCC_Leg1FloatingRateIndexRule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFixedRateDayCountConvention(fixedRateDayCountConventionLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateDayCountConvention(floatingRateDayCountConventionLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriod(fixedRatePaymentFrequencyPeriodLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriod(floatingRatePaymentFrequencyPeriodLeg2Rule.evaluate(input));
			
			final BigDecimal bigDecimal3 = fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriodMultiplier((bigDecimal3 == null ? null : bigDecimal3.intValueExact()));
			
			final BigDecimal bigDecimal4 = floatingRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriodMultiplier((bigDecimal4 == null ? null : bigDecimal4.intValueExact()));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyPeriod(floatingRateResetFrequencyPeriodOfLeg2Rule.evaluate(input));
			
			final BigDecimal bigDecimal5 = floatingRateResetFrequencyMultiplierOfLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyMultiplier((bigDecimal5 == null ? null : bigDecimal5.intValueExact()));
			
			output
				.getOrCreateLeg2()
				.setNotionalAmount(notionalAmountLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setNotionalAmountSchedule(notionalAmountScheduleLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setNotionalQuantitySchedule(notionalQuantityScheduleLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setNotionalCurrency(notionalCurrencyLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setTotalNotionalQuantity(totalNotionalQuantityLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setFixedRate(fixedRateLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setSettlementCurrency(settlementCurrencyLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setSpread(spreadLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setSpreadNotation(spreadNotationLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setSpreadCurrency(spreadCurrencyLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setQuantityUnitOfMeasure(quantityUnitOfMeasureLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setNotionalQuantity(notionalQuantityLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setFixingDate(fixingDateLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setQuantityFrequency(quantityFrequencyPeriodLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setQuantityFrequencyMultiplier(quantityFrequencyPeriodMultiplierLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setCommodityUnderlyerID(dTCC_Leg2CommodityUnderlyerIDRule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setCommodityInstrumentID(dTCC_Leg2CommodityInstrumentIDRule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setFloatingRateIndex(dTCC_Leg2FloatingRateIndexRule.evaluate(input));
			
			output
				.setActionType(actionTypeRule.evaluate(input));
			
			output
				.setEventType(eventTypeRule.evaluate(input));
			
			output
				.setEventTimestampOverriddenAsZonedDateTime(eventTimestampRule.evaluate(input));
			
			output
				.setPlatformIdentifier(platformIdentifierRule.evaluate(input));
			
			output
				.setClearingExceptionsAndExemptionsCounterparty1(clearingExceptionsAndExemptionsCounterparty1Rule.evaluate(input));
			
			output
				.setClearingExceptionsAndExemptionsCounterparty2(clearingExceptionsAndExemptionsCounterparty2Rule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(submitterIdentifierRule.evaluate(input));
			
			output
				.setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(counterparty2IdentifierSourceRule.evaluate(input));
			
			output
				.setEmbeddedOptionType(embeddedOptionTypeRule.evaluate(input));
			
			output
				.setNonStandardizedTermIndicator(nonStandardizedTermIndicatorRule.evaluate(input));
			
			output
				.setAmendmentIndicator(amendmentIndicatorRule.evaluate(input));
			
			output
				.setPackageIndicator(packageIndicatorRule.evaluate(input));
			
			output
				.setCustomBasketIndicator(customBasketIndicatorRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setUniqueProductIdentifier(uniqueProductIdentifierRule.evaluate(input));
			
			output
				.setSubsequentPositionUTI(subsequentPositionUTIRule.evaluate(input));
			
			output
				.setPriorUSI(priorUSIRule.evaluate(input));
			
			output
				.setIndexFactor(MapperC.of(indexFactorRule.evaluate(input)).get());
			
			output
				.getOrCreateNonReportable()
				.setEnrichment(enrichmentDataRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setPreUpiData(upiPreEnrichmentDataRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setPostUpiData(upiPostEnrichmentDataRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setNotionalSchedule(notionalScheduleRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setUnderlyingAssetType(underlyingAssetTypeRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setInstrumentType(instrumentTypeRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setDeliveryType(deliveryTypeRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setReturnorPayoutTrigger(returnorPayoutTriggerRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setExecutionVenueType(MapperC.of(executionVenueTypeRule.evaluate(input)).get());
			
			output
				.setPlatformAnonymousExecutionIndicator(MapperC.of(platformAnonymousExecutionIndicatorRule.evaluate(input)).get());
			
			output
				.getOrCreateDtccAdditionalFields()
				.setClearingVenueIDType(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty1ClearingBrokerIDType(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSubmittingPartyIDType(dTCC_SubmittingPartyIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSubmittedForParty(dTCC_SubmittedForPartyRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeLegTypes(dTCC_TradeLegTypesRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty1ReportingDestination(dTCC_TradeParty1ReportingDestinationRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty2ReportingDestination(Collections.<SupervisoryBodyEnum>emptyList());
			
			output
				.getOrCreateDtccAdditionalFields()
				.setPrimaryAssetClass(dTCC_PrimaryAssetClassRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSecondaryAssetClass(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setComment1(dTCC_Comment1Rule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setOptionStyle(dTCC_OptionStyleRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setOptionType(dTCC_OptionTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setProductID(dTCC_ProductIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty2ExecutionAgentID(dTCC_TradeParty2ExecutionAgentIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty2ExecutionAgentIDType(dTCC_TradeParty2ExecutionAgentIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty1ExecutionAgentID(dTCC_TradeParty1ExecutionAgentIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty1ExecutionAgentIDType(dTCC_TradeParty1ExecutionAgentIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty1TransactionID(dTCC_TradeParty1TransactionIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSettlementType(dTCC_SettlementTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setProductGrade(Collections.<ProductGradeReport>emptyList());
			
			output
				.getOrCreateDtccAdditionalFields()
				.setDeliveryLocation(dTCC_DeliveryLocationRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg1CommodityInstrumentID(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg2CommodityInstrumentID(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setResponsibleDataSubmitterIDType(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setResponsibleDataSubmitterID(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setMaturityDateOfTheUnderlying(dTCC_MaturityDateOfTheUnderlyingRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setCorporateActionNewTradeParty1Lei(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setOtherPaymentPayerIDType(Collections.<String>emptyList());
			
			output
				.getOrCreateDtccAdditionalFields()
				.setOtherPaymentReceiverIDType(Collections.<String>emptyList());
			
			output
				.getOrCreateDtccAdditionalFields()
				.setExecutionVenueID(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setExecutionVenueIDType(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg1FloatingRateIndex(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg2FloatingRateIndex(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setUnderlyingAssetName(dTCC_UnderlyingAssetNameRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setUnderlyingAsset(dTCC_UnderlyingAssetReportRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty1IDType(dTCC_TradeParty1IDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setAllocationType(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setUsiID(dTCC_USIIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setUsiIDPrefix(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setNewSDRIdentifier(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setMessageID(dTCC_MessageIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg1CommodityUnderlyerID(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg2CommodityUnderlyerID(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setMessageTypeTransaction(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setMessageTypePPD(dTCC_MessageTypePPDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg1SettlementPeriod(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLoadType(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty1BrokerIDType(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setVersionTransaction(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setVersionPPD(dTCC_VersionPPDRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
