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
import fpml.consolidated.doc.AdmissionToTrading;
import fpml.consolidated.doc.CurrencyPairClassification;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationMifirRTS23_2015Meta;
import fpml.consolidated.shared.CreditSeniority;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
import fpml.consolidated.shared.RelatedPerson;
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
@RosettaDataType(value="RegulatoryClassificationMifirRTS23_2015", builder=RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationMifirRTS23_2015", model="fpml", builder=RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationMifirRTS23_2015 extends RegulatoryClassification {

	RegulatoryClassificationMifirRTS23_2015Meta metaData = new RegulatoryClassificationMifirRTS23_2015Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	List<String> getSupervisoryBody();
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
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides information about a person that executed or supports this trade
	 *
	 */
	List<? extends RelatedPerson> getRelatedPerson();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryTradingObligation getTradingObligation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Whether the transaction reduces risk in an objectively measurable way. Only applicable for commodity derivative transactions.
	 *
	 */
	Boolean getIsCommodityHedge();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12). Reports a regulator-specific code classifying the currency pair in the trade into risk categories such as Major Currencies or Emerging Markets.
	 *
	 */
	CurrencyPairClassification getCurrencyPairClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	Boolean getTransmissionOfOrder();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	AdmissionToTrading getAdmissionToTrading();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Use instead the field within credit products: indexReferenceInformation/seniority (RPTWG decision 2017-09)
	 *
	 */
	CreditSeniority getSeniority();

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationMifirRTS23_2015 build();
	
	RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder toBuilder();
	
	static RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder builder() {
		return new RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationMifirRTS23_2015> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationMifirRTS23_2015> getType() {
		return RegulatoryClassificationMifirRTS23_2015.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.class, getReportingRole());
		processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.class, getReportingPurpose());
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("relatedPerson"), processor, RelatedPerson.class, getRelatedPerson());
		processRosetta(path.newSubPath("tradingObligation"), processor, RegulatoryTradingObligation.class, getTradingObligation());
		processor.processBasic(path.newSubPath("isCommodityHedge"), Boolean.class, getIsCommodityHedge(), this);
		processRosetta(path.newSubPath("currencyPairClassification"), processor, CurrencyPairClassification.class, getCurrencyPairClassification());
		processor.processBasic(path.newSubPath("transmissionOfOrder"), Boolean.class, getTransmissionOfOrder(), this);
		processRosetta(path.newSubPath("admissionToTrading"), processor, AdmissionToTrading.class, getAdmissionToTrading());
		processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.class, getSeniority());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationMifirRTS23_2015Builder extends RegulatoryClassificationMifirRTS23_2015, RegulatoryClassification.RegulatoryClassificationBuilder {
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
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		RelatedPerson.RelatedPersonBuilder getOrCreateRelatedPerson(int index);
		@Override
		List<? extends RelatedPerson.RelatedPersonBuilder> getRelatedPerson();
		RegulatoryTradingObligation.RegulatoryTradingObligationBuilder getOrCreateTradingObligation();
		@Override
		RegulatoryTradingObligation.RegulatoryTradingObligationBuilder getTradingObligation();
		CurrencyPairClassification.CurrencyPairClassificationBuilder getOrCreateCurrencyPairClassification();
		@Override
		CurrencyPairClassification.CurrencyPairClassificationBuilder getCurrencyPairClassification();
		AdmissionToTrading.AdmissionToTradingBuilder getOrCreateAdmissionToTrading();
		@Override
		AdmissionToTrading.AdmissionToTradingBuilder getAdmissionToTrading();
		CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority();
		@Override
		CreditSeniority.CreditSeniorityBuilder getSeniority();
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addSupervisoryBody(String supervisoryBody);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addSupervisoryBody(String supervisoryBody, int idx);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setBuyerPartyReference(PartyReference buyerPartyReference);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setSellerPartyReference(PartyReference sellerPartyReference);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedParty(RelatedParty relatedParty);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedParty(RelatedParty relatedParty, int idx);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedParty(List<? extends RelatedParty> relatedParty);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setRelatedParty(List<? extends RelatedParty> relatedParty);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedPerson(RelatedPerson relatedPerson);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedPerson(RelatedPerson relatedPerson, int idx);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedPerson(List<? extends RelatedPerson> relatedPerson);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setRelatedPerson(List<? extends RelatedPerson> relatedPerson);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setTradingObligation(RegulatoryTradingObligation tradingObligation);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setIsCommodityHedge(Boolean isCommodityHedge);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setCurrencyPairClassification(CurrencyPairClassification currencyPairClassification);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setTransmissionOfOrder(Boolean transmissionOfOrder);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setAdmissionToTrading(AdmissionToTrading admissionToTrading);
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setSeniority(CreditSeniority seniority);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("reportingRole"), processor, ReportingRole.ReportingRoleBuilder.class, getReportingRole());
			processRosetta(path.newSubPath("reportingPurpose"), processor, ReportingPurpose.ReportingPurposeBuilder.class, getReportingPurpose());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("relatedPerson"), processor, RelatedPerson.RelatedPersonBuilder.class, getRelatedPerson());
			processRosetta(path.newSubPath("tradingObligation"), processor, RegulatoryTradingObligation.RegulatoryTradingObligationBuilder.class, getTradingObligation());
			processor.processBasic(path.newSubPath("isCommodityHedge"), Boolean.class, getIsCommodityHedge(), this);
			processRosetta(path.newSubPath("currencyPairClassification"), processor, CurrencyPairClassification.CurrencyPairClassificationBuilder.class, getCurrencyPairClassification());
			processor.processBasic(path.newSubPath("transmissionOfOrder"), Boolean.class, getTransmissionOfOrder(), this);
			processRosetta(path.newSubPath("admissionToTrading"), processor, AdmissionToTrading.AdmissionToTradingBuilder.class, getAdmissionToTrading());
			processRosetta(path.newSubPath("seniority"), processor, CreditSeniority.CreditSeniorityBuilder.class, getSeniority());
		}
		

		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationMifirRTS23_2015  ***********************/
	class RegulatoryClassificationMifirRTS23_2015Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationMifirRTS23_2015 {
		private final List<String> supervisoryBody;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final PartyReference buyerPartyReference;
		private final PartyReference sellerPartyReference;
		private final List<? extends RelatedParty> relatedParty;
		private final List<? extends RelatedPerson> relatedPerson;
		private final RegulatoryTradingObligation tradingObligation;
		private final Boolean isCommodityHedge;
		private final CurrencyPairClassification currencyPairClassification;
		private final Boolean transmissionOfOrder;
		private final AdmissionToTrading admissionToTrading;
		private final CreditSeniority seniority;
		
		protected RegulatoryClassificationMifirRTS23_2015Impl(RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder builder) {
			super(builder);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.relatedPerson = ofNullable(builder.getRelatedPerson()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradingObligation = ofNullable(builder.getTradingObligation()).map(f->f.build()).orElse(null);
			this.isCommodityHedge = builder.getIsCommodityHedge();
			this.currencyPairClassification = ofNullable(builder.getCurrencyPairClassification()).map(f->f.build()).orElse(null);
			this.transmissionOfOrder = builder.getTransmissionOfOrder();
			this.admissionToTrading = ofNullable(builder.getAdmissionToTrading()).map(f->f.build()).orElse(null);
			this.seniority = ofNullable(builder.getSeniority()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		public List<String> getSupervisoryBody() {
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
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedPerson")
		public List<? extends RelatedPerson> getRelatedPerson() {
			return relatedPerson;
		}
		
		@Override
		@RosettaAttribute("tradingObligation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradingObligation")
		public RegulatoryTradingObligation getTradingObligation() {
			return tradingObligation;
		}
		
		@Override
		@RosettaAttribute("isCommodityHedge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCommodityHedge")
		public Boolean getIsCommodityHedge() {
			return isCommodityHedge;
		}
		
		@Override
		@RosettaAttribute("currencyPairClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyPairClassification")
		public CurrencyPairClassification getCurrencyPairClassification() {
			return currencyPairClassification;
		}
		
		@Override
		@RosettaAttribute("transmissionOfOrder")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transmissionOfOrder")
		public Boolean getTransmissionOfOrder() {
			return transmissionOfOrder;
		}
		
		@Override
		@RosettaAttribute("admissionToTrading")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("admissionToTrading")
		public AdmissionToTrading getAdmissionToTrading() {
			return admissionToTrading;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority getSeniority() {
			return seniority;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder toBuilder() {
			RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getRelatedPerson()).ifPresent(builder::setRelatedPerson);
			ofNullable(getTradingObligation()).ifPresent(builder::setTradingObligation);
			ofNullable(getIsCommodityHedge()).ifPresent(builder::setIsCommodityHedge);
			ofNullable(getCurrencyPairClassification()).ifPresent(builder::setCurrencyPairClassification);
			ofNullable(getTransmissionOfOrder()).ifPresent(builder::setTransmissionOfOrder);
			ofNullable(getAdmissionToTrading()).ifPresent(builder::setAdmissionToTrading);
			ofNullable(getSeniority()).ifPresent(builder::setSeniority);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationMifirRTS23_2015 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!Objects.equals(tradingObligation, _that.getTradingObligation())) return false;
			if (!Objects.equals(isCommodityHedge, _that.getIsCommodityHedge())) return false;
			if (!Objects.equals(currencyPairClassification, _that.getCurrencyPairClassification())) return false;
			if (!Objects.equals(transmissionOfOrder, _that.getTransmissionOfOrder())) return false;
			if (!Objects.equals(admissionToTrading, _that.getAdmissionToTrading())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (tradingObligation != null ? tradingObligation.hashCode() : 0);
			_result = 31 * _result + (isCommodityHedge != null ? isCommodityHedge.hashCode() : 0);
			_result = 31 * _result + (currencyPairClassification != null ? currencyPairClassification.hashCode() : 0);
			_result = 31 * _result + (transmissionOfOrder != null ? transmissionOfOrder.hashCode() : 0);
			_result = 31 * _result + (admissionToTrading != null ? admissionToTrading.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationMifirRTS23_2015 {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"tradingObligation=" + this.tradingObligation + ", " +
				"isCommodityHedge=" + this.isCommodityHedge + ", " +
				"currencyPairClassification=" + this.currencyPairClassification + ", " +
				"transmissionOfOrder=" + this.transmissionOfOrder + ", " +
				"admissionToTrading=" + this.admissionToTrading + ", " +
				"seniority=" + this.seniority +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationMifirRTS23_2015  ***********************/
	class RegulatoryClassificationMifirRTS23_2015BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder {
	
		protected List<String> supervisoryBody = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected List<RelatedPerson.RelatedPersonBuilder> relatedPerson = new ArrayList<>();
		protected RegulatoryTradingObligation.RegulatoryTradingObligationBuilder tradingObligation;
		protected Boolean isCommodityHedge;
		protected CurrencyPairClassification.CurrencyPairClassificationBuilder currencyPairClassification;
		protected Boolean transmissionOfOrder;
		protected AdmissionToTrading.AdmissionToTradingBuilder admissionToTrading;
		protected CreditSeniority.CreditSeniorityBuilder seniority;
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("supervisoryBody")
		public List<String> getSupervisoryBody() {
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
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedPerson")
		public List<? extends RelatedPerson.RelatedPersonBuilder> getRelatedPerson() {
			return relatedPerson;
		}
		
		@Override
		public RelatedPerson.RelatedPersonBuilder getOrCreateRelatedPerson(int index) {
			if (relatedPerson==null) {
				this.relatedPerson = new ArrayList<>();
			}
			return getIndex(relatedPerson, index, () -> {
						RelatedPerson.RelatedPersonBuilder newRelatedPerson = RelatedPerson.builder();
						return newRelatedPerson;
					});
		}
		
		@Override
		@RosettaAttribute("tradingObligation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradingObligation")
		public RegulatoryTradingObligation.RegulatoryTradingObligationBuilder getTradingObligation() {
			return tradingObligation;
		}
		
		@Override
		public RegulatoryTradingObligation.RegulatoryTradingObligationBuilder getOrCreateTradingObligation() {
			RegulatoryTradingObligation.RegulatoryTradingObligationBuilder result;
			if (tradingObligation!=null) {
				result = tradingObligation;
			}
			else {
				result = tradingObligation = RegulatoryTradingObligation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isCommodityHedge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCommodityHedge")
		public Boolean getIsCommodityHedge() {
			return isCommodityHedge;
		}
		
		@Override
		@RosettaAttribute("currencyPairClassification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currencyPairClassification")
		public CurrencyPairClassification.CurrencyPairClassificationBuilder getCurrencyPairClassification() {
			return currencyPairClassification;
		}
		
		@Override
		public CurrencyPairClassification.CurrencyPairClassificationBuilder getOrCreateCurrencyPairClassification() {
			CurrencyPairClassification.CurrencyPairClassificationBuilder result;
			if (currencyPairClassification!=null) {
				result = currencyPairClassification;
			}
			else {
				result = currencyPairClassification = CurrencyPairClassification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transmissionOfOrder")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transmissionOfOrder")
		public Boolean getTransmissionOfOrder() {
			return transmissionOfOrder;
		}
		
		@Override
		@RosettaAttribute("admissionToTrading")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("admissionToTrading")
		public AdmissionToTrading.AdmissionToTradingBuilder getAdmissionToTrading() {
			return admissionToTrading;
		}
		
		@Override
		public AdmissionToTrading.AdmissionToTradingBuilder getOrCreateAdmissionToTrading() {
			AdmissionToTrading.AdmissionToTradingBuilder result;
			if (admissionToTrading!=null) {
				result = admissionToTrading;
			}
			else {
				result = admissionToTrading = AdmissionToTrading.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seniority")
		public CreditSeniority.CreditSeniorityBuilder getSeniority() {
			return seniority;
		}
		
		@Override
		public CreditSeniority.CreditSeniorityBuilder getOrCreateSeniority() {
			CreditSeniority.CreditSeniorityBuilder result;
			if (seniority!=null) {
				result = seniority;
			}
			else {
				result = seniority = CreditSeniority.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addSupervisoryBody(String _supervisoryBody) {
			if (_supervisoryBody != null) {
				this.supervisoryBody.add(_supervisoryBody);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addSupervisoryBody(String _supervisoryBody, int idx) {
			getIndex(this.supervisoryBody, idx, () -> _supervisoryBody);
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addSupervisoryBody(List<String> supervisoryBodys) {
			if (supervisoryBodys != null) {
				for (final String toAdd : supervisoryBodys) {
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
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedPerson")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedPerson(RelatedPerson _relatedPerson) {
			if (_relatedPerson != null) {
				this.relatedPerson.add(_relatedPerson.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedPerson(RelatedPerson _relatedPerson, int idx) {
			getIndex(this.relatedPerson, idx, () -> _relatedPerson.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder addRelatedPerson(List<? extends RelatedPerson> relatedPersons) {
			if (relatedPersons != null) {
				for (final RelatedPerson toAdd : relatedPersons) {
					this.relatedPerson.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedPerson")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedPerson")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setRelatedPerson(List<? extends RelatedPerson> relatedPersons) {
			if (relatedPersons == null) {
				this.relatedPerson = new ArrayList<>();
			} else {
				this.relatedPerson = relatedPersons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradingObligation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingObligation")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setTradingObligation(RegulatoryTradingObligation _tradingObligation) {
			this.tradingObligation = _tradingObligation == null ? null : _tradingObligation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isCommodityHedge")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCommodityHedge")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setIsCommodityHedge(Boolean _isCommodityHedge) {
			this.isCommodityHedge = _isCommodityHedge == null ? null : _isCommodityHedge;
			return this;
		}
		
		@RosettaAttribute("currencyPairClassification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currencyPairClassification")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setCurrencyPairClassification(CurrencyPairClassification _currencyPairClassification) {
			this.currencyPairClassification = _currencyPairClassification == null ? null : _currencyPairClassification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transmissionOfOrder")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transmissionOfOrder")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setTransmissionOfOrder(Boolean _transmissionOfOrder) {
			this.transmissionOfOrder = _transmissionOfOrder == null ? null : _transmissionOfOrder;
			return this;
		}
		
		@RosettaAttribute("admissionToTrading")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("admissionToTrading")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setAdmissionToTrading(AdmissionToTrading _admissionToTrading) {
			this.admissionToTrading = _admissionToTrading == null ? null : _admissionToTrading.toBuilder();
			return this;
		}
		
		@RosettaAttribute("seniority")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seniority")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder setSeniority(CreditSeniority _seniority) {
			this.seniority = _seniority == null ? null : _seniority.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015 build() {
			return new RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Impl(this);
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder prune() {
			super.prune();
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			relatedPerson = relatedPerson.stream().filter(b->b!=null).<RelatedPerson.RelatedPersonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradingObligation!=null && !tradingObligation.prune().hasData()) tradingObligation = null;
			if (currencyPairClassification!=null && !currencyPairClassification.prune().hasData()) currencyPairClassification = null;
			if (admissionToTrading!=null && !admissionToTrading.prune().hasData()) admissionToTrading = null;
			if (seniority!=null && !seniority.prune().hasData()) seniority = null;
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
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRelatedPerson()!=null && getRelatedPerson().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradingObligation()!=null && getTradingObligation().hasData()) return true;
			if (getIsCommodityHedge()!=null) return true;
			if (getCurrencyPairClassification()!=null && getCurrencyPairClassification().hasData()) return true;
			if (getTransmissionOfOrder()!=null) return true;
			if (getAdmissionToTrading()!=null && getAdmissionToTrading().hasData()) return true;
			if (getSeniority()!=null && getSeniority().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder o = (RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getRelatedPerson(), o.getRelatedPerson(), this::getOrCreateRelatedPerson);
			merger.mergeRosetta(getTradingObligation(), o.getTradingObligation(), this::setTradingObligation);
			merger.mergeRosetta(getCurrencyPairClassification(), o.getCurrencyPairClassification(), this::setCurrencyPairClassification);
			merger.mergeRosetta(getAdmissionToTrading(), o.getAdmissionToTrading(), this::setAdmissionToTrading);
			merger.mergeRosetta(getSeniority(), o.getSeniority(), this::setSeniority);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), (Consumer<String>) this::addSupervisoryBody);
			merger.mergeBasic(getIsCommodityHedge(), o.getIsCommodityHedge(), this::setIsCommodityHedge);
			merger.mergeBasic(getTransmissionOfOrder(), o.getTransmissionOfOrder(), this::setTransmissionOfOrder);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationMifirRTS23_2015 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!Objects.equals(tradingObligation, _that.getTradingObligation())) return false;
			if (!Objects.equals(isCommodityHedge, _that.getIsCommodityHedge())) return false;
			if (!Objects.equals(currencyPairClassification, _that.getCurrencyPairClassification())) return false;
			if (!Objects.equals(transmissionOfOrder, _that.getTransmissionOfOrder())) return false;
			if (!Objects.equals(admissionToTrading, _that.getAdmissionToTrading())) return false;
			if (!Objects.equals(seniority, _that.getSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (reportingRole != null ? reportingRole.hashCode() : 0);
			_result = 31 * _result + (reportingPurpose != null ? reportingPurpose.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (relatedPerson != null ? relatedPerson.hashCode() : 0);
			_result = 31 * _result + (tradingObligation != null ? tradingObligation.hashCode() : 0);
			_result = 31 * _result + (isCommodityHedge != null ? isCommodityHedge.hashCode() : 0);
			_result = 31 * _result + (currencyPairClassification != null ? currencyPairClassification.hashCode() : 0);
			_result = 31 * _result + (transmissionOfOrder != null ? transmissionOfOrder.hashCode() : 0);
			_result = 31 * _result + (admissionToTrading != null ? admissionToTrading.hashCode() : 0);
			_result = 31 * _result + (seniority != null ? seniority.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationMifirRTS23_2015Builder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"tradingObligation=" + this.tradingObligation + ", " +
				"isCommodityHedge=" + this.isCommodityHedge + ", " +
				"currencyPairClassification=" + this.currencyPairClassification + ", " +
				"transmissionOfOrder=" + this.transmissionOfOrder + ", " +
				"admissionToTrading=" + this.admissionToTrading + ", " +
				"seniority=" + this.seniority +
			'}' + " " + super.toString();
		}
	}
}
