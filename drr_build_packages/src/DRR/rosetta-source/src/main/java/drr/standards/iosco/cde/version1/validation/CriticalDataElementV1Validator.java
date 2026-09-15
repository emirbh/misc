package drr.standards.iosco.cde.version1.validation;

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
import drr.standards.iosco.cde.version1.CriticalDataElementV1;
import drr.standards.iosco.cde.version1.LegV1;
import drr.standards.iso.ClearedEnum;
import drr.standards.iso.ConfirmationEnum;
import drr.standards.iso.Direction1Enum;
import drr.standards.iso.ValuationType1Code;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CriticalDataElementV1Validator implements Validator<CriticalDataElementV1> {

	private List<ComparisonResult> getComparisonResults(CriticalDataElementV1 o) {
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
				checkCardinality("leg1", (LegV1) o.getLeg1() != null ? 1 : 0, 0, 1), 
				checkCardinality("leg2", (LegV1) o.getLeg2() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CriticalDataElementV1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CriticalDataElementV1", ValidationResult.ValidationType.CARDINALITY, "CriticalDataElementV1", path, "", res.getError());
				}
				return success("CriticalDataElementV1", ValidationResult.ValidationType.CARDINALITY, "CriticalDataElementV1", path, "");
			})
			.collect(toList());
	}

}
