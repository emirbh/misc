package fpml.consolidated.recordkeeping.processes;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.doc.EntityClassification;
import fpml.consolidated.doc.PartyRelationshipType;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.fpmlenum.EMIRSupervisoryBodyEnum;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationEMIR_2015Meta;
import fpml.consolidated.shared.ActionType;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
 *
 */
@RosettaDataType(value="RegulatoryClassificationEMIR_2015", builder=RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationEMIR_2015", model="fpml", builder=RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationEMIR_2015 extends RegulatoryClassification {

	RegulatoryClassificationEMIR_2015Meta metaData = new RegulatoryClassificationEMIR_2015Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). The regulator or other supervisory body the organization is registered with (e.g. ESMA).
	 *
	 */
	List<EMIRSupervisoryBodyEnum> getSupervisoryBody();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifies the role of this party in reporting this trade for this regulator; roles could include ReportingParty and Voluntary reporting.
	 *
	 */
	ReportingRole getReportingRole();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The reason this message is being sent, for example Snapshot, PET, Confirmation, RealTimePublic.
	 *
	 */
	List<? extends ReportingPurpose> getReportingPurpose();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party this regulator considers to be the buyer
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the party this regulator considers to be the seller.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Indicates how the parties to the trade (the counterparties) are related to each other with respect to this reporting regime, e.g. Affiliated, Intragroup, etc..
	 *
	 */
	PartyRelationshipType getTradePartyRelationshipType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Reports a regulator-specific code for the action associated with this submission. Used, for example, to report the ESMA action type.
	 *
	 */
	ActionType getActionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getMandatorilyClearable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Indicates whether the counterparty exceeds the volume threshold above which trades are required to be cleared.
	 *
	 */
	Boolean getExceedsClearingThreshold();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Indicates the category or classification or business role of the organization referenced by the partyTradeInformation with respect to this reporting regime, for example Financial, NonFinancial etc.
	 *
	 */
	EntityClassification getReportingPartyClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Indicates the category or classification or business role of the organization referenced by the partyTradeInformation with respect to this reporting regime, for example Financial, NonFinancial etc.
	 *
	 */
	EntityClassification getCounterPartyClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Indicates whether the counterparty is in the European Economic Area
	 *
	 */
	Boolean getCounterPartyisEEA();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision ESMA prodcut classification
	 *
	 */
	ESMAContractType getContractType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision ESMA delivery type
	 *
	 */
	ESMADeliveryType getDeliveryType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	ESMACreditDetails getCreditDetails();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	ESMAProductUnderlyer getUnderlyer();

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationEMIR_2015 build();
	
	RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder toBuilder();
	
	static RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder builder() {
		return new RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationEMIR_2015> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationEMIR_2015> getType() {
		return RegulatoryClassificationEMIR_2015.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), EMIRSupervisoryBodyEnum.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("tradePartyRelationshipType"), processor, PartyRelationshipType.class, getTradePartyRelationshipType());
		processRosetta(path.newSubPath("actionType"), processor, ActionType.class, getActionType());
		processor.processBasic(path.newSubPath("mandatorilyClearable"), Boolean.class, getMandatorilyClearable(), this);
		processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
		processRosetta(path.newSubPath("reportingPartyClassification"), processor, EntityClassification.class, getReportingPartyClassification());
		processRosetta(path.newSubPath("counterPartyClassification"), processor, EntityClassification.class, getCounterPartyClassification());
		processor.processBasic(path.newSubPath("counterPartyisEEA"), Boolean.class, getCounterPartyisEEA(), this);
		processRosetta(path.newSubPath("contractType"), processor, ESMAContractType.class, getContractType());
		processRosetta(path.newSubPath("deliveryType"), processor, ESMADeliveryType.class, getDeliveryType());
		processRosetta(path.newSubPath("creditDetails"), processor, ESMACreditDetails.class, getCreditDetails());
		processRosetta(path.newSubPath("underlyer"), processor, ESMAProductUnderlyer.class, getUnderlyer());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationEMIR_2015Builder extends RegulatoryClassificationEMIR_2015, RegulatoryClassification.RegulatoryClassificationBuilder {
		ReportingRole.ReportingRoleBuilder getOrCreateReportingRole();
		@Override
		ReportingRole.ReportingRoleBuilder getReportingRole();
		ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index);
		@Override
		List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose();
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		PartyRelationshipType.PartyRelationshipTypeBuilder getOrCreateTradePartyRelationshipType();
		@Override
		PartyRelationshipType.PartyRelationshipTypeBuilder getTradePartyRelationshipType();
		ActionType.ActionTypeBuilder getOrCreateActionType();
		@Override
		ActionType.ActionTypeBuilder getActionType();
		EntityClassification.EntityClassificationBuilder getOrCreateReportingPartyClassification();
		@Override
		EntityClassification.EntityClassificationBuilder getReportingPartyClassification();
		EntityClassification.EntityClassificationBuilder getOrCreateCounterPartyClassification();
		@Override
		EntityClassification.EntityClassificationBuilder getCounterPartyClassification();
		ESMAContractType.ESMAContractTypeBuilder getOrCreateContractType();
		@Override
		ESMAContractType.ESMAContractTypeBuilder getContractType();
		ESMADeliveryType.ESMADeliveryTypeBuilder getOrCreateDeliveryType();
		@Override
		ESMADeliveryType.ESMADeliveryTypeBuilder getDeliveryType();
		ESMACreditDetails.ESMACreditDetailsBuilder getOrCreateCreditDetails();
		@Override
		ESMACreditDetails.ESMACreditDetailsBuilder getCreditDetails();
		ESMAProductUnderlyer.ESMAProductUnderlyerBuilder getOrCreateUnderlyer();
		@Override
		ESMAProductUnderlyer.ESMAProductUnderlyerBuilder getUnderlyer();
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addSupervisoryBody(EMIRSupervisoryBodyEnum supervisoryBody);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addSupervisoryBody(EMIRSupervisoryBodyEnum supervisoryBody, int idx);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addSupervisoryBody(List<EMIRSupervisoryBodyEnum> supervisoryBody);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setSupervisoryBody(List<EMIRSupervisoryBodyEnum> supervisoryBody);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setBuyerPartyReference(PartyReference buyerPartyReference);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setSellerPartyReference(PartyReference sellerPartyReference);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setTradePartyRelationshipType(PartyRelationshipType tradePartyRelationshipType);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setActionType(ActionType actionType);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setMandatorilyClearable(Boolean mandatorilyClearable);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setExceedsClearingThreshold(Boolean exceedsClearingThreshold);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setReportingPartyClassification(EntityClassification reportingPartyClassification);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setCounterPartyClassification(EntityClassification counterPartyClassification);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setCounterPartyisEEA(Boolean counterPartyisEEA);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setContractType(ESMAContractType contractType);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setDeliveryType(ESMADeliveryType deliveryType);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setCreditDetails(ESMACreditDetails creditDetails);
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setUnderlyer(ESMAProductUnderlyer underlyer);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), EMIRSupervisoryBodyEnum.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("tradePartyRelationshipType"), processor, PartyRelationshipType.PartyRelationshipTypeBuilder.class, getTradePartyRelationshipType());
			processRosetta(path.newSubPath("actionType"), processor, ActionType.ActionTypeBuilder.class, getActionType());
			processor.processBasic(path.newSubPath("mandatorilyClearable"), Boolean.class, getMandatorilyClearable(), this);
			processor.processBasic(path.newSubPath("exceedsClearingThreshold"), Boolean.class, getExceedsClearingThreshold(), this);
			processRosetta(path.newSubPath("reportingPartyClassification"), processor, EntityClassification.EntityClassificationBuilder.class, getReportingPartyClassification());
			processRosetta(path.newSubPath("counterPartyClassification"), processor, EntityClassification.EntityClassificationBuilder.class, getCounterPartyClassification());
			processor.processBasic(path.newSubPath("counterPartyisEEA"), Boolean.class, getCounterPartyisEEA(), this);
			processRosetta(path.newSubPath("contractType"), processor, ESMAContractType.ESMAContractTypeBuilder.class, getContractType());
			processRosetta(path.newSubPath("deliveryType"), processor, ESMADeliveryType.ESMADeliveryTypeBuilder.class, getDeliveryType());
			processRosetta(path.newSubPath("creditDetails"), processor, ESMACreditDetails.ESMACreditDetailsBuilder.class, getCreditDetails());
			processRosetta(path.newSubPath("underlyer"), processor, ESMAProductUnderlyer.ESMAProductUnderlyerBuilder.class, getUnderlyer());
		}
		

		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationEMIR_2015  ***********************/
	class RegulatoryClassificationEMIR_2015Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationEMIR_2015 {
		private final List<EMIRSupervisoryBodyEnum> supervisoryBody;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final PartyReference buyerPartyReference;
		private final PartyReference sellerPartyReference;
		private final PartyRelationshipType tradePartyRelationshipType;
		private final ActionType actionType;
		private final Boolean mandatorilyClearable;
		private final Boolean exceedsClearingThreshold;
		private final EntityClassification reportingPartyClassification;
		private final EntityClassification counterPartyClassification;
		private final Boolean counterPartyisEEA;
		private final ESMAContractType contractType;
		private final ESMADeliveryType deliveryType;
		private final ESMACreditDetails creditDetails;
		private final ESMAProductUnderlyer underlyer;
		
		protected RegulatoryClassificationEMIR_2015Impl(RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder builder) {
			super(builder);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.tradePartyRelationshipType = ofNullable(builder.getTradePartyRelationshipType()).map(f->f.build()).orElse(null);
			this.actionType = ofNullable(builder.getActionType()).map(f->f.build()).orElse(null);
			this.mandatorilyClearable = builder.getMandatorilyClearable();
			this.exceedsClearingThreshold = builder.getExceedsClearingThreshold();
			this.reportingPartyClassification = ofNullable(builder.getReportingPartyClassification()).map(f->f.build()).orElse(null);
			this.counterPartyClassification = ofNullable(builder.getCounterPartyClassification()).map(f->f.build()).orElse(null);
			this.counterPartyisEEA = builder.getCounterPartyisEEA();
			this.contractType = ofNullable(builder.getContractType()).map(f->f.build()).orElse(null);
			this.deliveryType = ofNullable(builder.getDeliveryType()).map(f->f.build()).orElse(null);
			this.creditDetails = ofNullable(builder.getCreditDetails()).map(f->f.build()).orElse(null);
			this.underlyer = ofNullable(builder.getUnderlyer()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		public List<EMIRSupervisoryBodyEnum> getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRole getReportingRole() {
			return reportingRole;
		}
		
		@Override
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingPurpose")
		public List<? extends ReportingPurpose> getReportingPurpose() {
			return reportingPurpose;
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("tradePartyRelationshipType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePartyRelationshipType")
		public PartyRelationshipType getTradePartyRelationshipType() {
			return tradePartyRelationshipType;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public ActionType getActionType() {
			return actionType;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatorilyClearable")
		public Boolean getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exceedsClearingThreshold")
		public Boolean getExceedsClearingThreshold() {
			return exceedsClearingThreshold;
		}
		
		@Override
		@RosettaAttribute("reportingPartyClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingPartyClassification")
		public EntityClassification getReportingPartyClassification() {
			return reportingPartyClassification;
		}
		
		@Override
		@RosettaAttribute("counterPartyClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyClassification")
		public EntityClassification getCounterPartyClassification() {
			return counterPartyClassification;
		}
		
		@Override
		@RosettaAttribute("counterPartyisEEA")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyisEEA")
		public Boolean getCounterPartyisEEA() {
			return counterPartyisEEA;
		}
		
		@Override
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractType")
		public ESMAContractType getContractType() {
			return contractType;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public ESMADeliveryType getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("creditDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditDetails")
		public ESMACreditDetails getCreditDetails() {
			return creditDetails;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public ESMAProductUnderlyer getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public RegulatoryClassificationEMIR_2015 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder toBuilder() {
			RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getTradePartyRelationshipType()).ifPresent(builder::setTradePartyRelationshipType);
			ofNullable(getActionType()).ifPresent(builder::setActionType);
			ofNullable(getMandatorilyClearable()).ifPresent(builder::setMandatorilyClearable);
			ofNullable(getExceedsClearingThreshold()).ifPresent(builder::setExceedsClearingThreshold);
			ofNullable(getReportingPartyClassification()).ifPresent(builder::setReportingPartyClassification);
			ofNullable(getCounterPartyClassification()).ifPresent(builder::setCounterPartyClassification);
			ofNullable(getCounterPartyisEEA()).ifPresent(builder::setCounterPartyisEEA);
			ofNullable(getContractType()).ifPresent(builder::setContractType);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
			ofNullable(getCreditDetails()).ifPresent(builder::setCreditDetails);
			ofNullable(getUnderlyer()).ifPresent(builder::setUnderlyer);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationEMIR_2015 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(tradePartyRelationshipType, _that.getTradePartyRelationshipType())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(exceedsClearingThreshold, _that.getExceedsClearingThreshold())) return false;
			if (!Objects.equals(reportingPartyClassification, _that.getReportingPartyClassification())) return false;
			if (!Objects.equals(counterPartyClassification, _that.getCounterPartyClassification())) return false;
			if (!Objects.equals(counterPartyisEEA, _that.getCounterPartyisEEA())) return false;
			if (!Objects.equals(contractType, _that.getContractType())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(creditDetails, _that.getCreditDetails())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (tradePartyRelationshipType != null ? tradePartyRelationshipType.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (exceedsClearingThreshold != null ? exceedsClearingThreshold.hashCode() : 0);
			_result = 31 * _result + (reportingPartyClassification != null ? reportingPartyClassification.hashCode() : 0);
			_result = 31 * _result + (counterPartyClassification != null ? counterPartyClassification.hashCode() : 0);
			_result = 31 * _result + (counterPartyisEEA != null ? counterPartyisEEA.hashCode() : 0);
			_result = 31 * _result + (contractType != null ? contractType.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.hashCode() : 0);
			_result = 31 * _result + (creditDetails != null ? creditDetails.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationEMIR_2015 {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"tradePartyRelationshipType=" + this.tradePartyRelationshipType + ", " +
				"actionType=" + this.actionType + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"reportingPartyClassification=" + this.reportingPartyClassification + ", " +
				"counterPartyClassification=" + this.counterPartyClassification + ", " +
				"counterPartyisEEA=" + this.counterPartyisEEA + ", " +
				"contractType=" + this.contractType + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"creditDetails=" + this.creditDetails + ", " +
				"underlyer=" + this.underlyer +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationEMIR_2015  ***********************/
	class RegulatoryClassificationEMIR_2015BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder {
	
		protected List<EMIRSupervisoryBodyEnum> supervisoryBody = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected PartyRelationshipType.PartyRelationshipTypeBuilder tradePartyRelationshipType;
		protected ActionType.ActionTypeBuilder actionType;
		protected Boolean mandatorilyClearable;
		protected Boolean exceedsClearingThreshold;
		protected EntityClassification.EntityClassificationBuilder reportingPartyClassification;
		protected EntityClassification.EntityClassificationBuilder counterPartyClassification;
		protected Boolean counterPartyisEEA;
		protected ESMAContractType.ESMAContractTypeBuilder contractType;
		protected ESMADeliveryType.ESMADeliveryTypeBuilder deliveryType;
		protected ESMACreditDetails.ESMACreditDetailsBuilder creditDetails;
		protected ESMAProductUnderlyer.ESMAProductUnderlyerBuilder underlyer;
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		public List<EMIRSupervisoryBodyEnum> getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingRole")
		public ReportingRole.ReportingRoleBuilder getReportingRole() {
			return reportingRole;
		}
		
		@Override
		public ReportingRole.ReportingRoleBuilder getOrCreateReportingRole() {
			ReportingRole.ReportingRoleBuilder result;
			if (reportingRole!=null) {
				result = reportingRole;
			}
			else {
				result = reportingRole = ReportingRole.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingPurpose")
		public List<? extends ReportingPurpose.ReportingPurposeBuilder> getReportingPurpose() {
			return reportingPurpose;
		}
		
		@Override
		public ReportingPurpose.ReportingPurposeBuilder getOrCreateReportingPurpose(int index) {
			if (reportingPurpose==null) {
				this.reportingPurpose = new ArrayList<>();
			}
			return getIndex(reportingPurpose, index, () -> {
						ReportingPurpose.ReportingPurposeBuilder newReportingPurpose = ReportingPurpose.builder();
						return newReportingPurpose;
					});
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradePartyRelationshipType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePartyRelationshipType")
		public PartyRelationshipType.PartyRelationshipTypeBuilder getTradePartyRelationshipType() {
			return tradePartyRelationshipType;
		}
		
		@Override
		public PartyRelationshipType.PartyRelationshipTypeBuilder getOrCreateTradePartyRelationshipType() {
			PartyRelationshipType.PartyRelationshipTypeBuilder result;
			if (tradePartyRelationshipType!=null) {
				result = tradePartyRelationshipType;
			}
			else {
				result = tradePartyRelationshipType = PartyRelationshipType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actionType")
		public ActionType.ActionTypeBuilder getActionType() {
			return actionType;
		}
		
		@Override
		public ActionType.ActionTypeBuilder getOrCreateActionType() {
			ActionType.ActionTypeBuilder result;
			if (actionType!=null) {
				result = actionType;
			}
			else {
				result = actionType = ActionType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mandatorilyClearable")
		public Boolean getMandatorilyClearable() {
			return mandatorilyClearable;
		}
		
		@Override
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exceedsClearingThreshold")
		public Boolean getExceedsClearingThreshold() {
			return exceedsClearingThreshold;
		}
		
		@Override
		@RosettaAttribute("reportingPartyClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportingPartyClassification")
		public EntityClassification.EntityClassificationBuilder getReportingPartyClassification() {
			return reportingPartyClassification;
		}
		
		@Override
		public EntityClassification.EntityClassificationBuilder getOrCreateReportingPartyClassification() {
			EntityClassification.EntityClassificationBuilder result;
			if (reportingPartyClassification!=null) {
				result = reportingPartyClassification;
			}
			else {
				result = reportingPartyClassification = EntityClassification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterPartyClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyClassification")
		public EntityClassification.EntityClassificationBuilder getCounterPartyClassification() {
			return counterPartyClassification;
		}
		
		@Override
		public EntityClassification.EntityClassificationBuilder getOrCreateCounterPartyClassification() {
			EntityClassification.EntityClassificationBuilder result;
			if (counterPartyClassification!=null) {
				result = counterPartyClassification;
			}
			else {
				result = counterPartyClassification = EntityClassification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("counterPartyisEEA")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("counterPartyisEEA")
		public Boolean getCounterPartyisEEA() {
			return counterPartyisEEA;
		}
		
		@Override
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractType")
		public ESMAContractType.ESMAContractTypeBuilder getContractType() {
			return contractType;
		}
		
		@Override
		public ESMAContractType.ESMAContractTypeBuilder getOrCreateContractType() {
			ESMAContractType.ESMAContractTypeBuilder result;
			if (contractType!=null) {
				result = contractType;
			}
			else {
				result = contractType = ESMAContractType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public ESMADeliveryType.ESMADeliveryTypeBuilder getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		public ESMADeliveryType.ESMADeliveryTypeBuilder getOrCreateDeliveryType() {
			ESMADeliveryType.ESMADeliveryTypeBuilder result;
			if (deliveryType!=null) {
				result = deliveryType;
			}
			else {
				result = deliveryType = ESMADeliveryType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creditDetails")
		public ESMACreditDetails.ESMACreditDetailsBuilder getCreditDetails() {
			return creditDetails;
		}
		
		@Override
		public ESMACreditDetails.ESMACreditDetailsBuilder getOrCreateCreditDetails() {
			ESMACreditDetails.ESMACreditDetailsBuilder result;
			if (creditDetails!=null) {
				result = creditDetails;
			}
			else {
				result = creditDetails = ESMACreditDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyer")
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder getUnderlyer() {
			return underlyer;
		}
		
		@Override
		public ESMAProductUnderlyer.ESMAProductUnderlyerBuilder getOrCreateUnderlyer() {
			ESMAProductUnderlyer.ESMAProductUnderlyerBuilder result;
			if (underlyer!=null) {
				result = underlyer;
			}
			else {
				result = underlyer = ESMAProductUnderlyer.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addSupervisoryBody(EMIRSupervisoryBodyEnum _supervisoryBody) {
			if (_supervisoryBody != null) {
				this.supervisoryBody.add(_supervisoryBody);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addSupervisoryBody(EMIRSupervisoryBodyEnum _supervisoryBody, int idx) {
			getIndex(this.supervisoryBody, idx, () -> _supervisoryBody);
			return this;
		}
		
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addSupervisoryBody(List<EMIRSupervisoryBodyEnum> supervisoryBodys) {
			if (supervisoryBodys != null) {
				for (final EMIRSupervisoryBodyEnum toAdd : supervisoryBodys) {
					this.supervisoryBody.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setSupervisoryBody(List<EMIRSupervisoryBodyEnum> supervisoryBodys) {
			if (supervisoryBodys == null) {
				this.supervisoryBody = new ArrayList<>();
			} else {
				this.supervisoryBody = supervisoryBodys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingRole")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingRole")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes != null) {
				for (final ReportingPurpose toAdd : reportingPurposes) {
					this.reportingPurpose.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
			if (reportingPurposes == null) {
				this.reportingPurpose = new ArrayList<>();
			} else {
				this.reportingPurpose = reportingPurposes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerPartyReference")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradePartyRelationshipType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePartyRelationshipType")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setTradePartyRelationshipType(PartyRelationshipType _tradePartyRelationshipType) {
			this.tradePartyRelationshipType = _tradePartyRelationshipType == null ? null : _tradePartyRelationshipType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("actionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actionType")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setActionType(ActionType _actionType) {
			this.actionType = _actionType == null ? null : _actionType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mandatorilyClearable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mandatorilyClearable")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setMandatorilyClearable(Boolean _mandatorilyClearable) {
			this.mandatorilyClearable = _mandatorilyClearable == null ? null : _mandatorilyClearable;
			return this;
		}
		
		@RosettaAttribute("exceedsClearingThreshold")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exceedsClearingThreshold")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setExceedsClearingThreshold(Boolean _exceedsClearingThreshold) {
			this.exceedsClearingThreshold = _exceedsClearingThreshold == null ? null : _exceedsClearingThreshold;
			return this;
		}
		
		@RosettaAttribute("reportingPartyClassification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportingPartyClassification")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setReportingPartyClassification(EntityClassification _reportingPartyClassification) {
			this.reportingPartyClassification = _reportingPartyClassification == null ? null : _reportingPartyClassification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterPartyClassification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterPartyClassification")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setCounterPartyClassification(EntityClassification _counterPartyClassification) {
			this.counterPartyClassification = _counterPartyClassification == null ? null : _counterPartyClassification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("counterPartyisEEA")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("counterPartyisEEA")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setCounterPartyisEEA(Boolean _counterPartyisEEA) {
			this.counterPartyisEEA = _counterPartyisEEA == null ? null : _counterPartyisEEA;
			return this;
		}
		
		@RosettaAttribute("contractType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractType")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setContractType(ESMAContractType _contractType) {
			this.contractType = _contractType == null ? null : _contractType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setDeliveryType(ESMADeliveryType _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creditDetails")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setCreditDetails(ESMACreditDetails _creditDetails) {
			this.creditDetails = _creditDetails == null ? null : _creditDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("underlyer")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyer")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder setUnderlyer(ESMAProductUnderlyer _underlyer) {
			this.underlyer = _underlyer == null ? null : _underlyer.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryClassificationEMIR_2015 build() {
			return new RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Impl(this);
		}
		
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder prune() {
			super.prune();
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (tradePartyRelationshipType!=null && !tradePartyRelationshipType.prune().hasData()) tradePartyRelationshipType = null;
			if (actionType!=null && !actionType.prune().hasData()) actionType = null;
			if (reportingPartyClassification!=null && !reportingPartyClassification.prune().hasData()) reportingPartyClassification = null;
			if (counterPartyClassification!=null && !counterPartyClassification.prune().hasData()) counterPartyClassification = null;
			if (contractType!=null && !contractType.prune().hasData()) contractType = null;
			if (deliveryType!=null && !deliveryType.prune().hasData()) deliveryType = null;
			if (creditDetails!=null && !creditDetails.prune().hasData()) creditDetails = null;
			if (underlyer!=null && !underlyer.prune().hasData()) underlyer = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSupervisoryBody()!=null && !getSupervisoryBody().isEmpty()) return true;
			if (getReportingRole()!=null && getReportingRole().hasData()) return true;
			if (getReportingPurpose()!=null && getReportingPurpose().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getTradePartyRelationshipType()!=null && getTradePartyRelationshipType().hasData()) return true;
			if (getActionType()!=null && getActionType().hasData()) return true;
			if (getMandatorilyClearable()!=null) return true;
			if (getExceedsClearingThreshold()!=null) return true;
			if (getReportingPartyClassification()!=null && getReportingPartyClassification().hasData()) return true;
			if (getCounterPartyClassification()!=null && getCounterPartyClassification().hasData()) return true;
			if (getCounterPartyisEEA()!=null) return true;
			if (getContractType()!=null && getContractType().hasData()) return true;
			if (getDeliveryType()!=null && getDeliveryType().hasData()) return true;
			if (getCreditDetails()!=null && getCreditDetails().hasData()) return true;
			if (getUnderlyer()!=null && getUnderlyer().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder o = (RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getTradePartyRelationshipType(), o.getTradePartyRelationshipType(), this::setTradePartyRelationshipType);
			merger.mergeRosetta(getActionType(), o.getActionType(), this::setActionType);
			merger.mergeRosetta(getReportingPartyClassification(), o.getReportingPartyClassification(), this::setReportingPartyClassification);
			merger.mergeRosetta(getCounterPartyClassification(), o.getCounterPartyClassification(), this::setCounterPartyClassification);
			merger.mergeRosetta(getContractType(), o.getContractType(), this::setContractType);
			merger.mergeRosetta(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			merger.mergeRosetta(getCreditDetails(), o.getCreditDetails(), this::setCreditDetails);
			merger.mergeRosetta(getUnderlyer(), o.getUnderlyer(), this::setUnderlyer);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), (Consumer<EMIRSupervisoryBodyEnum>) this::addSupervisoryBody);
			merger.mergeBasic(getMandatorilyClearable(), o.getMandatorilyClearable(), this::setMandatorilyClearable);
			merger.mergeBasic(getExceedsClearingThreshold(), o.getExceedsClearingThreshold(), this::setExceedsClearingThreshold);
			merger.mergeBasic(getCounterPartyisEEA(), o.getCounterPartyisEEA(), this::setCounterPartyisEEA);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationEMIR_2015 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(tradePartyRelationshipType, _that.getTradePartyRelationshipType())) return false;
			if (!Objects.equals(actionType, _that.getActionType())) return false;
			if (!Objects.equals(mandatorilyClearable, _that.getMandatorilyClearable())) return false;
			if (!Objects.equals(exceedsClearingThreshold, _that.getExceedsClearingThreshold())) return false;
			if (!Objects.equals(reportingPartyClassification, _that.getReportingPartyClassification())) return false;
			if (!Objects.equals(counterPartyClassification, _that.getCounterPartyClassification())) return false;
			if (!Objects.equals(counterPartyisEEA, _that.getCounterPartyisEEA())) return false;
			if (!Objects.equals(contractType, _that.getContractType())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(creditDetails, _that.getCreditDetails())) return false;
			if (!Objects.equals(underlyer, _that.getUnderlyer())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (tradePartyRelationshipType != null ? tradePartyRelationshipType.hashCode() : 0);
			_result = 31 * _result + (actionType != null ? actionType.hashCode() : 0);
			_result = 31 * _result + (mandatorilyClearable != null ? mandatorilyClearable.hashCode() : 0);
			_result = 31 * _result + (exceedsClearingThreshold != null ? exceedsClearingThreshold.hashCode() : 0);
			_result = 31 * _result + (reportingPartyClassification != null ? reportingPartyClassification.hashCode() : 0);
			_result = 31 * _result + (counterPartyClassification != null ? counterPartyClassification.hashCode() : 0);
			_result = 31 * _result + (counterPartyisEEA != null ? counterPartyisEEA.hashCode() : 0);
			_result = 31 * _result + (contractType != null ? contractType.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.hashCode() : 0);
			_result = 31 * _result + (creditDetails != null ? creditDetails.hashCode() : 0);
			_result = 31 * _result + (underlyer != null ? underlyer.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationEMIR_2015Builder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"tradePartyRelationshipType=" + this.tradePartyRelationshipType + ", " +
				"actionType=" + this.actionType + ", " +
				"mandatorilyClearable=" + this.mandatorilyClearable + ", " +
				"exceedsClearingThreshold=" + this.exceedsClearingThreshold + ", " +
				"reportingPartyClassification=" + this.reportingPartyClassification + ", " +
				"counterPartyClassification=" + this.counterPartyClassification + ", " +
				"counterPartyisEEA=" + this.counterPartyisEEA + ", " +
				"contractType=" + this.contractType + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"creditDetails=" + this.creditDetails + ", " +
				"underlyer=" + this.underlyer +
			'}' + " " + super.toString();
		}
	}
}
