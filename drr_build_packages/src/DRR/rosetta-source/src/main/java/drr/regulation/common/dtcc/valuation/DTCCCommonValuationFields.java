package drr.regulation.common.dtcc.valuation;

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
import com.rosetta.util.ListEquals;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.dtcc.valuation.meta.DTCCCommonValuationFieldsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="DTCCCommonValuationFields", builder=DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilderImpl.class, version="7.7.0")
@RuneDataType(value="DTCCCommonValuationFields", model="drr", builder=DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilderImpl.class, version="7.7.0")
public interface DTCCCommonValuationFields extends RosettaModelObject {

	DTCCCommonValuationFieldsMeta metaData = new DTCCCommonValuationFieldsMeta();

	/*********************** Getter Methods  ***********************/
	PartyIdentifierTypeEnum getTradeParty1IDType();
	PartyIdentifierTypeEnum getSubmittingPartyIDType();
	String getUsiIDPrefix();
	String getUtiIDPrefix();
	String getSubmittedForParty();
	List<SupervisoryBodyEnum> getTradeParty1ReportingDestination();
	List<SupervisoryBodyEnum> getTradeParty2ReportingDestination();
	AssetClassEnum getPrimaryAssetClass();
	String getComment1();
	String getMessageID();
	String getMessageType();
	String getTradeParty2ExecutionAgentID();
	PartyIdentifierTypeEnum getTradeParty2ExecutionAgentIDType();
	String getTradeParty1ExecutionAgentID();
	PartyIdentifierTypeEnum getTradeParty1ExecutionAgentIDType();
	String getTradeParty1TransactionID();
	String getVersion();

	/*********************** Build Methods  ***********************/
	DTCCCommonValuationFields build();
	
	DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder toBuilder();
	
