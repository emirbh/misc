package iso20022.unavista.csv.esma.mifir.rts22.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.unavista.csv.esma.mifir.rts22.DecisionMakerIdSubTypeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.DeliveryTypeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.DerivativeNotionalChangeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.FirmExecutionIdTypeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.InstrumentIdTypeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.InvestmnentDecisionIdTypeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.MIFIRUnavistaCSVDocument;
import iso20022.unavista.csv.esma.mifir.rts22.NotionalCurrency2TypeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.OptionStyleEnum;
import iso20022.unavista.csv.esma.mifir.rts22.OptionTypeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.PriceTypeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.QuantityTypeEnum;
import iso20022.unavista.csv.esma.mifir.rts22.ReportStatusEnum;
import iso20022.unavista.csv.esma.mifir.rts22.ShortSellingIndicatorEnum;
import iso20022.unavista.csv.esma.mifir.rts22.TradingCapacityEnum;
import iso20022.unavista.csv.esma.mifir.rts22.UVInstrumentClassificationEnum;
import iso20022.unavista.csv.esma.mifir.rts22.WaiverIndicatorEnum;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MIFIRUnavistaCSVDocumentValidator implements Validator<MIFIRUnavistaCSVDocument> {

	private List<ComparisonResult> getComparisonResults(MIFIRUnavistaCSVDocument o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reportStatus", (ReportStatusEnum) o.getReportStatus() != null ? 1 : 0, 1, 1), 
				checkCardinality("transactionReferenceNumber", (String) o.getTransactionReferenceNumber() != null ? 1 : 0, 1, 1), 
				checkCardinality("venueTransactionID", (String) o.getVenueTransactionID() != null ? 1 : 0, 0, 1), 
				checkCardinality("executingEntityID", (String) o.getExecutingEntityID() != null ? 1 : 0, 1, 1), 
				checkCardinality("submittingEntityID", (String) o.getSubmittingEntityID() != null ? 1 : 0, 1, 1), 
				checkCardinality("investmentFirmIndicator", (Boolean) o.getInvestmentFirmIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerID", (String) o.getBuyerID() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerIDType", (String) o.getBuyerIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerIDSubType", (String) o.getBuyerIDSubType() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerCountryOfBranch", (String) o.getBuyerCountryOfBranch() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerFirstName", (String) o.getBuyerFirstName() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSurname", (String) o.getBuyerSurname() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerDOB", (String) o.getBuyerDOB() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerDecisionMakerID", (String) o.getBuyerDecisionMakerID() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerDecisionMakerIDType", (String) o.getBuyerDecisionMakerIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerDecisionMakerIDSubType", (String) o.getBuyerDecisionMakerIDSubType() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerDecisionMakerFirstName", (String) o.getBuyerDecisionMakerFirstName() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerDecisionMakerSurname", (String) o.getBuyerDecisionMakerSurname() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerDecisionMakerDOB", (String) o.getBuyerDecisionMakerDOB() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerID", (String) o.getSellerID() != null ? 1 : 0, 1, 1), 
				checkCardinality("sellerIDType", (String) o.getSellerIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerIDSubType", (String) o.getSellerIDSubType() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerCountryOfBranch", (String) o.getSellerCountryOfBranch() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerFirstName", (String) o.getSellerFirstName() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerSurname", (String) o.getSellerSurname() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerDOB", (String) o.getSellerDOB() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerDecisionMakerID", (String) o.getSellerDecisionMakerID() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerDecisionMakerIDType", (String) o.getSellerDecisionMakerIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerDecisionMakerIDSubType", (String) o.getSellerDecisionMakerIDSubType() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerDecisionMakerFirstName", (String) o.getSellerDecisionMakerFirstName() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerDecisionMakerSurname", (String) o.getSellerDecisionMakerSurname() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerDecisionMakerDOB", (String) o.getSellerDecisionMakerDOB() != null ? 1 : 0, 0, 1), 
				checkCardinality("orderTransmissionIndicator", (Boolean) o.getOrderTransmissionIndicator() != null ? 1 : 0, 1, 1), 
				checkCardinality("buyerTransmitterID", (String) o.getBuyerTransmitterID() != null ? 1 : 0, 0, 1), 
				checkCardinality("sellerTransmitterID", (String) o.getSellerTransmitterID() != null ? 1 : 0, 0, 1), 
				checkCardinality("tradingDateTime", (ZonedDateTime) o.getTradingDateTime() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradingCapacity", (TradingCapacityEnum) o.getTradingCapacity() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantity", (BigDecimal) o.getQuantity() != null ? 1 : 0, 1, 1), 
				checkCardinality("quantityType", (QuantityTypeEnum) o.getQuantityType() != null ? 1 : 0, 0, 1), 
				checkCardinality("quantityCurrency", (String) o.getQuantityCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("derivativeNotionalChange", (DerivativeNotionalChangeEnum) o.getDerivativeNotionalChange() != null ? 1 : 0, 0, 1), 
				checkCardinality("price", (BigDecimal) o.getPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceType", (PriceTypeEnum) o.getPriceType() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceCurrency", (String) o.getPriceCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("netAmount", (BigDecimal) o.getNetAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("venue", (String) o.getVenue() != null ? 1 : 0, 1, 1), 
				checkCardinality("countryOfBranch", (String) o.getCountryOfBranch() != null ? 1 : 0, 0, 1), 
				checkCardinality("upFrontPayment", (BigDecimal) o.getUpFrontPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("upFrontPaymentCurrency", (String) o.getUpFrontPaymentCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("complexTradeComponentID", (String) o.getComplexTradeComponentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentID", (String) o.getInstrumentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentIDType", (InstrumentIdTypeEnum) o.getInstrumentIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentName", (String) o.getInstrumentName() != null ? 1 : 0, 0, 1), 
				checkCardinality("instrumentClassification", (String) o.getInstrumentClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalCurrency1", (String) o.getNotionalCurrency1() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalCurrency2Type", (NotionalCurrency2TypeEnum) o.getNotionalCurrency2Type() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalCurrency2", (String) o.getNotionalCurrency2() != null ? 1 : 0, 0, 1), 
				checkCardinality("priceMultiplier", (BigDecimal) o.getPriceMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("uvInstrumentClassification", (UVInstrumentClassificationEnum) o.getUvInstrumentClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingInstrumentID", (String) o.getUnderlyingInstrumentID() != null ? 1 : 0, 0, 1), 
				checkCardinality("uvIndexClassification", (String) o.getUvIndexClassification() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingIndexID", (String) o.getUnderlyingIndexID() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingIndexName", (String) o.getUnderlyingIndexName() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingIndexTerm", (String) o.getUnderlyingIndexTerm() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionType", (OptionTypeEnum) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePrice", (BigDecimal) o.getStrikePrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePriceType", (PriceTypeEnum) o.getStrikePriceType() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikePriceCurrency", (String) o.getStrikePriceCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionStyle", (OptionStyleEnum) o.getOptionStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("maturityDate", (Date) o.getMaturityDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiryDate", (Date) o.getExpiryDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("deliveryType", (DeliveryTypeEnum) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("investmentDecisionID", (String) o.getInvestmentDecisionID() != null ? 1 : 0, 0, 1), 
				checkCardinality("investmentDecisionIDType", (InvestmnentDecisionIdTypeEnum) o.getInvestmentDecisionIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("investmentDecisionIDSubType", (DecisionMakerIdSubTypeEnum) o.getInvestmentDecisionIDSubType() != null ? 1 : 0, 0, 1), 
				checkCardinality("investmentDecisionCountryOfBranch", (String) o.getInvestmentDecisionCountryOfBranch() != null ? 1 : 0, 0, 1), 
				checkCardinality("firmExecutionID", (String) o.getFirmExecutionID() != null ? 1 : 0, 1, 1), 
				checkCardinality("firmExecutionIDType", (FirmExecutionIdTypeEnum) o.getFirmExecutionIDType() != null ? 1 : 0, 0, 1), 
				checkCardinality("firmExecutionIDSubType", (DecisionMakerIdSubTypeEnum) o.getFirmExecutionIDSubType() != null ? 1 : 0, 0, 1), 
				checkCardinality("firmExecutionCountryOfBranch", (String) o.getFirmExecutionCountryOfBranch() != null ? 1 : 0, 0, 1), 
				checkCardinality("waiverIndicator", (WaiverIndicatorEnum) o.getWaiverIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("shortSellingIndicator", (ShortSellingIndicatorEnum) o.getShortSellingIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("otcPostTradeIndicator", (String) o.getOtcPostTradeIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityDerivativeIndicator", (Boolean) o.getCommodityDerivativeIndicator() != null ? 1 : 0, 0, 1), 
				checkCardinality("sftIndicator", (Boolean) o.getSftIndicator() != null ? 1 : 0, 1, 1), 
				checkCardinality("dataCategory", (String) o.getDataCategory() != null ? 1 : 0, 0, 1), 
				checkCardinality("internalClientIdentification", (String) o.getInternalClientIdentification() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MIFIRUnavistaCSVDocument o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MIFIRUnavistaCSVDocument", ValidationResult.ValidationType.CARDINALITY, "MIFIRUnavistaCSVDocument", path, "", res.getError());
				}
				return success("MIFIRUnavistaCSVDocument", ValidationResult.ValidationType.CARDINALITY, "MIFIRUnavistaCSVDocument", path, "");
			})
			.collect(toList());
	}

}
