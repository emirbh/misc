package drr.regulation.csa.rewrite.dtcc.valuation;

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
import com.rosetta.model.lib.annotations.RosettaIgnore;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneIgnore;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.dtcc.valuation.DTCCCommonValuationFields;
import drr.regulation.csa.rewrite.dtcc.valuation.meta.DTCCAdditionalValuationFieldsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="DTCCAdditionalValuationFields", builder=DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilderImpl.class, version="7.7.0")
@RuneDataType(value="DTCCAdditionalValuationFields", model="drr", builder=DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilderImpl.class, version="7.7.0")
public interface DTCCAdditionalValuationFields extends DTCCCommonValuationFields {

	DTCCAdditionalValuationFieldsMeta metaData = new DTCCAdditionalValuationFieldsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "Trade Party 1 - ID Type"
	 *
	 * Provision GTR required Control Field.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup CanadianDataAndReporting ISDA Data and Reporting Canadian Working Group "This distribution list is responsible for addressing industry compliance and implementation issues related to trade reporting under Canadian regulatory requirements across provinces. The group has been the driving force for work such as the Multi-lateral non-dealer Canadian reporting agreement, regulatory response letters, and reporting discussions with the OSC, MSC, Quebec, BCSC and ASC." 
	 * date "20250508" * field "Trade Party 1 - ID Type"
	 *
	 * Provision Reporting firms on the WG call said they would be using an LEI. There is only a possible use case for crypto trades reporting by SEFs; however, DRR is not going to model this case until is demanded by firms.
	 *
	 */
	@Override
	PartyIdentifierTypeEnum getTradeParty1IDType();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "Submitting Party - ID Type"
	 *
	 * Provision GTR required Control Field.
	 *
	 */
	@Override
	PartyIdentifierTypeEnum getSubmittingPartyIDType();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "Submitted For Party"
	 *
	 * Provision Need field for GTR Processing.
	 *
	 *
	 * Body ISDA
	 * Corpus WorkingGroup PeerReviewGroup ISDA EMIR/CFTC Digital Regulatory Reporting Peer Review "Industry group which works collaboratively to mutualize representation of amended CFTC and EMIR transaction reporting requirements in Digital Regulatory Reporting (DRR) - a digitized, single standard set of open-source machine-executable code using the Common Domain Model (CDM)." 
	 * date "20250507" * field "Submitted For Party"
	 *
	 * Provision Agreed to default the output to the LEI of the reporting party.
	 *
	 */
	@Override
	String getSubmittedForParty();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "Trade Party 1 - Reporting Destination"
	 *
	 * Provision Needed to report Jurisdiction.
	 *
	 */
	@Override
	List<SupervisoryBodyEnum> getTradeParty1ReportingDestination();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
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
	@Override
	String getMessageID();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "Message Type"
	 *
	 * Provision Need to indicate what message is being submitted to GTR.
	 *
	 */
	@Override
	String getMessageType();
	/**
	 *
	 * Body CSA
	 * Corpus Dissemination Valuation    * Corpus Specifications DTCC_Specs DTCC Specs "Document providing the message specifications required for inbound message for DTCC for CSA." 
	 * field "USI ID"
	 *
	 * Provision The USI is a unique identifier assigned to all swap transactions which identifies the transaction (the swap and its counterparties) uniquely throughout its duration. It consists of a namespace and a transaction identifier.
	 *
	 */
	String getUsiID();

	/*********************** Build Methods  ***********************/
	DTCCAdditionalValuationFields build();
	
	DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder toBuilder();
	
