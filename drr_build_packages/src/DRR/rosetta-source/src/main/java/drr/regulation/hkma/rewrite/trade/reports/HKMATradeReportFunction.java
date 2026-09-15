package drr.regulation.hkma.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.contract.reports.OptionTypeRule;
import drr.regulation.common.trade.party.reports.Counterparty2NameRule;
import drr.regulation.common.trade.party.reports.EntityResponsibleForReportingRule;
import drr.regulation.common.trade.party.reports.ExecutionAgentCounterparty1Rule;
import drr.regulation.common.trade.party.reports.ExecutionAgentCounterparty2Rule;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.regulation.hkma.rewrite.trade.labels.HKMATradeLabelProvider;
import drr.standards.iosco.cde.version3.collateral.reports.CollateralPortfolioIndicatorRule;
import drr.standards.iosco.cde.version3.datetime.reports.ReportingTimestampRule;
import drr.standards.iosco.cde.version3.event.reports.ActionTypeRule;
import drr.standards.iosco.cde.version3.party.reports.Beneficiary1IdentifierTypeIndicatorRule;
import drr.standards.iosco.cde.version3.party.reports.Beneficiary1Rule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty1Rule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2IdentifierTypeIndicatorRule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.hkma.rewrite.trade", body="HKMA", corpusList={"Trade"})
@RuneLabelProvider(labelProvider=HKMATradeLabelProvider.class)
@ImplementedBy(HKMATradeReportFunction.HKMATradeReportFunctionDefault.class)
public abstract class HKMATradeReportFunction implements ReportFunction<TransactionReportInstruction, HKMATransactionReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected BaseProductRule baseProductRule;
	@Inject protected BasketConstituentsRule basketConstituentsRule;
	@Inject protected Beneficiary1IdentifierTypeIndicatorRule beneficiary1IdentifierTypeIndicatorRule;
	@Inject protected Beneficiary1Rule beneficiary1Rule;
	@Inject protected BeneficiaryRule beneficiaryRule;
	@Inject protected BookingLocationRule bookingLocationRule;
	@Inject protected BrokerIdRule brokerIdRule;
	@Inject protected BrokerIdentifierFormatRule brokerIdentifierFormatRule;
	@Inject protected BrokerSchemeNameRule brokerSchemeNameRule;
	@Inject protected BuyerIdentifierRule buyerIdentifierRule;
	@Inject protected CallAmountRule callAmountRule;
	@Inject protected CallCurrencyRule callCurrencyRule;
	@Inject protected CdsIndexAttachmentPointRule cdsIndexAttachmentPointRule;
	@Inject protected CdsIndexDetachmentPointRule cdsIndexDetachmentPointRule;
	@Inject protected CentralCounterpartyIdentifierFormatRule centralCounterpartyIdentifierFormatRule;
	@Inject protected CentralCounterpartyRule centralCounterpartyRule;
	@Inject protected CentralCounterpartySchemeNameRule centralCounterpartySchemeNameRule;
	@Inject protected ClearedRule clearedRule;
	@Inject protected ClearingMemberIdentifierFormatRule clearingMemberIdentifierFormatRule;
	@Inject protected ClearingMemberRule clearingMemberRule;
	@Inject protected ClearingMemberSchemeNameRule clearingMemberSchemeNameRule;
	@Inject protected ClearingTimestampRule clearingTimestampRule;
	@Inject protected CollateralPortfolioIndicatorRule collateralPortfolioIndicatorRule;
	@Inject protected ConfirmedRule confirmedRule;
	@Inject protected ContractPriceScheduleRule contractPriceScheduleRule;
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierFormatRule counterparty2IdentifierFormatRule;
	@Inject protected Counterparty2IdentifierTypeIndicatorRule counterparty2IdentifierTypeIndicatorRule;
	@Inject protected Counterparty2NameRule counterparty2NameRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected Counterparty2SchemeNameRule counterparty2SchemeNameRule;
	@Inject protected CountryOfTheCounterparty2Rule countryOfTheCounterparty2Rule;
	@Inject protected CryptoAssetUnderlyingIndicatorRule cryptoAssetUnderlyingIndicatorRule;
	@Inject protected CustomBasketCodeRule customBasketCodeRule;
	@Inject protected DeliveryTypeRule deliveryTypeRule;
	@Inject protected Direction1Rule direction1Rule;
	@Inject protected Direction2Leg1Rule direction2Leg1Rule;
	@Inject protected Direction2Leg2Rule direction2Leg2Rule;
	@Inject protected EarlyTerminationDateRule earlyTerminationDateRule;
	@Inject protected EffectiveDateRule effectiveDateRule;
	@Inject protected EmbeddedOptionTypeRule embeddedOptionTypeRule;
	@Inject protected EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected EventIdentifierRule eventIdentifierRule;
	@Inject protected EventTimestampRule eventTimestampRule;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected ExchangeRateBasisRule exchangeRateBasisRule;
	@Inject protected ExchangeRateRule exchangeRateRule;
	@Inject protected ExecutionAgentCounterparty1Rule executionAgentCounterparty1Rule;
	@Inject protected ExecutionAgentCounterparty2Rule executionAgentCounterparty2Rule;
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
	@Inject protected FloatingRateIdentifierLeg1Rule floatingRateIdentifierLeg1Rule;
	@Inject protected FloatingRateIdentifierLeg2Rule floatingRateIdentifierLeg2Rule;
	@Inject protected FloatingRateIndicatorLeg1Rule floatingRateIndicatorLeg1Rule;
	@Inject protected FloatingRateIndicatorLeg2Rule floatingRateIndicatorLeg2Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodLeg1Rule floatingRatePaymentFrequencyPeriodLeg1Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodLeg2Rule floatingRatePaymentFrequencyPeriodLeg2Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodMultiplierLeg1Rule floatingRatePaymentFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodMultiplierLeg2Rule floatingRatePaymentFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected FloatingRateReferencePeriodLeg1Rule floatingRateReferencePeriodLeg1Rule;
	@Inject protected FloatingRateReferencePeriodLeg2Rule floatingRateReferencePeriodLeg2Rule;
	@Inject protected FloatingRateReferencePeriodMultiplierLeg1Rule floatingRateReferencePeriodMultiplierLeg1Rule;
	@Inject protected FloatingRateReferencePeriodMultiplierLeg2Rule floatingRateReferencePeriodMultiplierLeg2Rule;
	@Inject protected FurtherSubProductRule furtherSubProductRule;
	@Inject protected IndexFactorRule indexFactorRule;
	@Inject protected InitialMarginCollateralPortfolioCodeRule initialMarginCollateralPortfolioCodeRule;
	@Inject protected IntragroupRule intragroupRule;
	@Inject protected MaturityDateOfTheUnderlyingDerivativeRule maturityDateOfTheUnderlyingDerivativeRule;
	@Inject protected NameOfTheFloatingRateLeg1Rule nameOfTheFloatingRateLeg1Rule;
	@Inject protected NameOfTheFloatingRateLeg2Rule nameOfTheFloatingRateLeg2Rule;
	@Inject protected NameOfTheUnderlyingIndexRule nameOfTheUnderlyingIndexRule;
	@Inject protected NatureOfTheCounterparty1Rule natureOfTheCounterparty1Rule;
	@Inject protected NatureOfTheCounterparty2Rule natureOfTheCounterparty2Rule;
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
	@Inject protected OptionPremiumAmountRule optionPremiumAmountRule;
	@Inject protected OptionPremiumCurrencyRule optionPremiumCurrencyRule;
	@Inject protected OptionPremiumPaymentDateRule optionPremiumPaymentDateRule;
	@Inject protected OptionStyleRule optionStyleRule;
	@Inject protected OptionTypeRule optionTypeRule;
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
	@Inject protected PriceUnitOfMeasureRule priceUnitOfMeasureRule;
	@Inject protected PriorUTIProprietaryRule priorUTIProprietaryRule;
	@Inject protected PriorUTIProprietarySchemeNameRule priorUTIProprietarySchemeNameRule;
	@Inject protected PriorUTIRule priorUTIRule;
	@Inject protected ProductDescriptionRule productDescriptionRule;
	@Inject protected PutAmountRule putAmountRule;
	@Inject protected PutCurrencyRule putCurrencyRule;
	@Inject protected QuantityFrequencyPeriodLeg1Rule quantityFrequencyPeriodLeg1Rule;
	@Inject protected QuantityFrequencyPeriodLeg2Rule quantityFrequencyPeriodLeg2Rule;
	@Inject protected QuantityFrequencyPeriodMultiplierLeg1Rule quantityFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected QuantityFrequencyPeriodMultiplierLeg2Rule quantityFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected QuantityUnitOfMeasureLeg1Rule quantityUnitOfMeasureLeg1Rule;
	@Inject protected QuantityUnitOfMeasureLeg2Rule quantityUnitOfMeasureLeg2Rule;
	@Inject protected ReferenceEntityFormatRule referenceEntityFormatRule;
	@Inject protected ReferenceEntityRule referenceEntityRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected SecondaryTransactionIdentifierRule secondaryTransactionIdentifierRule;
	@Inject protected SectorOfTheCounterparty1Rule sectorOfTheCounterparty1Rule;
	@Inject protected SectorOfTheCounterparty2Rule sectorOfTheCounterparty2Rule;
	@Inject protected SellerIdentifierRule sellerIdentifierRule;
	@Inject protected SeniorityRule seniorityRule;
	@Inject protected SeriesRule seriesRule;
	@Inject protected SeriesVersionRule seriesVersionRule;
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
	@Inject protected StrikePriceScheduleRule strikePriceScheduleRule;
	@Inject protected SubProductRule subProductRule;
	@Inject protected SubmitterIdentifierRule submitterIdentifierRule;
	@Inject protected SwapLinkIDRule swapLinkIDRule;
	@Inject protected TechnicalRecordIdentificationRule technicalRecordIdentificationRule;
	@Inject protected TotalNotionalQuantityLeg1Rule totalNotionalQuantityLeg1Rule;
	@Inject protected TotalNotionalQuantityLeg2Rule totalNotionalQuantityLeg2Rule;
	@Inject protected TraderLocationRule traderLocationRule;
	@Inject protected TradingCapacityRule tradingCapacityRule;
	@Inject protected UnderlierIdOtherRule underlierIdOtherRule;
	@Inject protected UnderlierIdOtherSourceRule underlierIdOtherSourceRule;
	@Inject protected UnderlyingAssetPriceSourceRule underlyingAssetPriceSourceRule;
	@Inject protected UnderlyingAssetTradingPlatformIdentifierRule underlyingAssetTradingPlatformIdentifierRule;
	@Inject protected UnderlyingIdentificationRule underlyingIdentificationRule;
	@Inject protected UnderlyingIdentificationTypeRule underlyingIdentificationTypeRule;
	@Inject protected UniqueProductIdentifierProprietaryRule uniqueProductIdentifierProprietaryRule;
	@Inject protected UniqueProductIdentifierRule uniqueProductIdentifierRule;
	@Inject protected UniqueTransactionIdentifierProprietaryRule uniqueTransactionIdentifierProprietaryRule;
	@Inject protected UniqueTransactionIdentifierProprietarySchemeNameRule uniqueTransactionIdentifierProprietarySchemeNameRule;
	@Inject protected UniqueTransactionIdentifierRule uniqueTransactionIdentifierRule;
	@Inject protected VariationMarginCollateralPortfolioCodeRule variationMarginCollateralPortfolioCodeRule;
	@Inject protected barrierRule _barrierRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public HKMATransactionReport evaluate(TransactionReportInstruction input) {
		HKMATransactionReport.HKMATransactionReportBuilder outputBuilder = doEvaluate(input);
		
		final HKMATransactionReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(HKMATransactionReport.class, output);
		}
		
		return output;
	}

	protected abstract HKMATransactionReport.HKMATransactionReportBuilder doEvaluate(TransactionReportInstruction input);

	public static class HKMATradeReportFunctionDefault extends HKMATradeReportFunction {
		@Override
		protected HKMATransactionReport.HKMATransactionReportBuilder doEvaluate(TransactionReportInstruction input) {
			HKMATransactionReport.HKMATransactionReportBuilder output = HKMATransactionReport.builder();
			return assignOutput(output, input);
		}
		
		protected HKMATransactionReport.HKMATransactionReportBuilder assignOutput(HKMATransactionReport.HKMATransactionReportBuilder output, TransactionReportInstruction input) {
			output
				.setEffectiveDate(effectiveDateRule.evaluate(input));
			
			output
				.setEarlyTerminationDate(earlyTerminationDateRule.evaluate(input));
			
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
				.setConfirmed(confirmedRule.evaluate(input));
			
			output
				.setCallAmount(callAmountRule.evaluate(input));
			
			output
				.setPutAmount(putAmountRule.evaluate(input));
			
			output
				.setCallCurrency(callCurrencyRule.evaluate(input));
			
			output
				.setPutCurrency(putCurrencyRule.evaluate(input));
			
			output
				.setPriceSchedule(contractPriceScheduleRule.evaluate(input));
			
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
				.setCdSIndexAttachmentPoint(cdsIndexAttachmentPointRule.evaluate(input));
			
			output
				.setCdSIndexDetachmentPoint(cdsIndexDetachmentPointRule.evaluate(input));
			
			output
				.setCollateralPortfolioIndicator(collateralPortfolioIndicatorRule.evaluate(input));
			
			output
				.setFirstExerciseDate(firstExerciseDateRule.evaluate(input));
			
			output
				.setFinalContractualSettlementDate(finalContractualSettlementDateRule.evaluate(input));
			
			output
				.setSettlementLocation(settlementLocationRule.evaluate(input));
			
			output
				.setPriorUTI(priorUTIRule.evaluate(input));
			
			output
				.setDirection1(direction1Rule.evaluate(input));
			
			output
				.setCustomBasketCode(customBasketCodeRule.evaluate(input));
			
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
				.getOrCreatePeriodicPayment()
				.setFloatingRateIndicator(floatingRateIndicatorLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateIdentifier(floatingRateIdentifierLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriod(floatingRateReferencePeriodLeg1Rule.evaluate(input));
			
			final BigDecimal bigDecimal2 = floatingRateReferencePeriodMultiplierLeg1Rule.evaluate(input);
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriodMultiplier((bigDecimal2 == null ? null : bigDecimal2.intValueExact()));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setNameOfTheFloatingRate(nameOfTheFloatingRateLeg1Rule.evaluate(input));
			
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
				.setFixingDate(fixingDateLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setQuantityFrequency(quantityFrequencyPeriodLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setQuantityFrequencyMultiplier(quantityFrequencyPeriodMultiplierLeg1Rule.evaluate(input));
			
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
				.setFloatingRateIndicator(floatingRateIndicatorLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateIdentifier(floatingRateIdentifierLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriod(floatingRateReferencePeriodLeg2Rule.evaluate(input));
			
			final BigDecimal bigDecimal5 = floatingRateReferencePeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriodMultiplier((bigDecimal5 == null ? null : bigDecimal5.intValueExact()));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setNameOfTheFloatingRate(nameOfTheFloatingRateLeg2Rule.evaluate(input));
			
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
				.setFixingDate(fixingDateLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setQuantityFrequency(quantityFrequencyPeriodLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setQuantityFrequencyMultiplier(quantityFrequencyPeriodMultiplierLeg2Rule.evaluate(input));
			
			output
				.setUnderlyingIdOther(underlierIdOtherRule.evaluate(input));
			
			output
				.setUnderlyingIdOtherSource(underlierIdOtherSourceRule.evaluate(input));
			
			output
				.setUnderlyingAssetTradingPlatformIdentifier(underlyingAssetTradingPlatformIdentifierRule.evaluate(input));
			
			output
				.setUnderlyingAssetPriceSource(underlyingAssetPriceSourceRule.evaluate(input));
			
			output
				.setCryptoAssetUnderlyingIndicator(cryptoAssetUnderlyingIndicatorRule.evaluate(input));
			
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
				.setBookingLocation(bookingLocationRule.evaluate(input));
			
			output
				.setTraderLocation(MapperC.of(traderLocationRule.evaluate(input)).get());
			
			output
				.setDeliveryType(deliveryTypeRule.evaluate(input));
			
			output
				.setExecutionAgentCounterparty1(executionAgentCounterparty1Rule.evaluate(input));
			
			output
				.setExecutionAgentCounterparty2(executionAgentCounterparty2Rule.evaluate(input));
			
			output
				.setNatureOfCounterparty1(natureOfTheCounterparty1Rule.evaluate(input));
			
			output
				.setNatureOfCounterparty2(natureOfTheCounterparty2Rule.evaluate(input));
			
			output
				.setCorporateSectorOfTheCounterparty1(sectorOfTheCounterparty1Rule.evaluate(input));
			
			output
				.setCorporateSectorOfTheCounterparty2(sectorOfTheCounterparty2Rule.evaluate(input));
			
			output
				.setCounterparty2Name(counterparty2NameRule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(submitterIdentifierRule.evaluate(input));
			
			output
				.setEntityResponsibleForReportingOverriddenAsString(entityResponsibleForReportingRule.evaluate(input));
			
			output
				.setCountryOfTheCounterparty2(countryOfTheCounterparty2Rule.evaluate(input));
			
			output
				.setTradingCapacity(tradingCapacityRule.evaluate(input));
			
			output
				.setBrokerID(brokerIdRule.evaluate(input));
			
			output
				.setContractType(contractTypeRule.evaluate(input));
			
			output
				.setAssetClassOverriddenAsCommonAssetClass(assetClassRule.evaluate(input));
			
			output
				.setOptionType(optionTypeRule.evaluate(input));
			
			output
				.setOptionStyle(optionStyleRule.evaluate(input));
			
			output
				.setEmbeddedOptionType(embeddedOptionTypeRule.evaluate(input));
			
			output
				.setSecondaryTransactionIdentifier(secondaryTransactionIdentifierRule.evaluate(input));
			
			output
				.setIntragroup(intragroupRule.evaluate(input));
			
			output
				.setNonStandardizedTermIndicator(nonStandardizedTermIndicatorRule.evaluate(input));
			
			output
				.setUnderlyingIdentification(underlyingIdentificationRule.evaluate(input));
			
			output
				.setUnderlyingIdentificationType(underlyingIdentificationTypeRule.evaluate(input));
			
			output
				.setNameOfTheUnderlyingIndex(nameOfTheUnderlyingIndexRule.evaluate(input));
			
			output
				.setMaturityDateOfTheUnderlying(maturityDateOfTheUnderlyingDerivativeRule.evaluate(input));
			
			output
				.setSwapLinkID(swapLinkIDRule.evaluate(input));
			
			output
				.setPriorUTIProprietary(priorUTIProprietaryRule.evaluate(input));
			
			output
				.setClearingTimestamp(clearingTimestampRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(uniqueTransactionIdentifierRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(uniqueTransactionIdentifierProprietaryRule.evaluate(input));
			
			output
				.setUniqueProductIdentifier(uniqueProductIdentifierRule.evaluate(input));
			
			output
				.setTechnicalRecordIdOverriddenAsString(technicalRecordIdentificationRule.evaluate(input));
			
			output
				.setReferenceEntity(referenceEntityRule.evaluate(input));
			
			output
				.setSeniority(seniorityRule.evaluate(input));
			
			final BigDecimal bigDecimal6 = seriesRule.evaluate(input);
			output
				.setSeries((bigDecimal6 == null ? null : bigDecimal6.intValueExact()));
			
			output
				.setIndexFactor(MapperC.of(indexFactorRule.evaluate(input)).get());
			
			final BigDecimal bigDecimal7 = seriesVersionRule.evaluate(input);
			output
				.setSeriesVersion((bigDecimal7 == null ? null : bigDecimal7.intValueExact()));
			
			output
				.setBaseProduct(baseProductRule.evaluate(input));
			
			output
				.setSubProduct(subProductRule.evaluate(input));
			
			output
				.setFurtherSubProduct(furtherSubProductRule.evaluate(input));
			
			output
				.setBarrier(_barrierRule.evaluate(input));
			
			output
				.setInitialMarginCollateralPortfolioCode(initialMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setVariationMarginCollateralPortfolioCode(variationMarginCollateralPortfolioCodeRule.evaluate(input));
			
			output
				.setProductDescription(productDescriptionRule.evaluate(input));
			
			output
				.setBeneficiary(beneficiaryRule.evaluate(input));
			
			output
				.setUniqueProductIdentifierProprietary(uniqueProductIdentifierProprietaryRule.evaluate(input));
			
			output
				.setCounterparty2IdentifierFormat(counterparty2IdentifierFormatRule.evaluate(input));
			
			output
				.setCounterparty2SchemeName(counterparty2SchemeNameRule.evaluate(input));
			
			output
				.setCentralCounterpartyIdentifierFormat(centralCounterpartyIdentifierFormatRule.evaluate(input));
			
			output
				.setCentralCounterpartySchemeName(centralCounterpartySchemeNameRule.evaluate(input));
			
			output
				.setBrokerIdentifierFormat(brokerIdentifierFormatRule.evaluate(input));
			
			output
				.setBrokerSchemeName(brokerSchemeNameRule.evaluate(input));
			
			output
				.setReferenceEntityFormat(referenceEntityFormatRule.evaluate(input));
			
			output
				.setClearingMemberIdentifierFormat(clearingMemberIdentifierFormatRule.evaluate(input));
			
			output
				.setClearingMemberSchemeName(clearingMemberSchemeNameRule.evaluate(input));
			
			output
				.setPriorUTIProprietarySchemeName(priorUTIProprietarySchemeNameRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietarySchemeName(uniqueTransactionIdentifierProprietarySchemeNameRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
