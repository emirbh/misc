package drr.regulation.common.dtcc.trade;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.dtcc.trade.meta.CommonDTCCAdditionalFieldsMeta;
import drr.standards.iso.OptionStyleEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="CommonDTCCAdditionalFields", builder=CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilderImpl.class, version="7.7.0")
@RuneDataType(value="CommonDTCCAdditionalFields", model="drr", builder=CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilderImpl.class, version="7.7.0")
public interface CommonDTCCAdditionalFields extends RosettaModelObject {

	CommonDTCCAdditionalFieldsMeta metaData = new CommonDTCCAdditionalFieldsMeta();

	/*********************** Getter Methods  ***********************/
	PartyIdentifierTypeEnum getClearingVenueIDType();
	PartyIdentifierTypeEnum getTradeParty1ClearingBrokerIDType();
	PartyIdentifierTypeEnum getSubmittingPartyIDType();
	String getSubmittedForParty();
	String getTradeLegTypes();
	List<SupervisoryBodyEnum> getTradeParty1ReportingDestination();
	List<SupervisoryBodyEnum> getTradeParty2ReportingDestination();
	AssetClassEnum getPrimaryAssetClass();
	AssetClassEnum getSecondaryAssetClass();
	String getComment1();
	OptionStyleEnum getOptionStyle();
	String getOptionType();
	String getProductID();
	String getTradeParty2ExecutionAgentID();
	PartyIdentifierTypeEnum getTradeParty2ExecutionAgentIDType();
	String getTradeParty1ExecutionAgentID();
	PartyIdentifierTypeEnum getTradeParty1ExecutionAgentIDType();
	String getTradeParty1TransactionID();
	String getSettlementType();
	List<? extends ProductGradeReport> getProductGrade();
	String getDeliveryLocation();
	String getLeg1CommodityInstrumentID();
	String getLeg2CommodityInstrumentID();
	PartyIdentifierTypeEnum getResponsibleDataSubmitterIDType();
	String getResponsibleDataSubmitterID();
	Date getMaturityDateOfTheUnderlying();
	String getCorporateActionNewTradeParty1Lei();
	List<String> getOtherPaymentPayerIDType();
	List<String> getOtherPaymentReceiverIDType();
	Boolean getSefOrDcmAnonymousExecutionIndicator();
	String getExecutionVenueID();
	PartyIdentifierTypeEnum getExecutionVenueIDType();
	String getLeg1FloatingRateIndex();
	String getLeg2FloatingRateIndex();
	List<String> getUnderlyingAssetName();
	List<? extends UnderlyingAssetReport> getUnderlyingAsset();

	/*********************** Build Methods  ***********************/
	CommonDTCCAdditionalFields build();
	
	CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder toBuilder();
	
