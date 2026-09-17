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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.meta.LoanContractNotificationMeta;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
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
 * Provision A loan servicing notification used to communicate various loan contract business events.
 *
 */
@RosettaDataType(value="LoanContractNotification", builder=LoanContractNotification.LoanContractNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanContractNotification", model="fpml", builder=LoanContractNotification.LoanContractNotificationBuilderImpl.class, version="2.1.1")
public interface LoanContractNotification extends AbstractContractNotification {

	LoanContractNotificationMeta metaData = new LoanContractNotificationMeta();

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
	AbstractLoanServicingEvent getLoanContractEventGroup();
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
	List<? extends LoanContractNotificationChoice> getLoanContractNotificationChoice();
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
	LoanContractNotification build();
	
	LoanContractNotification.LoanContractNotificationBuilder toBuilder();
	
	static LoanContractNotification.LoanContractNotificationBuilder builder() {
		return new LoanContractNotification.LoanContractNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanContractNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanContractNotification> getType() {
		return LoanContractNotification.class;
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
		processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
		processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.class, getEventPayment());
		processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.class, getFacilityPosition());
		processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanServicingEvent.class, getLoanContractEventGroup());
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
		processRosetta(path.newSubPath("loanContractNotificationChoice"), processor, LoanContractNotificationChoice.class, getLoanContractNotificationChoice());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanContractNotificationBuilder extends LoanContractNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getOrCreateLoanContractEventGroup();
		@Override
		AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getLoanContractEventGroup();
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
		LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder getOrCreateLoanContractNotificationChoice(int index);
		@Override
		List<? extends LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder> getLoanContractNotificationChoice();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addValidation(Validation validation);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addEventPayment(EventPayment eventPayment);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addEventPayment(EventPayment eventPayment, int idx);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addFacilityPosition(FacilityPosition facilityPosition);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addFacilityPosition(FacilityPosition facilityPosition, int idx);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder addFacilityPosition(List<? extends FacilityPosition> facilityPosition);
		@Override
		LoanContractNotification.LoanContractNotificationBuilder setFacilityPosition(List<? extends FacilityPosition> facilityPosition);
		LoanContractNotification.LoanContractNotificationBuilder setLoanContractEventGroup(AbstractLoanServicingEvent loanContractEventGroup);
		LoanContractNotification.LoanContractNotificationBuilder setDealIdentifier(DealIdentifier dealIdentifier);
		LoanContractNotification.LoanContractNotificationBuilder setDealSummary(DealSummary dealSummary);
		LoanContractNotification.LoanContractNotificationBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		LoanContractNotification.LoanContractNotificationBuilder setFacilitySummary(FacilitySummary facilitySummary);
		LoanContractNotification.LoanContractNotificationBuilder addLoanContractNotificationChoice(LoanContractNotificationChoice loanContractNotificationChoice);
		LoanContractNotification.LoanContractNotificationBuilder addLoanContractNotificationChoice(LoanContractNotificationChoice loanContractNotificationChoice, int idx);
		LoanContractNotification.LoanContractNotificationBuilder addLoanContractNotificationChoice(List<? extends LoanContractNotificationChoice> loanContractNotificationChoice);
		LoanContractNotification.LoanContractNotificationBuilder setLoanContractNotificationChoice(List<? extends LoanContractNotificationChoice> loanContractNotificationChoice);
		LoanContractNotification.LoanContractNotificationBuilder addParty(Party party);
		LoanContractNotification.LoanContractNotificationBuilder addParty(Party party, int idx);
		LoanContractNotification.LoanContractNotificationBuilder addParty(List<? extends Party> party);
		LoanContractNotification.LoanContractNotificationBuilder setParty(List<? extends Party> party);

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
			processor.processBasic(path.newSubPath("isGlobalOnly"), Boolean.class, getIsGlobalOnly(), this);
			processRosetta(path.newSubPath("eventPayment"), processor, EventPayment.EventPaymentBuilder.class, getEventPayment());
			processRosetta(path.newSubPath("facilityPosition"), processor, FacilityPosition.FacilityPositionBuilder.class, getFacilityPosition());
			processRosetta(path.newSubPath("loanContractEventGroup"), processor, AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder.class, getLoanContractEventGroup());
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
			processRosetta(path.newSubPath("loanContractNotificationChoice"), processor, LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder.class, getLoanContractNotificationChoice());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LoanContractNotification.LoanContractNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LoanContractNotification  ***********************/
	class LoanContractNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements LoanContractNotification {
		private final AbstractLoanServicingEvent loanContractEventGroup;
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		private final List<? extends LoanContractNotificationChoice> loanContractNotificationChoice;
		private final List<? extends Party> party;
		
		protected LoanContractNotificationImpl(LoanContractNotification.LoanContractNotificationBuilder builder) {
			super(builder);
			this.loanContractEventGroup = ofNullable(builder.getLoanContractEventGroup()).map(f->f.build()).orElse(null);
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
			this.loanContractNotificationChoice = ofNullable(builder.getLoanContractNotificationChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("loanContractEventGroup")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanContractEventGroup")
		public AbstractLoanServicingEvent getLoanContractEventGroup() {
			return loanContractEventGroup;
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
		@RosettaAttribute("loanContractNotificationChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanContractNotificationChoice")
		public List<? extends LoanContractNotificationChoice> getLoanContractNotificationChoice() {
			return loanContractNotificationChoice;
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
		public LoanContractNotification build() {
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder toBuilder() {
			LoanContractNotification.LoanContractNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanContractNotification.LoanContractNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLoanContractEventGroup()).ifPresent(builder::setLoanContractEventGroup);
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
			ofNullable(getLoanContractNotificationChoice()).ifPresent(builder::setLoanContractNotificationChoice);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractNotification _that = getType().cast(o);
		
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(loanContractNotificationChoice, _that.getLoanContractNotificationChoice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (loanContractNotificationChoice != null ? loanContractNotificationChoice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractNotification {" +
				"loanContractEventGroup=" + this.loanContractEventGroup + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"loanContractNotificationChoice=" + this.loanContractNotificationChoice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanContractNotification  ***********************/
	class LoanContractNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl implements LoanContractNotification.LoanContractNotificationBuilder {
	
		protected AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder loanContractEventGroup;
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
		protected List<LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder> loanContractNotificationChoice = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("loanContractEventGroup")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("loanContractEventGroup")
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getLoanContractEventGroup() {
			return loanContractEventGroup;
		}
		
		@Override
		public AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder getOrCreateLoanContractEventGroup() {
			AbstractLoanServicingEvent.AbstractLoanServicingEventBuilder result;
			if (loanContractEventGroup!=null) {
				result = loanContractEventGroup;
			}
			else {
				result = loanContractEventGroup = AbstractLoanServicingEvent.builder();
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
		@RosettaAttribute("loanContractNotificationChoice")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("loanContractNotificationChoice")
		public List<? extends LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder> getLoanContractNotificationChoice() {
			return loanContractNotificationChoice;
		}
		
		@Override
		public LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder getOrCreateLoanContractNotificationChoice(int index) {
			if (loanContractNotificationChoice==null) {
				this.loanContractNotificationChoice = new ArrayList<>();
			}
			return getIndex(loanContractNotificationChoice, index, () -> {
						LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder newLoanContractNotificationChoice = LoanContractNotificationChoice.builder();
						return newLoanContractNotificationChoice;
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
		public LoanContractNotification.LoanContractNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public LoanContractNotification.LoanContractNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public LoanContractNotification.LoanContractNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanContractNotification.LoanContractNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LoanContractNotification.LoanContractNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LoanContractNotification.LoanContractNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LoanContractNotification.LoanContractNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setIsGlobalOnly(Boolean _isGlobalOnly) {
			this.isGlobalOnly = _isGlobalOnly == null ? null : _isGlobalOnly;
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addEventPayment(EventPayment _eventPayment) {
			if (_eventPayment != null) {
				this.eventPayment.add(_eventPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addEventPayment(EventPayment _eventPayment, int idx) {
			getIndex(this.eventPayment, idx, () -> _eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments != null) {
				for (final EventPayment toAdd : eventPayments) {
					this.eventPayment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
			if (eventPayments == null) {
				this.eventPayment = new ArrayList<>();
			} else {
				this.eventPayment = eventPayments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityPosition")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addFacilityPosition(FacilityPosition _facilityPosition) {
			if (_facilityPosition != null) {
				this.facilityPosition.add(_facilityPosition.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addFacilityPosition(FacilityPosition _facilityPosition, int idx) {
			getIndex(this.facilityPosition, idx, () -> _facilityPosition.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addFacilityPosition(List<? extends FacilityPosition> facilityPositions) {
			if (facilityPositions != null) {
				for (final FacilityPosition toAdd : facilityPositions) {
					this.facilityPosition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityPosition")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityPosition")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setFacilityPosition(List<? extends FacilityPosition> facilityPositions) {
			if (facilityPositions == null) {
				this.facilityPosition = new ArrayList<>();
			} else {
				this.facilityPosition = facilityPositions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loanContractEventGroup")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("loanContractEventGroup")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setLoanContractEventGroup(AbstractLoanServicingEvent _loanContractEventGroup) {
			this.loanContractEventGroup = _loanContractEventGroup == null ? null : _loanContractEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityIdentifier")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilitySummary")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setFacilitySummary(FacilitySummary _facilitySummary) {
			this.facilitySummary = _facilitySummary == null ? null : _facilitySummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loanContractNotificationChoice")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("loanContractNotificationChoice")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addLoanContractNotificationChoice(LoanContractNotificationChoice _loanContractNotificationChoice) {
			if (_loanContractNotificationChoice != null) {
				this.loanContractNotificationChoice.add(_loanContractNotificationChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addLoanContractNotificationChoice(LoanContractNotificationChoice _loanContractNotificationChoice, int idx) {
			getIndex(this.loanContractNotificationChoice, idx, () -> _loanContractNotificationChoice.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addLoanContractNotificationChoice(List<? extends LoanContractNotificationChoice> loanContractNotificationChoices) {
			if (loanContractNotificationChoices != null) {
				for (final LoanContractNotificationChoice toAdd : loanContractNotificationChoices) {
					this.loanContractNotificationChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("loanContractNotificationChoice")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("loanContractNotificationChoice")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder setLoanContractNotificationChoice(List<? extends LoanContractNotificationChoice> loanContractNotificationChoices) {
			if (loanContractNotificationChoices == null) {
				this.loanContractNotificationChoice = new ArrayList<>();
			} else {
				this.loanContractNotificationChoice = loanContractNotificationChoices.stream()
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
		public LoanContractNotification.LoanContractNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder addParty(List<? extends Party> partys) {
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
		public LoanContractNotification.LoanContractNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LoanContractNotification build() {
			return new LoanContractNotification.LoanContractNotificationImpl(this);
		}
		
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder prune() {
			super.prune();
			if (loanContractEventGroup!=null && !loanContractEventGroup.prune().hasData()) loanContractEventGroup = null;
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			loanContractNotificationChoice = loanContractNotificationChoice.stream().filter(b->b!=null).<LoanContractNotificationChoice.LoanContractNotificationChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLoanContractEventGroup()!=null && getLoanContractEventGroup().hasData()) return true;
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			if (getLoanContractNotificationChoice()!=null && getLoanContractNotificationChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanContractNotification.LoanContractNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanContractNotification.LoanContractNotificationBuilder o = (LoanContractNotification.LoanContractNotificationBuilder) other;
			
			merger.mergeRosetta(getLoanContractEventGroup(), o.getLoanContractEventGroup(), this::setLoanContractEventGroup);
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			merger.mergeRosetta(getLoanContractNotificationChoice(), o.getLoanContractNotificationChoice(), this::getOrCreateLoanContractNotificationChoice);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanContractNotification _that = getType().cast(o);
		
			if (!Objects.equals(loanContractEventGroup, _that.getLoanContractEventGroup())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(loanContractNotificationChoice, _that.getLoanContractNotificationChoice())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (loanContractEventGroup != null ? loanContractEventGroup.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (loanContractNotificationChoice != null ? loanContractNotificationChoice.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanContractNotificationBuilder {" +
				"loanContractEventGroup=" + this.loanContractEventGroup + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"loanContractNotificationChoice=" + this.loanContractNotificationChoice + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
