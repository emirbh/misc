package drr.regulation.cftc.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.reports.EnrichmentDataRule;
import drr.enrichment.common.reports.UpiPostEnrichmentDataRule;
import drr.enrichment.common.reports.UpiPreEnrichmentDataRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_ChangeInNotionalAmount1Rule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_ChangeInNotionalAmount2Rule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_ClearingVenueIDTypeRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_LargeNotionalOffFacilitySwapElectionIndicatorRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_Leg1CommodityUnderlyerIDRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_Leg2CommodityUnderlyerIDRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_MandatoryClearingIndicatorRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_MessageIDRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_MessageTypeTransactionRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_OriginalSwapSDRIDTypeRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_OtherPaymentPayerIDTypeRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_OtherPaymentReceiverIDTypeRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_PhysicalCommodityContractIndicatorRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_ProductGradeRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_SDMSPIndicatorCounterparty1Rule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_SDMSPIndicatorCounterparty2Rule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_SEFOrDCMAnonymousExecutionIndicatorRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_SEFOrDCMIndicatorRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_SecondaryAssetClassRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_TradeParty1ClearingBrokerIDTypeRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_TradeParty1IDTypeRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_TradeParty1TransactionIDRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_TradeParty2ReportingDestinationRule;
import drr.regulation.cftc.rewrite.dtcc.trade.reports.DTCC_VersionTransactionRule;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.regulation.cftc.rewrite.trade.labels.CFTCPart45LabelProvider;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.dtcc.trade.reports.DTCC_Comment1Rule;
import drr.regulation.common.dtcc.trade.reports.DTCC_CorporateActionNewTradeParty1LEIRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_DeliveryLocationRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_ExecutionVenueIDRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_ExecutionVenueIDTypeRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_Leg1CommodityInstrumentIDRule;
import drr.regulation.common.dtcc.trade.reports.DTCC_Leg2CommodityInstrumentIDRule;
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
import drr.regulation.common.trade.datetime.reports.ClearingTimestampRule;
import drr.regulation.common.trade.execution.reports.TraderLocationRule;
import drr.regulation.common.trade.party.reports.Counterparty2IdentifierSourceRule;
import drr.regulation.common.trade.party.reports.Counterparty2NameRule;
import drr.regulation.common.trade.party.reports.CountryOfCounterparty2Rule;
import drr.regulation.common.trade.party.reports.ExecutionAgentCounterparty1Rule;
import drr.regulation.common.trade.party.reports.ExecutionAgentCounterparty2Rule;
import drr.regulation.common.trade.party.reports.ReportSubmittingEntityRule;
import drr.regulation.common.trade.price.reports.SingleOrUpperAndLowerBarrierRule;
import drr.regulation.common.trade.quantity.reports.NotionalQuantityLeg2Rule;
import drr.regulation.common.trade.quantity.reports.NotionalScheduleRule;
import drr.standards.iosco.cde.version3.datetime.reports.EarlyTerminationDateRule;
import drr.standards.iosco.cde.version3.datetime.reports.EventTimestampRule;
import drr.standards.iosco.cde.version3.datetime.reports.ReportingTimestampRule;
import drr.standards.iosco.cde.version3.event.reports.ActionTypeRule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2Rule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.cftc.rewrite.trade", body="CFTC", corpusList={"Part45"})
@RuneLabelProvider(labelProvider=CFTCPart45LabelProvider.class)
@ImplementedBy(CFTCPart45ReportFunction.CFTCPart45ReportFunctionDefault.class)
public abstract class CFTCPart45ReportFunction implements ReportFunction<TransactionReportInstruction, CFTCPart45TransactionReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected AllocationIndicatorRule allocationIndicatorRule;
	@Inject protected AmendmentIndicatorRule amendmentIndicatorRule;
	@Inject protected BlockTradeElectionIndicatorRule blockTradeElectionIndicatorRule;
	@Inject protected BuyerIdentifierFormatRule buyerIdentifierFormatRule;
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
	@Inject protected ClearingTimestampRule clearingTimestampRule;
	@Inject protected Counterparty1FederalEntityIndicatorRule counterparty1FederalEntityIndicatorRule;
	@Inject protected Counterparty1FinancialEntityIndicatorRule counterparty1FinancialEntityIndicatorRule;
	@Inject protected Counterparty1FormatRule counterparty1FormatRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2FederalEntityIndicatorRule counterparty2FederalEntityIndicatorRule;
	@Inject protected Counterparty2FinancialEntityIndicatorRule counterparty2FinancialEntityIndicatorRule;
	@Inject protected Counterparty2FormatRule counterparty2FormatRule;
	@Inject protected Counterparty2IdentifierSourceRule counterparty2IdentifierSourceRule;
	@Inject protected Counterparty2NameRule counterparty2NameRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CountryOfCounterparty2Rule countryOfCounterparty2Rule;
	@Inject protected CustomBasketIndicatorRule customBasketIndicatorRule;
	@Inject protected DTCC_ChangeInNotionalAmount1Rule dTCC_ChangeInNotionalAmount1Rule;
	@Inject protected DTCC_ChangeInNotionalAmount2Rule dTCC_ChangeInNotionalAmount2Rule;
	@Inject protected DTCC_ClearingVenueIDTypeRule dTCC_ClearingVenueIDTypeRule;
	@Inject protected DTCC_Comment1Rule dTCC_Comment1Rule;
	@Inject protected DTCC_CorporateActionNewTradeParty1LEIRule dTCC_CorporateActionNewTradeParty1LEIRule;
	@Inject protected DTCC_DeliveryLocationRule dTCC_DeliveryLocationRule;
	@Inject protected DTCC_ExecutionVenueIDRule dTCC_ExecutionVenueIDRule;
	@Inject protected DTCC_ExecutionVenueIDTypeRule dTCC_ExecutionVenueIDTypeRule;
	@Inject protected DTCC_LargeNotionalOffFacilitySwapElectionIndicatorRule dTCC_LargeNotionalOffFacilitySwapElectionIndicatorRule;
	@Inject protected DTCC_Leg1CommodityInstrumentIDRule dTCC_Leg1CommodityInstrumentIDRule;
	@Inject protected DTCC_Leg1CommodityUnderlyerIDRule dTCC_Leg1CommodityUnderlyerIDRule;
	@Inject protected DTCC_Leg2CommodityInstrumentIDRule dTCC_Leg2CommodityInstrumentIDRule;
	@Inject protected DTCC_Leg2CommodityUnderlyerIDRule dTCC_Leg2CommodityUnderlyerIDRule;
	@Inject protected DTCC_MandatoryClearingIndicatorRule dTCC_MandatoryClearingIndicatorRule;
	@Inject protected DTCC_MaturityDateOfTheUnderlyingRule dTCC_MaturityDateOfTheUnderlyingRule;
	@Inject protected DTCC_MessageIDRule dTCC_MessageIDRule;
	@Inject protected DTCC_MessageTypeTransactionRule dTCC_MessageTypeTransactionRule;
	@Inject protected DTCC_OptionStyleRule dTCC_OptionStyleRule;
	@Inject protected DTCC_OptionTypeRule dTCC_OptionTypeRule;
	@Inject protected DTCC_OriginalSwapSDRIDTypeRule dTCC_OriginalSwapSDRIDTypeRule;
	@Inject protected DTCC_OtherPaymentPayerIDTypeRule dTCC_OtherPaymentPayerIDTypeRule;
	@Inject protected DTCC_OtherPaymentReceiverIDTypeRule dTCC_OtherPaymentReceiverIDTypeRule;
	@Inject protected DTCC_PhysicalCommodityContractIndicatorRule dTCC_PhysicalCommodityContractIndicatorRule;
	@Inject protected DTCC_PrimaryAssetClassRule dTCC_PrimaryAssetClassRule;
	@Inject protected DTCC_ProductGradeRule dTCC_ProductGradeRule;
	@Inject protected DTCC_ProductIDRule dTCC_ProductIDRule;
	@Inject protected DTCC_ResponsibleDataSubmitterIDRule dTCC_ResponsibleDataSubmitterIDRule;
	@Inject protected DTCC_ResponsibleDataSubmitterIDTypeRule dTCC_ResponsibleDataSubmitterIDTypeRule;
	@Inject protected DTCC_SDMSPIndicatorCounterparty1Rule dTCC_SDMSPIndicatorCounterparty1Rule;
	@Inject protected DTCC_SDMSPIndicatorCounterparty2Rule dTCC_SDMSPIndicatorCounterparty2Rule;
	@Inject protected DTCC_SEFOrDCMAnonymousExecutionIndicatorRule dTCC_SEFOrDCMAnonymousExecutionIndicatorRule;
	@Inject protected DTCC_SEFOrDCMIndicatorRule dTCC_SEFOrDCMIndicatorRule;
	@Inject protected DTCC_SecondaryAssetClassRule dTCC_SecondaryAssetClassRule;
	@Inject protected DTCC_SettlementTypeRule dTCC_SettlementTypeRule;
	@Inject protected DTCC_SubmittedForPartyRule dTCC_SubmittedForPartyRule;
	@Inject protected DTCC_SubmittingPartyIDTypeRule dTCC_SubmittingPartyIDTypeRule;
	@Inject protected DTCC_TradeLegTypesRule dTCC_TradeLegTypesRule;
	@Inject protected DTCC_TradeParty1ClearingBrokerIDTypeRule dTCC_TradeParty1ClearingBrokerIDTypeRule;
	@Inject protected DTCC_TradeParty1ExecutionAgentIDRule dTCC_TradeParty1ExecutionAgentIDRule;
	@Inject protected DTCC_TradeParty1ExecutionAgentIDTypeRule dTCC_TradeParty1ExecutionAgentIDTypeRule;
	@Inject protected DTCC_TradeParty1IDTypeRule dTCC_TradeParty1IDTypeRule;
	@Inject protected DTCC_TradeParty1ReportingDestinationRule dTCC_TradeParty1ReportingDestinationRule;
	@Inject protected DTCC_TradeParty1TransactionIDRule dTCC_TradeParty1TransactionIDRule;
	@Inject protected DTCC_TradeParty2ExecutionAgentIDRule dTCC_TradeParty2ExecutionAgentIDRule;
	@Inject protected DTCC_TradeParty2ExecutionAgentIDTypeRule dTCC_TradeParty2ExecutionAgentIDTypeRule;
	@Inject protected DTCC_TradeParty2ReportingDestinationRule dTCC_TradeParty2ReportingDestinationRule;
	@Inject protected DTCC_VersionTransactionRule dTCC_VersionTransactionRule;
	@Inject protected DeliveryTypeRule deliveryTypeRule;
	@Inject protected EarlyTerminationDateRule earlyTerminationDateRule;
	@Inject protected EffectiveDateRule effectiveDateRule;
	@Inject protected EmbeddedOptionTypeRule embeddedOptionTypeRule;
	@Inject protected EnrichmentDataRule enrichmentDataRule;
	@Inject protected EventIdentifierRule eventIdentifierRule;
	@Inject protected EventTimestampRule eventTimestampRule;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected ExchangeRateBasisRule exchangeRateBasisRule;
	@Inject protected ExchangeRateRule exchangeRateRule;
	@Inject protected ExecutionAgentCounterparty1Rule executionAgentCounterparty1Rule;
	@Inject protected ExecutionAgentCounterparty2Rule executionAgentCounterparty2Rule;
	@Inject protected ExecutionTimestampRule executionTimestampRule;
	@Inject protected ExecutionVenueTypeRule executionVenueTypeRule;
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
	@Inject protected InitialMarginCollateralPortfolioCodeRule initialMarginCollateralPortfolioCodeRule;
	@Inject protected InstrumentTypeRule instrumentTypeRule;
	@Inject protected JurisdictionRule jurisdictionRule;
	@Inject protected NewSDRIdentifierRule newSDRIdentifierRule;
	@Inject protected NonStandardizedTermIndicatorRule nonStandardizedTermIndicatorRule;
	@Inject protected NotionalAmountLeg1Rule notionalAmountLeg1Rule;
	@Inject protected NotionalAmountLeg2Rule notionalAmountLeg2Rule;
	@Inject protected NotionalAmountScheduleLeg1Rule notionalAmountScheduleLeg1Rule;
	@Inject protected NotionalAmountScheduleLeg2Rule notionalAmountScheduleLeg2Rule;
	@Inject protected NotionalCurrencyLeg1Rule notionalCurrencyLeg1Rule;
	@Inject protected NotionalCurrencyLeg2Rule notionalCurrencyLeg2Rule;
	@Inject protected NotionalQuantityLeg1Rule notionalQuantityLeg1Rule;
	@Inject protected NotionalQuantityLeg2Rule notionalQuantityLeg2Rule;
	@Inject protected NotionalScheduleRule notionalScheduleRule;
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
	@Inject protected PayerLeg1IdentifierFormatRule payerLeg1IdentifierFormatRule;
	@Inject protected PayerLeg2IdentifierFormatRule payerLeg2IdentifierFormatRule;
	@Inject protected PlatformIdentifierRule platformIdentifierRule;
	@Inject protected PostPricedSwapIndicatorRule postPricedSwapIndicatorRule;
	@Inject protected PriceCurrencyRule priceCurrencyRule;
	@Inject protected PriceNotationRule priceNotationRule;
	@Inject protected PriceRule priceRule;
	@Inject protected PriceUnitOfMeasureRule priceUnitOfMeasureRule;
	@Inject protected PrimeBrokerageTransactionIndicatorRule primeBrokerageTransactionIndicatorRule;
	@Inject protected PriorUTIRule priorUTIRule;
	@Inject protected PutAmountRule putAmountRule;
	@Inject protected PutCurrencyRule putCurrencyRule;
	@Inject protected QuantityFrequencyLeg1Rule quantityFrequencyLeg1Rule;
	@Inject protected QuantityFrequencyLeg2Rule quantityFrequencyLeg2Rule;
	@Inject protected QuantityFrequencyMultiplierLeg1Rule quantityFrequencyMultiplierLeg1Rule;
	@Inject protected QuantityFrequencyMultiplierLeg2Rule quantityFrequencyMultiplierLeg2Rule;
	@Inject protected QuantityUnitOfMeasureLeg1Rule quantityUnitOfMeasureLeg1Rule;
	@Inject protected QuantityUnitOfMeasureLeg2Rule quantityUnitOfMeasureLeg2Rule;
	@Inject protected ReceiverIdentifierLeg1Rule receiverIdentifierLeg1Rule;
	@Inject protected ReceiverIdentifierLeg2Rule receiverIdentifierLeg2Rule;
	@Inject protected ReceiverLeg1IdentifierFormatRule receiverLeg1IdentifierFormatRule;
	@Inject protected ReceiverLeg2IdentifierFormatRule receiverLeg2IdentifierFormatRule;
	@Inject protected ReportSubmittingEntityRule reportSubmittingEntityRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected SellerIdentifierFormatRule sellerIdentifierFormatRule;
	@Inject protected SellerIdentifierRule sellerIdentifierRule;
	@Inject protected SettlementCurrencyLeg1Rule settlementCurrencyLeg1Rule;
	@Inject protected SettlementCurrencyLeg2Rule settlementCurrencyLeg2Rule;
	@Inject protected SettlementLocationRule settlementLocationRule;
	@Inject protected SingleOrUpperAndLowerBarrierRule singleOrUpperAndLowerBarrierRule;
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
	@Inject protected TraderLocationRule traderLocationRule;
	@Inject protected UnderlyingAssetTypeRule underlyingAssetTypeRule;
	@Inject protected UniqueProductIdentifierRule uniqueProductIdentifierRule;
	@Inject protected UniqueSwapIdentifierRule uniqueSwapIdentifierRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected UpiPostEnrichmentDataRule upiPostEnrichmentDataRule;
	@Inject protected UpiPreEnrichmentDataRule upiPreEnrichmentDataRule;
	@Inject protected VariationMarginCollateralPortfolioCodeRule variationMarginCollateralPortfolioCodeRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public CFTCPart45TransactionReport evaluate(TransactionReportInstruction input) {
		CFTCPart45TransactionReport.CFTCPart45TransactionReportBuilder outputBuilder = doEvaluate(input);
		
		final CFTCPart45TransactionReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(CFTCPart45TransactionReport.class, output);
		}
		
		return output;
	}

	protected abstract CFTCPart45TransactionReport.CFTCPart45TransactionReportBuilder doEvaluate(TransactionReportInstruction input);

	public static class CFTCPart45ReportFunctionDefault extends CFTCPart45ReportFunction {
		@Override
		protected CFTCPart45TransactionReport.CFTCPart45TransactionReportBuilder doEvaluate(TransactionReportInstruction input) {
			CFTCPart45TransactionReport.CFTCPart45TransactionReportBuilder output = CFTCPart45TransactionReport.builder();
			return assignOutput(output, input);
		}
		
		protected CFTCPart45TransactionReport.CFTCPart45TransactionReportBuilder assignOutput(CFTCPart45TransactionReport.CFTCPart45TransactionReportBuilder output, TransactionReportInstruction input) {
			output
				.setEffectiveDateOverriddenAsDate(effectiveDateRule.evaluate(input));
			
			output
				.setEarlyTerminationDate(earlyTerminationDateRule.evaluate(input));
			
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
				.setExchangeRate(exchangeRateRule.evaluate(input));
			
			output
				.setExchangeRateBasis(exchangeRateBasisRule.evaluate(input));
			
			output
				.setCdSIndexAttachmentPoint(cDSIndexAttachmentPointRule.evaluate(input));
			
			output
				.setCdSIndexDetachmentPoint(cDSIndexDetachmentPointRule.evaluate(input));
			
			output
				.setFirstExerciseDate(firstExerciseDateRule.evaluate(input));
			
			output
				.setFinalContractualSettlementDate(finalContractualSettlementDateRule.evaluate(input));
			
			output
				.setSettlementLocation(settlementLocationRule.evaluate(input));
			
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
				.setNotionalQuantity(notionalQuantityLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setFixingDate(fixingDateLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setQuantityFrequency(quantityFrequencyLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setQuantityFrequencyMultiplier(quantityFrequencyMultiplierLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setPayerIdentifier(payerIdentifierLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setReceiverIdentifier(receiverIdentifierLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setPayerIdentifierFormat(payerLeg1IdentifierFormatRule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setReceiverIdentifierFormat(receiverLeg1IdentifierFormatRule.evaluate(input));
			
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
				.setNotionalQuantity(notionalQuantityLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setFixingDate(fixingDateLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setQuantityFrequency(quantityFrequencyLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setQuantityFrequencyMultiplier(quantityFrequencyMultiplierLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setPayerIdentifier(payerIdentifierLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setReceiverIdentifier(receiverIdentifierLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setPayerIdentifierFormat(payerLeg2IdentifierFormatRule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setReceiverIdentifierFormat(receiverLeg2IdentifierFormatRule.evaluate(input));
			
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
				.setTraderLocation(MapperC.of(traderLocationRule.evaluate(input)).get());
			
			output
				.setExecutionAgentCounterparty1(executionAgentCounterparty1Rule.evaluate(input));
			
			output
				.setExecutionAgentCounterparty2(executionAgentCounterparty2Rule.evaluate(input));
			
			output
				.setClearingExceptionsAndExemptionsCounterparty1(clearingExceptionsAndExemptionsCounterparty1Rule.evaluate(input));
			
			output
				.setClearingExceptionsAndExemptionsCounterparty2(clearingExceptionsAndExemptionsCounterparty2Rule.evaluate(input));
			
			output
				.setCounterparty2Name(counterparty2NameRule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(reportSubmittingEntityRule.evaluate(input));
			
			output
				.setCountryOfTheCounterparty2(countryOfCounterparty2Rule.evaluate(input));
			
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
				.setClearingTimestamp(clearingTimestampRule.evaluate(input));
			
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
				.setNewSDRIdentifier(newSDRIdentifierRule.evaluate(input));
			
			output
				.setIndexFactor(MapperC.of(indexFactorRule.evaluate(input)).get());
			
			output
				.setBarrier(singleOrUpperAndLowerBarrierRule.evaluate(input));
			
			output
				.setInitialMarginCollateralPortfolioCode(initialMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setVariationMarginCollateralPortfolioCode(variationMarginCollateralPortfolioCodeRule.evaluate(input));
			
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
				.setCounterparty1Format(counterparty1FormatRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setCounterparty2Format(counterparty2FormatRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setExecutionVenueType(executionVenueTypeRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setBuyerIdentifierFormat(buyerIdentifierFormatRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setSellerIdentifierFormat(sellerIdentifierFormatRule.evaluate(input));
			
			output
				.setPostPricedSwapIndicator(postPricedSwapIndicatorRule.evaluate(input));
			
			output
				.setBlockTradeElectionIndicator(blockTradeElectionIndicatorRule.evaluate(input));
			
			output
				.setPrimeBrokerageTransactionIndicator(primeBrokerageTransactionIndicatorRule.evaluate(input));
			
			output
				.setUniqueSwapIdentifier(uniqueSwapIdentifierRule.evaluate(input));
			
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
				.setTradeLegTypes(dTCC_TradeLegTypesRule.evaluate(input));
			
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
				.setProductGrade(dTCC_ProductGradeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setDeliveryLocation(dTCC_DeliveryLocationRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg1CommodityInstrumentID(dTCC_Leg1CommodityInstrumentIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg2CommodityInstrumentID(dTCC_Leg2CommodityInstrumentIDRule.evaluate(input));
			
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
				.setTradeParty1IDType(dTCC_TradeParty1IDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setMessageID(dTCC_MessageIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg1CommodityUnderlyerID(dTCC_Leg1CommodityUnderlyerIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLeg2CommodityUnderlyerID(dTCC_Leg2CommodityUnderlyerIDRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setChangeInNotionalAmount1(dTCC_ChangeInNotionalAmount1Rule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setChangeInNotionalAmount2(dTCC_ChangeInNotionalAmount2Rule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setLargeNotionalOffFacilitySwapElectionIndicator(dTCC_LargeNotionalOffFacilitySwapElectionIndicatorRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setMandatoryClearingIndicator(dTCC_MandatoryClearingIndicatorRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setMessageType(dTCC_MessageTypeTransactionRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setOriginalSwapSDRIDType(dTCC_OriginalSwapSDRIDTypeRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setPhysicalCommodityContractIndicator(dTCC_PhysicalCommodityContractIndicatorRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSdMspIndicatorCounterparty1(MapperC.of(dTCC_SDMSPIndicatorCounterparty1Rule.evaluate(input)).get());
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSdMspIndicatorCounterparty2(MapperC.of(dTCC_SDMSPIndicatorCounterparty2Rule.evaluate(input)).get());
			
			output
				.getOrCreateDtccAdditionalFields()
				.setSefOrDcmIndicator(dTCC_SEFOrDCMIndicatorRule.evaluate(input));
			
			output
				.getOrCreateDtccAdditionalFields()
				.setVersion(dTCC_VersionTransactionRule.evaluate(input));
			
			output
				.setClearingSwapUSIs(clearingSwapUSIsRule.evaluate(input));
			
			output
				.setClearingSwapUTIs(clearingSwapUTIsRule.evaluate(input));
			
			output
				.setOriginalSwapUSI(originalSwapUSIRule.evaluate(input));
			
			output
				.setCounterparty1FinancialEntityIndicator(counterparty1FinancialEntityIndicatorRule.evaluate(input));
			
			output
				.setCounterparty2FinancialEntityIndicator(counterparty2FinancialEntityIndicatorRule.evaluate(input));
			
			output
				.setCounterparty1FederalEntityIndicator(counterparty1FederalEntityIndicatorRule.evaluate(input));
			
			output
				.setCounterparty2FederalEntityIndicator(counterparty2FederalEntityIndicatorRule.evaluate(input));
			
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