	static CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder builder() {
		return new CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonDTCCAdditionalFields> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonDTCCAdditionalFields> getType() {
		return CommonDTCCAdditionalFields.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonDTCCAdditionalFieldsBuilder extends CommonDTCCAdditionalFields, RosettaModelObjectBuilder {
		ProductGradeReport.ProductGradeReportBuilder getOrCreateProductGrade(int index);
		@Override
		List<? extends ProductGradeReport.ProductGradeReportBuilder> getProductGrade();
		UnderlyingAssetReport.UnderlyingAssetReportBuilder getOrCreateUnderlyingAsset(int index);
		@Override
		List<? extends UnderlyingAssetReport.UnderlyingAssetReportBuilder> getUnderlyingAsset();
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setClearingVenueIDType(PartyIdentifierTypeEnum clearingVenueIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1ClearingBrokerIDType(PartyIdentifierTypeEnum tradeParty1ClearingBrokerIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum submittingPartyIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSubmittedForParty(String submittedForParty);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeLegTypes(String tradeLegTypes);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination, int idx);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum tradeParty2ReportingDestination);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum tradeParty2ReportingDestination, int idx);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestination);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestination);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setPrimaryAssetClass(AssetClassEnum primaryAssetClass);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSecondaryAssetClass(AssetClassEnum secondaryAssetClass);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setComment1(String comment1);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setOptionStyle(OptionStyleEnum optionStyle);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setOptionType(String optionType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setProductID(String productID);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty2ExecutionAgentID(String tradeParty2ExecutionAgentID);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty2ExecutionAgentIDType(PartyIdentifierTypeEnum tradeParty2ExecutionAgentIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1ExecutionAgentID(String tradeParty1ExecutionAgentID);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1ExecutionAgentIDType(PartyIdentifierTypeEnum tradeParty1ExecutionAgentIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1TransactionID(String tradeParty1TransactionID);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSettlementType(String settlementType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addProductGrade(ProductGradeReport productGrade);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addProductGrade(ProductGradeReport productGrade, int idx);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addProductGrade(List<? extends ProductGradeReport> productGrade);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setProductGrade(List<? extends ProductGradeReport> productGrade);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setDeliveryLocation(String deliveryLocation);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setLeg1CommodityInstrumentID(String leg1CommodityInstrumentID);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setLeg2CommodityInstrumentID(String leg2CommodityInstrumentID);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setResponsibleDataSubmitterIDType(PartyIdentifierTypeEnum responsibleDataSubmitterIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setResponsibleDataSubmitterID(String responsibleDataSubmitterID);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setMaturityDateOfTheUnderlying(Date maturityDateOfTheUnderlying);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setCorporateActionNewTradeParty1Lei(String corporateActionNewTradeParty1Lei);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(String otherPaymentPayerIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(String otherPaymentPayerIDType, int idx);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(List<String> otherPaymentPayerIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setOtherPaymentPayerIDType(List<String> otherPaymentPayerIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(String otherPaymentReceiverIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(String otherPaymentReceiverIDType, int idx);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(List<String> otherPaymentReceiverIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setOtherPaymentReceiverIDType(List<String> otherPaymentReceiverIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSefOrDcmAnonymousExecutionIndicator(Boolean sefOrDcmAnonymousExecutionIndicator);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setExecutionVenueID(String executionVenueID);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setExecutionVenueIDType(PartyIdentifierTypeEnum executionVenueIDType);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setLeg1FloatingRateIndex(String leg1FloatingRateIndex);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setLeg2FloatingRateIndex(String leg2FloatingRateIndex);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAssetName(String underlyingAssetName);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAssetName(String underlyingAssetName, int idx);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAssetName(List<String> underlyingAssetName);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setUnderlyingAssetName(List<String> underlyingAssetName);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAsset(UnderlyingAssetReport underlyingAsset);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAsset(UnderlyingAssetReport underlyingAsset, int idx);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAsset(List<? extends UnderlyingAssetReport> underlyingAsset);
		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setUnderlyingAsset(List<? extends UnderlyingAssetReport> underlyingAsset);

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
		}
		

		CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder prune();
	}

	/*********************** Immutable Implementation of CommonDTCCAdditionalFields  ***********************/
	class CommonDTCCAdditionalFieldsImpl implements CommonDTCCAdditionalFields {
		private final PartyIdentifierTypeEnum clearingVenueIDType;
		private final PartyIdentifierTypeEnum tradeParty1ClearingBrokerIDType;
		private final PartyIdentifierTypeEnum submittingPartyIDType;
		private final String submittedForParty;
		private final String tradeLegTypes;
		private final List<SupervisoryBodyEnum> tradeParty1ReportingDestination;
		private final List<SupervisoryBodyEnum> tradeParty2ReportingDestination;
		private final AssetClassEnum primaryAssetClass;
		private final AssetClassEnum secondaryAssetClass;
		private final String comment1;
		private final OptionStyleEnum optionStyle;
		private final String optionType;
		private final String productID;
		private final String tradeParty2ExecutionAgentID;
		private final PartyIdentifierTypeEnum tradeParty2ExecutionAgentIDType;
		private final String tradeParty1ExecutionAgentID;
		private final PartyIdentifierTypeEnum tradeParty1ExecutionAgentIDType;
		private final String tradeParty1TransactionID;
		private final String settlementType;
		private final List<? extends ProductGradeReport> productGrade;
		private final String deliveryLocation;
		private final String leg1CommodityInstrumentID;
		private final String leg2CommodityInstrumentID;
		private final PartyIdentifierTypeEnum responsibleDataSubmitterIDType;
		private final String responsibleDataSubmitterID;
		private final Date maturityDateOfTheUnderlying;
		private final String corporateActionNewTradeParty1Lei;
		private final List<String> otherPaymentPayerIDType;
		private final List<String> otherPaymentReceiverIDType;
		private final Boolean sefOrDcmAnonymousExecutionIndicator;
		private final String executionVenueID;
		private final PartyIdentifierTypeEnum executionVenueIDType;
		private final String leg1FloatingRateIndex;
		private final String leg2FloatingRateIndex;
		private final List<String> underlyingAssetName;
		private final List<? extends UnderlyingAssetReport> underlyingAsset;
		
		protected CommonDTCCAdditionalFieldsImpl(CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder builder) {
			this.clearingVenueIDType = builder.getClearingVenueIDType();
			this.tradeParty1ClearingBrokerIDType = builder.getTradeParty1ClearingBrokerIDType();
			this.submittingPartyIDType = builder.getSubmittingPartyIDType();
			this.submittedForParty = builder.getSubmittedForParty();
			this.tradeLegTypes = builder.getTradeLegTypes();
			this.tradeParty1ReportingDestination = ofNullable(builder.getTradeParty1ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty2ReportingDestination = ofNullable(builder.getTradeParty2ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.primaryAssetClass = builder.getPrimaryAssetClass();
			this.secondaryAssetClass = builder.getSecondaryAssetClass();
			this.comment1 = builder.getComment1();
			this.optionStyle = builder.getOptionStyle();
			this.optionType = builder.getOptionType();
			this.productID = builder.getProductID();
			this.tradeParty2ExecutionAgentID = builder.getTradeParty2ExecutionAgentID();
			this.tradeParty2ExecutionAgentIDType = builder.getTradeParty2ExecutionAgentIDType();
			this.tradeParty1ExecutionAgentID = builder.getTradeParty1ExecutionAgentID();
			this.tradeParty1ExecutionAgentIDType = builder.getTradeParty1ExecutionAgentIDType();
			this.tradeParty1TransactionID = builder.getTradeParty1TransactionID();
			this.settlementType = builder.getSettlementType();
			this.productGrade = ofNullable(builder.getProductGrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.deliveryLocation = builder.getDeliveryLocation();
			this.leg1CommodityInstrumentID = builder.getLeg1CommodityInstrumentID();
			this.leg2CommodityInstrumentID = builder.getLeg2CommodityInstrumentID();
			this.responsibleDataSubmitterIDType = builder.getResponsibleDataSubmitterIDType();
			this.responsibleDataSubmitterID = builder.getResponsibleDataSubmitterID();
			this.maturityDateOfTheUnderlying = builder.getMaturityDateOfTheUnderlying();
			this.corporateActionNewTradeParty1Lei = builder.getCorporateActionNewTradeParty1Lei();
			this.otherPaymentPayerIDType = ofNullable(builder.getOtherPaymentPayerIDType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.otherPaymentReceiverIDType = ofNullable(builder.getOtherPaymentReceiverIDType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.sefOrDcmAnonymousExecutionIndicator = builder.getSefOrDcmAnonymousExecutionIndicator();
			this.executionVenueID = builder.getExecutionVenueID();
			this.executionVenueIDType = builder.getExecutionVenueIDType();
			this.leg1FloatingRateIndex = builder.getLeg1FloatingRateIndex();
			this.leg2FloatingRateIndex = builder.getLeg2FloatingRateIndex();
			this.underlyingAssetName = ofNullable(builder.getUnderlyingAssetName()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("clearingVenueIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingVenueIDType")
		public PartyIdentifierTypeEnum getClearingVenueIDType() {
			return clearingVenueIDType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ClearingBrokerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ClearingBrokerIDType")
		public PartyIdentifierTypeEnum getTradeParty1ClearingBrokerIDType() {
			return tradeParty1ClearingBrokerIDType;
		}
		
		@Override
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submittingPartyIDType")
		public PartyIdentifierTypeEnum getSubmittingPartyIDType() {
			return submittingPartyIDType;
		}
		
		@Override
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submittedForParty")
		public String getSubmittedForParty() {
			return submittedForParty;
		}
		
		@Override
		@RosettaAttribute("tradeLegTypes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeLegTypes")
		public String getTradeLegTypes() {
			return tradeLegTypes;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<SupervisoryBodyEnum> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		public List<SupervisoryBodyEnum> getTradeParty2ReportingDestination() {
			return tradeParty2ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("primaryAssetClass")
		public AssetClassEnum getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryAssetClass")
		public AssetClassEnum getSecondaryAssetClass() {
			return secondaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment1")
		public String getComment1() {
			return comment1;
		}
		
		@Override
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionStyle")
		public OptionStyleEnum getOptionStyle() {
			return optionStyle;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public String getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("productID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productID")
		public String getProductID() {
			return productID;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ExecutionAgentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2ExecutionAgentID")
		public String getTradeParty2ExecutionAgentID() {
			return tradeParty2ExecutionAgentID;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ExecutionAgentIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2ExecutionAgentIDType")
		public PartyIdentifierTypeEnum getTradeParty2ExecutionAgentIDType() {
			return tradeParty2ExecutionAgentIDType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ExecutionAgentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ExecutionAgentID")
		public String getTradeParty1ExecutionAgentID() {
			return tradeParty1ExecutionAgentID;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ExecutionAgentIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ExecutionAgentIDType")
		public PartyIdentifierTypeEnum getTradeParty1ExecutionAgentIDType() {
			return tradeParty1ExecutionAgentIDType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1TransactionID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1TransactionID")
		public String getTradeParty1TransactionID() {
			return tradeParty1TransactionID;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public String getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productGrade")
		public List<? extends ProductGradeReport> getProductGrade() {
			return productGrade;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryLocation")
		public String getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		@RosettaAttribute("leg1CommodityInstrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1CommodityInstrumentID")
		public String getLeg1CommodityInstrumentID() {
			return leg1CommodityInstrumentID;
		}
		
		@Override
		@RosettaAttribute("leg2CommodityInstrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2CommodityInstrumentID")
		public String getLeg2CommodityInstrumentID() {
			return leg2CommodityInstrumentID;
		}
		
		@Override
		@RosettaAttribute("responsibleDataSubmitterIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("responsibleDataSubmitterIDType")
		public PartyIdentifierTypeEnum getResponsibleDataSubmitterIDType() {
			return responsibleDataSubmitterIDType;
		}
		
		@Override
		@RosettaAttribute("responsibleDataSubmitterID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("responsibleDataSubmitterID")
		public String getResponsibleDataSubmitterID() {
			return responsibleDataSubmitterID;
		}
		
		@Override
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		public Date getMaturityDateOfTheUnderlying() {
			return maturityDateOfTheUnderlying;
		}
		
		@Override
		@RosettaAttribute("corporateActionNewTradeParty1Lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateActionNewTradeParty1Lei")
		public String getCorporateActionNewTradeParty1Lei() {
			return corporateActionNewTradeParty1Lei;
		}
		
		@Override
		@RosettaAttribute("otherPaymentPayerIDType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPaymentPayerIDType")
		public List<String> getOtherPaymentPayerIDType() {
			return otherPaymentPayerIDType;
		}
		
		@Override
		@RosettaAttribute("otherPaymentReceiverIDType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPaymentReceiverIDType")
		public List<String> getOtherPaymentReceiverIDType() {
			return otherPaymentReceiverIDType;
		}
		
		@Override
		@RosettaAttribute("sefOrDcmAnonymousExecutionIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sefOrDcmAnonymousExecutionIndicator")
		public Boolean getSefOrDcmAnonymousExecutionIndicator() {
			return sefOrDcmAnonymousExecutionIndicator;
		}
		
		@Override
		@RosettaAttribute("executionVenueID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueID")
		public String getExecutionVenueID() {
			return executionVenueID;
		}
		
		@Override
		@RosettaAttribute("executionVenueIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueIDType")
		public PartyIdentifierTypeEnum getExecutionVenueIDType() {
			return executionVenueIDType;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1FloatingRateIndex")
		public String getLeg1FloatingRateIndex() {
			return leg1FloatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2FloatingRateIndex")
		public String getLeg2FloatingRateIndex() {
			return leg2FloatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetName")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetName")
		public List<String> getUnderlyingAssetName() {
			return underlyingAssetName;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAsset")
		public List<? extends UnderlyingAssetReport> getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public CommonDTCCAdditionalFields build() {
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder toBuilder() {
			CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder builder) {
			ofNullable(getClearingVenueIDType()).ifPresent(builder::setClearingVenueIDType);
			ofNullable(getTradeParty1ClearingBrokerIDType()).ifPresent(builder::setTradeParty1ClearingBrokerIDType);
			ofNullable(getSubmittingPartyIDType()).ifPresent(builder::setSubmittingPartyIDType);
			ofNullable(getSubmittedForParty()).ifPresent(builder::setSubmittedForParty);
			ofNullable(getTradeLegTypes()).ifPresent(builder::setTradeLegTypes);
			ofNullable(getTradeParty1ReportingDestination()).ifPresent(builder::setTradeParty1ReportingDestination);
			ofNullable(getTradeParty2ReportingDestination()).ifPresent(builder::setTradeParty2ReportingDestination);
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getSecondaryAssetClass()).ifPresent(builder::setSecondaryAssetClass);
			ofNullable(getComment1()).ifPresent(builder::setComment1);
			ofNullable(getOptionStyle()).ifPresent(builder::setOptionStyle);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getProductID()).ifPresent(builder::setProductID);
			ofNullable(getTradeParty2ExecutionAgentID()).ifPresent(builder::setTradeParty2ExecutionAgentID);
			ofNullable(getTradeParty2ExecutionAgentIDType()).ifPresent(builder::setTradeParty2ExecutionAgentIDType);
			ofNullable(getTradeParty1ExecutionAgentID()).ifPresent(builder::setTradeParty1ExecutionAgentID);
			ofNullable(getTradeParty1ExecutionAgentIDType()).ifPresent(builder::setTradeParty1ExecutionAgentIDType);
			ofNullable(getTradeParty1TransactionID()).ifPresent(builder::setTradeParty1TransactionID);
			ofNullable(getSettlementType()).ifPresent(builder::setSettlementType);
			ofNullable(getProductGrade()).ifPresent(builder::setProductGrade);
			ofNullable(getDeliveryLocation()).ifPresent(builder::setDeliveryLocation);
			ofNullable(getLeg1CommodityInstrumentID()).ifPresent(builder::setLeg1CommodityInstrumentID);
			ofNullable(getLeg2CommodityInstrumentID()).ifPresent(builder::setLeg2CommodityInstrumentID);
			ofNullable(getResponsibleDataSubmitterIDType()).ifPresent(builder::setResponsibleDataSubmitterIDType);
			ofNullable(getResponsibleDataSubmitterID()).ifPresent(builder::setResponsibleDataSubmitterID);
			ofNullable(getMaturityDateOfTheUnderlying()).ifPresent(builder::setMaturityDateOfTheUnderlying);
			ofNullable(getCorporateActionNewTradeParty1Lei()).ifPresent(builder::setCorporateActionNewTradeParty1Lei);
			ofNullable(getOtherPaymentPayerIDType()).ifPresent(builder::setOtherPaymentPayerIDType);
			ofNullable(getOtherPaymentReceiverIDType()).ifPresent(builder::setOtherPaymentReceiverIDType);
			ofNullable(getSefOrDcmAnonymousExecutionIndicator()).ifPresent(builder::setSefOrDcmAnonymousExecutionIndicator);
			ofNullable(getExecutionVenueID()).ifPresent(builder::setExecutionVenueID);
			ofNullable(getExecutionVenueIDType()).ifPresent(builder::setExecutionVenueIDType);
			ofNullable(getLeg1FloatingRateIndex()).ifPresent(builder::setLeg1FloatingRateIndex);
			ofNullable(getLeg2FloatingRateIndex()).ifPresent(builder::setLeg2FloatingRateIndex);
			ofNullable(getUnderlyingAssetName()).ifPresent(builder::setUnderlyingAssetName);
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonDTCCAdditionalFields _that = getType().cast(o);
		
			if (!Objects.equals(clearingVenueIDType, _that.getClearingVenueIDType())) return false;
			if (!Objects.equals(tradeParty1ClearingBrokerIDType, _that.getTradeParty1ClearingBrokerIDType())) return false;
			if (!Objects.equals(submittingPartyIDType, _that.getSubmittingPartyIDType())) return false;
			if (!Objects.equals(submittedForParty, _that.getSubmittedForParty())) return false;
			if (!Objects.equals(tradeLegTypes, _that.getTradeLegTypes())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!ListEquals.listEquals(tradeParty2ReportingDestination, _that.getTradeParty2ReportingDestination())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!Objects.equals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!Objects.equals(comment1, _that.getComment1())) return false;
			if (!Objects.equals(optionStyle, _that.getOptionStyle())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(productID, _that.getProductID())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentID, _that.getTradeParty2ExecutionAgentID())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentIDType, _that.getTradeParty2ExecutionAgentIDType())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentID, _that.getTradeParty1ExecutionAgentID())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentIDType, _that.getTradeParty1ExecutionAgentIDType())) return false;
			if (!Objects.equals(tradeParty1TransactionID, _that.getTradeParty1TransactionID())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!ListEquals.listEquals(productGrade, _that.getProductGrade())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			if (!Objects.equals(leg1CommodityInstrumentID, _that.getLeg1CommodityInstrumentID())) return false;
			if (!Objects.equals(leg2CommodityInstrumentID, _that.getLeg2CommodityInstrumentID())) return false;
			if (!Objects.equals(responsibleDataSubmitterIDType, _that.getResponsibleDataSubmitterIDType())) return false;
			if (!Objects.equals(responsibleDataSubmitterID, _that.getResponsibleDataSubmitterID())) return false;
			if (!Objects.equals(maturityDateOfTheUnderlying, _that.getMaturityDateOfTheUnderlying())) return false;
			if (!Objects.equals(corporateActionNewTradeParty1Lei, _that.getCorporateActionNewTradeParty1Lei())) return false;
			if (!ListEquals.listEquals(otherPaymentPayerIDType, _that.getOtherPaymentPayerIDType())) return false;
			if (!ListEquals.listEquals(otherPaymentReceiverIDType, _that.getOtherPaymentReceiverIDType())) return false;
			if (!Objects.equals(sefOrDcmAnonymousExecutionIndicator, _that.getSefOrDcmAnonymousExecutionIndicator())) return false;
			if (!Objects.equals(executionVenueID, _that.getExecutionVenueID())) return false;
			if (!Objects.equals(executionVenueIDType, _that.getExecutionVenueIDType())) return false;
			if (!Objects.equals(leg1FloatingRateIndex, _that.getLeg1FloatingRateIndex())) return false;
			if (!Objects.equals(leg2FloatingRateIndex, _that.getLeg2FloatingRateIndex())) return false;
			if (!ListEquals.listEquals(underlyingAssetName, _that.getUnderlyingAssetName())) return false;
			if (!ListEquals.listEquals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearingVenueIDType != null ? clearingVenueIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1ClearingBrokerIDType != null ? tradeParty1ClearingBrokerIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittingPartyIDType != null ? submittingPartyIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittedForParty != null ? submittedForParty.hashCode() : 0);
			_result = 31 * _result + (tradeLegTypes != null ? tradeLegTypes.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (tradeParty2ReportingDestination != null ? tradeParty2ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (comment1 != null ? comment1.hashCode() : 0);
			_result = 31 * _result + (optionStyle != null ? optionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.hashCode() : 0);
			_result = 31 * _result + (productID != null ? productID.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentID != null ? tradeParty2ExecutionAgentID.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentIDType != null ? tradeParty2ExecutionAgentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentID != null ? tradeParty1ExecutionAgentID.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentIDType != null ? tradeParty1ExecutionAgentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1TransactionID != null ? tradeParty1TransactionID.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.hashCode() : 0);
			_result = 31 * _result + (productGrade != null ? productGrade.hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			_result = 31 * _result + (leg1CommodityInstrumentID != null ? leg1CommodityInstrumentID.hashCode() : 0);
			_result = 31 * _result + (leg2CommodityInstrumentID != null ? leg2CommodityInstrumentID.hashCode() : 0);
			_result = 31 * _result + (responsibleDataSubmitterIDType != null ? responsibleDataSubmitterIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (responsibleDataSubmitterID != null ? responsibleDataSubmitterID.hashCode() : 0);
			_result = 31 * _result + (maturityDateOfTheUnderlying != null ? maturityDateOfTheUnderlying.hashCode() : 0);
			_result = 31 * _result + (corporateActionNewTradeParty1Lei != null ? corporateActionNewTradeParty1Lei.hashCode() : 0);
			_result = 31 * _result + (otherPaymentPayerIDType != null ? otherPaymentPayerIDType.hashCode() : 0);
			_result = 31 * _result + (otherPaymentReceiverIDType != null ? otherPaymentReceiverIDType.hashCode() : 0);
			_result = 31 * _result + (sefOrDcmAnonymousExecutionIndicator != null ? sefOrDcmAnonymousExecutionIndicator.hashCode() : 0);
			_result = 31 * _result + (executionVenueID != null ? executionVenueID.hashCode() : 0);
			_result = 31 * _result + (executionVenueIDType != null ? executionVenueIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateIndex != null ? leg1FloatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateIndex != null ? leg2FloatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetName != null ? underlyingAssetName.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonDTCCAdditionalFields {" +
				"clearingVenueIDType=" + this.clearingVenueIDType + ", " +
				"tradeParty1ClearingBrokerIDType=" + this.tradeParty1ClearingBrokerIDType + ", " +
				"submittingPartyIDType=" + this.submittingPartyIDType + ", " +
				"submittedForParty=" + this.submittedForParty + ", " +
				"tradeLegTypes=" + this.tradeLegTypes + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"tradeParty2ReportingDestination=" + this.tradeParty2ReportingDestination + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"comment1=" + this.comment1 + ", " +
				"optionStyle=" + this.optionStyle + ", " +
				"optionType=" + this.optionType + ", " +
				"productID=" + this.productID + ", " +
				"tradeParty2ExecutionAgentID=" + this.tradeParty2ExecutionAgentID + ", " +
				"tradeParty2ExecutionAgentIDType=" + this.tradeParty2ExecutionAgentIDType + ", " +
				"tradeParty1ExecutionAgentID=" + this.tradeParty1ExecutionAgentID + ", " +
				"tradeParty1ExecutionAgentIDType=" + this.tradeParty1ExecutionAgentIDType + ", " +
				"tradeParty1TransactionID=" + this.tradeParty1TransactionID + ", " +
				"settlementType=" + this.settlementType + ", " +
				"productGrade=" + this.productGrade + ", " +
				"deliveryLocation=" + this.deliveryLocation + ", " +
				"leg1CommodityInstrumentID=" + this.leg1CommodityInstrumentID + ", " +
				"leg2CommodityInstrumentID=" + this.leg2CommodityInstrumentID + ", " +
				"responsibleDataSubmitterIDType=" + this.responsibleDataSubmitterIDType + ", " +
				"responsibleDataSubmitterID=" + this.responsibleDataSubmitterID + ", " +
				"maturityDateOfTheUnderlying=" + this.maturityDateOfTheUnderlying + ", " +
				"corporateActionNewTradeParty1Lei=" + this.corporateActionNewTradeParty1Lei + ", " +
				"otherPaymentPayerIDType=" + this.otherPaymentPayerIDType + ", " +
				"otherPaymentReceiverIDType=" + this.otherPaymentReceiverIDType + ", " +
				"sefOrDcmAnonymousExecutionIndicator=" + this.sefOrDcmAnonymousExecutionIndicator + ", " +
				"executionVenueID=" + this.executionVenueID + ", " +
				"executionVenueIDType=" + this.executionVenueIDType + ", " +
				"leg1FloatingRateIndex=" + this.leg1FloatingRateIndex + ", " +
				"leg2FloatingRateIndex=" + this.leg2FloatingRateIndex + ", " +
				"underlyingAssetName=" + this.underlyingAssetName + ", " +
				"underlyingAsset=" + this.underlyingAsset +
			'}';
		}
	}

	/*********************** Builder Implementation of CommonDTCCAdditionalFields  ***********************/
	class CommonDTCCAdditionalFieldsBuilderImpl implements CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder {
	
		protected PartyIdentifierTypeEnum clearingVenueIDType;
		protected PartyIdentifierTypeEnum tradeParty1ClearingBrokerIDType;
		protected PartyIdentifierTypeEnum submittingPartyIDType;
		protected String submittedForParty;
		protected String tradeLegTypes;
		protected List<SupervisoryBodyEnum> tradeParty1ReportingDestination = new ArrayList<>();
		protected List<SupervisoryBodyEnum> tradeParty2ReportingDestination = new ArrayList<>();
		protected AssetClassEnum primaryAssetClass;
		protected AssetClassEnum secondaryAssetClass;
		protected String comment1;
		protected OptionStyleEnum optionStyle;
		protected String optionType;
		protected String productID;
		protected String tradeParty2ExecutionAgentID;
		protected PartyIdentifierTypeEnum tradeParty2ExecutionAgentIDType;
		protected String tradeParty1ExecutionAgentID;
		protected PartyIdentifierTypeEnum tradeParty1ExecutionAgentIDType;
		protected String tradeParty1TransactionID;
		protected String settlementType;
		protected List<ProductGradeReport.ProductGradeReportBuilder> productGrade = new ArrayList<>();
		protected String deliveryLocation;
		protected String leg1CommodityInstrumentID;
		protected String leg2CommodityInstrumentID;
		protected PartyIdentifierTypeEnum responsibleDataSubmitterIDType;
		protected String responsibleDataSubmitterID;
		protected Date maturityDateOfTheUnderlying;
		protected String corporateActionNewTradeParty1Lei;
		protected List<String> otherPaymentPayerIDType = new ArrayList<>();
		protected List<String> otherPaymentReceiverIDType = new ArrayList<>();
		protected Boolean sefOrDcmAnonymousExecutionIndicator;
		protected String executionVenueID;
		protected PartyIdentifierTypeEnum executionVenueIDType;
		protected String leg1FloatingRateIndex;
		protected String leg2FloatingRateIndex;
		protected List<String> underlyingAssetName = new ArrayList<>();
		protected List<UnderlyingAssetReport.UnderlyingAssetReportBuilder> underlyingAsset = new ArrayList<>();
		
		@Override
		@RosettaAttribute("clearingVenueIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearingVenueIDType")
		public PartyIdentifierTypeEnum getClearingVenueIDType() {
			return clearingVenueIDType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ClearingBrokerIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ClearingBrokerIDType")
		public PartyIdentifierTypeEnum getTradeParty1ClearingBrokerIDType() {
			return tradeParty1ClearingBrokerIDType;
		}
		
		@Override
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submittingPartyIDType")
		public PartyIdentifierTypeEnum getSubmittingPartyIDType() {
			return submittingPartyIDType;
		}
		
		@Override
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("submittedForParty")
		public String getSubmittedForParty() {
			return submittedForParty;
		}
		
		@Override
		@RosettaAttribute("tradeLegTypes")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeLegTypes")
		public String getTradeLegTypes() {
			return tradeLegTypes;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<SupervisoryBodyEnum> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		public List<SupervisoryBodyEnum> getTradeParty2ReportingDestination() {
			return tradeParty2ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("primaryAssetClass")
		public AssetClassEnum getPrimaryAssetClass() {
			return primaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("secondaryAssetClass")
		public AssetClassEnum getSecondaryAssetClass() {
			return secondaryAssetClass;
		}
		
		@Override
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment1")
		public String getComment1() {
			return comment1;
		}
		
		@Override
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionStyle")
		public OptionStyleEnum getOptionStyle() {
			return optionStyle;
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public String getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("productID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("productID")
		public String getProductID() {
			return productID;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ExecutionAgentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2ExecutionAgentID")
		public String getTradeParty2ExecutionAgentID() {
			return tradeParty2ExecutionAgentID;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ExecutionAgentIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty2ExecutionAgentIDType")
		public PartyIdentifierTypeEnum getTradeParty2ExecutionAgentIDType() {
			return tradeParty2ExecutionAgentIDType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ExecutionAgentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ExecutionAgentID")
		public String getTradeParty1ExecutionAgentID() {
			return tradeParty1ExecutionAgentID;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ExecutionAgentIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1ExecutionAgentIDType")
		public PartyIdentifierTypeEnum getTradeParty1ExecutionAgentIDType() {
			return tradeParty1ExecutionAgentIDType;
		}
		
		@Override
		@RosettaAttribute("tradeParty1TransactionID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1TransactionID")
		public String getTradeParty1TransactionID() {
			return tradeParty1TransactionID;
		}
		
		@Override
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementType")
		public String getSettlementType() {
			return settlementType;
		}
		
		@Override
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productGrade")
		public List<? extends ProductGradeReport.ProductGradeReportBuilder> getProductGrade() {
			return productGrade;
		}
		
		@Override
		public ProductGradeReport.ProductGradeReportBuilder getOrCreateProductGrade(int index) {
			if (productGrade==null) {
				this.productGrade = new ArrayList<>();
			}
			return getIndex(productGrade, index, () -> {
						ProductGradeReport.ProductGradeReportBuilder newProductGrade = ProductGradeReport.builder();
						return newProductGrade;
					});
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryLocation")
		public String getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		@RosettaAttribute("leg1CommodityInstrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1CommodityInstrumentID")
		public String getLeg1CommodityInstrumentID() {
			return leg1CommodityInstrumentID;
		}
		
		@Override
		@RosettaAttribute("leg2CommodityInstrumentID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2CommodityInstrumentID")
		public String getLeg2CommodityInstrumentID() {
			return leg2CommodityInstrumentID;
		}
		
		@Override
		@RosettaAttribute("responsibleDataSubmitterIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("responsibleDataSubmitterIDType")
		public PartyIdentifierTypeEnum getResponsibleDataSubmitterIDType() {
			return responsibleDataSubmitterIDType;
		}
		
		@Override
		@RosettaAttribute("responsibleDataSubmitterID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("responsibleDataSubmitterID")
		public String getResponsibleDataSubmitterID() {
			return responsibleDataSubmitterID;
		}
		
		@Override
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		public Date getMaturityDateOfTheUnderlying() {
			return maturityDateOfTheUnderlying;
		}
		
		@Override
		@RosettaAttribute("corporateActionNewTradeParty1Lei")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("corporateActionNewTradeParty1Lei")
		public String getCorporateActionNewTradeParty1Lei() {
			return corporateActionNewTradeParty1Lei;
		}
		
		@Override
		@RosettaAttribute("otherPaymentPayerIDType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPaymentPayerIDType")
		public List<String> getOtherPaymentPayerIDType() {
			return otherPaymentPayerIDType;
		}
		
		@Override
		@RosettaAttribute("otherPaymentReceiverIDType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPaymentReceiverIDType")
		public List<String> getOtherPaymentReceiverIDType() {
			return otherPaymentReceiverIDType;
		}
		
		@Override
		@RosettaAttribute("sefOrDcmAnonymousExecutionIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sefOrDcmAnonymousExecutionIndicator")
		public Boolean getSefOrDcmAnonymousExecutionIndicator() {
			return sefOrDcmAnonymousExecutionIndicator;
		}
		
		@Override
		@RosettaAttribute("executionVenueID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueID")
		public String getExecutionVenueID() {
			return executionVenueID;
		}
		
		@Override
		@RosettaAttribute("executionVenueIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("executionVenueIDType")
		public PartyIdentifierTypeEnum getExecutionVenueIDType() {
			return executionVenueIDType;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg1FloatingRateIndex")
		public String getLeg1FloatingRateIndex() {
			return leg1FloatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leg2FloatingRateIndex")
		public String getLeg2FloatingRateIndex() {
			return leg2FloatingRateIndex;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetName")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetName")
		public List<String> getUnderlyingAssetName() {
			return underlyingAssetName;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAsset")
		public List<? extends UnderlyingAssetReport.UnderlyingAssetReportBuilder> getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public UnderlyingAssetReport.UnderlyingAssetReportBuilder getOrCreateUnderlyingAsset(int index) {
			if (underlyingAsset==null) {
				this.underlyingAsset = new ArrayList<>();
			}
			return getIndex(underlyingAsset, index, () -> {
						UnderlyingAssetReport.UnderlyingAssetReportBuilder newUnderlyingAsset = UnderlyingAssetReport.builder();
						return newUnderlyingAsset;
					});
		}
		
		@RosettaAttribute("clearingVenueIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearingVenueIDType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setClearingVenueIDType(PartyIdentifierTypeEnum _clearingVenueIDType) {
			this.clearingVenueIDType = _clearingVenueIDType == null ? null : _clearingVenueIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ClearingBrokerIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ClearingBrokerIDType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1ClearingBrokerIDType(PartyIdentifierTypeEnum _tradeParty1ClearingBrokerIDType) {
			this.tradeParty1ClearingBrokerIDType = _tradeParty1ClearingBrokerIDType == null ? null : _tradeParty1ClearingBrokerIDType;
			return this;
		}
		
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submittingPartyIDType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum _submittingPartyIDType) {
			this.submittingPartyIDType = _submittingPartyIDType == null ? null : _submittingPartyIDType;
			return this;
		}
		
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submittedForParty")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSubmittedForParty(String _submittedForParty) {
			this.submittedForParty = _submittedForParty == null ? null : _submittedForParty;
			return this;
		}
		
		@RosettaAttribute("tradeLegTypes")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeLegTypes")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeLegTypes(String _tradeLegTypes) {
			this.tradeLegTypes = _tradeLegTypes == null ? null : _tradeLegTypes;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination) {
			if (_tradeParty1ReportingDestination != null) {
				this.tradeParty1ReportingDestination.add(_tradeParty1ReportingDestination);
			}
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination, int idx) {
			getIndex(this.tradeParty1ReportingDestination, idx, () -> _tradeParty1ReportingDestination);
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum _tradeParty2ReportingDestination) {
			if (_tradeParty2ReportingDestination != null) {
				this.tradeParty2ReportingDestination.add(_tradeParty2ReportingDestination);
			}
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum _tradeParty2ReportingDestination, int idx) {
			getIndex(this.tradeParty2ReportingDestination, idx, () -> _tradeParty2ReportingDestination);
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestinations) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestinations) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setPrimaryAssetClass(AssetClassEnum _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass;
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSecondaryAssetClass(AssetClassEnum _secondaryAssetClass) {
			this.secondaryAssetClass = _secondaryAssetClass == null ? null : _secondaryAssetClass;
			return this;
		}
		
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment1")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setComment1(String _comment1) {
			this.comment1 = _comment1 == null ? null : _comment1;
			return this;
		}
		
		@RosettaAttribute("optionStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionStyle")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setOptionStyle(OptionStyleEnum _optionStyle) {
			this.optionStyle = _optionStyle == null ? null : _optionStyle;
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setOptionType(String _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("productID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("productID")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setProductID(String _productID) {
			this.productID = _productID == null ? null : _productID;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentID")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty2ExecutionAgentID(String _tradeParty2ExecutionAgentID) {
			this.tradeParty2ExecutionAgentID = _tradeParty2ExecutionAgentID == null ? null : _tradeParty2ExecutionAgentID;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentIDType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty2ExecutionAgentIDType(PartyIdentifierTypeEnum _tradeParty2ExecutionAgentIDType) {
			this.tradeParty2ExecutionAgentIDType = _tradeParty2ExecutionAgentIDType == null ? null : _tradeParty2ExecutionAgentIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentID")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1ExecutionAgentID(String _tradeParty1ExecutionAgentID) {
			this.tradeParty1ExecutionAgentID = _tradeParty1ExecutionAgentID == null ? null : _tradeParty1ExecutionAgentID;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentIDType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1ExecutionAgentIDType(PartyIdentifierTypeEnum _tradeParty1ExecutionAgentIDType) {
			this.tradeParty1ExecutionAgentIDType = _tradeParty1ExecutionAgentIDType == null ? null : _tradeParty1ExecutionAgentIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1TransactionID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1TransactionID")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setTradeParty1TransactionID(String _tradeParty1TransactionID) {
			this.tradeParty1TransactionID = _tradeParty1TransactionID == null ? null : _tradeParty1TransactionID;
			return this;
		}
		
		@RosettaAttribute("settlementType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSettlementType(String _settlementType) {
			this.settlementType = _settlementType == null ? null : _settlementType;
			return this;
		}
		
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productGrade")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addProductGrade(ProductGradeReport _productGrade) {
			if (_productGrade != null) {
				this.productGrade.add(_productGrade.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addProductGrade(ProductGradeReport _productGrade, int idx) {
			getIndex(this.productGrade, idx, () -> _productGrade.toBuilder());
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addProductGrade(List<? extends ProductGradeReport> productGrades) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setProductGrade(List<? extends ProductGradeReport> productGrades) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setDeliveryLocation(String _deliveryLocation) {
			this.deliveryLocation = _deliveryLocation == null ? null : _deliveryLocation;
			return this;
		}
		
		@RosettaAttribute("leg1CommodityInstrumentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg1CommodityInstrumentID")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setLeg1CommodityInstrumentID(String _leg1CommodityInstrumentID) {
			this.leg1CommodityInstrumentID = _leg1CommodityInstrumentID == null ? null : _leg1CommodityInstrumentID;
			return this;
		}
		
		@RosettaAttribute("leg2CommodityInstrumentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2CommodityInstrumentID")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setLeg2CommodityInstrumentID(String _leg2CommodityInstrumentID) {
			this.leg2CommodityInstrumentID = _leg2CommodityInstrumentID == null ? null : _leg2CommodityInstrumentID;
			return this;
		}
		
		@RosettaAttribute("responsibleDataSubmitterIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("responsibleDataSubmitterIDType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setResponsibleDataSubmitterIDType(PartyIdentifierTypeEnum _responsibleDataSubmitterIDType) {
			this.responsibleDataSubmitterIDType = _responsibleDataSubmitterIDType == null ? null : _responsibleDataSubmitterIDType;
			return this;
		}
		
		@RosettaAttribute("responsibleDataSubmitterID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("responsibleDataSubmitterID")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setResponsibleDataSubmitterID(String _responsibleDataSubmitterID) {
			this.responsibleDataSubmitterID = _responsibleDataSubmitterID == null ? null : _responsibleDataSubmitterID;
			return this;
		}
		
		@RosettaAttribute("maturityDateOfTheUnderlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maturityDateOfTheUnderlying")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setMaturityDateOfTheUnderlying(Date _maturityDateOfTheUnderlying) {
			this.maturityDateOfTheUnderlying = _maturityDateOfTheUnderlying == null ? null : _maturityDateOfTheUnderlying;
			return this;
		}
		
		@RosettaAttribute("corporateActionNewTradeParty1Lei")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("corporateActionNewTradeParty1Lei")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setCorporateActionNewTradeParty1Lei(String _corporateActionNewTradeParty1Lei) {
			this.corporateActionNewTradeParty1Lei = _corporateActionNewTradeParty1Lei == null ? null : _corporateActionNewTradeParty1Lei;
			return this;
		}
		
		@RosettaAttribute("otherPaymentPayerIDType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPaymentPayerIDType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(String _otherPaymentPayerIDType) {
			if (_otherPaymentPayerIDType != null) {
				this.otherPaymentPayerIDType.add(_otherPaymentPayerIDType);
			}
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(String _otherPaymentPayerIDType, int idx) {
			getIndex(this.otherPaymentPayerIDType, idx, () -> _otherPaymentPayerIDType);
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentPayerIDType(List<String> otherPaymentPayerIDTypes) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setOtherPaymentPayerIDType(List<String> otherPaymentPayerIDTypes) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(String _otherPaymentReceiverIDType) {
			if (_otherPaymentReceiverIDType != null) {
				this.otherPaymentReceiverIDType.add(_otherPaymentReceiverIDType);
			}
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(String _otherPaymentReceiverIDType, int idx) {
			getIndex(this.otherPaymentReceiverIDType, idx, () -> _otherPaymentReceiverIDType);
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addOtherPaymentReceiverIDType(List<String> otherPaymentReceiverIDTypes) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setOtherPaymentReceiverIDType(List<String> otherPaymentReceiverIDTypes) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setSefOrDcmAnonymousExecutionIndicator(Boolean _sefOrDcmAnonymousExecutionIndicator) {
			this.sefOrDcmAnonymousExecutionIndicator = _sefOrDcmAnonymousExecutionIndicator == null ? null : _sefOrDcmAnonymousExecutionIndicator;
			return this;
		}
		
		@RosettaAttribute("executionVenueID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueID")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setExecutionVenueID(String _executionVenueID) {
			this.executionVenueID = _executionVenueID == null ? null : _executionVenueID;
			return this;
		}
		
		@RosettaAttribute("executionVenueIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("executionVenueIDType")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setExecutionVenueIDType(PartyIdentifierTypeEnum _executionVenueIDType) {
			this.executionVenueIDType = _executionVenueIDType == null ? null : _executionVenueIDType;
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg1FloatingRateIndex")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setLeg1FloatingRateIndex(String _leg1FloatingRateIndex) {
			this.leg1FloatingRateIndex = _leg1FloatingRateIndex == null ? null : _leg1FloatingRateIndex;
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leg2FloatingRateIndex")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setLeg2FloatingRateIndex(String _leg2FloatingRateIndex) {
			this.leg2FloatingRateIndex = _leg2FloatingRateIndex == null ? null : _leg2FloatingRateIndex;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetName")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetName")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAssetName(String _underlyingAssetName) {
			if (_underlyingAssetName != null) {
				this.underlyingAssetName.add(_underlyingAssetName);
			}
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAssetName(String _underlyingAssetName, int idx) {
			getIndex(this.underlyingAssetName, idx, () -> _underlyingAssetName);
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAssetName(List<String> underlyingAssetNames) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setUnderlyingAssetName(List<String> underlyingAssetNames) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAsset(UnderlyingAssetReport _underlyingAsset) {
			if (_underlyingAsset != null) {
				this.underlyingAsset.add(_underlyingAsset.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAsset(UnderlyingAssetReport _underlyingAsset, int idx) {
			getIndex(this.underlyingAsset, idx, () -> _underlyingAsset.toBuilder());
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder addUnderlyingAsset(List<? extends UnderlyingAssetReport> underlyingAssets) {
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
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder setUnderlyingAsset(List<? extends UnderlyingAssetReport> underlyingAssets) {
			if (underlyingAssets == null) {
				this.underlyingAsset = new ArrayList<>();
			} else {
				this.underlyingAsset = underlyingAssets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CommonDTCCAdditionalFields build() {
			return new CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsImpl(this);
		}
		
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder prune() {
			productGrade = productGrade.stream().filter(b->b!=null).<ProductGradeReport.ProductGradeReportBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			underlyingAsset = underlyingAsset.stream().filter(b->b!=null).<UnderlyingAssetReport.UnderlyingAssetReportBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getClearingVenueIDType()!=null) return true;
			if (getTradeParty1ClearingBrokerIDType()!=null) return true;
			if (getSubmittingPartyIDType()!=null) return true;
			if (getSubmittedForParty()!=null) return true;
			if (getTradeLegTypes()!=null) return true;
			if (getTradeParty1ReportingDestination()!=null && !getTradeParty1ReportingDestination().isEmpty()) return true;
			if (getTradeParty2ReportingDestination()!=null && !getTradeParty2ReportingDestination().isEmpty()) return true;
			if (getPrimaryAssetClass()!=null) return true;
			if (getSecondaryAssetClass()!=null) return true;
			if (getComment1()!=null) return true;
			if (getOptionStyle()!=null) return true;
			if (getOptionType()!=null) return true;
			if (getProductID()!=null) return true;
			if (getTradeParty2ExecutionAgentID()!=null) return true;
			if (getTradeParty2ExecutionAgentIDType()!=null) return true;
			if (getTradeParty1ExecutionAgentID()!=null) return true;
			if (getTradeParty1ExecutionAgentIDType()!=null) return true;
			if (getTradeParty1TransactionID()!=null) return true;
			if (getSettlementType()!=null) return true;
			if (getProductGrade()!=null && getProductGrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDeliveryLocation()!=null) return true;
			if (getLeg1CommodityInstrumentID()!=null) return true;
			if (getLeg2CommodityInstrumentID()!=null) return true;
			if (getResponsibleDataSubmitterIDType()!=null) return true;
			if (getResponsibleDataSubmitterID()!=null) return true;
			if (getMaturityDateOfTheUnderlying()!=null) return true;
			if (getCorporateActionNewTradeParty1Lei()!=null) return true;
			if (getOtherPaymentPayerIDType()!=null && !getOtherPaymentPayerIDType().isEmpty()) return true;
			if (getOtherPaymentReceiverIDType()!=null && !getOtherPaymentReceiverIDType().isEmpty()) return true;
			if (getSefOrDcmAnonymousExecutionIndicator()!=null) return true;
			if (getExecutionVenueID()!=null) return true;
			if (getExecutionVenueIDType()!=null) return true;
			if (getLeg1FloatingRateIndex()!=null) return true;
			if (getLeg2FloatingRateIndex()!=null) return true;
			if (getUnderlyingAssetName()!=null && !getUnderlyingAssetName().isEmpty()) return true;
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder o = (CommonDTCCAdditionalFields.CommonDTCCAdditionalFieldsBuilder) other;
			
			merger.mergeRosetta(getProductGrade(), o.getProductGrade(), this::getOrCreateProductGrade);
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::getOrCreateUnderlyingAsset);
			
			merger.mergeBasic(getClearingVenueIDType(), o.getClearingVenueIDType(), this::setClearingVenueIDType);
			merger.mergeBasic(getTradeParty1ClearingBrokerIDType(), o.getTradeParty1ClearingBrokerIDType(), this::setTradeParty1ClearingBrokerIDType);
			merger.mergeBasic(getSubmittingPartyIDType(), o.getSubmittingPartyIDType(), this::setSubmittingPartyIDType);
			merger.mergeBasic(getSubmittedForParty(), o.getSubmittedForParty(), this::setSubmittedForParty);
			merger.mergeBasic(getTradeLegTypes(), o.getTradeLegTypes(), this::setTradeLegTypes);
			merger.mergeBasic(getTradeParty1ReportingDestination(), o.getTradeParty1ReportingDestination(), (Consumer<SupervisoryBodyEnum>) this::addTradeParty1ReportingDestination);
			merger.mergeBasic(getTradeParty2ReportingDestination(), o.getTradeParty2ReportingDestination(), (Consumer<SupervisoryBodyEnum>) this::addTradeParty2ReportingDestination);
			merger.mergeBasic(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeBasic(getSecondaryAssetClass(), o.getSecondaryAssetClass(), this::setSecondaryAssetClass);
			merger.mergeBasic(getComment1(), o.getComment1(), this::setComment1);
			merger.mergeBasic(getOptionStyle(), o.getOptionStyle(), this::setOptionStyle);
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getProductID(), o.getProductID(), this::setProductID);
			merger.mergeBasic(getTradeParty2ExecutionAgentID(), o.getTradeParty2ExecutionAgentID(), this::setTradeParty2ExecutionAgentID);
			merger.mergeBasic(getTradeParty2ExecutionAgentIDType(), o.getTradeParty2ExecutionAgentIDType(), this::setTradeParty2ExecutionAgentIDType);
			merger.mergeBasic(getTradeParty1ExecutionAgentID(), o.getTradeParty1ExecutionAgentID(), this::setTradeParty1ExecutionAgentID);
			merger.mergeBasic(getTradeParty1ExecutionAgentIDType(), o.getTradeParty1ExecutionAgentIDType(), this::setTradeParty1ExecutionAgentIDType);
			merger.mergeBasic(getTradeParty1TransactionID(), o.getTradeParty1TransactionID(), this::setTradeParty1TransactionID);
			merger.mergeBasic(getSettlementType(), o.getSettlementType(), this::setSettlementType);
			merger.mergeBasic(getDeliveryLocation(), o.getDeliveryLocation(), this::setDeliveryLocation);
			merger.mergeBasic(getLeg1CommodityInstrumentID(), o.getLeg1CommodityInstrumentID(), this::setLeg1CommodityInstrumentID);
			merger.mergeBasic(getLeg2CommodityInstrumentID(), o.getLeg2CommodityInstrumentID(), this::setLeg2CommodityInstrumentID);
			merger.mergeBasic(getResponsibleDataSubmitterIDType(), o.getResponsibleDataSubmitterIDType(), this::setResponsibleDataSubmitterIDType);
			merger.mergeBasic(getResponsibleDataSubmitterID(), o.getResponsibleDataSubmitterID(), this::setResponsibleDataSubmitterID);
			merger.mergeBasic(getMaturityDateOfTheUnderlying(), o.getMaturityDateOfTheUnderlying(), this::setMaturityDateOfTheUnderlying);
			merger.mergeBasic(getCorporateActionNewTradeParty1Lei(), o.getCorporateActionNewTradeParty1Lei(), this::setCorporateActionNewTradeParty1Lei);
			merger.mergeBasic(getOtherPaymentPayerIDType(), o.getOtherPaymentPayerIDType(), (Consumer<String>) this::addOtherPaymentPayerIDType);
			merger.mergeBasic(getOtherPaymentReceiverIDType(), o.getOtherPaymentReceiverIDType(), (Consumer<String>) this::addOtherPaymentReceiverIDType);
			merger.mergeBasic(getSefOrDcmAnonymousExecutionIndicator(), o.getSefOrDcmAnonymousExecutionIndicator(), this::setSefOrDcmAnonymousExecutionIndicator);
			merger.mergeBasic(getExecutionVenueID(), o.getExecutionVenueID(), this::setExecutionVenueID);
			merger.mergeBasic(getExecutionVenueIDType(), o.getExecutionVenueIDType(), this::setExecutionVenueIDType);
			merger.mergeBasic(getLeg1FloatingRateIndex(), o.getLeg1FloatingRateIndex(), this::setLeg1FloatingRateIndex);
			merger.mergeBasic(getLeg2FloatingRateIndex(), o.getLeg2FloatingRateIndex(), this::setLeg2FloatingRateIndex);
			merger.mergeBasic(getUnderlyingAssetName(), o.getUnderlyingAssetName(), (Consumer<String>) this::addUnderlyingAssetName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonDTCCAdditionalFields _that = getType().cast(o);
		
			if (!Objects.equals(clearingVenueIDType, _that.getClearingVenueIDType())) return false;
			if (!Objects.equals(tradeParty1ClearingBrokerIDType, _that.getTradeParty1ClearingBrokerIDType())) return false;
			if (!Objects.equals(submittingPartyIDType, _that.getSubmittingPartyIDType())) return false;
			if (!Objects.equals(submittedForParty, _that.getSubmittedForParty())) return false;
			if (!Objects.equals(tradeLegTypes, _that.getTradeLegTypes())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!ListEquals.listEquals(tradeParty2ReportingDestination, _that.getTradeParty2ReportingDestination())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!Objects.equals(secondaryAssetClass, _that.getSecondaryAssetClass())) return false;
			if (!Objects.equals(comment1, _that.getComment1())) return false;
			if (!Objects.equals(optionStyle, _that.getOptionStyle())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(productID, _that.getProductID())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentID, _that.getTradeParty2ExecutionAgentID())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentIDType, _that.getTradeParty2ExecutionAgentIDType())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentID, _that.getTradeParty1ExecutionAgentID())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentIDType, _that.getTradeParty1ExecutionAgentIDType())) return false;
			if (!Objects.equals(tradeParty1TransactionID, _that.getTradeParty1TransactionID())) return false;
			if (!Objects.equals(settlementType, _that.getSettlementType())) return false;
			if (!ListEquals.listEquals(productGrade, _that.getProductGrade())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			if (!Objects.equals(leg1CommodityInstrumentID, _that.getLeg1CommodityInstrumentID())) return false;
			if (!Objects.equals(leg2CommodityInstrumentID, _that.getLeg2CommodityInstrumentID())) return false;
			if (!Objects.equals(responsibleDataSubmitterIDType, _that.getResponsibleDataSubmitterIDType())) return false;
			if (!Objects.equals(responsibleDataSubmitterID, _that.getResponsibleDataSubmitterID())) return false;
			if (!Objects.equals(maturityDateOfTheUnderlying, _that.getMaturityDateOfTheUnderlying())) return false;
			if (!Objects.equals(corporateActionNewTradeParty1Lei, _that.getCorporateActionNewTradeParty1Lei())) return false;
			if (!ListEquals.listEquals(otherPaymentPayerIDType, _that.getOtherPaymentPayerIDType())) return false;
			if (!ListEquals.listEquals(otherPaymentReceiverIDType, _that.getOtherPaymentReceiverIDType())) return false;
			if (!Objects.equals(sefOrDcmAnonymousExecutionIndicator, _that.getSefOrDcmAnonymousExecutionIndicator())) return false;
			if (!Objects.equals(executionVenueID, _that.getExecutionVenueID())) return false;
			if (!Objects.equals(executionVenueIDType, _that.getExecutionVenueIDType())) return false;
			if (!Objects.equals(leg1FloatingRateIndex, _that.getLeg1FloatingRateIndex())) return false;
			if (!Objects.equals(leg2FloatingRateIndex, _that.getLeg2FloatingRateIndex())) return false;
			if (!ListEquals.listEquals(underlyingAssetName, _that.getUnderlyingAssetName())) return false;
			if (!ListEquals.listEquals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (clearingVenueIDType != null ? clearingVenueIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1ClearingBrokerIDType != null ? tradeParty1ClearingBrokerIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittingPartyIDType != null ? submittingPartyIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittedForParty != null ? submittedForParty.hashCode() : 0);
			_result = 31 * _result + (tradeLegTypes != null ? tradeLegTypes.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (tradeParty2ReportingDestination != null ? tradeParty2ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (secondaryAssetClass != null ? secondaryAssetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (comment1 != null ? comment1.hashCode() : 0);
			_result = 31 * _result + (optionStyle != null ? optionStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.hashCode() : 0);
			_result = 31 * _result + (productID != null ? productID.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentID != null ? tradeParty2ExecutionAgentID.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentIDType != null ? tradeParty2ExecutionAgentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentID != null ? tradeParty1ExecutionAgentID.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentIDType != null ? tradeParty1ExecutionAgentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1TransactionID != null ? tradeParty1TransactionID.hashCode() : 0);
			_result = 31 * _result + (settlementType != null ? settlementType.hashCode() : 0);
			_result = 31 * _result + (productGrade != null ? productGrade.hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			_result = 31 * _result + (leg1CommodityInstrumentID != null ? leg1CommodityInstrumentID.hashCode() : 0);
			_result = 31 * _result + (leg2CommodityInstrumentID != null ? leg2CommodityInstrumentID.hashCode() : 0);
			_result = 31 * _result + (responsibleDataSubmitterIDType != null ? responsibleDataSubmitterIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (responsibleDataSubmitterID != null ? responsibleDataSubmitterID.hashCode() : 0);
			_result = 31 * _result + (maturityDateOfTheUnderlying != null ? maturityDateOfTheUnderlying.hashCode() : 0);
			_result = 31 * _result + (corporateActionNewTradeParty1Lei != null ? corporateActionNewTradeParty1Lei.hashCode() : 0);
			_result = 31 * _result + (otherPaymentPayerIDType != null ? otherPaymentPayerIDType.hashCode() : 0);
			_result = 31 * _result + (otherPaymentReceiverIDType != null ? otherPaymentReceiverIDType.hashCode() : 0);
			_result = 31 * _result + (sefOrDcmAnonymousExecutionIndicator != null ? sefOrDcmAnonymousExecutionIndicator.hashCode() : 0);
			_result = 31 * _result + (executionVenueID != null ? executionVenueID.hashCode() : 0);
			_result = 31 * _result + (executionVenueIDType != null ? executionVenueIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateIndex != null ? leg1FloatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateIndex != null ? leg2FloatingRateIndex.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetName != null ? underlyingAssetName.hashCode() : 0);
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonDTCCAdditionalFieldsBuilder {" +
				"clearingVenueIDType=" + this.clearingVenueIDType + ", " +
				"tradeParty1ClearingBrokerIDType=" + this.tradeParty1ClearingBrokerIDType + ", " +
				"submittingPartyIDType=" + this.submittingPartyIDType + ", " +
				"submittedForParty=" + this.submittedForParty + ", " +
				"tradeLegTypes=" + this.tradeLegTypes + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"tradeParty2ReportingDestination=" + this.tradeParty2ReportingDestination + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"secondaryAssetClass=" + this.secondaryAssetClass + ", " +
				"comment1=" + this.comment1 + ", " +
				"optionStyle=" + this.optionStyle + ", " +
				"optionType=" + this.optionType + ", " +
				"productID=" + this.productID + ", " +
				"tradeParty2ExecutionAgentID=" + this.tradeParty2ExecutionAgentID + ", " +
				"tradeParty2ExecutionAgentIDType=" + this.tradeParty2ExecutionAgentIDType + ", " +
				"tradeParty1ExecutionAgentID=" + this.tradeParty1ExecutionAgentID + ", " +
				"tradeParty1ExecutionAgentIDType=" + this.tradeParty1ExecutionAgentIDType + ", " +
				"tradeParty1TransactionID=" + this.tradeParty1TransactionID + ", " +
				"settlementType=" + this.settlementType + ", " +
				"productGrade=" + this.productGrade + ", " +
				"deliveryLocation=" + this.deliveryLocation + ", " +
				"leg1CommodityInstrumentID=" + this.leg1CommodityInstrumentID + ", " +
				"leg2CommodityInstrumentID=" + this.leg2CommodityInstrumentID + ", " +
				"responsibleDataSubmitterIDType=" + this.responsibleDataSubmitterIDType + ", " +
				"responsibleDataSubmitterID=" + this.responsibleDataSubmitterID + ", " +
				"maturityDateOfTheUnderlying=" + this.maturityDateOfTheUnderlying + ", " +
				"corporateActionNewTradeParty1Lei=" + this.corporateActionNewTradeParty1Lei + ", " +
				"otherPaymentPayerIDType=" + this.otherPaymentPayerIDType + ", " +
				"otherPaymentReceiverIDType=" + this.otherPaymentReceiverIDType + ", " +
				"sefOrDcmAnonymousExecutionIndicator=" + this.sefOrDcmAnonymousExecutionIndicator + ", " +
				"executionVenueID=" + this.executionVenueID + ", " +
				"executionVenueIDType=" + this.executionVenueIDType + ", " +
				"leg1FloatingRateIndex=" + this.leg1FloatingRateIndex + ", " +
				"leg2FloatingRateIndex=" + this.leg2FloatingRateIndex + ", " +
				"underlyingAssetName=" + this.underlyingAssetName + ", " +
				"underlyingAsset=" + this.underlyingAsset +
			'}';
		}
	}
}
