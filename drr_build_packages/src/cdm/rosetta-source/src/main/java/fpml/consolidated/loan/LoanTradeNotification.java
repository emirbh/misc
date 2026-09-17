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
import fpml.consolidated.loan.meta.LoanTradeNotificationMeta;
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
 * Provision A loan servicing notification used to communicate details to establish a master trade, from counterparty to counterparty.
 *
 */
@RosettaDataType(value="LoanTradeNotification", builder=LoanTradeNotification.LoanTradeNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradeNotification", model="fpml", builder=LoanTradeNotification.LoanTradeNotificationBuilderImpl.class, version="2.1.1")
public interface LoanTradeNotification extends AbstractLoanTradeNotification {

	LoanTradeNotificationMeta metaData = new LoanTradeNotificationMeta();

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
	AbstractLoanTradeEvent getLoanTradeEventGroup();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	LoanTradeSettlementTask getSettlementTask();
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
	 * Provision A structure that defines all loan trade information i.e. this structure contains the main (e.g. fund manager/main counterparty) trade details.
	 *
	 */
	LoanTradeSummary getTradeSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure that defines party-to-party loan trade information. This structure contains the main (e.g. fund manager/main counterparty) trade details.
	 *
	 */
	LoanTradeType getTrade();
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
	 * Provision A legal entity or a subdivision of a legal entity.
	 *
	 */
	List<? extends Party> getParty();

	/*********************** Build Methods  ***********************/
	LoanTradeNotification build();
	
	LoanTradeNotification.LoanTradeNotificationBuilder toBuilder();
	
	static LoanTradeNotification.LoanTradeNotificationBuilder builder() {
		return new LoanTradeNotification.LoanTradeNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradeNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradeNotification> getType() {
		return LoanTradeNotification.class;
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
		processRosetta(path.newSubPath("payment"), processor, LoanTradePayment.class, getPayment());
		processRosetta(path.newSubPath("loanTradeEventGroup"), processor, AbstractLoanTradeEvent.class, getLoanTradeEventGroup());
		processRosetta(path.newSubPath("settlementTask"), processor, LoanTradeSettlementTask.class, getSettlementTask());
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.class, getTradeSummary());
		processRosetta(path.newSubPath("trade"), processor, LoanTradeType.class, getTrade());
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradeNotificationBuilder extends LoanTradeNotification, AbstractLoanTradeNotification.AbstractLoanTradeNotificationBuilder {
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder getOrCreateLoanTradeEventGroup();
		@Override
		AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder getLoanTradeEventGroup();
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder getOrCreateSettlementTask();
		@Override
		LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder getSettlementTask();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier();
		@Override
		TradeIdentifier.TradeIdentifierBuilder getTradeIdentifier();
		LoanTradeSummary.LoanTradeSummaryBuilder getOrCreateTradeSummary();
		@Override
		LoanTradeSummary.LoanTradeSummaryBuilder getTradeSummary();
		LoanTradeType.LoanTradeTypeBuilder getOrCreateTrade();
		@Override
		LoanTradeType.LoanTradeTypeBuilder getTrade();
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
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addValidation(Validation validation);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setPartyReference(PartyReference partyReference);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setRole(LoanTradingPartyRole role);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addPayment(LoanTradePayment payment);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addPayment(LoanTradePayment payment, int idx);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder addPayment(List<? extends LoanTradePayment> payment);
		@Override
		LoanTradeNotification.LoanTradeNotificationBuilder setPayment(List<? extends LoanTradePayment> payment);
		LoanTradeNotification.LoanTradeNotificationBuilder setLoanTradeEventGroup(AbstractLoanTradeEvent loanTradeEventGroup);
		LoanTradeNotification.LoanTradeNotificationBuilder setSettlementTask(LoanTradeSettlementTask settlementTask);
		LoanTradeNotification.LoanTradeNotificationBuilder setTradeIdentifier(TradeIdentifier tradeIdentifier);
		LoanTradeNotification.LoanTradeNotificationBuilder setTradeSummary(LoanTradeSummary tradeSummary);
		LoanTradeNotification.LoanTradeNotificationBuilder setTrade(LoanTradeType trade);
		LoanTradeNotification.LoanTradeNotificationBuilder setDealIdentifier(DealIdentifier dealIdentifier);
		LoanTradeNotification.LoanTradeNotificationBuilder setDealSummary(DealSummary dealSummary);
		LoanTradeNotification.LoanTradeNotificationBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		LoanTradeNotification.LoanTradeNotificationBuilder setFacilitySummary(FacilitySummary facilitySummary);
		LoanTradeNotification.LoanTradeNotificationBuilder addParty(Party party);
		LoanTradeNotification.LoanTradeNotificationBuilder addParty(Party party, int idx);
		LoanTradeNotification.LoanTradeNotificationBuilder addParty(List<? extends Party> party);
		LoanTradeNotification.LoanTradeNotificationBuilder setParty(List<? extends Party> party);

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
			processRosetta(path.newSubPath("payment"), processor, LoanTradePayment.LoanTradePaymentBuilder.class, getPayment());
			processRosetta(path.newSubPath("loanTradeEventGroup"), processor, AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder.class, getLoanTradeEventGroup());
			processRosetta(path.newSubPath("settlementTask"), processor, LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder.class, getSettlementTask());
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("tradeSummary"), processor, LoanTradeSummary.LoanTradeSummaryBuilder.class, getTradeSummary());
			processRosetta(path.newSubPath("trade"), processor, LoanTradeType.LoanTradeTypeBuilder.class, getTrade());
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanTradeNotification.LoanTradeNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradeNotification  ***********************/
	class LoanTradeNotificationImpl extends AbstractLoanTradeNotification.AbstractLoanTradeNotificationImpl implements LoanTradeNotification {
		private final AbstractLoanTradeEvent loanTradeEventGroup;
		private final LoanTradeSettlementTask settlementTask;
		private final TradeIdentifier tradeIdentifier;
		private final LoanTradeSummary tradeSummary;
		private final LoanTradeType trade;
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		private final List<? extends Party> party;
		
		protected LoanTradeNotificationImpl(LoanTradeNotification.LoanTradeNotificationBuilder builder) {
			super(builder);
			this.loanTradeEventGroup = ofNullable(builder.getLoanTradeEventGroup()).map(f->f.build()).orElse(null);
			this.settlementTask = ofNullable(builder.getSettlementTask()).map(f->f.build()).orElse(null);
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).map(f->f.build()).orElse(null);
			this.tradeSummary = ofNullable(builder.getTradeSummary()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanTradeEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanTradeEventGroup")
		public AbstractLoanTradeEvent getLoanTradeEventGroup() {
			return loanTradeEventGroup;
		}
		
		@Override
		@RosettaAttribute("settlementTask")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementTask")
		public LoanTradeSettlementTask getSettlementTask() {
			return settlementTask;
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
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public LoanTradeType getTrade() {
			return trade;
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
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		public LoanTradeNotification build() {
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder toBuilder() {
			LoanTradeNotification.LoanTradeNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradeNotification.LoanTradeNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanTradeEventGroup()).ifPresent(builder::setLoanTradeEventGroup);
			ofNullable(getSettlementTask()).ifPresent(builder::setSettlementTask);
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getTradeSummary()).ifPresent(builder::setTradeSummary);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeNotification _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeEventGroup, _that.getLoanTradeEventGroup())) return false;
			if (!Objects.equals(settlementTask, _that.getSettlementTask())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeEventGroup != null ? loanTradeEventGroup.hashCode() : 0);
			_result = 31 * _result + (settlementTask != null ? settlementTask.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeNotification {" +
				"loanTradeEventGroup=" + this.loanTradeEventGroup + ", " +
				"settlementTask=" + this.settlementTask + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"trade=" + this.trade + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanTradeNotification  ***********************/
	class LoanTradeNotificationBuilderImpl extends AbstractLoanTradeNotification.AbstractLoanTradeNotificationBuilderImpl implements LoanTradeNotification.LoanTradeNotificationBuilder {
	
		protected AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder loanTradeEventGroup;
		protected LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder settlementTask;
		protected TradeIdentifier.TradeIdentifierBuilder tradeIdentifier;
		protected LoanTradeSummary.LoanTradeSummaryBuilder tradeSummary;
		protected LoanTradeType.LoanTradeTypeBuilder trade;
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("loanTradeEventGroup")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanTradeEventGroup")
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder getLoanTradeEventGroup() {
			return loanTradeEventGroup;
		}
		
		@Override
		public AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder getOrCreateLoanTradeEventGroup() {
			AbstractLoanTradeEvent.AbstractLoanTradeEventBuilder result;
			if (loanTradeEventGroup!=null) {
				result = loanTradeEventGroup;
			}
			else {
				result = loanTradeEventGroup = AbstractLoanTradeEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementTask")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementTask")
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder getSettlementTask() {
			return settlementTask;
		}
		
		@Override
		public LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder getOrCreateSettlementTask() {
			LoanTradeSettlementTask.LoanTradeSettlementTaskBuilder result;
			if (settlementTask!=null) {
				result = settlementTask;
			}
			else {
				result = settlementTask = LoanTradeSettlementTask.builder();
			}
			
			return result;
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
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public LoanTradeType.LoanTradeTypeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public LoanTradeType.LoanTradeTypeBuilder getOrCreateTrade() {
			LoanTradeType.LoanTradeTypeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = LoanTradeType.builder();
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("role")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("role")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setRole(LoanTradingPartyRole _role) {
			this.role = _role == null ? null : _role.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("payment")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addPayment(LoanTradePayment _payment) {
			if (_payment != null) {
				this.payment.add(_payment.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addPayment(LoanTradePayment _payment, int idx) {
			getIndex(this.payment, idx, () -> _payment.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addPayment(List<? extends LoanTradePayment> payments) {
			if (payments != null) {
				for (final LoanTradePayment toAdd : payments) {
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setPayment(List<? extends LoanTradePayment> payments) {
			if (payments == null) {
				this.payment = new ArrayList<>();
			} else {
				this.payment = payments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanTradeEventGroup")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanTradeEventGroup")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setLoanTradeEventGroup(AbstractLoanTradeEvent _loanTradeEventGroup) {
			this.loanTradeEventGroup = _loanTradeEventGroup == null ? null : _loanTradeEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementTask")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementTask")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setSettlementTask(LoanTradeSettlementTask _settlementTask) {
			this.settlementTask = _settlementTask == null ? null : _settlementTask.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeIdentifier")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setTradeIdentifier(TradeIdentifier _tradeIdentifier) {
			this.tradeIdentifier = _tradeIdentifier == null ? null : _tradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeSummary")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setTradeSummary(LoanTradeSummary _tradeSummary) {
			this.tradeSummary = _tradeSummary == null ? null : _tradeSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setTrade(LoanTradeType _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityIdentifier")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilitySummary")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder setFacilitySummary(FacilitySummary _facilitySummary) {
			this.facilitySummary = _facilitySummary == null ? null : _facilitySummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder addParty(List<? extends Party> partys) {
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
		public LoanTradeNotification.LoanTradeNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanTradeNotification build() {
			return new LoanTradeNotification.LoanTradeNotificationImpl(this);
		}
		
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder prune() {
			super.prune();
			if (loanTradeEventGroup!=null && !loanTradeEventGroup.prune().hasData()) loanTradeEventGroup = null;
			if (settlementTask!=null && !settlementTask.prune().hasData()) settlementTask = null;
			if (tradeIdentifier!=null && !tradeIdentifier.prune().hasData()) tradeIdentifier = null;
			if (tradeSummary!=null && !tradeSummary.prune().hasData()) tradeSummary = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanTradeEventGroup()!=null && getLoanTradeEventGroup().hasData()) return true;
			if (getSettlementTask()!=null && getSettlementTask().hasData()) return true;
			if (getTradeIdentifier()!=null && getTradeIdentifier().hasData()) return true;
			if (getTradeSummary()!=null && getTradeSummary().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradeNotification.LoanTradeNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanTradeNotification.LoanTradeNotificationBuilder o = (LoanTradeNotification.LoanTradeNotificationBuilder) other;
			
			merger.mergeRosetta(getLoanTradeEventGroup(), o.getLoanTradeEventGroup(), this::setLoanTradeEventGroup);
			merger.mergeRosetta(getSettlementTask(), o.getSettlementTask(), this::setSettlementTask);
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::setTradeIdentifier);
			merger.mergeRosetta(getTradeSummary(), o.getTradeSummary(), this::setTradeSummary);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanTradeNotification _that = getType().cast(o);
		
			if (!Objects.equals(loanTradeEventGroup, _that.getLoanTradeEventGroup())) return false;
			if (!Objects.equals(settlementTask, _that.getSettlementTask())) return false;
			if (!Objects.equals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(tradeSummary, _that.getTradeSummary())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanTradeEventGroup != null ? loanTradeEventGroup.hashCode() : 0);
			_result = 31 * _result + (settlementTask != null ? settlementTask.hashCode() : 0);
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeSummary != null ? tradeSummary.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradeNotificationBuilder {" +
				"loanTradeEventGroup=" + this.loanTradeEventGroup + ", " +
				"settlementTask=" + this.settlementTask + ", " +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"tradeSummary=" + this.tradeSummary + ", " +
				"trade=" + this.trade + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
