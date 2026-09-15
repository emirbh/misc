package drr.regulation.sec.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.reports.EnrichmentDataRule;
import drr.enrichment.common.reports.UpiPostEnrichmentDataRule;
import drr.enrichment.common.reports.UpiPreEnrichmentDataRule;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.reports.DTCC_ClearingVenueIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_Comment1Rule;
import drr.regulation.common.dtcc.trade.reports.DTCC_CorporateActionNewTradeParty1LEIRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_MaturityDateOfTheUnderlyingRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_OtherPaymentPayerIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_OtherPaymentReceiverIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_PrimaryAssetClassRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_ResponsibleDataSubmitterIDRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_ResponsibleDataSubmitterIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_SecondaryAssetClassRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_SubmittedForPartyRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_SubmittingPartyIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty1ClearingBrokerIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty1ExecutionAgentIDRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty1ExecutionAgentIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty1ReportingDestinationRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty2ExecutionAgentIDRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty2ExecutionAgentIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_TradeParty2ReportingDestinationRule;
import drr.regulation.common.trade.link.reports.PriorUSIRule;
import drr.regulation.common.trade.party.reports.Counterparty2IdentifierSourceRule;
import drr.regulation.common.trade.party.reports.ReportSubmittingEntityRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_ExecutionVenueIDRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_ExecutionVenueIDTypeRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_Leg1FloatingRateIndexRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_Leg2FloatingRateIndexRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_MessageIDRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_SEFOrDCMAnonymousExecutionIndicatorRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_TradeParty1IDTypeRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_TradeParty1TransactionIDRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_UnderlyingAssetNameRule;
import drr.regulation.sec.rewrite.dtcc.reports.DTCC_UnderlyingAssetReportRule;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import drr.regulation.sec.rewrite.trade.labels.SECTradeLabelProvider;
import drr.standards.iosco.cde.version3.datetime.reports.EventTimestampRule;
import drr.standards.iosco.cde.version3.datetime.reports.ReportingTimestampRule;
import drr.standards.iosco.cde.version3.event.reports.ActionTypeRule;
import drr.standards.iosco.cde.version3.event.reports.LevelRule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2Rule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.sec.rewrite.trade", body="SEC", corpusList={"Trade"})
@RuneLabelProvider(labelProvider=SECTradeLabelProvider.class)
@ImplementedBy(SECTradeReportFunction.SECTradeReportFunctionDefault.class)
public abstract class SECTradeReportFunction implements ReportFunction<TransactionReportInstruction, SECTransactionReportTrade> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected AllocationIndicatorRule allocationIndicatorRule;
	@Inject protected AmendmentIndicatorRule amendmentIndicatorRule;
	@Inject protected BuyerIdentifierRule buyerIdentifierRule;
	@Inject protected CDSIndexAttachmentPointRule cDSIndexAttachmentPointRule;
	@Inject protected CDSIndexDetachmentPointRule cDSIndexDetachmentPointRule;
	@Inject protected CallAmountRule callAmountRule;
	@Inject protected CallCurrencyRule callCurrencyRule;
	@Inject protected CentralCounterpartyRule centralCounterpartyRule;
	@Inject protected ClearedRule clearedRule;
	@Inject protected ClearingAccountOriginRule clearingAccountOriginRule;
	@Inject protected ClearingExceptionsAndExemptionsCounterparty1Rule clearingExceptionsAndExemptionsCounterparty1Rule;
	@Inject protected ClearingExceptionsAndExemptionsCounterparty2Rule clearingExceptionsAndExemptionsCounterparty2Rule;
	@Inject protected ClearingMemberRule clearingMemberRule;
	@Inject protected ClearingReceiptTimestampRule clearingReceiptTimestampRule;
	@Inject protected ClearingSwapUSIsRule clearingSwapUSIsRule;
	@Inject protected ClearingSwapUTIsRule clearingSwapUTIsRule;
	@Inject protected Counterparty1FinancialEntityIndicatorRule counterparty1FinancialEntityIndicatorRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2FinancialEntityIndicatorRule counterparty2FinancialEntityIndicatorRule;
	@Inject protected Counterparty2IdentifierSourceRule counterparty2IdentifierSourceRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CustomBasketIndicatorRule customBasketIndicatorRule;
	@Inject protected DTCC_ClearingVenueIDTypeRule dTCC_ClearingVenueIDTypeRule;
	@Inject protected DTCC_Comment1Rule dTCC_Comment1Rule;
	@Inject protected DTCC_CorporateActionNewTradeParty1LEIRule dTCC_CorporateActionNewTradeParty1LEIRule;
	@Inject protected DTCC_ExecutionVenueIDRule dTCC_ExecutionVenueIDRule;
	@Inject protected DTCC_ExecutionVenueIDTypeRule dTCC_ExecutionVenueIDTypeRule;
	@Inject protected DTCC_Leg1FloatingRateIndexRule dTCC_Leg1FloatingRateIndexRule;
	@Inject protected DTCC_Leg2FloatingRateIndexRule dTCC_Leg2FloatingRateIndexRule;
	@Inject protected DTCC_MaturityDateOfTheUnderlyingRule dTCC_MaturityDateOfTheUnderlyingRule;
	@Inject protected DTCC_MessageIDRule dTCC_MessageIDRule;
	@Inject protected DTCC_OtherPaymentPayerIDTypeRule dTCC_OtherPaymentPayerIDTypeRule;
	@Inject protected DTCC_OtherPaymentReceiverIDTypeRule dTCC_OtherPaymentReceiverIDTypeRule;
	@Inject protected DTCC_PrimaryAssetClassRule dTCC_PrimaryAssetClassRule;
	@Inject protected DTCC_ResponsibleDataSubmitterIDRule dTCC_ResponsibleDataSubmitterIDRule;
	@Inject protected DTCC_ResponsibleDataSubmitterIDTypeRule dTCC_ResponsibleDataSubmitterIDTypeRule;
	@Inject protected DTCC_SEFOrDCMAnonymousExecutionIndicatorRule dTCC_SEFOrDCMAnonymousExecutionIndicatorRule;
	@Inject protected DTCC_SecondaryAssetClassRule dTCC_SecondaryAssetClassRule;
	@Inject protected DTCC_SubmittedForPartyRule dTCC_SubmittedForPartyRule;
	@Inject protected DTCC_SubmittingPartyIDTypeRule dTCC_SubmittingPartyIDTypeRule;
	@Inject protected DTCC_TradeParty1ClearingBrokerIDTypeRule dTCC_TradeParty1ClearingBrokerIDTypeRule;
	@Inject protected DTCC_TradeParty1ExecutionAgentIDRule dTCC_TradeParty1ExecutionAgentIDRule;
	@Inject protected DTCC_TradeParty1ExecutionAgentIDTypeRule dTCC_TradeParty1ExecutionAgentIDTypeRule;
	@Inject protected DTCC_TradeParty1IDTypeRule dTCC_TradeParty1IDTypeRule;
	@Inject protected DTCC_TradeParty1ReportingDestinationRule dTCC_TradeParty1ReportingDestinationRule;
	@Inject protected DTCC_TradeParty1TransactionIDRule dTCC_TradeParty1TransactionIDRule;
	@Inject protected DTCC_TradeParty2ExecutionAgentIDRule dTCC_TradeParty2ExecutionAgentIDRule;
	@Inject protected DTCC_TradeParty2ExecutionAgentIDTypeRule dTCC_TradeParty2ExecutionAgentIDTypeRule;
	@Inject protected DTCC_TradeParty2ReportingDestinationRule dTCC_TradeParty2ReportingDestinationRule;
	@Inject protected DTCC_UnderlyingAssetNameRule dTCC_UnderlyingAssetNameRule;
	@Inject protected DTCC_UnderlyingAssetReportRule dTCC_UnderlyingAssetReportRule;
	@Inject protected EffectiveDateRule effectiveDateRule;
	@Inject protected EmbeddedOptionTypeRule embeddedOptionTypeRule;
	@Inject protected EnrichmentDataRule enrichmentDataRule;
	@Inject protected EventIdentifierRule eventIdentifierRule;
	@Inject protected EventTimestampRule eventTimestampRule;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected ExecutionTimestampRule executionTimestampRule;
	@Inject protected ExpirationDateRule expirationDateRule;
	@Inject protected FinalContractualSettlementDateRule finalContractualSettlementDateRule;
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
	@Inject protected FloatingRateResetFrequencyPeriodLeg1Rule floatingRateResetFrequencyPeriodLeg1Rule;
	@Inject protected FloatingRateResetFrequencyPeriodLeg2Rule floatingRateResetFrequencyPeriodLeg2Rule;
	@Inject protected FloatingRateResetFrequencyPeriodMultiplierLeg1Rule floatingRateResetFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected FloatingRateResetFrequencyPeriodMultiplierLeg2Rule floatingRateResetFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected IndexFactorRule indexFactorRule;
	@Inject protected JurisdictionRule jurisdictionRule;
	@Inject protected LevelRule levelRule;
	@Inject protected NewSDRIdentifierRule newSDRIdentifierRule;
	@Inject protected NonStandardizedTermIndicatorRule nonStandardizedTermIndicatorRule;
	@Inject protected NotionalAmountLeg1Rule notionalAmountLeg1Rule;
	@Inject protected NotionalAmountLeg2Rule notionalAmountLeg2Rule;
	@Inject protected NotionalAmountScheduleLeg1Rule notionalAmountScheduleLeg1Rule;
	@Inject protected NotionalAmountScheduleLeg2Rule notionalAmountScheduleLeg2Rule;
	@Inject protected NotionalCurrencyLeg1Rule notionalCurrencyLeg1Rule;
	@Inject protected NotionalCurrencyLeg2Rule notionalCurrencyLeg2Rule;
	@Inject protected OptionPremiumAmountRule optionPremiumAmountRule;
	@Inject protected OptionPremiumCurrencyRule optionPremiumCurrencyRule;
	@Inject protected OptionPremiumPaymentDateRule optionPremiumPaymentDateRule;
	@Inject protected OriginalSwapSDRIdentifierRule originalSwapSDRIdentifierRule;
	@Inject protected OriginalSwapUSIRule originalSwapUSIRule;
	@Inject protected OriginalSwapUTIRule originalSwapUTIRule;
	@Inject protected OtherPaymentRule otherPaymentRule;
	@Inject protected PackageIdentifierRule packageIdentifierRule;
	@Inject protected PackageIndicatorRule packageIndicatorRule;
	@Inject protected PackageTransactionPriceCurrencyRule packageTransactionPriceCurrencyRule;
	@Inject protected PackageTransactionPriceNotationRule packageTransactionPriceNotationRule;
	@Inject protected PackageTransactionPriceRule packageTransactionPriceRule;
	@Inject protected PackageTransactionSpreadCurrencyRule packageTransactionSpreadCurrencyRule;
	@Inject protected PackageTransactionSpreadNotationRule packageTransactionSpreadNotationRule;
	@Inject protected PackageTransactionSpreadRule packageTransactionSpreadRule;
	@Inject protected PayerIdentifierLeg1Rule payerIdentifierLeg1Rule;
	@Inject protected PayerIdentifierLeg2Rule payerIdentifierLeg2Rule;
	@Inject protected PlatformIdentifierRule platformIdentifierRule;
	@Inject protected PostPricedSwapIndicatorRule postPricedSwapIndicatorRule;
	@Inject protected PriceCurrencyRule priceCurrencyRule;
	@Inject protected PriceNotationRule priceNotationRule;
	@Inject protected PriceRule priceRule;
	@Inject protected PriceUnitOfMeasureRule priceUnitOfMeasureRule;
	@Inject protected PriorUSIRule priorUSIRule;
	@Inject protected PriorUTIRule priorUTIRule;
	@Inject protected PutAmountRule putAmountRule;
	@Inject protected PutCurrencyRule putCurrencyRule;
	@Inject protected QuantityUnitOfMeasureLeg1Rule quantityUnitOfMeasureLeg1Rule;
	@Inject protected QuantityUnitOfMeasureLeg2Rule quantityUnitOfMeasureLeg2Rule;
	@Inject protected ReceiverIdentifierLeg1Rule receiverIdentifierLeg1Rule;
	@Inject protected ReceiverIdentifierLeg2Rule receiverIdentifierLeg2Rule;
	@Inject protected ReportSubmittingEntityRule reportSubmittingEntityRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected SellerIdentifierRule sellerIdentifierRule;
	@Inject protected SettlementCurrencyLeg1Rule settlementCurrencyLeg1Rule;
	@Inject protected SettlementCurrencyLeg2Rule settlementCurrencyLeg2Rule;
	@Inject protected SettlementLocationLeg1Rule settlementLocationLeg1Rule;
	@Inject protected SpreadCurrencyLeg1Rule spreadCurrencyLeg1Rule;
	@Inject protected SpreadCurrencyLeg2Rule spreadCurrencyLeg2Rule;
	@Inject protected SpreadLeg1Rule spreadLeg1Rule;
	@Inject protected SpreadLeg2Rule spreadLeg2Rule;
	@Inject protected SpreadNotationLeg1Rule spreadNotationLeg1Rule;
	@Inject protected SpreadNotationLeg2Rule spreadNotationLeg2Rule;
	@Inject protected StrikePriceCurrencyCurrencyPairRule strikePriceCurrencyCurrencyPairRule;
	@Inject protected StrikePriceNotationRule strikePriceNotationRule;
	@Inject protected StrikePriceRule strikePriceRule;
	@Inject protected TotalNotionalQuantityLeg1Rule totalNotionalQuantityLeg1Rule;
	@Inject protected TotalNotionalQuantityLeg2Rule totalNotionalQuantityLeg2Rule;
	@Inject protected UniqueProductIdentifierRule uniqueProductIdentifierRule;
	@Inject protected UniqueSwapIdentifierRule uniqueSwapIdentifierRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected UpiPostEnrichmentDataRule upiPostEnrichmentDataRule;
	@Inject protected UpiPreEnrichmentDataRule upiPreEnrichmentDataRule;
	@Inject protected emptyRuleRule _emptyRuleRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public SECTransactionReportTrade evaluate(TransactionReportInstruction input) {
		SECTransactionReportTrade.SECTransactionReportTradeBuilder outputBuilder = doEvaluate(input);
		
		final SECTransactionReportTrade output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(SECTransactionReportTrade.class, output);
		}
		
		return output;
	}

	protected abstract SECTransactionReportTrade.SECTransactionReportTradeBuilder doEvaluate(TransactionReportInstruction input);

	public static class SECTradeReportFunctionDefault extends SECTradeReportFunction {
		@Override
		protected SECTransactionReportTrade.SECTransactionReportTradeBuilder doEvaluate(TransactionReportInstruction input) {
			SECTransactionReportTrade.SECTransactionReportTradeBuilder output = SECTransactionReportTrade.builder();
			return assignOutput(output, input);
		}
		
		protected SECTransactionReportTrade.SECTransactionReportTradeBuilder assignOutput(SECTransactionReportTrade.SECTransactionReportTradeBuilder output, TransactionReportInstruction input) {
			output
				.setEffectiveDateOverriddenAsDate(effectiveDateRule.evaluate(input));
			
			output
				.setReportingTimestamp(reportingTimestampRule.evaluate(input));
			
			output
				.setExecutionTimestampOverriddenAsZonedDateTime(executionTimestampRule.evaluate(input));
			
			output
				.setExpirationDate(expirationDateRule.evaluate(input));
			
			output
				.setCounterparty1(counterparty1Rule.evaluate(input));
			
			output
				.setCounterparty2OverriddenAsString(counterparty2Rule.evaluate(input));
			
			output
				.setBuyerIdentifier(buyerIdentifierRule.evaluate(input));
			
			output
				.setSellerIdentifier(sellerIdentifierRule.evaluate(input));
			
			output
				.setClearedOverriddenAsClearedEnum(clearedRule.evaluate(input));
			
			output
				.setCentralCounterparty(centralCounterpartyRule.evaluate(input));
			
			output
				.setClearingMember(clearingMemberRule.evaluate(input));
			
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
				.setPackageIdentifier(packageIdentifierRule.evaluate(input));
			
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
				.setOptionPremiumPaymentDate(optionPremiumPaymentDateRule.evaluate(input));
			
			output
				.setCdSIndexAttachmentPoint(cDSIndexAttachmentPointRule.evaluate(input));
			
			output
				.setCdSIndexDetachmentPoint(cDSIndexDetachmentPointRule.evaluate(input));
			
			output
				.setFirstExerciseDate(firstExerciseDateRule.evaluate(input));
			
			output
				.setFinalContractualSettlementDate(finalContractualSettlementDateRule.evaluate(input));
			
			output
				.setSettlementLocation(settlementLocationLeg1Rule.evaluate(input));
			
			output
				.setPriorUTI(priorUTIRule.evaluate(input));
			
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
				.setFloatingRateResetFrequencyPeriod(floatingRateResetFrequencyPeriodLeg1Rule.evaluate(input));
			
			final BigDecimal bigDecimal2 = floatingRateResetFrequencyPeriodMultiplierLeg1Rule.evaluate(input);
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
				.setFixingDate(fixingDateLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setPayerIdentifier(payerIdentifierLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setReceiverIdentifier(receiverIdentifierLeg1Rule.evaluate(input));
			
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
				.setFloatingRateResetFrequencyPeriod(floatingRateResetFrequencyPeriodLeg2Rule.evaluate(input));
			
			final BigDecimal bigDecimal5 = floatingRateResetFrequencyPeriodMultiplierLeg2Rule.evaluate(input);
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
				.setFixingDate(fixingDateLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setPayerIdentifier(payerIdentifierLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setReceiverIdentifier(receiverIdentifierLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setFloatingRateIndex(dTCC_Leg2FloatingRateIndexRule.evaluate(input));
			
			output
				.setLevel(levelRule.evaluate(input));
			
			output
				.setActionType(actionTypeRule.evaluate(input));
			
			output
				.setEventType(eventTypeRule.evaluate(input));
			
			output
				.setEventIdentifier(eventIdentifierRule.evaluate(input));
			
			output
				.setEventTimestampOverriddenAsZonedDateTime(eventTimestampRule.evaluate(input));
			
			output
				.setPlatformIdentifier(platformIdentifierRule.evaluate(input));
			
			output
				.setClearingExceptionsAndExemptionsCounterparty1(clearingExceptionsAndExemptionsCounterparty1Rule.evaluate(input));
			
			output
				.setClearingExceptionsAndExemptionsCounterparty2(clearingExceptionsAndExemptionsCounterparty2Rule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(reportSubmittingEntityRule.evaluate(input));
			
			output
				.setCounterparty2IdentifierSourceOverriddenAsCounterparty2IdentifierEnum(counterparty2IdentifierSourceRule.evaluate(input));
			
			output
				.setEmbeddedOptionType(embeddedOptionTypeRule.evaluate(input));
			
			output
				.setNonStandardizedTermIndicator(nonStandardizedTermIndicatorRule.evaluate(input));
			
			output
				.setAmendmentIndicator(amendmentIndicatorRule.evaluate(input));
			
			output
				.setPackageIndicatorOverriddenAsBoolean(packageIndicatorRule.evaluate(input));
			
			output
				.setCustomBasketIndicatorOverriddenAsBoolean(customBasketIndicatorRule.evaluate(input));
			
			output
				.setClearingAccountOrigin(clearingAccountOriginRule.evaluate(input));
			
			output
				.setClearingReceiptTimestamp(clearingReceiptTimestampRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setUniqueProductIdentifier(uniqueProductIdentifierRule.evaluate(input));
			
			output
				.setOriginalSwapUTI(originalSwapUTIRule.evaluate(input));
			
			output
				.setOriginalSwapSDRIdentifier(originalSwapSDRIdentifierRule.evaluate(input));
			
			output
				.setPriorUSI(priorUSIRule.evaluate(input));
			
			output
				.setNewSDRIdentifier(newSDRIdentifierRule.evaluate(input));
			
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
				.setPostPricedSwapIndicator(postPricedSwapIndicatorRule.evaluate(input));
			
			output
				.setUniqueSwapIdentifier(uniqueSwapIdentifierRule.evaluate(input));
			
			output
				.setCounterparty1FinancialEntityIndicator(counterparty1FinancialEntityIndicatorRule.evaluate(input));
			
			output
				.setCounterparty2FinancialEntityIndicator(counterparty2FinancialEntityIndicatorRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setClearingVenueIDType(dTCC_ClearingVenueIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty1ClearingBrokerIDType(dTCC_TradeParty1ClearingBrokerIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSubmittingPartyIDType(dTCC_SubmittingPartyIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSubmittedForParty(dTCC_SubmittedForPartyRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty1ReportingDestination(dTCC_TradeParty1ReportingDestinationRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setTradeParty2ReportingDestination(dTCC_TradeParty2ReportingDestinationRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setPrimaryAssetClass(dTCC_PrimaryAssetClassRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSecondaryAssetClass(dTCC_SecondaryAssetClassRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setComment1(dTCC_Comment1Rule.evaluate(input));
			
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
				.setOtherPaymentPayerIDType(dTCC_OtherPaymentPayerIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setOtherPaymentReceiverIDType(dTCC_OtherPaymentReceiverIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSefOrDcmAnonymousExecutionIndicator(dTCC_SEFOrDCMAnonymousExecutionIndicatorRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setExecutionVenueID(dTCC_ExecutionVenueIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setExecutionVenueIDType(dTCC_ExecutionVenueIDTypeRule.evaluate(input));
			
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
				.setMessageID(dTCC_MessageIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setMessageTypePPD(null);
			
			output
				.getOrCreateDtccAdditionalFields()
				.setVersionPPD(null);
			
			output
				.setClearingSwapUSIs(clearingSwapUSIsRule.evaluate(input));
			
			output
				.setClearingSwapUTIs(clearingSwapUTIsRule.evaluate(input));
			
			output
				.setOriginalSwapUSI(originalSwapUSIRule.evaluate(input));
			
			output
				.setAllocationIndicator(allocationIndicatorRule.evaluate(input));
			
			output
				.setJurisdiction(jurisdictionRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
