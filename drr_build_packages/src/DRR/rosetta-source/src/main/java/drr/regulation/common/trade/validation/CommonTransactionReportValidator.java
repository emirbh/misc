package drr.regulation.common.trade.validation;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.ClearingAccountOriginEnum;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.Counterparty2IdentifierEnum;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.CommonTransactionReport;
import drr.regulation.common.trade.NonReportable;
import drr.regulation.common.trade.contract.MasterAgreementEnum;
import drr.regulation.common.trade.party.NatureOfCounterpartyEnum;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
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

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CommonTransactionReportValidator implements Validator<CommonTransactionReport> {

	private List<ComparisonResult> getComparisonResults(CommonTransactionReport o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", (Date) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("earlyTerminationDate", (Date) o.getEarlyTerminationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportingTimestamp", (ZonedDateTime) o.getReportingTimestamp() != null ? 1 : 0, 1, 1), 
				checkCardinality("executionTimestamp", (ZonedDateTime) o.getExecutionTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("expirationDate", (Date) o.getExpirationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty1", (String) o.getCounterparty1() != null ? 1 : 0, 1, 1), 
				checkCardinality("counterparty2", (String) o.getCounterparty2() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty2IdentifierType", (Boolean) o.getCounterparty2IdentifierType() != null ? 1 : 0, 0, 1), 
				checkCardinality("beneficiary1", (String) o.getBeneficiary1() != null ? 1 : 0, 0, 1), 
				checkCardinality("beneficiary1IdentifierTypeIndicator", (Boolean) o.getBeneficiary1IdentifierTypeIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerIdentifier", (String) o.getBuyerIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerIdentifier", (String) o.getSellerIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleared", (ClearedEnum) o.getCleared() != null ? 1 : 0, 0, 1), 
				checkCardinality("centralCounterparty", (String) o.getCentralCounterparty() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingMember", (String) o.getClearingMember() != null ? 1 : 0, 0, 1), 
				checkCardinality("confirmed", (ConfirmationEnum) o.getConfirmed() != null ? 1 : 0, 0, 1), 
				checkCardinality("callAmount", (BigDecimal) o.getCallAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("putAmount", (BigDecimal) o.getPutAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("callCurrency", (ISOCurrencyCodeEnum) o.getCallCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("putCurrency", (ISOCurrencyCodeEnum) o.getPutCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("delta", (BigDecimal) o.getDelta() != null ? 1 : 0, 0, 1), 
				checkCardinality("price", (PriceFormat) o.getPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceNotation", (PriceNotationEnum) o.getPriceNotation() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceCurrency", (ISOCurrencyCodeEnum) o.getPriceCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageTransactionPrice", (PriceFormat) o.getPackageTransactionPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageTransactionPriceNotation", (PriceNotationEnum) o.getPackageTransactionPriceNotation() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageTransactionPriceCurrency", (ISOCurrencyCodeEnum) o.getPackageTransactionPriceCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageTransactionSpread", (PriceFormat) o.getPackageTransactionSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageTransactionSpreadNotation", (PriceNotationEnum) o.getPackageTransactionSpreadNotation() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageTransactionSpreadCurrency", (ISOCurrencyCodeEnum) o.getPackageTransactionSpreadCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageIdentifier", (String) o.getPackageIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePrice", (PriceFormat) o.getStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePriceNotation", (PriceNotationEnum) o.getStrikePriceNotation() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePriceCurrency", (String) o.getStrikePriceCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceUnitOfMeasure", (String) o.getPriceUnitOfMeasure() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionPremiumAmount", (BigDecimal) o.getOptionPremiumAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionPremiumCurrency", (ISOCurrencyCodeEnum) o.getOptionPremiumCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionPremiumPaymentDate", (Date) o.getOptionPremiumPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeRate", (BigDecimal) o.getExchangeRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("exchangeRateBasis", (String) o.getExchangeRateBasis() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdSIndexAttachmentPoint", (BigDecimal) o.getCdSIndexAttachmentPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("cdSIndexDetachmentPoint", (BigDecimal) o.getCdSIndexDetachmentPoint() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralPortfolioIndicator", (Boolean) o.getCollateralPortfolioIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("firstExerciseDate", (Date) o.getFirstExerciseDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalContractualSettlementDate", (Date) o.getFinalContractualSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementLocation", (ISOCountryCodeEnum) o.getSettlementLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("priorUTI", (String) o.getPriorUTI() != null ? 1 : 0, 0, 1), 
				checkCardinality("direction1", (Direction1Enum) o.getDirection1() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationAmount", (BigDecimal) o.getValuationAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationCurrency", (ISOCurrencyCodeEnum) o.getValuationCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationMethod", (ValuationType1Code) o.getValuationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationTimestamp", (ZonedDateTime) o.getValuationTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("customBasketCode", (String) o.getCustomBasketCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("leg1", (CommonLeg) o.getLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("leg2", (CommonLeg) o.getLeg2() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingIdOther", (String) o.getUnderlyingIdOther() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingIdOtherSource", (AssetIdTypeEnum) o.getUnderlyingIdOtherSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAssetTradingPlatformIdentifier", (String) o.getUnderlyingAssetTradingPlatformIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAssetPriceSource", (String) o.getUnderlyingAssetPriceSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("cryptoAssetUnderlyingIndicator", (Boolean) o.getCryptoAssetUnderlyingIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("level", (ReportLevelEnum) o.getLevel() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionType", (ActionTypeEnum) o.getActionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("eventType", (EventTypeEnum) o.getEventType() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventIdentifier", (String) o.getEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventTimestamp", (ZonedDateTime) o.getEventTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("confirmationTimestamp", (ZonedDateTime) o.getConfirmationTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("platformIdentifier", (String) o.getPlatformIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("bookingLocation", (ISOCountryCodeEnum) o.getBookingLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("traderLocation", (ISOCountryCodeEnum) o.getTraderLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryType", (DeliveryTypeEnum) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionAgentCounterparty1", (String) o.getExecutionAgentCounterparty1() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionAgentCounterparty2", (String) o.getExecutionAgentCounterparty2() != null ? 1 : 0, 0, 1), 
				checkCardinality("natureOfCounterparty1", (NatureOfCounterpartyEnum) o.getNatureOfCounterparty1() != null ? 1 : 0, 0, 1), 
				checkCardinality("natureOfCounterparty2", (NatureOfCounterpartyEnum) o.getNatureOfCounterparty2() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty2Name", (String) o.getCounterparty2Name() != null ? 1 : 0, 0, 1), 
				checkCardinality("reportSubmittingEntityID", (String) o.getReportSubmittingEntityID() != null ? 1 : 0, 1, 1), 
				checkCardinality("entityResponsibleForReporting", (String) o.getEntityResponsibleForReporting() != null ? 1 : 0, 0, 1), 
				checkCardinality("countryOfTheCounterparty2", (ISOCountryCodeEnum) o.getCountryOfTheCounterparty2() != null ? 1 : 0, 0, 1), 
				checkCardinality("counterparty2IdentifierSource", (Counterparty2IdentifierEnum) o.getCounterparty2IdentifierSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradingCapacity", (TradingCapacity7Code) o.getTradingCapacity() != null ? 1 : 0, 0, 1), 
				checkCardinality("brokerID", (String) o.getBrokerID() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractType", (CommonContractType) o.getContractType() != null ? 1 : 0, 0, 1), 
				checkCardinality("assetClass", (CommonAssetClass) o.getAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (OptionTypeCode) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionStyle", (OptionStyleEnum) o.getOptionStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("embeddedOptionType", (EmbeddedOptionTypeEnum) o.getEmbeddedOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementType", (MasterAgreementEnum) o.getMasterAgreementType() != null ? 1 : 0, 0, 1), 
				checkCardinality("masterAgreementVersion", (Integer) o.getMasterAgreementVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("secondaryTransactionIdentifier", (String) o.getSecondaryTransactionIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("intragroup", (Boolean) o.getIntragroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonStandardizedTermIndicator", (Boolean) o.getNonStandardizedTermIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("amendmentIndicator", (Boolean) o.getAmendmentIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingIdentification", (String) o.getUnderlyingIdentification() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingIdentificationType", (UnderlyingIdentificationTypeEnum) o.getUnderlyingIdentificationType() != null ? 1 : 0, 0, 1), 
				checkCardinality("nameOfTheUnderlyingIndex", (String) o.getNameOfTheUnderlyingIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturityDateOfTheUnderlying", (Date) o.getMaturityDateOfTheUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("swapLinkID", (String) o.getSwapLinkID() != null ? 1 : 0, 0, 1), 
				checkCardinality("packageIndicator", (Boolean) o.getPackageIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("customBasketIndicator", (Boolean) o.getCustomBasketIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("priorUTIProprietary", (String) o.getPriorUTIProprietary() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingTimestamp", (ZonedDateTime) o.getClearingTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingAccountOrigin", (ClearingAccountOriginEnum) o.getClearingAccountOrigin() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingReceiptTimestamp", (ZonedDateTime) o.getClearingReceiptTimestamp() != null ? 1 : 0, 0, 1), 
				checkCardinality("uniqueTransactionIdentifier", (String) o.getUniqueTransactionIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("uniqueTransactionIdentifierProprietary", (String) o.getUniqueTransactionIdentifierProprietary() != null ? 1 : 0, 0, 1), 
				checkCardinality("uniqueProductIdentifier", (String) o.getUniqueProductIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("originalSwapUTI", (String) o.getOriginalSwapUTI() != null ? 1 : 0, 0, 1), 
				checkCardinality("subsequentPositionUTI", (String) o.getSubsequentPositionUTI() != null ? 1 : 0, 0, 1), 
				checkCardinality("originalSwapSDRIdentifier", (String) o.getOriginalSwapSDRIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("priorUSI", (String) o.getPriorUSI() != null ? 1 : 0, 0, 1), 
				checkCardinality("newSDRIdentifier", (String) o.getNewSDRIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("technicalRecordId", (String) o.getTechnicalRecordId() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceEntity", (String) o.getReferenceEntity() != null ? 1 : 0, 0, 1), 
				checkCardinality("seniority", (SeniorityEnum) o.getSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("series", (Integer) o.getSeries() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexFactor", (BigDecimal) o.getIndexFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("seriesVersion", (Integer) o.getSeriesVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("baseProduct", (String) o.getBaseProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("subProduct", (String) o.getSubProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("furtherSubProduct", (String) o.getFurtherSubProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("barrier", (SingleOrUpperAndLowerBarrier) o.getBarrier() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialMarginCollateralPortfolioCode", (String) o.getInitialMarginCollateralPortfolioCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("variationMarginCollateralPortfolioCode", (String) o.getVariationMarginCollateralPortfolioCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("nonReportable", (NonReportable) o.getNonReportable() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommonTransactionReport o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommonTransactionReport", ValidationResult.ValidationType.CARDINALITY, "CommonTransactionReport", path, "", res.getError());
				}
				return success("CommonTransactionReport", ValidationResult.ValidationType.CARDINALITY, "CommonTransactionReport", path, "");
			})
			.collect(toList());
	}

}
