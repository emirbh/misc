package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.reports.EnrichmentDataRule;
import drr.enrichment.common.reports.UpiPostEnrichmentDataRule;
import drr.enrichment.common.reports.UpiPreEnrichmentDataRule;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.asic.rewrite.trade.labels.ASICTradeLabelProvider;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.AssetClassRule;
import drr.regulation.common.trade.contract.reports.ContractTypeRule;
import drr.regulation.common.trade.link.reports.SecondaryTransactionIdentifierRule;
import drr.regulation.common.trade.party.reports.Counterparty2NameRule;
import drr.regulation.common.trade.party.reports.EntityResponsibleForReportingRule;
import drr.regulation.common.trade.party.reports.ReportSubmittingEntityRule;
import drr.standards.iosco.cde.version3.datetime.reports.ReportingTimestampRule;
import drr.standards.iosco.cde.version3.event.reports.ActionTypeRule;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty1Rule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2IdentifierTypeIndicatorRule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.asic.rewrite.trade", body="ASIC", corpusList={"Trade"})
@RuneLabelProvider(labelProvider=ASICTradeLabelProvider.class)
@ImplementedBy(ASICTradeReportFunction.ASICTradeReportFunctionDefault.class)
public abstract class ASICTradeReportFunction implements ReportFunction<TransactionReportInstruction, ASICTransactionReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected BasketConstituentsRule basketConstituentsRule;
	@Inject protected BasketStructurerRule basketStructurerRule;
	@Inject protected Beneficiary1IdentifierTypeIndicatorRule beneficiary1IdentifierTypeIndicatorRule;
	@Inject protected Beneficiary1Rule beneficiary1Rule;
	@Inject protected BrokerRule brokerRule;
	@Inject protected CDSIndexAttachmentPointRule cDSIndexAttachmentPointRule;
	@Inject protected CDSIndexDetachmentPointRule cDSIndexDetachmentPointRule;
	@Inject protected CallAmountRule callAmountRule;
	@Inject protected CallCurrencyRule callCurrencyRule;
	@Inject protected CentralCounterpartyRule centralCounterpartyRule;
	@Inject protected ClearedRule clearedRule;
	@Inject protected ClearingMemberRule clearingMemberRule;
	@Inject protected ClearingTimestampRule clearingTimestampRule;
	@Inject protected CollateralPortfolioCodeInitialMarginRule collateralPortfolioCodeInitialMarginRule;
	@Inject protected CollateralPortfolioCodeVariationMarginRule collateralPortfolioCodeVariationMarginRule;
	@Inject protected CollateralPortfolioIndicatorRule collateralPortfolioIndicatorRule;
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierTypeIndicatorRule counterparty2IdentifierTypeIndicatorRule;
	@Inject protected Counterparty2NameRule counterparty2NameRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CountryOfCounterparty2Rule countryOfCounterparty2Rule;
	@Inject protected CustomBasketCodeIdentifierRule customBasketCodeIdentifierRule;
	@Inject protected DeltaRule deltaRule;
	@Inject protected Direction1Rule direction1Rule;
	@Inject protected Direction2Leg1Rule direction2Leg1Rule;
	@Inject protected Direction2Leg2Rule direction2Leg2Rule;
	@Inject protected EffectiveDateRule effectiveDateRule;
	@Inject protected EnrichmentDataRule enrichmentDataRule;
	@Inject protected EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected EventIdentifierRule eventIdentifierRule;
	@Inject protected EventTimestampRule eventTimestampRule;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected ExchangeRateBasisRule exchangeRateBasisRule;
	@Inject protected ExchangeRateRule exchangeRateRule;
	@Inject protected ExecutionAgentCounterparty1Rule executionAgentCounterparty1Rule;
	@Inject protected ExecutionAgentCounterparty2DTCCRule executionAgentCounterparty2DTCCRule;
	@Inject protected ExecutionTimestampRule executionTimestampRule;
	@Inject protected ExpirationDateRule expirationDateRule;
	@Inject protected FixedRateDayCountConventionLeg1Rule fixedRateDayCountConventionLeg1Rule;
	@Inject protected FixedRateDayCountConventionLeg2Rule fixedRateDayCountConventionLeg2Rule;
	@Inject protected FixedRateLeg1Rule fixedRateLeg1Rule;
	@Inject protected FixedRateLeg2Rule fixedRateLeg2Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodLeg1Rule fixedRatePaymentFrequencyPeriodLeg1Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodLeg2Rule fixedRatePaymentFrequencyPeriodLeg2Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodMultiplierLeg1Rule fixedRatePaymentFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected FloatingRateDayCountConventionLeg1Rule floatingRateDayCountConventionLeg1Rule;
	@Inject protected FloatingRateDayCountConventionLeg2Rule floatingRateDayCountConventionLeg2Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodLeg1Rule floatingRatePaymentFrequencyPeriodLeg1Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodLeg2Rule floatingRatePaymentFrequencyPeriodLeg2Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodMultiplierLeg1Rule floatingRatePaymentFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodMultiplierLeg2Rule floatingRatePaymentFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected FloatingRateReferencePeriodLeg2Rule floatingRateReferencePeriodLeg2Rule;
	@Inject protected FloatingRateReferencePeriodMultiplierLeg2Rule floatingRateReferencePeriodMultiplierLeg2Rule;
	@Inject protected IndexFactorRule indexFactorRule;
	@Inject protected IndicatorOfTheFloatingRateLeg2Rule indicatorOfTheFloatingRateLeg2Rule;
	@Inject protected MaturityDateOfTheUnderlierRule maturityDateOfTheUnderlierRule;
	@Inject protected NewDerivativeTradeRepositoryRule newDerivativeTradeRepositoryRule;
	@Inject protected NextFloatingReferenceResetDateLeg1Rule nextFloatingReferenceResetDateLeg1Rule;
	@Inject protected NextFloatingReferenceResetDateLeg2Rule nextFloatingReferenceResetDateLeg2Rule;
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
	@Inject protected OptionPremiumAmountRule optionPremiumAmountRule;
	@Inject protected OptionPremiumCurrencyRule optionPremiumCurrencyRule;
	@Inject protected OptionPremiumPaymentDateRule optionPremiumPaymentDateRule;
	@Inject protected OtherPaymentRule otherPaymentRule;
	@Inject protected PackageIdentifierRule packageIdentifierRule;
	@Inject protected PackageTransactionPriceCurrencyRule packageTransactionPriceCurrencyRule;
	@Inject protected PackageTransactionPriceNotationRule packageTransactionPriceNotationRule;
	@Inject protected PackageTransactionPriceRule packageTransactionPriceRule;
	@Inject protected PackageTransactionSpreadCurrencyRule packageTransactionSpreadCurrencyRule;
	@Inject protected PackageTransactionSpreadNotationRule packageTransactionSpreadNotationRule;
	@Inject protected PackageTransactionSpreadRule packageTransactionSpreadRule;
	@Inject protected PlatformIdentifierRule platformIdentifierRule;
	@Inject protected PriceCurrencyRule priceCurrencyRule;
	@Inject protected PriceNotationRule priceNotationRule;
	@Inject protected PriceRule priceRule;
	@Inject protected PriceScheduleRule priceScheduleRule;
	@Inject protected PriceUnitOfMeasureRule priceUnitOfMeasureRule;
	@Inject protected PriorUTIProprietaryRule priorUTIProprietaryRule;
	@Inject protected PriorUTIRule priorUTIRule;
	@Inject protected PutAmountRule putAmountRule;
	@Inject protected PutCurrencyRule putCurrencyRule;
	@Inject protected QuantityUnitOfMeasureLeg1Rule quantityUnitOfMeasureLeg1Rule;
	@Inject protected QuantityUnitOfMeasureLeg2Rule quantityUnitOfMeasureLeg2Rule;
	@Inject protected ReportSubmittingEntityRule reportSubmittingEntityRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected SecondaryTransactionIdentifierRule secondaryTransactionIdentifierRule;
	@Inject protected SettlementCurrencyLeg1Rule settlementCurrencyLeg1Rule;
	@Inject protected SettlementCurrencyLeg2Rule settlementCurrencyLeg2Rule;
	@Inject protected SingleOrUpperAndLowerBarrierRule singleOrUpperAndLowerBarrierRule;
	@Inject protected SmallScaleBuySideEntityIndicatorRule smallScaleBuySideEntityIndicatorRule;
	@Inject protected SpreadCurrencyLeg1Rule spreadCurrencyLeg1Rule;
	@Inject protected SpreadCurrencyLeg2Rule spreadCurrencyLeg2Rule;
	@Inject protected SpreadLeg1Rule spreadLeg1Rule;
	@Inject protected SpreadLeg2Rule spreadLeg2Rule;
	@Inject protected SpreadNotationLeg1Rule spreadNotationLeg1Rule;
	@Inject protected SpreadNotationLeg2Rule spreadNotationLeg2Rule;
	@Inject protected StrikePriceCurrencyCurrencyPairRule strikePriceCurrencyCurrencyPairRule;
	@Inject protected StrikePriceNotationRule strikePriceNotationRule;
	@Inject protected StrikePriceRule strikePriceRule;
	@Inject protected StrikePriceScheduleRule strikePriceScheduleRule;
	@Inject protected TechnicalRecordIdRule technicalRecordIdRule;
	@Inject protected TotalNotionalQuantityLeg1Rule totalNotionalQuantityLeg1Rule;
	@Inject protected TotalNotionalQuantityLeg2Rule totalNotionalQuantityLeg2Rule;
	@Inject protected UnderlyingIdOtherRule underlyingIdOtherRule;
	@Inject protected UnderlyingIdOtherSourceRule underlyingIdOtherSourceRule;
	@Inject protected UnderlyingIdentificationRule underlyingIdentificationRule;
	@Inject protected UnderlyingIdentificationTypeRule underlyingIdentificationTypeRule;
	@Inject protected UniqueProductIdentifierRule uniqueProductIdentifierRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected UpiPostEnrichmentDataRule upiPostEnrichmentDataRule;
	@Inject protected UpiPreEnrichmentDataRule upiPreEnrichmentDataRule;
	@Inject protected UtiProprietaryRule utiProprietaryRule;
	@Inject protected ValuationAmountRule valuationAmountRule;
	@Inject protected ValuationCurrencyRule valuationCurrencyRule;
	@Inject protected ValuationMethodRule valuationMethodRule;
	@Inject protected ValuationTimestampRule valuationTimestampRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ASICTransactionReport evaluate(TransactionReportInstruction input) {
		ASICTransactionReport.ASICTransactionReportBuilder outputBuilder = doEvaluate(input);
		
		final ASICTransactionReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(ASICTransactionReport.class, output);
		}
		
		return output;
	}

	protected abstract ASICTransactionReport.ASICTransactionReportBuilder doEvaluate(TransactionReportInstruction input);

	public static class ASICTradeReportFunctionDefault extends ASICTradeReportFunction {
		@Override
		protected ASICTransactionReport.ASICTransactionReportBuilder doEvaluate(TransactionReportInstruction input) {
			ASICTransactionReport.ASICTransactionReportBuilder output = ASICTransactionReport.builder();
			return assignOutput(output, input);
		}
		
		protected ASICTransactionReport.ASICTransactionReportBuilder assignOutput(ASICTransactionReport.ASICTransactionReportBuilder output, TransactionReportInstruction input) {
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
				.setCounterparty2IdentifierTypeOverriddenAsBoolean(counterparty2IdentifierTypeIndicatorRule.evaluate(input));
			
			output
				.setBeneficiary1(beneficiary1Rule.evaluate(input));
			
			output
				.setBeneficiary1IdentifierTypeIndicator(beneficiary1IdentifierTypeIndicatorRule.evaluate(input));
			
			output
				.setCleared(clearedRule.evaluate(input));
			
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
				.setDelta(deltaRule.evaluate(input));
			
			output
				.setPriceSchedule(priceScheduleRule.evaluate(input));
			
			output
				.setStrikePriceSchedule(strikePriceScheduleRule.evaluate(input));
			
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
				.setCollateralPortfolioIndicator(collateralPortfolioIndicatorRule.evaluate(input));
			
			output
				.setPriorUTI(priorUTIRule.evaluate(input));
			
			output
				.setDirection1(direction1Rule.evaluate(input));
			
			output
				.setValuationAmount(valuationAmountRule.evaluate(input));
			
			output
				.setValuationCurrency(valuationCurrencyRule.evaluate(input));
			
			output
				.setValuationMethod(valuationMethodRule.evaluate(input));
			
			output
				.setValuationTimestamp(valuationTimestampRule.evaluate(input));
			
			output
				.setCustomBasketCode(customBasketCodeIdentifierRule.evaluate(input));
			
			output
				.setBasketConstituents(basketConstituentsRule.evaluate(input));
			
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
				.setDirection2(direction2Leg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setNotionalQuantity(notionalQuantityLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setNextFloatingReferenceResetDate(nextFloatingReferenceResetDateLeg1Rule.evaluate(input));
			
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
			
			final BigDecimal bigDecimal2 = fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriodMultiplier((bigDecimal2 == null ? null : bigDecimal2.intValueExact()));
			
			final BigDecimal bigDecimal3 = floatingRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriodMultiplier((bigDecimal3 == null ? null : bigDecimal3.intValueExact()));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateIndicator(indicatorOfTheFloatingRateLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriod(floatingRateReferencePeriodLeg2Rule.evaluate(input));
			
			final BigDecimal bigDecimal4 = floatingRateReferencePeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriodMultiplier((bigDecimal4 == null ? null : bigDecimal4.intValueExact()));
			
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
				.setDirection2(direction2Leg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setNotionalQuantity(notionalQuantityLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setNextFloatingReferenceResetDate(nextFloatingReferenceResetDateLeg2Rule.evaluate(input));
			
			output
				.setUnderlyingIdOther(underlyingIdOtherRule.evaluate(input));
			
			output
				.setUnderlyingIdOtherSource(underlyingIdOtherSourceRule.evaluate(input));
			
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
				.setExecutionAgentCounterparty1(executionAgentCounterparty1Rule.evaluate(input));
			
			output
				.setExecutionAgentCounterparty2(executionAgentCounterparty2DTCCRule.evaluate(input));
			
			output
				.setCounterparty2Name(counterparty2NameRule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(reportSubmittingEntityRule.evaluate(input));
			
			output
				.setEntityResponsibleForReporting(entityResponsibleForReportingRule.evaluate(input));
			
			output
				.setCountryOfTheCounterparty2(countryOfCounterparty2Rule.evaluate(input));
			
			output
				.setBrokerID(brokerRule.evaluate(input));
			
			output
				.setContractTypeOverriddenAsCommonContractType(contractTypeRule.evaluate(input));
			
			output
				.setAssetClassOverriddenAsCommonAssetClass(assetClassRule.evaluate(input));
			
			output
				.setSecondaryTransactionIdentifier(secondaryTransactionIdentifierRule.evaluate(input));
			
			output
				.setUnderlyingIdentification(underlyingIdentificationRule.evaluate(input));
			
			output
				.setUnderlyingIdentificationType(underlyingIdentificationTypeRule.evaluate(input));
			
			output
				.setMaturityDateOfTheUnderlying(maturityDateOfTheUnderlierRule.evaluate(input));
			
			output
				.setPriorUTIProprietary(priorUTIProprietaryRule.evaluate(input));
			
			output
				.setClearingTimestamp(clearingTimestampRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(utiProprietaryRule.evaluate(input));
			
			output
				.setUniqueProductIdentifier(uniqueProductIdentifierRule.evaluate(input));
			
			output
				.setTechnicalRecordIdOverriddenAsString(technicalRecordIdRule.evaluate(input));
			
			output
				.setIndexFactor(MapperC.of(indexFactorRule.evaluate(input)).get());
			
			output
				.setBarrier(singleOrUpperAndLowerBarrierRule.evaluate(input));
			
			output
				.setInitialMarginCollateralPortfolioCode(collateralPortfolioCodeInitialMarginRule.evaluate(input));
			
			output
				.setVariationMarginCollateralPortfolioCode(collateralPortfolioCodeVariationMarginRule.evaluate(input));
			
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
				.setBasketStructurerID(basketStructurerRule.evaluate(input));
			
			output
				.setNewDerivativeTradeRepository(newDerivativeTradeRepositoryRule.evaluate(input));
			
			output
				.setSmallScaleBuySideEntityIndicator(smallScaleBuySideEntityIndicatorRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
