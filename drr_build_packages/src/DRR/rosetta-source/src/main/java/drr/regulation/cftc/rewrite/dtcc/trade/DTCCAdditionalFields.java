package drr.regulation.cftc.rewrite.dtcc.trade;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import drr.regulation.cftc.rewrite.dtcc.trade.meta.DTCCAdditionalFieldsMeta;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.dtcc.trade.CommonDTCCAdditionalFields;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import drr.regulation.common.dtcc.trade.UnderlyingAssetReport;
import drr.standards.iso.OptionStyleEnum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="DTCCAdditionalFields", builder=DTCCAdditionalFields.DTCCAdditionalFieldsBuilderImpl.class, version="7.7.0")
@RuneDataType(value="DTCCAdditionalFields", model="drr", builder=DTCCAdditionalFields.DTCCAdditionalFieldsBuilderImpl.class, version="7.7.0")
public interface DTCCAdditionalFields extends CommonDTCCAdditionalFields {

	DTCCAdditionalFieldsMeta metaData = new DTCCAdditionalFieldsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Trade Party 1 - ID Type"
	 *
	 * Provision GTR required Control Field.
	 *
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Trade Party 1 - ID Type"
	 *
	 * Provision NPID is only accepted when [CDE - Platform Identifier] is not 'XXXX', 'XOFF', or 'BILT' and [Clearing Status] = I.
	 *
	 */
	String getTradeParty1IDType();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Message ID"
	 *
	 * Provision Purpose of this field is to allow firms to submit a unique ID that will allow them to tie in specific submissions/modifications. For example if 5 modifications are submitted on a specific PET, this will allow the firm to ensure they receive responses for all 5 modifications.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup EUUKNAPeerReviewGroup ISDA EU/UK/North America Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended EU/UK EMIR and North America transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20250604" * field "Message ID"
	 *
	 * Provision Each Message ID must be unique, irrespective of the report type. This unique identification is achieved by concatenating with the Reporting Timestamp field.
	 *
	 */
	String getMessageID();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Leg 1 - Commodity Underlyer ID"
	 *
	 * Provision UPI RDL: An identifier that can be used to determine the asset(s), index (indices) or benchmark underlying a contract.
	 *
	 */
	String getLeg1CommodityUnderlyerID();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Leg 2 - Commodity Underlyer ID"
	 *
	 * Provision UPI RDL: An identifier that can be used to determine the asset(s), index (indices) or benchmark underlying a contract.
	 *
	 */
	String getLeg2CommodityUnderlyerID();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Change in Notional Amount 1"
	 *
	 * Provision For each leg of the transaction, where applicable: Change in Notional Amount 1 (See Inbound field Notional Amount 1). This field will be used for calculating the Large notional off-facility swap election indicator if it is left blank.
	 *
	 */
	BigDecimal getChangeInNotionalAmount1();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Change in Notional Amount 2"
	 *
	 * Provision For each leg of the transaction, where applicable: Change in Notional Amount 2 (See Inbound field Notional Amount 2). This field will be used for calculating the Large notional off-facility swap election indicator if it is left blank.
	 *
	 */
	BigDecimal getChangeInNotionalAmount2();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Large Notional Off-facility Swap Election Indicator"
	 *
	 * Provision Indicator of whether an election has been made to report the swap transaction as a Large Notional Off-facility Swap by the reporting counterparty or as calculated by either the swap data repository acting on behalf of the reporting counterparty or by using a third party.
	 *
	 */
	Boolean getLargeNotionalOffFacilitySwapElectionIndicator();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Mandatory Clearing Indicator"
	 *
	 * Provision An indicator of whether the transaction is subject to mandatory clearing.
	 *
	 */
	Boolean getMandatoryClearingIndicator();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Message Type"
	 *
	 * Provision Need to indicate what message is being submitted to GTR.
	 *
	 */
	String getMessageType();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Original Swap SDR - ID Type"
	 *
	 * Provision GTR Control Field.
	 *
	 */
	PartyIdentifierTypeEnum getOriginalSwapSDRIDType();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Physical Commodity Contract Indicator"
	 *
	 * Provision An indication of whether or not the trade being submitted:
	             (1) references one of the contracts described in Appendix B to part 43; or 
	             (2) is economically related to one of the contracts described in Appendix B to part 43.
	 *
	 */
	Boolean getPhysicalCommodityContractIndicator();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "SD MSP Indicator - Counterparty 1"
	 *
	 * Provision Indicator of whether counterparty 1 is SD or MSP.
	 *
	 */
	Boolean getSdMspIndicatorCounterparty1();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "SD MSP Indicator - Counterparty 2"
	 *
	 * Provision Indicator of whether counterparty 2 is SD or MSP.
	 *
	 */
	Boolean getSdMspIndicatorCounterparty2();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "SEF or DCM Indicator"
	 *
	 * Provision An indication of whether the swap was executed on or pursuant to the rules of a swap execution facility or designated contract market.
	 *
	 */
	Boolean getSefOrDcmIndicator();
	/**
	 *
	 * Body CFTC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CFTC." 
	 * field "Version"
	 *
	 * Provision Memo field. Used to identify the asset class and template type of submission.
	 *
	 */
	String getVersion();

	/*********************** Build Methods  ***********************/
	DTCCAdditionalFields build();
	
	DTCCAdditionalFields.DTCCAdditionalFieldsBuilder toBuilder();
	