	static DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder builder() {
		return new DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DTCCAdditionalValuationFields> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DTCCAdditionalValuationFields> getType() {
		return DTCCAdditionalValuationFields.class;
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
		processor.processBasic(path.newSubPath("usiID"), String.class, getUsiID(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DTCCAdditionalValuationFieldsBuilder extends DTCCAdditionalValuationFields, DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilder {
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1IDType(PartyIdentifierTypeEnum tradeParty1IDType);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum submittingPartyIDType);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setUsiIDPrefix(String usiIDPrefix);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setUtiIDPrefix(String utiIDPrefix);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setSubmittedForParty(String submittedForParty);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum tradeParty1ReportingDestination, int idx);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum tradeParty2ReportingDestination);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum tradeParty2ReportingDestination, int idx);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestination);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestination);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setPrimaryAssetClass(AssetClassEnum primaryAssetClass);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setComment1(String comment1);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setMessageID(String messageID);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setMessageType(String messageType);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty2ExecutionAgentID(String tradeParty2ExecutionAgentID);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty2ExecutionAgentIDType(PartyIdentifierTypeEnum tradeParty2ExecutionAgentIDType);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1ExecutionAgentID(String tradeParty1ExecutionAgentID);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1ExecutionAgentIDType(PartyIdentifierTypeEnum tradeParty1ExecutionAgentIDType);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1TransactionID(String tradeParty1TransactionID);
		@Override
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setVersion(String version);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1IDTypeOverriddenAsPartyIdentifierTypeEnum(PartyIdentifierTypeEnum tradeParty1IDType);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setSubmittingPartyIDTypeOverriddenAsPartyIdentifierTypeEnum(PartyIdentifierTypeEnum submittingPartyIDType);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setSubmittedForPartyOverriddenAsString(String submittedForParty);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(SupervisoryBodyEnum tradeParty1ReportingDestination);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(SupervisoryBodyEnum tradeParty1ReportingDestination, int idx);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(List<SupervisoryBodyEnum> tradeParty1ReportingDestination);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setMessageIDOverriddenAsString(String messageID);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setMessageTypeOverriddenAsString(String messageType);
		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setUsiID(String usiID);

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
			processor.processBasic(path.newSubPath("usiID"), String.class, getUsiID(), this);
		}
		

		DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder prune();
	}

	/*********************** Immutable Implementation of DTCCAdditionalValuationFields  ***********************/
	class DTCCAdditionalValuationFieldsImpl extends DTCCCommonValuationFields.DTCCCommonValuationFieldsImpl implements DTCCAdditionalValuationFields {
		private final PartyIdentifierTypeEnum tradeParty1IDType;
		private final PartyIdentifierTypeEnum submittingPartyIDType;
		private final String submittedForParty;
		private final List<SupervisoryBodyEnum> tradeParty1ReportingDestination;
		private final String messageID;
		private final String messageType;
		private final String usiID;
		
		protected DTCCAdditionalValuationFieldsImpl(DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder builder) {
			super(builder);
			this.tradeParty1IDType = builder.getTradeParty1IDType();
			this.submittingPartyIDType = builder.getSubmittingPartyIDType();
			this.submittedForParty = builder.getSubmittedForParty();
			this.tradeParty1ReportingDestination = ofNullable(builder.getTradeParty1ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.messageID = builder.getMessageID();
			this.messageType = builder.getMessageType();
			this.usiID = builder.getUsiID();
		}
		
		@Override
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeParty1IDType")
		public PartyIdentifierTypeEnum getTradeParty1IDType() {
			return tradeParty1IDType;
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
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<SupervisoryBodyEnum> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageID")
		public String getMessageID() {
			return messageID;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
		}
		
		@Override
		@RosettaAttribute("usiID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("usiID")
		public String getUsiID() {
			return usiID;
		}
		
		@Override
		public DTCCAdditionalValuationFields build() {
			return this;
		}
		
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder toBuilder() {
			DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradeParty1IDType()).ifPresent(builder::setTradeParty1IDTypeOverriddenAsPartyIdentifierTypeEnum);
			ofNullable(getSubmittingPartyIDType()).ifPresent(builder::setSubmittingPartyIDTypeOverriddenAsPartyIdentifierTypeEnum);
			ofNullable(getSubmittedForParty()).ifPresent(builder::setSubmittedForPartyOverriddenAsString);
			ofNullable(getTradeParty1ReportingDestination()).ifPresent(builder::setTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum);
			ofNullable(getMessageID()).ifPresent(builder::setMessageIDOverriddenAsString);
			ofNullable(getMessageType()).ifPresent(builder::setMessageTypeOverriddenAsString);
			ofNullable(getUsiID()).ifPresent(builder::setUsiID);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DTCCAdditionalValuationFields _that = getType().cast(o);
		
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(submittingPartyIDType, _that.getSubmittingPartyIDType())) return false;
			if (!Objects.equals(submittedForParty, _that.getSubmittedForParty())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(usiID, _that.getUsiID())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittingPartyIDType != null ? submittingPartyIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittedForParty != null ? submittedForParty.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (usiID != null ? usiID.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DTCCAdditionalValuationFields {" +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"submittingPartyIDType=" + this.submittingPartyIDType + ", " +
				"submittedForParty=" + this.submittedForParty + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"messageID=" + this.messageID + ", " +
				"messageType=" + this.messageType + ", " +
				"usiID=" + this.usiID +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DTCCAdditionalValuationFields  ***********************/
	class DTCCAdditionalValuationFieldsBuilderImpl extends DTCCCommonValuationFields.DTCCCommonValuationFieldsBuilderImpl implements DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder {
	
		protected PartyIdentifierTypeEnum tradeParty1IDType;
		protected PartyIdentifierTypeEnum submittingPartyIDType;
		protected String submittedForParty;
		protected List<SupervisoryBodyEnum> tradeParty1ReportingDestination = new ArrayList<>();
		protected String messageID;
		protected String messageType;
		protected String usiID;
		
		@Override
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradeParty1IDType")
		public PartyIdentifierTypeEnum getTradeParty1IDType() {
			return tradeParty1IDType;
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
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<SupervisoryBodyEnum> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageID")
		public String getMessageID() {
			return messageID;
		}
		
		@Override
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageType")
		public String getMessageType() {
			return messageType;
		}
		
		@Override
		@RosettaAttribute("usiID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("usiID")
		public String getUsiID() {
			return usiID;
		}
		
		@RosettaAttribute("tradeParty1IDType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradeParty1IDType")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1IDTypeOverriddenAsPartyIdentifierTypeEnum(PartyIdentifierTypeEnum _tradeParty1IDType) {
			this.tradeParty1IDType = _tradeParty1IDType == null ? null : _tradeParty1IDType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1IDType(PartyIdentifierTypeEnum _tradeParty1IDType) {
			return setTradeParty1IDTypeOverriddenAsPartyIdentifierTypeEnum(_tradeParty1IDType);
		}
		
		@RosettaAttribute("submittingPartyIDType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submittingPartyIDType")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setSubmittingPartyIDTypeOverriddenAsPartyIdentifierTypeEnum(PartyIdentifierTypeEnum _submittingPartyIDType) {
			this.submittingPartyIDType = _submittingPartyIDType == null ? null : _submittingPartyIDType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setSubmittingPartyIDType(PartyIdentifierTypeEnum _submittingPartyIDType) {
			return setSubmittingPartyIDTypeOverriddenAsPartyIdentifierTypeEnum(_submittingPartyIDType);
		}
		
		@RosettaAttribute("usiIDPrefix")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("usiIDPrefix")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setUsiIDPrefix(String _usiIDPrefix) {
			this.usiIDPrefix = _usiIDPrefix == null ? null : _usiIDPrefix;
			return this;
		}
		
		@RosettaAttribute("utiIDPrefix")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("utiIDPrefix")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setUtiIDPrefix(String _utiIDPrefix) {
			this.utiIDPrefix = _utiIDPrefix == null ? null : _utiIDPrefix;
			return this;
		}
		
		@RosettaAttribute("submittedForParty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("submittedForParty")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setSubmittedForPartyOverriddenAsString(String _submittedForParty) {
			this.submittedForParty = _submittedForParty == null ? null : _submittedForParty;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setSubmittedForParty(String _submittedForParty) {
			return setSubmittedForPartyOverriddenAsString(_submittedForParty);
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(SupervisoryBodyEnum _tradeParty1ReportingDestination) {
			if (_tradeParty1ReportingDestination != null) {
				this.tradeParty1ReportingDestination.add(_tradeParty1ReportingDestination);
			}
			return this;
		}
		
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(SupervisoryBodyEnum _tradeParty1ReportingDestination, int idx) {
			getIndex(this.tradeParty1ReportingDestination, idx, () -> _tradeParty1ReportingDestination);
			return this;
		}
		
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
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
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations == null) {
				this.tradeParty1ReportingDestination = new ArrayList<>();
			} else {
				this.tradeParty1ReportingDestination = tradeParty1ReportingDestinations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination) {
			return addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(_tradeParty1ReportingDestination);
		}
		
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestination(SupervisoryBodyEnum _tradeParty1ReportingDestination, int idx) {
			return addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(_tradeParty1ReportingDestination, idx);
		}
		
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
			return addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(tradeParty1ReportingDestinations);
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1ReportingDestination(List<SupervisoryBodyEnum> tradeParty1ReportingDestinations) {
			return setTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum(tradeParty1ReportingDestinations);
		}
		
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum _tradeParty2ReportingDestination) {
			if (_tradeParty2ReportingDestination != null) {
				this.tradeParty2ReportingDestination.add(_tradeParty2ReportingDestination);
			}
			return this;
		}
		
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty2ReportingDestination(SupervisoryBodyEnum _tradeParty2ReportingDestination, int idx) {
			getIndex(this.tradeParty2ReportingDestination, idx, () -> _tradeParty2ReportingDestination);
			return this;
		}
		
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder addTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestinations) {
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
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty2ReportingDestination(List<SupervisoryBodyEnum> tradeParty2ReportingDestinations) {
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
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setPrimaryAssetClass(AssetClassEnum _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass;
			return this;
		}
		
		@RosettaAttribute("comment1")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment1")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setComment1(String _comment1) {
			this.comment1 = _comment1 == null ? null : _comment1;
			return this;
		}
		
		@RosettaAttribute("messageID")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("messageID")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setMessageIDOverriddenAsString(String _messageID) {
			this.messageID = _messageID == null ? null : _messageID;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setMessageID(String _messageID) {
			return setMessageIDOverriddenAsString(_messageID);
		}
		
		@RosettaAttribute("messageType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("messageType")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setMessageTypeOverriddenAsString(String _messageType) {
			this.messageType = _messageType == null ? null : _messageType;
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setMessageType(String _messageType) {
			return setMessageTypeOverriddenAsString(_messageType);
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentID")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty2ExecutionAgentID(String _tradeParty2ExecutionAgentID) {
			this.tradeParty2ExecutionAgentID = _tradeParty2ExecutionAgentID == null ? null : _tradeParty2ExecutionAgentID;
			return this;
		}
		
		@RosettaAttribute("tradeParty2ExecutionAgentIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty2ExecutionAgentIDType")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty2ExecutionAgentIDType(PartyIdentifierTypeEnum _tradeParty2ExecutionAgentIDType) {
			this.tradeParty2ExecutionAgentIDType = _tradeParty2ExecutionAgentIDType == null ? null : _tradeParty2ExecutionAgentIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentID")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1ExecutionAgentID(String _tradeParty1ExecutionAgentID) {
			this.tradeParty1ExecutionAgentID = _tradeParty1ExecutionAgentID == null ? null : _tradeParty1ExecutionAgentID;
			return this;
		}
		
		@RosettaAttribute("tradeParty1ExecutionAgentIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1ExecutionAgentIDType")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1ExecutionAgentIDType(PartyIdentifierTypeEnum _tradeParty1ExecutionAgentIDType) {
			this.tradeParty1ExecutionAgentIDType = _tradeParty1ExecutionAgentIDType == null ? null : _tradeParty1ExecutionAgentIDType;
			return this;
		}
		
		@RosettaAttribute("tradeParty1TransactionID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeParty1TransactionID")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setTradeParty1TransactionID(String _tradeParty1TransactionID) {
			this.tradeParty1TransactionID = _tradeParty1TransactionID == null ? null : _tradeParty1TransactionID;
			return this;
		}
		
		@RosettaAttribute("version")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("version")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setVersion(String _version) {
			this.version = _version == null ? null : _version;
			return this;
		}
		
		@RosettaAttribute("usiID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("usiID")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder setUsiID(String _usiID) {
			this.usiID = _usiID == null ? null : _usiID;
			return this;
		}
		
		@Override
		public DTCCAdditionalValuationFields build() {
			return new DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsImpl(this);
		}
		
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradeParty1IDType()!=null) return true;
			if (getSubmittingPartyIDType()!=null) return true;
			if (getSubmittedForParty()!=null) return true;
			if (getTradeParty1ReportingDestination()!=null && !getTradeParty1ReportingDestination().isEmpty()) return true;
			if (getMessageID()!=null) return true;
			if (getMessageType()!=null) return true;
			if (getUsiID()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder o = (DTCCAdditionalValuationFields.DTCCAdditionalValuationFieldsBuilder) other;
			
			
			merger.mergeBasic(getTradeParty1IDType(), o.getTradeParty1IDType(), this::setTradeParty1IDTypeOverriddenAsPartyIdentifierTypeEnum);
			merger.mergeBasic(getSubmittingPartyIDType(), o.getSubmittingPartyIDType(), this::setSubmittingPartyIDTypeOverriddenAsPartyIdentifierTypeEnum);
			merger.mergeBasic(getSubmittedForParty(), o.getSubmittedForParty(), this::setSubmittedForPartyOverriddenAsString);
			merger.mergeBasic(getTradeParty1ReportingDestination(), o.getTradeParty1ReportingDestination(), (Consumer<SupervisoryBodyEnum>) this::addTradeParty1ReportingDestinationOverriddenAsSupervisoryBodyEnum);
			merger.mergeBasic(getMessageID(), o.getMessageID(), this::setMessageIDOverriddenAsString);
			merger.mergeBasic(getMessageType(), o.getMessageType(), this::setMessageTypeOverriddenAsString);
			merger.mergeBasic(getUsiID(), o.getUsiID(), this::setUsiID);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DTCCAdditionalValuationFields _that = getType().cast(o);
		
			if (!Objects.equals(tradeParty1IDType, _that.getTradeParty1IDType())) return false;
			if (!Objects.equals(submittingPartyIDType, _that.getSubmittingPartyIDType())) return false;
			if (!Objects.equals(submittedForParty, _that.getSubmittedForParty())) return false;
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!Objects.equals(messageID, _that.getMessageID())) return false;
			if (!Objects.equals(messageType, _that.getMessageType())) return false;
			if (!Objects.equals(usiID, _that.getUsiID())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradeParty1IDType != null ? tradeParty1IDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittingPartyIDType != null ? submittingPartyIDType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (submittedForParty != null ? submittedForParty.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (messageID != null ? messageID.hashCode() : 0);
			_result = 31 * _result + (messageType != null ? messageType.hashCode() : 0);
			_result = 31 * _result + (usiID != null ? usiID.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DTCCAdditionalValuationFieldsBuilder {" +
				"tradeParty1IDType=" + this.tradeParty1IDType + ", " +
				"submittingPartyIDType=" + this.submittingPartyIDType + ", " +
				"submittedForParty=" + this.submittedForParty + ", " +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"messageID=" + this.messageID + ", " +
				"messageType=" + this.messageType + ", " +
				"usiID=" + this.usiID +
			'}' + " " + super.toString();
		}
	}
}
