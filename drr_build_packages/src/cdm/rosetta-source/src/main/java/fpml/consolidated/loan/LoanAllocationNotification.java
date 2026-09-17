package fpml.consolidated.loan;

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
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.LoanAllocationNotificationMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A loan servicing notification used to communicate trade allocation details, from counterparty to counterparty, or counterparty to admin agent.
 *
 */
@RosettaDataType(value="LoanAllocationNotification", builder=LoanAllocationNotification.LoanAllocationNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationNotification", model="fpml", builder=LoanAllocationNotification.LoanAllocationNotificationBuilderImpl.class, version="2.1.1")
public interface LoanAllocationNotification extends AbstractLoanAllocationNotification {

	LoanAllocationNotificationMeta metaData = new LoanAllocationNotificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanAllocationNotificationChoice0> getLoanAllocationNotificationChoice0();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanAllocationNotificationChoice1> getLoanAllocationNotificationChoice1();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Unique trade ids used to identify the trade record.
	 *
	 */
	TradeIdentifier getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A summary structure representing the loan trade.
	 *
	 */
	LoanTradeSummary getTradeSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal identifier structure.
	 *
	 */
	DealIdentifier getDealIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A deal summary structure.
	 *
	 */
	DealSummary getDealSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A facility identifier structure.
	 *
	 */
	FacilityIdentifier getFacilityIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A facility summary structure.
	 *
	 */
	FacilitySummary getFacilitySummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanAllocationNotificationChoice2> getLoanAllocationNotificationChoice2();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity.
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanAllocationNotification build();
	
	LoanAllocationNotification.LoanAllocationNotificationBuilder toBuilder();
	
	static LoanAllocationNotification.LoanAllocationNotificationBuilder builder() {
		return new LoanAllocationNotification.LoanAllocationNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationNotification> getType() {
		return LoanAllocationNotification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.class, getRole());
		processRosetta(path.newSubPath("payment"), processor, LoanAllocationPayment.class, getPayment());
		processRosetta(path.newSubPath("loanAllocationNotificationChoice0"), processor, LoanAllocationNotificationChoice0.class, getLoanAllocationNotificationChoice0());
		processRosetta(path.newSubPath("loanAllocationNotificationChoice1"), processor, LoanAllocationNotificationChoice1.class, getLoanAllocationNotificationChoice1());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
		processRosetta(path.newSubPath("loanAllocationNotificationChoice2"), processor, LoanAllocationNotificationChoice2.class, getLoanAllocationNotificationChoice2());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationNotificationBuilder extends LoanAllocationNotification, AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilder {
		LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder getOrCreateLoanAllocationNotificationChoice0(int index);
		@Override
		List<? extends LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder> getLoanAllocationNotificationChoice0();
		LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder getOrCreateLoanAllocationNotificationChoice1(int index);
		@Override
		List<? extends LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder> getLoanAllocationNotificationChoice1();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary();
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary();
		DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier();
		@Override
		DealIdentifier.DealIdentifierBuilder getDealIdentifier();
		DealSummary.DealSummaryBuilder getOrCreateDealSummary();
		@Override
		DealSummary.DealSummaryBuilder getDealSummary();
		FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier();
		@Override
		FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier();
		FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary();
		@Override
		FacilitySummary.FacilitySummaryBuilder getFacilitySummary();
		LoanAllocationNotificationChoice2.LoanAllocationNotificationChoice2Builder getOrCreateLoanAllocationNotificationChoice2(int index);
		@Override
		List<? extends LoanAllocationNotificationChoice2.LoanAllocationNotificationChoice2Builder> getLoanAllocationNotificationChoice2();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addValidation(Validation validation);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setRole(LoanTradingPartyRole role);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addPayment(LoanAllocationPayment payment);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addPayment(LoanAllocationPayment payment, int idx);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payment);
		@Override
		LoanAllocationNotification.LoanAllocationNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payment);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice0(LoanAllocationNotificationChoice0 loanAllocationNotificationChoice0);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice0(LoanAllocationNotificationChoice0 loanAllocationNotificationChoice0, int idx);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice0(List<? extends LoanAllocationNotificationChoice0> loanAllocationNotificationChoice0);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setLoanAllocationNotificationChoice0(List<? extends LoanAllocationNotificationChoice0> loanAllocationNotificationChoice0);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice1(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice1(LoanAllocationNotificationChoice1 loanAllocationNotificationChoice1, int idx);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice1(List<? extends LoanAllocationNotificationChoice1> loanAllocationNotificationChoice1);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setLoanAllocationNotificationChoice1(List<? extends LoanAllocationNotificationChoice1> loanAllocationNotificationChoice1);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setDealIdentifier(DealIdentifier dealIdentifier);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setDealSummary(DealSummary dealSummary);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setFacilitySummary(FacilitySummary facilitySummary);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice2(LoanAllocationNotificationChoice2 loanAllocationNotificationChoice2);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice2(LoanAllocationNotificationChoice2 loanAllocationNotificationChoice2, int idx);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice2(List<? extends LoanAllocationNotificationChoice2> loanAllocationNotificationChoice2);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setLoanAllocationNotificationChoice2(List<? extends LoanAllocationNotificationChoice2> loanAllocationNotificationChoice2);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(Party party);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(Party party, int idx);
		LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(List<? extends Party> party);
		LoanAllocationNotification.LoanAllocationNotificationBuilder setParty(List<? extends Party> party);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processor.processBasic(path.newSubPath("noticeDate"), ZonedDateTime.class, getNoticeDate(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("role"), processor, LoanTradingPartyRole.LoanTradingPartyRoleBuilder.class, getRole());
			processRosetta(path.newSubPath("payment"), processor, LoanAllocationPayment.LoanAllocationPaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("loanAllocationNotificationChoice0"), processor, LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder.class, getLoanAllocationNotificationChoice0());
			processRosetta(path.newSubPath("loanAllocationNotificationChoice1"), processor, LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder.class, getLoanAllocationNotificationChoice1());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
			processRosetta(path.newSubPath("loanAllocationNotificationChoice2"), processor, LoanAllocationNotificationChoice2.LoanAllocationNotificationChoice2Builder.class, getLoanAllocationNotificationChoice2());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanAllocationNotification.LoanAllocationNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationNotification  ***********************/
	class LoanAllocationNotificationImpl extends AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationImpl implements LoanAllocationNotification {
		private final List<? extends LoanAllocationNotificationChoice0> loanAllocationNotificationChoice0;
		private final List<? extends LoanAllocationNotificationChoice1> loanAllocationNotificationChoice1;
		private final TradeIdentifier tradeIdentifier;
		private final LoanTradeSummary tradeSummary;
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		private final List<? extends LoanAllocationNotificationChoice2> loanAllocationNotificationChoice2;
		private final List<? extends Party> party;
		
		protected LoanAllocationNotificationImpl(LoanAllocationNotification.LoanAllocationNotificationBuilder builder) {
			super(builder);
			this.loanAllocationNotificationChoice0 = ofNullable(builder.getLoanAllocationNotificationChoice0()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.loanAllocationNotificationChoice1 = ofNullable(builder.getLoanAllocationNotificationChoice1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
			this.loanAllocationNotificationChoice2 = ofNullable(builder.getLoanAllocationNotificationChoice2()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanAllocationNotificationChoice0")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice0")
		public List<? extends LoanAllocationNotificationChoice0> getLoanAllocationNotificationChoice0() {
			return loanAllocationNotificationChoice0;
		}
		
		@Override
		@RosettaAttribute("loanAllocationNotificationChoice1")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice1")
		public List<? extends LoanAllocationNotificationChoice1> getLoanAllocationNotificationChoice1() {
			return loanAllocationNotificationChoice1;
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public TradeIdentifier getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeSummary")
		public LoanTradeSummary getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealIdentifier")
		public DealIdentifier getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealSummary")
		public DealSummary getDealSummary() {
			return dealSummary;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityIdentifier")
		public FacilityIdentifier getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilitySummary")
		public FacilitySummary getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		@RosettaAttribute("loanAllocationNotificationChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice2")
		public List<? extends LoanAllocationNotificationChoice2> getLoanAllocationNotificationChoice2() {
			return loanAllocationNotificationChoice2;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanAllocationNotification build() {
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder toBuilder() {
			LoanAllocationNotification.LoanAllocationNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationNotification.LoanAllocationNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanAllocationNotificationChoice0()).ifPresent(builder::setLoanAllocationNotificationChoice0);
			ofNullable(getLoanAllocationNotificationChoice1()).ifPresent(builder::setLoanAllocationNotificationChoice1);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
			ofNullable(getLoanAllocationNotificationChoice2()).ifPresent(builder::setLoanAllocationNotificationChoice2);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanAllocationNotificationChoice0, _that.getLoanAllocationNotificationChoice0())) return false;
			if (!ListEquals.listEquals(loanAllocationNotificationChoice1, _that.getLoanAllocationNotificationChoice1())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(loanAllocationNotificationChoice2, _that.getLoanAllocationNotificationChoice2())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanAllocationNotificationChoice0 != null ? loanAllocationNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (loanAllocationNotificationChoice1 != null ? loanAllocationNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (loanAllocationNotificationChoice2 != null ? loanAllocationNotificationChoice2.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNotification {" +
				"loanAllocationNotificationChoice0=" + this.loanAllocationNotificationChoice0 + ", " +
				"loanAllocationNotificationChoice1=" + this.loanAllocationNotificationChoice1 + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"loanAllocationNotificationChoice2=" + this.loanAllocationNotificationChoice2 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationNotification  ***********************/
	class LoanAllocationNotificationBuilderImpl extends AbstractLoanAllocationNotification.AbstractLoanAllocationNotificationBuilderImpl implements LoanAllocationNotification.LoanAllocationNotificationBuilder {
	
		protected List<LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder> loanAllocationNotificationChoice0 = new ArrayList<>();
		protected List<LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder> loanAllocationNotificationChoice1 = new ArrayList<>();
		protected TradeIdentifier.TradeIdentifierBuilder tradeIdentifier;
		protected LoanTradeSummary.LoanTradeSummaryBuilder tradeSummary;
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
		protected List<LoanAllocationNotificationChoice2.LoanAllocationNotificationChoice2Builder> loanAllocationNotificationChoice2 = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("loanAllocationNotificationChoice0")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice0")
		public List<? extends LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder> getLoanAllocationNotificationChoice0() {
			return loanAllocationNotificationChoice0;
		}
		
		@Override
		public LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder getOrCreateLoanAllocationNotificationChoice0(int index) {
			if (loanAllocationNotificationChoice0==null) {
				this.loanAllocationNotificationChoice0 = new ArrayList<>();
			}
			return getIndex(loanAllocationNotificationChoice0, index, () -> {
						LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder newLoanAllocationNotificationChoice0 = LoanAllocationNotificationChoice0.builder();
						return newLoanAllocationNotificationChoice0;
					});
		}
		
		@Override
		@RosettaAttribute("loanAllocationNotificationChoice1")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice1")
		public List<? extends LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder> getLoanAllocationNotificationChoice1() {
			return loanAllocationNotificationChoice1;
		}
		
		@Override
		public LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder getOrCreateLoanAllocationNotificationChoice1(int index) {
			if (loanAllocationNotificationChoice1==null) {
				this.loanAllocationNotificationChoice1 = new ArrayList<>();
			}
			return getIndex(loanAllocationNotificationChoice1, index, () -> {
						LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder newLoanAllocationNotificationChoice1 = LoanAllocationNotificationChoice1.builder();
						return newLoanAllocationNotificationChoice1;
					});
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeIdentifier")
		public TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier() {
			TradeIdentifier.TradeIdentifierBuilder result;
			if (tradeIdentifier!=null) {
				result = tradeIdentifier;
			}
			else {
				result = tradeIdentifier = TradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeSummary")
		public LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary() {
			return tradeSummary;
		}
		
		@Override
		public LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary() {
			LoanTradeSummary.LoanTradeSummaryBuilder result;
			if (tradeSummary!=null) {
				result = tradeSummary;
			}
			else {
				result = tradeSummary = LoanTradeSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealIdentifier")
		public DealIdentifier.DealIdentifierBuilder getDealIdentifier() {
			return dealIdentifier;
		}
		
		@Override
		public DealIdentifier.DealIdentifierBuilder getOrCreateDealIdentifier() {
			DealIdentifier.DealIdentifierBuilder result;
			if (dealIdentifier!=null) {
				result = dealIdentifier;
			}
			else {
				result = dealIdentifier = DealIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dealSummary")
		public DealSummary.DealSummaryBuilder getDealSummary() {
			return dealSummary;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder getOrCreateDealSummary() {
			DealSummary.DealSummaryBuilder result;
			if (dealSummary!=null) {
				result = dealSummary;
			}
			else {
				result = dealSummary = DealSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilityIdentifier")
		public FacilityIdentifier.FacilityIdentifierBuilder getFacilityIdentifier() {
			return facilityIdentifier;
		}
		
		@Override
		public FacilityIdentifier.FacilityIdentifierBuilder getOrCreateFacilityIdentifier() {
			FacilityIdentifier.FacilityIdentifierBuilder result;
			if (facilityIdentifier!=null) {
				result = facilityIdentifier;
			}
			else {
				result = facilityIdentifier = FacilityIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("facilitySummary")
		public FacilitySummary.FacilitySummaryBuilder getFacilitySummary() {
			return facilitySummary;
		}
		
		@Override
		public FacilitySummary.FacilitySummaryBuilder getOrCreateFacilitySummary() {
			FacilitySummary.FacilitySummaryBuilder result;
			if (facilitySummary!=null) {
				result = facilitySummary;
			}
			else {
				result = facilitySummary = FacilitySummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loanAllocationNotificationChoice2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice2")
		public List<? extends LoanAllocationNotificationChoice2.LoanAllocationNotificationChoice2Builder> getLoanAllocationNotificationChoice2() {
			return loanAllocationNotificationChoice2;
		}
		
		@Override
		public LoanAllocationNotificationChoice2.LoanAllocationNotificationChoice2Builder getOrCreateLoanAllocationNotificationChoice2(int index) {
			if (loanAllocationNotificationChoice2==null) {
				this.loanAllocationNotificationChoice2 = new ArrayList<>();
			}
			return getIndex(loanAllocationNotificationChoice2, index, () -> {
						LoanAllocationNotificationChoice2.LoanAllocationNotificationChoice2Builder newLoanAllocationNotificationChoice2 = LoanAllocationNotificationChoice2.builder();
						return newLoanAllocationNotificationChoice2;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int index) {
			if (party==null) {
				this.party = new ArrayList<>();
			}
			return getIndex(party, index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (final Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCorrection")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds != null) {
				for (final CorrelationId toAdd : correlationIds) {
					this.correlationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds == null) {
				this.correlationId = new ArrayList<>();
			} else {
				this.correlationId = correlationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("noticeDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("noticeDate")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("role")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("role")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setRole(LoanTradingPartyRole _role) {
			this.role = _role == null ? null : _role.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addPayment(LoanAllocationPayment _payment) {
			if (_payment != null) {
				this.payment.add(_payment.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addPayment(LoanAllocationPayment _payment, int idx) {
			getIndex(this.payment, idx, () -> _payment.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addPayment(List<? extends LoanAllocationPayment> payments) {
			if (payments != null) {
				for (final LoanAllocationPayment toAdd : payments) {
					this.payment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setPayment(List<? extends LoanAllocationPayment> payments) {
			if (payments == null) {
				this.payment = new ArrayList<>();
			} else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanAllocationNotificationChoice0")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice0")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice0(LoanAllocationNotificationChoice0 _loanAllocationNotificationChoice0) {
			if (_loanAllocationNotificationChoice0 != null) {
				this.loanAllocationNotificationChoice0.add(_loanAllocationNotificationChoice0.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice0(LoanAllocationNotificationChoice0 _loanAllocationNotificationChoice0, int idx) {
			getIndex(this.loanAllocationNotificationChoice0, idx, () -> _loanAllocationNotificationChoice0.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice0(List<? extends LoanAllocationNotificationChoice0> loanAllocationNotificationChoice0s) {
			if (loanAllocationNotificationChoice0s != null) {
				for (final LoanAllocationNotificationChoice0 toAdd : loanAllocationNotificationChoice0s) {
					this.loanAllocationNotificationChoice0.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanAllocationNotificationChoice0")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice0")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setLoanAllocationNotificationChoice0(List<? extends LoanAllocationNotificationChoice0> loanAllocationNotificationChoice0s) {
			if (loanAllocationNotificationChoice0s == null) {
				this.loanAllocationNotificationChoice0 = new ArrayList<>();
			} else {
				this.loanAllocationNotificationChoice0 = loanAllocationNotificationChoice0s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanAllocationNotificationChoice1")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice1")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice1(LoanAllocationNotificationChoice1 _loanAllocationNotificationChoice1) {
			if (_loanAllocationNotificationChoice1 != null) {
				this.loanAllocationNotificationChoice1.add(_loanAllocationNotificationChoice1.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice1(LoanAllocationNotificationChoice1 _loanAllocationNotificationChoice1, int idx) {
			getIndex(this.loanAllocationNotificationChoice1, idx, () -> _loanAllocationNotificationChoice1.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice1(List<? extends LoanAllocationNotificationChoice1> loanAllocationNotificationChoice1s) {
			if (loanAllocationNotificationChoice1s != null) {
				for (final LoanAllocationNotificationChoice1 toAdd : loanAllocationNotificationChoice1s) {
					this.loanAllocationNotificationChoice1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanAllocationNotificationChoice1")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice1")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setLoanAllocationNotificationChoice1(List<? extends LoanAllocationNotificationChoice1> loanAllocationNotificationChoice1s) {
			if (loanAllocationNotificationChoice1s == null) {
				this.loanAllocationNotificationChoice1 = new ArrayList<>();
			} else {
				this.loanAllocationNotificationChoice1 = loanAllocationNotificationChoice1s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeIdentifier")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setTradeIdentifier(TradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeSummary")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setTradeSummary(LoanTradeSummary _tradeSummary) {
			this.tradeSummary = _tradeSummary == null ? null : _tradeSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityIdentifier")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilitySummary")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setFacilitySummary(FacilitySummary _facilitySummary) {
			this.facilitySummary = _facilitySummary == null ? null : _facilitySummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanAllocationNotificationChoice2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice2")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice2(LoanAllocationNotificationChoice2 _loanAllocationNotificationChoice2) {
			if (_loanAllocationNotificationChoice2 != null) {
				this.loanAllocationNotificationChoice2.add(_loanAllocationNotificationChoice2.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice2(LoanAllocationNotificationChoice2 _loanAllocationNotificationChoice2, int idx) {
			getIndex(this.loanAllocationNotificationChoice2, idx, () -> _loanAllocationNotificationChoice2.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addLoanAllocationNotificationChoice2(List<? extends LoanAllocationNotificationChoice2> loanAllocationNotificationChoice2s) {
			if (loanAllocationNotificationChoice2s != null) {
				for (final LoanAllocationNotificationChoice2 toAdd : loanAllocationNotificationChoice2s) {
					this.loanAllocationNotificationChoice2.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanAllocationNotificationChoice2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loanAllocationNotificationChoice2")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setLoanAllocationNotificationChoice2(List<? extends LoanAllocationNotificationChoice2> loanAllocationNotificationChoice2s) {
			if (loanAllocationNotificationChoice2s == null) {
				this.loanAllocationNotificationChoice2 = new ArrayList<>();
			} else {
				this.loanAllocationNotificationChoice2 = loanAllocationNotificationChoice2s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanAllocationNotification build() {
			return new LoanAllocationNotification.LoanAllocationNotificationImpl(this);
		}
		
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder prune() {
			super.prune();
			loanAllocationNotificationChoice0 = loanAllocationNotificationChoice0.stream().filter(b->b!=null).<LoanAllocationNotificationChoice0.LoanAllocationNotificationChoice0Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			loanAllocationNotificationChoice1 = loanAllocationNotificationChoice1.stream().filter(b->b!=null).<LoanAllocationNotificationChoice1.LoanAllocationNotificationChoice1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			loanAllocationNotificationChoice2 = loanAllocationNotificationChoice2.stream().filter(b->b!=null).<LoanAllocationNotificationChoice2.LoanAllocationNotificationChoice2Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanAllocationNotificationChoice0()!=null && getLoanAllocationNotificationChoice0().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLoanAllocationNotificationChoice1()!=null && getLoanAllocationNotificationChoice1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			if (getLoanAllocationNotificationChoice2()!=null && getLoanAllocationNotificationChoice2().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNotification.LoanAllocationNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationNotification.LoanAllocationNotificationBuilder o = (LoanAllocationNotification.LoanAllocationNotificationBuilder) other;
			
			merger.mergeRosetta(getLoanAllocationNotificationChoice0(), o.getLoanAllocationNotificationChoice0(), this::getOrCreateLoanAllocationNotificationChoice0);
			merger.mergeRosetta(getLoanAllocationNotificationChoice1(), o.getLoanAllocationNotificationChoice1(), this::getOrCreateLoanAllocationNotificationChoice1);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::setTradeSummary);
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			merger.mergeRosetta(getLoanAllocationNotificationChoice2(), o.getLoanAllocationNotificationChoice2(), this::getOrCreateLoanAllocationNotificationChoice2);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationNotification _that = getType().cast(o);
		
			if (!ListEquals.listEquals(loanAllocationNotificationChoice0, _that.getLoanAllocationNotificationChoice0())) return false;
			if (!ListEquals.listEquals(loanAllocationNotificationChoice1, _that.getLoanAllocationNotificationChoice1())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(loanAllocationNotificationChoice2, _that.getLoanAllocationNotificationChoice2())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanAllocationNotificationChoice0 != null ? loanAllocationNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (loanAllocationNotificationChoice1 != null ? loanAllocationNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (loanAllocationNotificationChoice2 != null ? loanAllocationNotificationChoice2.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNotificationBuilder {" +
				"loanAllocationNotificationChoice0=" + this.loanAllocationNotificationChoice0 + ", " +
				"loanAllocationNotificationChoice1=" + this.loanAllocationNotificationChoice1 + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"loanAllocationNotificationChoice2=" + this.loanAllocationNotificationChoice2 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
