package drr.regulation.sec.rewrite.dtcc;

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
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.dtcc.trade.CommonDTCCAdditionalFields;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import drr.regulation.common.dtcc.trade.UnderlyingAssetReport;
import drr.regulation.sec.rewrite.dtcc.meta.DTCCAdditionalFieldsMeta;
import drr.standards.iso.OptionStyleEnum;
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
	 * Body SEC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "DTCC validation rules document providing the message specifications required for inbound reporting submissions to DTCC for SEC reporting." 
	 * field "Original Swap SDR - ID Type"
	 *
	 * Provision GTR Control Field.
	 *
	 */
	PartyIdentifierTypeEnum getOriginalSwapSDRIDType();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "DTCC validation rules document providing the message specifications required for inbound reporting submissions to DTCC for SEC reporting." 
	 * dataElement "901.d.1" * field "Trade Party 1 - ID Type"
	 *
	 * Provision GTR required Control Field.
	 *
	 */
	String getTradeParty1IDType();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "DTCC validation rules document providing the message specifications required for inbound reporting submissions to DTCC for SEC reporting." 
	 * field "Message ID"
	 *
	 * Provision Purpose of this field is to allow firms to submit a unique ID that will allow them to tie in specific submissions/modifications. For example if 5 modifications are submitted on a specific PET, this will allow the firm to ensure they receive responses for all 5 modifications.
	 *
	 */
	String getMessageID();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "DTCC validation rules document providing the message specifications required for inbound reporting submissions to DTCC for SEC reporting." 
	 * field "Message Type (Trade report)"
	 *
	 * Provision Need to indicate what message is being submitted to GTR.
	 *
	 */
	String getMessageTypeTransaction();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination PPD    * Corpus Specifications DTCC_Specs DTCC Specs "DTCC validation rules document providing the message specifications required for inbound reporting submissions to DTCC for SEC reporting." 
	 * field "Message Type (PPD report)"
	 *
	 * Provision Need to indicate what message is being submitted to GTR.
	 *
	 */
	String getMessageTypePPD();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination Trade    * Corpus Specifications DTCC_Specs DTCC Specs "DTCC validation rules document providing the message specifications required for inbound reporting submissions to DTCC for SEC reporting." 
	 * field "Version (Trade report)"
	 *
	 * Provision Memo field. Used to identify the asset class and template type of submission.
	 *
	 */
	String getVersionTransaction();
	/**
	 *
	 * Body SEC
	 * Corpus Dissemination PPD    * Corpus Specifications DTCC_Specs DTCC Specs "DTCC validation rules document providing the message specifications required for inbound reporting submissions to DTCC for SEC reporting." 
	 * field "Version (PPD report)"
	 *
	 * Provision Memo field. Used to identify the asset class and template type of submission.
	 *
	 */
	String getVersionPPD();

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
		processor.processBasic(path.newSubPath("originalSwapSDRIDType"), PartyIdentifierTypeEnum.class, getOriginalSwapSDRIDType(), this);
		processor.processBasic(path.newSubPath("tradeParty1IDType"), String.class, getTradeParty1IDType(), this);
		processor.processBasic(path.newSubPath("messageID"), String.class, getMessageID(), this);
		processor.processBasic(path.newSubPath("messageTypeTransaction"), String.class, getMessageTypeTransaction(), this);
		processor.processBasic(path.newSubPath("messageTypePPD"), String.class, getMessageTypePPD(), this);
		processor.processBasic(path.newSubPath("versionTransaction"), String.class, getVersionTransaction(), this);
		processor.processBasic(path.newSubPath("versionPPD"), String.class, getVersionPPD(), this);
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
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOriginalSwapSDRIDType(PartyIdentifierTypeEnum originalSwapSDRIDType);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setTradeParty1IDType(String tradeParty1IDType);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMessageID(String messageID);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMessageTypeTransaction(String messageTypeTransaction);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMessageTypePPD(String messageTypePPD);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setVersionTransaction(String versionTransaction);
		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setVersionPPD(String versionPPD);

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
			processor.processBasic(path.newSubPath("originalSwapSDRIDType"), PartyIdentifierTypeEnum.class, getOriginalSwapSDRIDType(), this);
			processor.processBasic(path.newSubPath("tradeParty1IDType"), String.class, getTradeParty1IDType(), this);
			processor.processBasic(path.newSubPath("messageID"), String.class, getMessageID(), this);
			processor.processBasic(path.newSubPath("messageTypeTransaction"), String.class, getMessageTypeTransaction(), this);
			processor.processBasic(path.newSubPath("messageTypePPD"), String.class, getMessageTypePPD(), this);
			processor.processBasic(path.newSubPath("versionTransaction"), String.class, getVersionTransaction(), this);
			processor.processBasic(path.newSubPath("versionPPD"), String.class, getVersionPPD(), this);
		}
		

		DTCCAdditionalFields.DTCCAdditionalFieldsBuilder prune();
	}

	/*********************** Immutable Implementation of DTCCAdditionalFields  ***********************/
	class DTCCAdditionalFieldsImpl extends CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsImpl implements DTCCAdditionalFields {
		private final PartyIdentifierTypeEnum originalSwapSDRIDType;
		private final String tradeParty1IDType;
		private final String messageID;
		private final String messageTypeTransaction;
		private final String messageTypePPD;
		private final String versionTransaction;
		private final String versionPPD;
		
		protected DTCCAdditionalFieldsImpl(DTCCAdditionalFields.DTCCAdditionalFieldsBuilder builder) {
			super(builder);
			this.originalSwapSDRIDType = builder.getOriginalSwapSDRIDType();
			this.tradeParty1IDType = builder.getTradeParty1IDType();
			this.messageID = builder.getMessageID();
			this.messageTypeTransaction = builder.getMessageTypeTransaction();
			this.messageTypePPD = builder.getMessageTypePPD();
			this.versionTransaction = builder.getVersionTransaction();
			this.versionPPD = builder.getVersionPPD();
		}
		
		@Override
		@RosettaAttribute("originalSwapSDRIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapSDRIDType")
		public PartyIdentifierTypeEnum getOriginalSwapSDRIDType() {
			return originalSwapSDRIDType;
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
		@RosettaAttribute("messageTypeTransaction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageTypeTransaction")
		public String getMessageTypeTransaction() {
			return messageTypeTransaction;
		}
		
		@Override
		@RosettaAttribute("messageTypePPD")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageTypePPD")
		public String getMessageTypePPD() {
			return messageTypePPD;
		}
		
		@Override
		@RosettaAttribute("versionTransaction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("versionTransaction")
		public String getVersionTransaction() {
			return versionTransaction;
		}
		
		@Override
		@RosettaAttribute("versionPPD")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("versionPPD")
		public String getVersionPPD() {
			return versionPPD;
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
			ofNullable(getOriginalSwapSDRIDType()).ifPresent(builder::setOriginalSwapSDRIDType);
			ofNullable(getTradeParty1IDType()).ifPresent(builder::setTradeParty1IDType);
			ofNullable(getMessageID()).ifPresent(builder::setMessageID);
			ofNullable(getMessageTypeTransaction()).ifPresent(builder::setMessageTypeTransaction);
			ofNullable(getMessageTypePPD()).ifPresent(builder::setMessageTypePPD);
			ofNullable(getVersionTransaction()).ifPresent(builder::setVersionTransaction);
			ofNullable(getVersionPPD()).ifPresent(builder::setVersionPPD);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DTCCAdditionalFields _that = getType().cast(o);
		
			if (!Objects.equals(originalSwapSDRIDType, _that.getOriginalSwapSDRIDType())) return false;
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(messageTypeTransaction, _that.getMessageTypeTransaction())) return false;
			if (!Objects.equals(messageTypePPD, _that.getMessageTypePPD())) return false;
			if (!Objects.equals(versionTransaction, _that.getVersionTransaction())) return false;
			if (!Objects.equals(versionPPD, _that.getVersionPPD())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalSwapSDRIDType != null ? originalSwapSDRIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.hashCode() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (messageTypeTransaction != null ? messageTypeTransaction.hashCode() : 0);
			_result = 31 * _result + (messageTypePPD != null ? messageTypePPD.hashCode() : 0);
			_result = 31 * _result + (versionTransaction != null ? versionTransaction.hashCode() : 0);
			_result = 31 * _result + (versionPPD != null ? versionPPD.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DTCCAdditionalFields {" +
				"originalSwapSDRIDType=" + this.originalSwapSDRIDType + ", " +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"messageID=" + this.messageID + ", " +
				"messageTypeTransaction=" + this.messageTypeTransaction + ", " +
				"messageTypePPD=" + this.messageTypePPD + ", " +
				"versionTransaction=" + this.versionTransaction + ", " +
				"versionPPD=" + this.versionPPD +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DTCCAdditionalFields  ***********************/
	class DTCCAdditionalFieldsBuilderImpl extends CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilderImpl implements DTCCAdditionalFields.DTCCAdditionalFieldsBuilder {
	
		protected PartyIdentifierTypeEnum originalSwapSDRIDType;
		protected String tradeParty1IDType;
		protected String messageID;
		protected String messageTypeTransaction;
		protected String messageTypePPD;
		protected String versionTransaction;
		protected String versionPPD;
		
		@Override
		@RosettaAttribute("originalSwapSDRIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSwapSDRIDType")
		public PartyIdentifierTypeEnum getOriginalSwapSDRIDType() {
			return originalSwapSDRIDType;
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
		@RosettaAttribute("messageTypeTransaction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageTypeTransaction")
		public String getMessageTypeTransaction() {
			return messageTypeTransaction;
		}
		
		@Override
		@RosettaAttribute("messageTypePPD")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageTypePPD")
		public String getMessageTypePPD() {
			return messageTypePPD;
		}
		
		@Override
		@RosettaAttribute("versionTransaction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("versionTransaction")
		public String getVersionTransaction() {
			return versionTransaction;
		}
		
		@Override
		@RosettaAttribute("versionPPD")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("versionPPD")
		public String getVersionPPD() {
			return versionPPD;
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
		
		@RosettaAttribute("originalSwapSDRIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSwapSDRIDType")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setOriginalSwapSDRIDType(PartyIdentifierTypeEnum _originalSwapSDRIDType) {
			this.originalSwapSDRIDType = _originalSwapSDRIDType == null ? null : _originalSwapSDRIDType;
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
		
		@RosettaAttribute("messageTypeTransaction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageTypeTransaction")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMessageTypeTransaction(String _messageTypeTransaction) {
			this.messageTypeTransaction = _messageTypeTransaction == null ? null : _messageTypeTransaction;
			return this;
		}
		
		@RosettaAttribute("messageTypePPD")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageTypePPD")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setMessageTypePPD(String _messageTypePPD) {
			this.messageTypePPD = _messageTypePPD == null ? null : _messageTypePPD;
			return this;
		}
		
		@RosettaAttribute("versionTransaction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("versionTransaction")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setVersionTransaction(String _versionTransaction) {
			this.versionTransaction = _versionTransaction == null ? null : _versionTransaction;
			return this;
		}
		
		@RosettaAttribute("versionPPD")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("versionPPD")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder setVersionPPD(String _versionPPD) {
			this.versionPPD = _versionPPD == null ? null : _versionPPD;
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
			if (getOriginalSwapSDRIDType()!=null) return true;
			if (getTradeParty1IDType()!=null) return true;
			if (getMessageID()!=null) return true;
			if (getMessageTypeTransaction()!=null) return true;
			if (getMessageTypePPD()!=null) return true;
			if (getVersionTransaction()!=null) return true;
			if (getVersionPPD()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DTCCAdditionalFields.DTCCAdditionalFieldsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DTCCAdditionalFields.DTCCAdditionalFieldsBuilder o = (DTCCAdditionalFields.DTCCAdditionalFieldsBuilder) other;
			
			
			merger.mergeBasic(getOriginalSwapSDRIDType(), o.getOriginalSwapSDRIDType(), this::setOriginalSwapSDRIDType);
			merger.mergeBasic(getTradeParty1IDType(), o.getTradeParty1IDType(), this::setTradeParty1IDType);
			merger.mergeBasic(getMessageID(), o.getMessageID(), this::setMessageID);
			merger.mergeBasic(getMessageTypeTransaction(), o.getMessageTypeTransaction(), this::setMessageTypeTransaction);
			merger.mergeBasic(getMessageTypePPD(), o.getMessageTypePPD(), this::setMessageTypePPD);
			merger.mergeBasic(getVersionTransaction(), o.getVersionTransaction(), this::setVersionTransaction);
			merger.mergeBasic(getVersionPPD(), o.getVersionPPD(), this::setVersionPPD);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DTCCAdditionalFields _that = getType().cast(o);
		
			if (!Objects.equals(originalSwapSDRIDType, _that.getOriginalSwapSDRIDType())) return false;
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(messageTypeTransaction, _that.getMessageTypeTransaction())) return false;
			if (!Objects.equals(messageTypePPD, _that.getMessageTypePPD())) return false;
			if (!Objects.equals(versionTransaction, _that.getVersionTransaction())) return false;
			if (!Objects.equals(versionPPD, _that.getVersionPPD())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (originalSwapSDRIDType != null ? originalSwapSDRIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.hashCode() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (messageTypeTransaction != null ? messageTypeTransaction.hashCode() : 0);
			_result = 31 * _result + (messageTypePPD != null ? messageTypePPD.hashCode() : 0);
			_result = 31 * _result + (versionTransaction != null ? versionTransaction.hashCode() : 0);
			_result = 31 * _result + (versionPPD != null ? versionPPD.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DTCCAdditionalFieldsBuilder {" +
				"originalSwapSDRIDType=" + this.originalSwapSDRIDType + ", " +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"messageID=" + this.messageID + ", " +
				"messageTypeTransaction=" + this.messageTypeTransaction + ", " +
				"messageTypePPD=" + this.messageTypePPD + ", " +
				"versionTransaction=" + this.versionTransaction + ", " +
				"versionPPD=" + this.versionPPD +
			'}' + " " + super.toString();
		}
	}
}
