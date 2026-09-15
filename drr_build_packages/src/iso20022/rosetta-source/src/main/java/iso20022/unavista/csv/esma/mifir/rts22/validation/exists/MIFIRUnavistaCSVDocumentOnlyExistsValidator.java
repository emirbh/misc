package iso20022.unavista.csv.esma.mifir.rts22.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
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
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class MIFIRUnavistaCSVDocumentOnlyExistsValidator implements ValidatorWithArg<MIFIRUnavistaCSVDocument, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends MIFIRUnavistaCSVDocument> ValidationResult<MIFIRUnavistaCSVDocument> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("reportStatus", ExistenceChecker.isSet((ReportStatusEnum) o.getReportStatus()))
				.put("transactionReferenceNumber", ExistenceChecker.isSet((String) o.getTransactionReferenceNumber()))
				.put("venueTransactionID", ExistenceChecker.isSet((String) o.getVenueTransactionID()))
				.put("executingEntityID", ExistenceChecker.isSet((String) o.getExecutingEntityID()))
				.put("submittingEntityID", ExistenceChecker.isSet((String) o.getSubmittingEntityID()))
				.put("investmentFirmIndicator", ExistenceChecker.isSet((Boolean) o.getInvestmentFirmIndicator()))
				.put("buyerID", ExistenceChecker.isSet((String) o.getBuyerID()))
				.put("buyerIDType", ExistenceChecker.isSet((String) o.getBuyerIDType()))
				.put("buyerIDSubType", ExistenceChecker.isSet((String) o.getBuyerIDSubType()))
				.put("buyerCountryOfBranch", ExistenceChecker.isSet((String) o.getBuyerCountryOfBranch()))
				.put("buyerFirstName", ExistenceChecker.isSet((String) o.getBuyerFirstName()))
				.put("buyerSurname", ExistenceChecker.isSet((String) o.getBuyerSurname()))
				.put("buyerDOB", ExistenceChecker.isSet((String) o.getBuyerDOB()))
				.put("buyerDecisionMakerID", ExistenceChecker.isSet((String) o.getBuyerDecisionMakerID()))
				.put("buyerDecisionMakerIDType", ExistenceChecker.isSet((String) o.getBuyerDecisionMakerIDType()))
				.put("buyerDecisionMakerIDSubType", ExistenceChecker.isSet((String) o.getBuyerDecisionMakerIDSubType()))
				.put("buyerDecisionMakerFirstName", ExistenceChecker.isSet((String) o.getBuyerDecisionMakerFirstName()))
				.put("buyerDecisionMakerSurname", ExistenceChecker.isSet((String) o.getBuyerDecisionMakerSurname()))
				.put("buyerDecisionMakerDOB", ExistenceChecker.isSet((String) o.getBuyerDecisionMakerDOB()))
				.put("sellerID", ExistenceChecker.isSet((String) o.getSellerID()))
				.put("sellerIDType", ExistenceChecker.isSet((String) o.getSellerIDType()))
				.put("sellerIDSubType", ExistenceChecker.isSet((String) o.getSellerIDSubType()))
				.put("sellerCountryOfBranch", ExistenceChecker.isSet((String) o.getSellerCountryOfBranch()))
				.put("sellerFirstName", ExistenceChecker.isSet((String) o.getSellerFirstName()))
				.put("sellerSurname", ExistenceChecker.isSet((String) o.getSellerSurname()))
				.put("sellerDOB", ExistenceChecker.isSet((String) o.getSellerDOB()))
				.put("sellerDecisionMakerID", ExistenceChecker.isSet((String) o.getSellerDecisionMakerID()))
				.put("sellerDecisionMakerIDType", ExistenceChecker.isSet((String) o.getSellerDecisionMakerIDType()))
				.put("sellerDecisionMakerIDSubType", ExistenceChecker.isSet((String) o.getSellerDecisionMakerIDSubType()))
				.put("sellerDecisionMakerFirstName", ExistenceChecker.isSet((String) o.getSellerDecisionMakerFirstName()))
				.put("sellerDecisionMakerSurname", ExistenceChecker.isSet((String) o.getSellerDecisionMakerSurname()))
				.put("sellerDecisionMakerDOB", ExistenceChecker.isSet((String) o.getSellerDecisionMakerDOB()))
				.put("orderTransmissionIndicator", ExistenceChecker.isSet((Boolean) o.getOrderTransmissionIndicator()))
				.put("buyerTransmitterID", ExistenceChecker.isSet((String) o.getBuyerTransmitterID()))
				.put("sellerTransmitterID", ExistenceChecker.isSet((String) o.getSellerTransmitterID()))
				.put("tradingDateTime", ExistenceChecker.isSet((ZonedDateTime) o.getTradingDateTime()))
				.put("tradingCapacity", ExistenceChecker.isSet((TradingCapacityEnum) o.getTradingCapacity()))
				.put("quantity", ExistenceChecker.isSet((BigDecimal) o.getQuantity()))
				.put("quantityType", ExistenceChecker.isSet((QuantityTypeEnum) o.getQuantityType()))
				.put("quantityCurrency", ExistenceChecker.isSet((String) o.getQuantityCurrency()))
				.put("derivativeNotionalChange", ExistenceChecker.isSet((DerivativeNotionalChangeEnum) o.getDerivativeNotionalChange()))
				.put("price", ExistenceChecker.isSet((BigDecimal) o.getPrice()))
				.put("priceType", ExistenceChecker.isSet((PriceTypeEnum) o.getPriceType()))
				.put("priceCurrency", ExistenceChecker.isSet((String) o.getPriceCurrency()))
				.put("netAmount", ExistenceChecker.isSet((BigDecimal) o.getNetAmount()))
				.put("venue", ExistenceChecker.isSet((String) o.getVenue()))
				.put("countryOfBranch", ExistenceChecker.isSet((String) o.getCountryOfBranch()))
				.put("upFrontPayment", ExistenceChecker.isSet((BigDecimal) o.getUpFrontPayment()))
				.put("upFrontPaymentCurrency", ExistenceChecker.isSet((String) o.getUpFrontPaymentCurrency()))
				.put("complexTradeComponentID", ExistenceChecker.isSet((String) o.getComplexTradeComponentID()))
				.put("instrumentID", ExistenceChecker.isSet((String) o.getInstrumentID()))
				.put("instrumentIDType", ExistenceChecker.isSet((InstrumentIdTypeEnum) o.getInstrumentIDType()))
				.put("instrumentName", ExistenceChecker.isSet((String) o.getInstrumentName()))
				.put("instrumentClassification", ExistenceChecker.isSet((String) o.getInstrumentClassification()))
				.put("notionalCurrency1", ExistenceChecker.isSet((String) o.getNotionalCurrency1()))
				.put("notionalCurrency2Type", ExistenceChecker.isSet((NotionalCurrency2TypeEnum) o.getNotionalCurrency2Type()))
				.put("notionalCurrency2", ExistenceChecker.isSet((String) o.getNotionalCurrency2()))
				.put("priceMultiplier", ExistenceChecker.isSet((BigDecimal) o.getPriceMultiplier()))
				.put("uvInstrumentClassification", ExistenceChecker.isSet((UVInstrumentClassificationEnum) o.getUvInstrumentClassification()))
				.put("underlyingInstrumentID", ExistenceChecker.isSet((String) o.getUnderlyingInstrumentID()))
				.put("uvIndexClassification", ExistenceChecker.isSet((String) o.getUvIndexClassification()))
				.put("underlyingIndexID", ExistenceChecker.isSet((String) o.getUnderlyingIndexID()))
				.put("underlyingIndexName", ExistenceChecker.isSet((String) o.getUnderlyingIndexName()))
				.put("underlyingIndexTerm", ExistenceChecker.isSet((String) o.getUnderlyingIndexTerm()))
				.put("optionType", ExistenceChecker.isSet((OptionTypeEnum) o.getOptionType()))
				.put("strikePrice", ExistenceChecker.isSet((BigDecimal) o.getStrikePrice()))
				.put("strikePriceType", ExistenceChecker.isSet((PriceTypeEnum) o.getStrikePriceType()))
				.put("strikePriceCurrency", ExistenceChecker.isSet((String) o.getStrikePriceCurrency()))
				.put("optionStyle", ExistenceChecker.isSet((OptionStyleEnum) o.getOptionStyle()))
				.put("maturityDate", ExistenceChecker.isSet((Date) o.getMaturityDate()))
				.put("expiryDate", ExistenceChecker.isSet((Date) o.getExpiryDate()))
				.put("deliveryType", ExistenceChecker.isSet((DeliveryTypeEnum) o.getDeliveryType()))
				.put("investmentDecisionID", ExistenceChecker.isSet((String) o.getInvestmentDecisionID()))
				.put("investmentDecisionIDType", ExistenceChecker.isSet((InvestmnentDecisionIdTypeEnum) o.getInvestmentDecisionIDType()))
				.put("investmentDecisionIDSubType", ExistenceChecker.isSet((DecisionMakerIdSubTypeEnum) o.getInvestmentDecisionIDSubType()))
				.put("investmentDecisionCountryOfBranch", ExistenceChecker.isSet((String) o.getInvestmentDecisionCountryOfBranch()))
				.put("firmExecutionID", ExistenceChecker.isSet((String) o.getFirmExecutionID()))
				.put("firmExecutionIDType", ExistenceChecker.isSet((FirmExecutionIdTypeEnum) o.getFirmExecutionIDType()))
				.put("firmExecutionIDSubType", ExistenceChecker.isSet((DecisionMakerIdSubTypeEnum) o.getFirmExecutionIDSubType()))
				.put("firmExecutionCountryOfBranch", ExistenceChecker.isSet((String) o.getFirmExecutionCountryOfBranch()))
				.put("waiverIndicator", ExistenceChecker.isSet((WaiverIndicatorEnum) o.getWaiverIndicator()))
				.put("shortSellingIndicator", ExistenceChecker.isSet((ShortSellingIndicatorEnum) o.getShortSellingIndicator()))
				.put("otcPostTradeIndicator", ExistenceChecker.isSet((String) o.getOtcPostTradeIndicator()))
				.put("commodityDerivativeIndicator", ExistenceChecker.isSet((Boolean) o.getCommodityDerivativeIndicator()))
				.put("sftIndicator", ExistenceChecker.isSet((Boolean) o.getSftIndicator()))
				.put("dataCategory", ExistenceChecker.isSet((String) o.getDataCategory()))
				.put("internalClientIdentification", ExistenceChecker.isSet((String) o.getInternalClientIdentification()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MIFIRUnavistaCSVDocument", ValidationResult.ValidationType.ONLY_EXISTS, "MIFIRUnavistaCSVDocument", path, "");
		}
		return failure("MIFIRUnavistaCSVDocument", ValidationResult.ValidationType.ONLY_EXISTS, "MIFIRUnavistaCSVDocument", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