	static DTCCAdditionalFields.DTCCAdditionalFieldsBuilder builder() {
		return new DTCCAdditionalFields.DTCCAdditionalFieldsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DTCCAdditionalFields> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DTCCAdditionalFields> getType() {
		return DTCCAdditionalFields.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("clearingVenueIDType"), PartyIdentifierTypeEnum.class, getClearingVenueIDType(), this);
		processor.processBasic(path.newSubPath("tradeParty1ClearingBrokerIDType"), PartyIdentifierTypeEnum.class, getTradeParty1ClearingBrokerIDType(), this);
		processor.processBasic(path.newSubPath("submittingPartyIDType"), PartyIdentifierTypeEnum.class, getSubmittingPartyIDType(), this);
		processor.processBasic(path.newSubPath("submittedForParty"), String.class, getSubmittedForParty(), this);
		processor.processBasic(path.newSubPath("tradeLegTypes"), String.class, getTradeLegTypes(), this);
		processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty1ReportingDestination(), this);
		processor.processBasic(path.newSubPath("tradeParty2ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty2ReportingDestination(), this);
		processor.processBasic(path.newSubPath("primaryAssetClass"), AssetClassEnum.class, getPrimaryAssetClass(), this);
		processor.processBasic(path.newSubPath("secondaryAssetClass"), AssetClassEnum.class, getSecondaryAssetClass(), this);
		processor.processBasic(path.newSubPath("comment1"), String.class, getComment1(), this);
		processor.processBasic(path.newSubPath("optionStyle"), OptionStyleEnum.class, getOptionStyle(), this);
		processor.processBasic(path.newSubPath("optionType"), String.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("productID"), String.class, getProductID(), this);
		processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentID"), String.class, getTradeParty2ExecutionAgentID(), this);
		processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentIDType"), PartyIdentifierTypeEnum.class, getTradeParty2ExecutionAgentIDType(), this);
		processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentID"), String.class, getTradeParty1ExecutionAgentID(), this);
		processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentIDType"), PartyIdentifierTypeEnum.class, getTradeParty1ExecutionAgentIDType(), this);
		processor.processBasic(path.newSubPath("tradeParty1TransactionID"), String.class, getTradeParty1TransactionID(), this);
		processor.processBasic(path.newSubPath("settlementType"), String.class, getSettlementType(), this);
		processRosetta(path.newSubPath("productGrade"), processor, ProductGradeReport.class, getProductGrade());
		processor.processBasic(path.newSubPath("deliveryLocation"), String.class, getDeliveryLocation(), this);
		processor.processBasic(path.newSubPath("leg1CommodityInstrumentID"), String.class, getLeg1CommodityInstrumentID(), this);
		processor.processBasic(path.newSubPath("leg2CommodityInstrumentID"), String.class, getLeg2CommodityInstrumentID(), this);
		processor.processBasic(path.newSubPath("responsibleDataSubmitterIDType"), PartyIdentifierTypeEnum.class, getResponsibleDataSubmitterIDType(), this);
		processor.processBasic(path.newSubPath("responsibleDataSubmitterID"), String.class, getResponsibleDataSubmitterID(), this);
		processor.processBasic(path.newSubPath("maturityDateOfTheUnderlying"), Date.class, getMaturityDateOfTheUnderlying(), this);
		processor.processBasic(path.newSubPath("corporateActionNewTradeParty1Lei"), String.class, getCorporateActionNewTradeParty1Lei(), this);
		processor.processBasic(path.newSubPath("otherPaymentPayerIDType"), String.class, getOtherPaymentPayerIDType(), this);
		processor.processBasic(path.newSubPath("otherPaymentReceiverIDType"), String.class, getOtherPaymentReceiverIDType(), this);
		processor.processBasic(path.newSubPath("sefOrDcmAnonymousExecutionIndicator"), Boolean.class, getSefOrDcmAnonymousExecutionIndicator(), this);
		processor.processBasic(path.newSubPath("executionVenueID"), String.class, getExecutionVenueID(), this);
		processor.processBasic(path.newSubPath("executionVenueIDType"), PartyIdentifierTypeEnum.class, getExecutionVenueIDType(), this);
		processor.processBasic(path.newSubPath("leg1FloatingRateIndex"), String.class, getLeg1FloatingRateIndex(), this);
		processor.processBasic(path.newSubPath("leg2FloatingRateIndex"), String.class, getLeg2FloatingRateIndex(), this);
		processor.processBasic(path.newSubPath("underlyingAssetName"), String.class, getUnderlyingAssetName(), this);
		processRosetta(path.newSubPath("underlyingAsset"), processor, UnderlyingAssetReport.class, getUnderlyingAsset());
		processor.processBasic(path.newSubPath("tradeParty1IDType"), String.class, getTradeParty1IDType(), this);
		processor.processBasic(path.newSubPath("messageID"), String.class, getMessageID(), this);
		processor.processBasic(path.newSubPath("leg1CommodityUnderlyerID"), String.class, getLeg1CommodityUnderlyerID(), this);
		processor.processBasic(path.newSubPath("leg2CommodityUnderlyerID"), String.class, getLeg2CommodityUnderlyerID(), this);
		processor.processBasic(path.newSubPath("changeInNotionalAmount1"), BigDecimal.class, getChangeInNotionalAmount1(), this);
		processor.processBasic(path.newSubPath("changeInNotionalAmount2"), BigDecimal.class, getChangeInNotionalAmount2(), this);
		processor.processBasic(path.newSubPath("largeNotionalOffFacilitySwapElectionIndicator"), Boolean.class, getLargeNotionalOffFacilitySwapElectionIndicator(), this);
		processor.processBasic(path.newSubPath("mandatoryClearingIndicator"), Boolean.class, getMandatoryClearingIndicator(), this);
		processor.processBasic(path.newSubPath("messageType"), String.class, getMessageType(), this);
		processor.processBasic(path.newSubPath("originalSwapSDRIDType"), PartyIdentifierTypeEnum.class, getOriginalSwapSDRIDType(), this);
		processor.processBasic(path.newSubPath("physicalCommodityContractIndicator"), Boolean.class, getPhysicalCommodityContractIndicator(), this);
		processor.processBasic(path.newSubPath("sdMspIndicatorCounterparty1"), Boolean.class, getSdMspIndicatorCounterparty1(), this);
		processor.processBasic(path.newSubPath("sdMspIndicatorCounterparty2"), Boolean.class, getSdMspIndicatorCounterparty2(), this);
		processor.processBasic(path.newSubPath("sefOrDcmIndicator"), Boolean.class, getSefOrDcmIndicator(), this);
		processor.processBasic(path.newSubPath("version"), String.class, getVersion(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DTCCAdditionalFieldsBuilder extends DTCCAdditionalFields, CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder {
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setClearingVenueIDType(PartyIdentifierTypeEnum clearingVenueIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1ClearingBrokerIDType(PartyIdentifierTypeEnum tradeParty1ClearingBrokerIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum submittingPartyIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSubmittedForParty(String submittedForParty);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeLegTypes(String tradeLegTypes);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination, int idx);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum tradeParty2ReportingDestination);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum tradeParty2ReportingDestination, int idx);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestination);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestination);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setPrimaryAssetClass(AssetClassEnum primaryAssetClass);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSecondaryAssetClass(AssetClassEnum secondaryAssetClass);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setComment1(String comment1);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOptionStyle(OptionStyleEnum optionStyle);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOptionType(String optionType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setProductID(String productID);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty2ExecutionAgentID(String tradeParty2ExecutionAgentID);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty2ExecutionAgentIDType(PartyIdentifierTypeEnum tradeParty2ExecutionAgentIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1ExecutionAgentID(String tradeParty1ExecutionAgentID);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1ExecutionAgentIDType(PartyIdentifierTypeEnum tradeParty1ExecutionAgentIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1TransactionID(String tradeParty1TransactionID);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSettlementType(String settlementType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addProductGrade(ProductGradeReport productGrade);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addProductGrade(ProductGradeReport productGrade, int idx);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addProductGrade(List<? extends ProductGradeReport> productGrade);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setProductGrade(List<? extends ProductGradeReport> productGrade);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setDeliveryLocation(String deliveryLocation);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg1CommodityInstrumentID(String leg1CommodityInstrumentID);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg2CommodityInstrumentID(String leg2CommodityInstrumentID);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setResponsibleDataSubmitterIDType(PartyIdentifierTypeEnum responsibleDataSubmitterIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setResponsibleDataSubmitterID(String responsibleDataSubmitterID);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMaturityDateOfTheUnderlying(Date maturityDateOfTheUnderlying);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setCorporateActionNewTradeParty1Lei(String corporateActionNewTradeParty1Lei);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(String otherPaymentPayerIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(String otherPaymentPayerIDType, int idx);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(List<String> otherPaymentPayerIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOtherPaymentPayerIDType(List<String> otherPaymentPayerIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(String otherPaymentReceiverIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(String otherPaymentReceiverIDType, int idx);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(List<String> otherPaymentReceiverIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOtherPaymentReceiverIDType(List<String> otherPaymentReceiverIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSefOrDcmAnonymousExecutionIndicator(Boolean sefOrDcmAnonymousExecutionIndicator);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setExecutionVenueID(String executionVenueID);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setExecutionVenueIDType(PartyIdentifierTypeEnum executionVenueIDType);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg1FloatingRateIndex(String leg1FloatingRateIndex);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg2FloatingRateIndex(String leg2FloatingRateIndex);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAssetName(String underlyingAssetName);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAssetName(String underlyingAssetName, int idx);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAssetName(List<String> underlyingAssetName);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setUnderlyingAssetName(List<String> underlyingAssetName);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAsset(UnderlyingAssetReport underlyingAsset);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAsset(UnderlyingAssetReport underlyingAsset, int idx);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAsset(List<? extends UnderlyingAssetReport> underlyingAsset);
		@Override
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setUnderlyingAsset(List<? extends UnderlyingAssetReport> underlyingAsset);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1IDType(String tradeParty1IDType);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMessageID(String messageID);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg1CommodityUnderlyerID(String leg1CommodityUnderlyerID);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg2CommodityUnderlyerID(String leg2CommodityUnderlyerID);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setChangeInNotionalAmount1(BigDecimal changeInNotionalAmount1);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setChangeInNotionalAmount2(BigDecimal changeInNotionalAmount2);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLargeNotionalOffFacilitySwapElectionIndicator(Boolean largeNotionalOffFacilitySwapElectionIndicator);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMandatoryClearingIndicator(Boolean mandatoryClearingIndicator);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMessageType(String messageType);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOriginalSwapSDRIDType(PartyIdentifierTypeEnum originalSwapSDRIDType);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setPhysicalCommodityContractIndicator(Boolean physicalCommodityContractIndicator);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSdMspIndicatorCounterparty1(Boolean sdMspIndicatorCounterparty1);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSdMspIndicatorCounterparty2(Boolean sdMspIndicatorCounterparty2);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSefOrDcmIndicator(Boolean sefOrDcmIndicator);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setVersion(String version);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("clearingVenueIDType"), PartyIdentifierTypeEnum.class, getClearingVenueIDType(), this);
			processor.processBasic(path.newSubPath("tradeParty1ClearingBrokerIDType"), PartyIdentifierTypeEnum.class, getTradeParty1ClearingBrokerIDType(), this);
			processor.processBasic(path.newSubPath("submittingPartyIDType"), PartyIdentifierTypeEnum.class, getSubmittingPartyIDType(), this);
			processor.processBasic(path.newSubPath("submittedForParty"), String.class, getSubmittedForParty(), this);
			processor.processBasic(path.newSubPath("tradeLegTypes"), String.class, getTradeLegTypes(), this);
			processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty1ReportingDestination(), this);
			processor.processBasic(path.newSubPath("tradeParty2ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty2ReportingDestination(), this);
			processor.processBasic(path.newSubPath("primaryAssetClass"), AssetClassEnum.class, getPrimaryAssetClass(), this);
			processor.processBasic(path.newSubPath("secondaryAssetClass"), AssetClassEnum.class, getSecondaryAssetClass(), this);
			processor.processBasic(path.newSubPath("comment1"), String.class, getComment1(), this);
			processor.processBasic(path.newSubPath("optionStyle"), OptionStyleEnum.class, getOptionStyle(), this);
			processor.processBasic(path.newSubPath("optionType"), String.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("productID"), String.class, getProductID(), this);
			processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentID"), String.class, getTradeParty2ExecutionAgentID(), this);
			processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentIDType"), PartyIdentifierTypeEnum.class, getTradeParty2ExecutionAgentIDType(), this);
			processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentID"), String.class, getTradeParty1ExecutionAgentID(), this);
			processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentIDType"), PartyIdentifierTypeEnum.class, getTradeParty1ExecutionAgentIDType(), this);
			processor.processBasic(path.newSubPath("tradeParty1TransactionID"), String.class, getTradeParty1TransactionID(), this);
			processor.processBasic(path.newSubPath("settlementType"), String.class, getSettlementType(), this);
			processRosetta(path.newSubPath("productGrade"), processor, ProductGradeReport.ProductGradeReportBuilder.class, getProductGrade());
			processor.processBasic(path.newSubPath("deliveryLocation"), String.class, getDeliveryLocation(), this);
			processor.processBasic(path.newSubPath("leg1CommodityInstrumentID"), String.class, getLeg1CommodityInstrumentID(), this);
			processor.processBasic(path.newSubPath("leg2CommodityInstrumentID"), String.class, getLeg2CommodityInstrumentID(), this);
			processor.processBasic(path.newSubPath("responsibleDataSubmitterIDType"), PartyIdentifierTypeEnum.class, getResponsibleDataSubmitterIDType(), this);
			processor.processBasic(path.newSubPath("responsibleDataSubmitterID"), String.class, getResponsibleDataSubmitterID(), this);
			processor.processBasic(path.newSubPath("maturityDateOfTheUnderlying"), Date.class, getMaturityDateOfTheUnderlying(), this);
			processor.processBasic(path.newSubPath("corporateActionNewTradeParty1Lei"), String.class, getCorporateActionNewTradeParty1Lei(), this);
			processor.processBasic(path.newSubPath("otherPaymentPayerIDType"), String.class, getOtherPaymentPayerIDType(), this);
			processor.processBasic(path.newSubPath("otherPaymentReceiverIDType"), String.class, getOtherPaymentReceiverIDType(), this);
			processor.processBasic(path.newSubPath("sefOrDcmAnonymousExecutionIndicator"), Boolean.class, getSefOrDcmAnonymousExecutionIndicator(), this);
			processor.processBasic(path.newSubPath("executionVenueID"), String.class, getExecutionVenueID(), this);
			processor.processBasic(path.newSubPath("executionVenueIDType"), PartyIdentifierTypeEnum.class, getExecutionVenueIDType(), this);
			processor.processBasic(path.newSubPath("leg1FloatingRateIndex"), String.class, getLeg1FloatingRateIndex(), this);
			processor.processBasic(path.newSubPath("leg2FloatingRateIndex"), String.class, getLeg2FloatingRateIndex(), this);
			processor.processBasic(path.newSubPath("underlyingAssetName"), String.class, getUnderlyingAssetName(), this);
			processRosetta(path.newSubPath("underlyingAsset"), processor, UnderlyingAssetReport.UnderlyingAssetReportBuilder.class, getUnderlyingAsset());
			processor.processBasic(path.newSubPath("tradeParty1IDType"), String.class, getTradeParty1IDType(), this);
			processor.processBasic(path.newSubPath("messageID"), String.class, getMessageID(), this);
			processor.processBasic(path.newSubPath("leg1CommodityUnderlyerID"), String.class, getLeg1CommodityUnderlyerID(), this);
			processor.processBasic(path.newSubPath("leg2CommodityUnderlyerID"), String.class, getLeg2CommodityUnderlyerID(), this);
			processor.processBasic(path.newSubPath("changeInNotionalAmount1"), BigDecimal.class, getChangeInNotionalAmount1(), this);
			processor.processBasic(path.newSubPath("changeInNotionalAmount2"), BigDecimal.class, getChangeInNotionalAmount2(), this);
			processor.processBasic(path.newSubPath("largeNotionalOffFacilitySwapElectionIndicator"), Boolean.class, getLargeNotionalOffFacilitySwapElectionIndicator(), this);
			processor.processBasic(path.newSubPath("mandatoryClearingIndicator"), Boolean.class, getMandatoryClearingIndicator(), this);
			processor.processBasic(path.newSubPath("messageType"), String.class, getMessageType(), this);
			processor.processBasic(path.newSubPath("originalSwapSDRIDType"), PartyIdentifierTypeEnum.class, getOriginalSwapSDRIDType(), this);
			processor.processBasic(path.newSubPath("physicalCommodityContractIndicator"), Boolean.class, getPhysicalCommodityContractIndicator(), this);
			processor.processBasic(path.newSubPath("sdMspIndicatorCounterparty1"), Boolean.class, getSdMspIndicatorCounterparty1(), this);
			processor.processBasic(path.newSubPath("sdMspIndicatorCounterparty2"), Boolean.class, getSdMspIndicatorCounterparty2(), this);
			processor.processBasic(path.newSubPath("sefOrDcmIndicator"), Boolean.class, getSefOrDcmIndicator(), this);
			processor.processBasic(path.newSubPath("version"), String.class, getVersion(), this);
		}
		

		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder prune();
	}

	/*********************** Immutable Implementation of DTCCAdditionalFields  ***********************/
	class DTCCAdditionalFieldsImpl extends CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsImpl implements DTCCAdditionalFields {
		private final String tradeParty1IDType;
		private final String messageID;
		private final String leg1CommodityUnderlyerID;
		private final String leg2CommodityUnderlyerID;
		private final BigDecimal changeInNotionalAmount1;
		private final BigDecimal changeInNotionalAmount2;
		private final Boolean largeNotionalOffFacilitySwapElectionIndicator;
		private final Boolean mandatoryClearingIndicator;
		private final String messageType;
		private final PartyIdentifierTypeEnum originalSwapSDRIDType;
		private final Boolean physicalCommodityContractIndicator;
		private final Boolean sdMspIndicatorCounterparty1;
		private final Boolean sdMspIndicatorCounterparty2;
		private final Boolean sefOrDcmIndicator;
		private final String version;
		
		protected DTCCAdditionalFieldsImpl(DTCCAdditionalFields.DTCCAdditionalFieldsBuilder builder) {
			super(builder);
			this.tradeParty1IDType = builder.getTradeParty1IDType();
			this.messageID = builder.getMessageID();
			this.leg1CommodityUnderlyerID = builder.getLeg1CommodityUnderlyerID();
			this.leg2CommodityUnderlyerID = builder.getLeg2CommodityUnderlyerID();
			this.changeInNotionalAmount1 = builder.getChangeInNotionalAmount1();
			this.changeInNotionalAmount2 = builder.getChangeInNotionalAmount2();
			this.largeNotionalOffFacilitySwapElectionIndicator = builder.getLargeNotionalOffFacilitySwapElectionIndicator();
			this.mandatoryClearingIndicator = builder.getMandatoryClearingIndicator();
			this.messageType = builder.getMessageType();
			this.originalSwapSDRIDType = builder.getOriginalSwapSDRIDType();
			this.physicalCommodityContractIndicator = builder.getPhysicalCommodityContractIndicator();
			this.sdMspIndicatorCounterparty1 = builder.getSdMspIndicatorCounterparty1();
			this.sdMspIndicatorCounterparty2 = builder.getSdMspIndicatorCounterparty2();
			this.sefOrDcmIndicator = builder.getSefOrDcmIndicator();
			this.version = builder.getVersion();
		}
		
		@Override
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeParty1IDType")
		public String getTradeParty1IDType() {
			return tradeParty1IDType;
		}
		
		@Override
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageID")
		public String getMessageID() {
			return messageID;
		}
		
		@Override
		@RosettaAttribute("leg1CommodityUnderlyerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1CommodityUnderlyerID")
		public String getLeg1CommodityUnderlyerID() {
			return leg1CommodityUnderlyerID;
		}
		
		@Override
		@RosettaAttribute("leg2CommodityUnderlyerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2CommodityUnderlyerID")
		public String getLeg2CommodityUnderlyerID() {
			return leg2CommodityUnderlyerID;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNotionalAmount1")
		public BigDecimal getChangeInNotionalAmount1() {
			return changeInNotionalAmount1;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNotionalAmount2")
		public BigDecimal getChangeInNotionalAmount2() {
			return changeInNotionalAmount2;
		}
		
		@Override
		@RosettaAttribute("largeNotionalOffFacilitySwapElectionIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeNotionalOffFacilitySwapElectionIndicator")
		public Boolean getLargeNotionalOffFacilitySwapElectionIndicator() {
			return largeNotionalOffFacilitySwapElectionIndicator;
		}
		
		@Override
		@RosettaAttribute("mandatoryClearingIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mandatoryClearingIndicator")
		public Boolean getMandatoryClearingIndicator() {
			return mandatoryClearingIndicator;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
		}
		
		@Override
		@RosettaAttribute("originalSwapSDRIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapSDRIDType")
		public PartyIdentifierTypeEnum getOriginalSwapSDRIDType() {
			return originalSwapSDRIDType;
		}
		
		@Override
		@RosettaAttribute("physicalCommodityContractIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalCommodityContractIndicator")
		public Boolean getPhysicalCommodityContractIndicator() {
			return physicalCommodityContractIndicator;
		}
		
		@Override
		@RosettaAttribute("sdMspIndicatorCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sdMspIndicatorCounterparty1")
		public Boolean getSdMspIndicatorCounterparty1() {
			return sdMspIndicatorCounterparty1;
		}
		
		@Override
		@RosettaAttribute("sdMspIndicatorCounterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sdMspIndicatorCounterparty2")
		public Boolean getSdMspIndicatorCounterparty2() {
			return sdMspIndicatorCounterparty2;
		}
		
		@Override
		@RosettaAttribute("sefOrDcmIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sefOrDcmIndicator")
		public Boolean getSefOrDcmIndicator() {
			return sefOrDcmIndicator;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public String getVersion() {
			return version;
		}
		
		@Override
		public DTCCAdditionalFields build() {
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder toBuilder() {
			DTCCAdditionalFields.DTCCAdditionalFieldsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DTCCAdditionalFields.DTCCAdditionalFieldsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeParty1IDType()).ifPresent(builder::setTradeParty1IDType);
			ofNullable(getMessageID()).ifPresent(builder::setMessageID);
			ofNullable(getLeg1CommodityUnderlyerID()).ifPresent(builder::setLeg1CommodityUnderlyerID);
			ofNullable(getLeg2CommodityUnderlyerID()).ifPresent(builder::setLeg2CommodityUnderlyerID);
			ofNullable(getChangeInNotionalAmount1()).ifPresent(builder::setChangeInNotionalAmount1);
			ofNullable(getChangeInNotionalAmount2()).ifPresent(builder::setChangeInNotionalAmount2);
			ofNullable(getLargeNotionalOffFacilitySwapElectionIndicator()).ifPresent(builder::setLargeNotionalOffFacilitySwapElectionIndicator);
			ofNullable(getMandatoryClearingIndicator()).ifPresent(builder::setMandatoryClearingIndicator);
			ofNullable(getMessageType()).ifPresent(builder::setMessageType);
			ofNullable(getOriginalSwapSDRIDType()).ifPresent(builder::setOriginalSwapSDRIDType);
			ofNullable(getPhysicalCommodityContractIndicator()).ifPresent(builder::setPhysicalCommodityContractIndicator);
			ofNullable(getSdMspIndicatorCounterparty1()).ifPresent(builder::setSdMspIndicatorCounterparty1);
			ofNullable(getSdMspIndicatorCounterparty2()).ifPresent(builder::setSdMspIndicatorCounterparty2);
			ofNullable(getSefOrDcmIndicator()).ifPresent(builder::setSefOrDcmIndicator);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DTCCAdditionalFields _that = getType().cast(o);
		
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(leg1CommodityUnderlyerID, _that.getLeg1CommodityUnderlyerID())) return false;
			if (!Objects.equals(leg2CommodityUnderlyerID, _that.getLeg2CommodityUnderlyerID())) return false;
			if (!Objects.equals(changeInNotionalAmount1, _that.getChangeInNotionalAmount1())) return false;
			if (!Objects.equals(changeInNotionalAmount2, _that.getChangeInNotionalAmount2())) return false;
			if (!Objects.equals(largeNotionalOffFacilitySwapElectionIndicator, _that.getLargeNotionalOffFacilitySwapElectionIndicator())) return false;
			if (!Objects.equals(mandatoryClearingIndicator, _that.getMandatoryClearingIndicator())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(originalSwapSDRIDType, _that.getOriginalSwapSDRIDType())) return false;
			if (!Objects.equals(physicalCommodityContractIndicator, _that.getPhysicalCommodityContractIndicator())) return false;
			if (!Objects.equals(sdMspIndicatorCounterparty1, _that.getSdMspIndicatorCounterparty1())) return false;
			if (!Objects.equals(sdMspIndicatorCounterparty2, _that.getSdMspIndicatorCounterparty2())) return false;
			if (!Objects.equals(sefOrDcmIndicator, _that.getSefOrDcmIndicator())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.hashCode() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (leg1CommodityUnderlyerID != null ? leg1CommodityUnderlyerID.hashCode() : 0);
			_result = 31 * _result + (leg2CommodityUnderlyerID != null ? leg2CommodityUnderlyerID.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalAmount1 != null ? changeInNotionalAmount1.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalAmount2 != null ? changeInNotionalAmount2.hashCode() : 0);
			_result = 31 * _result + (largeNotionalOffFacilitySwapElectionIndicator != null ? largeNotionalOffFacilitySwapElectionIndicator.hashCode() : 0);
			_result = 31 * _result + (mandatoryClearingIndicator != null ? mandatoryClearingIndicator.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (originalSwapSDRIDType != null ? originalSwapSDRIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (physicalCommodityContractIndicator != null ? physicalCommodityContractIndicator.hashCode() : 0);
			_result = 31 * _result + (sdMspIndicatorCounterparty1 != null ? sdMspIndicatorCounterparty1.hashCode() : 0);
			_result = 31 * _result + (sdMspIndicatorCounterparty2 != null ? sdMspIndicatorCounterparty2.hashCode() : 0);
			_result = 31 * _result + (sefOrDcmIndicator != null ? sefOrDcmIndicator.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DTCCAdditionalFields {" +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"messageID=" + this.messageID + ", " +
				"leg1CommodityUnderlyerID=" + this.leg1CommodityUnderlyerID + ", " +
				"leg2CommodityUnderlyerID=" + this.leg2CommodityUnderlyerID + ", " +
				"changeInNotionalAmount1=" + this.changeInNotionalAmount1 + ", " +
				"changeInNotionalAmount2=" + this.changeInNotionalAmount2 + ", " +
				"largeNotionalOffFacilitySwapElectionIndicator=" + this.largeNotionalOffFacilitySwapElectionIndicator + ", " +
				"mandatoryClearingIndicator=" + this.mandatoryClearingIndicator + ", " +
				"messageType=" + this.messageType + ", " +
				"originalSwapSDRIDType=" + this.originalSwapSDRIDType + ", " +
				"physicalCommodityContractIndicator=" + this.physicalCommodityContractIndicator + ", " +
				"sdMspIndicatorCounterparty1=" + this.sdMspIndicatorCounterparty1 + ", " +
				"sdMspIndicatorCounterparty2=" + this.sdMspIndicatorCounterparty2 + ", " +
				"sefOrDcmIndicator=" + this.sefOrDcmIndicator + ", " +
				"version=" + this.version +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DTCCAdditionalFields  ***********************/
	class DTCCAdditionalFieldsBuilderImpl extends CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilderImpl implements DTCCAdditionalFields.DTCCAdditionalFieldsBuilder {
	
		protected String tradeParty1IDType;
		protected String messageID;
		protected String leg1CommodityUnderlyerID;
		protected String leg2CommodityUnderlyerID;
		protected BigDecimal changeInNotionalAmount1;
		protected BigDecimal changeInNotionalAmount2;
		protected Boolean largeNotionalOffFacilitySwapElectionIndicator;
		protected Boolean mandatoryClearingIndicator;
		protected String messageType;
		protected PartyIdentifierTypeEnum originalSwapSDRIDType;
		protected Boolean physicalCommodityContractIndicator;
		protected Boolean sdMspIndicatorCounterparty1;
		protected Boolean sdMspIndicatorCounterparty2;
		protected Boolean sefOrDcmIndicator;
		protected String version;
		
		@Override
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeParty1IDType")
		public String getTradeParty1IDType() {
			return tradeParty1IDType;
		}
		
		@Override
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageID")
		public String getMessageID() {
			return messageID;
		}
		
		@Override
		@RosettaAttribute("leg1CommodityUnderlyerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1CommodityUnderlyerID")
		public String getLeg1CommodityUnderlyerID() {
			return leg1CommodityUnderlyerID;
		}
		
		@Override
		@RosettaAttribute("leg2CommodityUnderlyerID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2CommodityUnderlyerID")
		public String getLeg2CommodityUnderlyerID() {
			return leg2CommodityUnderlyerID;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNotionalAmount1")
		public BigDecimal getChangeInNotionalAmount1() {
			return changeInNotionalAmount1;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount2")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("changeInNotionalAmount2")
		public BigDecimal getChangeInNotionalAmount2() {
			return changeInNotionalAmount2;
		}
		
		@Override
		@RosettaAttribute("largeNotionalOffFacilitySwapElectionIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("largeNotionalOffFacilitySwapElectionIndicator")
		public Boolean getLargeNotionalOffFacilitySwapElectionIndicator() {
			return largeNotionalOffFacilitySwapElectionIndicator;
		}
		
		@Override
		@RosettaAttribute("mandatoryClearingIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("mandatoryClearingIndicator")
		public Boolean getMandatoryClearingIndicator() {
			return mandatoryClearingIndicator;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
		}
		
		@Override
		@RosettaAttribute("originalSwapSDRIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapSDRIDType")
		public PartyIdentifierTypeEnum getOriginalSwapSDRIDType() {
			return originalSwapSDRIDType;
		}
		
		@Override
		@RosettaAttribute("physicalCommodityContractIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalCommodityContractIndicator")
		public Boolean getPhysicalCommodityContractIndicator() {
			return physicalCommodityContractIndicator;
		}
		
		@Override
		@RosettaAttribute("sdMspIndicatorCounterparty1")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sdMspIndicatorCounterparty1")
		public Boolean getSdMspIndicatorCounterparty1() {
			return sdMspIndicatorCounterparty1;
		}
		
		@Override
		@RosettaAttribute("sdMspIndicatorCounterparty2")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sdMspIndicatorCounterparty2")
		public Boolean getSdMspIndicatorCounterparty2() {
			return sdMspIndicatorCounterparty2;
		}
		
		@Override
		@RosettaAttribute("sefOrDcmIndicator")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sefOrDcmIndicator")
		public Boolean getSefOrDcmIndicator() {
			return sefOrDcmIndicator;
		}
		
		@Override
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public String getVersion() {
			return version;
		}
		
		@RosettaAttribute("clearingVenueIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingVenueIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setClearingVenueIDType(PartyIdentifierTypeEnum _clearingVenueIDType) {
			this.clearingVenueIDType = _clearingVenueIDType == null ? null : _clearingVenueIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ClearingBrokerIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ClearingBrokerIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1ClearingBrokerIDType(PartyIdentifierTypeEnum _tradeParty1ClearingBrokerIDType) {
			this.tradeParty1ClearingBrokerIDType = _tradeParty1ClearingBrokerIDType == null ? null : _tradeParty1ClearingBrokerIDType;
			return this;
		}
		
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submittingPartyIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum _submittingPartyIDType) {
			this.submittingPartyIDType = _submittingPartyIDType == null ? null : _submittingPartyIDType;
			return this;
		}
		
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submittedForParty")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSubmittedForParty(String _submittedForParty) {
			this.submittedForParty = _submittedForParty == null ? null : _submittedForParty;
			return this;
		}
		
		@RosettaAttribute("tradeLegTypes")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeLegTypes")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeLegTypes(String _tradeLegTypes) {
			this.tradeLegTypes = _tradeLegTypes == null ? null : _tradeLegTypes;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination) {
			if (_tradeParty1ReportingDestination != null) {
				this.tradeParty1ReportingDestination.add(_tradeParty1ReportingDestination);
			}
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination, int idx) {
			getIndex(this.tradeParty1ReportingDestination, idx, () -> _tradeParty1ReportingDestination);
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations != null) {
				for (final SupervisoryBodyEnum toAdd : tradeParty1ReportingDestinations) {
					this.tradeParty1ReportingDestination.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations == null) {
				this.tradeParty1ReportingDestination = new ArrayList<>();
			} else {
				this.tradeParty1ReportingDestination = tradeParty1ReportingDestinations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum _tradeParty2ReportingDestination) {
			if (_tradeParty2ReportingDestination != null) {
				this.tradeParty2ReportingDestination.add(_tradeParty2ReportingDestination);
			}
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum _tradeParty2ReportingDestination, int idx) {
			getIndex(this.tradeParty2ReportingDestination, idx, () -> _tradeParty2ReportingDestination);
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestinations) {
			if (tradeParty2ReportingDestinations != null) {
				for (final SupervisoryBodyEnum toAdd : tradeParty2ReportingDestinations) {
					this.tradeParty2ReportingDestination.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestinations) {
			if (tradeParty2ReportingDestinations == null) {
				this.tradeParty2ReportingDestination = new ArrayList<>();
			} else {
				this.tradeParty2ReportingDestination = tradeParty2ReportingDestinations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("primaryAssetClass")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setPrimaryAssetClass(AssetClassEnum _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass;
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryAssetClass")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSecondaryAssetClass(AssetClassEnum _secondaryAssetClass) {
			this.secondaryAssetClass = _secondaryAssetClass == null ? null : _secondaryAssetClass;
			return this;
		}
		
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment1")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setComment1(String _comment1) {
			this.comment1 = _comment1 == null ? null : _comment1;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOptionType(String _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("productID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("productID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setProductID(String _productID) {
			this.productID = _productID == null ? null : _productID;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty2ExecutionAgentID(String _tradeParty2ExecutionAgentID) {
			this.tradeParty2ExecutionAgentID = _tradeParty2ExecutionAgentID == null ? null : _tradeParty2ExecutionAgentID;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty2ExecutionAgentIDType(PartyIdentifierTypeEnum _tradeParty2ExecutionAgentIDType) {
			this.tradeParty2ExecutionAgentIDType = _tradeParty2ExecutionAgentIDType == null ? null : _tradeParty2ExecutionAgentIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1ExecutionAgentID(String _tradeParty1ExecutionAgentID) {
			this.tradeParty1ExecutionAgentID = _tradeParty1ExecutionAgentID == null ? null : _tradeParty1ExecutionAgentID;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1ExecutionAgentIDType(PartyIdentifierTypeEnum _tradeParty1ExecutionAgentIDType) {
			this.tradeParty1ExecutionAgentIDType = _tradeParty1ExecutionAgentIDType == null ? null : _tradeParty1ExecutionAgentIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1TransactionID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1TransactionID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1TransactionID(String _tradeParty1TransactionID) {
			this.tradeParty1TransactionID = _tradeParty1TransactionID == null ? null : _tradeParty1TransactionID;
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSettlementType(String _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productGrade")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addProductGrade(ProductGradeReport _productGrade) {
			if (_productGrade != null) {
				this.productGrade.add(_productGrade.toBuilder());
			}
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addProductGrade(ProductGradeReport _productGrade, int idx) {
			getIndex(this.productGrade, idx, () -> _productGrade.toBuilder());
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addProductGrade(List<? extends ProductGradeReport> productGrades) {
			if (productGrades != null) {
				for (final ProductGradeReport toAdd : productGrades) {
					this.productGrade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productGrade")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setProductGrade(List<? extends ProductGradeReport> productGrades) {
			if (productGrades == null) {
				this.productGrade = new ArrayList<>();
			} else {
				this.productGrade = productGrades.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deliveryLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryLocation")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setDeliveryLocation(String _deliveryLocation) {
			this.deliveryLocation = _deliveryLocation == null ? null : _deliveryLocation;
			return this;
		}
		
		@RosettaAttribute("leg1CommodityInstrumentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg1CommodityInstrumentID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg1CommodityInstrumentID(String _leg1CommodityInstrumentID) {
			this.leg1CommodityInstrumentID = _leg1CommodityInstrumentID == null ? null : _leg1CommodityInstrumentID;
			return this;
		}
		
		@RosettaAttribute("leg2CommodityInstrumentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2CommodityInstrumentID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg2CommodityInstrumentID(String _leg2CommodityInstrumentID) {
			this.leg2CommodityInstrumentID = _leg2CommodityInstrumentID == null ? null : _leg2CommodityInstrumentID;
			return this;
		}
		
		@RosettaAttribute("responsibleDataSubmitterIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("responsibleDataSubmitterIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setResponsibleDataSubmitterIDType(PartyIdentifierTypeEnum _responsibleDataSubmitterIDType) {
			this.responsibleDataSubmitterIDType = _responsibleDataSubmitterIDType == null ? null : _responsibleDataSubmitterIDType;
			return this;
		}
		
		@RosettaAttribute("responsibleDataSubmitterID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("responsibleDataSubmitterID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setResponsibleDataSubmitterID(String _responsibleDataSubmitterID) {
			this.responsibleDataSubmitterID = _responsibleDataSubmitterID == null ? null : _responsibleDataSubmitterID;
			return this;
		}
		
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMaturityDateOfTheUnderlying(Date _maturityDateOfTheUnderlying) {
			this.maturityDateOfTheUnderlying = _maturityDateOfTheUnderlying == null ? null : _maturityDateOfTheUnderlying;
			return this;
		}
		
		@RosettaAttribute("corporateActionNewTradeParty1Lei")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("corporateActionNewTradeParty1Lei")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setCorporateActionNewTradeParty1Lei(String _corporateActionNewTradeParty1Lei) {
			this.corporateActionNewTradeParty1Lei = _corporateActionNewTradeParty1Lei == null ? null : _corporateActionNewTradeParty1Lei;
			return this;
		}
		
		@RosettaAttribute("otherPaymentPayerIDType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPaymentPayerIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(String _otherPaymentPayerIDType) {
			if (_otherPaymentPayerIDType != null) {
				this.otherPaymentPayerIDType.add(_otherPaymentPayerIDType);
			}
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(String _otherPaymentPayerIDType, int idx) {
			getIndex(this.otherPaymentPayerIDType, idx, () -> _otherPaymentPayerIDType);
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(List<String> otherPaymentPayerIDTypes) {
			if (otherPaymentPayerIDTypes != null) {
				for (final String toAdd : otherPaymentPayerIDTypes) {
					this.otherPaymentPayerIDType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherPaymentPayerIDType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherPaymentPayerIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOtherPaymentPayerIDType(List<String> otherPaymentPayerIDTypes) {
			if (otherPaymentPayerIDTypes == null) {
				this.otherPaymentPayerIDType = new ArrayList<>();
			} else {
				this.otherPaymentPayerIDType = otherPaymentPayerIDTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("otherPaymentReceiverIDType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPaymentReceiverIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(String _otherPaymentReceiverIDType) {
			if (_otherPaymentReceiverIDType != null) {
				this.otherPaymentReceiverIDType.add(_otherPaymentReceiverIDType);
			}
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(String _otherPaymentReceiverIDType, int idx) {
			getIndex(this.otherPaymentReceiverIDType, idx, () -> _otherPaymentReceiverIDType);
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(List<String> otherPaymentReceiverIDTypes) {
			if (otherPaymentReceiverIDTypes != null) {
				for (final String toAdd : otherPaymentReceiverIDTypes) {
					this.otherPaymentReceiverIDType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherPaymentReceiverIDType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherPaymentReceiverIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOtherPaymentReceiverIDType(List<String> otherPaymentReceiverIDTypes) {
			if (otherPaymentReceiverIDTypes == null) {
				this.otherPaymentReceiverIDType = new ArrayList<>();
			} else {
				this.otherPaymentReceiverIDType = otherPaymentReceiverIDTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sefOrDcmAnonymousExecutionIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sefOrDcmAnonymousExecutionIndicator")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSefOrDcmAnonymousExecutionIndicator(Boolean _sefOrDcmAnonymousExecutionIndicator) {
			this.sefOrDcmAnonymousExecutionIndicator = _sefOrDcmAnonymousExecutionIndicator == null ? null : _sefOrDcmAnonymousExecutionIndicator;
			return this;
		}
		
		@RosettaAttribute("executionVenueID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setExecutionVenueID(String _executionVenueID) {
			this.executionVenueID = _executionVenueID == null ? null : _executionVenueID;
			return this;
		}
		
		@RosettaAttribute("executionVenueIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setExecutionVenueIDType(PartyIdentifierTypeEnum _executionVenueIDType) {
			this.executionVenueIDType = _executionVenueIDType == null ? null : _executionVenueIDType;
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg1FloatingRateIndex")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg1FloatingRateIndex(String _leg1FloatingRateIndex) {
			this.leg1FloatingRateIndex = _leg1FloatingRateIndex == null ? null : _leg1FloatingRateIndex;
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2FloatingRateIndex")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg2FloatingRateIndex(String _leg2FloatingRateIndex) {
			this.leg2FloatingRateIndex = _leg2FloatingRateIndex == null ? null : _leg2FloatingRateIndex;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetName")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetName")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAssetName(String _underlyingAssetName) {
			if (_underlyingAssetName != null) {
				this.underlyingAssetName.add(_underlyingAssetName);
			}
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAssetName(String _underlyingAssetName, int idx) {
			getIndex(this.underlyingAssetName, idx, () -> _underlyingAssetName);
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAssetName(List<String> underlyingAssetNames) {
			if (underlyingAssetNames != null) {
				for (final String toAdd : underlyingAssetNames) {
					this.underlyingAssetName.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetName")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetName")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setUnderlyingAssetName(List<String> underlyingAssetNames) {
			if (underlyingAssetNames == null) {
				this.underlyingAssetName = new ArrayList<>();
			} else {
				this.underlyingAssetName = underlyingAssetNames.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAsset")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAsset(UnderlyingAssetReport _underlyingAsset) {
			if (_underlyingAsset != null) {
				this.underlyingAsset.add(_underlyingAsset.toBuilder());
			}
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAsset(UnderlyingAssetReport _underlyingAsset, int idx) {
			getIndex(this.underlyingAsset, idx, () -> _underlyingAsset.toBuilder());
			return this;
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder addUnderlyingAsset(List<? extends UnderlyingAssetReport> underlyingAssets) {
			if (underlyingAssets != null) {
				for (final UnderlyingAssetReport toAdd : underlyingAssets) {
					this.underlyingAsset.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAsset")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setUnderlyingAsset(List<? extends UnderlyingAssetReport> underlyingAssets) {
			if (underlyingAssets == null) {
				this.underlyingAsset = new ArrayList<>();
			} else {
				this.underlyingAsset = underlyingAssets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradeParty1IDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1IDType(String _tradeParty1IDType) {
			this.tradeParty1IDType = _tradeParty1IDType == null ? null : _tradeParty1IDType;
			return this;
		}
		
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMessageID(String _messageID) {
			this.messageID = _messageID == null ? null : _messageID;
			return this;
		}
		
		@RosettaAttribute("leg1CommodityUnderlyerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg1CommodityUnderlyerID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg1CommodityUnderlyerID(String _leg1CommodityUnderlyerID) {
			this.leg1CommodityUnderlyerID = _leg1CommodityUnderlyerID == null ? null : _leg1CommodityUnderlyerID;
			return this;
		}
		
		@RosettaAttribute("leg2CommodityUnderlyerID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2CommodityUnderlyerID")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLeg2CommodityUnderlyerID(String _leg2CommodityUnderlyerID) {
			this.leg2CommodityUnderlyerID = _leg2CommodityUnderlyerID == null ? null : _leg2CommodityUnderlyerID;
			return this;
		}
		
		@RosettaAttribute("changeInNotionalAmount1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInNotionalAmount1")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setChangeInNotionalAmount1(BigDecimal _changeInNotionalAmount1) {
			this.changeInNotionalAmount1 = _changeInNotionalAmount1 == null ? null : _changeInNotionalAmount1;
			return this;
		}
		
		@RosettaAttribute("changeInNotionalAmount2")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("changeInNotionalAmount2")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setChangeInNotionalAmount2(BigDecimal _changeInNotionalAmount2) {
			this.changeInNotionalAmount2 = _changeInNotionalAmount2 == null ? null : _changeInNotionalAmount2;
			return this;
		}
		
		@RosettaAttribute("largeNotionalOffFacilitySwapElectionIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("largeNotionalOffFacilitySwapElectionIndicator")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setLargeNotionalOffFacilitySwapElectionIndicator(Boolean _largeNotionalOffFacilitySwapElectionIndicator) {
			this.largeNotionalOffFacilitySwapElectionIndicator = _largeNotionalOffFacilitySwapElectionIndicator == null ? null : _largeNotionalOffFacilitySwapElectionIndicator;
			return this;
		}
		
		@RosettaAttribute("mandatoryClearingIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("mandatoryClearingIndicator")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMandatoryClearingIndicator(Boolean _mandatoryClearingIndicator) {
			this.mandatoryClearingIndicator = _mandatoryClearingIndicator == null ? null : _mandatoryClearingIndicator;
			return this;
		}
		
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMessageType(String _messageType) {
			this.messageType = _messageType == null ? null : _messageType;
			return this;
		}
		
		@RosettaAttribute("originalSwapSDRIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapSDRIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOriginalSwapSDRIDType(PartyIdentifierTypeEnum _originalSwapSDRIDType) {
			this.originalSwapSDRIDType = _originalSwapSDRIDType == null ? null : _originalSwapSDRIDType;
			return this;
		}
		
		@RosettaAttribute("physicalCommodityContractIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalCommodityContractIndicator")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setPhysicalCommodityContractIndicator(Boolean _physicalCommodityContractIndicator) {
			this.physicalCommodityContractIndicator = _physicalCommodityContractIndicator == null ? null : _physicalCommodityContractIndicator;
			return this;
		}
		
		@RosettaAttribute("sdMspIndicatorCounterparty1")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sdMspIndicatorCounterparty1")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSdMspIndicatorCounterparty1(Boolean _sdMspIndicatorCounterparty1) {
			this.sdMspIndicatorCounterparty1 = _sdMspIndicatorCounterparty1 == null ? null : _sdMspIndicatorCounterparty1;
			return this;
		}
		
		@RosettaAttribute("sdMspIndicatorCounterparty2")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sdMspIndicatorCounterparty2")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSdMspIndicatorCounterparty2(Boolean _sdMspIndicatorCounterparty2) {
			this.sdMspIndicatorCounterparty2 = _sdMspIndicatorCounterparty2 == null ? null : _sdMspIndicatorCounterparty2;
			return this;
		}
		
		@RosettaAttribute("sefOrDcmIndicator")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sefOrDcmIndicator")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setSefOrDcmIndicator(Boolean _sefOrDcmIndicator) {
			this.sefOrDcmIndicator = _sefOrDcmIndicator == null ? null : _sefOrDcmIndicator;
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("version")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setVersion(String _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@Override
		public DTCCAdditionalFields build() {
			return new DTCCAdditionalFields.DTCCAdditionalFieldsImpl(this);
		}
		
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeParty1IDType()!=null) return true;
			if (getMessageID()!=null) return true;
			if (getLeg1CommodityUnderlyerID()!=null) return true;
			if (getLeg2CommodityUnderlyerID()!=null) return true;
			if (getChangeInNotionalAmount1()!=null) return true;
			if (getChangeInNotionalAmount2()!=null) return true;
			if (getLargeNotionalOffFacilitySwapElectionIndicator()!=null) return true;
			if (getMandatoryClearingIndicator()!=null) return true;
			if (getMessageType()!=null) return true;
			if (getOriginalSwapSDRIDType()!=null) return true;
			if (getPhysicalCommodityContractIndicator()!=null) return true;
			if (getSdMspIndicatorCounterparty1()!=null) return true;
			if (getSdMspIndicatorCounterparty2()!=null) return true;
			if (getSefOrDcmIndicator()!=null) return true;
			if (getVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DTCCAdditionalFields.DTCCAdditionalFieldsBuilder o = (DTCCAdditionalFields.DTCCAdditionalFieldsBuilder) other;
			
			
			merger.mergeBasic(getTradeParty1IDType(), o.getTradeParty1IDType(), this::setTradeParty1IDType);
			merger.mergeBasic(getMessageID(), o.getMessageID(), this::setMessageID);
			merger.mergeBasic(getLeg1CommodityUnderlyerID(), o.getLeg1CommodityUnderlyerID(), this::setLeg1CommodityUnderlyerID);
			merger.mergeBasic(getLeg2CommodityUnderlyerID(), o.getLeg2CommodityUnderlyerID(), this::setLeg2CommodityUnderlyerID);
			merger.mergeBasic(getChangeInNotionalAmount1(), o.getChangeInNotionalAmount1(), this::setChangeInNotionalAmount1);
			merger.mergeBasic(getChangeInNotionalAmount2(), o.getChangeInNotionalAmount2(), this::setChangeInNotionalAmount2);
			merger.mergeBasic(getLargeNotionalOffFacilitySwapElectionIndicator(), o.getLargeNotionalOffFacilitySwapElectionIndicator(), this::setLargeNotionalOffFacilitySwapElectionIndicator);
			merger.mergeBasic(getMandatoryClearingIndicator(), o.getMandatoryClearingIndicator(), this::setMandatoryClearingIndicator);
			merger.mergeBasic(getMessageType(), o.getMessageType(), this::setMessageType);
			merger.mergeBasic(getOriginalSwapSDRIDType(), o.getOriginalSwapSDRIDType(), this::setOriginalSwapSDRIDType);
			merger.mergeBasic(getPhysicalCommodityContractIndicator(), o.getPhysicalCommodityContractIndicator(), this::setPhysicalCommodityContractIndicator);
			merger.mergeBasic(getSdMspIndicatorCounterparty1(), o.getSdMspIndicatorCounterparty1(), this::setSdMspIndicatorCounterparty1);
			merger.mergeBasic(getSdMspIndicatorCounterparty2(), o.getSdMspIndicatorCounterparty2(), this::setSdMspIndicatorCounterparty2);
			merger.mergeBasic(getSefOrDcmIndicator(), o.getSefOrDcmIndicator(), this::setSefOrDcmIndicator);
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DTCCAdditionalFields _that = getType().cast(o);
		
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(leg1CommodityUnderlyerID, _that.getLeg1CommodityUnderlyerID())) return false;
			if (!Objects.equals(leg2CommodityUnderlyerID, _that.getLeg2CommodityUnderlyerID())) return false;
			if (!Objects.equals(changeInNotionalAmount1, _that.getChangeInNotionalAmount1())) return false;
			if (!Objects.equals(changeInNotionalAmount2, _that.getChangeInNotionalAmount2())) return false;
			if (!Objects.equals(largeNotionalOffFacilitySwapElectionIndicator, _that.getLargeNotionalOffFacilitySwapElectionIndicator())) return false;
			if (!Objects.equals(mandatoryClearingIndicator, _that.getMandatoryClearingIndicator())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(originalSwapSDRIDType, _that.getOriginalSwapSDRIDType())) return false;
			if (!Objects.equals(physicalCommodityContractIndicator, _that.getPhysicalCommodityContractIndicator())) return false;
			if (!Objects.equals(sdMspIndicatorCounterparty1, _that.getSdMspIndicatorCounterparty1())) return false;
			if (!Objects.equals(sdMspIndicatorCounterparty2, _that.getSdMspIndicatorCounterparty2())) return false;
			if (!Objects.equals(sefOrDcmIndicator, _that.getSefOrDcmIndicator())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.hashCode() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (leg1CommodityUnderlyerID != null ? leg1CommodityUnderlyerID.hashCode() : 0);
			_result = 31 * _result + (leg2CommodityUnderlyerID != null ? leg2CommodityUnderlyerID.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalAmount1 != null ? changeInNotionalAmount1.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalAmount2 != null ? changeInNotionalAmount2.hashCode() : 0);
			_result = 31 * _result + (largeNotionalOffFacilitySwapElectionIndicator != null ? largeNotionalOffFacilitySwapElectionIndicator.hashCode() : 0);
			_result = 31 * _result + (mandatoryClearingIndicator != null ? mandatoryClearingIndicator.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (originalSwapSDRIDType != null ? originalSwapSDRIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (physicalCommodityContractIndicator != null ? physicalCommodityContractIndicator.hashCode() : 0);
			_result = 31 * _result + (sdMspIndicatorCounterparty1 != null ? sdMspIndicatorCounterparty1.hashCode() : 0);
			_result = 31 * _result + (sdMspIndicatorCounterparty2 != null ? sdMspIndicatorCounterparty2.hashCode() : 0);
			_result = 31 * _result + (sefOrDcmIndicator != null ? sefOrDcmIndicator.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DTCCAdditionalFieldsBuilder {" +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"messageID=" + this.messageID + ", " +
				"leg1CommodityUnderlyerID=" + this.leg1CommodityUnderlyerID + ", " +
				"leg2CommodityUnderlyerID=" + this.leg2CommodityUnderlyerID + ", " +
				"changeInNotionalAmount1=" + this.changeInNotionalAmount1 + ", " +
				"changeInNotionalAmount2=" + this.changeInNotionalAmount2 + ", " +
				"largeNotionalOffFacilitySwapElectionIndicator=" + this.largeNotionalOffFacilitySwapElectionIndicator + ", " +
				"mandatoryClearingIndicator=" + this.mandatoryClearingIndicator + ", " +
				"messageType=" + this.messageType + ", " +
				"originalSwapSDRIDType=" + this.originalSwapSDRIDType + ", " +
				"physicalCommodityContractIndicator=" + this.physicalCommodityContractIndicator + ", " +
				"sdMspIndicatorCounterparty1=" + this.sdMspIndicatorCounterparty1 + ", " +
				"sdMspIndicatorCounterparty2=" + this.sdMspIndicatorCounterparty2 + ", " +
				"sefOrDcmIndicator=" + this.sefOrDcmIndicator + ", " +
				"version=" + this.version +
			'}' + " " + super.toString();
		}
	}
}