	static DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder builder() {
		return new DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DTCCCommonValuationFields> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DTCCCommonValuationFields> getType() {
		return DTCCCommonValuationFields.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tradeParty1IDType"), PartyIdentifierTypeEnum.class, getTradeParty1IDType(), this);
		processor.processBasic(path.newSubPath("submittingPartyIDType"), PartyIdentifierTypeEnum.class, getSubmittingPartyIDType(), this);
		processor.processBasic(path.newSubPath("usiIDPrefix"), String.class, getUsiIDPrefix(), this);
		processor.processBasic(path.newSubPath("utiIDPrefix"), String.class, getUtiIDPrefix(), this);
		processor.processBasic(path.newSubPath("submittedForParty"), String.class, getSubmittedForParty(), this);
		processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty1ReportingDestination(), this);
		processor.processBasic(path.newSubPath("tradeParty2ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty2ReportingDestination(), this);
		processor.processBasic(path.newSubPath("primaryAssetClass"), AssetClassEnum.class, getPrimaryAssetClass(), this);
		processor.processBasic(path.newSubPath("comment1"), String.class, getComment1(), this);
		processor.processBasic(path.newSubPath("messageID"), String.class, getMessageID(), this);
		processor.processBasic(path.newSubPath("messageType"), String.class, getMessageType(), this);
		processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentID"), String.class, getTradeParty2ExecutionAgentID(), this);
		processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentIDType"), PartyIdentifierTypeEnum.class, getTradeParty2ExecutionAgentIDType(), this);
		processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentID"), String.class, getTradeParty1ExecutionAgentID(), this);
		processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentIDType"), PartyIdentifierTypeEnum.class, getTradeParty1ExecutionAgentIDType(), this);
		processor.processBasic(path.newSubPath("tradeParty1TransactionID"), String.class, getTradeParty1TransactionID(), this);
		processor.processBasic(path.newSubPath("version"), String.class, getVersion(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DTCCCommonValuationFieldsBuilder extends DTCCCommonValuationFields, RosettaModelObjectBuilder {
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1IDType(PartyIdentifierTypeEnum tradeParty1IDType);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum submittingPartyIDType);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setUsiIDPrefix(String usiIDPrefix);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setUtiIDPrefix(String utiIDPrefix);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setSubmittedForParty(String submittedForParty);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination, int idx);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum tradeParty2ReportingDestination);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum tradeParty2ReportingDestination, int idx);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestination);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestination);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setPrimaryAssetClass(AssetClassEnum primaryAssetClass);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setComment1(String comment1);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setMessageID(String messageID);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setMessageType(String messageType);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty2ExecutionAgentID(String tradeParty2ExecutionAgentID);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty2ExecutionAgentIDType(PartyIdentifierTypeEnum tradeParty2ExecutionAgentIDType);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1ExecutionAgentID(String tradeParty1ExecutionAgentID);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1ExecutionAgentIDType(PartyIdentifierTypeEnum tradeParty1ExecutionAgentIDType);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1TransactionID(String tradeParty1TransactionID);
		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setVersion(String version);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tradeParty1IDType"), PartyIdentifierTypeEnum.class, getTradeParty1IDType(), this);
			processor.processBasic(path.newSubPath("submittingPartyIDType"), PartyIdentifierTypeEnum.class, getSubmittingPartyIDType(), this);
			processor.processBasic(path.newSubPath("usiIDPrefix"), String.class, getUsiIDPrefix(), this);
			processor.processBasic(path.newSubPath("utiIDPrefix"), String.class, getUtiIDPrefix(), this);
			processor.processBasic(path.newSubPath("submittedForParty"), String.class, getSubmittedForParty(), this);
			processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty1ReportingDestination(), this);
			processor.processBasic(path.newSubPath("tradeParty2ReportingDestination"), SupervisoryBodyEnum.class, getTradeParty2ReportingDestination(), this);
			processor.processBasic(path.newSubPath("primaryAssetClass"), AssetClassEnum.class, getPrimaryAssetClass(), this);
			processor.processBasic(path.newSubPath("comment1"), String.class, getComment1(), this);
			processor.processBasic(path.newSubPath("messageID"), String.class, getMessageID(), this);
			processor.processBasic(path.newSubPath("messageType"), String.class, getMessageType(), this);
			processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentID"), String.class, getTradeParty2ExecutionAgentID(), this);
			processor.processBasic(path.newSubPath("tradeParty2ExecutionAgentIDType"), PartyIdentifierTypeEnum.class, getTradeParty2ExecutionAgentIDType(), this);
			processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentID"), String.class, getTradeParty1ExecutionAgentID(), this);
			processor.processBasic(path.newSubPath("tradeParty1ExecutionAgentIDType"), PartyIdentifierTypeEnum.class, getTradeParty1ExecutionAgentIDType(), this);
			processor.processBasic(path.newSubPath("tradeParty1TransactionID"), String.class, getTradeParty1TransactionID(), this);
			processor.processBasic(path.newSubPath("version"), String.class, getVersion(), this);
		}
		

		DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder prune();
	}

	/*********************** Immutable Implementation of DTCCCommonValuationFields  ***********************/
	class DTCCCommonValuationFieldsImpl implements DTCCCommonValuationFields {
		private final PartyIdentifierTypeEnum tradeParty1IDType;
		private final PartyIdentifierTypeEnum submittingPartyIDType;
		private final String usiIDPrefix;
		private final String utiIDPrefix;
		private final String submittedForParty;
		private final List<SupervisoryBodyEnum> tradeParty1ReportingDestination;
		private final List<SupervisoryBodyEnum> tradeParty2ReportingDestination;
		private final AssetClassEnum primaryAssetClass;
		private final String comment1;
		private final String messageID;
		private final String messageType;
		private final String tradeParty2ExecutionAgentID;
		private final PartyIdentifierTypeEnum tradeParty2ExecutionAgentIDType;
		private final String tradeParty1ExecutionAgentID;
		private final PartyIdentifierTypeEnum tradeParty1ExecutionAgentIDType;
		private final String tradeParty1TransactionID;
		private final String version;
		
		protected DTCCCommonValuationFieldsImpl(DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder builder) {
			this.tradeParty1IDType = builder.getTradeParty1IDType();
			this.submittingPartyIDType = builder.getSubmittingPartyIDType();
			this.usiIDPrefix = builder.getUsiIDPrefix();
			this.utiIDPrefix = builder.getUtiIDPrefix();
			this.submittedForParty = builder.getSubmittedForParty();
			this.tradeParty1ReportingDestination = ofNullable(builder.getTradeParty1ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty2ReportingDestination = ofNullable(builder.getTradeParty2ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.primaryAssetClass = builder.getPrimaryAssetClass();
			this.comment1 = builder.getComment1();
			this.messageID = builder.getMessageID();
			this.messageType = builder.getMessageType();
			this.tradeParty2ExecutionAgentID = builder.getTradeParty2ExecutionAgentID();
			this.tradeParty2ExecutionAgentIDType = builder.getTradeParty2ExecutionAgentIDType();
			this.tradeParty1ExecutionAgentID = builder.getTradeParty1ExecutionAgentID();
			this.tradeParty1ExecutionAgentIDType = builder.getTradeParty1ExecutionAgentIDType();
			this.tradeParty1TransactionID = builder.getTradeParty1TransactionID();
			this.version = builder.getVersion();
		}
		
		@Override
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1IDType")
		public PartyIdentifierTypeEnum getTradeParty1IDType() {
			return tradeParty1IDType;
		}
		
		@Override
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittingPartyIDType")
		public PartyIdentifierTypeEnum getSubmittingPartyIDType() {
			return submittingPartyIDType;
		}
		
		@Override
		@RosettaAttribute("usiIDPrefix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("usiIDPrefix")
		public String getUsiIDPrefix() {
			return usiIDPrefix;
		}
		
		@Override
		@RosettaAttribute("utiIDPrefix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("utiIDPrefix")
		public String getUtiIDPrefix() {
			return utiIDPrefix;
		}
		
		@Override
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittedForParty")
		public String getSubmittedForParty() {
			return submittedForParty;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment1")
		public String getComment1() {
			return comment1;
		}
		
		@Override
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageID")
		public String getMessageID() {
			return messageID;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
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
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public String getVersion() {
			return version;
		}
		
		@Override
		public DTCCCommonValuationFields build() {
			return this;
		}
		
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder toBuilder() {
			DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder builder) {
			ofNullable(getTradeParty1IDType()).ifPresent(builder::setTradeParty1IDType);
			ofNullable(getSubmittingPartyIDType()).ifPresent(builder::setSubmittingPartyIDType);
			ofNullable(getUsiIDPrefix()).ifPresent(builder::setUsiIDPrefix);
			ofNullable(getUtiIDPrefix()).ifPresent(builder::setUtiIDPrefix);
			ofNullable(getSubmittedForParty()).ifPresent(builder::setSubmittedForParty);
			ofNullable(getTradeParty1ReportingDestination()).ifPresent(builder::setTradeParty1ReportingDestination);
			ofNullable(getTradeParty2ReportingDestination()).ifPresent(builder::setTradeParty2ReportingDestination);
			ofNullable(getPrimaryAssetClass()).ifPresent(builder::setPrimaryAssetClass);
			ofNullable(getComment1()).ifPresent(builder::setComment1);
			ofNullable(getMessageID()).ifPresent(builder::setMessageID);
			ofNullable(getMessageType()).ifPresent(builder::setMessageType);
			ofNullable(getTradeParty2ExecutionAgentID()).ifPresent(builder::setTradeParty2ExecutionAgentID);
			ofNullable(getTradeParty2ExecutionAgentIDType()).ifPresent(builder::setTradeParty2ExecutionAgentIDType);
			ofNullable(getTradeParty1ExecutionAgentID()).ifPresent(builder::setTradeParty1ExecutionAgentID);
			ofNullable(getTradeParty1ExecutionAgentIDType()).ifPresent(builder::setTradeParty1ExecutionAgentIDType);
			ofNullable(getTradeParty1TransactionID()).ifPresent(builder::setTradeParty1TransactionID);
			ofNullable(getVersion()).ifPresent(builder::setVersion);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DTCCCommonValuationFields _that = getType().cast(o);
		
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(submittingPartyIDType, _that.getSubmittingPartyIDType())) return false;
			if (!Objects.equals(usiIDPrefix, _that.getUsiIDPrefix())) return false;
			if (!Objects.equals(utiIDPrefix, _that.getUtiIDPrefix())) return false;
			if (!Objects.equals(submittedForParty, _that.getSubmittedForParty())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!ListEquals.listEquals(tradeParty2ReportingDestination, _that.getTradeParty2ReportingDestination())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!Objects.equals(comment1, _that.getComment1())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentID, _that.getTradeParty2ExecutionAgentID())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentIDType, _that.getTradeParty2ExecutionAgentIDType())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentID, _that.getTradeParty1ExecutionAgentID())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentIDType, _that.getTradeParty1ExecutionAgentIDType())) return false;
			if (!Objects.equals(tradeParty1TransactionID, _that.getTradeParty1TransactionID())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittingPartyIDType != null ? submittingPartyIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (usiIDPrefix != null ? usiIDPrefix.hashCode() : 0);
			_result = 31 * _result + (utiIDPrefix != null ? utiIDPrefix.hashCode() : 0);
			_result = 31 * _result + (submittedForParty != null ? submittedForParty.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (tradeParty2ReportingDestination != null ? tradeParty2ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (comment1 != null ? comment1.hashCode() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentID != null ? tradeParty2ExecutionAgentID.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentIDType != null ? tradeParty2ExecutionAgentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentID != null ? tradeParty1ExecutionAgentID.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentIDType != null ? tradeParty1ExecutionAgentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1TransactionID != null ? tradeParty1TransactionID.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DTCCCommonValuationFields {" +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"submittingPartyIDType=" + this.submittingPartyIDType + ", " +
				"usiIDPrefix=" + this.usiIDPrefix + ", " +
				"utiIDPrefix=" + this.utiIDPrefix + ", " +
				"submittedForParty=" + this.submittedForParty + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"tradeParty2ReportingDestination=" + this.tradeParty2ReportingDestination + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"comment1=" + this.comment1 + ", " +
				"messageID=" + this.messageID + ", " +
				"messageType=" + this.messageType + ", " +
				"tradeParty2ExecutionAgentID=" + this.tradeParty2ExecutionAgentID + ", " +
				"tradeParty2ExecutionAgentIDType=" + this.tradeParty2ExecutionAgentIDType + ", " +
				"tradeParty1ExecutionAgentID=" + this.tradeParty1ExecutionAgentID + ", " +
				"tradeParty1ExecutionAgentIDType=" + this.tradeParty1ExecutionAgentIDType + ", " +
				"tradeParty1TransactionID=" + this.tradeParty1TransactionID + ", " +
				"version=" + this.version +
			'}';
		}
	}

	/*********************** Builder Implementation of DTCCCommonValuationFields  ***********************/
	class DTCCCommonValuationFieldsBuilderImpl implements DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder {
	
		protected PartyIdentifierTypeEnum tradeParty1IDType;
		protected PartyIdentifierTypeEnum submittingPartyIDType;
		protected String usiIDPrefix;
		protected String utiIDPrefix;
		protected String submittedForParty;
		protected List<SupervisoryBodyEnum> tradeParty1ReportingDestination = new ArrayList<>();
		protected List<SupervisoryBodyEnum> tradeParty2ReportingDestination = new ArrayList<>();
		protected AssetClassEnum primaryAssetClass;
		protected String comment1;
		protected String messageID;
		protected String messageType;
		protected String tradeParty2ExecutionAgentID;
		protected PartyIdentifierTypeEnum tradeParty2ExecutionAgentIDType;
		protected String tradeParty1ExecutionAgentID;
		protected PartyIdentifierTypeEnum tradeParty1ExecutionAgentIDType;
		protected String tradeParty1TransactionID;
		protected String version;
		
		@Override
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeParty1IDType")
		public PartyIdentifierTypeEnum getTradeParty1IDType() {
			return tradeParty1IDType;
		}
		
		@Override
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittingPartyIDType")
		public PartyIdentifierTypeEnum getSubmittingPartyIDType() {
			return submittingPartyIDType;
		}
		
		@Override
		@RosettaAttribute("usiIDPrefix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("usiIDPrefix")
		public String getUsiIDPrefix() {
			return usiIDPrefix;
		}
		
		@Override
		@RosettaAttribute("utiIDPrefix")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("utiIDPrefix")
		public String getUtiIDPrefix() {
			return utiIDPrefix;
		}
		
		@Override
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submittedForParty")
		public String getSubmittedForParty() {
			return submittedForParty;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
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
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("comment1")
		public String getComment1() {
			return comment1;
		}
		
		@Override
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageID")
		public String getMessageID() {
			return messageID;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
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
		@RosettaAttribute("version")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("version")
		public String getVersion() {
			return version;
		}
		
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1IDType")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1IDType(PartyIdentifierTypeEnum _tradeParty1IDType) {
			this.tradeParty1IDType = _tradeParty1IDType == null ? null : _tradeParty1IDType;
			return this;
		}
		
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("submittingPartyIDType")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum _submittingPartyIDType) {
			this.submittingPartyIDType = _submittingPartyIDType == null ? null : _submittingPartyIDType;
			return this;
		}
		
		@RosettaAttribute("usiIDPrefix")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("usiIDPrefix")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setUsiIDPrefix(String _usiIDPrefix) {
			this.usiIDPrefix = _usiIDPrefix == null ? null : _usiIDPrefix;
			return this;
		}
		
		@RosettaAttribute("utiIDPrefix")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("utiIDPrefix")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setUtiIDPrefix(String _utiIDPrefix) {
			this.utiIDPrefix = _utiIDPrefix == null ? null : _utiIDPrefix;
			return this;
		}
		
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("submittedForParty")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setSubmittedForParty(String _submittedForParty) {
			this.submittedForParty = _submittedForParty == null ? null : _submittedForParty;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination) {
			if (_tradeParty1ReportingDestination != null) {
				this.tradeParty1ReportingDestination.add(_tradeParty1ReportingDestination);
			}
			return this;
		}
		
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination, int idx) {
			getIndex(this.tradeParty1ReportingDestination, idx, () -> _tradeParty1ReportingDestination);
			return this;
		}
		
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations != null) {
				for (final SupervisoryBodyEnum toAdd : tradeParty1ReportingDestinations) {
					this.tradeParty1ReportingDestination.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
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
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum _tradeParty2ReportingDestination) {
			if (_tradeParty2ReportingDestination != null) {
				this.tradeParty2ReportingDestination.add(_tradeParty2ReportingDestination);
			}
			return this;
		}
		
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum _tradeParty2ReportingDestination, int idx) {
			getIndex(this.tradeParty2ReportingDestination, idx, () -> _tradeParty2ReportingDestination);
			return this;
		}
		
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder addTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestinations) {
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
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestinations) {
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
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setPrimaryAssetClass(AssetClassEnum _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass;
			return this;
		}
		
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment1")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setComment1(String _comment1) {
			this.comment1 = _comment1 == null ? null : _comment1;
			return this;
		}
		
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageID")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setMessageID(String _messageID) {
			this.messageID = _messageID == null ? null : _messageID;
			return this;
		}
		
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageType")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setMessageType(String _messageType) {
			this.messageType = _messageType == null ? null : _messageType;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentID")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty2ExecutionAgentID(String _tradeParty2ExecutionAgentID) {
			this.tradeParty2ExecutionAgentID = _tradeParty2ExecutionAgentID == null ? null : _tradeParty2ExecutionAgentID;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentIDType")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty2ExecutionAgentIDType(PartyIdentifierTypeEnum _tradeParty2ExecutionAgentIDType) {
			this.tradeParty2ExecutionAgentIDType = _tradeParty2ExecutionAgentIDType == null ? null : _tradeParty2ExecutionAgentIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentID")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1ExecutionAgentID(String _tradeParty1ExecutionAgentID) {
			this.tradeParty1ExecutionAgentID = _tradeParty1ExecutionAgentID == null ? null : _tradeParty1ExecutionAgentID;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentIDType")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1ExecutionAgentIDType(PartyIdentifierTypeEnum _tradeParty1ExecutionAgentIDType) {
			this.tradeParty1ExecutionAgentIDType = _tradeParty1ExecutionAgentIDType == null ? null : _tradeParty1ExecutionAgentIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1TransactionID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1TransactionID")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setTradeParty1TransactionID(String _tradeParty1TransactionID) {
			this.tradeParty1TransactionID = _tradeParty1TransactionID == null ? null : _tradeParty1TransactionID;
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("version")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder setVersion(String _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@Override
		public DTCCCommonValuationFields build() {
			return new DTCCCommonValuationFields.DTCCCommonValuationFieldsImpl(this);
		}
		
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeParty1IDType()!=null) return true;
			if (getSubmittingPartyIDType()!=null) return true;
			if (getUsiIDPrefix()!=null) return true;
			if (getUtiIDPrefix()!=null) return true;
			if (getSubmittedForParty()!=null) return true;
			if (getTradeParty1ReportingDestination()!=null && !getTradeParty1ReportingDestination().isEmpty()) return true;
			if (getTradeParty2ReportingDestination()!=null && !getTradeParty2ReportingDestination().isEmpty()) return true;
			if (getPrimaryAssetClass()!=null) return true;
			if (getComment1()!=null) return true;
			if (getMessageID()!=null) return true;
			if (getMessageType()!=null) return true;
			if (getTradeParty2ExecutionAgentID()!=null) return true;
			if (getTradeParty2ExecutionAgentIDType()!=null) return true;
			if (getTradeParty1ExecutionAgentID()!=null) return true;
			if (getTradeParty1ExecutionAgentIDType()!=null) return true;
			if (getTradeParty1TransactionID()!=null) return true;
			if (getVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder o = (DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder) other;
			
			
			merger.mergeBasic(getTradeParty1IDType(), o.getTradeParty1IDType(), this::setTradeParty1IDType);
			merger.mergeBasic(getSubmittingPartyIDType(), o.getSubmittingPartyIDType(), this::setSubmittingPartyIDType);
			merger.mergeBasic(getUsiIDPrefix(), o.getUsiIDPrefix(), this::setUsiIDPrefix);
			merger.mergeBasic(getUtiIDPrefix(), o.getUtiIDPrefix(), this::setUtiIDPrefix);
			merger.mergeBasic(getSubmittedForParty(), o.getSubmittedForParty(), this::setSubmittedForParty);
			merger.mergeBasic(getTradeParty1ReportingDestination(), o.getTradeParty1ReportingDestination(), (Consumer<SupervisoryBodyEnum>) this::addTradeParty1ReportingDestination);
			merger.mergeBasic(getTradeParty2ReportingDestination(), o.getTradeParty2ReportingDestination(), (Consumer<SupervisoryBodyEnum>) this::addTradeParty2ReportingDestination);
			merger.mergeBasic(getPrimaryAssetClass(), o.getPrimaryAssetClass(), this::setPrimaryAssetClass);
			merger.mergeBasic(getComment1(), o.getComment1(), this::setComment1);
			merger.mergeBasic(getMessageID(), o.getMessageID(), this::setMessageID);
			merger.mergeBasic(getMessageType(), o.getMessageType(), this::setMessageType);
			merger.mergeBasic(getTradeParty2ExecutionAgentID(), o.getTradeParty2ExecutionAgentID(), this::setTradeParty2ExecutionAgentID);
			merger.mergeBasic(getTradeParty2ExecutionAgentIDType(), o.getTradeParty2ExecutionAgentIDType(), this::setTradeParty2ExecutionAgentIDType);
			merger.mergeBasic(getTradeParty1ExecutionAgentID(), o.getTradeParty1ExecutionAgentID(), this::setTradeParty1ExecutionAgentID);
			merger.mergeBasic(getTradeParty1ExecutionAgentIDType(), o.getTradeParty1ExecutionAgentIDType(), this::setTradeParty1ExecutionAgentIDType);
			merger.mergeBasic(getTradeParty1TransactionID(), o.getTradeParty1TransactionID(), this::setTradeParty1TransactionID);
			merger.mergeBasic(getVersion(), o.getVersion(), this::setVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DTCCCommonValuationFields _that = getType().cast(o);
		
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(submittingPartyIDType, _that.getSubmittingPartyIDType())) return false;
			if (!Objects.equals(usiIDPrefix, _that.getUsiIDPrefix())) return false;
			if (!Objects.equals(utiIDPrefix, _that.getUtiIDPrefix())) return false;
			if (!Objects.equals(submittedForParty, _that.getSubmittedForParty())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!ListEquals.listEquals(tradeParty2ReportingDestination, _that.getTradeParty2ReportingDestination())) return false;
			if (!Objects.equals(primaryAssetClass, _that.getPrimaryAssetClass())) return false;
			if (!Objects.equals(comment1, _that.getComment1())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentID, _that.getTradeParty2ExecutionAgentID())) return false;
			if (!Objects.equals(tradeParty2ExecutionAgentIDType, _that.getTradeParty2ExecutionAgentIDType())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentID, _that.getTradeParty1ExecutionAgentID())) return false;
			if (!Objects.equals(tradeParty1ExecutionAgentIDType, _that.getTradeParty1ExecutionAgentIDType())) return false;
			if (!Objects.equals(tradeParty1TransactionID, _that.getTradeParty1TransactionID())) return false;
			if (!Objects.equals(version, _that.getVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittingPartyIDType != null ? submittingPartyIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (usiIDPrefix != null ? usiIDPrefix.hashCode() : 0);
			_result = 31 * _result + (utiIDPrefix != null ? utiIDPrefix.hashCode() : 0);
			_result = 31 * _result + (submittedForParty != null ? submittedForParty.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (tradeParty2ReportingDestination != null ? tradeParty2ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (primaryAssetClass != null ? primaryAssetClass.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (comment1 != null ? comment1.hashCode() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentID != null ? tradeParty2ExecutionAgentID.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ExecutionAgentIDType != null ? tradeParty2ExecutionAgentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentID != null ? tradeParty1ExecutionAgentID.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ExecutionAgentIDType != null ? tradeParty1ExecutionAgentIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tradeParty1TransactionID != null ? tradeParty1TransactionID.hashCode() : 0);
			_result = 31 * _result + (version != null ? version.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DTCCCommonValuationFieldsBuilder {" +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"submittingPartyIDType=" + this.submittingPartyIDType + ", " +
				"usiIDPrefix=" + this.usiIDPrefix + ", " +
				"utiIDPrefix=" + this.utiIDPrefix + ", " +
				"submittedForParty=" + this.submittedForParty + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"tradeParty2ReportingDestination=" + this.tradeParty2ReportingDestination + ", " +
				"primaryAssetClass=" + this.primaryAssetClass + ", " +
				"comment1=" + this.comment1 + ", " +
				"messageID=" + this.messageID + ", " +
				"messageType=" + this.messageType + ", " +
				"tradeParty2ExecutionAgentID=" + this.tradeParty2ExecutionAgentID + ", " +
				"tradeParty2ExecutionAgentIDType=" + this.tradeParty2ExecutionAgentIDType + ", " +
				"tradeParty1ExecutionAgentID=" + this.tradeParty1ExecutionAgentID + ", " +
				"tradeParty1ExecutionAgentIDType=" + this.tradeParty1ExecutionAgentIDType + ", " +
				"tradeParty1TransactionID=" + this.tradeParty1TransactionID + ", " +
				"version=" + this.version +
			'}';
		}
	}
}
