package drr.regulation.hkma.rewrite.trade.validation.exists;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.base.trade.price.PricePeriod;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.Counterparty2IdentifierEnum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.common.ReferenceEntityFormatEnum;
import drr.regulation.common.UTIProprietarySchemeNameEnum;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ConfirmationEnum;
import drr.standards.iso.DeliveryTypeEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.OptionStyleEnum;
import drr.standards.iso.OptionTypeCode;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.SeniorityEnum;
import drr.standards.iso.TradingCapacity7Code;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class HKMATransactionReportOnlyExistsValidator implements ValidatorWithArg<HKMATransactionReport, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends HKMATransactionReport> ValidationResult<HKMATransactionReport> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet((Date) o.getEffectiveDate()))
				.put("earlyTerminationDate", ExistenceChecker.isSet((Date) o.getEarlyTerminationDate()))
				.put("reportingTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getReportingTimestamp()))
				.put("executionTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getExecutionTimestamp()))
				.put("expirationDate", ExistenceChecker.isSet((Date) o.getExpirationDate()))
				.put("counterparty1", ExistenceChecker.isSet((String) o.getCounterparty1()))
				.put("counterparty2", ExistenceChecker.isSet((String) o.getCounterparty2()))
				.put("counterparty2IdentifierType", ExistenceChecker.isSet((Boolean) o.getCounterparty2IdentifierType()))
				.put("beneficiary1", ExistenceChecker.isSet((String) o.getBeneficiary1()))
				.put("beneficiary1IdentifierTypeIndicator", ExistenceChecker.isSet((Boolean) o.getBeneficiary1IdentifierTypeIndicator()))
				.put("buyerIdentifier", ExistenceChecker.isSet((String) o.getBuyerIdentifier()))
				.put("sellerIdentifier", ExistenceChecker.isSet((String) o.getSellerIdentifier()))
				.put("cleared", ExistenceChecker.isSet((ClearedEnum) o.getCleared()))
				.put("centralCounterparty", ExistenceChecker.isSet((String) o.getCentralCounterparty()))
				.put("clearingMember", ExistenceChecker.isSet((String) o.getClearingMember()))
				.put("confirmed", ExistenceChecker.isSet((ConfirmationEnum) o.getConfirmed()))
				.put("callAmount", ExistenceChecker.isSet((BigDecimal) o.getCallAmount()))
				.put("putAmount", ExistenceChecker.isSet((BigDecimal) o.getPutAmount()))
				.put("callCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getCallCurrency()))
				.put("putCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getPutCurrency()))
				.put("delta", ExistenceChecker.isSet((BigDecimal) o.getDelta()))
				.put("priceSchedule", ExistenceChecker.isSet((List<? extends PricePeriod>) o.getPriceSchedule()))
				.put("strikePriceSchedule", ExistenceChecker.isSet((List<? extends PricePeriod>) o.getStrikePriceSchedule()))
				.put("price", ExistenceChecker.isSet((PriceFormat) o.getPrice()))
				.put("priceNotation", ExistenceChecker.isSet((PriceNotationEnum) o.getPriceNotation()))
				.put("priceCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getPriceCurrency()))
				.put("packageTransactionPrice", ExistenceChecker.isSet((PriceFormat) o.getPackageTransactionPrice()))
				.put("packageTransactionPriceNotation", ExistenceChecker.isSet((PriceNotationEnum) o.getPackageTransactionPriceNotation()))
				.put("packageTransactionPriceCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getPackageTransactionPriceCurrency()))
				.put("packageTransactionSpread", ExistenceChecker.isSet((PriceFormat) o.getPackageTransactionSpread()))
				.put("packageTransactionSpreadNotation", ExistenceChecker.isSet((PriceNotationEnum) o.getPackageTransactionSpreadNotation()))
				.put("packageTransactionSpreadCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getPackageTransactionSpreadCurrency()))
				.put("packageIdentifier", ExistenceChecker.isSet((String) o.getPackageIdentifier()))
				.put("strikePrice", ExistenceChecker.isSet((PriceFormat) o.getStrikePrice()))
				.put("strikePriceNotation", ExistenceChecker.isSet((PriceNotationEnum) o.getStrikePriceNotation()))
				.put("strikePriceCurrency", ExistenceChecker.isSet((String) o.getStrikePriceCurrency()))
				.put("priceUnitOfMeasure", ExistenceChecker.isSet((String) o.getPriceUnitOfMeasure()))
				.put("optionPremiumAmount", ExistenceChecker.isSet((BigDecimal) o.getOptionPremiumAmount()))
				.put("optionPremiumCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getOptionPremiumCurrency()))
				.put("optionPremiumPaymentDate", ExistenceChecker.isSet((Date) o.getOptionPremiumPaymentDate()))
				.put("exchangeRate", ExistenceChecker.isSet((BigDecimal) o.getExchangeRate()))
				.put("exchangeRateBasis", ExistenceChecker.isSet((String) o.getExchangeRateBasis()))
				.put("cdSIndexAttachmentPoint", ExistenceChecker.isSet((BigDecimal) o.getCdSIndexAttachmentPoint()))
				.put("cdSIndexDetachmentPoint", ExistenceChecker.isSet((BigDecimal) o.getCdSIndexDetachmentPoint()))
				.put("collateralPortfolioIndicator", ExistenceChecker.isSet((Boolean) o.getCollateralPortfolioIndicator()))
				.put("firstExerciseDate", ExistenceChecker.isSet((Date) o.getFirstExerciseDate()))
				.put("finalContractualSettlementDate", ExistenceChecker.isSet((Date) o.getFinalContractualSettlementDate()))
				.put("settlementLocation", ExistenceChecker.isSet((ISOCountryCodeEnum) o.getSettlementLocation()))
				.put("priorUTI", ExistenceChecker.isSet((String) o.getPriorUTI()))
				.put("direction1", ExistenceChecker.isSet((Direction1Enum) o.getDirection1()))
				.put("valuationAmount", ExistenceChecker.isSet((BigDecimal) o.getValuationAmount()))
				.put("valuationCurrency", ExistenceChecker.isSet((ISOCurrencyCodeEnum) o.getValuationCurrency()))
				.put("valuationMethod", ExistenceChecker.isSet((ValuationType1Code) o.getValuationMethod()))
				.put("valuationTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getValuationTimestamp()))
				.put("customBasketCode", ExistenceChecker.isSet((String) o.getCustomBasketCode()))
				.put("basketConstituents", ExistenceChecker.isSet((List<? extends BasketConstituentsReport>) o.getBasketConstituents()))
				.put("otherPayment", ExistenceChecker.isSet((List<? extends OtherPayment>) o.getOtherPayment()))
				.put("leg1", ExistenceChecker.isSet((CommonLeg) o.getLeg1()))
				.put("leg2", ExistenceChecker.isSet((CommonLeg) o.getLeg2()))
				.put("underlyingIdOther", ExistenceChecker.isSet((String) o.getUnderlyingIdOther()))
				.put("underlyingIdOtherSource", ExistenceChecker.isSet((AssetIdTypeEnum) o.getUnderlyingIdOtherSource()))
				.put("underlyingAssetTradingPlatformIdentifier", ExistenceChecker.isSet((String) o.getUnderlyingAssetTradingPlatformIdentifier()))
				.put("underlyingAssetPriceSource", ExistenceChecker.isSet((String) o.getUnderlyingAssetPriceSource()))
				.put("cryptoAssetUnderlyingIndicator", ExistenceChecker.isSet((Boolean) o.getCryptoAssetUnderlyingIndicator()))
				.put("level", ExistenceChecker.isSet((ReportLevelEnum) o.getLevel()))
				.put("actionType", ExistenceChecker.isSet((ActionTypeEnum) o.getActionType()))
				.put("eventType", ExistenceChecker.isSet((EventTypeEnum) o.getEventType()))
				.put("eventIdentifier", ExistenceChecker.isSet((String) o.getEventIdentifier()))
				.put("eventTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getEventTimestamp()))
				.put("confirmationTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getConfirmationTimestamp()))
				.put("platformIdentifier", ExistenceChecker.isSet((String) o.getPlatformIdentifier()))
				.put("bookingLocation", ExistenceChecker.isSet((ISOCountryCodeEnum) o.getBookingLocation()))
				.put("traderLocation", ExistenceChecker.isSet((ISOCountryCodeEnum) o.getTraderLocation()))
				.put("deliveryType", ExistenceChecker.isSet((DeliveryTypeEnum) o.getDeliveryType()))
				.put("executionAgentCounterparty1", ExistenceChecker.isSet((String) o.getExecutionAgentCounterparty1()))
				.put("executionAgentCounterparty2", ExistenceChecker.isSet((String) o.getExecutionAgentCounterparty2()))
				.put("natureOfCounterparty1", ExistenceChecker.isSet((NatureOfCounterpartyEnum) o.getNatureOfCounterparty1()))
				.put("natureOfCounterparty2", ExistenceChecker.isSet((NatureOfCounterpartyEnum) o.getNatureOfCounterparty2()))
				.put("clearingExceptionsAndExemptionsCounterparty1", ExistenceChecker.isSet((List<ClearingExceptionsAndExemptionsEnum>) o.getClearingExceptionsAndExemptionsCounterparty1()))
				.put("clearingExceptionsAndExemptionsCounterparty2", ExistenceChecker.isSet((List<ClearingExceptionsAndExemptionsEnum>) o.getClearingExceptionsAndExemptionsCounterparty2()))
				.put("corporateSectorOfTheCounterparty1", ExistenceChecker.isSet((List<String>) o.getCorporateSectorOfTheCounterparty1()))
				.put("corporateSectorOfTheCounterparty2", ExistenceChecker.isSet((List<String>) o.getCorporateSectorOfTheCounterparty2()))
				.put("counterparty2Name", ExistenceChecker.isSet((String) o.getCounterparty2Name()))
				.put("reportSubmittingEntityID", ExistenceChecker.isSet((String) o.getReportSubmittingEntityID()))
				.put("entityResponsibleForReporting", ExistenceChecker.isSet((String) o.getEntityResponsibleForReporting()))
				.put("countryOfTheCounterparty2", ExistenceChecker.isSet((ISOCountryCodeEnum) o.getCountryOfTheCounterparty2()))
				.put("counterparty2IdentifierSource", ExistenceChecker.isSet((Counterparty2IdentifierEnum) o.getCounterparty2IdentifierSource()))
				.put("tradingCapacity", ExistenceChecker.isSet((TradingCapacity7Code) o.getTradingCapacity()))
				.put("brokerID", ExistenceChecker.isSet((String) o.getBrokerID()))
				.put("contractType", ExistenceChecker.isSet((CommonContractType) o.getContractType()))
				.put("assetClass", ExistenceChecker.isSet((CommonAssetClass) o.getAssetClass()))
				.put("optionType", ExistenceChecker.isSet((OptionTypeCode) o.getOptionType()))
				.put("optionStyle", ExistenceChecker.isSet((OptionStyleEnum) o.getOptionStyle()))
				.put("embeddedOptionType", ExistenceChecker.isSet((EmbeddedOptionTypeEnum) o.getEmbeddedOptionType()))
				.put("masterAgreementType", ExistenceChecker.isSet((MasterAgreementEnum) o.getMasterAgreementType()))
				.put("masterAgreementVersion", ExistenceChecker.isSet((Integer) o.getMasterAgreementVersion()))
				.put("secondaryTransactionIdentifier", ExistenceChecker.isSet((String) o.getSecondaryTransactionIdentifier()))
				.put("intragroup", ExistenceChecker.isSet((Boolean) o.getIntragroup()))
				.put("nonStandardizedTermIndicator", ExistenceChecker.isSet((Boolean) o.getNonStandardizedTermIndicator()))
				.put("amendmentIndicator", ExistenceChecker.isSet((Boolean) o.getAmendmentIndicator()))
				.put("underlyingIdentification", ExistenceChecker.isSet((String) o.getUnderlyingIdentification()))
				.put("underlyingIdentificationType", ExistenceChecker.isSet((UnderlyingIdentificationTypeEnum) o.getUnderlyingIdentificationType()))
				.put("nameOfTheUnderlyingIndex", ExistenceChecker.isSet((String) o.getNameOfTheUnderlyingIndex()))
				.put("maturityDateOfTheUnderlying", ExistenceChecker.isSet((Date) o.getMaturityDateOfTheUnderlying()))
				.put("swapLinkID", ExistenceChecker.isSet((String) o.getSwapLinkID()))
				.put("packageIndicator", ExistenceChecker.isSet((Boolean) o.getPackageIndicator()))
				.put("customBasketIndicator", ExistenceChecker.isSet((Boolean) o.getCustomBasketIndicator()))
				.put("priorUTIProprietary", ExistenceChecker.isSet((String) o.getPriorUTIProprietary()))
				.put("clearingTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getClearingTimestamp()))
				.put("clearingAccountOrigin", ExistenceChecker.isSet((ClearingAccountOriginEnum) o.getClearingAccountOrigin()))
				.put("clearingReceiptTimestamp", ExistenceChecker.isSet((ZonedDateTime) o.getClearingReceiptTimestamp()))
				.put("uniqueTransactionIdentifier", ExistenceChecker.isSet((String) o.getUniqueTransactionIdentifier()))
				.put("uniqueTransactionIdentifierProprietary", ExistenceChecker.isSet((String) o.getUniqueTransactionIdentifierProprietary()))
				.put("uniqueProductIdentifier", ExistenceChecker.isSet((String) o.getUniqueProductIdentifier()))
				.put("originalSwapUTI", ExistenceChecker.isSet((String) o.getOriginalSwapUTI()))
				.put("subsequentPositionUTI", ExistenceChecker.isSet((String) o.getSubsequentPositionUTI()))
				.put("originalSwapSDRIdentifier", ExistenceChecker.isSet((String) o.getOriginalSwapSDRIdentifier()))
				.put("priorUSI", ExistenceChecker.isSet((String) o.getPriorUSI()))
				.put("newSDRIdentifier", ExistenceChecker.isSet((String) o.getNewSDRIdentifier()))
				.put("technicalRecordId", ExistenceChecker.isSet((String) o.getTechnicalRecordId()))
				.put("referenceEntity", ExistenceChecker.isSet((String) o.getReferenceEntity()))
				.put("seniority", ExistenceChecker.isSet((SeniorityEnum) o.getSeniority()))
				.put("series", ExistenceChecker.isSet((Integer) o.getSeries()))
				.put("indexFactor", ExistenceChecker.isSet((BigDecimal) o.getIndexFactor()))
				.put("seriesVersion", ExistenceChecker.isSet((Integer) o.getSeriesVersion()))
				.put("baseProduct", ExistenceChecker.isSet((String) o.getBaseProduct()))
				.put("subProduct", ExistenceChecker.isSet((String) o.getSubProduct()))
				.put("furtherSubProduct", ExistenceChecker.isSet((String) o.getFurtherSubProduct()))
				.put("barrier", ExistenceChecker.isSet((SingleOrUpperAndLowerBarrier) o.getBarrier()))
				.put("initialMarginCollateralPortfolioCode", ExistenceChecker.isSet((String) o.getInitialMarginCollateralPortfolioCode()))
				.put("variationMarginCollateralPortfolioCode", ExistenceChecker.isSet((String) o.getVariationMarginCollateralPortfolioCode()))
				.put("nonReportable", ExistenceChecker.isSet((NonReportable) o.getNonReportable()))
				.put("basketConstituentNumberOfUnits", ExistenceChecker.isSet((List<BigDecimal>) o.getBasketConstituentNumberOfUnits()))
				.put("basketConstituentUnitOfMeasure", ExistenceChecker.isSet((List<String>) o.getBasketConstituentUnitOfMeasure()))
				.put("productDescription", ExistenceChecker.isSet((String) o.getProductDescription()))
				.put("beneficiary", ExistenceChecker.isSet((String) o.getBeneficiary()))
				.put("remarks", ExistenceChecker.isSet((String) o.getRemarks()))
				.put("remarks1", ExistenceChecker.isSet((String) o.getRemarks1()))
				.put("remarks2", ExistenceChecker.isSet((String) o.getRemarks2()))
				.put("remarks3", ExistenceChecker.isSet((String) o.getRemarks3()))
				.put("remarks4", ExistenceChecker.isSet((String) o.getRemarks4()))
				.put("remarks5", ExistenceChecker.isSet((String) o.getRemarks5()))
				.put("remarks6", ExistenceChecker.isSet((String) o.getRemarks6()))
				.put("remarks7", ExistenceChecker.isSet((String) o.getRemarks7()))
				.put("remarks8", ExistenceChecker.isSet((String) o.getRemarks8()))
				.put("remarks9", ExistenceChecker.isSet((String) o.getRemarks9()))
				.put("remarks10", ExistenceChecker.isSet((String) o.getRemarks10()))
				.put("remarks11", ExistenceChecker.isSet((String) o.getRemarks11()))
				.put("remarks12", ExistenceChecker.isSet((String) o.getRemarks12()))
				.put("remarks13", ExistenceChecker.isSet((String) o.getRemarks13()))
				.put("uniqueProductIdentifierProprietary", ExistenceChecker.isSet((String) o.getUniqueProductIdentifierProprietary()))
				.put("counterparty2IdentifierFormat", ExistenceChecker.isSet((PartyIdentifierFormat2Enum) o.getCounterparty2IdentifierFormat()))
				.put("counterparty2SchemeName", ExistenceChecker.isSet((HKTRPartyScheme) o.getCounterparty2SchemeName()))
				.put("centralCounterpartyIdentifierFormat", ExistenceChecker.isSet((PartyIdentifierFormat2Enum) o.getCentralCounterpartyIdentifierFormat()))
				.put("centralCounterpartySchemeName", ExistenceChecker.isSet((HKTRPartyScheme) o.getCentralCounterpartySchemeName()))
				.put("brokerIdentifierFormat", ExistenceChecker.isSet((PartyIdentifierFormat2Enum) o.getBrokerIdentifierFormat()))
				.put("brokerSchemeName", ExistenceChecker.isSet((HKTRPartyScheme) o.getBrokerSchemeName()))
				.put("referenceEntityFormat", ExistenceChecker.isSet((ReferenceEntityFormatEnum) o.getReferenceEntityFormat()))
				.put("clearingMemberIdentifierFormat", ExistenceChecker.isSet((PartyIdentifierFormat2Enum) o.getClearingMemberIdentifierFormat()))
				.put("clearingMemberSchemeName", ExistenceChecker.isSet((HKTRPartyScheme) o.getClearingMemberSchemeName()))
				.put("priorUTIProprietarySchemeName", ExistenceChecker.isSet((UTIProprietarySchemeNameEnum) o.getPriorUTIProprietarySchemeName()))
				.put("uniqueTransactionIdentifierProprietarySchemeName", ExistenceChecker.isSet((UTIProprietarySchemeNameEnum) o.getUniqueTransactionIdentifierProprietarySchemeName()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("HKMATransactionReport", ValidationResult.ValidationType.ONLY_EXISTS, "HKMATransactionReport", path, "");
		}
		return failure("HKMATransactionReport", ValidationResult.ValidationType.ONLY_EXISTS, "HKMATransactionReport", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
