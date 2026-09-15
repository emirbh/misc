package drr.standards.iosco.cde.version3.validation.exists;

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
import drr.standards.iosco.cde.version3.CriticalDataElement;
import drr.standards.iosco.cde.version3.Leg;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ConfirmationEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.EventTypeEnum;
import drr.standards.iso.ReportLevelEnum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class CriticalDataElementOnlyExistsValidator implements ValidatorWithArg<CriticalDataElement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends CriticalDataElement> ValidationResult<CriticalDataElement> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("leg1", ExistenceChecker.isSet((Leg) o.getLeg1()))
				.put("leg2", ExistenceChecker.isSet((Leg) o.getLeg2()))
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
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CriticalDataElement", ValidationResult.ValidationType.ONLY_EXISTS, "CriticalDataElement", path, "");
		}
		return failure("CriticalDataElement", ValidationResult.ValidationType.ONLY_EXISTS, "CriticalDataElement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
