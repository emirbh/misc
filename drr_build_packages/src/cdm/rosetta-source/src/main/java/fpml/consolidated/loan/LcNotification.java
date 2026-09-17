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
import fpml.consolidated.loan.meta.LcNotificationMeta;
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
 * Provision A loan servicing notification used to communicate various letter of credit business events.
 *
 */
@RosettaDataType(value="LcNotification", builder=LcNotification.LcNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LcNotification", model="fpml", builder=LcNotification.LcNotificationBuilderImpl.class, version="2.1.1")
public interface LcNotification extends AbstractContractNotification {

	LcNotificationMeta metaData = new LcNotificationMeta();

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
	AbstractLcEvent getLcEventGroup();
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
	 * Provision A letter of credit identifier structure.
	 *
	 */
	LoanContractIdentifier getLetterOfCreditIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A letter of credit summary structure.
	 *
	 */
	LetterOfCreditSummary getLetterOfCreditSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A full letter of credit structure.
	 *
	 */
	LetterOfCredit getLetterOfCredit();
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
	LcNotification build();
	
	LcNotification.LcNotificationBuilder toBuilder();
	
	static LcNotification.LcNotificationBuilder builder() {
		return new LcNotification.LcNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LcNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LcNotification> getType() {
		return LcNotification.class;
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
		processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.class, getLcEventGroup());
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
		processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, LoanContractIdentifier.class, getLetterOfCreditIdentifier());
		processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.class, getLetterOfCreditSummary());
		processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.class, getLetterOfCredit());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LcNotificationBuilder extends LcNotification, AbstractContractNotification.AbstractContractNotificationBuilder {
		AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup();
		@Override
		AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup();
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
		LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier();
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder getLetterOfCreditIdentifier();
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getOrCreateLetterOfCreditSummary();
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getLetterOfCreditSummary();
		LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit();
		@Override
		LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		LcNotification.LcNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		LcNotification.LcNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		LcNotification.LcNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		LcNotification.LcNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		LcNotification.LcNotificationBuilder addValidation(Validation validation);
		@Override
		LcNotification.LcNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		LcNotification.LcNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		LcNotification.LcNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		LcNotification.LcNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		LcNotification.LcNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		LcNotification.LcNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		LcNotification.LcNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		LcNotification.LcNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LcNotification.LcNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		LcNotification.LcNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		LcNotification.LcNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		LcNotification.LcNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		LcNotification.LcNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LcNotification.LcNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		LcNotification.LcNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		LcNotification.LcNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		@Override
		LcNotification.LcNotificationBuilder addEventPayment(EventPayment eventPayment);
		@Override
		LcNotification.LcNotificationBuilder addEventPayment(EventPayment eventPayment, int idx);
		@Override
		LcNotification.LcNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		LcNotification.LcNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		LcNotification.LcNotificationBuilder addFacilityPosition(FacilityPosition facilityPosition);
		@Override
		LcNotification.LcNotificationBuilder addFacilityPosition(FacilityPosition facilityPosition, int idx);
		@Override
		LcNotification.LcNotificationBuilder addFacilityPosition(List<? extends FacilityPosition> facilityPosition);
		@Override
		LcNotification.LcNotificationBuilder setFacilityPosition(List<? extends FacilityPosition> facilityPosition);
		LcNotification.LcNotificationBuilder setLcEventGroup(AbstractLcEvent lcEventGroup);
		LcNotification.LcNotificationBuilder setDealIdentifier(DealIdentifier dealIdentifier);
		LcNotification.LcNotificationBuilder setDealSummary(DealSummary dealSummary);
		LcNotification.LcNotificationBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		LcNotification.LcNotificationBuilder setFacilitySummary(FacilitySummary facilitySummary);
		LcNotification.LcNotificationBuilder setLetterOfCreditIdentifier(LoanContractIdentifier letterOfCreditIdentifier);
		LcNotification.LcNotificationBuilder setLetterOfCreditSummary(LetterOfCreditSummary letterOfCreditSummary);
		LcNotification.LcNotificationBuilder setLetterOfCredit(LetterOfCredit letterOfCredit);
		LcNotification.LcNotificationBuilder addParty(Party party);
		LcNotification.LcNotificationBuilder addParty(Party party, int idx);
		LcNotification.LcNotificationBuilder addParty(List<? extends Party> party);
		LcNotification.LcNotificationBuilder setParty(List<? extends Party> party);

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
			processRosetta(path.newSubPath("lcEventGroup"), processor, AbstractLcEvent.AbstractLcEventBuilder.class, getLcEventGroup());
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
			processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, LoanContractIdentifier.LoanContractIdentifierBuilder.class, getLetterOfCreditIdentifier());
			processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.LetterOfCreditSummaryBuilder.class, getLetterOfCreditSummary());
			processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.LetterOfCreditBuilder.class, getLetterOfCredit());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		LcNotification.LcNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of LcNotification  ***********************/
	class LcNotificationImpl extends AbstractContractNotification.AbstractContractNotificationImpl implements LcNotification {
		private final AbstractLcEvent lcEventGroup;
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		private final LoanContractIdentifier letterOfCreditIdentifier;
		private final LetterOfCreditSummary letterOfCreditSummary;
		private final LetterOfCredit letterOfCredit;
		private final List<? extends Party> party;
		
		protected LcNotificationImpl(LcNotification.LcNotificationBuilder builder) {
			super(builder);
			this.lcEventGroup = ofNullable(builder.getLcEventGroup()).map(f->f.build()).orElse(null);
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
			this.letterOfCreditIdentifier = ofNullable(builder.getLetterOfCreditIdentifier()).map(f->f.build()).orElse(null);
			this.letterOfCreditSummary = ofNullable(builder.getLetterOfCreditSummary()).map(f->f.build()).orElse(null);
			this.letterOfCredit = ofNullable(builder.getLetterOfCredit()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lcEventGroup")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lcEventGroup")
		public AbstractLcEvent getLcEventGroup() {
			return lcEventGroup;
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
		@RosettaAttribute("letterOfCreditIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditIdentifier")
		public LoanContractIdentifier getLetterOfCreditIdentifier() {
			return letterOfCreditIdentifier;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditSummary")
		public LetterOfCreditSummary getLetterOfCreditSummary() {
			return letterOfCreditSummary;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCredit")
		public LetterOfCredit getLetterOfCredit() {
			return letterOfCredit;
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
		public LcNotification build() {
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder toBuilder() {
			LcNotification.LcNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LcNotification.LcNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getLcEventGroup()).ifPresent(builder::setLcEventGroup);
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
			ofNullable(getLetterOfCreditIdentifier()).ifPresent(builder::setLetterOfCreditIdentifier);
			ofNullable(getLetterOfCreditSummary()).ifPresent(builder::setLetterOfCreditSummary);
			ofNullable(getLetterOfCredit()).ifPresent(builder::setLetterOfCredit);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcNotification _that = getType().cast(o);
		
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			if (!Objects.equals(letterOfCreditSummary, _that.getLetterOfCreditSummary())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditSummary != null ? letterOfCreditSummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcNotification {" +
				"lcEventGroup=" + this.lcEventGroup + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LcNotification  ***********************/
	class LcNotificationBuilderImpl extends AbstractContractNotification.AbstractContractNotificationBuilderImpl implements LcNotification.LcNotificationBuilder {
	
		protected AbstractLcEvent.AbstractLcEventBuilder lcEventGroup;
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
		protected LoanContractIdentifier.LoanContractIdentifierBuilder letterOfCreditIdentifier;
		protected LetterOfCreditSummary.LetterOfCreditSummaryBuilder letterOfCreditSummary;
		protected LetterOfCredit.LetterOfCreditBuilder letterOfCredit;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("lcEventGroup")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("lcEventGroup")
		public AbstractLcEvent.AbstractLcEventBuilder getLcEventGroup() {
			return lcEventGroup;
		}
		
		@Override
		public AbstractLcEvent.AbstractLcEventBuilder getOrCreateLcEventGroup() {
			AbstractLcEvent.AbstractLcEventBuilder result;
			if (lcEventGroup!=null) {
				result = lcEventGroup;
			}
			else {
				result = lcEventGroup = AbstractLcEvent.builder();
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
		@RosettaAttribute("letterOfCreditIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditIdentifier")
		public LoanContractIdentifier.LoanContractIdentifierBuilder getLetterOfCreditIdentifier() {
			return letterOfCreditIdentifier;
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier() {
			LoanContractIdentifier.LoanContractIdentifierBuilder result;
			if (letterOfCreditIdentifier!=null) {
				result = letterOfCreditIdentifier;
			}
			else {
				result = letterOfCreditIdentifier = LoanContractIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditSummary")
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder getLetterOfCreditSummary() {
			return letterOfCreditSummary;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder getOrCreateLetterOfCreditSummary() {
			LetterOfCreditSummary.LetterOfCreditSummaryBuilder result;
			if (letterOfCreditSummary!=null) {
				result = letterOfCreditSummary;
			}
			else {
				result = letterOfCreditSummary = LetterOfCreditSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCredit")
		public LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit() {
			return letterOfCredit;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit() {
			LetterOfCredit.LetterOfCreditBuilder result;
			if (letterOfCredit!=null) {
				result = letterOfCredit;
			}
			else {
				result = letterOfCredit = LetterOfCredit.builder();
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
		public LcNotification.LcNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public LcNotification.LcNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public LcNotification.LcNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public LcNotification.LcNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public LcNotification.LcNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public LcNotification.LcNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public LcNotification.LcNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public LcNotification.LcNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public LcNotification.LcNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LcNotification.LcNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public LcNotification.LcNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public LcNotification.LcNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LcNotification.LcNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public LcNotification.LcNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		@Override
		public LcNotification.LcNotificationBuilder setIsGlobalOnly(Boolean _isGlobalOnly) {
			this.isGlobalOnly = _isGlobalOnly == null ? null : _isGlobalOnly;
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public LcNotification.LcNotificationBuilder addEventPayment(EventPayment _eventPayment) {
			if (_eventPayment != null) {
				this.eventPayment.add(_eventPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addEventPayment(EventPayment _eventPayment, int idx) {
			getIndex(this.eventPayment, idx, () -> _eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
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
		public LcNotification.LcNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		public LcNotification.LcNotificationBuilder addFacilityPosition(FacilityPosition _facilityPosition) {
			if (_facilityPosition != null) {
				this.facilityPosition.add(_facilityPosition.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addFacilityPosition(FacilityPosition _facilityPosition, int idx) {
			getIndex(this.facilityPosition, idx, () -> _facilityPosition.toBuilder());
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addFacilityPosition(List<? extends FacilityPosition> facilityPositions) {
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
		public LcNotification.LcNotificationBuilder setFacilityPosition(List<? extends FacilityPosition> facilityPositions) {
			if (facilityPositions == null) {
				this.facilityPosition = new ArrayList<>();
			} else {
				this.facilityPosition = facilityPositions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("lcEventGroup")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("lcEventGroup")
		@Override
		public LcNotification.LcNotificationBuilder setLcEventGroup(AbstractLcEvent _lcEventGroup) {
			this.lcEventGroup = _lcEventGroup == null ? null : _lcEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public LcNotification.LcNotificationBuilder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public LcNotification.LcNotificationBuilder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityIdentifier")
		@Override
		public LcNotification.LcNotificationBuilder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilitySummary")
		@Override
		public LcNotification.LcNotificationBuilder setFacilitySummary(FacilitySummary _facilitySummary) {
			this.facilitySummary = _facilitySummary == null ? null : _facilitySummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCreditIdentifier")
		@Override
		public LcNotification.LcNotificationBuilder setLetterOfCreditIdentifier(LoanContractIdentifier _letterOfCreditIdentifier) {
			this.letterOfCreditIdentifier = _letterOfCreditIdentifier == null ? null : _letterOfCreditIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCreditSummary")
		@Override
		public LcNotification.LcNotificationBuilder setLetterOfCreditSummary(LetterOfCreditSummary _letterOfCreditSummary) {
			this.letterOfCreditSummary = _letterOfCreditSummary == null ? null : _letterOfCreditSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCredit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCredit")
		@Override
		public LcNotification.LcNotificationBuilder setLetterOfCredit(LetterOfCredit _letterOfCredit) {
			this.letterOfCredit = _letterOfCredit == null ? null : _letterOfCredit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public LcNotification.LcNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public LcNotification.LcNotificationBuilder addParty(List<? extends Party> partys) {
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
		public LcNotification.LcNotificationBuilder setParty(List<? extends Party> partys) {
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
		public LcNotification build() {
			return new LcNotification.LcNotificationImpl(this);
		}
		
		@Override
		public LcNotification.LcNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcNotification.LcNotificationBuilder prune() {
			super.prune();
			if (lcEventGroup!=null && !lcEventGroup.prune().hasData()) lcEventGroup = null;
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			if (letterOfCreditIdentifier!=null && !letterOfCreditIdentifier.prune().hasData()) letterOfCreditIdentifier = null;
			if (letterOfCreditSummary!=null && !letterOfCreditSummary.prune().hasData()) letterOfCreditSummary = null;
			if (letterOfCredit!=null && !letterOfCredit.prune().hasData()) letterOfCredit = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getLcEventGroup()!=null && getLcEventGroup().hasData()) return true;
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			if (getLetterOfCreditIdentifier()!=null && getLetterOfCreditIdentifier().hasData()) return true;
			if (getLetterOfCreditSummary()!=null && getLetterOfCreditSummary().hasData()) return true;
			if (getLetterOfCredit()!=null && getLetterOfCredit().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LcNotification.LcNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LcNotification.LcNotificationBuilder o = (LcNotification.LcNotificationBuilder) other;
			
			merger.mergeRosetta(getLcEventGroup(), o.getLcEventGroup(), this::setLcEventGroup);
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			merger.mergeRosetta(getLetterOfCreditIdentifier(), o.getLetterOfCreditIdentifier(), this::setLetterOfCreditIdentifier);
			merger.mergeRosetta(getLetterOfCreditSummary(), o.getLetterOfCreditSummary(), this::setLetterOfCreditSummary);
			merger.mergeRosetta(getLetterOfCredit(), o.getLetterOfCredit(), this::setLetterOfCredit);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LcNotification _that = getType().cast(o);
		
			if (!Objects.equals(lcEventGroup, _that.getLcEventGroup())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			if (!Objects.equals(letterOfCreditSummary, _that.getLetterOfCreditSummary())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (lcEventGroup != null ? lcEventGroup.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditSummary != null ? letterOfCreditSummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LcNotificationBuilder {" +
				"lcEventGroup=" + this.lcEventGroup + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
