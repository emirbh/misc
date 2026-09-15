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
import fpml.consolidated.doc.OtcClassification;
import fpml.consolidated.doc.ReportingPurpose;
import fpml.consolidated.doc.ReportingRole;
import fpml.consolidated.doc.ShortSale;
import fpml.consolidated.doc.TradingWaiver;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryClassificationMifirRTS24_2015Meta;
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
@RosettaDataType(value="RegulatoryClassificationMifirRTS24_2015", builder=RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015BuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryClassificationMifirRTS24_2015", model="fpml", builder=RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015BuilderImpl.class, version="2.1.1")
public interface RegulatoryClassificationMifirRTS24_2015 extends RegulatoryClassification {

	RegulatoryClassificationMifirRTS24_2015Meta metaData = new RegulatoryClassificationMifirRTS24_2015Meta();

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
	 * Provision Whether the transaction falls within the scope of activity but is exempted from reporting under [Securities Financing Transactions Regulation]
	 *
	 */
	Boolean getIsSecuritiesFinancing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Classification of the OTC transaction. Note: Coding scheme definition to encapsulate: Articles 20(3)(a) and 21(5)(a) of Regulation (EU) 600/2014. e.g. default="http://www.fpml.org/coding-scheme/esma-mifir-otc-classification"
	 *
	 */
	List<? extends OtcClassification> getOtcClassification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Classification of the pre-trade waiver, if any, that the transaction was executed under. Note: Coding scheme to encapsulate: Articles 4 and 9 of Regulation (EU) 600/2014. e.g. default="http://www.fpml.org/coding-scheme/esma-mifir-trading-waiver"
	 *
	 */
	List<? extends TradingWaiver> getTradingWaiver();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Classification of the transaction as a short sale or not and, if short, of the type of transaction. Note: Coding scheme to encapsulate: Article 11 of Regulation (EU) 600/2014. e.g. default="http://www.fpml.org/coding-scheme/esma-mifir-short-sale"
	 *
	 */
	ShortSale getShortSale();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the transaction reduces risk in an objectively measurable way. Only applicable for commodity derivative transactions.
	 *
	 */
	Boolean getIsCommodityHedge();

	/*********************** Build Methods  ***********************/
	RegulatoryClassificationMifirRTS24_2015 build();
	
	RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder toBuilder();
	
	static RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder builder() {
		return new RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryClassificationMifirRTS24_2015> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryClassificationMifirRTS24_2015> getType() {
		return RegulatoryClassificationMifirRTS24_2015.class;
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
		processor.processBasic(path.newSubPath("isSecuritiesFinancing"), Boolean.class, getIsSecuritiesFinancing(), this);
		processRosetta(path.newSubPath("otcClassification"), processor, OtcClassification.class, getOtcClassification());
		processRosetta(path.newSubPath("tradingWaiver"), processor, TradingWaiver.class, getTradingWaiver());
		processRosetta(path.newSubPath("shortSale"), processor, ShortSale.class, getShortSale());
		processor.processBasic(path.newSubPath("isCommodityHedge"), Boolean.class, getIsCommodityHedge(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryClassificationMifirRTS24_2015Builder extends RegulatoryClassificationMifirRTS24_2015, RegulatoryClassification.RegulatoryClassificationBuilder {
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
		OtcClassification.OtcClassificationBuilder getOrCreateOtcClassification(int index);
		@Override
		List<? extends OtcClassification.OtcClassificationBuilder> getOtcClassification();
		TradingWaiver.TradingWaiverBuilder getOrCreateTradingWaiver(int index);
		@Override
		List<? extends TradingWaiver.TradingWaiverBuilder> getTradingWaiver();
		ShortSale.ShortSaleBuilder getOrCreateShortSale();
		@Override
		ShortSale.ShortSaleBuilder getShortSale();
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addSupervisoryBody(String supervisoryBody);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addSupervisoryBody(String supervisoryBody, int idx);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setSupervisoryBody(List<String> supervisoryBody);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setReportingRole(ReportingRole reportingRole);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addReportingPurpose(ReportingPurpose reportingPurpose);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addReportingPurpose(ReportingPurpose reportingPurpose, int idx);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurpose);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setBuyerPartyReference(PartyReference buyerPartyReference);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setSellerPartyReference(PartyReference sellerPartyReference);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedParty(RelatedParty relatedParty);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedParty(RelatedParty relatedParty, int idx);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedParty(List<? extends RelatedParty> relatedParty);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setRelatedParty(List<? extends RelatedParty> relatedParty);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedPerson(RelatedPerson relatedPerson);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedPerson(RelatedPerson relatedPerson, int idx);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedPerson(List<? extends RelatedPerson> relatedPerson);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setRelatedPerson(List<? extends RelatedPerson> relatedPerson);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setTradingObligation(RegulatoryTradingObligation tradingObligation);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setIsSecuritiesFinancing(Boolean isSecuritiesFinancing);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addOtcClassification(OtcClassification otcClassification);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addOtcClassification(OtcClassification otcClassification, int idx);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addOtcClassification(List<? extends OtcClassification> otcClassification);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setOtcClassification(List<? extends OtcClassification> otcClassification);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addTradingWaiver(TradingWaiver tradingWaiver);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addTradingWaiver(TradingWaiver tradingWaiver, int idx);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addTradingWaiver(List<? extends TradingWaiver> tradingWaiver);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setTradingWaiver(List<? extends TradingWaiver> tradingWaiver);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setShortSale(ShortSale shortSale);
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setIsCommodityHedge(Boolean isCommodityHedge);

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
			processor.processBasic(path.newSubPath("isSecuritiesFinancing"), Boolean.class, getIsSecuritiesFinancing(), this);
			processRosetta(path.newSubPath("otcClassification"), processor, OtcClassification.OtcClassificationBuilder.class, getOtcClassification());
			processRosetta(path.newSubPath("tradingWaiver"), processor, TradingWaiver.TradingWaiverBuilder.class, getTradingWaiver());
			processRosetta(path.newSubPath("shortSale"), processor, ShortSale.ShortSaleBuilder.class, getShortSale());
			processor.processBasic(path.newSubPath("isCommodityHedge"), Boolean.class, getIsCommodityHedge(), this);
		}
		

		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder prune();
	}

	/*********************** Immutable Implementation of RegulatoryClassificationMifirRTS24_2015  ***********************/
	class RegulatoryClassificationMifirRTS24_2015Impl extends RegulatoryClassification.RegulatoryClassificationImpl implements RegulatoryClassificationMifirRTS24_2015 {
		private final List<String> supervisoryBody;
		private final ReportingRole reportingRole;
		private final List<? extends ReportingPurpose> reportingPurpose;
		private final PartyReference buyerPartyReference;
		private final PartyReference sellerPartyReference;
		private final List<? extends RelatedParty> relatedParty;
		private final List<? extends RelatedPerson> relatedPerson;
		private final RegulatoryTradingObligation tradingObligation;
		private final Boolean isSecuritiesFinancing;
		private final List<? extends OtcClassification> otcClassification;
		private final List<? extends TradingWaiver> tradingWaiver;
		private final ShortSale shortSale;
		private final Boolean isCommodityHedge;
		
		protected RegulatoryClassificationMifirRTS24_2015Impl(RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder builder) {
			super(builder);
			this.supervisoryBody = ofNullable(builder.getSupervisoryBody()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.reportingRole = ofNullable(builder.getReportingRole()).map(f->f.build()).orElse(null);
			this.reportingPurpose = ofNullable(builder.getReportingPurpose()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.relatedPerson = ofNullable(builder.getRelatedPerson()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradingObligation = ofNullable(builder.getTradingObligation()).map(f->f.build()).orElse(null);
			this.isSecuritiesFinancing = builder.getIsSecuritiesFinancing();
			this.otcClassification = ofNullable(builder.getOtcClassification()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradingWaiver = ofNullable(builder.getTradingWaiver()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.shortSale = ofNullable(builder.getShortSale()).map(f->f.build()).orElse(null);
			this.isCommodityHedge = builder.getIsCommodityHedge();
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
		@RosettaAttribute("isSecuritiesFinancing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isSecuritiesFinancing")
		public Boolean getIsSecuritiesFinancing() {
			return isSecuritiesFinancing;
		}
		
		@Override
		@RosettaAttribute("otcClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otcClassification")
		public List<? extends OtcClassification> getOtcClassification() {
			return otcClassification;
		}
		
		@Override
		@RosettaAttribute("tradingWaiver")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradingWaiver")
		public List<? extends TradingWaiver> getTradingWaiver() {
			return tradingWaiver;
		}
		
		@Override
		@RosettaAttribute("shortSale")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shortSale")
		public ShortSale getShortSale() {
			return shortSale;
		}
		
		@Override
		@RosettaAttribute("isCommodityHedge")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isCommodityHedge")
		public Boolean getIsCommodityHedge() {
			return isCommodityHedge;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015 build() {
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder toBuilder() {
			RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getReportingRole()).ifPresent(builder::setReportingRole);
			ofNullable(getReportingPurpose()).ifPresent(builder::setReportingPurpose);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getRelatedPerson()).ifPresent(builder::setRelatedPerson);
			ofNullable(getTradingObligation()).ifPresent(builder::setTradingObligation);
			ofNullable(getIsSecuritiesFinancing()).ifPresent(builder::setIsSecuritiesFinancing);
			ofNullable(getOtcClassification()).ifPresent(builder::setOtcClassification);
			ofNullable(getTradingWaiver()).ifPresent(builder::setTradingWaiver);
			ofNullable(getShortSale()).ifPresent(builder::setShortSale);
			ofNullable(getIsCommodityHedge()).ifPresent(builder::setIsCommodityHedge);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationMifirRTS24_2015 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!Objects.equals(tradingObligation, _that.getTradingObligation())) return false;
			if (!Objects.equals(isSecuritiesFinancing, _that.getIsSecuritiesFinancing())) return false;
			if (!ListEquals.listEquals(otcClassification, _that.getOtcClassification())) return false;
			if (!ListEquals.listEquals(tradingWaiver, _that.getTradingWaiver())) return false;
			if (!Objects.equals(shortSale, _that.getShortSale())) return false;
			if (!Objects.equals(isCommodityHedge, _that.getIsCommodityHedge())) return false;
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
			_result = 31 * _result + (isSecuritiesFinancing != null ? isSecuritiesFinancing.hashCode() : 0);
			_result = 31 * _result + (otcClassification != null ? otcClassification.hashCode() : 0);
			_result = 31 * _result + (tradingWaiver != null ? tradingWaiver.hashCode() : 0);
			_result = 31 * _result + (shortSale != null ? shortSale.hashCode() : 0);
			_result = 31 * _result + (isCommodityHedge != null ? isCommodityHedge.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationMifirRTS24_2015 {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"tradingObligation=" + this.tradingObligation + ", " +
				"isSecuritiesFinancing=" + this.isSecuritiesFinancing + ", " +
				"otcClassification=" + this.otcClassification + ", " +
				"tradingWaiver=" + this.tradingWaiver + ", " +
				"shortSale=" + this.shortSale + ", " +
				"isCommodityHedge=" + this.isCommodityHedge +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryClassificationMifirRTS24_2015  ***********************/
	class RegulatoryClassificationMifirRTS24_2015BuilderImpl extends RegulatoryClassification.RegulatoryClassificationBuilderImpl implements RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder {
	
		protected List<String> supervisoryBody = new ArrayList<>();
		protected ReportingRole.ReportingRoleBuilder reportingRole;
		protected List<ReportingPurpose.ReportingPurposeBuilder> reportingPurpose = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected List<RelatedPerson.RelatedPersonBuilder> relatedPerson = new ArrayList<>();
		protected RegulatoryTradingObligation.RegulatoryTradingObligationBuilder tradingObligation;
		protected Boolean isSecuritiesFinancing;
		protected List<OtcClassification.OtcClassificationBuilder> otcClassification = new ArrayList<>();
		protected List<TradingWaiver.TradingWaiverBuilder> tradingWaiver = new ArrayList<>();
		protected ShortSale.ShortSaleBuilder shortSale;
		protected Boolean isCommodityHedge;
		
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
		@RosettaAttribute("isSecuritiesFinancing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isSecuritiesFinancing")
		public Boolean getIsSecuritiesFinancing() {
			return isSecuritiesFinancing;
		}
		
		@Override
		@RosettaAttribute("otcClassification")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otcClassification")
		public List<? extends OtcClassification.OtcClassificationBuilder> getOtcClassification() {
			return otcClassification;
		}
		
		@Override
		public OtcClassification.OtcClassificationBuilder getOrCreateOtcClassification(int index) {
			if (otcClassification==null) {
				this.otcClassification = new ArrayList<>();
			}
			return getIndex(otcClassification, index, () -> {
						OtcClassification.OtcClassificationBuilder newOtcClassification = OtcClassification.builder();
						return newOtcClassification;
					});
		}
		
		@Override
		@RosettaAttribute("tradingWaiver")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradingWaiver")
		public List<? extends TradingWaiver.TradingWaiverBuilder> getTradingWaiver() {
			return tradingWaiver;
		}
		
		@Override
		public TradingWaiver.TradingWaiverBuilder getOrCreateTradingWaiver(int index) {
			if (tradingWaiver==null) {
				this.tradingWaiver = new ArrayList<>();
			}
			return getIndex(tradingWaiver, index, () -> {
						TradingWaiver.TradingWaiverBuilder newTradingWaiver = TradingWaiver.builder();
						return newTradingWaiver;
					});
		}
		
		@Override
		@RosettaAttribute("shortSale")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("shortSale")
		public ShortSale.ShortSaleBuilder getShortSale() {
			return shortSale;
		}
		
		@Override
		public ShortSale.ShortSaleBuilder getOrCreateShortSale() {
			ShortSale.ShortSaleBuilder result;
			if (shortSale!=null) {
				result = shortSale;
			}
			else {
				result = shortSale = ShortSale.builder();
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
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("supervisoryBody")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addSupervisoryBody(String _supervisoryBody) {
			if (_supervisoryBody != null) {
				this.supervisoryBody.add(_supervisoryBody);
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addSupervisoryBody(String _supervisoryBody, int idx) {
			getIndex(this.supervisoryBody, idx, () -> _supervisoryBody);
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setSupervisoryBody(List<String> supervisoryBodys) {
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
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setReportingRole(ReportingRole _reportingRole) {
			this.reportingRole = _reportingRole == null ? null : _reportingRole.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportingPurpose")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingPurpose")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addReportingPurpose(ReportingPurpose _reportingPurpose) {
			if (_reportingPurpose != null) {
				this.reportingPurpose.add(_reportingPurpose.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addReportingPurpose(ReportingPurpose _reportingPurpose, int idx) {
			getIndex(this.reportingPurpose, idx, () -> _reportingPurpose.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setReportingPurpose(List<? extends ReportingPurpose> reportingPurposes) {
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
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerPartyReference")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedPerson(RelatedPerson _relatedPerson) {
			if (_relatedPerson != null) {
				this.relatedPerson.add(_relatedPerson.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedPerson(RelatedPerson _relatedPerson, int idx) {
			getIndex(this.relatedPerson, idx, () -> _relatedPerson.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addRelatedPerson(List<? extends RelatedPerson> relatedPersons) {
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
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setRelatedPerson(List<? extends RelatedPerson> relatedPersons) {
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
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setTradingObligation(RegulatoryTradingObligation _tradingObligation) {
			this.tradingObligation = _tradingObligation == null ? null : _tradingObligation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isSecuritiesFinancing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isSecuritiesFinancing")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setIsSecuritiesFinancing(Boolean _isSecuritiesFinancing) {
			this.isSecuritiesFinancing = _isSecuritiesFinancing == null ? null : _isSecuritiesFinancing;
			return this;
		}
		
		@RosettaAttribute("otcClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otcClassification")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addOtcClassification(OtcClassification _otcClassification) {
			if (_otcClassification != null) {
				this.otcClassification.add(_otcClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addOtcClassification(OtcClassification _otcClassification, int idx) {
			getIndex(this.otcClassification, idx, () -> _otcClassification.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addOtcClassification(List<? extends OtcClassification> otcClassifications) {
			if (otcClassifications != null) {
				for (final OtcClassification toAdd : otcClassifications) {
					this.otcClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("otcClassification")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otcClassification")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setOtcClassification(List<? extends OtcClassification> otcClassifications) {
			if (otcClassifications == null) {
				this.otcClassification = new ArrayList<>();
			} else {
				this.otcClassification = otcClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradingWaiver")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradingWaiver")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addTradingWaiver(TradingWaiver _tradingWaiver) {
			if (_tradingWaiver != null) {
				this.tradingWaiver.add(_tradingWaiver.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addTradingWaiver(TradingWaiver _tradingWaiver, int idx) {
			getIndex(this.tradingWaiver, idx, () -> _tradingWaiver.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder addTradingWaiver(List<? extends TradingWaiver> tradingWaivers) {
			if (tradingWaivers != null) {
				for (final TradingWaiver toAdd : tradingWaivers) {
					this.tradingWaiver.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradingWaiver")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradingWaiver")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setTradingWaiver(List<? extends TradingWaiver> tradingWaivers) {
			if (tradingWaivers == null) {
				this.tradingWaiver = new ArrayList<>();
			} else {
				this.tradingWaiver = tradingWaivers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("shortSale")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("shortSale")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setShortSale(ShortSale _shortSale) {
			this.shortSale = _shortSale == null ? null : _shortSale.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isCommodityHedge")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCommodityHedge")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder setIsCommodityHedge(Boolean _isCommodityHedge) {
			this.isCommodityHedge = _isCommodityHedge == null ? null : _isCommodityHedge;
			return this;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015 build() {
			return new RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Impl(this);
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder prune() {
			super.prune();
			if (reportingRole!=null && !reportingRole.prune().hasData()) reportingRole = null;
			reportingPurpose = reportingPurpose.stream().filter(b->b!=null).<ReportingPurpose.ReportingPurposeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			relatedPerson = relatedPerson.stream().filter(b->b!=null).<RelatedPerson.RelatedPersonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradingObligation!=null && !tradingObligation.prune().hasData()) tradingObligation = null;
			otcClassification = otcClassification.stream().filter(b->b!=null).<OtcClassification.OtcClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradingWaiver = tradingWaiver.stream().filter(b->b!=null).<TradingWaiver.TradingWaiverBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (shortSale!=null && !shortSale.prune().hasData()) shortSale = null;
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
			if (getIsSecuritiesFinancing()!=null) return true;
			if (getOtcClassification()!=null && getOtcClassification().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradingWaiver()!=null && getTradingWaiver().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getShortSale()!=null && getShortSale().hasData()) return true;
			if (getIsCommodityHedge()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder o = (RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder) other;
			
			merger.mergeRosetta(getReportingRole(), o.getReportingRole(), this::setReportingRole);
			merger.mergeRosetta(getReportingPurpose(), o.getReportingPurpose(), this::getOrCreateReportingPurpose);
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getRelatedPerson(), o.getRelatedPerson(), this::getOrCreateRelatedPerson);
			merger.mergeRosetta(getTradingObligation(), o.getTradingObligation(), this::setTradingObligation);
			merger.mergeRosetta(getOtcClassification(), o.getOtcClassification(), this::getOrCreateOtcClassification);
			merger.mergeRosetta(getTradingWaiver(), o.getTradingWaiver(), this::getOrCreateTradingWaiver);
			merger.mergeRosetta(getShortSale(), o.getShortSale(), this::setShortSale);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), (Consumer<String>) this::addSupervisoryBody);
			merger.mergeBasic(getIsSecuritiesFinancing(), o.getIsSecuritiesFinancing(), this::setIsSecuritiesFinancing);
			merger.mergeBasic(getIsCommodityHedge(), o.getIsCommodityHedge(), this::setIsCommodityHedge);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryClassificationMifirRTS24_2015 _that = getType().cast(o);
		
			if (!ListEquals.listEquals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!Objects.equals(reportingRole, _that.getReportingRole())) return false;
			if (!ListEquals.listEquals(reportingPurpose, _that.getReportingPurpose())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(relatedPerson, _that.getRelatedPerson())) return false;
			if (!Objects.equals(tradingObligation, _that.getTradingObligation())) return false;
			if (!Objects.equals(isSecuritiesFinancing, _that.getIsSecuritiesFinancing())) return false;
			if (!ListEquals.listEquals(otcClassification, _that.getOtcClassification())) return false;
			if (!ListEquals.listEquals(tradingWaiver, _that.getTradingWaiver())) return false;
			if (!Objects.equals(shortSale, _that.getShortSale())) return false;
			if (!Objects.equals(isCommodityHedge, _that.getIsCommodityHedge())) return false;
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
			_result = 31 * _result + (isSecuritiesFinancing != null ? isSecuritiesFinancing.hashCode() : 0);
			_result = 31 * _result + (otcClassification != null ? otcClassification.hashCode() : 0);
			_result = 31 * _result + (tradingWaiver != null ? tradingWaiver.hashCode() : 0);
			_result = 31 * _result + (shortSale != null ? shortSale.hashCode() : 0);
			_result = 31 * _result + (isCommodityHedge != null ? isCommodityHedge.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryClassificationMifirRTS24_2015Builder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"reportingRole=" + this.reportingRole + ", " +
				"reportingPurpose=" + this.reportingPurpose + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"relatedPerson=" + this.relatedPerson + ", " +
				"tradingObligation=" + this.tradingObligation + ", " +
				"isSecuritiesFinancing=" + this.isSecuritiesFinancing + ", " +
				"otcClassification=" + this.otcClassification + ", " +
				"tradingWaiver=" + this.tradingWaiver + ", " +
				"shortSale=" + this.shortSale + ", " +
				"isCommodityHedge=" + this.isCommodityHedge +
			'}' + " " + super.toString();
		}
	}
}
