package iso20022.unavista.csv.esma.mifir.rts22;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import iso20022.unavista.csv.esma.mifir.rts22.meta.MIFIRUnavistaCSVDocumentMeta;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Type definition for the MiFID transaction report.
 * @version ${project.version}
 */
@RosettaDataType(value="MIFIRUnavistaCSVDocument", builder=MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilderImpl.class, version="${project.version}")
@RuneDataType(value="MIFIRUnavistaCSVDocument", model="iso20022", builder=MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilderImpl.class, version="${project.version}")
public interface MIFIRUnavistaCSVDocument extends RosettaModelObject {

	MIFIRUnavistaCSVDocumentMeta metaData = new MIFIRUnavistaCSVDocumentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indication as to whether the transaction report is new or a cancellation.
	 */
	ReportStatusEnum getReportStatus();
	/**
	 * The internal reference number of the transaction.
	 */
	String getTransactionReferenceNumber();
	/**
	 * Alphanumeric code assigned by the trading venue.
	 */
	String getVenueTransactionID();
	/**
	 * Identification of the investment firm executing the transaction.
	 */
	String getExecutingEntityID();
	/**
	 * Identification of the submitting entity.
	 */
	String getSubmittingEntityID();
	/**
	 * Indicates if the party is an investment firm.
	 */
	Boolean getInvestmentFirmIndicator();
	/**
	 * Identification of the acquiring party.
	 */
	String getBuyerID();
	/**
	 * Type of Buyer ID.
	 */
	String getBuyerIDType();
	/**
	 * Sub-type of Buyer ID.
	 */
	String getBuyerIDSubType();
	/**
	 * Country of the branch for the buyer.
	 */
	String getBuyerCountryOfBranch();
	/**
	 * First name of the buyer.
	 */
	String getBuyerFirstName();
	/**
	 * Surname of the buyer.
	 */
	String getBuyerSurname();
	/**
	 * Date of birth of the buyer.
	 */
	String getBuyerDOB();
	/**
	 * ID of the buyer&#39;s decision maker.
	 */
	String getBuyerDecisionMakerID();
	/**
	 * Type of Buyer Decision Maker ID.
	 */
	String getBuyerDecisionMakerIDType();
	/**
	 * Sub-type of Buyer Decision Maker ID
	 */
	String getBuyerDecisionMakerIDSubType();
	/**
	 * First name of the buyer&#39;s decision maker.
	 */
	String getBuyerDecisionMakerFirstName();
	/**
	 * Surname of the buyer&#39;s decision maker.
	 */
	String getBuyerDecisionMakerSurname();
	/**
	 * Date of birth of the buyer&#39;s decision maker.
	 */
	String getBuyerDecisionMakerDOB();
	/**
	 * Identification of the selling party.
	 */
	String getSellerID();
	/**
	 * Type of Seller ID.
	 */
	String getSellerIDType();
	/**
	 * Sub-type of Seller ID.
	 */
	String getSellerIDSubType();
	/**
	 * Country of the branch for the seller.
	 */
	String getSellerCountryOfBranch();
	/**
	 * First name of the seller.
	 */
	String getSellerFirstName();
	/**
	 * Surname of the seller.
	 */
	String getSellerSurname();
	/**
	 * Date of birth of the seller.
	 */
	String getSellerDOB();
	/**
	 * ID of the seller&#39;s decision maker.
	 */
	String getSellerDecisionMakerID();
	/**
	 * Type of Seller Decision Maker ID.
	 */
	String getSellerDecisionMakerIDType();
	/**
	 * Sub-type of Seller Decision Maker ID.
	 */
	String getSellerDecisionMakerIDSubType();
	/**
	 * First name of the seller&#39;s decision maker.
	 */
	String getSellerDecisionMakerFirstName();
	/**
	 * Surname of the seller&#39;s decision maker.
	 */
	String getSellerDecisionMakerSurname();
	/**
	 * Date of birth of the seller&#39;s decision maker.
	 */
	String getSellerDecisionMakerDOB();
	/**
	 * Indicates if the order was transmitted.
	 */
	Boolean getOrderTransmissionIndicator();
	/**
	 * ID of the buyer transmitter.
	 */
	String getBuyerTransmitterID();
	/**
	 * ID of the seller transmitter.
	 */
	String getSellerTransmitterID();
	/**
	 * The date and time when the transaction was executed.
	 */
	ZonedDateTime getTradingDateTime();
	/**
	 * Capacity in which the firm executed the transaction.
	 */
	TradingCapacityEnum getTradingCapacity();
	/**
	 * The number of units.
	 */
	BigDecimal getQuantity();
	/**
	 * The type of quantity.
	 */
	QuantityTypeEnum getQuantityType();
	/**
	 * Currency in which the quantity is expressed.
	 */
	String getQuantityCurrency();
	/**
	 * Change in derivative notional.
	 */
	DerivativeNotionalChangeEnum getDerivativeNotionalChange();
	/**
	 * The price per security or derivative contract.
	 */
	BigDecimal getPrice();
	/**
	 * The type of price.
	 */
	PriceTypeEnum getPriceType();
	/**
	 * Currency in which the price is expressed.
	 */
	String getPriceCurrency();
	/**
	 * Net amount of the transaction.
	 */
	BigDecimal getNetAmount();
	/**
	 * Identification of the venue where the transaction was executed.
	 */
	String getVenue();
	/**
	 * Country of the branch.
	 */
	String getCountryOfBranch();
	/**
	 * Monetary value of any upfront payment.
	 */
	BigDecimal getUpFrontPayment();
	/**
	 * Currency of the upfront payment.
	 */
	String getUpFrontPaymentCurrency();
	/**
	 * Identifier of the complex trade component.
	 */
	String getComplexTradeComponentID();
	/**
	 * Instrument ID.
	 */
	String getInstrumentID();
	/**
	 * Type of Instrument ID.
	 */
	InstrumentIdTypeEnum getInstrumentIDType();
	/**
	 * Name of the instrument.
	 */
	String getInstrumentName();
	/**
	 * Classification of the instrument.
	 */
	String getInstrumentClassification();
	/**
	 * First notional currency.
	 */
	String getNotionalCurrency1();
	/**
	 * Type of the second notional currency.
	 */
	NotionalCurrency2TypeEnum getNotionalCurrency2Type();
	/**
	 * Second notional currency.
	 */
	String getNotionalCurrency2();
	/**
	 * Price multiplier.
	 */
	BigDecimal getPriceMultiplier();
	/**
	 * UV Instrument Classification.
	 */
	UVInstrumentClassificationEnum getUvInstrumentClassification();
	/**
	 * Underlying Instrument ID.
	 */
	String getUnderlyingInstrumentID();
	/**
	 * UV Index Classification.
	 */
	String getUvIndexClassification();
	/**
	 * Underlying Index ID.
	 */
	String getUnderlyingIndexID();
	/**
	 * Underlying Index Name.
	 */
	String getUnderlyingIndexName();
	/**
	 * Underlying Index Term.
	 */
	String getUnderlyingIndexTerm();
	/**
	 * Type of option.
	 */
	OptionTypeEnum getOptionType();
	/**
	 * Strike price of the option.
	 */
	BigDecimal getStrikePrice();
	/**
	 * Strike price type.
	 */
	PriceTypeEnum getStrikePriceType();
	/**
	 * Currency of the strike price.
	 */
	String getStrikePriceCurrency();
	/**
	 * Style of the option.
	 */
	OptionStyleEnum getOptionStyle();
	/**
	 * Maturity date of the instrument.
	 */
	Date getMaturityDate();
	/**
	 * Expiry date of the instrument.
	 */
	Date getExpiryDate();
	/**
	 * Delivery type.
	 */
	DeliveryTypeEnum getDeliveryType();
	/**
	 * Investment Decision ID.
	 */
	String getInvestmentDecisionID();
	/**
	 * Investment Decision ID Type.
	 */
	InvestmnentDecisionIdTypeEnum getInvestmentDecisionIDType();
	/**
	 * Investment Decision ID Sub Type.
	 */
	DecisionMakerIdSubTypeEnum getInvestmentDecisionIDSubType();
	/**
	 * Investment Decision Country of Branch.
	 */
	String getInvestmentDecisionCountryOfBranch();
	/**
	 * Firm Execution ID.
	 */
	String getFirmExecutionID();
	/**
	 * Firm Execution ID Type.
	 */
	FirmExecutionIdTypeEnum getFirmExecutionIDType();
	/**
	 * Firm Execution ID Sub Type.
	 */
	DecisionMakerIdSubTypeEnum getFirmExecutionIDSubType();
	/**
	 * Firm Execution Country of Branch.
	 */
	String getFirmExecutionCountryOfBranch();
	/**
	 * Waiver Indicator.
	 */
	WaiverIndicatorEnum getWaiverIndicator();
	/**
	 * Short Selling Indicator.
	 */
	ShortSellingIndicatorEnum getShortSellingIndicator();
	/**
	 * OTC Post Trade Indicator.
	 */
	String getOtcPostTradeIndicator();
	/**
	 * Commodity Derivative Indicator.
	 */
	Boolean getCommodityDerivativeIndicator();
	/**
	 * SFT Indicator.
	 */
	Boolean getSftIndicator();
	/**
	 * Data Category.
	 */
	String getDataCategory();
	/**
	 * Internal client identification.
	 */
	String getInternalClientIdentification();

	/*********************** Build Methods  ***********************/
	MIFIRUnavistaCSVDocument build();
	
	MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder toBuilder();
	
