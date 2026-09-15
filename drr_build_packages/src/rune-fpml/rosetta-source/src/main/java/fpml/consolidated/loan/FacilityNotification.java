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
import fpml.consolidated.loan.meta.FacilityNotificationMeta;
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
 * Provision A loan servicing notification which can be used to communicate any facility-level business event.
 *
 */
@RosettaDataType(value="FacilityNotification", builder=FacilityNotification.FacilityNotificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FacilityNotification", model="fpml", builder=FacilityNotification.FacilityNotificationBuilderImpl.class, version="2.1.1")
public interface FacilityNotification extends AbstractFacilityNotification {

	FacilityNotificationMeta metaData = new FacilityNotificationMeta();

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
	AbstractFacilityEvent getFacilityEventGroup();
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
	List<? extends FacilityNotificationChoice0> getFacilityNotificationChoice0();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends FacilityNotificationChoice1> getFacilityNotificationChoice1();
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
	FacilityNotification build();
	
	FacilityNotification.FacilityNotificationBuilder toBuilder();
	
	static FacilityNotification.FacilityNotificationBuilder builder() {
		return new FacilityNotification.FacilityNotificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityNotification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FacilityNotification> getType() {
		return FacilityNotification.class;
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
		processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.class, getFacilityEventGroup());
		processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.class, getDealIdentifier());
		processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.class, getDealSummary());
		processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.class, getFacilityIdentifier());
		processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.class, getFacilitySummary());
		processRosetta(path.newSubPath("facilityNotificationChoice0"), processor, FacilityNotificationChoice0.class, getFacilityNotificationChoice0());
		processRosetta(path.newSubPath("facilityNotificationChoice1"), processor, FacilityNotificationChoice1.class, getFacilityNotificationChoice1());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityNotificationBuilder extends FacilityNotification, AbstractFacilityNotification.AbstractFacilityNotificationBuilder {
		AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup();
		@Override
		AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup();
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
		FacilityNotificationChoice0.FacilityNotificationChoice0Builder getOrCreateFacilityNotificationChoice0(int index);
		@Override
		List<? extends FacilityNotificationChoice0.FacilityNotificationChoice0Builder> getFacilityNotificationChoice0();
		FacilityNotificationChoice1.FacilityNotificationChoice1Builder getOrCreateFacilityNotificationChoice1(int index);
		@Override
		List<? extends FacilityNotificationChoice1.FacilityNotificationChoice1Builder> getFacilityNotificationChoice1();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		@Override
		FacilityNotification.FacilityNotificationBuilder setFpmlVersion(String fpmlVersion);
		@Override
		FacilityNotification.FacilityNotificationBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		FacilityNotification.FacilityNotificationBuilder setActualBuild(Integer actualBuild);
		@Override
		FacilityNotification.FacilityNotificationBuilder setHeader(RequestMessageHeader header);
		@Override
		FacilityNotification.FacilityNotificationBuilder addValidation(Validation validation);
		@Override
		FacilityNotification.FacilityNotificationBuilder addValidation(Validation validation, int idx);
		@Override
		FacilityNotification.FacilityNotificationBuilder addValidation(List<? extends Validation> validation);
		@Override
		FacilityNotification.FacilityNotificationBuilder setValidation(List<? extends Validation> validation);
		@Override
		FacilityNotification.FacilityNotificationBuilder setIsCorrection(Boolean isCorrection);
		@Override
		FacilityNotification.FacilityNotificationBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		FacilityNotification.FacilityNotificationBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		FacilityNotification.FacilityNotificationBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		FacilityNotification.FacilityNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		FacilityNotification.FacilityNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		FacilityNotification.FacilityNotificationBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		FacilityNotification.FacilityNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		FacilityNotification.FacilityNotificationBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		FacilityNotification.FacilityNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		FacilityNotification.FacilityNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		FacilityNotification.FacilityNotificationBuilder setNoticeDate(ZonedDateTime noticeDate);
		@Override
		FacilityNotification.FacilityNotificationBuilder setIsGlobalOnly(Boolean isGlobalOnly);
		@Override
		FacilityNotification.FacilityNotificationBuilder addEventPayment(EventPayment eventPayment);
		@Override
		FacilityNotification.FacilityNotificationBuilder addEventPayment(EventPayment eventPayment, int idx);
		@Override
		FacilityNotification.FacilityNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		FacilityNotification.FacilityNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayment);
		@Override
		FacilityNotification.FacilityNotificationBuilder setFacilityPosition(FacilityPosition facilityPosition);
		FacilityNotification.FacilityNotificationBuilder setFacilityEventGroup(AbstractFacilityEvent facilityEventGroup);
		FacilityNotification.FacilityNotificationBuilder setDealIdentifier(DealIdentifier dealIdentifier);
		FacilityNotification.FacilityNotificationBuilder setDealSummary(DealSummary dealSummary);
		FacilityNotification.FacilityNotificationBuilder setFacilityIdentifier(FacilityIdentifier facilityIdentifier);
		FacilityNotification.FacilityNotificationBuilder setFacilitySummary(FacilitySummary facilitySummary);
		FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice0(FacilityNotificationChoice0 facilityNotificationChoice0);
		FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice0(FacilityNotificationChoice0 facilityNotificationChoice0, int idx);
		FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice0(List<? extends FacilityNotificationChoice0> facilityNotificationChoice0);
		FacilityNotification.FacilityNotificationBuilder setFacilityNotificationChoice0(List<? extends FacilityNotificationChoice0> facilityNotificationChoice0);
		FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice1(FacilityNotificationChoice1 facilityNotificationChoice1);
		FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice1(FacilityNotificationChoice1 facilityNotificationChoice1, int idx);
		FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice1(List<? extends FacilityNotificationChoice1> facilityNotificationChoice1);
		FacilityNotification.FacilityNotificationBuilder setFacilityNotificationChoice1(List<? extends FacilityNotificationChoice1> facilityNotificationChoice1);
		FacilityNotification.FacilityNotificationBuilder addParty(Party party);
		FacilityNotification.FacilityNotificationBuilder addParty(Party party, int idx);
		FacilityNotification.FacilityNotificationBuilder addParty(List<? extends Party> party);
		FacilityNotification.FacilityNotificationBuilder setParty(List<? extends Party> party);

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
			processRosetta(path.newSubPath("facilityEventGroup"), processor, AbstractFacilityEvent.AbstractFacilityEventBuilder.class, getFacilityEventGroup());
			processRosetta(path.newSubPath("dealIdentifier"), processor, DealIdentifier.DealIdentifierBuilder.class, getDealIdentifier());
			processRosetta(path.newSubPath("dealSummary"), processor, DealSummary.DealSummaryBuilder.class, getDealSummary());
			processRosetta(path.newSubPath("facilityIdentifier"), processor, FacilityIdentifier.FacilityIdentifierBuilder.class, getFacilityIdentifier());
			processRosetta(path.newSubPath("facilitySummary"), processor, FacilitySummary.FacilitySummaryBuilder.class, getFacilitySummary());
			processRosetta(path.newSubPath("facilityNotificationChoice0"), processor, FacilityNotificationChoice0.FacilityNotificationChoice0Builder.class, getFacilityNotificationChoice0());
			processRosetta(path.newSubPath("facilityNotificationChoice1"), processor, FacilityNotificationChoice1.FacilityNotificationChoice1Builder.class, getFacilityNotificationChoice1());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
		}
		

		FacilityNotification.FacilityNotificationBuilder prune();
	}

	/*********************** Immutable Implementation of FacilityNotification  ***********************/
	class FacilityNotificationImpl extends AbstractFacilityNotification.AbstractFacilityNotificationImpl implements FacilityNotification {
		private final AbstractFacilityEvent facilityEventGroup;
		private final DealIdentifier dealIdentifier;
		private final DealSummary dealSummary;
		private final FacilityIdentifier facilityIdentifier;
		private final FacilitySummary facilitySummary;
		private final List<? extends FacilityNotificationChoice0> facilityNotificationChoice0;
		private final List<? extends FacilityNotificationChoice1> facilityNotificationChoice1;
		private final List<? extends Party> party;
		
		protected FacilityNotificationImpl(FacilityNotification.FacilityNotificationBuilder builder) {
			super(builder);
			this.facilityEventGroup = ofNullable(builder.getFacilityEventGroup()).map(f->f.build()).orElse(null);
			this.dealIdentifier = ofNullable(builder.getDealIdentifier()).map(f->f.build()).orElse(null);
			this.dealSummary = ofNullable(builder.getDealSummary()).map(f->f.build()).orElse(null);
			this.facilityIdentifier = ofNullable(builder.getFacilityIdentifier()).map(f->f.build()).orElse(null);
			this.facilitySummary = ofNullable(builder.getFacilitySummary()).map(f->f.build()).orElse(null);
			this.facilityNotificationChoice0 = ofNullable(builder.getFacilityNotificationChoice0()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.facilityNotificationChoice1 = ofNullable(builder.getFacilityNotificationChoice1()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("facilityEventGroup")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityEventGroup")
		public AbstractFacilityEvent getFacilityEventGroup() {
			return facilityEventGroup;
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
		@RosettaAttribute("facilityNotificationChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityNotificationChoice0")
		public List<? extends FacilityNotificationChoice0> getFacilityNotificationChoice0() {
			return facilityNotificationChoice0;
		}
		
		@Override
		@RosettaAttribute("facilityNotificationChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityNotificationChoice1")
		public List<? extends FacilityNotificationChoice1> getFacilityNotificationChoice1() {
			return facilityNotificationChoice1;
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
		public FacilityNotification build() {
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder toBuilder() {
			FacilityNotification.FacilityNotificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityNotification.FacilityNotificationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFacilityEventGroup()).ifPresent(builder::setFacilityEventGroup);
			ofNullable(getDealIdentifier()).ifPresent(builder::setDealIdentifier);
			ofNullable(getDealSummary()).ifPresent(builder::setDealSummary);
			ofNullable(getFacilityIdentifier()).ifPresent(builder::setFacilityIdentifier);
			ofNullable(getFacilitySummary()).ifPresent(builder::setFacilitySummary);
			ofNullable(getFacilityNotificationChoice0()).ifPresent(builder::setFacilityNotificationChoice0);
			ofNullable(getFacilityNotificationChoice1()).ifPresent(builder::setFacilityNotificationChoice1);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(facilityNotificationChoice0, _that.getFacilityNotificationChoice0())) return false;
			if (!ListEquals.listEquals(facilityNotificationChoice1, _that.getFacilityNotificationChoice1())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (facilityNotificationChoice0 != null ? facilityNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (facilityNotificationChoice1 != null ? facilityNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityNotification {" +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"facilityNotificationChoice0=" + this.facilityNotificationChoice0 + ", " +
				"facilityNotificationChoice1=" + this.facilityNotificationChoice1 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FacilityNotification  ***********************/
	class FacilityNotificationBuilderImpl extends AbstractFacilityNotification.AbstractFacilityNotificationBuilderImpl implements FacilityNotification.FacilityNotificationBuilder {
	
		protected AbstractFacilityEvent.AbstractFacilityEventBuilder facilityEventGroup;
		protected DealIdentifier.DealIdentifierBuilder dealIdentifier;
		protected DealSummary.DealSummaryBuilder dealSummary;
		protected FacilityIdentifier.FacilityIdentifierBuilder facilityIdentifier;
		protected FacilitySummary.FacilitySummaryBuilder facilitySummary;
		protected List<FacilityNotificationChoice0.FacilityNotificationChoice0Builder> facilityNotificationChoice0 = new ArrayList<>();
		protected List<FacilityNotificationChoice1.FacilityNotificationChoice1Builder> facilityNotificationChoice1 = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		
		@Override
		@RosettaAttribute("facilityEventGroup")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("facilityEventGroup")
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getFacilityEventGroup() {
			return facilityEventGroup;
		}
		
		@Override
		public AbstractFacilityEvent.AbstractFacilityEventBuilder getOrCreateFacilityEventGroup() {
			AbstractFacilityEvent.AbstractFacilityEventBuilder result;
			if (facilityEventGroup!=null) {
				result = facilityEventGroup;
			}
			else {
				result = facilityEventGroup = AbstractFacilityEvent.builder();
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
		@RosettaAttribute("facilityNotificationChoice0")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityNotificationChoice0")
		public List<? extends FacilityNotificationChoice0.FacilityNotificationChoice0Builder> getFacilityNotificationChoice0() {
			return facilityNotificationChoice0;
		}
		
		@Override
		public FacilityNotificationChoice0.FacilityNotificationChoice0Builder getOrCreateFacilityNotificationChoice0(int index) {
			if (facilityNotificationChoice0==null) {
				this.facilityNotificationChoice0 = new ArrayList<>();
			}
			return getIndex(facilityNotificationChoice0, index, () -> {
						FacilityNotificationChoice0.FacilityNotificationChoice0Builder newFacilityNotificationChoice0 = FacilityNotificationChoice0.builder();
						return newFacilityNotificationChoice0;
					});
		}
		
		@Override
		@RosettaAttribute("facilityNotificationChoice1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("facilityNotificationChoice1")
		public List<? extends FacilityNotificationChoice1.FacilityNotificationChoice1Builder> getFacilityNotificationChoice1() {
			return facilityNotificationChoice1;
		}
		
		@Override
		public FacilityNotificationChoice1.FacilityNotificationChoice1Builder getOrCreateFacilityNotificationChoice1(int index) {
			if (facilityNotificationChoice1==null) {
				this.facilityNotificationChoice1 = new ArrayList<>();
			}
			return getIndex(facilityNotificationChoice1, index, () -> {
						FacilityNotificationChoice1.FacilityNotificationChoice1Builder newFacilityNotificationChoice1 = FacilityNotificationChoice1.builder();
						return newFacilityNotificationChoice1;
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
		public FacilityNotification.FacilityNotificationBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public FacilityNotification.FacilityNotificationBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addValidation(List<? extends Validation> validations) {
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
		public FacilityNotification.FacilityNotificationBuilder setValidation(List<? extends Validation> validations) {
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
		public FacilityNotification.FacilityNotificationBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public FacilityNotification.FacilityNotificationBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public FacilityNotification.FacilityNotificationBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public FacilityNotification.FacilityNotificationBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public FacilityNotification.FacilityNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public FacilityNotification.FacilityNotificationBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public FacilityNotification.FacilityNotificationBuilder setNoticeDate(ZonedDateTime _noticeDate) {
			this.noticeDate = _noticeDate == null ? null : _noticeDate;
			return this;
		}
		
		@RosettaAttribute("isGlobalOnly")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isGlobalOnly")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setIsGlobalOnly(Boolean _isGlobalOnly) {
			this.isGlobalOnly = _isGlobalOnly == null ? null : _isGlobalOnly;
			return this;
		}
		
		@RosettaAttribute("eventPayment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventPayment")
		@Override
		public FacilityNotification.FacilityNotificationBuilder addEventPayment(EventPayment _eventPayment) {
			if (_eventPayment != null) {
				this.eventPayment.add(_eventPayment.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addEventPayment(EventPayment _eventPayment, int idx) {
			getIndex(this.eventPayment, idx, () -> _eventPayment.toBuilder());
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addEventPayment(List<? extends EventPayment> eventPayments) {
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
		public FacilityNotification.FacilityNotificationBuilder setEventPayment(List<? extends EventPayment> eventPayments) {
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
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityPosition")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setFacilityPosition(FacilityPosition _facilityPosition) {
			this.facilityPosition = _facilityPosition == null ? null : _facilityPosition.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityEventGroup")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("facilityEventGroup")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setFacilityEventGroup(AbstractFacilityEvent _facilityEventGroup) {
			this.facilityEventGroup = _facilityEventGroup == null ? null : _facilityEventGroup.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealIdentifier")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setDealIdentifier(DealIdentifier _dealIdentifier) {
			this.dealIdentifier = _dealIdentifier == null ? null : _dealIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dealSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dealSummary")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setDealSummary(DealSummary _dealSummary) {
			this.dealSummary = _dealSummary == null ? null : _dealSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilityIdentifier")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setFacilityIdentifier(FacilityIdentifier _facilityIdentifier) {
			this.facilityIdentifier = _facilityIdentifier == null ? null : _facilityIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilitySummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("facilitySummary")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setFacilitySummary(FacilitySummary _facilitySummary) {
			this.facilitySummary = _facilitySummary == null ? null : _facilitySummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("facilityNotificationChoice0")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityNotificationChoice0")
		@Override
		public FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice0(FacilityNotificationChoice0 _facilityNotificationChoice0) {
			if (_facilityNotificationChoice0 != null) {
				this.facilityNotificationChoice0.add(_facilityNotificationChoice0.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice0(FacilityNotificationChoice0 _facilityNotificationChoice0, int idx) {
			getIndex(this.facilityNotificationChoice0, idx, () -> _facilityNotificationChoice0.toBuilder());
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice0(List<? extends FacilityNotificationChoice0> facilityNotificationChoice0s) {
			if (facilityNotificationChoice0s != null) {
				for (final FacilityNotificationChoice0 toAdd : facilityNotificationChoice0s) {
					this.facilityNotificationChoice0.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityNotificationChoice0")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityNotificationChoice0")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setFacilityNotificationChoice0(List<? extends FacilityNotificationChoice0> facilityNotificationChoice0s) {
			if (facilityNotificationChoice0s == null) {
				this.facilityNotificationChoice0 = new ArrayList<>();
			} else {
				this.facilityNotificationChoice0 = facilityNotificationChoice0s.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("facilityNotificationChoice1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("facilityNotificationChoice1")
		@Override
		public FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice1(FacilityNotificationChoice1 _facilityNotificationChoice1) {
			if (_facilityNotificationChoice1 != null) {
				this.facilityNotificationChoice1.add(_facilityNotificationChoice1.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice1(FacilityNotificationChoice1 _facilityNotificationChoice1, int idx) {
			getIndex(this.facilityNotificationChoice1, idx, () -> _facilityNotificationChoice1.toBuilder());
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addFacilityNotificationChoice1(List<? extends FacilityNotificationChoice1> facilityNotificationChoice1s) {
			if (facilityNotificationChoice1s != null) {
				for (final FacilityNotificationChoice1 toAdd : facilityNotificationChoice1s) {
					this.facilityNotificationChoice1.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("facilityNotificationChoice1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("facilityNotificationChoice1")
		@Override
		public FacilityNotification.FacilityNotificationBuilder setFacilityNotificationChoice1(List<? extends FacilityNotificationChoice1> facilityNotificationChoice1s) {
			if (facilityNotificationChoice1s == null) {
				this.facilityNotificationChoice1 = new ArrayList<>();
			} else {
				this.facilityNotificationChoice1 = facilityNotificationChoice1s.stream()
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
		public FacilityNotification.FacilityNotificationBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder addParty(List<? extends Party> partys) {
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
		public FacilityNotification.FacilityNotificationBuilder setParty(List<? extends Party> partys) {
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
		public FacilityNotification build() {
			return new FacilityNotification.FacilityNotificationImpl(this);
		}
		
		@Override
		public FacilityNotification.FacilityNotificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityNotification.FacilityNotificationBuilder prune() {
			super.prune();
			if (facilityEventGroup!=null && !facilityEventGroup.prune().hasData()) facilityEventGroup = null;
			if (dealIdentifier!=null && !dealIdentifier.prune().hasData()) dealIdentifier = null;
			if (dealSummary!=null && !dealSummary.prune().hasData()) dealSummary = null;
			if (facilityIdentifier!=null && !facilityIdentifier.prune().hasData()) facilityIdentifier = null;
			if (facilitySummary!=null && !facilitySummary.prune().hasData()) facilitySummary = null;
			facilityNotificationChoice0 = facilityNotificationChoice0.stream().filter(b->b!=null).<FacilityNotificationChoice0.FacilityNotificationChoice0Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			facilityNotificationChoice1 = facilityNotificationChoice1.stream().filter(b->b!=null).<FacilityNotificationChoice1.FacilityNotificationChoice1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFacilityEventGroup()!=null && getFacilityEventGroup().hasData()) return true;
			if (getDealIdentifier()!=null && getDealIdentifier().hasData()) return true;
			if (getDealSummary()!=null && getDealSummary().hasData()) return true;
			if (getFacilityIdentifier()!=null && getFacilityIdentifier().hasData()) return true;
			if (getFacilitySummary()!=null && getFacilitySummary().hasData()) return true;
			if (getFacilityNotificationChoice0()!=null && getFacilityNotificationChoice0().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFacilityNotificationChoice1()!=null && getFacilityNotificationChoice1().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityNotification.FacilityNotificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FacilityNotification.FacilityNotificationBuilder o = (FacilityNotification.FacilityNotificationBuilder) other;
			
			merger.mergeRosetta(getFacilityEventGroup(), o.getFacilityEventGroup(), this::setFacilityEventGroup);
			merger.mergeRosetta(getDealIdentifier(), o.getDealIdentifier(), this::setDealIdentifier);
			merger.mergeRosetta(getDealSummary(), o.getDealSummary(), this::setDealSummary);
			merger.mergeRosetta(getFacilityIdentifier(), o.getFacilityIdentifier(), this::setFacilityIdentifier);
			merger.mergeRosetta(getFacilitySummary(), o.getFacilitySummary(), this::setFacilitySummary);
			merger.mergeRosetta(getFacilityNotificationChoice0(), o.getFacilityNotificationChoice0(), this::getOrCreateFacilityNotificationChoice0);
			merger.mergeRosetta(getFacilityNotificationChoice1(), o.getFacilityNotificationChoice1(), this::getOrCreateFacilityNotificationChoice1);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FacilityNotification _that = getType().cast(o);
		
			if (!Objects.equals(facilityEventGroup, _that.getFacilityEventGroup())) return false;
			if (!Objects.equals(dealIdentifier, _that.getDealIdentifier())) return false;
			if (!Objects.equals(dealSummary, _that.getDealSummary())) return false;
			if (!Objects.equals(facilityIdentifier, _that.getFacilityIdentifier())) return false;
			if (!Objects.equals(facilitySummary, _that.getFacilitySummary())) return false;
			if (!ListEquals.listEquals(facilityNotificationChoice0, _that.getFacilityNotificationChoice0())) return false;
			if (!ListEquals.listEquals(facilityNotificationChoice1, _that.getFacilityNotificationChoice1())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (facilityEventGroup != null ? facilityEventGroup.hashCode() : 0);
			_result = 31 * _result + (dealIdentifier != null ? dealIdentifier.hashCode() : 0);
			_result = 31 * _result + (dealSummary != null ? dealSummary.hashCode() : 0);
			_result = 31 * _result + (facilityIdentifier != null ? facilityIdentifier.hashCode() : 0);
			_result = 31 * _result + (facilitySummary != null ? facilitySummary.hashCode() : 0);
			_result = 31 * _result + (facilityNotificationChoice0 != null ? facilityNotificationChoice0.hashCode() : 0);
			_result = 31 * _result + (facilityNotificationChoice1 != null ? facilityNotificationChoice1.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FacilityNotificationBuilder {" +
				"facilityEventGroup=" + this.facilityEventGroup + ", " +
				"dealIdentifier=" + this.dealIdentifier + ", " +
				"dealSummary=" + this.dealSummary + ", " +
				"facilityIdentifier=" + this.facilityIdentifier + ", " +
				"facilitySummary=" + this.facilitySummary + ", " +
				"facilityNotificationChoice0=" + this.facilityNotificationChoice0 + ", " +
				"facilityNotificationChoice1=" + this.facilityNotificationChoice1 + ", " +
				"party=" + this.party +
			'}' + " " + super.toString();
		}
	}
}
