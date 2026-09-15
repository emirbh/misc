package drr.regulation.jfsa.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.reports.EnrichmentDataRule;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.execution.reports.TraderLocationRule;
import drr.regulation.common.trade.party.reports.Counterparty2NameRule;
import drr.regulation.common.trade.party.reports.EntityResponsibleForReportingRule;
import drr.regulation.common.trade.party.reports.ReportSubmittingEntityRule;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.regulation.jfsa.rewrite.trade.labels.JFSATradeLabelProvider;
import drr.standards.iosco.cde.version3.datetime.reports.ExecutionTimestampRule;
import drr.standards.iosco.cde.version3.datetime.reports.ReportingTimestampRule;
import drr.standards.iosco.cde.version3.event.reports.ActionTypeRule;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty1Rule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2IdentifierTypeIndicatorRule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2Rule;
import drr.standards.iosco.cde.version3.price.reports.PackageTransactionSpreadFormatRule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.jfsa.rewrite.trade", body="JFSA", corpusList={"Trade"})
@RuneLabelProvider(labelProvider=JFSATradeLabelProvider.class)
@ImplementedBy(JFSATradeReportFunction.JFSATradeReportFunctionDefault.class)
public abstract class JFSATradeReportFunction implements ReportFunction<TransactionReportInstruction, JFSATransactionReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected BasketConstituentsRule basketConstituentsRule;
	@Inject protected CDSIndexAttachmentPointRule cDSIndexAttachmentPointRule;
	@Inject protected CDSIndexDetachmentPointRule cDSIndexDetachmentPointRule;
	@Inject protected CallAmountRule callAmountRule;
	@Inject protected CallCurrencyRule callCurrencyRule;
	@Inject protected CentralCounterpartyRule centralCounterpartyRule;
	@Inject protected ClearedRule clearedRule;
	@Inject protected ClearingAccountOriginRule clearingAccountOriginRule;
	@Inject protected ClearingMemberRule clearingMemberRule;
	@Inject protected ClearingReceiptTimestampRule clearingReceiptTimestampRule;
	@Inject protected CollateralPortfolioIndicatorRule collateralPortfolioIndicatorRule;
	@Inject protected ConfirmationTimestampDTCCRule confirmationTimestampDTCCRule;
	@Inject protected ConfirmedRule confirmedRule;
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierTypeIndicatorRule counterparty2IdentifierTypeIndicatorRule;
	@Inject protected Counterparty2NameRule counterparty2NameRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CustomBasketCodeRule customBasketCodeRule;
	@Inject protected DeliveryTypeRule deliveryTypeRule;
	@Inject protected DeltaRule deltaRule;
	@Inject protected DerivativeBasedOnCryptoAssetsRule derivativeBasedOnCryptoAssetsRule;
	@Inject protected Direction1Rule direction1Rule;
	@Inject protected Direction2Leg1Rule direction2Leg1Rule;
	@Inject protected Direction2Leg2Rule direction2Leg2Rule;
	@Inject protected EarlyTerminationDateRule earlyTerminationDateRule;
	@Inject protected EffectiveDateRule effectiveDateRule;
	@Inject protected EmbeddedOptionTypeRule embeddedOptionTypeRule;
	@Inject protected EnrichmentDataRule enrichmentDataRule;
	@Inject protected EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected EventIdentifierRule eventIdentifierRule;
	@Inject protected EventTimestampRule eventTimestampRule;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected ExchangeRateBasisRule exchangeRateBasisRule;
	@Inject protected ExchangeRateRule exchangeRateRule;
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
	@Inject protected FloatingRateResetFrequencyPeriodLeg1Rule floatingRateResetFrequencyPeriodLeg1Rule;
	@Inject protected FloatingRateResetFrequencyPeriodLeg2Rule floatingRateResetFrequencyPeriodLeg2Rule;
	@Inject protected FloatingRateResetFrequencyPeriodMultiplierLeg1Rule floatingRateResetFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected FloatingRateResetFrequencyPeriodMultiplierLeg2Rule floatingRateResetFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected IndexFactorRule indexFactorRule;
	@Inject protected InitialMarginCollateralPortfolioCodeRule initialMarginCollateralPortfolioCodeRule;
	@Inject protected MaturityDateOfTheUnderlyingRule maturityDateOfTheUnderlyingRule;
	@Inject protected NameOfTheFloatingRateLeg1Rule nameOfTheFloatingRateLeg1Rule;
	@Inject protected NameOfTheFloatingRateLeg2Rule nameOfTheFloatingRateLeg2Rule;
	@Inject protected NameOfTheUnderlyingIndexRule nameOfTheUnderlyingIndexRule;
	@Inject protected NewSDRIdentifierRule newSDRIdentifierRule;
	@Inject protected NotionalAmountLeg1Rule notionalAmountLeg1Rule;
	@Inject protected NotionalAmountLeg2Rule notionalAmountLeg2Rule;
	@Inject protected NotionalAmountScheduleLeg1Rule notionalAmountScheduleLeg1Rule;
	@Inject protected NotionalAmountScheduleLeg2Rule notionalAmountScheduleLeg2Rule;
	@Inject protected NotionalCurrencyLeg1Rule notionalCurrencyLeg1Rule;
	@Inject protected NotionalCurrencyLeg2Rule notionalCurrencyLeg2Rule;
	@Inject protected NotionalQuantityScheduleLeg1Rule notionalQuantityScheduleLeg1Rule;
	@Inject protected NotionalQuantityScheduleLeg2Rule notionalQuantityScheduleLeg2Rule;
	@Inject protected OptionPremiumAmountRule optionPremiumAmountRule;
	@Inject protected OptionPremiumCurrencyRule optionPremiumCurrencyRule;
	@Inject protected OptionPremiumPaymentDateRule optionPremiumPaymentDateRule;
	@Inject protected OptionStyleRule optionStyleRule;
	@Inject protected OptionTypeRule optionTypeRule;
	@Inject protected OriginalSwapSDRIdentifierRule originalSwapSDRIdentifierRule;
	@Inject protected OriginalSwapUTIProprietaryRule originalSwapUTIProprietaryRule;
	@Inject protected OriginalSwapUTIRule originalSwapUTIRule;
	@Inject protected OtherPaymentRule otherPaymentRule;
	@Inject protected PackageIdentifierRule packageIdentifierRule;
	@Inject protected PackageTransactionPriceCurrencyRule packageTransactionPriceCurrencyRule;
	@Inject protected PackageTransactionPriceNotationRule packageTransactionPriceNotationRule;
	@Inject protected PackageTransactionPriceRule packageTransactionPriceRule;
	@Inject protected PackageTransactionSpreadCurrencyRule packageTransactionSpreadCurrencyRule;
	@Inject protected PackageTransactionSpreadFormatRule packageTransactionSpreadFormatRule;
	@Inject protected PackageTransactionSpreadNotationRule packageTransactionSpreadNotationRule;
	@Inject protected PlatformIdentifierRule platformIdentifierRule;
	@Inject protected PriceCurrencyRule priceCurrencyRule;
	@Inject protected PriceNotationRule priceNotationRule;
	@Inject protected PriceRule priceRule;
	@Inject protected PriceScheduleRule priceScheduleRule;
	@Inject protected PriceUnitOfMeasureRule priceUnitOfMeasureRule;
	@Inject protected PriorUtiProprietaryRule priorUtiProprietaryRule;
	@Inject protected PriorUtiRule priorUtiRule;
	@Inject protected PutAmountRule putAmountRule;
	@Inject protected PutCurrencyRule putCurrencyRule;
	@Inject protected QuantityUnitOfMeasureLeg1Rule quantityUnitOfMeasureLeg1Rule;
	@Inject protected QuantityUnitOfMeasureLeg2Rule quantityUnitOfMeasureLeg2Rule;
	@Inject protected ReferenceEntityRule referenceEntityRule;
	@Inject protected ReportSubmittingEntityRule reportSubmittingEntityRule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected SeniorityRule seniorityRule;
	@Inject protected SeriesRule seriesRule;
	@Inject protected SettlementCurrencyLeg1Rule settlementCurrencyLeg1Rule;
	@Inject protected SettlementCurrencyLeg2Rule settlementCurrencyLeg2Rule;
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
	@Inject protected StrikePriceScheduleRule strikePriceScheduleRule;
	@Inject protected TechnicalRecordIdRule technicalRecordIdRule;
	@Inject protected TotalNotionalQuantityLeg1Rule totalNotionalQuantityLeg1Rule;
	@Inject protected TotalNotionalQuantityLeg2Rule totalNotionalQuantityLeg2Rule;
	@Inject protected TraderLocationRule traderLocationRule;
	@Inject protected UPIRule uPIRule;
	@Inject protected UnderlyingIdentificationRule underlyingIdentificationRule;
	@Inject protected UnderlyingIdentificationTypeRule underlyingIdentificationTypeRule;
	@Inject protected UnderlyingIndexIndicatorRule underlyingIndexIndicatorRule;
	@Inject protected UtiProprietaryRule utiProprietaryRule;
	@Inject protected UtiRule utiRule;
	@Inject protected ValuationAmountRule valuationAmountRule;
	@Inject protected ValuationCurrencyRule valuationCurrencyRule;
	@Inject protected ValuationMethodRule valuationMethodRule;
	@Inject protected ValuationTimestampRule valuationTimestampRule;
	@Inject protected VariationMarginCollateralPortfolioCodeRule variationMarginCollateralPortfolioCodeRule;
	@Inject protected VersionRule versionRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public JFSATransactionReport evaluate(TransactionReportInstruction input) {
		JFSATransactionReport.JFSATransactionReportBuilder outputBuilder = doEvaluate(input);
		
		final JFSATransactionReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(JFSATransactionReport.class, output);
		}
		
		return output;
	}

	protected abstract JFSATransactionReport.JFSATransactionReportBuilder doEvaluate(TransactionReportInstruction input);

	public static class JFSATradeReportFunctionDefault extends JFSATradeReportFunction {
		@Override
		protected JFSATransactionReport.JFSATransactionReportBuilder doEvaluate(TransactionReportInstruction input) {
			JFSATransactionReport.JFSATransactionReportBuilder output = JFSATransactionReport.builder();
			return assignOutput(output, input);
		}
		
		protected JFSATransactionReport.JFSATransactionReportBuilder assignOutput(JFSATransactionReport.JFSATransactionReportBuilder output, TransactionReportInstruction input) {
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
				.setPackageTransactionSpread(packageTransactionSpreadFormatRule.evaluate(input));
			
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
				.setFirstExerciseDate(firstExerciseDateRule.evaluate(input));
			
			output
				.setFinalContractualSettlementDate(finalContractualSettlementDateRule.evaluate(input));
			
			output
				.setPriorUTI(priorUtiRule.evaluate(input));
			
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
				.setFloatingRateResetFrequencyPeriod(floatingRateResetFrequencyPeriodLeg1Rule.evaluate(input));
			
			final BigDecimal bigDecimal2 = floatingRateResetFrequencyPeriodMultiplierLeg1Rule.evaluate(input);
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyMultiplier((bigDecimal2 == null ? null : bigDecimal2.intValueExact()));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateIndicator(floatingRateIndicatorLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriod(floatingRateReferencePeriodLeg1Rule.evaluate(input));
			
			final BigDecimal bigDecimal3 = floatingRateReferencePeriodMultiplierLeg1Rule.evaluate(input);
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriodMultiplier((bigDecimal3 == null ? null : bigDecimal3.intValueExact()));
			
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
				.setFixingDate(fixingDateLeg1Rule.evaluate(input));
			
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
			
			final BigDecimal bigDecimal4 = fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriodMultiplier((bigDecimal4 == null ? null : bigDecimal4.intValueExact()));
			
			final BigDecimal bigDecimal5 = floatingRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriodMultiplier((bigDecimal5 == null ? null : bigDecimal5.intValueExact()));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyPeriod(floatingRateResetFrequencyPeriodLeg2Rule.evaluate(input));
			
			final BigDecimal bigDecimal6 = floatingRateResetFrequencyPeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyMultiplier((bigDecimal6 == null ? null : bigDecimal6.intValueExact()));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateIndicator(floatingRateIndicatorLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriod(floatingRateReferencePeriodLeg2Rule.evaluate(input));
			
			final BigDecimal bigDecimal7 = floatingRateReferencePeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriodMultiplier((bigDecimal7 == null ? null : bigDecimal7.intValueExact()));
			
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
				.setFixingDate(fixingDateLeg2Rule.evaluate(input));
			
			output
				.setCryptoAssetUnderlyingIndicator(derivativeBasedOnCryptoAssetsRule.evaluate(input));
			
			output
				.setActionType(actionTypeRule.evaluate(input));
			
			output
				.setEventType(eventTypeRule.evaluate(input));
			
			output
				.setEventIdentifier(eventIdentifierRule.evaluate(input));
			
			output
				.setEventTimestampOverriddenAsZonedDateTime(eventTimestampRule.evaluate(input));
			
			output
				.setConfirmationTimestamp(confirmationTimestampDTCCRule.evaluate(input));
			
			output
				.setPlatformIdentifier(platformIdentifierRule.evaluate(input));
			
			output
				.setTraderLocation(MapperC.of(traderLocationRule.evaluate(input)).get());
			
			output
				.setDeliveryType(deliveryTypeRule.evaluate(input));
			
			output
				.setCounterparty2Name(counterparty2NameRule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(reportSubmittingEntityRule.evaluate(input));
			
			output
				.setEntityResponsibleForReportingOverriddenAsString(entityResponsibleForReportingRule.evaluate(input));
			
			output
				.setContractTypeOverriddenAsCommonContractType(contractTypeRule.evaluate(input));
			
			output
				.setAssetClassOverriddenAsCommonAssetClass(assetClassRule.evaluate(input));
			
			output
				.setOptionType(optionTypeRule.evaluate(input));
			
			output
				.setOptionStyle(optionStyleRule.evaluate(input));
			
			output
				.setEmbeddedOptionType(embeddedOptionTypeRule.evaluate(input));
			
			output
				.setUnderlyingIdentification(underlyingIdentificationRule.evaluate(input));
			
			output
				.setUnderlyingIdentificationType(underlyingIdentificationTypeRule.evaluate(input));
			
			output
				.setNameOfTheUnderlyingIndex(nameOfTheUnderlyingIndexRule.evaluate(input));
			
			output
				.setMaturityDateOfTheUnderlying(maturityDateOfTheUnderlyingRule.evaluate(input));
			
			output
				.setPriorUTIProprietary(priorUtiProprietaryRule.evaluate(input));
			
			output
				.setClearingAccountOrigin(clearingAccountOriginRule.evaluate(input));
			
			output
				.setClearingReceiptTimestamp(clearingReceiptTimestampRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(utiRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(utiProprietaryRule.evaluate(input));
			
			output
				.setUniqueProductIdentifier(uPIRule.evaluate(input));
			
			output
				.setOriginalSwapUTI(originalSwapUTIRule.evaluate(input));
			
			output
				.setOriginalSwapSDRIdentifier(originalSwapSDRIdentifierRule.evaluate(input));
			
			output
				.setNewSDRIdentifier(newSDRIdentifierRule.evaluate(input));
			
			output
				.setTechnicalRecordIdOverriddenAsString(technicalRecordIdRule.evaluate(input));
			
			output
				.setReferenceEntity(referenceEntityRule.evaluate(input));
			
			output
				.setSeniority(seniorityRule.evaluate(input));
			
			final BigDecimal bigDecimal8 = seriesRule.evaluate(input);
			output
				.setSeries((bigDecimal8 == null ? null : bigDecimal8.intValueExact()));
			
			output
				.setIndexFactor(MapperC.of(indexFactorRule.evaluate(input)).get());
			
			final BigDecimal bigDecimal9 = versionRule.evaluate(input);
			output
				.setSeriesVersion((bigDecimal9 == null ? null : bigDecimal9.intValueExact()));
			
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
				.setOriginalSwapUTIProprietary(originalSwapUTIProprietaryRule.evaluate(input));
			
			output
				.setUnderlyingIndexIndicator(underlyingIndexIndicatorRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