	static MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder builder() {
		return new MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MIFIRUnavistaCSVDocument> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MIFIRUnavistaCSVDocument> getType() {
		return MIFIRUnavistaCSVDocument.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("reportStatus"), ReportStatusEnum.class, getReportStatus(), this);
		processor.processBasic(path.newSubPath("transactionReferenceNumber"), String.class, getTransactionReferenceNumber(), this);
		processor.processBasic(path.newSubPath("venueTransactionID"), String.class, getVenueTransactionID(), this);
		processor.processBasic(path.newSubPath("executingEntityID"), String.class, getExecutingEntityID(), this);
		processor.processBasic(path.newSubPath("submittingEntityID"), String.class, getSubmittingEntityID(), this);
		processor.processBasic(path.newSubPath("investmentFirmIndicator"), Boolean.class, getInvestmentFirmIndicator(), this);
		processor.processBasic(path.newSubPath("buyerID"), String.class, getBuyerID(), this);
		processor.processBasic(path.newSubPath("buyerIDType"), String.class, getBuyerIDType(), this);
		processor.processBasic(path.newSubPath("buyerIDSubType"), String.class, getBuyerIDSubType(), this);
		processor.processBasic(path.newSubPath("buyerCountryOfBranch"), String.class, getBuyerCountryOfBranch(), this);
		processor.processBasic(path.newSubPath("buyerFirstName"), String.class, getBuyerFirstName(), this);
		processor.processBasic(path.newSubPath("buyerSurname"), String.class, getBuyerSurname(), this);
		processor.processBasic(path.newSubPath("buyerDOB"), String.class, getBuyerDOB(), this);
		processor.processBasic(path.newSubPath("buyerDecisionMakerID"), String.class, getBuyerDecisionMakerID(), this);
		processor.processBasic(path.newSubPath("buyerDecisionMakerIDType"), String.class, getBuyerDecisionMakerIDType(), this);
		processor.processBasic(path.newSubPath("buyerDecisionMakerIDSubType"), String.class, getBuyerDecisionMakerIDSubType(), this);
		processor.processBasic(path.newSubPath("buyerDecisionMakerFirstName"), String.class, getBuyerDecisionMakerFirstName(), this);
		processor.processBasic(path.newSubPath("buyerDecisionMakerSurname"), String.class, getBuyerDecisionMakerSurname(), this);
		processor.processBasic(path.newSubPath("buyerDecisionMakerDOB"), String.class, getBuyerDecisionMakerDOB(), this);
		processor.processBasic(path.newSubPath("sellerID"), String.class, getSellerID(), this);
		processor.processBasic(path.newSubPath("sellerIDType"), String.class, getSellerIDType(), this);
		processor.processBasic(path.newSubPath("sellerIDSubType"), String.class, getSellerIDSubType(), this);
		processor.processBasic(path.newSubPath("sellerCountryOfBranch"), String.class, getSellerCountryOfBranch(), this);
		processor.processBasic(path.newSubPath("sellerFirstName"), String.class, getSellerFirstName(), this);
		processor.processBasic(path.newSubPath("sellerSurname"), String.class, getSellerSurname(), this);
		processor.processBasic(path.newSubPath("sellerDOB"), String.class, getSellerDOB(), this);
		processor.processBasic(path.newSubPath("sellerDecisionMakerID"), String.class, getSellerDecisionMakerID(), this);
		processor.processBasic(path.newSubPath("sellerDecisionMakerIDType"), String.class, getSellerDecisionMakerIDType(), this);
		processor.processBasic(path.newSubPath("sellerDecisionMakerIDSubType"), String.class, getSellerDecisionMakerIDSubType(), this);
		processor.processBasic(path.newSubPath("sellerDecisionMakerFirstName"), String.class, getSellerDecisionMakerFirstName(), this);
		processor.processBasic(path.newSubPath("sellerDecisionMakerSurname"), String.class, getSellerDecisionMakerSurname(), this);
		processor.processBasic(path.newSubPath("sellerDecisionMakerDOB"), String.class, getSellerDecisionMakerDOB(), this);
		processor.processBasic(path.newSubPath("orderTransmissionIndicator"), Boolean.class, getOrderTransmissionIndicator(), this);
		processor.processBasic(path.newSubPath("buyerTransmitterID"), String.class, getBuyerTransmitterID(), this);
		processor.processBasic(path.newSubPath("sellerTransmitterID"), String.class, getSellerTransmitterID(), this);
		processor.processBasic(path.newSubPath("tradingDateTime"), ZonedDateTime.class, getTradingDateTime(), this);
		processor.processBasic(path.newSubPath("tradingCapacity"), TradingCapacityEnum.class, getTradingCapacity(), this);
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processor.processBasic(path.newSubPath("quantityType"), QuantityTypeEnum.class, getQuantityType(), this);
		processor.processBasic(path.newSubPath("quantityCurrency"), String.class, getQuantityCurrency(), this);
		processor.processBasic(path.newSubPath("derivativeNotionalChange"), DerivativeNotionalChangeEnum.class, getDerivativeNotionalChange(), this);
		processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
		processor.processBasic(path.newSubPath("priceType"), PriceTypeEnum.class, getPriceType(), this);
		processor.processBasic(path.newSubPath("priceCurrency"), String.class, getPriceCurrency(), this);
		processor.processBasic(path.newSubPath("netAmount"), BigDecimal.class, getNetAmount(), this);
		processor.processBasic(path.newSubPath("venue"), String.class, getVenue(), this);
		processor.processBasic(path.newSubPath("countryOfBranch"), String.class, getCountryOfBranch(), this);
		processor.processBasic(path.newSubPath("upFrontPayment"), BigDecimal.class, getUpFrontPayment(), this);
		processor.processBasic(path.newSubPath("upFrontPaymentCurrency"), String.class, getUpFrontPaymentCurrency(), this);
		processor.processBasic(path.newSubPath("complexTradeComponentID"), String.class, getComplexTradeComponentID(), this);
		processor.processBasic(path.newSubPath("instrumentID"), String.class, getInstrumentID(), this);
		processor.processBasic(path.newSubPath("instrumentIDType"), InstrumentIdTypeEnum.class, getInstrumentIDType(), this);
		processor.processBasic(path.newSubPath("instrumentName"), String.class, getInstrumentName(), this);
		processor.processBasic(path.newSubPath("instrumentClassification"), String.class, getInstrumentClassification(), this);
		processor.processBasic(path.newSubPath("notionalCurrency1"), String.class, getNotionalCurrency1(), this);
		processor.processBasic(path.newSubPath("notionalCurrency2Type"), NotionalCurrency2TypeEnum.class, getNotionalCurrency2Type(), this);
		processor.processBasic(path.newSubPath("notionalCurrency2"), String.class, getNotionalCurrency2(), this);
		processor.processBasic(path.newSubPath("priceMultiplier"), BigDecimal.class, getPriceMultiplier(), this);
		processor.processBasic(path.newSubPath("uvInstrumentClassification"), UVInstrumentClassificationEnum.class, getUvInstrumentClassification(), this);
		processor.processBasic(path.newSubPath("underlyingInstrumentID"), String.class, getUnderlyingInstrumentID(), this);
		processor.processBasic(path.newSubPath("uvIndexClassification"), String.class, getUvIndexClassification(), this);
		processor.processBasic(path.newSubPath("underlyingIndexID"), String.class, getUnderlyingIndexID(), this);
		processor.processBasic(path.newSubPath("underlyingIndexName"), String.class, getUnderlyingIndexName(), this);
		processor.processBasic(path.newSubPath("underlyingIndexTerm"), String.class, getUnderlyingIndexTerm(), this);
		processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
		processor.processBasic(path.newSubPath("strikePriceType"), PriceTypeEnum.class, getStrikePriceType(), this);
		processor.processBasic(path.newSubPath("strikePriceCurrency"), String.class, getStrikePriceCurrency(), this);
		processor.processBasic(path.newSubPath("optionStyle"), OptionStyleEnum.class, getOptionStyle(), this);
		processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
		processor.processBasic(path.newSubPath("investmentDecisionID"), String.class, getInvestmentDecisionID(), this);
		processor.processBasic(path.newSubPath("investmentDecisionIDType"), InvestmnentDecisionIdTypeEnum.class, getInvestmentDecisionIDType(), this);
		processor.processBasic(path.newSubPath("investmentDecisionIDSubType"), DecisionMakerIdSubTypeEnum.class, getInvestmentDecisionIDSubType(), this);
		processor.processBasic(path.newSubPath("investmentDecisionCountryOfBranch"), String.class, getInvestmentDecisionCountryOfBranch(), this);
		processor.processBasic(path.newSubPath("firmExecutionID"), String.class, getFirmExecutionID(), this);
		processor.processBasic(path.newSubPath("firmExecutionIDType"), FirmExecutionIdTypeEnum.class, getFirmExecutionIDType(), this);
		processor.processBasic(path.newSubPath("firmExecutionIDSubType"), DecisionMakerIdSubTypeEnum.class, getFirmExecutionIDSubType(), this);
		processor.processBasic(path.newSubPath("firmExecutionCountryOfBranch"), String.class, getFirmExecutionCountryOfBranch(), this);
		processor.processBasic(path.newSubPath("waiverIndicator"), WaiverIndicatorEnum.class, getWaiverIndicator(), this);
		processor.processBasic(path.newSubPath("shortSellingIndicator"), ShortSellingIndicatorEnum.class, getShortSellingIndicator(), this);
		processor.processBasic(path.newSubPath("otcPostTradeIndicator"), String.class, getOtcPostTradeIndicator(), this);
		processor.processBasic(path.newSubPath("commodityDerivativeIndicator"), Boolean.class, getCommodityDerivativeIndicator(), this);
		processor.processBasic(path.newSubPath("sftIndicator"), Boolean.class, getSftIndicator(), this);
		processor.processBasic(path.newSubPath("dataCategory"), String.class, getDataCategory(), this);
		processor.processBasic(path.newSubPath("internalClientIdentification"), String.class, getInternalClientIdentification(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MIFIRUnavistaCSVDocumentBuilder extends MIFIRUnavistaCSVDocument, RosettaModelObjectBuilder {
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setReportStatus(ReportStatusEnum reportStatus);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setTransactionReferenceNumber(String transactionReferenceNumber);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setVenueTransactionID(String venueTransactionID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setExecutingEntityID(String executingEntityID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSubmittingEntityID(String submittingEntityID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentFirmIndicator(Boolean investmentFirmIndicator);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerID(String buyerID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerIDType(String buyerIDType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerIDSubType(String buyerIDSubType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerCountryOfBranch(String buyerCountryOfBranch);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerFirstName(String buyerFirstName);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerSurname(String buyerSurname);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDOB(String buyerDOB);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerID(String buyerDecisionMakerID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerIDType(String buyerDecisionMakerIDType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerIDSubType(String buyerDecisionMakerIDSubType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerFirstName(String buyerDecisionMakerFirstName);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerSurname(String buyerDecisionMakerSurname);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerDOB(String buyerDecisionMakerDOB);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerID(String sellerID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerIDType(String sellerIDType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerIDSubType(String sellerIDSubType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerCountryOfBranch(String sellerCountryOfBranch);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerFirstName(String sellerFirstName);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerSurname(String sellerSurname);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDOB(String sellerDOB);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerID(String sellerDecisionMakerID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerIDType(String sellerDecisionMakerIDType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerIDSubType(String sellerDecisionMakerIDSubType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerFirstName(String sellerDecisionMakerFirstName);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerSurname(String sellerDecisionMakerSurname);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerDOB(String sellerDecisionMakerDOB);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setOrderTransmissionIndicator(Boolean orderTransmissionIndicator);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerTransmitterID(String buyerTransmitterID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerTransmitterID(String sellerTransmitterID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setTradingDateTime(ZonedDateTime tradingDateTime);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setTradingCapacity(TradingCapacityEnum tradingCapacity);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setQuantity(BigDecimal quantity);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setQuantityType(QuantityTypeEnum quantityType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setQuantityCurrency(String quantityCurrency);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setDerivativeNotionalChange(DerivativeNotionalChangeEnum derivativeNotionalChange);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setPrice(BigDecimal price);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setPriceType(PriceTypeEnum priceType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setPriceCurrency(String priceCurrency);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setNetAmount(BigDecimal netAmount);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setVenue(String venue);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setCountryOfBranch(String countryOfBranch);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUpFrontPayment(BigDecimal upFrontPayment);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUpFrontPaymentCurrency(String upFrontPaymentCurrency);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setComplexTradeComponentID(String complexTradeComponentID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInstrumentID(String instrumentID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInstrumentIDType(InstrumentIdTypeEnum instrumentIDType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInstrumentName(String instrumentName);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInstrumentClassification(String instrumentClassification);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setNotionalCurrency1(String notionalCurrency1);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setNotionalCurrency2Type(NotionalCurrency2TypeEnum notionalCurrency2Type);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setNotionalCurrency2(String notionalCurrency2);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setPriceMultiplier(BigDecimal priceMultiplier);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUvInstrumentClassification(UVInstrumentClassificationEnum uvInstrumentClassification);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUnderlyingInstrumentID(String underlyingInstrumentID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUvIndexClassification(String uvIndexClassification);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUnderlyingIndexID(String underlyingIndexID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUnderlyingIndexName(String underlyingIndexName);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUnderlyingIndexTerm(String underlyingIndexTerm);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setOptionType(OptionTypeEnum optionType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setStrikePrice(BigDecimal strikePrice);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setStrikePriceType(PriceTypeEnum strikePriceType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setStrikePriceCurrency(String strikePriceCurrency);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setOptionStyle(OptionStyleEnum optionStyle);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setMaturityDate(Date maturityDate);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setExpiryDate(Date expiryDate);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentDecisionID(String investmentDecisionID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentDecisionIDType(InvestmnentDecisionIdTypeEnum investmentDecisionIDType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentDecisionIDSubType(DecisionMakerIdSubTypeEnum investmentDecisionIDSubType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentDecisionCountryOfBranch(String investmentDecisionCountryOfBranch);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setFirmExecutionID(String firmExecutionID);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setFirmExecutionIDType(FirmExecutionIdTypeEnum firmExecutionIDType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setFirmExecutionIDSubType(DecisionMakerIdSubTypeEnum firmExecutionIDSubType);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setFirmExecutionCountryOfBranch(String firmExecutionCountryOfBranch);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setWaiverIndicator(WaiverIndicatorEnum waiverIndicator);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setShortSellingIndicator(ShortSellingIndicatorEnum shortSellingIndicator);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setOtcPostTradeIndicator(String otcPostTradeIndicator);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setCommodityDerivativeIndicator(Boolean commodityDerivativeIndicator);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSftIndicator(Boolean sftIndicator);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setDataCategory(String dataCategory);
		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInternalClientIdentification(String internalClientIdentification);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("reportStatus"), ReportStatusEnum.class, getReportStatus(), this);
			processor.processBasic(path.newSubPath("transactionReferenceNumber"), String.class, getTransactionReferenceNumber(), this);
			processor.processBasic(path.newSubPath("venueTransactionID"), String.class, getVenueTransactionID(), this);
			processor.processBasic(path.newSubPath("executingEntityID"), String.class, getExecutingEntityID(), this);
			processor.processBasic(path.newSubPath("submittingEntityID"), String.class, getSubmittingEntityID(), this);
			processor.processBasic(path.newSubPath("investmentFirmIndicator"), Boolean.class, getInvestmentFirmIndicator(), this);
			processor.processBasic(path.newSubPath("buyerID"), String.class, getBuyerID(), this);
			processor.processBasic(path.newSubPath("buyerIDType"), String.class, getBuyerIDType(), this);
			processor.processBasic(path.newSubPath("buyerIDSubType"), String.class, getBuyerIDSubType(), this);
			processor.processBasic(path.newSubPath("buyerCountryOfBranch"), String.class, getBuyerCountryOfBranch(), this);
			processor.processBasic(path.newSubPath("buyerFirstName"), String.class, getBuyerFirstName(), this);
			processor.processBasic(path.newSubPath("buyerSurname"), String.class, getBuyerSurname(), this);
			processor.processBasic(path.newSubPath("buyerDOB"), String.class, getBuyerDOB(), this);
			processor.processBasic(path.newSubPath("buyerDecisionMakerID"), String.class, getBuyerDecisionMakerID(), this);
			processor.processBasic(path.newSubPath("buyerDecisionMakerIDType"), String.class, getBuyerDecisionMakerIDType(), this);
			processor.processBasic(path.newSubPath("buyerDecisionMakerIDSubType"), String.class, getBuyerDecisionMakerIDSubType(), this);
			processor.processBasic(path.newSubPath("buyerDecisionMakerFirstName"), String.class, getBuyerDecisionMakerFirstName(), this);
			processor.processBasic(path.newSubPath("buyerDecisionMakerSurname"), String.class, getBuyerDecisionMakerSurname(), this);
			processor.processBasic(path.newSubPath("buyerDecisionMakerDOB"), String.class, getBuyerDecisionMakerDOB(), this);
			processor.processBasic(path.newSubPath("sellerID"), String.class, getSellerID(), this);
			processor.processBasic(path.newSubPath("sellerIDType"), String.class, getSellerIDType(), this);
			processor.processBasic(path.newSubPath("sellerIDSubType"), String.class, getSellerIDSubType(), this);
			processor.processBasic(path.newSubPath("sellerCountryOfBranch"), String.class, getSellerCountryOfBranch(), this);
			processor.processBasic(path.newSubPath("sellerFirstName"), String.class, getSellerFirstName(), this);
			processor.processBasic(path.newSubPath("sellerSurname"), String.class, getSellerSurname(), this);
			processor.processBasic(path.newSubPath("sellerDOB"), String.class, getSellerDOB(), this);
			processor.processBasic(path.newSubPath("sellerDecisionMakerID"), String.class, getSellerDecisionMakerID(), this);
			processor.processBasic(path.newSubPath("sellerDecisionMakerIDType"), String.class, getSellerDecisionMakerIDType(), this);
			processor.processBasic(path.newSubPath("sellerDecisionMakerIDSubType"), String.class, getSellerDecisionMakerIDSubType(), this);
			processor.processBasic(path.newSubPath("sellerDecisionMakerFirstName"), String.class, getSellerDecisionMakerFirstName(), this);
			processor.processBasic(path.newSubPath("sellerDecisionMakerSurname"), String.class, getSellerDecisionMakerSurname(), this);
			processor.processBasic(path.newSubPath("sellerDecisionMakerDOB"), String.class, getSellerDecisionMakerDOB(), this);
			processor.processBasic(path.newSubPath("orderTransmissionIndicator"), Boolean.class, getOrderTransmissionIndicator(), this);
			processor.processBasic(path.newSubPath("buyerTransmitterID"), String.class, getBuyerTransmitterID(), this);
			processor.processBasic(path.newSubPath("sellerTransmitterID"), String.class, getSellerTransmitterID(), this);
			processor.processBasic(path.newSubPath("tradingDateTime"), ZonedDateTime.class, getTradingDateTime(), this);
			processor.processBasic(path.newSubPath("tradingCapacity"), TradingCapacityEnum.class, getTradingCapacity(), this);
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processor.processBasic(path.newSubPath("quantityType"), QuantityTypeEnum.class, getQuantityType(), this);
			processor.processBasic(path.newSubPath("quantityCurrency"), String.class, getQuantityCurrency(), this);
			processor.processBasic(path.newSubPath("derivativeNotionalChange"), DerivativeNotionalChangeEnum.class, getDerivativeNotionalChange(), this);
			processor.processBasic(path.newSubPath("price"), BigDecimal.class, getPrice(), this);
			processor.processBasic(path.newSubPath("priceType"), PriceTypeEnum.class, getPriceType(), this);
			processor.processBasic(path.newSubPath("priceCurrency"), String.class, getPriceCurrency(), this);
			processor.processBasic(path.newSubPath("netAmount"), BigDecimal.class, getNetAmount(), this);
			processor.processBasic(path.newSubPath("venue"), String.class, getVenue(), this);
			processor.processBasic(path.newSubPath("countryOfBranch"), String.class, getCountryOfBranch(), this);
			processor.processBasic(path.newSubPath("upFrontPayment"), BigDecimal.class, getUpFrontPayment(), this);
			processor.processBasic(path.newSubPath("upFrontPaymentCurrency"), String.class, getUpFrontPaymentCurrency(), this);
			processor.processBasic(path.newSubPath("complexTradeComponentID"), String.class, getComplexTradeComponentID(), this);
			processor.processBasic(path.newSubPath("instrumentID"), String.class, getInstrumentID(), this);
			processor.processBasic(path.newSubPath("instrumentIDType"), InstrumentIdTypeEnum.class, getInstrumentIDType(), this);
			processor.processBasic(path.newSubPath("instrumentName"), String.class, getInstrumentName(), this);
			processor.processBasic(path.newSubPath("instrumentClassification"), String.class, getInstrumentClassification(), this);
			processor.processBasic(path.newSubPath("notionalCurrency1"), String.class, getNotionalCurrency1(), this);
			processor.processBasic(path.newSubPath("notionalCurrency2Type"), NotionalCurrency2TypeEnum.class, getNotionalCurrency2Type(), this);
			processor.processBasic(path.newSubPath("notionalCurrency2"), String.class, getNotionalCurrency2(), this);
			processor.processBasic(path.newSubPath("priceMultiplier"), BigDecimal.class, getPriceMultiplier(), this);
			processor.processBasic(path.newSubPath("uvInstrumentClassification"), UVInstrumentClassificationEnum.class, getUvInstrumentClassification(), this);
			processor.processBasic(path.newSubPath("underlyingInstrumentID"), String.class, getUnderlyingInstrumentID(), this);
			processor.processBasic(path.newSubPath("uvIndexClassification"), String.class, getUvIndexClassification(), this);
			processor.processBasic(path.newSubPath("underlyingIndexID"), String.class, getUnderlyingIndexID(), this);
			processor.processBasic(path.newSubPath("underlyingIndexName"), String.class, getUnderlyingIndexName(), this);
			processor.processBasic(path.newSubPath("underlyingIndexTerm"), String.class, getUnderlyingIndexTerm(), this);
			processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
			processor.processBasic(path.newSubPath("strikePriceType"), PriceTypeEnum.class, getStrikePriceType(), this);
			processor.processBasic(path.newSubPath("strikePriceCurrency"), String.class, getStrikePriceCurrency(), this);
			processor.processBasic(path.newSubPath("optionStyle"), OptionStyleEnum.class, getOptionStyle(), this);
			processor.processBasic(path.newSubPath("maturityDate"), Date.class, getMaturityDate(), this);
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
			processor.processBasic(path.newSubPath("investmentDecisionID"), String.class, getInvestmentDecisionID(), this);
			processor.processBasic(path.newSubPath("investmentDecisionIDType"), InvestmnentDecisionIdTypeEnum.class, getInvestmentDecisionIDType(), this);
			processor.processBasic(path.newSubPath("investmentDecisionIDSubType"), DecisionMakerIdSubTypeEnum.class, getInvestmentDecisionIDSubType(), this);
			processor.processBasic(path.newSubPath("investmentDecisionCountryOfBranch"), String.class, getInvestmentDecisionCountryOfBranch(), this);
			processor.processBasic(path.newSubPath("firmExecutionID"), String.class, getFirmExecutionID(), this);
			processor.processBasic(path.newSubPath("firmExecutionIDType"), FirmExecutionIdTypeEnum.class, getFirmExecutionIDType(), this);
			processor.processBasic(path.newSubPath("firmExecutionIDSubType"), DecisionMakerIdSubTypeEnum.class, getFirmExecutionIDSubType(), this);
			processor.processBasic(path.newSubPath("firmExecutionCountryOfBranch"), String.class, getFirmExecutionCountryOfBranch(), this);
			processor.processBasic(path.newSubPath("waiverIndicator"), WaiverIndicatorEnum.class, getWaiverIndicator(), this);
			processor.processBasic(path.newSubPath("shortSellingIndicator"), ShortSellingIndicatorEnum.class, getShortSellingIndicator(), this);
			processor.processBasic(path.newSubPath("otcPostTradeIndicator"), String.class, getOtcPostTradeIndicator(), this);
			processor.processBasic(path.newSubPath("commodityDerivativeIndicator"), Boolean.class, getCommodityDerivativeIndicator(), this);
			processor.processBasic(path.newSubPath("sftIndicator"), Boolean.class, getSftIndicator(), this);
			processor.processBasic(path.newSubPath("dataCategory"), String.class, getDataCategory(), this);
			processor.processBasic(path.newSubPath("internalClientIdentification"), String.class, getInternalClientIdentification(), this);
		}
		

		MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder prune();
	}

	/*********************** Immutable Implementation of MIFIRUnavistaCSVDocument  ***********************/
	class MIFIRUnavistaCSVDocumentImpl implements MIFIRUnavistaCSVDocument {
		private final ReportStatusEnum reportStatus;
		private final String transactionReferenceNumber;
		private final String venueTransactionID;
		private final String executingEntityID;
		private final String submittingEntityID;
		private final Boolean investmentFirmIndicator;
		private final String buyerID;
		private final String buyerIDType;
		private final String buyerIDSubType;
		private final String buyerCountryOfBranch;
		private final String buyerFirstName;
		private final String buyerSurname;
		private final String buyerDOB;
		private final String buyerDecisionMakerID;
		private final String buyerDecisionMakerIDType;
		private final String buyerDecisionMakerIDSubType;
		private final String buyerDecisionMakerFirstName;
		private final String buyerDecisionMakerSurname;
		private final String buyerDecisionMakerDOB;
		private final String sellerID;
		private final String sellerIDType;
		private final String sellerIDSubType;
		private final String sellerCountryOfBranch;
		private final String sellerFirstName;
		private final String sellerSurname;
		private final String sellerDOB;
		private final String sellerDecisionMakerID;
		private final String sellerDecisionMakerIDType;
		private final String sellerDecisionMakerIDSubType;
		private final String sellerDecisionMakerFirstName;
		private final String sellerDecisionMakerSurname;
		private final String sellerDecisionMakerDOB;
		private final Boolean orderTransmissionIndicator;
		private final String buyerTransmitterID;
		private final String sellerTransmitterID;
		private final ZonedDateTime tradingDateTime;
		private final TradingCapacityEnum tradingCapacity;
		private final BigDecimal quantity;
		private final QuantityTypeEnum quantityType;
		private final String quantityCurrency;
		private final DerivativeNotionalChangeEnum derivativeNotionalChange;
		private final BigDecimal price;
		private final PriceTypeEnum priceType;
		private final String priceCurrency;
		private final BigDecimal netAmount;
		private final String venue;
		private final String countryOfBranch;
		private final BigDecimal upFrontPayment;
		private final String upFrontPaymentCurrency;
		private final String complexTradeComponentID;
		private final String instrumentID;
		private final InstrumentIdTypeEnum instrumentIDType;
		private final String instrumentName;
		private final String instrumentClassification;
		private final String notionalCurrency1;
		private final NotionalCurrency2TypeEnum notionalCurrency2Type;
		private final String notionalCurrency2;
		private final BigDecimal priceMultiplier;
		private final UVInstrumentClassificationEnum uvInstrumentClassification;
		private final String underlyingInstrumentID;
		private final String uvIndexClassification;
		private final String underlyingIndexID;
		private final String underlyingIndexName;
		private final String underlyingIndexTerm;
		private final OptionTypeEnum optionType;
		private final BigDecimal strikePrice;
		private final PriceTypeEnum strikePriceType;
		private final String strikePriceCurrency;
		private final OptionStyleEnum optionStyle;
		private final Date maturityDate;
		private final Date expiryDate;
		private final DeliveryTypeEnum deliveryType;
		private final String investmentDecisionID;
		private final InvestmnentDecisionIdTypeEnum investmentDecisionIDType;
		private final DecisionMakerIdSubTypeEnum investmentDecisionIDSubType;
		private final String investmentDecisionCountryOfBranch;
		private final String firmExecutionID;
		private final FirmExecutionIdTypeEnum firmExecutionIDType;
		private final DecisionMakerIdSubTypeEnum firmExecutionIDSubType;
		private final String firmExecutionCountryOfBranch;
		private final WaiverIndicatorEnum waiverIndicator;
		private final ShortSellingIndicatorEnum shortSellingIndicator;
		private final String otcPostTradeIndicator;
		private final Boolean commodityDerivativeIndicator;
		private final Boolean sftIndicator;
		private final String dataCategory;
		private final String internalClientIdentification;
		
		protected MIFIRUnavistaCSVDocumentImpl(MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder builder) {
			this.reportStatus = builder.getReportStatus();
			this.transactionReferenceNumber = builder.getTransactionReferenceNumber();
			this.venueTransactionID = builder.getVenueTransactionID();
			this.executingEntityID = builder.getExecutingEntityID();
			this.submittingEntityID = builder.getSubmittingEntityID();
			this.investmentFirmIndicator = builder.getInvestmentFirmIndicator();
			this.buyerID = builder.getBuyerID();
			this.buyerIDType = builder.getBuyerIDType();
			this.buyerIDSubType = builder.getBuyerIDSubType();
			this.buyerCountryOfBranch = builder.getBuyerCountryOfBranch();
			this.buyerFirstName = builder.getBuyerFirstName();
			this.buyerSurname = builder.getBuyerSurname();
			this.buyerDOB = builder.getBuyerDOB();
			this.buyerDecisionMakerID = builder.getBuyerDecisionMakerID();
			this.buyerDecisionMakerIDType = builder.getBuyerDecisionMakerIDType();
			this.buyerDecisionMakerIDSubType = builder.getBuyerDecisionMakerIDSubType();
			this.buyerDecisionMakerFirstName = builder.getBuyerDecisionMakerFirstName();
			this.buyerDecisionMakerSurname = builder.getBuyerDecisionMakerSurname();
			this.buyerDecisionMakerDOB = builder.getBuyerDecisionMakerDOB();
			this.sellerID = builder.getSellerID();
			this.sellerIDType = builder.getSellerIDType();
			this.sellerIDSubType = builder.getSellerIDSubType();
			this.sellerCountryOfBranch = builder.getSellerCountryOfBranch();
			this.sellerFirstName = builder.getSellerFirstName();
			this.sellerSurname = builder.getSellerSurname();
			this.sellerDOB = builder.getSellerDOB();
			this.sellerDecisionMakerID = builder.getSellerDecisionMakerID();
			this.sellerDecisionMakerIDType = builder.getSellerDecisionMakerIDType();
			this.sellerDecisionMakerIDSubType = builder.getSellerDecisionMakerIDSubType();
			this.sellerDecisionMakerFirstName = builder.getSellerDecisionMakerFirstName();
			this.sellerDecisionMakerSurname = builder.getSellerDecisionMakerSurname();
			this.sellerDecisionMakerDOB = builder.getSellerDecisionMakerDOB();
			this.orderTransmissionIndicator = builder.getOrderTransmissionIndicator();
			this.buyerTransmitterID = builder.getBuyerTransmitterID();
			this.sellerTransmitterID = builder.getSellerTransmitterID();
			this.tradingDateTime = builder.getTradingDateTime();
			this.tradingCapacity = builder.getTradingCapacity();
			this.quantity = builder.getQuantity();
			this.quantityType = builder.getQuantityType();
			this.quantityCurrency = builder.getQuantityCurrency();
			this.derivativeNotionalChange = builder.getDerivativeNotionalChange();
			this.price = builder.getPrice();
			this.priceType = builder.getPriceType();
			this.priceCurrency = builder.getPriceCurrency();
			this.netAmount = builder.getNetAmount();
			this.venue = builder.getVenue();
			this.countryOfBranch = builder.getCountryOfBranch();
			this.upFrontPayment = builder.getUpFrontPayment();
			this.upFrontPaymentCurrency = builder.getUpFrontPaymentCurrency();
			this.complexTradeComponentID = builder.getComplexTradeComponentID();
			this.instrumentID = builder.getInstrumentID();
			this.instrumentIDType = builder.getInstrumentIDType();
			this.instrumentName = builder.getInstrumentName();
			this.instrumentClassification = builder.getInstrumentClassification();
			this.notionalCurrency1 = builder.getNotionalCurrency1();
			this.notionalCurrency2Type = builder.getNotionalCurrency2Type();
			this.notionalCurrency2 = builder.getNotionalCurrency2();
			this.priceMultiplier = builder.getPriceMultiplier();
			this.uvInstrumentClassification = builder.getUvInstrumentClassification();
			this.underlyingInstrumentID = builder.getUnderlyingInstrumentID();
			this.uvIndexClassification = builder.getUvIndexClassification();
			this.underlyingIndexID = builder.getUnderlyingIndexID();
			this.underlyingIndexName = builder.getUnderlyingIndexName();
			this.underlyingIndexTerm = builder.getUnderlyingIndexTerm();
			this.optionType = builder.getOptionType();
			this.strikePrice = builder.getStrikePrice();
			this.strikePriceType = builder.getStrikePriceType();
			this.strikePriceCurrency = builder.getStrikePriceCurrency();
			this.optionStyle = builder.getOptionStyle();
			this.maturityDate = builder.getMaturityDate();
			this.expiryDate = builder.getExpiryDate();
			this.deliveryType = builder.getDeliveryType();
			this.investmentDecisionID = builder.getInvestmentDecisionID();
			this.investmentDecisionIDType = builder.getInvestmentDecisionIDType();
			this.investmentDecisionIDSubType = builder.getInvestmentDecisionIDSubType();
			this.investmentDecisionCountryOfBranch = builder.getInvestmentDecisionCountryOfBranch();
			this.firmExecutionID = builder.getFirmExecutionID();
			this.firmExecutionIDType = builder.getFirmExecutionIDType();
			this.firmExecutionIDSubType = builder.getFirmExecutionIDSubType();
			this.firmExecutionCountryOfBranch = builder.getFirmExecutionCountryOfBranch();
			this.waiverIndicator = builder.getWaiverIndicator();
			this.shortSellingIndicator = builder.getShortSellingIndicator();
			this.otcPostTradeIndicator = builder.getOtcPostTradeIndicator();
			this.commodityDerivativeIndicator = builder.getCommodityDerivativeIndicator();
			this.sftIndicator = builder.getSftIndicator();
			this.dataCategory = builder.getDataCategory();
			this.internalClientIdentification = builder.getInternalClientIdentification();
		}
		
		@Override
		@RosettaAttribute("reportStatus")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportStatus")
		public ReportStatusEnum getReportStatus() {
			return reportStatus;
		}
		
		@Override
		@RosettaAttribute("transactionReferenceNumber")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("transactionReferenceNumber")
		public String getTransactionReferenceNumber() {
			return transactionReferenceNumber;
		}
		
		@Override
		@RosettaAttribute("venueTransactionID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("venueTransactionID")
		public String getVenueTransactionID() {
			return venueTransactionID;
		}
		
		@Override
		@RosettaAttribute("executingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executingEntityID")
		public String getExecutingEntityID() {
			return executingEntityID;
		}
		
		@Override
		@RosettaAttribute("submittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submittingEntityID")
		public String getSubmittingEntityID() {
			return submittingEntityID;
		}
		
		@Override
		@RosettaAttribute("investmentFirmIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentFirmIndicator")
		public Boolean getInvestmentFirmIndicator() {
			return investmentFirmIndicator;
		}
		
		@Override
		@RosettaAttribute("buyerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerID")
		public String getBuyerID() {
			return buyerID;
		}
		
		@Override
		@RosettaAttribute("buyerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerIDType")
		public String getBuyerIDType() {
			return buyerIDType;
		}
		
		@Override
		@RosettaAttribute("buyerIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerIDSubType")
		public String getBuyerIDSubType() {
			return buyerIDSubType;
		}
		
		@Override
		@RosettaAttribute("buyerCountryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerCountryOfBranch")
		public String getBuyerCountryOfBranch() {
			return buyerCountryOfBranch;
		}
		
		@Override
		@RosettaAttribute("buyerFirstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerFirstName")
		public String getBuyerFirstName() {
			return buyerFirstName;
		}
		
		@Override
		@RosettaAttribute("buyerSurname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerSurname")
		public String getBuyerSurname() {
			return buyerSurname;
		}
		
		@Override
		@RosettaAttribute("buyerDOB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDOB")
		public String getBuyerDOB() {
			return buyerDOB;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerID")
		public String getBuyerDecisionMakerID() {
			return buyerDecisionMakerID;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerIDType")
		public String getBuyerDecisionMakerIDType() {
			return buyerDecisionMakerIDType;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerIDSubType")
		public String getBuyerDecisionMakerIDSubType() {
			return buyerDecisionMakerIDSubType;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerFirstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerFirstName")
		public String getBuyerDecisionMakerFirstName() {
			return buyerDecisionMakerFirstName;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerSurname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerSurname")
		public String getBuyerDecisionMakerSurname() {
			return buyerDecisionMakerSurname;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerDOB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerDOB")
		public String getBuyerDecisionMakerDOB() {
			return buyerDecisionMakerDOB;
		}
		
		@Override
		@RosettaAttribute("sellerID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerID")
		public String getSellerID() {
			return sellerID;
		}
		
		@Override
		@RosettaAttribute("sellerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerIDType")
		public String getSellerIDType() {
			return sellerIDType;
		}
		
		@Override
		@RosettaAttribute("sellerIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerIDSubType")
		public String getSellerIDSubType() {
			return sellerIDSubType;
		}
		
		@Override
		@RosettaAttribute("sellerCountryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerCountryOfBranch")
		public String getSellerCountryOfBranch() {
			return sellerCountryOfBranch;
		}
		
		@Override
		@RosettaAttribute("sellerFirstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerFirstName")
		public String getSellerFirstName() {
			return sellerFirstName;
		}
		
		@Override
		@RosettaAttribute("sellerSurname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerSurname")
		public String getSellerSurname() {
			return sellerSurname;
		}
		
		@Override
		@RosettaAttribute("sellerDOB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDOB")
		public String getSellerDOB() {
			return sellerDOB;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerID")
		public String getSellerDecisionMakerID() {
			return sellerDecisionMakerID;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerIDType")
		public String getSellerDecisionMakerIDType() {
			return sellerDecisionMakerIDType;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerIDSubType")
		public String getSellerDecisionMakerIDSubType() {
			return sellerDecisionMakerIDSubType;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerFirstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerFirstName")
		public String getSellerDecisionMakerFirstName() {
			return sellerDecisionMakerFirstName;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerSurname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerSurname")
		public String getSellerDecisionMakerSurname() {
			return sellerDecisionMakerSurname;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerDOB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerDOB")
		public String getSellerDecisionMakerDOB() {
			return sellerDecisionMakerDOB;
		}
		
		@Override
		@RosettaAttribute("orderTransmissionIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("orderTransmissionIndicator")
		public Boolean getOrderTransmissionIndicator() {
			return orderTransmissionIndicator;
		}
		
		@Override
		@RosettaAttribute("buyerTransmitterID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerTransmitterID")
		public String getBuyerTransmitterID() {
			return buyerTransmitterID;
		}
		
		@Override
		@RosettaAttribute("sellerTransmitterID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerTransmitterID")
		public String getSellerTransmitterID() {
			return sellerTransmitterID;
		}
		
		@Override
		@RosettaAttribute("tradingDateTime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradingDateTime")
		public ZonedDateTime getTradingDateTime() {
			return tradingDateTime;
		}
		
		@Override
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradingCapacity")
		public TradingCapacityEnum getTradingCapacity() {
			return tradingCapacity;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityType")
		public QuantityTypeEnum getQuantityType() {
			return quantityType;
		}
		
		@Override
		@RosettaAttribute("quantityCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityCurrency")
		public String getQuantityCurrency() {
			return quantityCurrency;
		}
		
		@Override
		@RosettaAttribute("derivativeNotionalChange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("derivativeNotionalChange")
		public DerivativeNotionalChangeEnum getDerivativeNotionalChange() {
			return derivativeNotionalChange;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("priceType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceType")
		public PriceTypeEnum getPriceType() {
			return priceType;
		}
		
		@Override
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceCurrency")
		public String getPriceCurrency() {
			return priceCurrency;
		}
		
		@Override
		@RosettaAttribute("netAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("netAmount")
		public BigDecimal getNetAmount() {
			return netAmount;
		}
		
		@Override
		@RosettaAttribute("venue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("venue")
		public String getVenue() {
			return venue;
		}
		
		@Override
		@RosettaAttribute("countryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("countryOfBranch")
		public String getCountryOfBranch() {
			return countryOfBranch;
		}
		
		@Override
		@RosettaAttribute("upFrontPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upFrontPayment")
		public BigDecimal getUpFrontPayment() {
			return upFrontPayment;
		}
		
		@Override
		@RosettaAttribute("upFrontPaymentCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upFrontPaymentCurrency")
		public String getUpFrontPaymentCurrency() {
			return upFrontPaymentCurrency;
		}
		
		@Override
		@RosettaAttribute("complexTradeComponentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("complexTradeComponentID")
		public String getComplexTradeComponentID() {
			return complexTradeComponentID;
		}
		
		@Override
		@RosettaAttribute("instrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentID")
		public String getInstrumentID() {
			return instrumentID;
		}
		
		@Override
		@RosettaAttribute("instrumentIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentIDType")
		public InstrumentIdTypeEnum getInstrumentIDType() {
			return instrumentIDType;
		}
		
		@Override
		@RosettaAttribute("instrumentName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentName")
		public String getInstrumentName() {
			return instrumentName;
		}
		
		@Override
		@RosettaAttribute("instrumentClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentClassification")
		public String getInstrumentClassification() {
			return instrumentClassification;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalCurrency1")
		public String getNotionalCurrency1() {
			return notionalCurrency1;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency2Type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalCurrency2Type")
		public NotionalCurrency2TypeEnum getNotionalCurrency2Type() {
			return notionalCurrency2Type;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalCurrency2")
		public String getNotionalCurrency2() {
			return notionalCurrency2;
		}
		
		@Override
		@RosettaAttribute("priceMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceMultiplier")
		public BigDecimal getPriceMultiplier() {
			return priceMultiplier;
		}
		
		@Override
		@RosettaAttribute("uvInstrumentClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uvInstrumentClassification")
		public UVInstrumentClassificationEnum getUvInstrumentClassification() {
			return uvInstrumentClassification;
		}
		
		@Override
		@RosettaAttribute("underlyingInstrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingInstrumentID")
		public String getUnderlyingInstrumentID() {
			return underlyingInstrumentID;
		}
		
		@Override
		@RosettaAttribute("uvIndexClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uvIndexClassification")
		public String getUvIndexClassification() {
			return uvIndexClassification;
		}
		
		@Override
		@RosettaAttribute("underlyingIndexID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIndexID")
		public String getUnderlyingIndexID() {
			return underlyingIndexID;
		}
		
		@Override
		@RosettaAttribute("underlyingIndexName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIndexName")
		public String getUnderlyingIndexName() {
			return underlyingIndexName;
		}
		
		@Override
		@RosettaAttribute("underlyingIndexTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIndexTerm")
		public String getUnderlyingIndexTerm() {
			return underlyingIndexTerm;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePrice")
		public BigDecimal getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("strikePriceType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceType")
		public PriceTypeEnum getStrikePriceType() {
			return strikePriceType;
		}
		
		@Override
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceCurrency")
		public String getStrikePriceCurrency() {
			return strikePriceCurrency;
		}
		
		@Override
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionStyle")
		public OptionStyleEnum getOptionStyle() {
			return optionStyle;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public DeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("investmentDecisionID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentDecisionID")
		public String getInvestmentDecisionID() {
			return investmentDecisionID;
		}
		
		@Override
		@RosettaAttribute("investmentDecisionIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentDecisionIDType")
		public InvestmnentDecisionIdTypeEnum getInvestmentDecisionIDType() {
			return investmentDecisionIDType;
		}
		
		@Override
		@RosettaAttribute("investmentDecisionIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentDecisionIDSubType")
		public DecisionMakerIdSubTypeEnum getInvestmentDecisionIDSubType() {
			return investmentDecisionIDSubType;
		}
		
		@Override
		@RosettaAttribute("investmentDecisionCountryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentDecisionCountryOfBranch")
		public String getInvestmentDecisionCountryOfBranch() {
			return investmentDecisionCountryOfBranch;
		}
		
		@Override
		@RosettaAttribute("firmExecutionID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("firmExecutionID")
		public String getFirmExecutionID() {
			return firmExecutionID;
		}
		
		@Override
		@RosettaAttribute("firmExecutionIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firmExecutionIDType")
		public FirmExecutionIdTypeEnum getFirmExecutionIDType() {
			return firmExecutionIDType;
		}
		
		@Override
		@RosettaAttribute("firmExecutionIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firmExecutionIDSubType")
		public DecisionMakerIdSubTypeEnum getFirmExecutionIDSubType() {
			return firmExecutionIDSubType;
		}
		
		@Override
		@RosettaAttribute("firmExecutionCountryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firmExecutionCountryOfBranch")
		public String getFirmExecutionCountryOfBranch() {
			return firmExecutionCountryOfBranch;
		}
		
		@Override
		@RosettaAttribute("waiverIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("waiverIndicator")
		public WaiverIndicatorEnum getWaiverIndicator() {
			return waiverIndicator;
		}
		
		@Override
		@RosettaAttribute("shortSellingIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shortSellingIndicator")
		public ShortSellingIndicatorEnum getShortSellingIndicator() {
			return shortSellingIndicator;
		}
		
		@Override
		@RosettaAttribute("otcPostTradeIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otcPostTradeIndicator")
		public String getOtcPostTradeIndicator() {
			return otcPostTradeIndicator;
		}
		
		@Override
		@RosettaAttribute("commodityDerivativeIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityDerivativeIndicator")
		public Boolean getCommodityDerivativeIndicator() {
			return commodityDerivativeIndicator;
		}
		
		@Override
		@RosettaAttribute("sftIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sftIndicator")
		public Boolean getSftIndicator() {
			return sftIndicator;
		}
		
		@Override
		@RosettaAttribute("dataCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dataCategory")
		public String getDataCategory() {
			return dataCategory;
		}
		
		@Override
		@RosettaAttribute("internalClientIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("internalClientIdentification")
		public String getInternalClientIdentification() {
			return internalClientIdentification;
		}
		
		@Override
		public MIFIRUnavistaCSVDocument build() {
			return this;
		}
		
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder toBuilder() {
			MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder builder) {
			ofNullable(getReportStatus()).ifPresent(builder::setReportStatus);
			ofNullable(getTransactionReferenceNumber()).ifPresent(builder::setTransactionReferenceNumber);
			ofNullable(getVenueTransactionID()).ifPresent(builder::setVenueTransactionID);
			ofNullable(getExecutingEntityID()).ifPresent(builder::setExecutingEntityID);
			ofNullable(getSubmittingEntityID()).ifPresent(builder::setSubmittingEntityID);
			ofNullable(getInvestmentFirmIndicator()).ifPresent(builder::setInvestmentFirmIndicator);
			ofNullable(getBuyerID()).ifPresent(builder::setBuyerID);
			ofNullable(getBuyerIDType()).ifPresent(builder::setBuyerIDType);
			ofNullable(getBuyerIDSubType()).ifPresent(builder::setBuyerIDSubType);
			ofNullable(getBuyerCountryOfBranch()).ifPresent(builder::setBuyerCountryOfBranch);
			ofNullable(getBuyerFirstName()).ifPresent(builder::setBuyerFirstName);
			ofNullable(getBuyerSurname()).ifPresent(builder::setBuyerSurname);
			ofNullable(getBuyerDOB()).ifPresent(builder::setBuyerDOB);
			ofNullable(getBuyerDecisionMakerID()).ifPresent(builder::setBuyerDecisionMakerID);
			ofNullable(getBuyerDecisionMakerIDType()).ifPresent(builder::setBuyerDecisionMakerIDType);
			ofNullable(getBuyerDecisionMakerIDSubType()).ifPresent(builder::setBuyerDecisionMakerIDSubType);
			ofNullable(getBuyerDecisionMakerFirstName()).ifPresent(builder::setBuyerDecisionMakerFirstName);
			ofNullable(getBuyerDecisionMakerSurname()).ifPresent(builder::setBuyerDecisionMakerSurname);
			ofNullable(getBuyerDecisionMakerDOB()).ifPresent(builder::setBuyerDecisionMakerDOB);
			ofNullable(getSellerID()).ifPresent(builder::setSellerID);
			ofNullable(getSellerIDType()).ifPresent(builder::setSellerIDType);
			ofNullable(getSellerIDSubType()).ifPresent(builder::setSellerIDSubType);
			ofNullable(getSellerCountryOfBranch()).ifPresent(builder::setSellerCountryOfBranch);
			ofNullable(getSellerFirstName()).ifPresent(builder::setSellerFirstName);
			ofNullable(getSellerSurname()).ifPresent(builder::setSellerSurname);
			ofNullable(getSellerDOB()).ifPresent(builder::setSellerDOB);
			ofNullable(getSellerDecisionMakerID()).ifPresent(builder::setSellerDecisionMakerID);
			ofNullable(getSellerDecisionMakerIDType()).ifPresent(builder::setSellerDecisionMakerIDType);
			ofNullable(getSellerDecisionMakerIDSubType()).ifPresent(builder::setSellerDecisionMakerIDSubType);
			ofNullable(getSellerDecisionMakerFirstName()).ifPresent(builder::setSellerDecisionMakerFirstName);
			ofNullable(getSellerDecisionMakerSurname()).ifPresent(builder::setSellerDecisionMakerSurname);
			ofNullable(getSellerDecisionMakerDOB()).ifPresent(builder::setSellerDecisionMakerDOB);
			ofNullable(getOrderTransmissionIndicator()).ifPresent(builder::setOrderTransmissionIndicator);
			ofNullable(getBuyerTransmitterID()).ifPresent(builder::setBuyerTransmitterID);
			ofNullable(getSellerTransmitterID()).ifPresent(builder::setSellerTransmitterID);
			ofNullable(getTradingDateTime()).ifPresent(builder::setTradingDateTime);
			ofNullable(getTradingCapacity()).ifPresent(builder::setTradingCapacity);
			ofNullable(getQuantity()).ifPresent(builder::setQuantity);
			ofNullable(getQuantityType()).ifPresent(builder::setQuantityType);
			ofNullable(getQuantityCurrency()).ifPresent(builder::setQuantityCurrency);
			ofNullable(getDerivativeNotionalChange()).ifPresent(builder::setDerivativeNotionalChange);
			ofNullable(getPrice()).ifPresent(builder::setPrice);
			ofNullable(getPriceType()).ifPresent(builder::setPriceType);
			ofNullable(getPriceCurrency()).ifPresent(builder::setPriceCurrency);
			ofNullable(getNetAmount()).ifPresent(builder::setNetAmount);
			ofNullable(getVenue()).ifPresent(builder::setVenue);
			ofNullable(getCountryOfBranch()).ifPresent(builder::setCountryOfBranch);
			ofNullable(getUpFrontPayment()).ifPresent(builder::setUpFrontPayment);
			ofNullable(getUpFrontPaymentCurrency()).ifPresent(builder::setUpFrontPaymentCurrency);
			ofNullable(getComplexTradeComponentID()).ifPresent(builder::setComplexTradeComponentID);
			ofNullable(getInstrumentID()).ifPresent(builder::setInstrumentID);
			ofNullable(getInstrumentIDType()).ifPresent(builder::setInstrumentIDType);
			ofNullable(getInstrumentName()).ifPresent(builder::setInstrumentName);
			ofNullable(getInstrumentClassification()).ifPresent(builder::setInstrumentClassification);
			ofNullable(getNotionalCurrency1()).ifPresent(builder::setNotionalCurrency1);
			ofNullable(getNotionalCurrency2Type()).ifPresent(builder::setNotionalCurrency2Type);
			ofNullable(getNotionalCurrency2()).ifPresent(builder::setNotionalCurrency2);
			ofNullable(getPriceMultiplier()).ifPresent(builder::setPriceMultiplier);
			ofNullable(getUvInstrumentClassification()).ifPresent(builder::setUvInstrumentClassification);
			ofNullable(getUnderlyingInstrumentID()).ifPresent(builder::setUnderlyingInstrumentID);
			ofNullable(getUvIndexClassification()).ifPresent(builder::setUvIndexClassification);
			ofNullable(getUnderlyingIndexID()).ifPresent(builder::setUnderlyingIndexID);
			ofNullable(getUnderlyingIndexName()).ifPresent(builder::setUnderlyingIndexName);
			ofNullable(getUnderlyingIndexTerm()).ifPresent(builder::setUnderlyingIndexTerm);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getStrikePrice()).ifPresent(builder::setStrikePrice);
			ofNullable(getStrikePriceType()).ifPresent(builder::setStrikePriceType);
			ofNullable(getStrikePriceCurrency()).ifPresent(builder::setStrikePriceCurrency);
			ofNullable(getOptionStyle()).ifPresent(builder::setOptionStyle);
			ofNullable(getMaturityDate()).ifPresent(builder::setMaturityDate);
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
			ofNullable(getInvestmentDecisionID()).ifPresent(builder::setInvestmentDecisionID);
			ofNullable(getInvestmentDecisionIDType()).ifPresent(builder::setInvestmentDecisionIDType);
			ofNullable(getInvestmentDecisionIDSubType()).ifPresent(builder::setInvestmentDecisionIDSubType);
			ofNullable(getInvestmentDecisionCountryOfBranch()).ifPresent(builder::setInvestmentDecisionCountryOfBranch);
			ofNullable(getFirmExecutionID()).ifPresent(builder::setFirmExecutionID);
			ofNullable(getFirmExecutionIDType()).ifPresent(builder::setFirmExecutionIDType);
			ofNullable(getFirmExecutionIDSubType()).ifPresent(builder::setFirmExecutionIDSubType);
			ofNullable(getFirmExecutionCountryOfBranch()).ifPresent(builder::setFirmExecutionCountryOfBranch);
			ofNullable(getWaiverIndicator()).ifPresent(builder::setWaiverIndicator);
			ofNullable(getShortSellingIndicator()).ifPresent(builder::setShortSellingIndicator);
			ofNullable(getOtcPostTradeIndicator()).ifPresent(builder::setOtcPostTradeIndicator);
			ofNullable(getCommodityDerivativeIndicator()).ifPresent(builder::setCommodityDerivativeIndicator);
			ofNullable(getSftIndicator()).ifPresent(builder::setSftIndicator);
			ofNullable(getDataCategory()).ifPresent(builder::setDataCategory);
			ofNullable(getInternalClientIdentification()).ifPresent(builder::setInternalClientIdentification);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MIFIRUnavistaCSVDocument _that = getType().cast(o);
		
			if (!Objects.equals(reportStatus, _that.getReportStatus())) return false;
			if (!Objects.equals(transactionReferenceNumber, _that.getTransactionReferenceNumber())) return false;
			if (!Objects.equals(venueTransactionID, _that.getVenueTransactionID())) return false;
			if (!Objects.equals(executingEntityID, _that.getExecutingEntityID())) return false;
			if (!Objects.equals(submittingEntityID, _that.getSubmittingEntityID())) return false;
			if (!Objects.equals(investmentFirmIndicator, _that.getInvestmentFirmIndicator())) return false;
			if (!Objects.equals(buyerID, _that.getBuyerID())) return false;
			if (!Objects.equals(buyerIDType, _that.getBuyerIDType())) return false;
			if (!Objects.equals(buyerIDSubType, _that.getBuyerIDSubType())) return false;
			if (!Objects.equals(buyerCountryOfBranch, _that.getBuyerCountryOfBranch())) return false;
			if (!Objects.equals(buyerFirstName, _that.getBuyerFirstName())) return false;
			if (!Objects.equals(buyerSurname, _that.getBuyerSurname())) return false;
			if (!Objects.equals(buyerDOB, _that.getBuyerDOB())) return false;
			if (!Objects.equals(buyerDecisionMakerID, _that.getBuyerDecisionMakerID())) return false;
			if (!Objects.equals(buyerDecisionMakerIDType, _that.getBuyerDecisionMakerIDType())) return false;
			if (!Objects.equals(buyerDecisionMakerIDSubType, _that.getBuyerDecisionMakerIDSubType())) return false;
			if (!Objects.equals(buyerDecisionMakerFirstName, _that.getBuyerDecisionMakerFirstName())) return false;
			if (!Objects.equals(buyerDecisionMakerSurname, _that.getBuyerDecisionMakerSurname())) return false;
			if (!Objects.equals(buyerDecisionMakerDOB, _that.getBuyerDecisionMakerDOB())) return false;
			if (!Objects.equals(sellerID, _that.getSellerID())) return false;
			if (!Objects.equals(sellerIDType, _that.getSellerIDType())) return false;
			if (!Objects.equals(sellerIDSubType, _that.getSellerIDSubType())) return false;
			if (!Objects.equals(sellerCountryOfBranch, _that.getSellerCountryOfBranch())) return false;
			if (!Objects.equals(sellerFirstName, _that.getSellerFirstName())) return false;
			if (!Objects.equals(sellerSurname, _that.getSellerSurname())) return false;
			if (!Objects.equals(sellerDOB, _that.getSellerDOB())) return false;
			if (!Objects.equals(sellerDecisionMakerID, _that.getSellerDecisionMakerID())) return false;
			if (!Objects.equals(sellerDecisionMakerIDType, _that.getSellerDecisionMakerIDType())) return false;
			if (!Objects.equals(sellerDecisionMakerIDSubType, _that.getSellerDecisionMakerIDSubType())) return false;
			if (!Objects.equals(sellerDecisionMakerFirstName, _that.getSellerDecisionMakerFirstName())) return false;
			if (!Objects.equals(sellerDecisionMakerSurname, _that.getSellerDecisionMakerSurname())) return false;
			if (!Objects.equals(sellerDecisionMakerDOB, _that.getSellerDecisionMakerDOB())) return false;
			if (!Objects.equals(orderTransmissionIndicator, _that.getOrderTransmissionIndicator())) return false;
			if (!Objects.equals(buyerTransmitterID, _that.getBuyerTransmitterID())) return false;
			if (!Objects.equals(sellerTransmitterID, _that.getSellerTransmitterID())) return false;
			if (!Objects.equals(tradingDateTime, _that.getTradingDateTime())) return false;
			if (!Objects.equals(tradingCapacity, _that.getTradingCapacity())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(quantityType, _that.getQuantityType())) return false;
			if (!Objects.equals(quantityCurrency, _that.getQuantityCurrency())) return false;
			if (!Objects.equals(derivativeNotionalChange, _that.getDerivativeNotionalChange())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(priceType, _that.getPriceType())) return false;
			if (!Objects.equals(priceCurrency, _that.getPriceCurrency())) return false;
			if (!Objects.equals(netAmount, _that.getNetAmount())) return false;
			if (!Objects.equals(venue, _that.getVenue())) return false;
			if (!Objects.equals(countryOfBranch, _that.getCountryOfBranch())) return false;
			if (!Objects.equals(upFrontPayment, _that.getUpFrontPayment())) return false;
			if (!Objects.equals(upFrontPaymentCurrency, _that.getUpFrontPaymentCurrency())) return false;
			if (!Objects.equals(complexTradeComponentID, _that.getComplexTradeComponentID())) return false;
			if (!Objects.equals(instrumentID, _that.getInstrumentID())) return false;
			if (!Objects.equals(instrumentIDType, _that.getInstrumentIDType())) return false;
			if (!Objects.equals(instrumentName, _that.getInstrumentName())) return false;
			if (!Objects.equals(instrumentClassification, _that.getInstrumentClassification())) return false;
			if (!Objects.equals(notionalCurrency1, _that.getNotionalCurrency1())) return false;
			if (!Objects.equals(notionalCurrency2Type, _that.getNotionalCurrency2Type())) return false;
			if (!Objects.equals(notionalCurrency2, _that.getNotionalCurrency2())) return false;
			if (!Objects.equals(priceMultiplier, _that.getPriceMultiplier())) return false;
			if (!Objects.equals(uvInstrumentClassification, _that.getUvInstrumentClassification())) return false;
			if (!Objects.equals(underlyingInstrumentID, _that.getUnderlyingInstrumentID())) return false;
			if (!Objects.equals(uvIndexClassification, _that.getUvIndexClassification())) return false;
			if (!Objects.equals(underlyingIndexID, _that.getUnderlyingIndexID())) return false;
			if (!Objects.equals(underlyingIndexName, _that.getUnderlyingIndexName())) return false;
			if (!Objects.equals(underlyingIndexTerm, _that.getUnderlyingIndexTerm())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikePriceType, _that.getStrikePriceType())) return false;
			if (!Objects.equals(strikePriceCurrency, _that.getStrikePriceCurrency())) return false;
			if (!Objects.equals(optionStyle, _that.getOptionStyle())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(investmentDecisionID, _that.getInvestmentDecisionID())) return false;
			if (!Objects.equals(investmentDecisionIDType, _that.getInvestmentDecisionIDType())) return false;
			if (!Objects.equals(investmentDecisionIDSubType, _that.getInvestmentDecisionIDSubType())) return false;
			if (!Objects.equals(investmentDecisionCountryOfBranch, _that.getInvestmentDecisionCountryOfBranch())) return false;
			if (!Objects.equals(firmExecutionID, _that.getFirmExecutionID())) return false;
			if (!Objects.equals(firmExecutionIDType, _that.getFirmExecutionIDType())) return false;
			if (!Objects.equals(firmExecutionIDSubType, _that.getFirmExecutionIDSubType())) return false;
			if (!Objects.equals(firmExecutionCountryOfBranch, _that.getFirmExecutionCountryOfBranch())) return false;
			if (!Objects.equals(waiverIndicator, _that.getWaiverIndicator())) return false;
			if (!Objects.equals(shortSellingIndicator, _that.getShortSellingIndicator())) return false;
			if (!Objects.equals(otcPostTradeIndicator, _that.getOtcPostTradeIndicator())) return false;
			if (!Objects.equals(commodityDerivativeIndicator, _that.getCommodityDerivativeIndicator())) return false;
			if (!Objects.equals(sftIndicator, _that.getSftIndicator())) return false;
			if (!Objects.equals(dataCategory, _that.getDataCategory())) return false;
			if (!Objects.equals(internalClientIdentification, _that.getInternalClientIdentification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportStatus != null ? reportStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (transactionReferenceNumber != null ? transactionReferenceNumber.hashCode() : 0);
			_result = 31 * _result + (venueTransactionID != null ? venueTransactionID.hashCode() : 0);
			_result = 31 * _result + (executingEntityID != null ? executingEntityID.hashCode() : 0);
			_result = 31 * _result + (submittingEntityID != null ? submittingEntityID.hashCode() : 0);
			_result = 31 * _result + (investmentFirmIndicator != null ? investmentFirmIndicator.hashCode() : 0);
			_result = 31 * _result + (buyerID != null ? buyerID.hashCode() : 0);
			_result = 31 * _result + (buyerIDType != null ? buyerIDType.hashCode() : 0);
			_result = 31 * _result + (buyerIDSubType != null ? buyerIDSubType.hashCode() : 0);
			_result = 31 * _result + (buyerCountryOfBranch != null ? buyerCountryOfBranch.hashCode() : 0);
			_result = 31 * _result + (buyerFirstName != null ? buyerFirstName.hashCode() : 0);
			_result = 31 * _result + (buyerSurname != null ? buyerSurname.hashCode() : 0);
			_result = 31 * _result + (buyerDOB != null ? buyerDOB.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerID != null ? buyerDecisionMakerID.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerIDType != null ? buyerDecisionMakerIDType.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerIDSubType != null ? buyerDecisionMakerIDSubType.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerFirstName != null ? buyerDecisionMakerFirstName.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerSurname != null ? buyerDecisionMakerSurname.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerDOB != null ? buyerDecisionMakerDOB.hashCode() : 0);
			_result = 31 * _result + (sellerID != null ? sellerID.hashCode() : 0);
			_result = 31 * _result + (sellerIDType != null ? sellerIDType.hashCode() : 0);
			_result = 31 * _result + (sellerIDSubType != null ? sellerIDSubType.hashCode() : 0);
			_result = 31 * _result + (sellerCountryOfBranch != null ? sellerCountryOfBranch.hashCode() : 0);
			_result = 31 * _result + (sellerFirstName != null ? sellerFirstName.hashCode() : 0);
			_result = 31 * _result + (sellerSurname != null ? sellerSurname.hashCode() : 0);
			_result = 31 * _result + (sellerDOB != null ? sellerDOB.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerID != null ? sellerDecisionMakerID.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerIDType != null ? sellerDecisionMakerIDType.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerIDSubType != null ? sellerDecisionMakerIDSubType.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerFirstName != null ? sellerDecisionMakerFirstName.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerSurname != null ? sellerDecisionMakerSurname.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerDOB != null ? sellerDecisionMakerDOB.hashCode() : 0);
			_result = 31 * _result + (orderTransmissionIndicator != null ? orderTransmissionIndicator.hashCode() : 0);
			_result = 31 * _result + (buyerTransmitterID != null ? buyerTransmitterID.hashCode() : 0);
			_result = 31 * _result + (sellerTransmitterID != null ? sellerTransmitterID.hashCode() : 0);
			_result = 31 * _result + (tradingDateTime != null ? tradingDateTime.hashCode() : 0);
			_result = 31 * _result + (tradingCapacity != null ? tradingCapacity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityType != null ? quantityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantityCurrency != null ? quantityCurrency.hashCode() : 0);
			_result = 31 * _result + (derivativeNotionalChange != null ? derivativeNotionalChange.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (priceType != null ? priceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priceCurrency != null ? priceCurrency.hashCode() : 0);
			_result = 31 * _result + (netAmount != null ? netAmount.hashCode() : 0);
			_result = 31 * _result + (venue != null ? venue.hashCode() : 0);
			_result = 31 * _result + (countryOfBranch != null ? countryOfBranch.hashCode() : 0);
			_result = 31 * _result + (upFrontPayment != null ? upFrontPayment.hashCode() : 0);
			_result = 31 * _result + (upFrontPaymentCurrency != null ? upFrontPaymentCurrency.hashCode() : 0);
			_result = 31 * _result + (complexTradeComponentID != null ? complexTradeComponentID.hashCode() : 0);
			_result = 31 * _result + (instrumentID != null ? instrumentID.hashCode() : 0);
			_result = 31 * _result + (instrumentIDType != null ? instrumentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (instrumentName != null ? instrumentName.hashCode() : 0);
			_result = 31 * _result + (instrumentClassification != null ? instrumentClassification.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency1 != null ? notionalCurrency1.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency2Type != null ? notionalCurrency2Type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notionalCurrency2 != null ? notionalCurrency2.hashCode() : 0);
			_result = 31 * _result + (priceMultiplier != null ? priceMultiplier.hashCode() : 0);
			_result = 31 * _result + (uvInstrumentClassification != null ? uvInstrumentClassification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentID != null ? underlyingInstrumentID.hashCode() : 0);
			_result = 31 * _result + (uvIndexClassification != null ? uvIndexClassification.hashCode() : 0);
			_result = 31 * _result + (underlyingIndexID != null ? underlyingIndexID.hashCode() : 0);
			_result = 31 * _result + (underlyingIndexName != null ? underlyingIndexName.hashCode() : 0);
			_result = 31 * _result + (underlyingIndexTerm != null ? underlyingIndexTerm.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePriceType != null ? strikePriceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikePriceCurrency != null ? strikePriceCurrency.hashCode() : 0);
			_result = 31 * _result + (optionStyle != null ? optionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (investmentDecisionID != null ? investmentDecisionID.hashCode() : 0);
			_result = 31 * _result + (investmentDecisionIDType != null ? investmentDecisionIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (investmentDecisionIDSubType != null ? investmentDecisionIDSubType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (investmentDecisionCountryOfBranch != null ? investmentDecisionCountryOfBranch.hashCode() : 0);
			_result = 31 * _result + (firmExecutionID != null ? firmExecutionID.hashCode() : 0);
			_result = 31 * _result + (firmExecutionIDType != null ? firmExecutionIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (firmExecutionIDSubType != null ? firmExecutionIDSubType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (firmExecutionCountryOfBranch != null ? firmExecutionCountryOfBranch.hashCode() : 0);
			_result = 31 * _result + (waiverIndicator != null ? waiverIndicator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shortSellingIndicator != null ? shortSellingIndicator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otcPostTradeIndicator != null ? otcPostTradeIndicator.hashCode() : 0);
			_result = 31 * _result + (commodityDerivativeIndicator != null ? commodityDerivativeIndicator.hashCode() : 0);
			_result = 31 * _result + (sftIndicator != null ? sftIndicator.hashCode() : 0);
			_result = 31 * _result + (dataCategory != null ? dataCategory.hashCode() : 0);
			_result = 31 * _result + (internalClientIdentification != null ? internalClientIdentification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MIFIRUnavistaCSVDocument {" +
				"reportStatus=" + this.reportStatus + ", " +
				"transactionReferenceNumber=" + this.transactionReferenceNumber + ", " +
				"venueTransactionID=" + this.venueTransactionID + ", " +
				"executingEntityID=" + this.executingEntityID + ", " +
				"submittingEntityID=" + this.submittingEntityID + ", " +
				"investmentFirmIndicator=" + this.investmentFirmIndicator + ", " +
				"buyerID=" + this.buyerID + ", " +
				"buyerIDType=" + this.buyerIDType + ", " +
				"buyerIDSubType=" + this.buyerIDSubType + ", " +
				"buyerCountryOfBranch=" + this.buyerCountryOfBranch + ", " +
				"buyerFirstName=" + this.buyerFirstName + ", " +
				"buyerSurname=" + this.buyerSurname + ", " +
				"buyerDOB=" + this.buyerDOB + ", " +
				"buyerDecisionMakerID=" + this.buyerDecisionMakerID + ", " +
				"buyerDecisionMakerIDType=" + this.buyerDecisionMakerIDType + ", " +
				"buyerDecisionMakerIDSubType=" + this.buyerDecisionMakerIDSubType + ", " +
				"buyerDecisionMakerFirstName=" + this.buyerDecisionMakerFirstName + ", " +
				"buyerDecisionMakerSurname=" + this.buyerDecisionMakerSurname + ", " +
				"buyerDecisionMakerDOB=" + this.buyerDecisionMakerDOB + ", " +
				"sellerID=" + this.sellerID + ", " +
				"sellerIDType=" + this.sellerIDType + ", " +
				"sellerIDSubType=" + this.sellerIDSubType + ", " +
				"sellerCountryOfBranch=" + this.sellerCountryOfBranch + ", " +
				"sellerFirstName=" + this.sellerFirstName + ", " +
				"sellerSurname=" + this.sellerSurname + ", " +
				"sellerDOB=" + this.sellerDOB + ", " +
				"sellerDecisionMakerID=" + this.sellerDecisionMakerID + ", " +
				"sellerDecisionMakerIDType=" + this.sellerDecisionMakerIDType + ", " +
				"sellerDecisionMakerIDSubType=" + this.sellerDecisionMakerIDSubType + ", " +
				"sellerDecisionMakerFirstName=" + this.sellerDecisionMakerFirstName + ", " +
				"sellerDecisionMakerSurname=" + this.sellerDecisionMakerSurname + ", " +
				"sellerDecisionMakerDOB=" + this.sellerDecisionMakerDOB + ", " +
				"orderTransmissionIndicator=" + this.orderTransmissionIndicator + ", " +
				"buyerTransmitterID=" + this.buyerTransmitterID + ", " +
				"sellerTransmitterID=" + this.sellerTransmitterID + ", " +
				"tradingDateTime=" + this.tradingDateTime + ", " +
				"tradingCapacity=" + this.tradingCapacity + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityType=" + this.quantityType + ", " +
				"quantityCurrency=" + this.quantityCurrency + ", " +
				"derivativeNotionalChange=" + this.derivativeNotionalChange + ", " +
				"price=" + this.price + ", " +
				"priceType=" + this.priceType + ", " +
				"priceCurrency=" + this.priceCurrency + ", " +
				"netAmount=" + this.netAmount + ", " +
				"venue=" + this.venue + ", " +
				"countryOfBranch=" + this.countryOfBranch + ", " +
				"upFrontPayment=" + this.upFrontPayment + ", " +
				"upFrontPaymentCurrency=" + this.upFrontPaymentCurrency + ", " +
				"complexTradeComponentID=" + this.complexTradeComponentID + ", " +
				"instrumentID=" + this.instrumentID + ", " +
				"instrumentIDType=" + this.instrumentIDType + ", " +
				"instrumentName=" + this.instrumentName + ", " +
				"instrumentClassification=" + this.instrumentClassification + ", " +
				"notionalCurrency1=" + this.notionalCurrency1 + ", " +
				"notionalCurrency2Type=" + this.notionalCurrency2Type + ", " +
				"notionalCurrency2=" + this.notionalCurrency2 + ", " +
				"priceMultiplier=" + this.priceMultiplier + ", " +
				"uvInstrumentClassification=" + this.uvInstrumentClassification + ", " +
				"underlyingInstrumentID=" + this.underlyingInstrumentID + ", " +
				"uvIndexClassification=" + this.uvIndexClassification + ", " +
				"underlyingIndexID=" + this.underlyingIndexID + ", " +
				"underlyingIndexName=" + this.underlyingIndexName + ", " +
				"underlyingIndexTerm=" + this.underlyingIndexTerm + ", " +
				"optionType=" + this.optionType + ", " +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePriceType=" + this.strikePriceType + ", " +
				"strikePriceCurrency=" + this.strikePriceCurrency + ", " +
				"optionStyle=" + this.optionStyle + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"investmentDecisionID=" + this.investmentDecisionID + ", " +
				"investmentDecisionIDType=" + this.investmentDecisionIDType + ", " +
				"investmentDecisionIDSubType=" + this.investmentDecisionIDSubType + ", " +
				"investmentDecisionCountryOfBranch=" + this.investmentDecisionCountryOfBranch + ", " +
				"firmExecutionID=" + this.firmExecutionID + ", " +
				"firmExecutionIDType=" + this.firmExecutionIDType + ", " +
				"firmExecutionIDSubType=" + this.firmExecutionIDSubType + ", " +
				"firmExecutionCountryOfBranch=" + this.firmExecutionCountryOfBranch + ", " +
				"waiverIndicator=" + this.waiverIndicator + ", " +
				"shortSellingIndicator=" + this.shortSellingIndicator + ", " +
				"otcPostTradeIndicator=" + this.otcPostTradeIndicator + ", " +
				"commodityDerivativeIndicator=" + this.commodityDerivativeIndicator + ", " +
				"sftIndicator=" + this.sftIndicator + ", " +
				"dataCategory=" + this.dataCategory + ", " +
				"internalClientIdentification=" + this.internalClientIdentification +
			'}';
		}
	}

	/*********************** Builder Implementation of MIFIRUnavistaCSVDocument  ***********************/
	class MIFIRUnavistaCSVDocumentBuilderImpl implements MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder {
	
		protected ReportStatusEnum reportStatus;
		protected String transactionReferenceNumber;
		protected String venueTransactionID;
		protected String executingEntityID;
		protected String submittingEntityID;
		protected Boolean investmentFirmIndicator;
		protected String buyerID;
		protected String buyerIDType;
		protected String buyerIDSubType;
		protected String buyerCountryOfBranch;
		protected String buyerFirstName;
		protected String buyerSurname;
		protected String buyerDOB;
		protected String buyerDecisionMakerID;
		protected String buyerDecisionMakerIDType;
		protected String buyerDecisionMakerIDSubType;
		protected String buyerDecisionMakerFirstName;
		protected String buyerDecisionMakerSurname;
		protected String buyerDecisionMakerDOB;
		protected String sellerID;
		protected String sellerIDType;
		protected String sellerIDSubType;
		protected String sellerCountryOfBranch;
		protected String sellerFirstName;
		protected String sellerSurname;
		protected String sellerDOB;
		protected String sellerDecisionMakerID;
		protected String sellerDecisionMakerIDType;
		protected String sellerDecisionMakerIDSubType;
		protected String sellerDecisionMakerFirstName;
		protected String sellerDecisionMakerSurname;
		protected String sellerDecisionMakerDOB;
		protected Boolean orderTransmissionIndicator;
		protected String buyerTransmitterID;
		protected String sellerTransmitterID;
		protected ZonedDateTime tradingDateTime;
		protected TradingCapacityEnum tradingCapacity;
		protected BigDecimal quantity;
		protected QuantityTypeEnum quantityType;
		protected String quantityCurrency;
		protected DerivativeNotionalChangeEnum derivativeNotionalChange;
		protected BigDecimal price;
		protected PriceTypeEnum priceType;
		protected String priceCurrency;
		protected BigDecimal netAmount;
		protected String venue;
		protected String countryOfBranch;
		protected BigDecimal upFrontPayment;
		protected String upFrontPaymentCurrency;
		protected String complexTradeComponentID;
		protected String instrumentID;
		protected InstrumentIdTypeEnum instrumentIDType;
		protected String instrumentName;
		protected String instrumentClassification;
		protected String notionalCurrency1;
		protected NotionalCurrency2TypeEnum notionalCurrency2Type;
		protected String notionalCurrency2;
		protected BigDecimal priceMultiplier;
		protected UVInstrumentClassificationEnum uvInstrumentClassification;
		protected String underlyingInstrumentID;
		protected String uvIndexClassification;
		protected String underlyingIndexID;
		protected String underlyingIndexName;
		protected String underlyingIndexTerm;
		protected OptionTypeEnum optionType;
		protected BigDecimal strikePrice;
		protected PriceTypeEnum strikePriceType;
		protected String strikePriceCurrency;
		protected OptionStyleEnum optionStyle;
		protected Date maturityDate;
		protected Date expiryDate;
		protected DeliveryTypeEnum deliveryType;
		protected String investmentDecisionID;
		protected InvestmnentDecisionIdTypeEnum investmentDecisionIDType;
		protected DecisionMakerIdSubTypeEnum investmentDecisionIDSubType;
		protected String investmentDecisionCountryOfBranch;
		protected String firmExecutionID;
		protected FirmExecutionIdTypeEnum firmExecutionIDType;
		protected DecisionMakerIdSubTypeEnum firmExecutionIDSubType;
		protected String firmExecutionCountryOfBranch;
		protected WaiverIndicatorEnum waiverIndicator;
		protected ShortSellingIndicatorEnum shortSellingIndicator;
		protected String otcPostTradeIndicator;
		protected Boolean commodityDerivativeIndicator;
		protected Boolean sftIndicator;
		protected String dataCategory;
		protected String internalClientIdentification;
		
		@Override
		@RosettaAttribute("reportStatus")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportStatus")
		public ReportStatusEnum getReportStatus() {
			return reportStatus;
		}
		
		@Override
		@RosettaAttribute("transactionReferenceNumber")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("transactionReferenceNumber")
		public String getTransactionReferenceNumber() {
			return transactionReferenceNumber;
		}
		
		@Override
		@RosettaAttribute("venueTransactionID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("venueTransactionID")
		public String getVenueTransactionID() {
			return venueTransactionID;
		}
		
		@Override
		@RosettaAttribute("executingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executingEntityID")
		public String getExecutingEntityID() {
			return executingEntityID;
		}
		
		@Override
		@RosettaAttribute("submittingEntityID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submittingEntityID")
		public String getSubmittingEntityID() {
			return submittingEntityID;
		}
		
		@Override
		@RosettaAttribute("investmentFirmIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentFirmIndicator")
		public Boolean getInvestmentFirmIndicator() {
			return investmentFirmIndicator;
		}
		
		@Override
		@RosettaAttribute("buyerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerID")
		public String getBuyerID() {
			return buyerID;
		}
		
		@Override
		@RosettaAttribute("buyerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerIDType")
		public String getBuyerIDType() {
			return buyerIDType;
		}
		
		@Override
		@RosettaAttribute("buyerIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerIDSubType")
		public String getBuyerIDSubType() {
			return buyerIDSubType;
		}
		
		@Override
		@RosettaAttribute("buyerCountryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerCountryOfBranch")
		public String getBuyerCountryOfBranch() {
			return buyerCountryOfBranch;
		}
		
		@Override
		@RosettaAttribute("buyerFirstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerFirstName")
		public String getBuyerFirstName() {
			return buyerFirstName;
		}
		
		@Override
		@RosettaAttribute("buyerSurname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerSurname")
		public String getBuyerSurname() {
			return buyerSurname;
		}
		
		@Override
		@RosettaAttribute("buyerDOB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDOB")
		public String getBuyerDOB() {
			return buyerDOB;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerID")
		public String getBuyerDecisionMakerID() {
			return buyerDecisionMakerID;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerIDType")
		public String getBuyerDecisionMakerIDType() {
			return buyerDecisionMakerIDType;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerIDSubType")
		public String getBuyerDecisionMakerIDSubType() {
			return buyerDecisionMakerIDSubType;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerFirstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerFirstName")
		public String getBuyerDecisionMakerFirstName() {
			return buyerDecisionMakerFirstName;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerSurname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerSurname")
		public String getBuyerDecisionMakerSurname() {
			return buyerDecisionMakerSurname;
		}
		
		@Override
		@RosettaAttribute("buyerDecisionMakerDOB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerDecisionMakerDOB")
		public String getBuyerDecisionMakerDOB() {
			return buyerDecisionMakerDOB;
		}
		
		@Override
		@RosettaAttribute("sellerID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerID")
		public String getSellerID() {
			return sellerID;
		}
		
		@Override
		@RosettaAttribute("sellerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerIDType")
		public String getSellerIDType() {
			return sellerIDType;
		}
		
		@Override
		@RosettaAttribute("sellerIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerIDSubType")
		public String getSellerIDSubType() {
			return sellerIDSubType;
		}
		
		@Override
		@RosettaAttribute("sellerCountryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerCountryOfBranch")
		public String getSellerCountryOfBranch() {
			return sellerCountryOfBranch;
		}
		
		@Override
		@RosettaAttribute("sellerFirstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerFirstName")
		public String getSellerFirstName() {
			return sellerFirstName;
		}
		
		@Override
		@RosettaAttribute("sellerSurname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerSurname")
		public String getSellerSurname() {
			return sellerSurname;
		}
		
		@Override
		@RosettaAttribute("sellerDOB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDOB")
		public String getSellerDOB() {
			return sellerDOB;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerID")
		public String getSellerDecisionMakerID() {
			return sellerDecisionMakerID;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerIDType")
		public String getSellerDecisionMakerIDType() {
			return sellerDecisionMakerIDType;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerIDSubType")
		public String getSellerDecisionMakerIDSubType() {
			return sellerDecisionMakerIDSubType;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerFirstName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerFirstName")
		public String getSellerDecisionMakerFirstName() {
			return sellerDecisionMakerFirstName;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerSurname")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerSurname")
		public String getSellerDecisionMakerSurname() {
			return sellerDecisionMakerSurname;
		}
		
		@Override
		@RosettaAttribute("sellerDecisionMakerDOB")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerDecisionMakerDOB")
		public String getSellerDecisionMakerDOB() {
			return sellerDecisionMakerDOB;
		}
		
		@Override
		@RosettaAttribute("orderTransmissionIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("orderTransmissionIndicator")
		public Boolean getOrderTransmissionIndicator() {
			return orderTransmissionIndicator;
		}
		
		@Override
		@RosettaAttribute("buyerTransmitterID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerTransmitterID")
		public String getBuyerTransmitterID() {
			return buyerTransmitterID;
		}
		
		@Override
		@RosettaAttribute("sellerTransmitterID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerTransmitterID")
		public String getSellerTransmitterID() {
			return sellerTransmitterID;
		}
		
		@Override
		@RosettaAttribute("tradingDateTime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradingDateTime")
		public ZonedDateTime getTradingDateTime() {
			return tradingDateTime;
		}
		
		@Override
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradingCapacity")
		public TradingCapacityEnum getTradingCapacity() {
			return tradingCapacity;
		}
		
		@Override
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quantity")
		public BigDecimal getQuantity() {
			return quantity;
		}
		
		@Override
		@RosettaAttribute("quantityType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityType")
		public QuantityTypeEnum getQuantityType() {
			return quantityType;
		}
		
		@Override
		@RosettaAttribute("quantityCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityCurrency")
		public String getQuantityCurrency() {
			return quantityCurrency;
		}
		
		@Override
		@RosettaAttribute("derivativeNotionalChange")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("derivativeNotionalChange")
		public DerivativeNotionalChangeEnum getDerivativeNotionalChange() {
			return derivativeNotionalChange;
		}
		
		@Override
		@RosettaAttribute("price")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("price")
		public BigDecimal getPrice() {
			return price;
		}
		
		@Override
		@RosettaAttribute("priceType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceType")
		public PriceTypeEnum getPriceType() {
			return priceType;
		}
		
		@Override
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceCurrency")
		public String getPriceCurrency() {
			return priceCurrency;
		}
		
		@Override
		@RosettaAttribute("netAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("netAmount")
		public BigDecimal getNetAmount() {
			return netAmount;
		}
		
		@Override
		@RosettaAttribute("venue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("venue")
		public String getVenue() {
			return venue;
		}
		
		@Override
		@RosettaAttribute("countryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("countryOfBranch")
		public String getCountryOfBranch() {
			return countryOfBranch;
		}
		
		@Override
		@RosettaAttribute("upFrontPayment")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upFrontPayment")
		public BigDecimal getUpFrontPayment() {
			return upFrontPayment;
		}
		
		@Override
		@RosettaAttribute("upFrontPaymentCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("upFrontPaymentCurrency")
		public String getUpFrontPaymentCurrency() {
			return upFrontPaymentCurrency;
		}
		
		@Override
		@RosettaAttribute("complexTradeComponentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("complexTradeComponentID")
		public String getComplexTradeComponentID() {
			return complexTradeComponentID;
		}
		
		@Override
		@RosettaAttribute("instrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentID")
		public String getInstrumentID() {
			return instrumentID;
		}
		
		@Override
		@RosettaAttribute("instrumentIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentIDType")
		public InstrumentIdTypeEnum getInstrumentIDType() {
			return instrumentIDType;
		}
		
		@Override
		@RosettaAttribute("instrumentName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentName")
		public String getInstrumentName() {
			return instrumentName;
		}
		
		@Override
		@RosettaAttribute("instrumentClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("instrumentClassification")
		public String getInstrumentClassification() {
			return instrumentClassification;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalCurrency1")
		public String getNotionalCurrency1() {
			return notionalCurrency1;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency2Type")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalCurrency2Type")
		public NotionalCurrency2TypeEnum getNotionalCurrency2Type() {
			return notionalCurrency2Type;
		}
		
		@Override
		@RosettaAttribute("notionalCurrency2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalCurrency2")
		public String getNotionalCurrency2() {
			return notionalCurrency2;
		}
		
		@Override
		@RosettaAttribute("priceMultiplier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("priceMultiplier")
		public BigDecimal getPriceMultiplier() {
			return priceMultiplier;
		}
		
		@Override
		@RosettaAttribute("uvInstrumentClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uvInstrumentClassification")
		public UVInstrumentClassificationEnum getUvInstrumentClassification() {
			return uvInstrumentClassification;
		}
		
		@Override
		@RosettaAttribute("underlyingInstrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingInstrumentID")
		public String getUnderlyingInstrumentID() {
			return underlyingInstrumentID;
		}
		
		@Override
		@RosettaAttribute("uvIndexClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("uvIndexClassification")
		public String getUvIndexClassification() {
			return uvIndexClassification;
		}
		
		@Override
		@RosettaAttribute("underlyingIndexID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIndexID")
		public String getUnderlyingIndexID() {
			return underlyingIndexID;
		}
		
		@Override
		@RosettaAttribute("underlyingIndexName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIndexName")
		public String getUnderlyingIndexName() {
			return underlyingIndexName;
		}
		
		@Override
		@RosettaAttribute("underlyingIndexTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingIndexTerm")
		public String getUnderlyingIndexTerm() {
			return underlyingIndexTerm;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePrice")
		public BigDecimal getStrikePrice() {
			return strikePrice;
		}
		
		@Override
		@RosettaAttribute("strikePriceType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceType")
		public PriceTypeEnum getStrikePriceType() {
			return strikePriceType;
		}
		
		@Override
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceCurrency")
		public String getStrikePriceCurrency() {
			return strikePriceCurrency;
		}
		
		@Override
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionStyle")
		public OptionStyleEnum getOptionStyle() {
			return optionStyle;
		}
		
		@Override
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDate")
		public Date getMaturityDate() {
			return maturityDate;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryDate")
		public Date getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public DeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("investmentDecisionID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentDecisionID")
		public String getInvestmentDecisionID() {
			return investmentDecisionID;
		}
		
		@Override
		@RosettaAttribute("investmentDecisionIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentDecisionIDType")
		public InvestmnentDecisionIdTypeEnum getInvestmentDecisionIDType() {
			return investmentDecisionIDType;
		}
		
		@Override
		@RosettaAttribute("investmentDecisionIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentDecisionIDSubType")
		public DecisionMakerIdSubTypeEnum getInvestmentDecisionIDSubType() {
			return investmentDecisionIDSubType;
		}
		
		@Override
		@RosettaAttribute("investmentDecisionCountryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("investmentDecisionCountryOfBranch")
		public String getInvestmentDecisionCountryOfBranch() {
			return investmentDecisionCountryOfBranch;
		}
		
		@Override
		@RosettaAttribute("firmExecutionID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("firmExecutionID")
		public String getFirmExecutionID() {
			return firmExecutionID;
		}
		
		@Override
		@RosettaAttribute("firmExecutionIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firmExecutionIDType")
		public FirmExecutionIdTypeEnum getFirmExecutionIDType() {
			return firmExecutionIDType;
		}
		
		@Override
		@RosettaAttribute("firmExecutionIDSubType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firmExecutionIDSubType")
		public DecisionMakerIdSubTypeEnum getFirmExecutionIDSubType() {
			return firmExecutionIDSubType;
		}
		
		@Override
		@RosettaAttribute("firmExecutionCountryOfBranch")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("firmExecutionCountryOfBranch")
		public String getFirmExecutionCountryOfBranch() {
			return firmExecutionCountryOfBranch;
		}
		
		@Override
		@RosettaAttribute("waiverIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("waiverIndicator")
		public WaiverIndicatorEnum getWaiverIndicator() {
			return waiverIndicator;
		}
		
		@Override
		@RosettaAttribute("shortSellingIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shortSellingIndicator")
		public ShortSellingIndicatorEnum getShortSellingIndicator() {
			return shortSellingIndicator;
		}
		
		@Override
		@RosettaAttribute("otcPostTradeIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("otcPostTradeIndicator")
		public String getOtcPostTradeIndicator() {
			return otcPostTradeIndicator;
		}
		
		@Override
		@RosettaAttribute("commodityDerivativeIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityDerivativeIndicator")
		public Boolean getCommodityDerivativeIndicator() {
			return commodityDerivativeIndicator;
		}
		
		@Override
		@RosettaAttribute("sftIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sftIndicator")
		public Boolean getSftIndicator() {
			return sftIndicator;
		}
		
		@Override
		@RosettaAttribute("dataCategory")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dataCategory")
		public String getDataCategory() {
			return dataCategory;
		}
		
		@Override
		@RosettaAttribute("internalClientIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("internalClientIdentification")
		public String getInternalClientIdentification() {
			return internalClientIdentification;
		}
		
		@RosettaAttribute("reportStatus")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportStatus")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setReportStatus(ReportStatusEnum _reportStatus) {
			this.reportStatus = _reportStatus == null ? null : _reportStatus;
			return this;
		}
		
		@RosettaAttribute("transactionReferenceNumber")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("transactionReferenceNumber")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setTransactionReferenceNumber(String _transactionReferenceNumber) {
			this.transactionReferenceNumber = _transactionReferenceNumber == null ? null : _transactionReferenceNumber;
			return this;
		}
		
		@RosettaAttribute("venueTransactionID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("venueTransactionID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setVenueTransactionID(String _venueTransactionID) {
			this.venueTransactionID = _venueTransactionID == null ? null : _venueTransactionID;
			return this;
		}
		
		@RosettaAttribute("executingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executingEntityID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setExecutingEntityID(String _executingEntityID) {
			this.executingEntityID = _executingEntityID == null ? null : _executingEntityID;
			return this;
		}
		
		@RosettaAttribute("submittingEntityID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submittingEntityID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSubmittingEntityID(String _submittingEntityID) {
			this.submittingEntityID = _submittingEntityID == null ? null : _submittingEntityID;
			return this;
		}
		
		@RosettaAttribute("investmentFirmIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("investmentFirmIndicator")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentFirmIndicator(Boolean _investmentFirmIndicator) {
			this.investmentFirmIndicator = _investmentFirmIndicator == null ? null : _investmentFirmIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerID(String _buyerID) {
			this.buyerID = _buyerID == null ? null : _buyerID;
			return this;
		}
		
		@RosettaAttribute("buyerIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIDType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerIDType(String _buyerIDType) {
			this.buyerIDType = _buyerIDType == null ? null : _buyerIDType;
			return this;
		}
		
		@RosettaAttribute("buyerIDSubType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerIDSubType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerIDSubType(String _buyerIDSubType) {
			this.buyerIDSubType = _buyerIDSubType == null ? null : _buyerIDSubType;
			return this;
		}
		
		@RosettaAttribute("buyerCountryOfBranch")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerCountryOfBranch")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerCountryOfBranch(String _buyerCountryOfBranch) {
			this.buyerCountryOfBranch = _buyerCountryOfBranch == null ? null : _buyerCountryOfBranch;
			return this;
		}
		
		@RosettaAttribute("buyerFirstName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerFirstName")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerFirstName(String _buyerFirstName) {
			this.buyerFirstName = _buyerFirstName == null ? null : _buyerFirstName;
			return this;
		}
		
		@RosettaAttribute("buyerSurname")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerSurname")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerSurname(String _buyerSurname) {
			this.buyerSurname = _buyerSurname == null ? null : _buyerSurname;
			return this;
		}
		
		@RosettaAttribute("buyerDOB")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerDOB")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDOB(String _buyerDOB) {
			this.buyerDOB = _buyerDOB == null ? null : _buyerDOB;
			return this;
		}
		
		@RosettaAttribute("buyerDecisionMakerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerDecisionMakerID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerID(String _buyerDecisionMakerID) {
			this.buyerDecisionMakerID = _buyerDecisionMakerID == null ? null : _buyerDecisionMakerID;
			return this;
		}
		
		@RosettaAttribute("buyerDecisionMakerIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerDecisionMakerIDType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerIDType(String _buyerDecisionMakerIDType) {
			this.buyerDecisionMakerIDType = _buyerDecisionMakerIDType == null ? null : _buyerDecisionMakerIDType;
			return this;
		}
		
		@RosettaAttribute("buyerDecisionMakerIDSubType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerDecisionMakerIDSubType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerIDSubType(String _buyerDecisionMakerIDSubType) {
			this.buyerDecisionMakerIDSubType = _buyerDecisionMakerIDSubType == null ? null : _buyerDecisionMakerIDSubType;
			return this;
		}
		
		@RosettaAttribute("buyerDecisionMakerFirstName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerDecisionMakerFirstName")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerFirstName(String _buyerDecisionMakerFirstName) {
			this.buyerDecisionMakerFirstName = _buyerDecisionMakerFirstName == null ? null : _buyerDecisionMakerFirstName;
			return this;
		}
		
		@RosettaAttribute("buyerDecisionMakerSurname")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerDecisionMakerSurname")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerSurname(String _buyerDecisionMakerSurname) {
			this.buyerDecisionMakerSurname = _buyerDecisionMakerSurname == null ? null : _buyerDecisionMakerSurname;
			return this;
		}
		
		@RosettaAttribute("buyerDecisionMakerDOB")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerDecisionMakerDOB")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerDecisionMakerDOB(String _buyerDecisionMakerDOB) {
			this.buyerDecisionMakerDOB = _buyerDecisionMakerDOB == null ? null : _buyerDecisionMakerDOB;
			return this;
		}
		
		@RosettaAttribute("sellerID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerID(String _sellerID) {
			this.sellerID = _sellerID == null ? null : _sellerID;
			return this;
		}
		
		@RosettaAttribute("sellerIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIDType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerIDType(String _sellerIDType) {
			this.sellerIDType = _sellerIDType == null ? null : _sellerIDType;
			return this;
		}
		
		@RosettaAttribute("sellerIDSubType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerIDSubType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerIDSubType(String _sellerIDSubType) {
			this.sellerIDSubType = _sellerIDSubType == null ? null : _sellerIDSubType;
			return this;
		}
		
		@RosettaAttribute("sellerCountryOfBranch")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerCountryOfBranch")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerCountryOfBranch(String _sellerCountryOfBranch) {
			this.sellerCountryOfBranch = _sellerCountryOfBranch == null ? null : _sellerCountryOfBranch;
			return this;
		}
		
		@RosettaAttribute("sellerFirstName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerFirstName")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerFirstName(String _sellerFirstName) {
			this.sellerFirstName = _sellerFirstName == null ? null : _sellerFirstName;
			return this;
		}
		
		@RosettaAttribute("sellerSurname")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerSurname")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerSurname(String _sellerSurname) {
			this.sellerSurname = _sellerSurname == null ? null : _sellerSurname;
			return this;
		}
		
		@RosettaAttribute("sellerDOB")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerDOB")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDOB(String _sellerDOB) {
			this.sellerDOB = _sellerDOB == null ? null : _sellerDOB;
			return this;
		}
		
		@RosettaAttribute("sellerDecisionMakerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerDecisionMakerID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerID(String _sellerDecisionMakerID) {
			this.sellerDecisionMakerID = _sellerDecisionMakerID == null ? null : _sellerDecisionMakerID;
			return this;
		}
		
		@RosettaAttribute("sellerDecisionMakerIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerDecisionMakerIDType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerIDType(String _sellerDecisionMakerIDType) {
			this.sellerDecisionMakerIDType = _sellerDecisionMakerIDType == null ? null : _sellerDecisionMakerIDType;
			return this;
		}
		
		@RosettaAttribute("sellerDecisionMakerIDSubType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerDecisionMakerIDSubType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerIDSubType(String _sellerDecisionMakerIDSubType) {
			this.sellerDecisionMakerIDSubType = _sellerDecisionMakerIDSubType == null ? null : _sellerDecisionMakerIDSubType;
			return this;
		}
		
		@RosettaAttribute("sellerDecisionMakerFirstName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerDecisionMakerFirstName")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerFirstName(String _sellerDecisionMakerFirstName) {
			this.sellerDecisionMakerFirstName = _sellerDecisionMakerFirstName == null ? null : _sellerDecisionMakerFirstName;
			return this;
		}
		
		@RosettaAttribute("sellerDecisionMakerSurname")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerDecisionMakerSurname")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerSurname(String _sellerDecisionMakerSurname) {
			this.sellerDecisionMakerSurname = _sellerDecisionMakerSurname == null ? null : _sellerDecisionMakerSurname;
			return this;
		}
		
		@RosettaAttribute("sellerDecisionMakerDOB")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerDecisionMakerDOB")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerDecisionMakerDOB(String _sellerDecisionMakerDOB) {
			this.sellerDecisionMakerDOB = _sellerDecisionMakerDOB == null ? null : _sellerDecisionMakerDOB;
			return this;
		}
		
		@RosettaAttribute("orderTransmissionIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("orderTransmissionIndicator")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setOrderTransmissionIndicator(Boolean _orderTransmissionIndicator) {
			this.orderTransmissionIndicator = _orderTransmissionIndicator == null ? null : _orderTransmissionIndicator;
			return this;
		}
		
		@RosettaAttribute("buyerTransmitterID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerTransmitterID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setBuyerTransmitterID(String _buyerTransmitterID) {
			this.buyerTransmitterID = _buyerTransmitterID == null ? null : _buyerTransmitterID;
			return this;
		}
		
		@RosettaAttribute("sellerTransmitterID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerTransmitterID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSellerTransmitterID(String _sellerTransmitterID) {
			this.sellerTransmitterID = _sellerTransmitterID == null ? null : _sellerTransmitterID;
			return this;
		}
		
		@RosettaAttribute("tradingDateTime")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradingDateTime")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setTradingDateTime(ZonedDateTime _tradingDateTime) {
			this.tradingDateTime = _tradingDateTime == null ? null : _tradingDateTime;
			return this;
		}
		
		@RosettaAttribute("tradingCapacity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradingCapacity")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setTradingCapacity(TradingCapacityEnum _tradingCapacity) {
			this.tradingCapacity = _tradingCapacity == null ? null : _tradingCapacity;
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quantity")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@RosettaAttribute("quantityType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setQuantityType(QuantityTypeEnum _quantityType) {
			this.quantityType = _quantityType == null ? null : _quantityType;
			return this;
		}
		
		@RosettaAttribute("quantityCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityCurrency")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setQuantityCurrency(String _quantityCurrency) {
			this.quantityCurrency = _quantityCurrency == null ? null : _quantityCurrency;
			return this;
		}
		
		@RosettaAttribute("derivativeNotionalChange")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("derivativeNotionalChange")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setDerivativeNotionalChange(DerivativeNotionalChangeEnum _derivativeNotionalChange) {
			this.derivativeNotionalChange = _derivativeNotionalChange == null ? null : _derivativeNotionalChange;
			return this;
		}
		
		@RosettaAttribute("price")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("price")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setPrice(BigDecimal _price) {
			this.price = _price == null ? null : _price;
			return this;
		}
		
		@RosettaAttribute("priceType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setPriceType(PriceTypeEnum _priceType) {
			this.priceType = _priceType == null ? null : _priceType;
			return this;
		}
		
		@RosettaAttribute("priceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceCurrency")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setPriceCurrency(String _priceCurrency) {
			this.priceCurrency = _priceCurrency == null ? null : _priceCurrency;
			return this;
		}
		
		@RosettaAttribute("netAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("netAmount")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setNetAmount(BigDecimal _netAmount) {
			this.netAmount = _netAmount == null ? null : _netAmount;
			return this;
		}
		
		@RosettaAttribute("venue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("venue")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setVenue(String _venue) {
			this.venue = _venue == null ? null : _venue;
			return this;
		}
		
		@RosettaAttribute("countryOfBranch")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("countryOfBranch")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setCountryOfBranch(String _countryOfBranch) {
			this.countryOfBranch = _countryOfBranch == null ? null : _countryOfBranch;
			return this;
		}
		
		@RosettaAttribute("upFrontPayment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upFrontPayment")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUpFrontPayment(BigDecimal _upFrontPayment) {
			this.upFrontPayment = _upFrontPayment == null ? null : _upFrontPayment;
			return this;
		}
		
		@RosettaAttribute("upFrontPaymentCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("upFrontPaymentCurrency")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUpFrontPaymentCurrency(String _upFrontPaymentCurrency) {
			this.upFrontPaymentCurrency = _upFrontPaymentCurrency == null ? null : _upFrontPaymentCurrency;
			return this;
		}
		
		@RosettaAttribute("complexTradeComponentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("complexTradeComponentID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setComplexTradeComponentID(String _complexTradeComponentID) {
			this.complexTradeComponentID = _complexTradeComponentID == null ? null : _complexTradeComponentID;
			return this;
		}
		
		@RosettaAttribute("instrumentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInstrumentID(String _instrumentID) {
			this.instrumentID = _instrumentID == null ? null : _instrumentID;
			return this;
		}
		
		@RosettaAttribute("instrumentIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentIDType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInstrumentIDType(InstrumentIdTypeEnum _instrumentIDType) {
			this.instrumentIDType = _instrumentIDType == null ? null : _instrumentIDType;
			return this;
		}
		
		@RosettaAttribute("instrumentName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentName")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInstrumentName(String _instrumentName) {
			this.instrumentName = _instrumentName == null ? null : _instrumentName;
			return this;
		}
		
		@RosettaAttribute("instrumentClassification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("instrumentClassification")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInstrumentClassification(String _instrumentClassification) {
			this.instrumentClassification = _instrumentClassification == null ? null : _instrumentClassification;
			return this;
		}
		
		@RosettaAttribute("notionalCurrency1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalCurrency1")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setNotionalCurrency1(String _notionalCurrency1) {
			this.notionalCurrency1 = _notionalCurrency1 == null ? null : _notionalCurrency1;
			return this;
		}
		
		@RosettaAttribute("notionalCurrency2Type")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalCurrency2Type")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setNotionalCurrency2Type(NotionalCurrency2TypeEnum _notionalCurrency2Type) {
			this.notionalCurrency2Type = _notionalCurrency2Type == null ? null : _notionalCurrency2Type;
			return this;
		}
		
		@RosettaAttribute("notionalCurrency2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalCurrency2")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setNotionalCurrency2(String _notionalCurrency2) {
			this.notionalCurrency2 = _notionalCurrency2 == null ? null : _notionalCurrency2;
			return this;
		}
		
		@RosettaAttribute("priceMultiplier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("priceMultiplier")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setPriceMultiplier(BigDecimal _priceMultiplier) {
			this.priceMultiplier = _priceMultiplier == null ? null : _priceMultiplier;
			return this;
		}
		
		@RosettaAttribute("uvInstrumentClassification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uvInstrumentClassification")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUvInstrumentClassification(UVInstrumentClassificationEnum _uvInstrumentClassification) {
			this.uvInstrumentClassification = _uvInstrumentClassification == null ? null : _uvInstrumentClassification;
			return this;
		}
		
		@RosettaAttribute("underlyingInstrumentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingInstrumentID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUnderlyingInstrumentID(String _underlyingInstrumentID) {
			this.underlyingInstrumentID = _underlyingInstrumentID == null ? null : _underlyingInstrumentID;
			return this;
		}
		
		@RosettaAttribute("uvIndexClassification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("uvIndexClassification")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUvIndexClassification(String _uvIndexClassification) {
			this.uvIndexClassification = _uvIndexClassification == null ? null : _uvIndexClassification;
			return this;
		}
		
		@RosettaAttribute("underlyingIndexID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIndexID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUnderlyingIndexID(String _underlyingIndexID) {
			this.underlyingIndexID = _underlyingIndexID == null ? null : _underlyingIndexID;
			return this;
		}
		
		@RosettaAttribute("underlyingIndexName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIndexName")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUnderlyingIndexName(String _underlyingIndexName) {
			this.underlyingIndexName = _underlyingIndexName == null ? null : _underlyingIndexName;
			return this;
		}
		
		@RosettaAttribute("underlyingIndexTerm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingIndexTerm")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setUnderlyingIndexTerm(String _underlyingIndexTerm) {
			this.underlyingIndexTerm = _underlyingIndexTerm == null ? null : _underlyingIndexTerm;
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setOptionType(OptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("strikePrice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePrice")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setStrikePrice(BigDecimal _strikePrice) {
			this.strikePrice = _strikePrice == null ? null : _strikePrice;
			return this;
		}
		
		@RosettaAttribute("strikePriceType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setStrikePriceType(PriceTypeEnum _strikePriceType) {
			this.strikePriceType = _strikePriceType == null ? null : _strikePriceType;
			return this;
		}
		
		@RosettaAttribute("strikePriceCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceCurrency")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setStrikePriceCurrency(String _strikePriceCurrency) {
			this.strikePriceCurrency = _strikePriceCurrency == null ? null : _strikePriceCurrency;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("maturityDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDate")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setMaturityDate(Date _maturityDate) {
			this.maturityDate = _maturityDate == null ? null : _maturityDate;
			return this;
		}
		
		@RosettaAttribute("expiryDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryDate")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setExpiryDate(Date _expiryDate) {
			this.expiryDate = _expiryDate == null ? null : _expiryDate;
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setDeliveryType(DeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("investmentDecisionID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("investmentDecisionID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentDecisionID(String _investmentDecisionID) {
			this.investmentDecisionID = _investmentDecisionID == null ? null : _investmentDecisionID;
			return this;
		}
		
		@RosettaAttribute("investmentDecisionIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("investmentDecisionIDType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentDecisionIDType(InvestmnentDecisionIdTypeEnum _investmentDecisionIDType) {
			this.investmentDecisionIDType = _investmentDecisionIDType == null ? null : _investmentDecisionIDType;
			return this;
		}
		
		@RosettaAttribute("investmentDecisionIDSubType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("investmentDecisionIDSubType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentDecisionIDSubType(DecisionMakerIdSubTypeEnum _investmentDecisionIDSubType) {
			this.investmentDecisionIDSubType = _investmentDecisionIDSubType == null ? null : _investmentDecisionIDSubType;
			return this;
		}
		
		@RosettaAttribute("investmentDecisionCountryOfBranch")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("investmentDecisionCountryOfBranch")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInvestmentDecisionCountryOfBranch(String _investmentDecisionCountryOfBranch) {
			this.investmentDecisionCountryOfBranch = _investmentDecisionCountryOfBranch == null ? null : _investmentDecisionCountryOfBranch;
			return this;
		}
		
		@RosettaAttribute("firmExecutionID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("firmExecutionID")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setFirmExecutionID(String _firmExecutionID) {
			this.firmExecutionID = _firmExecutionID == null ? null : _firmExecutionID;
			return this;
		}
		
		@RosettaAttribute("firmExecutionIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firmExecutionIDType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setFirmExecutionIDType(FirmExecutionIdTypeEnum _firmExecutionIDType) {
			this.firmExecutionIDType = _firmExecutionIDType == null ? null : _firmExecutionIDType;
			return this;
		}
		
		@RosettaAttribute("firmExecutionIDSubType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firmExecutionIDSubType")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setFirmExecutionIDSubType(DecisionMakerIdSubTypeEnum _firmExecutionIDSubType) {
			this.firmExecutionIDSubType = _firmExecutionIDSubType == null ? null : _firmExecutionIDSubType;
			return this;
		}
		
		@RosettaAttribute("firmExecutionCountryOfBranch")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("firmExecutionCountryOfBranch")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setFirmExecutionCountryOfBranch(String _firmExecutionCountryOfBranch) {
			this.firmExecutionCountryOfBranch = _firmExecutionCountryOfBranch == null ? null : _firmExecutionCountryOfBranch;
			return this;
		}
		
		@RosettaAttribute("waiverIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("waiverIndicator")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setWaiverIndicator(WaiverIndicatorEnum _waiverIndicator) {
			this.waiverIndicator = _waiverIndicator == null ? null : _waiverIndicator;
			return this;
		}
		
		@RosettaAttribute("shortSellingIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shortSellingIndicator")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setShortSellingIndicator(ShortSellingIndicatorEnum _shortSellingIndicator) {
			this.shortSellingIndicator = _shortSellingIndicator == null ? null : _shortSellingIndicator;
			return this;
		}
		
		@RosettaAttribute("otcPostTradeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("otcPostTradeIndicator")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setOtcPostTradeIndicator(String _otcPostTradeIndicator) {
			this.otcPostTradeIndicator = _otcPostTradeIndicator == null ? null : _otcPostTradeIndicator;
			return this;
		}
		
		@RosettaAttribute("commodityDerivativeIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityDerivativeIndicator")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setCommodityDerivativeIndicator(Boolean _commodityDerivativeIndicator) {
			this.commodityDerivativeIndicator = _commodityDerivativeIndicator == null ? null : _commodityDerivativeIndicator;
			return this;
		}
		
		@RosettaAttribute("sftIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sftIndicator")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setSftIndicator(Boolean _sftIndicator) {
			this.sftIndicator = _sftIndicator == null ? null : _sftIndicator;
			return this;
		}
		
		@RosettaAttribute("dataCategory")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dataCategory")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setDataCategory(String _dataCategory) {
			this.dataCategory = _dataCategory == null ? null : _dataCategory;
			return this;
		}
		
		@RosettaAttribute("internalClientIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("internalClientIdentification")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder setInternalClientIdentification(String _internalClientIdentification) {
			this.internalClientIdentification = _internalClientIdentification == null ? null : _internalClientIdentification;
			return this;
		}
		
		@Override
		public MIFIRUnavistaCSVDocument build() {
			return new MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentImpl(this);
		}
		
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReportStatus()!=null) return true;
			if (getTransactionReferenceNumber()!=null) return true;
			if (getVenueTransactionID()!=null) return true;
			if (getExecutingEntityID()!=null) return true;
			if (getSubmittingEntityID()!=null) return true;
			if (getInvestmentFirmIndicator()!=null) return true;
			if (getBuyerID()!=null) return true;
			if (getBuyerIDType()!=null) return true;
			if (getBuyerIDSubType()!=null) return true;
			if (getBuyerCountryOfBranch()!=null) return true;
			if (getBuyerFirstName()!=null) return true;
			if (getBuyerSurname()!=null) return true;
			if (getBuyerDOB()!=null) return true;
			if (getBuyerDecisionMakerID()!=null) return true;
			if (getBuyerDecisionMakerIDType()!=null) return true;
			if (getBuyerDecisionMakerIDSubType()!=null) return true;
			if (getBuyerDecisionMakerFirstName()!=null) return true;
			if (getBuyerDecisionMakerSurname()!=null) return true;
			if (getBuyerDecisionMakerDOB()!=null) return true;
			if (getSellerID()!=null) return true;
			if (getSellerIDType()!=null) return true;
			if (getSellerIDSubType()!=null) return true;
			if (getSellerCountryOfBranch()!=null) return true;
			if (getSellerFirstName()!=null) return true;
			if (getSellerSurname()!=null) return true;
			if (getSellerDOB()!=null) return true;
			if (getSellerDecisionMakerID()!=null) return true;
			if (getSellerDecisionMakerIDType()!=null) return true;
			if (getSellerDecisionMakerIDSubType()!=null) return true;
			if (getSellerDecisionMakerFirstName()!=null) return true;
			if (getSellerDecisionMakerSurname()!=null) return true;
			if (getSellerDecisionMakerDOB()!=null) return true;
			if (getOrderTransmissionIndicator()!=null) return true;
			if (getBuyerTransmitterID()!=null) return true;
			if (getSellerTransmitterID()!=null) return true;
			if (getTradingDateTime()!=null) return true;
			if (getTradingCapacity()!=null) return true;
			if (getQuantity()!=null) return true;
			if (getQuantityType()!=null) return true;
			if (getQuantityCurrency()!=null) return true;
			if (getDerivativeNotionalChange()!=null) return true;
			if (getPrice()!=null) return true;
			if (getPriceType()!=null) return true;
			if (getPriceCurrency()!=null) return true;
			if (getNetAmount()!=null) return true;
			if (getVenue()!=null) return true;
			if (getCountryOfBranch()!=null) return true;
			if (getUpFrontPayment()!=null) return true;
			if (getUpFrontPaymentCurrency()!=null) return true;
			if (getComplexTradeComponentID()!=null) return true;
			if (getInstrumentID()!=null) return true;
			if (getInstrumentIDType()!=null) return true;
			if (getInstrumentName()!=null) return true;
			if (getInstrumentClassification()!=null) return true;
			if (getNotionalCurrency1()!=null) return true;
			if (getNotionalCurrency2Type()!=null) return true;
			if (getNotionalCurrency2()!=null) return true;
			if (getPriceMultiplier()!=null) return true;
			if (getUvInstrumentClassification()!=null) return true;
			if (getUnderlyingInstrumentID()!=null) return true;
			if (getUvIndexClassification()!=null) return true;
			if (getUnderlyingIndexID()!=null) return true;
			if (getUnderlyingIndexName()!=null) return true;
			if (getUnderlyingIndexTerm()!=null) return true;
			if (getOptionType()!=null) return true;
			if (getStrikePrice()!=null) return true;
			if (getStrikePriceType()!=null) return true;
			if (getStrikePriceCurrency()!=null) return true;
			if (getOptionStyle()!=null) return true;
			if (getMaturityDate()!=null) return true;
			if (getExpiryDate()!=null) return true;
			if (getDeliveryType()!=null) return true;
			if (getInvestmentDecisionID()!=null) return true;
			if (getInvestmentDecisionIDType()!=null) return true;
			if (getInvestmentDecisionIDSubType()!=null) return true;
			if (getInvestmentDecisionCountryOfBranch()!=null) return true;
			if (getFirmExecutionID()!=null) return true;
			if (getFirmExecutionIDType()!=null) return true;
			if (getFirmExecutionIDSubType()!=null) return true;
			if (getFirmExecutionCountryOfBranch()!=null) return true;
			if (getWaiverIndicator()!=null) return true;
			if (getShortSellingIndicator()!=null) return true;
			if (getOtcPostTradeIndicator()!=null) return true;
			if (getCommodityDerivativeIndicator()!=null) return true;
			if (getSftIndicator()!=null) return true;
			if (getDataCategory()!=null) return true;
			if (getInternalClientIdentification()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder o = (MIFIRUnavistaCSVDocument.MIFIRUnavistaCSVDocumentBuilder) other;
			
			
			merger.mergeBasic(getReportStatus(), o.getReportStatus(), this::setReportStatus);
			merger.mergeBasic(getTransactionReferenceNumber(), o.getTransactionReferenceNumber(), this::setTransactionReferenceNumber);
			merger.mergeBasic(getVenueTransactionID(), o.getVenueTransactionID(), this::setVenueTransactionID);
			merger.mergeBasic(getExecutingEntityID(), o.getExecutingEntityID(), this::setExecutingEntityID);
			merger.mergeBasic(getSubmittingEntityID(), o.getSubmittingEntityID(), this::setSubmittingEntityID);
			merger.mergeBasic(getInvestmentFirmIndicator(), o.getInvestmentFirmIndicator(), this::setInvestmentFirmIndicator);
			merger.mergeBasic(getBuyerID(), o.getBuyerID(), this::setBuyerID);
			merger.mergeBasic(getBuyerIDType(), o.getBuyerIDType(), this::setBuyerIDType);
			merger.mergeBasic(getBuyerIDSubType(), o.getBuyerIDSubType(), this::setBuyerIDSubType);
			merger.mergeBasic(getBuyerCountryOfBranch(), o.getBuyerCountryOfBranch(), this::setBuyerCountryOfBranch);
			merger.mergeBasic(getBuyerFirstName(), o.getBuyerFirstName(), this::setBuyerFirstName);
			merger.mergeBasic(getBuyerSurname(), o.getBuyerSurname(), this::setBuyerSurname);
			merger.mergeBasic(getBuyerDOB(), o.getBuyerDOB(), this::setBuyerDOB);
			merger.mergeBasic(getBuyerDecisionMakerID(), o.getBuyerDecisionMakerID(), this::setBuyerDecisionMakerID);
			merger.mergeBasic(getBuyerDecisionMakerIDType(), o.getBuyerDecisionMakerIDType(), this::setBuyerDecisionMakerIDType);
			merger.mergeBasic(getBuyerDecisionMakerIDSubType(), o.getBuyerDecisionMakerIDSubType(), this::setBuyerDecisionMakerIDSubType);
			merger.mergeBasic(getBuyerDecisionMakerFirstName(), o.getBuyerDecisionMakerFirstName(), this::setBuyerDecisionMakerFirstName);
			merger.mergeBasic(getBuyerDecisionMakerSurname(), o.getBuyerDecisionMakerSurname(), this::setBuyerDecisionMakerSurname);
			merger.mergeBasic(getBuyerDecisionMakerDOB(), o.getBuyerDecisionMakerDOB(), this::setBuyerDecisionMakerDOB);
			merger.mergeBasic(getSellerID(), o.getSellerID(), this::setSellerID);
			merger.mergeBasic(getSellerIDType(), o.getSellerIDType(), this::setSellerIDType);
			merger.mergeBasic(getSellerIDSubType(), o.getSellerIDSubType(), this::setSellerIDSubType);
			merger.mergeBasic(getSellerCountryOfBranch(), o.getSellerCountryOfBranch(), this::setSellerCountryOfBranch);
			merger.mergeBasic(getSellerFirstName(), o.getSellerFirstName(), this::setSellerFirstName);
			merger.mergeBasic(getSellerSurname(), o.getSellerSurname(), this::setSellerSurname);
			merger.mergeBasic(getSellerDOB(), o.getSellerDOB(), this::setSellerDOB);
			merger.mergeBasic(getSellerDecisionMakerID(), o.getSellerDecisionMakerID(), this::setSellerDecisionMakerID);
			merger.mergeBasic(getSellerDecisionMakerIDType(), o.getSellerDecisionMakerIDType(), this::setSellerDecisionMakerIDType);
			merger.mergeBasic(getSellerDecisionMakerIDSubType(), o.getSellerDecisionMakerIDSubType(), this::setSellerDecisionMakerIDSubType);
			merger.mergeBasic(getSellerDecisionMakerFirstName(), o.getSellerDecisionMakerFirstName(), this::setSellerDecisionMakerFirstName);
			merger.mergeBasic(getSellerDecisionMakerSurname(), o.getSellerDecisionMakerSurname(), this::setSellerDecisionMakerSurname);
			merger.mergeBasic(getSellerDecisionMakerDOB(), o.getSellerDecisionMakerDOB(), this::setSellerDecisionMakerDOB);
			merger.mergeBasic(getOrderTransmissionIndicator(), o.getOrderTransmissionIndicator(), this::setOrderTransmissionIndicator);
			merger.mergeBasic(getBuyerTransmitterID(), o.getBuyerTransmitterID(), this::setBuyerTransmitterID);
			merger.mergeBasic(getSellerTransmitterID(), o.getSellerTransmitterID(), this::setSellerTransmitterID);
			merger.mergeBasic(getTradingDateTime(), o.getTradingDateTime(), this::setTradingDateTime);
			merger.mergeBasic(getTradingCapacity(), o.getTradingCapacity(), this::setTradingCapacity);
			merger.mergeBasic(getQuantity(), o.getQuantity(), this::setQuantity);
			merger.mergeBasic(getQuantityType(), o.getQuantityType(), this::setQuantityType);
			merger.mergeBasic(getQuantityCurrency(), o.getQuantityCurrency(), this::setQuantityCurrency);
			merger.mergeBasic(getDerivativeNotionalChange(), o.getDerivativeNotionalChange(), this::setDerivativeNotionalChange);
			merger.mergeBasic(getPrice(), o.getPrice(), this::setPrice);
			merger.mergeBasic(getPriceType(), o.getPriceType(), this::setPriceType);
			merger.mergeBasic(getPriceCurrency(), o.getPriceCurrency(), this::setPriceCurrency);
			merger.mergeBasic(getNetAmount(), o.getNetAmount(), this::setNetAmount);
			merger.mergeBasic(getVenue(), o.getVenue(), this::setVenue);
			merger.mergeBasic(getCountryOfBranch(), o.getCountryOfBranch(), this::setCountryOfBranch);
			merger.mergeBasic(getUpFrontPayment(), o.getUpFrontPayment(), this::setUpFrontPayment);
			merger.mergeBasic(getUpFrontPaymentCurrency(), o.getUpFrontPaymentCurrency(), this::setUpFrontPaymentCurrency);
			merger.mergeBasic(getComplexTradeComponentID(), o.getComplexTradeComponentID(), this::setComplexTradeComponentID);
			merger.mergeBasic(getInstrumentID(), o.getInstrumentID(), this::setInstrumentID);
			merger.mergeBasic(getInstrumentIDType(), o.getInstrumentIDType(), this::setInstrumentIDType);
			merger.mergeBasic(getInstrumentName(), o.getInstrumentName(), this::setInstrumentName);
			merger.mergeBasic(getInstrumentClassification(), o.getInstrumentClassification(), this::setInstrumentClassification);
			merger.mergeBasic(getNotionalCurrency1(), o.getNotionalCurrency1(), this::setNotionalCurrency1);
			merger.mergeBasic(getNotionalCurrency2Type(), o.getNotionalCurrency2Type(), this::setNotionalCurrency2Type);
			merger.mergeBasic(getNotionalCurrency2(), o.getNotionalCurrency2(), this::setNotionalCurrency2);
			merger.mergeBasic(getPriceMultiplier(), o.getPriceMultiplier(), this::setPriceMultiplier);
			merger.mergeBasic(getUvInstrumentClassification(), o.getUvInstrumentClassification(), this::setUvInstrumentClassification);
			merger.mergeBasic(getUnderlyingInstrumentID(), o.getUnderlyingInstrumentID(), this::setUnderlyingInstrumentID);
			merger.mergeBasic(getUvIndexClassification(), o.getUvIndexClassification(), this::setUvIndexClassification);
			merger.mergeBasic(getUnderlyingIndexID(), o.getUnderlyingIndexID(), this::setUnderlyingIndexID);
			merger.mergeBasic(getUnderlyingIndexName(), o.getUnderlyingIndexName(), this::setUnderlyingIndexName);
			merger.mergeBasic(getUnderlyingIndexTerm(), o.getUnderlyingIndexTerm(), this::setUnderlyingIndexTerm);
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getStrikePrice(), o.getStrikePrice(), this::setStrikePrice);
			merger.mergeBasic(getStrikePriceType(), o.getStrikePriceType(), this::setStrikePriceType);
			merger.mergeBasic(getStrikePriceCurrency(), o.getStrikePriceCurrency(), this::setStrikePriceCurrency);
			merger.mergeBasic(getOptionStyle(), o.getOptionStyle(), this::setOptionStyle);
			merger.mergeBasic(getMaturityDate(), o.getMaturityDate(), this::setMaturityDate);
			merger.mergeBasic(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			merger.mergeBasic(getInvestmentDecisionID(), o.getInvestmentDecisionID(), this::setInvestmentDecisionID);
			merger.mergeBasic(getInvestmentDecisionIDType(), o.getInvestmentDecisionIDType(), this::setInvestmentDecisionIDType);
			merger.mergeBasic(getInvestmentDecisionIDSubType(), o.getInvestmentDecisionIDSubType(), this::setInvestmentDecisionIDSubType);
			merger.mergeBasic(getInvestmentDecisionCountryOfBranch(), o.getInvestmentDecisionCountryOfBranch(), this::setInvestmentDecisionCountryOfBranch);
			merger.mergeBasic(getFirmExecutionID(), o.getFirmExecutionID(), this::setFirmExecutionID);
			merger.mergeBasic(getFirmExecutionIDType(), o.getFirmExecutionIDType(), this::setFirmExecutionIDType);
			merger.mergeBasic(getFirmExecutionIDSubType(), o.getFirmExecutionIDSubType(), this::setFirmExecutionIDSubType);
			merger.mergeBasic(getFirmExecutionCountryOfBranch(), o.getFirmExecutionCountryOfBranch(), this::setFirmExecutionCountryOfBranch);
			merger.mergeBasic(getWaiverIndicator(), o.getWaiverIndicator(), this::setWaiverIndicator);
			merger.mergeBasic(getShortSellingIndicator(), o.getShortSellingIndicator(), this::setShortSellingIndicator);
			merger.mergeBasic(getOtcPostTradeIndicator(), o.getOtcPostTradeIndicator(), this::setOtcPostTradeIndicator);
			merger.mergeBasic(getCommodityDerivativeIndicator(), o.getCommodityDerivativeIndicator(), this::setCommodityDerivativeIndicator);
			merger.mergeBasic(getSftIndicator(), o.getSftIndicator(), this::setSftIndicator);
			merger.mergeBasic(getDataCategory(), o.getDataCategory(), this::setDataCategory);
			merger.mergeBasic(getInternalClientIdentification(), o.getInternalClientIdentification(), this::setInternalClientIdentification);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MIFIRUnavistaCSVDocument _that = getType().cast(o);
		
			if (!Objects.equals(reportStatus, _that.getReportStatus())) return false;
			if (!Objects.equals(transactionReferenceNumber, _that.getTransactionReferenceNumber())) return false;
			if (!Objects.equals(venueTransactionID, _that.getVenueTransactionID())) return false;
			if (!Objects.equals(executingEntityID, _that.getExecutingEntityID())) return false;
			if (!Objects.equals(submittingEntityID, _that.getSubmittingEntityID())) return false;
			if (!Objects.equals(investmentFirmIndicator, _that.getInvestmentFirmIndicator())) return false;
			if (!Objects.equals(buyerID, _that.getBuyerID())) return false;
			if (!Objects.equals(buyerIDType, _that.getBuyerIDType())) return false;
			if (!Objects.equals(buyerIDSubType, _that.getBuyerIDSubType())) return false;
			if (!Objects.equals(buyerCountryOfBranch, _that.getBuyerCountryOfBranch())) return false;
			if (!Objects.equals(buyerFirstName, _that.getBuyerFirstName())) return false;
			if (!Objects.equals(buyerSurname, _that.getBuyerSurname())) return false;
			if (!Objects.equals(buyerDOB, _that.getBuyerDOB())) return false;
			if (!Objects.equals(buyerDecisionMakerID, _that.getBuyerDecisionMakerID())) return false;
			if (!Objects.equals(buyerDecisionMakerIDType, _that.getBuyerDecisionMakerIDType())) return false;
			if (!Objects.equals(buyerDecisionMakerIDSubType, _that.getBuyerDecisionMakerIDSubType())) return false;
			if (!Objects.equals(buyerDecisionMakerFirstName, _that.getBuyerDecisionMakerFirstName())) return false;
			if (!Objects.equals(buyerDecisionMakerSurname, _that.getBuyerDecisionMakerSurname())) return false;
			if (!Objects.equals(buyerDecisionMakerDOB, _that.getBuyerDecisionMakerDOB())) return false;
			if (!Objects.equals(sellerID, _that.getSellerID())) return false;
			if (!Objects.equals(sellerIDType, _that.getSellerIDType())) return false;
			if (!Objects.equals(sellerIDSubType, _that.getSellerIDSubType())) return false;
			if (!Objects.equals(sellerCountryOfBranch, _that.getSellerCountryOfBranch())) return false;
			if (!Objects.equals(sellerFirstName, _that.getSellerFirstName())) return false;
			if (!Objects.equals(sellerSurname, _that.getSellerSurname())) return false;
			if (!Objects.equals(sellerDOB, _that.getSellerDOB())) return false;
			if (!Objects.equals(sellerDecisionMakerID, _that.getSellerDecisionMakerID())) return false;
			if (!Objects.equals(sellerDecisionMakerIDType, _that.getSellerDecisionMakerIDType())) return false;
			if (!Objects.equals(sellerDecisionMakerIDSubType, _that.getSellerDecisionMakerIDSubType())) return false;
			if (!Objects.equals(sellerDecisionMakerFirstName, _that.getSellerDecisionMakerFirstName())) return false;
			if (!Objects.equals(sellerDecisionMakerSurname, _that.getSellerDecisionMakerSurname())) return false;
			if (!Objects.equals(sellerDecisionMakerDOB, _that.getSellerDecisionMakerDOB())) return false;
			if (!Objects.equals(orderTransmissionIndicator, _that.getOrderTransmissionIndicator())) return false;
			if (!Objects.equals(buyerTransmitterID, _that.getBuyerTransmitterID())) return false;
			if (!Objects.equals(sellerTransmitterID, _that.getSellerTransmitterID())) return false;
			if (!Objects.equals(tradingDateTime, _that.getTradingDateTime())) return false;
			if (!Objects.equals(tradingCapacity, _that.getTradingCapacity())) return false;
			if (!Objects.equals(quantity, _that.getQuantity())) return false;
			if (!Objects.equals(quantityType, _that.getQuantityType())) return false;
			if (!Objects.equals(quantityCurrency, _that.getQuantityCurrency())) return false;
			if (!Objects.equals(derivativeNotionalChange, _that.getDerivativeNotionalChange())) return false;
			if (!Objects.equals(price, _that.getPrice())) return false;
			if (!Objects.equals(priceType, _that.getPriceType())) return false;
			if (!Objects.equals(priceCurrency, _that.getPriceCurrency())) return false;
			if (!Objects.equals(netAmount, _that.getNetAmount())) return false;
			if (!Objects.equals(venue, _that.getVenue())) return false;
			if (!Objects.equals(countryOfBranch, _that.getCountryOfBranch())) return false;
			if (!Objects.equals(upFrontPayment, _that.getUpFrontPayment())) return false;
			if (!Objects.equals(upFrontPaymentCurrency, _that.getUpFrontPaymentCurrency())) return false;
			if (!Objects.equals(complexTradeComponentID, _that.getComplexTradeComponentID())) return false;
			if (!Objects.equals(instrumentID, _that.getInstrumentID())) return false;
			if (!Objects.equals(instrumentIDType, _that.getInstrumentIDType())) return false;
			if (!Objects.equals(instrumentName, _that.getInstrumentName())) return false;
			if (!Objects.equals(instrumentClassification, _that.getInstrumentClassification())) return false;
			if (!Objects.equals(notionalCurrency1, _that.getNotionalCurrency1())) return false;
			if (!Objects.equals(notionalCurrency2Type, _that.getNotionalCurrency2Type())) return false;
			if (!Objects.equals(notionalCurrency2, _that.getNotionalCurrency2())) return false;
			if (!Objects.equals(priceMultiplier, _that.getPriceMultiplier())) return false;
			if (!Objects.equals(uvInstrumentClassification, _that.getUvInstrumentClassification())) return false;
			if (!Objects.equals(underlyingInstrumentID, _that.getUnderlyingInstrumentID())) return false;
			if (!Objects.equals(uvIndexClassification, _that.getUvIndexClassification())) return false;
			if (!Objects.equals(underlyingIndexID, _that.getUnderlyingIndexID())) return false;
			if (!Objects.equals(underlyingIndexName, _that.getUnderlyingIndexName())) return false;
			if (!Objects.equals(underlyingIndexTerm, _that.getUnderlyingIndexTerm())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(strikePrice, _that.getStrikePrice())) return false;
			if (!Objects.equals(strikePriceType, _that.getStrikePriceType())) return false;
			if (!Objects.equals(strikePriceCurrency, _that.getStrikePriceCurrency())) return false;
			if (!Objects.equals(optionStyle, _that.getOptionStyle())) return false;
			if (!Objects.equals(maturityDate, _that.getMaturityDate())) return false;
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(investmentDecisionID, _that.getInvestmentDecisionID())) return false;
			if (!Objects.equals(investmentDecisionIDType, _that.getInvestmentDecisionIDType())) return false;
			if (!Objects.equals(investmentDecisionIDSubType, _that.getInvestmentDecisionIDSubType())) return false;
			if (!Objects.equals(investmentDecisionCountryOfBranch, _that.getInvestmentDecisionCountryOfBranch())) return false;
			if (!Objects.equals(firmExecutionID, _that.getFirmExecutionID())) return false;
			if (!Objects.equals(firmExecutionIDType, _that.getFirmExecutionIDType())) return false;
			if (!Objects.equals(firmExecutionIDSubType, _that.getFirmExecutionIDSubType())) return false;
			if (!Objects.equals(firmExecutionCountryOfBranch, _that.getFirmExecutionCountryOfBranch())) return false;
			if (!Objects.equals(waiverIndicator, _that.getWaiverIndicator())) return false;
			if (!Objects.equals(shortSellingIndicator, _that.getShortSellingIndicator())) return false;
			if (!Objects.equals(otcPostTradeIndicator, _that.getOtcPostTradeIndicator())) return false;
			if (!Objects.equals(commodityDerivativeIndicator, _that.getCommodityDerivativeIndicator())) return false;
			if (!Objects.equals(sftIndicator, _that.getSftIndicator())) return false;
			if (!Objects.equals(dataCategory, _that.getDataCategory())) return false;
			if (!Objects.equals(internalClientIdentification, _that.getInternalClientIdentification())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (reportStatus != null ? reportStatus.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (transactionReferenceNumber != null ? transactionReferenceNumber.hashCode() : 0);
			_result = 31 * _result + (venueTransactionID != null ? venueTransactionID.hashCode() : 0);
			_result = 31 * _result + (executingEntityID != null ? executingEntityID.hashCode() : 0);
			_result = 31 * _result + (submittingEntityID != null ? submittingEntityID.hashCode() : 0);
			_result = 31 * _result + (investmentFirmIndicator != null ? investmentFirmIndicator.hashCode() : 0);
			_result = 31 * _result + (buyerID != null ? buyerID.hashCode() : 0);
			_result = 31 * _result + (buyerIDType != null ? buyerIDType.hashCode() : 0);
			_result = 31 * _result + (buyerIDSubType != null ? buyerIDSubType.hashCode() : 0);
			_result = 31 * _result + (buyerCountryOfBranch != null ? buyerCountryOfBranch.hashCode() : 0);
			_result = 31 * _result + (buyerFirstName != null ? buyerFirstName.hashCode() : 0);
			_result = 31 * _result + (buyerSurname != null ? buyerSurname.hashCode() : 0);
			_result = 31 * _result + (buyerDOB != null ? buyerDOB.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerID != null ? buyerDecisionMakerID.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerIDType != null ? buyerDecisionMakerIDType.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerIDSubType != null ? buyerDecisionMakerIDSubType.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerFirstName != null ? buyerDecisionMakerFirstName.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerSurname != null ? buyerDecisionMakerSurname.hashCode() : 0);
			_result = 31 * _result + (buyerDecisionMakerDOB != null ? buyerDecisionMakerDOB.hashCode() : 0);
			_result = 31 * _result + (sellerID != null ? sellerID.hashCode() : 0);
			_result = 31 * _result + (sellerIDType != null ? sellerIDType.hashCode() : 0);
			_result = 31 * _result + (sellerIDSubType != null ? sellerIDSubType.hashCode() : 0);
			_result = 31 * _result + (sellerCountryOfBranch != null ? sellerCountryOfBranch.hashCode() : 0);
			_result = 31 * _result + (sellerFirstName != null ? sellerFirstName.hashCode() : 0);
			_result = 31 * _result + (sellerSurname != null ? sellerSurname.hashCode() : 0);
			_result = 31 * _result + (sellerDOB != null ? sellerDOB.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerID != null ? sellerDecisionMakerID.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerIDType != null ? sellerDecisionMakerIDType.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerIDSubType != null ? sellerDecisionMakerIDSubType.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerFirstName != null ? sellerDecisionMakerFirstName.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerSurname != null ? sellerDecisionMakerSurname.hashCode() : 0);
			_result = 31 * _result + (sellerDecisionMakerDOB != null ? sellerDecisionMakerDOB.hashCode() : 0);
			_result = 31 * _result + (orderTransmissionIndicator != null ? orderTransmissionIndicator.hashCode() : 0);
			_result = 31 * _result + (buyerTransmitterID != null ? buyerTransmitterID.hashCode() : 0);
			_result = 31 * _result + (sellerTransmitterID != null ? sellerTransmitterID.hashCode() : 0);
			_result = 31 * _result + (tradingDateTime != null ? tradingDateTime.hashCode() : 0);
			_result = 31 * _result + (tradingCapacity != null ? tradingCapacity.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantity != null ? quantity.hashCode() : 0);
			_result = 31 * _result + (quantityType != null ? quantityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (quantityCurrency != null ? quantityCurrency.hashCode() : 0);
			_result = 31 * _result + (derivativeNotionalChange != null ? derivativeNotionalChange.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (price != null ? price.hashCode() : 0);
			_result = 31 * _result + (priceType != null ? priceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (priceCurrency != null ? priceCurrency.hashCode() : 0);
			_result = 31 * _result + (netAmount != null ? netAmount.hashCode() : 0);
			_result = 31 * _result + (venue != null ? venue.hashCode() : 0);
			_result = 31 * _result + (countryOfBranch != null ? countryOfBranch.hashCode() : 0);
			_result = 31 * _result + (upFrontPayment != null ? upFrontPayment.hashCode() : 0);
			_result = 31 * _result + (upFrontPaymentCurrency != null ? upFrontPaymentCurrency.hashCode() : 0);
			_result = 31 * _result + (complexTradeComponentID != null ? complexTradeComponentID.hashCode() : 0);
			_result = 31 * _result + (instrumentID != null ? instrumentID.hashCode() : 0);
			_result = 31 * _result + (instrumentIDType != null ? instrumentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (instrumentName != null ? instrumentName.hashCode() : 0);
			_result = 31 * _result + (instrumentClassification != null ? instrumentClassification.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency1 != null ? notionalCurrency1.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency2Type != null ? notionalCurrency2Type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (notionalCurrency2 != null ? notionalCurrency2.hashCode() : 0);
			_result = 31 * _result + (priceMultiplier != null ? priceMultiplier.hashCode() : 0);
			_result = 31 * _result + (uvInstrumentClassification != null ? uvInstrumentClassification.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentID != null ? underlyingInstrumentID.hashCode() : 0);
			_result = 31 * _result + (uvIndexClassification != null ? uvIndexClassification.hashCode() : 0);
			_result = 31 * _result + (underlyingIndexID != null ? underlyingIndexID.hashCode() : 0);
			_result = 31 * _result + (underlyingIndexName != null ? underlyingIndexName.hashCode() : 0);
			_result = 31 * _result + (underlyingIndexTerm != null ? underlyingIndexTerm.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikePrice != null ? strikePrice.hashCode() : 0);
			_result = 31 * _result + (strikePriceType != null ? strikePriceType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (strikePriceCurrency != null ? strikePriceCurrency.hashCode() : 0);
			_result = 31 * _result + (optionStyle != null ? optionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (maturityDate != null ? maturityDate.hashCode() : 0);
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (investmentDecisionID != null ? investmentDecisionID.hashCode() : 0);
			_result = 31 * _result + (investmentDecisionIDType != null ? investmentDecisionIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (investmentDecisionIDSubType != null ? investmentDecisionIDSubType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (investmentDecisionCountryOfBranch != null ? investmentDecisionCountryOfBranch.hashCode() : 0);
			_result = 31 * _result + (firmExecutionID != null ? firmExecutionID.hashCode() : 0);
			_result = 31 * _result + (firmExecutionIDType != null ? firmExecutionIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (firmExecutionIDSubType != null ? firmExecutionIDSubType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (firmExecutionCountryOfBranch != null ? firmExecutionCountryOfBranch.hashCode() : 0);
			_result = 31 * _result + (waiverIndicator != null ? waiverIndicator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (shortSellingIndicator != null ? shortSellingIndicator.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otcPostTradeIndicator != null ? otcPostTradeIndicator.hashCode() : 0);
			_result = 31 * _result + (commodityDerivativeIndicator != null ? commodityDerivativeIndicator.hashCode() : 0);
			_result = 31 * _result + (sftIndicator != null ? sftIndicator.hashCode() : 0);
			_result = 31 * _result + (dataCategory != null ? dataCategory.hashCode() : 0);
			_result = 31 * _result + (internalClientIdentification != null ? internalClientIdentification.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MIFIRUnavistaCSVDocumentBuilder {" +
				"reportStatus=" + this.reportStatus + ", " +
				"transactionReferenceNumber=" + this.transactionReferenceNumber + ", " +
				"venueTransactionID=" + this.venueTransactionID + ", " +
				"executingEntityID=" + this.executingEntityID + ", " +
				"submittingEntityID=" + this.submittingEntityID + ", " +
				"investmentFirmIndicator=" + this.investmentFirmIndicator + ", " +
				"buyerID=" + this.buyerID + ", " +
				"buyerIDType=" + this.buyerIDType + ", " +
				"buyerIDSubType=" + this.buyerIDSubType + ", " +
				"buyerCountryOfBranch=" + this.buyerCountryOfBranch + ", " +
				"buyerFirstName=" + this.buyerFirstName + ", " +
				"buyerSurname=" + this.buyerSurname + ", " +
				"buyerDOB=" + this.buyerDOB + ", " +
				"buyerDecisionMakerID=" + this.buyerDecisionMakerID + ", " +
				"buyerDecisionMakerIDType=" + this.buyerDecisionMakerIDType + ", " +
				"buyerDecisionMakerIDSubType=" + this.buyerDecisionMakerIDSubType + ", " +
				"buyerDecisionMakerFirstName=" + this.buyerDecisionMakerFirstName + ", " +
				"buyerDecisionMakerSurname=" + this.buyerDecisionMakerSurname + ", " +
				"buyerDecisionMakerDOB=" + this.buyerDecisionMakerDOB + ", " +
				"sellerID=" + this.sellerID + ", " +
				"sellerIDType=" + this.sellerIDType + ", " +
				"sellerIDSubType=" + this.sellerIDSubType + ", " +
				"sellerCountryOfBranch=" + this.sellerCountryOfBranch + ", " +
				"sellerFirstName=" + this.sellerFirstName + ", " +
				"sellerSurname=" + this.sellerSurname + ", " +
				"sellerDOB=" + this.sellerDOB + ", " +
				"sellerDecisionMakerID=" + this.sellerDecisionMakerID + ", " +
				"sellerDecisionMakerIDType=" + this.sellerDecisionMakerIDType + ", " +
				"sellerDecisionMakerIDSubType=" + this.sellerDecisionMakerIDSubType + ", " +
				"sellerDecisionMakerFirstName=" + this.sellerDecisionMakerFirstName + ", " +
				"sellerDecisionMakerSurname=" + this.sellerDecisionMakerSurname + ", " +
				"sellerDecisionMakerDOB=" + this.sellerDecisionMakerDOB + ", " +
				"orderTransmissionIndicator=" + this.orderTransmissionIndicator + ", " +
				"buyerTransmitterID=" + this.buyerTransmitterID + ", " +
				"sellerTransmitterID=" + this.sellerTransmitterID + ", " +
				"tradingDateTime=" + this.tradingDateTime + ", " +
				"tradingCapacity=" + this.tradingCapacity + ", " +
				"quantity=" + this.quantity + ", " +
				"quantityType=" + this.quantityType + ", " +
				"quantityCurrency=" + this.quantityCurrency + ", " +
				"derivativeNotionalChange=" + this.derivativeNotionalChange + ", " +
				"price=" + this.price + ", " +
				"priceType=" + this.priceType + ", " +
				"priceCurrency=" + this.priceCurrency + ", " +
				"netAmount=" + this.netAmount + ", " +
				"venue=" + this.venue + ", " +
				"countryOfBranch=" + this.countryOfBranch + ", " +
				"upFrontPayment=" + this.upFrontPayment + ", " +
				"upFrontPaymentCurrency=" + this.upFrontPaymentCurrency + ", " +
				"complexTradeComponentID=" + this.complexTradeComponentID + ", " +
				"instrumentID=" + this.instrumentID + ", " +
				"instrumentIDType=" + this.instrumentIDType + ", " +
				"instrumentName=" + this.instrumentName + ", " +
				"instrumentClassification=" + this.instrumentClassification + ", " +
				"notionalCurrency1=" + this.notionalCurrency1 + ", " +
				"notionalCurrency2Type=" + this.notionalCurrency2Type + ", " +
				"notionalCurrency2=" + this.notionalCurrency2 + ", " +
				"priceMultiplier=" + this.priceMultiplier + ", " +
				"uvInstrumentClassification=" + this.uvInstrumentClassification + ", " +
				"underlyingInstrumentID=" + this.underlyingInstrumentID + ", " +
				"uvIndexClassification=" + this.uvIndexClassification + ", " +
				"underlyingIndexID=" + this.underlyingIndexID + ", " +
				"underlyingIndexName=" + this.underlyingIndexName + ", " +
				"underlyingIndexTerm=" + this.underlyingIndexTerm + ", " +
				"optionType=" + this.optionType + ", " +
				"strikePrice=" + this.strikePrice + ", " +
				"strikePriceType=" + this.strikePriceType + ", " +
				"strikePriceCurrency=" + this.strikePriceCurrency + ", " +
				"optionStyle=" + this.optionStyle + ", " +
				"maturityDate=" + this.maturityDate + ", " +
				"expiryDate=" + this.expiryDate + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"investmentDecisionID=" + this.investmentDecisionID + ", " +
				"investmentDecisionIDType=" + this.investmentDecisionIDType + ", " +
				"investmentDecisionIDSubType=" + this.investmentDecisionIDSubType + ", " +
				"investmentDecisionCountryOfBranch=" + this.investmentDecisionCountryOfBranch + ", " +
				"firmExecutionID=" + this.firmExecutionID + ", " +
				"firmExecutionIDType=" + this.firmExecutionIDType + ", " +
				"firmExecutionIDSubType=" + this.firmExecutionIDSubType + ", " +
				"firmExecutionCountryOfBranch=" + this.firmExecutionCountryOfBranch + ", " +
				"waiverIndicator=" + this.waiverIndicator + ", " +
				"shortSellingIndicator=" + this.shortSellingIndicator + ", " +
				"otcPostTradeIndicator=" + this.otcPostTradeIndicator + ", " +
				"commodityDerivativeIndicator=" + this.commodityDerivativeIndicator + ", " +
				"sftIndicator=" + this.sftIndicator + ", " +
				"dataCategory=" + this.dataCategory + ", " +
				"internalClientIdentification=" + this.internalClientIdentification +
			'}';
		}
	}
}
