package drr.regulation.esma.emir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaReport;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.reports.EnrichmentDataRule;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.reports.AssetClassRule;
import drr.regulation.common.emir.reports.BaseProductRule;
import drr.regulation.common.emir.reports.BrokerIDRule;
import drr.regulation.common.emir.reports.CDSIndexAttachmentPointRule;
import drr.regulation.common.emir.reports.CDSIndexDetachmentPointRule;
import drr.regulation.common.emir.reports.CentralCounterpartyRule;
import drr.regulation.common.emir.reports.ClearedRule;
import drr.regulation.common.emir.reports.ClearingMemberRule;
import drr.regulation.common.emir.reports.ClearingTimestampRule;
import drr.regulation.common.emir.reports.CollateralPortfolioCodeRule;
import drr.regulation.common.emir.reports.CollateralPortfolioIndicatorRule;
import drr.regulation.common.emir.reports.ContractPriceScheduleRule;
import drr.regulation.common.emir.reports.ContractTypeRule;
import drr.regulation.common.emir.reports.CountryOfTheCounterParty2Rule;
import drr.regulation.common.emir.reports.CustomBasketCodeRule;
import drr.regulation.common.emir.reports.DeliveryPointOrZoneRule;
import drr.regulation.common.emir.reports.DeliveryRule;
import drr.regulation.common.emir.reports.DeliveryTypeRule;
import drr.regulation.common.emir.reports.DeltaRule;
import drr.regulation.common.emir.reports.DirectionOfLeg1Rule;
import drr.regulation.common.emir.reports.DirectionOfLeg2Rule;
import drr.regulation.common.emir.reports.DirectionRule;
import drr.regulation.common.emir.reports.EarlyTerminationDateRule;
import drr.regulation.common.emir.reports.EffectiveDateRule;
import drr.regulation.common.emir.reports.EventDateRule;
import drr.regulation.common.emir.reports.ExchangeRateBasisRule;
import drr.regulation.common.emir.reports.ExchangeRateRule;
import drr.regulation.common.emir.reports.ExecutionTimestampRule;
import drr.regulation.common.emir.reports.ExpirationDateRule;
import drr.regulation.common.emir.reports.FinalContractualSettlementDateRule;
import drr.regulation.common.emir.reports.FixedRateDayCountConventionLeg2Rule;
import drr.regulation.common.emir.reports.FixedRateOfLeg1OrCouponRule;
import drr.regulation.common.emir.reports.FixedRateOfLeg2Rule;
import drr.regulation.common.emir.reports.FixedRateOrCouponDayCountConventionLeg1Rule;
import drr.regulation.common.emir.reports.FloatingRateDayCountConventionOfLeg1Rule;
import drr.regulation.common.emir.reports.FloatingRateDayCountConventionOfLeg2Rule;
import drr.regulation.common.emir.reports.FloatingRatePaymentFrequencyPeriodLeg1Rule;
import drr.regulation.common.emir.reports.FloatingRatePaymentFrequencyPeriodLeg2Rule;
import drr.regulation.common.emir.reports.FloatingRatePaymentFrequencyPeriodMultiplierLeg1Rule;
import drr.regulation.common.emir.reports.FloatingRatePaymentFrequencyPeriodMultiplierLeg2Rule;
import drr.regulation.common.emir.reports.FloatingRateReferencePeriodOfLeg1MultiplierRule;
import drr.regulation.common.emir.reports.FloatingRateReferencePeriodOfLeg1TimePeriodRule;
import drr.regulation.common.emir.reports.FloatingRateResetFrequencyMultiplierOfLeg1Rule;
import drr.regulation.common.emir.reports.FloatingRateResetFrequencyMultiplierOfLeg2Rule;
import drr.regulation.common.emir.reports.FloatingRateResetFrequencyPeriodOfLeg1Rule;
import drr.regulation.common.emir.reports.FloatingRateResetFrequencyPeriodOfLeg2Rule;
import drr.regulation.common.emir.reports.ForwardExchangeRateRule;
import drr.regulation.common.emir.reports.FurtherSubProductRule;
import drr.regulation.common.emir.reports.IdentifierOfBasketConstituentsRule;
import drr.regulation.common.emir.reports.IdentifierOfFloatingRateOfLeg1Rule;
import drr.regulation.common.emir.reports.InterconnectionPointRule;
import drr.regulation.common.emir.reports.LoadTypeRule;
import drr.regulation.common.emir.reports.MasterAgreementTypeRule;
import drr.regulation.common.emir.reports.MasterAgreementVersionRule;
import drr.regulation.common.emir.reports.MaturityDateOfTheUnderlyingRule;
import drr.regulation.common.emir.reports.NameOfTheFloatingRateOfLeg1Rule;
import drr.regulation.common.emir.reports.NameOfTheFloatingRateOfLeg2Rule;
import drr.regulation.common.emir.reports.NameOfTheUnderlyingIndexRule;
import drr.regulation.common.emir.reports.NotionalAmountOfLeg1Rule;
import drr.regulation.common.emir.reports.NotionalAmountOfLeg2Rule;
import drr.regulation.common.emir.reports.NotionalAmountScheduleLeg1Rule;
import drr.regulation.common.emir.reports.NotionalAmountScheduleLeg2Rule;
import drr.regulation.common.emir.reports.NotionalCurrencyLeg1Rule;
import drr.regulation.common.emir.reports.NotionalCurrencyLeg2Rule;
import drr.regulation.common.emir.reports.OptionPremiumAmountRule;
import drr.regulation.common.emir.reports.OptionPremiumCurrencyRule;
import drr.regulation.common.emir.reports.OptionPremiumPaymentDateRule;
import drr.regulation.common.emir.reports.OptionStyleRule;
import drr.regulation.common.emir.reports.OptionTypeRule;
import drr.regulation.common.emir.reports.OtherMasterAgreementTypeRule;
import drr.regulation.common.emir.reports.OtherPaymentRule;
import drr.regulation.common.emir.reports.PTRRIDRule;
import drr.regulation.common.emir.reports.PTRRRule;
import drr.regulation.common.emir.reports.PTRRServiceProviderRule;
import drr.regulation.common.emir.reports.PackageIdentifierRule;
import drr.regulation.common.emir.reports.PackageTransactionPriceCurrencyRule;
import drr.regulation.common.emir.reports.PackageTransactionPriceNotationRule;
import drr.regulation.common.emir.reports.PackageTransactionPriceRule;
import drr.regulation.common.emir.reports.PackageTransactionSpreadCurrencyRule;
import drr.regulation.common.emir.reports.PackageTransactionSpreadNotationRule;
import drr.regulation.common.emir.reports.PackageTransactionSpreadRule;
import drr.regulation.common.emir.reports.PriceCurrencyRule;
import drr.regulation.common.emir.reports.PriceNotationRule;
import drr.regulation.common.emir.reports.PriceRule;
import drr.regulation.common.emir.reports.PriorUtiProprietaryRule;
import drr.regulation.common.emir.reports.PriorUtiRule;
import drr.regulation.common.emir.reports.ReferenceEntityRule;
import drr.regulation.common.emir.reports.SeniorityRule;
import drr.regulation.common.emir.reports.SeriesRule;
import drr.regulation.common.emir.reports.SettlementCurrency1Rule;
import drr.regulation.common.emir.reports.SpreadCurrencyOfLeg1Rule;
import drr.regulation.common.emir.reports.SpreadCurrencyOfLeg2Rule;
import drr.regulation.common.emir.reports.SpreadOfLeg1NotationRule;
import drr.regulation.common.emir.reports.SpreadOfLeg1Rule;
import drr.regulation.common.emir.reports.SpreadOfLeg2NotationRule;
import drr.regulation.common.emir.reports.SpreadOfLeg2Rule;
import drr.regulation.common.emir.reports.StrikePriceCurrencyCurrencyPairRule;
import drr.regulation.common.emir.reports.StrikePriceNotationRule;
import drr.regulation.common.emir.reports.StrikePriceRule;
import drr.regulation.common.emir.reports.StrikePriceScheduleRule;
import drr.regulation.common.emir.reports.SubProductRule;
import drr.regulation.common.emir.reports.SubsequentPositionUtiRule;
import drr.regulation.common.emir.reports.TotalNotionalQuantityLeg1Rule;
import drr.regulation.common.emir.reports.TotalNotionalQuantityLeg2Rule;
import drr.regulation.common.emir.reports.TrancheRule;
import drr.regulation.common.emir.reports.TypeOfPTRRTechniqueRule;
import drr.regulation.common.emir.reports.UnderlyingIdentificationRule;
import drr.regulation.common.emir.reports.UnderlyingIdentificationTypeRule;
import drr.regulation.common.emir.reports.ValuationAmountRule;
import drr.regulation.common.emir.reports.ValuationCurrencyRule;
import drr.regulation.common.emir.reports.ValuationMethodRule;
import drr.regulation.common.emir.reports.ValuationTimestampRule;
import drr.regulation.common.emir.reports.VersionRule;
import drr.regulation.common.trade.datetime.reports.ConfirmationTimestampRule;
import drr.regulation.common.trade.execution.reports.TraderLocationRule;
import drr.regulation.common.trade.party.reports.Counterparty2NameRule;
import drr.regulation.common.trade.party.reports.EntityResponsibleForReportingRule;
import drr.regulation.common.trade.party.reports.ReportSubmittingEntityRule;
import drr.regulation.common.trade.price.reports.SingleOrUpperAndLowerBarrierRule;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.regulation.esma.emir.refit.trade.labels.ESMAEMIRTradeLabelProvider;
import drr.standards.iosco.cde.version3.datetime.reports.ReportingTimestampRule;
import drr.standards.iosco.cde.version3.event.reports.ActionTypeRule;
import drr.standards.iosco.cde.version3.event.reports.EventTypeRule;
import drr.standards.iosco.cde.version3.event.reports.LevelRule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty1Rule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2IdentifierTypeIndicatorRule;
import drr.standards.iosco.cde.version3.party.reports.Counterparty2Rule;
import drr.standards.iosco.cde.version3.underlier.reports.CryptoAssetUnderlyingIndicatorRule;
import drr.standards.iosco.upi.reports.ProductClassificationRule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@RosettaReport(namespace="drr.regulation.esma.emir.refit.trade", body="ESMA", corpusList={"EMIR", "Trade"})
@RuneLabelProvider(labelProvider=ESMAEMIRTradeLabelProvider.class)
@ImplementedBy(ESMAEMIRTradeReportFunction.ESMAEMIRTradeReportFunctionDefault.class)
public abstract class ESMAEMIRTradeReportFunction implements ReportFunction<TransactionReportInstruction, ESMAEMIRTransactionReport> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ActionTypeRule actionTypeRule;
	@Inject protected AssetClassRule assetClassRule;
	@Inject protected BaseProductRule baseProductRule;
	@Inject protected BrokerIDRule brokerIDRule;
	@Inject protected CDSIndexAttachmentPointRule cDSIndexAttachmentPointRule;
	@Inject protected CDSIndexDetachmentPointRule cDSIndexDetachmentPointRule;
	@Inject protected CentralCounterpartyRule centralCounterpartyRule;
	@Inject protected ClearedRule clearedRule;
	@Inject protected ClearingMemberRule clearingMemberRule;
	@Inject protected ClearingObligationRule clearingObligationRule;
	@Inject protected ClearingThresholdOfCounterparty1Rule clearingThresholdOfCounterparty1Rule;
	@Inject protected ClearingThresholdOfCounterparty2Rule clearingThresholdOfCounterparty2Rule;
	@Inject protected ClearingTimestampRule clearingTimestampRule;
	@Inject protected CollateralPortfolioCodeRule collateralPortfolioCodeRule;
	@Inject protected CollateralPortfolioIndicatorRule collateralPortfolioIndicatorRule;
	@Inject protected ConfirmationTimestampRule confirmationTimestampRule;
	@Inject protected ConfirmedRule confirmedRule;
	@Inject protected ContractPriceScheduleRule contractPriceScheduleRule;
	@Inject protected ContractTypeRule contractTypeRule;
	@Inject protected CorporateSectorOfTheCounterparty1Rule corporateSectorOfTheCounterparty1Rule;
	@Inject protected CorporateSectorOfTheCounterparty2Rule corporateSectorOfTheCounterparty2Rule;
	@Inject protected Counterparty1Rule counterparty1Rule;
	@Inject protected Counterparty2IdentifierTypeIndicatorRule counterparty2IdentifierTypeIndicatorRule;
	@Inject protected Counterparty2NameRule counterparty2NameRule;
	@Inject protected Counterparty2Rule counterparty2Rule;
	@Inject protected CountryOfTheCounterParty2Rule countryOfTheCounterParty2Rule;
	@Inject protected CryptoAssetUnderlyingIndicatorRule cryptoAssetUnderlyingIndicatorRule;
	@Inject protected CustomBasketCodeRule customBasketCodeRule;
	@Inject protected DeliveryPointOrZoneRule deliveryPointOrZoneRule;
	@Inject protected DeliveryRule deliveryRule;
	@Inject protected DeliveryTypeRule deliveryTypeRule;
	@Inject protected DeltaRule deltaRule;
	@Inject protected DirectionOfLeg1Rule directionOfLeg1Rule;
	@Inject protected DirectionOfLeg2Rule directionOfLeg2Rule;
	@Inject protected DirectionRule directionRule;
	@Inject protected DirectlyLinkedToCommercialActivityOrTreasuryFinancingRule directlyLinkedToCommercialActivityOrTreasuryFinancingRule;
	@Inject protected EarlyTerminationDateRule earlyTerminationDateRule;
	@Inject protected EffectiveDateRule effectiveDateRule;
	@Inject protected EnrichmentDataRule enrichmentDataRule;
	@Inject protected EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected EventDateRule eventDateRule;
	@Inject protected EventTypeRule eventTypeRule;
	@Inject protected ExchangeRateBasisRule exchangeRateBasisRule;
	@Inject protected ExchangeRateRule exchangeRateRule;
	@Inject protected ExecutionTimestampRule executionTimestampRule;
	@Inject protected ExpirationDateRule expirationDateRule;
	@Inject protected FinalContractualSettlementDateRule finalContractualSettlementDateRule;
	@Inject protected FixedRateDayCountConventionLeg2Rule fixedRateDayCountConventionLeg2Rule;
	@Inject protected FixedRateOfLeg1OrCouponRule fixedRateOfLeg1OrCouponRule;
	@Inject protected FixedRateOfLeg2Rule fixedRateOfLeg2Rule;
	@Inject protected FixedRateOrCouponDayCountConventionLeg1Rule fixedRateOrCouponDayCountConventionLeg1Rule;
	@Inject protected FixedRateOrCouponPaymentFrequencyPeriodLeg1Rule fixedRateOrCouponPaymentFrequencyPeriodLeg1Rule;
	@Inject protected FixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule fixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodLeg2Rule fixedRatePaymentFrequencyPeriodLeg2Rule;
	@Inject protected FixedRatePaymentFrequencyPeriodMultiplierLeg2Rule fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected FloatingRateDayCountConventionOfLeg1Rule floatingRateDayCountConventionOfLeg1Rule;
	@Inject protected FloatingRateDayCountConventionOfLeg2Rule floatingRateDayCountConventionOfLeg2Rule;
	@Inject protected FloatingRateIndicatorLeg1Rule floatingRateIndicatorLeg1Rule;
	@Inject protected FloatingRateIndicatorLeg2Rule floatingRateIndicatorLeg2Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodLeg1Rule floatingRatePaymentFrequencyPeriodLeg1Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodLeg2Rule floatingRatePaymentFrequencyPeriodLeg2Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodMultiplierLeg1Rule floatingRatePaymentFrequencyPeriodMultiplierLeg1Rule;
	@Inject protected FloatingRatePaymentFrequencyPeriodMultiplierLeg2Rule floatingRatePaymentFrequencyPeriodMultiplierLeg2Rule;
	@Inject protected FloatingRateReferencePeriodOfLeg1MultiplierRule floatingRateReferencePeriodOfLeg1MultiplierRule;
	@Inject protected FloatingRateReferencePeriodOfLeg1TimePeriodRule floatingRateReferencePeriodOfLeg1TimePeriodRule;
	@Inject protected FloatingRateReferencePeriodOfLeg2MultiplierRule floatingRateReferencePeriodOfLeg2MultiplierRule;
	@Inject protected FloatingRateReferencePeriodOfLeg2TimePeriodRule floatingRateReferencePeriodOfLeg2TimePeriodRule;
	@Inject protected FloatingRateResetFrequencyMultiplierOfLeg1Rule floatingRateResetFrequencyMultiplierOfLeg1Rule;
	@Inject protected FloatingRateResetFrequencyMultiplierOfLeg2Rule floatingRateResetFrequencyMultiplierOfLeg2Rule;
	@Inject protected FloatingRateResetFrequencyPeriodOfLeg1Rule floatingRateResetFrequencyPeriodOfLeg1Rule;
	@Inject protected FloatingRateResetFrequencyPeriodOfLeg2Rule floatingRateResetFrequencyPeriodOfLeg2Rule;
	@Inject protected ForwardExchangeRateRule forwardExchangeRateRule;
	@Inject protected FurtherSubProductRule furtherSubProductRule;
	@Inject protected ISINRule iSINRule;
	@Inject protected IdentifierOfBasketConstituentsRule identifierOfBasketConstituentsRule;
	@Inject protected IdentifierOfFloatingRateOfLeg1Rule identifierOfFloatingRateOfLeg1Rule;
	@Inject protected IndexFactorRule indexFactorRule;
	@Inject protected IndicatorOfTheUnderlyingIndexRule indicatorOfTheUnderlyingIndexRule;
	@Inject protected InterconnectionPointRule interconnectionPointRule;
	@Inject protected IntragroupRule intragroupRule;
	@Inject protected LevelRule levelRule;
	@Inject protected LoadTypeRule loadTypeRule;
	@Inject protected MasterAgreementTypeRule masterAgreementTypeRule;
	@Inject protected MasterAgreementVersionRule masterAgreementVersionRule;
	@Inject protected MaturityDateOfTheUnderlyingRule maturityDateOfTheUnderlyingRule;
	@Inject protected NameOfTheFloatingRateOfLeg1Rule nameOfTheFloatingRateOfLeg1Rule;
	@Inject protected NameOfTheFloatingRateOfLeg2Rule nameOfTheFloatingRateOfLeg2Rule;
	@Inject protected NameOfTheUnderlyingIndexRule nameOfTheUnderlyingIndexRule;
	@Inject protected NatureOfCounterparty1Rule natureOfCounterparty1Rule;
	@Inject protected NatureOfCounterparty2Rule natureOfCounterparty2Rule;
	@Inject protected NotionalAmountOfLeg1Rule notionalAmountOfLeg1Rule;
	@Inject protected NotionalAmountOfLeg2Rule notionalAmountOfLeg2Rule;
	@Inject protected NotionalAmountScheduleLeg1Rule notionalAmountScheduleLeg1Rule;
	@Inject protected NotionalAmountScheduleLeg2Rule notionalAmountScheduleLeg2Rule;
	@Inject protected NotionalCurrencyLeg1Rule notionalCurrencyLeg1Rule;
	@Inject protected NotionalCurrencyLeg2Rule notionalCurrencyLeg2Rule;
	@Inject protected OptionPremiumAmountRule optionPremiumAmountRule;
	@Inject protected OptionPremiumCurrencyRule optionPremiumCurrencyRule;
	@Inject protected OptionPremiumPaymentDateRule optionPremiumPaymentDateRule;
	@Inject protected OptionStyleRule optionStyleRule;
	@Inject protected OptionTypeRule optionTypeRule;
	@Inject protected OtherMasterAgreementTypeRule otherMasterAgreementTypeRule;
	@Inject protected OtherPaymentRule otherPaymentRule;
	@Inject protected PTRRIDRule pTRRIDRule;
	@Inject protected PTRRRule pTRRRule;
	@Inject protected PTRRServiceProviderRule pTRRServiceProviderRule;
	@Inject protected PackageIdentifierRule packageIdentifierRule;
	@Inject protected PackageTransactionPriceCurrencyRule packageTransactionPriceCurrencyRule;
	@Inject protected PackageTransactionPriceNotationRule packageTransactionPriceNotationRule;
	@Inject protected PackageTransactionPriceRule packageTransactionPriceRule;
	@Inject protected PackageTransactionSpreadCurrencyRule packageTransactionSpreadCurrencyRule;
	@Inject protected PackageTransactionSpreadNotationRule packageTransactionSpreadNotationRule;
	@Inject protected PackageTransactionSpreadRule packageTransactionSpreadRule;
	@Inject protected PriceCurrencyRule priceCurrencyRule;
	@Inject protected PriceNotationRule priceNotationRule;
	@Inject protected PriceRule priceRule;
	@Inject protected PriorUtiProprietaryRule priorUtiProprietaryRule;
	@Inject protected PriorUtiRule priorUtiRule;
	@Inject protected ProductClassificationRule productClassificationRule;
	@Inject protected ReferenceEntityRule referenceEntityRule;
	@Inject protected ReportSubmittingEntityRule reportSubmittingEntityRule;
	@Inject protected ReportTrackingNumberRule reportTrackingNumberRule;
	@Inject protected ReportingObligationOfTheCounterparty2Rule reportingObligationOfTheCounterparty2Rule;
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected SeniorityRule seniorityRule;
	@Inject protected SeriesRule seriesRule;
	@Inject protected SettlementCurrency1Rule settlementCurrency1Rule;
	@Inject protected SingleOrUpperAndLowerBarrierRule singleOrUpperAndLowerBarrierRule;
	@Inject protected SpreadCurrencyOfLeg1Rule spreadCurrencyOfLeg1Rule;
	@Inject protected SpreadCurrencyOfLeg2Rule spreadCurrencyOfLeg2Rule;
	@Inject protected SpreadOfLeg1NotationRule spreadOfLeg1NotationRule;
	@Inject protected SpreadOfLeg1Rule spreadOfLeg1Rule;
	@Inject protected SpreadOfLeg2NotationRule spreadOfLeg2NotationRule;
	@Inject protected SpreadOfLeg2Rule spreadOfLeg2Rule;
	@Inject protected StrikePriceCurrencyCurrencyPairRule strikePriceCurrencyCurrencyPairRule;
	@Inject protected StrikePriceNotationRule strikePriceNotationRule;
	@Inject protected StrikePriceRule strikePriceRule;
	@Inject protected StrikePriceScheduleRule strikePriceScheduleRule;
	@Inject protected SubProductRule subProductRule;
	@Inject protected SubsequentPositionUtiRule subsequentPositionUtiRule;
	@Inject protected TotalNotionalQuantityLeg1Rule totalNotionalQuantityLeg1Rule;
	@Inject protected TotalNotionalQuantityLeg2Rule totalNotionalQuantityLeg2Rule;
	@Inject protected TraderLocationRule traderLocationRule;
	@Inject protected TrancheRule trancheRule;
	@Inject protected TypeOfPTRRTechniqueRule typeOfPTRRTechniqueRule;
	@Inject protected UPIRule uPIRule;
	@Inject protected UnderlyingIdentificationRule underlyingIdentificationRule;
	@Inject protected UnderlyingIdentificationTypeRule underlyingIdentificationTypeRule;
	@Inject protected UtiProprietaryRule utiProprietaryRule;
	@Inject protected UtiRule utiRule;
	@Inject protected ValuationAmountRule valuationAmountRule;
	@Inject protected ValuationCurrencyRule valuationCurrencyRule;
	@Inject protected ValuationMethodRule valuationMethodRule;
	@Inject protected ValuationTimestampRule valuationTimestampRule;
	@Inject protected VenueOfExecutionRule venueOfExecutionRule;
	@Inject protected VersionRule versionRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ESMAEMIRTransactionReport evaluate(TransactionReportInstruction input) {
		ESMAEMIRTransactionReport.ESMAEMIRTransactionReportBuilder outputBuilder = doEvaluate(input);
		
		final ESMAEMIRTransactionReport output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(ESMAEMIRTransactionReport.class, output);
		}
		
		return output;
	}

	protected abstract ESMAEMIRTransactionReport.ESMAEMIRTransactionReportBuilder doEvaluate(TransactionReportInstruction input);

	public static class ESMAEMIRTradeReportFunctionDefault extends ESMAEMIRTradeReportFunction {
		@Override
		protected ESMAEMIRTransactionReport.ESMAEMIRTransactionReportBuilder doEvaluate(TransactionReportInstruction input) {
			ESMAEMIRTransactionReport.ESMAEMIRTransactionReportBuilder output = ESMAEMIRTransactionReport.builder();
			return assignOutput(output, input);
		}
		
		protected ESMAEMIRTransactionReport.ESMAEMIRTransactionReportBuilder assignOutput(ESMAEMIRTransactionReport.ESMAEMIRTransactionReportBuilder output, TransactionReportInstruction input) {
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
				.setDelta(deltaRule.evaluate(input));
			
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
				.setFinalContractualSettlementDate(finalContractualSettlementDateRule.evaluate(input));
			
			output
				.setPriorUTI(priorUtiRule.evaluate(input));
			
			output
				.setDirection1(directionRule.evaluate(input));
			
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
				.setBasketConstituents(identifierOfBasketConstituentsRule.evaluate(input));
			
			output
				.setOtherPayment(otherPaymentRule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFixedRateDayCountConvention(fixedRateOrCouponDayCountConventionLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateDayCountConvention(floatingRateDayCountConventionOfLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriod(fixedRateOrCouponPaymentFrequencyPeriodLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriod(floatingRatePaymentFrequencyPeriodLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriodMultiplier(fixedRateOrCouponPaymentFrequencyPeriodMultiplierLeg1Rule.evaluate(input));
			
			final BigDecimal bigDecimal0 = floatingRatePaymentFrequencyPeriodMultiplierLeg1Rule.evaluate(input);
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriodMultiplier((bigDecimal0 == null ? null : bigDecimal0.intValueExact()));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyPeriod(floatingRateResetFrequencyPeriodOfLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyMultiplier(floatingRateResetFrequencyMultiplierOfLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateIndicator(floatingRateIndicatorLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateIdentifier(identifierOfFloatingRateOfLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriod(floatingRateReferencePeriodOfLeg1TimePeriodRule.evaluate(input));
			
			final BigDecimal bigDecimal1 = floatingRateReferencePeriodOfLeg1MultiplierRule.evaluate(input);
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriodMultiplier((bigDecimal1 == null ? null : bigDecimal1.intValueExact()));
			
			output
				.getOrCreateLeg1()
				.getOrCreatePeriodicPayment()
				.setNameOfTheFloatingRate(nameOfTheFloatingRateOfLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setNotionalAmount(notionalAmountOfLeg1Rule.evaluate(input));
			
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
				.setFixedRate(fixedRateOfLeg1OrCouponRule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setSettlementCurrency(settlementCurrency1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setSpread(spreadOfLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setSpreadNotation(spreadOfLeg1NotationRule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setSpreadCurrency(spreadCurrencyOfLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg1()
				.setDirection2(directionOfLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFixedRateDayCountConvention(fixedRateDayCountConventionLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateDayCountConvention(floatingRateDayCountConventionOfLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriod(fixedRatePaymentFrequencyPeriodLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriod(floatingRatePaymentFrequencyPeriodLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFixedRatePaymentFrequencyPeriodMultiplier(fixedRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input));
			
			final BigDecimal bigDecimal2 = floatingRatePaymentFrequencyPeriodMultiplierLeg2Rule.evaluate(input);
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRatePaymentFrequencyPeriodMultiplier((bigDecimal2 == null ? null : bigDecimal2.intValueExact()));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyPeriod(floatingRateResetFrequencyPeriodOfLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateResetFrequencyMultiplier(floatingRateResetFrequencyMultiplierOfLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateIndicator(floatingRateIndicatorLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateIdentifier(identifierOfFloatingRateOfLeg1Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriod(floatingRateReferencePeriodOfLeg2TimePeriodRule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setFloatingRateReferencePeriodMultiplier(floatingRateReferencePeriodOfLeg2MultiplierRule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.getOrCreatePeriodicPayment()
				.setNameOfTheFloatingRate(nameOfTheFloatingRateOfLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setNotionalAmount(notionalAmountOfLeg2Rule.evaluate(input));
			
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
				.setFixedRate(fixedRateOfLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setSpread(spreadOfLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setSpreadNotation(spreadOfLeg2NotationRule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setSpreadCurrency(spreadCurrencyOfLeg2Rule.evaluate(input));
			
			output
				.getOrCreateLeg2()
				.setDirection2(directionOfLeg2Rule.evaluate(input));
			
			output
				.setCryptoAssetUnderlyingIndicatorOverriddenAsBoolean(cryptoAssetUnderlyingIndicatorRule.evaluate(input));
			
			output
				.setLevelOverriddenAsReportLevelEnum(levelRule.evaluate(input));
			
			output
				.setActionType(actionTypeRule.evaluate(input));
			
			output
				.setEventType(eventTypeRule.evaluate(input));
			
			output
				.setConfirmationTimestamp(confirmationTimestampRule.evaluate(input));
			
			output
				.setTraderLocation(MapperC.of(traderLocationRule.evaluate(input)).get());
			
			output
				.setDeliveryTypeOverriddenAsDeliveryTypeEnum(deliveryTypeRule.evaluate(input));
			
			output
				.setNatureOfCounterparty1OverriddenAsNatureOfCounterpartyEnum(natureOfCounterparty1Rule.evaluate(input));
			
			output
				.setNatureOfCounterparty2(natureOfCounterparty2Rule.evaluate(input));
			
			output
				.setCorporateSectorOfTheCounterparty1(corporateSectorOfTheCounterparty1Rule.evaluate(input));
			
			output
				.setCorporateSectorOfTheCounterparty2(corporateSectorOfTheCounterparty2Rule.evaluate(input));
			
			output
				.setCounterparty2Name(counterparty2NameRule.evaluate(input));
			
			output
				.setReportSubmittingEntityID(reportSubmittingEntityRule.evaluate(input));
			
			output
				.setEntityResponsibleForReporting(entityResponsibleForReportingRule.evaluate(input));
			
			output
				.setCountryOfTheCounterparty2(countryOfTheCounterParty2Rule.evaluate(input));
			
			output
				.setBrokerID(brokerIDRule.evaluate(input));
			
			output
				.setContractTypeOverriddenAsCommonContractType(contractTypeRule.evaluate(input));
			
			output
				.setAssetClassOverriddenAsCommonAssetClass(assetClassRule.evaluate(input));
			
			output
				.setOptionType(optionTypeRule.evaluate(input));
			
			output
				.setOptionStyle(optionStyleRule.evaluate(input));
			
			output
				.setMasterAgreementTypeOverriddenAsMasterAgreementEnum(masterAgreementTypeRule.evaluate(input));
			
			output
				.setMasterAgreementVersion(masterAgreementVersionRule.evaluate(input));
			
			output
				.setIntragroup(intragroupRule.evaluate(input));
			
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
				.setClearingTimestamp(clearingTimestampRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifier(utiRule.evaluate(input));
			
			output
				.setUniqueTransactionIdentifierProprietary(utiProprietaryRule.evaluate(input));
			
			output
				.setUniqueProductIdentifier(uPIRule.evaluate(input));
			
			output
				.setSubsequentPositionUTI(subsequentPositionUtiRule.evaluate(input));
			
			output
				.setReferenceEntity(referenceEntityRule.evaluate(input));
			
			output
				.setSeniority(seniorityRule.evaluate(input));
			
			final BigDecimal bigDecimal3 = seriesRule.evaluate(input);
			output
				.setSeries((bigDecimal3 == null ? null : bigDecimal3.intValueExact()));
			
			output
				.setIndexFactor(indexFactorRule.evaluate(input));
			
			final BigDecimal bigDecimal4 = versionRule.evaluate(input);
			output
				.setSeriesVersion((bigDecimal4 == null ? null : bigDecimal4.intValueExact()));
			
			output
				.setBaseProduct(baseProductRule.evaluate(input));
			
			output
				.setSubProduct(subProductRule.evaluate(input));
			
			output
				.setFurtherSubProduct(furtherSubProductRule.evaluate(input));
			
			output
				.setBarrier(singleOrUpperAndLowerBarrierRule.evaluate(input));
			
			output
				.getOrCreateNonReportable()
				.setEnrichment(enrichmentDataRule.evaluate(input));
			
			output
				.setOtherMasterAgreementType(otherMasterAgreementTypeRule.evaluate(input));
			
			output
				.setCollateralPortfolioCode(collateralPortfolioCodeRule.evaluate(input));
			
			output
				.setPtrrId(pTRRIDRule.evaluate(input));
			
			output
				.setClearingThresholdOfCounterparty1(clearingThresholdOfCounterparty1Rule.evaluate(input));
			
			output
				.setClearingThresholdOfCounterparty2(clearingThresholdOfCounterparty2Rule.evaluate(input));
			
			output
				.setReportingObligationOfTheCounterparty2(reportingObligationOfTheCounterparty2Rule.evaluate(input));
			
			output
				.setDirectlyLinkedToCommercialActivityOrTreasuryFinancing(directlyLinkedToCommercialActivityOrTreasuryFinancingRule.evaluate(input));
			
			output
				.setReportTrackingNumber(reportTrackingNumberRule.evaluate(input));
			
			output
				.setIsin(iSINRule.evaluate(input));
			
			output
				.setProductClassification(productClassificationRule.evaluate(input));
			
			output
				.setIndicatorOfTheUnderlyingIndex(indicatorOfTheUnderlyingIndexRule.evaluate(input));
			
			output
				.setClearingObligation(clearingObligationRule.evaluate(input));
			
			output
				.setPtrr(pTRRRule.evaluate(input));
			
			output
				.setTypeOfPTRRTechnique(typeOfPTRRTechniqueRule.evaluate(input));
			
			output
				.setPtrrServiceProvider(pTRRServiceProviderRule.evaluate(input));
			
			output
				.setVenueOfExecution(venueOfExecutionRule.evaluate(input));
			
			output
				.setForwardExchangeRate(forwardExchangeRateRule.evaluate(input));
			
			output
				.setDeliveryPoint(deliveryPointOrZoneRule.evaluate(input));
			
			output
				.setInterconnectionPoint(interconnectionPointRule.evaluate(input));
			
			output
				.setLoadType(loadTypeRule.evaluate(input));
			
			output
				.setDeliveryReport(deliveryRule.evaluate(input));
			
			output
				.setTranche(MapperC.of(trancheRule.evaluate(input)).get());
			
			output
				.setEventDate(eventDateRule.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
